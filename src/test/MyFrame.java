package test;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.Random;


//JFrame을 상속 받은 MyFrame Class
public class MyFrame extends JFrame{
   private JLabel imageLabel; // 이미지 레이블
   private ImageIcon [] images = new ImageIcon [3]; // 이미지 객체 배열
   int currentId; // 현재 선택된 이미지 번호(0~2).
   
   private JButton team = new JButton("팀소개"); //team 팀소개 버튼 생성
   private JButton paint = new JButton("페인팅"); //paint 페인팅 버튼 생성
   private JButton love = new JButton("글사랑"); //love 글사랑 버튼 생성
   
   private boolean showflag = false; // 페인팅한 것을 보여줄지 말지를 결정하는 변수
   
   private JTextField tf =new JTextField(20); //입력창의 크기가 20인 텍스트 필드 tf를 생성한다.
   private JTextArea ta = new JTextArea(7,20); //크기가 7 * 20인 텍스트 영역을 생성한다.
   
   MyPanel panel = new MyPanel(); //MyPanel 클래스를 가지는 객체 panel을 생성한다.
   
   //MyFrame 생성자 시작
   public MyFrame() {
      setTitle("팀과제 1번째"); // 프레임 타이틀 "팀과제 1번째"
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 윈도우를 닫으면 프로그램이 종료되도록 설정
      
      Container c = getContentPane(); // 컨탠트 팬을 알아낸다.
      c.setLayout(new BorderLayout(30, 20)); //컨텐트 팬에 Border 배치관리자를 단다.
      
      JPanel p1 = new JPanel(); // p1 패널을 생성한다.
      p1.add(team); //p1패널에 team 버튼을 부착한다.
      p1.add(paint); //p1패널에 paint 버튼을 부착한다.
      p1.add(love); //p1패널에 love 버튼을 부착한다.
      p1.setSize(20,10); //p1 패널의 크기는 20 * 10으로 한다.
      c.add(p1,BorderLayout.NORTH); // 컨탠트 팬 c의 북쪽에 p1패널을 부착한다.
     
      c.add(panel, BorderLayout.CENTER); //컨텐트 팬 c의 중앙에 MyPanel을 부착
      
      for(int i=0; i<images.length; i++) //이미지 객체 배열에 배열의 크기 만큼 반복해서 이미지 저장하기
         images[i] = new ImageIcon("images/image"+i+".jpg"); //images 폴더의 images를 가져와서 저장하기

      currentId = 0; // 현재 선택된 이미지 번호

      panel.setVisible(true); //패널을 보이게 한다.
      setSize(700, 700); //프레임 크기를 700*700으로 설정한다.
      setVisible(true); // 프레임이 출력되도록 지시한다.
   }//MyFrame 생성자 종료

   
      // JPanel을 상속받는 MyPanel을 구현한다.
    class MyPanel extends JPanel{
        Container c = getContentPane(); // 컨탠트 팬을 알아낸다.
        int x; //변수 x를 선언
        int y; //변수 y를 선언
        
