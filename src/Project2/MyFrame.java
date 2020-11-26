package Project2;

/*
 
다음의 조건을 만족하도록 팀원들과 협력하여 기말프로젝트[팀프로젝트 과제 2]를 기획하고 구현하라. 

<조건>

기존의 팀프로젝트 과제 1에서 버튼으로 처리하던 것을 메뉴바, 메뉴, 메뉴아이템을 생성하여 수용하고, 아래의 조건에 부합하는 신규항목을 추가구현하되, 메뉴아이템에 이벤트를 달아서 처리하는 형태로 구현하라. 

[기존과제]

1. "기존과제" 메뉴를 생성하고, "팀소개", "페인팅", "글사랑" 메뉴아이템을 붙여서 다음을 구현한다. 

- 팀소개를 클릭할 때마다 MyPanel에 팀원의 사진을 하나씩 보인다.

- 페인팅을 클릭하면 MyPanel이 캔버스처럼 화이트로 나타나며, 여기에 마우스로 어떤 위치를 클릭하면 클릭된 장소에 1~10픽섹 범위크기의 렌덤한 컬러를 가진 원이 그려지도록 한다.

- 글사랑을 클릭하면 MyPanel에 Text필드와 TextArea가 나타나며 Text 필드에 입력한 문장이 TextArea 문장 끝에 추가 되도록 한다.

[신규과제]

2. "게임수행" 메뉴을 생성하고, 메뉴 아이템으로 Openchallenge_13을 확장하여 몬스터 게임을 기획하고 구현하되, "게임시작"과 "점수조회" 두개의 메뉴이이템을 구성하여 운영하라.

- 게임에서는 스레드 개념를 적용하고, 토기를 쫓아가는 몬스터를 만들어 토끼를 추격하도록 하고, 몬스터가 토끼와 교차하는 영역에 가면 토끼가 죽고, 일정시간동안 살아 있으면 점수를 1점씩 증가시켜서 화면에 나타나도록 하라. 

- 토끼가 연속 3번 죽거나 일정시간 이상  게임이 지속되면 게임을 끝나도록 하고, 게임이 끝날때 다이얼로그가 떠서 이름을 입력받도록 하고 이름과 점수를 컴퓨터 폴더상의 SCORE 파일에 저장하도로 하라[파일처리].

- 현재까지의 점수중에서 가장 높은 점수를 기록한 순서로 10명을 나열하라[파일처리].

3. "미디어재생" 메뉴를 생성하고, "오디오재생" 메뉴아이템을 붙여서 오디오 재생 기능을 구현하라. 

- "오디오재생" 클릭하면 새로운 창이뜨고 창에 "PLAY", "STOP", "AGAIN" 버튼을 붙여서 오디오 재생기를 구현하라.   
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//필요한 모듈을 임포트해줍니다.

public class MyFrame extends JFrame {
    
   private JMenuItem [] pj1Menu = { // 화면 상단에 나타날 메뉴들입니다.
         new JMenuItem("팀 소개"),
         new JMenuItem("페인팅"),
         new JMenuItem("글사랑")};
   
   private JMenuItem [] GameMenu = { // 화면 상단에 나타날 메뉴들입니다.
	         new JMenuItem("게임실행"),
	         new JMenuItem("점수조회")};
   //---------------------------------------
   String Jinseob = "이름: 우진섭\n"
         + "소속: 컴퓨터공학과 201534635\n"+"소개: 만화 그리는 거 좋아합니다.";
   String ParkSol = "이름: 박솔\n"
            + "소속: 컴퓨터공학과 201533753 \n"+"소개: 자바를 배우고 있습니다.";
   String YoungChan = "이름: 김영찬\n"
            + "소속: 컴퓨터공학과 201232943 \n"+"소개: 여행을 좋아합니다";
   //각자의 프로필을 각자의 이름을 딴 변수로 만들어주었습니다.
   private String [] profile = {Jinseob,ParkSol,YoungChan}; //프로필이 들어갈 스트링 배열입니다.
   private Font f = new Font("Gulim", Font.BOLD, 15); // 텍스트에리어들에 적용시킬 폰트입니다.t
   
   //---------------------------------------
   private ImageIcon [] image = new ImageIcon[3]; // 이미지를 넣을 배열입니다.
   private JLabel imageLabel; //이미지를 붙일 라벨입니다.
   private int picNum = 0;  // 사진과 프로필을 변경하는데 쓰일 번호입니다.
   private JTextArea [] TeamProfile = new JTextArea[3]; // 각 팀원의 프로필이 들어갈 텍스트에리어입니다.
   
   //---------------------------------------
   
   private int red = 0, green = 0, blue = 0, size = 0; // 페인팅에서 랜덤하게 색을 변경하기 위한 변수입니다.
   private int location_x, location_y; // 마우스의 x좌표와 y좌표입니다.
   private boolean showflag = false; // 페인팅한 것을 보여줄지 말지를 결정하는 변수입니다.
   
   //---------------------------------------
   
   private JTextArea TA = new JTextArea("",7,20); // 글사랑에 쓰일 텍스트 에리어입니다. 
   private JScrollPane TS = new JScrollPane(TA); // 글사랑의 텍스트에리어에 붙을 스크롤팬입니다.
   private JTextField TF = new JTextField("",20); // 입력값을 받는 데 쓰일 텍스트필드입니다.
   private JSlider [] sl = new JSlider [3]; // 3개의 슬라이더 배열 생성, 글자색 변경
   
   // MyFrame 생성자 밖에 선언해주는 이유는 MyPanel쪽에서도 써먹기 위함입니다.
   
   
   public MyFrame() {
      
      for(int i=0; i<image.length; i++)  
            image[i] = new ImageIcon("images/image" + i + ".jpg"); 
      // 이미지 파일을 경로상에서 불러와서 배열에 객체로 저장합니다.
      
      setTitle("Team 3's First Project"); // 제목을 지정해줍니다.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame이 닫힐때 프로그램도 같이 종료합니다.
      createMenu();
      Container c = getContentPane(); // 컨텐트팬을 알아내어 c로 이름을 지정해줍니다.
      setLayout(new BorderLayout()); // 버튼 3개를 북쪽에 붙이고, 중앙에는 MyPanel을 둔다.라고 조건에 있었기에 MyFrame의 레이아웃은 Border로 설정했습니다.
      
      c.add(new MyPanel(), BorderLayout.CENTER); //MyPanel을 중앙에 둡니다.
      
      setSize(500,600); // 사이즈를 지정해줍니다.
      setVisible(true); // MyFrame을 보이게 해줍니다.
      

   }
   
   
   private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu teamMenu = new JMenu("기존과제");
		JMenu gameMenu  = new JMenu("게임수행");
		JMenu mediaMenu = new JMenu("미디어재생");
		
		for(int i=0; i<pj1Menu.length; i++)  
			teamMenu.add(pj1Menu[i]); 
		
		mb.add(teamMenu);
		
		for(int i=0; i<GameMenu.length; i++)  
			gameMenu.add(GameMenu[i]); 
		
		mb.add(gameMenu);
		
		mediaMenu.add(new JMenuItem("오디오재생"));
		
		mb.add(mediaMenu);
		
		setJMenuBar(mb);
	}
   
   

   class MyPanel extends JPanel { //버튼이 눌림에 따라 바뀌는 중앙의 패널입니다.
      
      public MyPanel() {
         
         addMouseListener(new MyMouseListener()); 
         //마우스 리스너를 MyPanel에 붙여줍니다. 
         //글사랑 버튼을 눌렀을때에 마우스 리스너를 붙여주지 않은 이유는 
         //버튼을 누를때마다 새 마우스 리스너가 생겨나서 메모리가 과도하게 낭비되기 때문입니다.
         
         setBackground(Color.LIGHT_GRAY); 
         setLayout(null); // MyPanel의 레이아웃을 없애줍니다.
         TA.setFont(f); // 텍스트 에리어의 폰트를 지정해줍니다.
         
         
         for(int i=0; i<TeamProfile.length; i++)  { // 팀 프로필 객체를 생성합니다.
          
            TeamProfile[i] = new JTextArea("",2,2); //팀원의 프로필을 만들어 배열에 저장합니다.
            TeamProfile[i].setText(profile[i]); //팀원의 프로필 내용을 프로필 배열에서 가져옵니다.
            TeamProfile[i].setFont(f); //프로필 내용의 폰트를 지정해줍니다.
            TeamProfile[i].setBackground(Color.black); //프로필 내용의 뒷배경을 검은색으로 지정해줍니다.
            TeamProfile[i].setForeground(Color.green); //프로필 내용의 글자색을 초록색으로 지정해줍니다.
            //프로필 색 조합이 이런 이유는 순전히 조장의 취향입니다.
            TeamProfile[i].setEditable(false); //프로필을 사용자가 수정하지 못하게 지정해줍니다.
            TeamProfile[i].setVisible(true);
         }
         
         TS.setBounds(20,20,440,325); //글사랑의 텍스트에리어(스크롤팬 붙임)의 위치와 크기를 지정한다.
         TF.setBounds(20,350,440,30); //글사랑의 텍스트 필드의 위치와 크기를 지정한다.
         
         TA.setLineWrap(true); // JTextArea에서 자동으로 줄바꿈을 해주는 메서드입니다.
         TA.setEditable(false); //텍스트 에리어를 사용자가 수정하지 못하게 지정해줍니다.

         TeamProfile[picNum].setVisible(true);//첫 화면에서 나타날 프로필을 보이게 합니다.
         
         
         
         pj1Menu[0].addActionListener(new ActionListener(){ // 첫번째 버튼입니다.
            public void actionPerformed(ActionEvent e) {
               showflag = false;//paintComponent의 내용이 작동되지 않게 합니다.
               removeAll();
               repaint();
               setBackground(Color.LIGHT_GRAY); //뒷배경을 연회색으로 바꿉니다.
               add(imageLabel = new JLabel(image[picNum])); //이미지 레이블에 사진을 붙여줍니다.
               imageLabel.setBounds(100,0,250,250); // 사진의 위치와 크기를 지정한다.
               add(TeamProfile[picNum]);
               TeamProfile[picNum].setBounds(20,275,440,200); //위치를 미리 지정해줍니다.
               imageLabel.setIcon(image[picNum]); // 이미지 레이블에 이미지를 변경해줍니다.    
               picNum ++; // 이미지 번호 증가. 다음 이미지로 넘어갑니다.
               picNum %= image.length; // 3이 넘어서 배열의 범위를 벗어나는 것을 막기 위해 picNum을 image.lenth로 나눈 나머지로 정해줍니다.
               
               
            }
         });
         
         pj1Menu[1].addActionListener(new ActionListener(){ // 두 번째 버튼입니다.
            public void actionPerformed(ActionEvent e) {
               showflag = true; //showflag를 true로 바꿔주어 paintComponent의 내용이 작동되게 합니다.
               removeAll();
               repaint();
               setBackground(Color.WHITE); //뒷배경을 하얀색으로 바꿉니다.
            }
         });
         
         pj1Menu[2].addActionListener(new ActionListener(){ // 세번째 버튼이 눌렸을때 호출될 리스너입니다.
            public void actionPerformed(ActionEvent e) {
               showflag = false;//paintComponent의 내용이 작동되지 않게 합니다.
               removeAll();
               repaint();
               setBackground(Color.LIGHT_GRAY);//뒷배경을 연회색으로 바꿉니다.
               add(TS);
               add(TF);
               addSlider();
               
            }
         });
         
         GameMenu[0].addActionListener(new ActionListener(){ // 세번째 버튼이 눌렸을때 호출될 리스너입니다.
             public void actionPerformed(ActionEvent e) {
                 showflag = false;//paintComponent의 내용이 작동되지 않게 합니다.
                 removeAll();
                 repaint();
                 new OpenChallenge_13();
                 
              }
           });
         
         TF.addActionListener(new ActionListener(){ // 글사랑에서 TextField에 입력 후 엔터 입력시 호출될 리스너입니다.
            public void actionPerformed(ActionEvent e) {
               JTextField t = (JTextField)e.getSource(); // TextField에 입력된 내용을 불러옵니다.
               TA.append(t.getText() + " "); // 텍스트에리어에 텍스트필드의 내용을 붙입니다.
               t.setText(""); //텍스트필드의 내용을 빈칸으로 초기화합니다.
            }
         });
         
         
      }
      
      public void paintComponent(Graphics g) {
          super.paintComponent(g);
          if (showflag == true) { //버튼1, 버튼3 상태에선 원이 안보이게 해야 하므로 showflag가 true일때만 원이 생기게 합니다.
                red = (int)(Math.random()*256); //R 값을 0~255 중에 랜덤으로 정해줍니다.
                blue = (int)(Math.random()*256);//G 값을 0~255 중에 랜덤으로 정해줍니다.
                green = (int)(Math.random()*256);//B 값을 0~255 중에 랜덤으로 정해줍니다.
                size = (int)(Math.random()*10+1);//크기를 1~10 중에 랜덤으로 정해줍니다.
                //+1을 해주는 이유는  Math.random()이 0부터 시작하기 때문입니다.
             
                g.setColor(new Color(red,green,blue)); // 위에서 생성된 RGB값을 가지는 color값을 만들어 g의 색상으로 지정해줍니다.
                g.fillOval(location_x, location_y, size, size); //마우스의 x,y 좌표를 가지는 size 크기의 원을 만듭니다.
             
             }
          }
      
      private void addSlider() {
          // 슬라이더를 3개 생성하고 모양을 제어한다.
                for(int i=0; i<sl.length; i++) {
                   // 0~255 사이의 값을 선택할 수 있는 슬라이더 생성. 초깃값은 128
                   sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
                   sl[i].setPaintLabels(true);
                   sl[i].setPaintTicks(true);
                   sl[i].setPaintTrack(true);
                   sl[i].setMajorTickSpacing(50);
                   sl[i].setMinorTickSpacing(10);
                   // 슬라이더의 모양을 제어하는 코드들입니다.
                   
                   // 슬라이더에 Change 리스너 등록
                   sl[i].addChangeListener(new MyChangeListener());
                   sl[i].setLocation(20+ 150*i,400);
                   sl[i].setSize(150,50);
                   add(sl[i]); // 슬라이더를 컨텐트팬에 삽입합니다.
                   sl[i].setVisible(true); //슬라이더를 안보이게 합니다.
              
             
                }
                
                sl[0].setForeground(Color.RED); // s[0] 슬라이더는 RED 값 선택
                sl[1].setForeground(Color.GREEN); // s[1] 슬라이더는 GREEN 값 선택
                sl[2].setForeground(Color.BLUE); // s[0] 슬라이더는 BLUE 값 선택
                
             }
          
       }
      
      class MyMouseListener extends MouseAdapter { // 마우스 어댑터를 상속받는 MyMouseListener를 만듭니다.
         public void mousePressed(MouseEvent e) {
        	 if (showflag == true) { //버튼1, 버튼3 상태에선 원의 위치가 변하지 않아야 하므로 여기도 showflag가 true일때만 작동되게 합니다.
        	     repaint();// 마우스가 클릭되었을때에 다시 그려줍니다.
        		 location_x = e.getX(); // 마우스의 현재 x좌표를 알아냅니다.
        		 location_y = e.getY(); // 마우스의 현재 y좌표를 알아냅니다.
        		 System.out.printf("현재 위치 >> %d, %d \n",location_x,location_y);
        		 //현재 위치를 시스템 상에서 알 수 있게 프린트로 출력해줍니다.
        	 }
         }
      }
      
      class MyChangeListener implements ChangeListener { // 체인지리스너를 상속받는 MyChangeListener를 만듭니다.
          public void stateChanged(ChangeEvent e) { // 슬라이더의 값이 변경할 때 호출
             // 3개의 슬라이더로부터 값을 얻어 colorLabel의 배경색 변경
        	  
             int r = sl[0].getValue(); // R 성분 값 얻기
             int g = sl[1].getValue(); // G 성분 값 얻기
             int b = sl[2].getValue(); // B 성분 값 얻기
             TA.setForeground(new Color(r,g,b)); // r,g,b 값으로 새로운 색 설정
          }
       }
         
      
      
   public static void main(String[] args) { //메인 코드입니다.
      new MyFrame(); //MyFrame을 새로 만들어줍니다.
   }
}