        //MyPanel 생성자 시작
        public MyPanel() {   
           setBackground(Color.LIGHT_GRAY); //배경색을 LIGHT GRAY로 한다.
           setLayout(null); //배치관리자가 없다.
           
           add(imageLabel = new JLabel(images[currentId])); //현재 이미지 배열 속 이미지 객체를 생성하고, JLabel로 이미지 레이블을 추가한다
           imageLabel.setBounds(50,50,500,500); //이미지 레이블의 좌표는 (50,50)이며 크기는 500*500으로 한다
         
           
           // 팀소개 버튼에 Action 리스너 달기
           // 익명 클래스를 이용한다.
           team.addActionListener(new ActionListener() {
              @Override //오버라이딩한다
              public void actionPerformed(ActionEvent e) { 
                 showflag = false; //페인팅 한것을 보여주지 않도록 한다.
                 tf.setVisible(false); //텍스트 필드를 보여주지 않도록 한다.
                 ta.setVisible(false); //텍스트 에리어를 보여주지 않도록 한다.
                 
                 panel.setVisible(true); //패널을 다시 보이게 한다.
                 setBackground(Color.LIGHT_GRAY); //배경색을 LIGHT GRAY로 한다. 
                 imageLabel.setVisible(true);//이미지 라벨을 보이게 한다.
                 currentId ++; // 이미지 번호 증가. 다음 이미지로 넘어가게 한다.
                 currentId %= images.length; // 3 가 넘는 것을 막기 위해 이미지 개수로 나머지 구함 
                 imageLabel.setIcon(images[currentId]); // 이미지 레이블에 이미지 변경 
               }
            });
               
           
           // 페인팅 버튼에 Action 리스너 달기
           // 익명 클래스를 이용한다.
           paint.addActionListener(new ActionListener() {
              @Override //오버라이딩한다
              public void actionPerformed(ActionEvent e) {
                 showflag = true; //페인팅 한것을 보여준다.
                 tf.setVisible(false); //텍스트 필드를 보여주지 않도록 한다.
                 ta.setVisible(false); //텍스트 에리어를 보여주지 않도록 한다.
                 panel.setVisible(true); //패널을 다시 보이게 한다.
                 imageLabel.setVisible(false); //이미지 라벨을 보이지 않게 한다.
                 
                 setBackground(Color.WHITE); // 배경을 하얗게 만들어 버튼을 누르면 새하얀 캔버스가 나타나는 것처럼 만든다.
                 panel.addMouseListener(new MymouseAdapter()); //패널에 마우스 리스너를 단다.
              }
           });
           
           
           // 글사랑 버튼에 Action 리스너 달기
           // 익명 클래스를 이용한다.
           love.addActionListener(new ActionListener() {
              @Override //오버라이딩한다
              public void actionPerformed(ActionEvent e) {
                 showflag = false; //페인팅 한것을 보여주지 않도록 한다.
                 tf.setVisible(true); //텍스트 필드를 보여주도록 한다.
                 ta.setVisible(true); //텍스트 에리어를 보여주도록 한다.
                 
                     c.setLayout(null); // 컨텐트 팬c의 배치관리자를 제거한다.
                     panel.setVisible(false); //패널을 보이지 않게 한다.
                     JLabel la =new JLabel("입력 후 엔터키를 누르세요"); // JLabel로 문자열 레이블 la을 만든다.
                     la.setSize(500,50); //문자열 레이블 la의 크기를 500 * 50으로 한다.
                     la.setLocation(250,50); //문자열 레이블 la의 위치를 (250,50)으로 한다.
                     c.add(la); //컨텐트 팬에 문자열 레이블 la를 추가한다.
                     
                     tf.setSize(500,50); //텍스트 필드의 사이즈는 (500,50)으로 한다
                     tf.setLocation(80,100); //텍스트 필드의 위치는 (80, 100)으로 한다
                     ta.setSize(500,300); //텍스트 에리어의 사이즈는 (500,300)으로 한다
                     ta.setLocation(80,180); //텍스트 에리어의 위치는 (80, 180)으로 한다
                     c.add(tf); //컨텐트팬 c에 텍스트필드를 부착한다.
                     
                     //텍스트 필드에 <Enter> 키 입력시 발생하는 Action 이벤트의 리스너 등록
                     tf.addActionListener(new ActionListener (){
                        public void actionPerformed(ActionEvent e) {
                           JTextField t=(JTextField)e.getSource();
                           ta.append(t.getText()); //텍스트 필드의 문자열을 텍스트영역 창에 추가
                           t.setText(""); //현재 텍스트 필드에 입력된 내용 지우기
                        }
                     });
                     
                     c.add(ta); //컨텐트 팬 c에 텍스트 에리어를 부착한다.
                     
              }} );

         
      }//MyPanel 생성자 닫기
      
        
        //MouseAdapter를 상속받아서 MymouseAdapter을 구현
        class MymouseAdapter extends MouseAdapter{ 
           public void mouseClicked(MouseEvent e) { //마우스 클릭시 클릭된 위치를 알아낸다.
              repaint(); // 강제로 페인팅 할 것을 지시하는 메소드
              x=(int)e.getX(); //클릭된 위치의 x 좌표
              y=(int)e.getY(); //클릭된 위치의 y 좌표
           }
        } 
           
        //랜덤한 색상과 랜덤한 크기의 원을 그리게 해준다.
        public void  paintComponent(Graphics g) { //오버라이딩 한다.
           super.paintComponent(g); //Jpanel의 paintComponent() 호출
           
           if (showflag == true) { //페인팅 하는 것을 보여주는 변수의 상태가 true라면 실행한다.
            
              int red = (int)(Math.random()*256); //red를 선언하면서 랜덤한 수를 받아 값을 초기화해준다.
            int green = (int)(Math.random()*256); //green를 선언하면서 랜덤한 수를 받아 값을 초기화해준다.
            int blue = (int)(Math.random() * 256); //blue를 선언하면서 랜덤한 수를 받아 값을 초기화해준다.
            g.setColor(new Color(red,green,blue)); //객체 g의 색을 랜덤하게 받은 red, green, blue를 통해  설정한다.
               
            int size =(int)(Math.random()*10) + 1; //사이즈를 선언하면 동시에 1부터 10 사이의 랜덤한 수를 받아 초기화해준다.
                 
            g.drawOval(x, y, size, size); //좌표(x,y)의 위치에서 size * size 크기의 사각형에 내접하는 타원을 그린다.
            }
        }

   }//MyPanel 클래스 닫기

   public static void main(String[] args) { //main 함수
      new MyFrame(); 
   }
   
} //MyFrame 클래스 닫기