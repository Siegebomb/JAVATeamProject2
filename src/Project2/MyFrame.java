package Project2;

/*
 
������ ������ �����ϵ��� ������� �����Ͽ� �⸻������Ʈ[��������Ʈ ���� 2]�� ��ȹ�ϰ� �����϶�. 

<����>

������ ��������Ʈ ���� 1���� ��ư���� ó���ϴ� ���� �޴���, �޴�, �޴��������� �����Ͽ� �����ϰ�, �Ʒ��� ���ǿ� �����ϴ� �ű��׸��� �߰������ϵ�, �޴������ۿ� �̺�Ʈ�� �޾Ƽ� ó���ϴ� ���·� �����϶�. 

[��������]

1. "��������" �޴��� �����ϰ�, "���Ұ�", "������", "�ۻ��" �޴��������� �ٿ��� ������ �����Ѵ�. 

- ���Ұ��� Ŭ���� ������ MyPanel�� ������ ������ �ϳ��� ���δ�.

- �������� Ŭ���ϸ� MyPanel�� ĵ����ó�� ȭ��Ʈ�� ��Ÿ����, ���⿡ ���콺�� � ��ġ�� Ŭ���ϸ� Ŭ���� ��ҿ� 1~10�ȼ� ����ũ���� ������ �÷��� ���� ���� �׷������� �Ѵ�.

- �ۻ���� Ŭ���ϸ� MyPanel�� Text�ʵ�� TextArea�� ��Ÿ���� Text �ʵ忡 �Է��� ������ TextArea ���� ���� �߰� �ǵ��� �Ѵ�.

[�ű԰���]

2. "���Ӽ���" �޴��� �����ϰ�, �޴� ���������� Openchallenge_13�� Ȯ���Ͽ� ���� ������ ��ȹ�ϰ� �����ϵ�, "���ӽ���"�� "������ȸ" �ΰ��� �޴��������� �����Ͽ� ��϶�.

- ���ӿ����� ������ ���並 �����ϰ�, ��⸦ �Ѿư��� ���͸� ����� �䳢�� �߰��ϵ��� �ϰ�, ���Ͱ� �䳢�� �����ϴ� ������ ���� �䳢�� �װ�, �����ð����� ��� ������ ������ 1���� �������Ѽ� ȭ�鿡 ��Ÿ������ �϶�. 

- �䳢�� ���� 3�� �װų� �����ð� �̻�  ������ ���ӵǸ� ������ �������� �ϰ�, ������ ������ ���̾�αװ� ���� �̸��� �Է¹޵��� �ϰ� �̸��� ������ ��ǻ�� �������� SCORE ���Ͽ� �����ϵ��� �϶�[����ó��].

- ��������� �����߿��� ���� ���� ������ ����� ������ 10���� �����϶�[����ó��].

3. "�̵�����" �޴��� �����ϰ�, "��������" �޴��������� �ٿ��� ����� ��� ����� �����϶�. 

- "��������" Ŭ���ϸ� ���ο� â�̶߰� â�� "PLAY", "STOP", "AGAIN" ��ư�� �ٿ��� ����� ����⸦ �����϶�.   
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
//�ʿ��� ����� ����Ʈ���ݴϴ�.

public class MyFrame extends JFrame {
    
   private JMenuItem [] pj1Menu = { // ȭ�� ��ܿ� ��Ÿ�� �޴����Դϴ�.
         new JMenuItem("�� �Ұ�"),
         new JMenuItem("������"),
         new JMenuItem("�ۻ��")};
   
   private JMenuItem [] GameMenu = { // ȭ�� ��ܿ� ��Ÿ�� �޴����Դϴ�.
	         new JMenuItem("���ӽ���"),
	         new JMenuItem("������ȸ")};
   //---------------------------------------
   String Jinseob = "�̸�: ������\n"
         + "�Ҽ�: ��ǻ�Ͱ��а� 201534635\n"+"�Ұ�: ��ȭ �׸��� �� �����մϴ�.";
   String ParkSol = "�̸�: �ڼ�\n"
            + "�Ҽ�: ��ǻ�Ͱ��а� 201533753 \n"+"�Ұ�: �ڹٸ� ���� �ֽ��ϴ�.";
   String YoungChan = "�̸�: �迵��\n"
            + "�Ҽ�: ��ǻ�Ͱ��а� 201232943 \n"+"�Ұ�: ������ �����մϴ�";
   //������ �������� ������ �̸��� �� ������ ������־����ϴ�.
   private String [] profile = {Jinseob,ParkSol,YoungChan}; //�������� �� ��Ʈ�� �迭�Դϴ�.
   private Font f = new Font("Gulim", Font.BOLD, 15); // �ؽ�Ʈ������鿡 �����ų ��Ʈ�Դϴ�.t
   
   //---------------------------------------
   private ImageIcon [] image = new ImageIcon[3]; // �̹����� ���� �迭�Դϴ�.
   private JLabel imageLabel; //�̹����� ���� ���Դϴ�.
   private int picNum = 0;  // ������ �������� �����ϴµ� ���� ��ȣ�Դϴ�.
   private JTextArea [] TeamProfile = new JTextArea[3]; // �� ������ �������� �� �ؽ�Ʈ�������Դϴ�.
   
   //---------------------------------------
   
   private int red = 0, green = 0, blue = 0, size = 0; // �����ÿ��� �����ϰ� ���� �����ϱ� ���� �����Դϴ�.
   private int location_x, location_y; // ���콺�� x��ǥ�� y��ǥ�Դϴ�.
   private boolean showflag = false; // �������� ���� �������� ������ �����ϴ� �����Դϴ�.
   
   //---------------------------------------
   
   private JTextArea TA = new JTextArea("",7,20); // �ۻ���� ���� �ؽ�Ʈ �������Դϴ�. 
   private JScrollPane TS = new JScrollPane(TA); // �ۻ���� �ؽ�Ʈ����� ���� ��ũ�����Դϴ�.
   private JTextField TF = new JTextField("",20); // �Է°��� �޴� �� ���� �ؽ�Ʈ�ʵ��Դϴ�.
   private JSlider [] sl = new JSlider [3]; // 3���� �����̴� �迭 ����, ���ڻ� ����
   
   // MyFrame ������ �ۿ� �������ִ� ������ MyPanel�ʿ����� ��Ա� �����Դϴ�.
   
   
   public MyFrame() {
      
      for(int i=0; i<image.length; i++)  
            image[i] = new ImageIcon("images/image" + i + ".jpg"); 
      // �̹��� ������ ��λ󿡼� �ҷ��ͼ� �迭�� ��ü�� �����մϴ�.
      
      setTitle("Team 3's First Project"); // ������ �������ݴϴ�.
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// JFrame�� ������ ���α׷��� ���� �����մϴ�.
      createMenu();
      Container c = getContentPane(); // ����Ʈ���� �˾Ƴ��� c�� �̸��� �������ݴϴ�.
      setLayout(new BorderLayout()); // ��ư 3���� ���ʿ� ���̰�, �߾ӿ��� MyPanel�� �д�.��� ���ǿ� �־��⿡ MyFrame�� ���̾ƿ��� Border�� �����߽��ϴ�.
      
      c.add(new MyPanel(), BorderLayout.CENTER); //MyPanel�� �߾ӿ� �Ӵϴ�.
      
      setSize(500,600); // ����� �������ݴϴ�.
      setVisible(true); // MyFrame�� ���̰� ���ݴϴ�.
      

   }
   
   
   private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu teamMenu = new JMenu("��������");
		JMenu gameMenu  = new JMenu("���Ӽ���");
		JMenu mediaMenu = new JMenu("�̵�����");
		
		for(int i=0; i<pj1Menu.length; i++)  
			teamMenu.add(pj1Menu[i]); 
		
		mb.add(teamMenu);
		
		for(int i=0; i<GameMenu.length; i++)  
			gameMenu.add(GameMenu[i]); 
		
		mb.add(gameMenu);
		
		mediaMenu.add(new JMenuItem("��������"));
		
		mb.add(mediaMenu);
		
		setJMenuBar(mb);
	}
   
   

   class MyPanel extends JPanel { //��ư�� ������ ���� �ٲ�� �߾��� �г��Դϴ�.
      
      public MyPanel() {
         
         addMouseListener(new MyMouseListener()); 
         //���콺 �����ʸ� MyPanel�� �ٿ��ݴϴ�. 
         //�ۻ�� ��ư�� ���������� ���콺 �����ʸ� �ٿ����� ���� ������ 
         //��ư�� ���������� �� ���콺 �����ʰ� ���ܳ��� �޸𸮰� �����ϰ� ����Ǳ� �����Դϴ�.
         
         setBackground(Color.LIGHT_GRAY); 
         setLayout(null); // MyPanel�� ���̾ƿ��� �����ݴϴ�.
         TA.setFont(f); // �ؽ�Ʈ �������� ��Ʈ�� �������ݴϴ�.
         
         
         for(int i=0; i<TeamProfile.length; i++)  { // �� ������ ��ü�� �����մϴ�.
          
            TeamProfile[i] = new JTextArea("",2,2); //������ �������� ����� �迭�� �����մϴ�.
            TeamProfile[i].setText(profile[i]); //������ ������ ������ ������ �迭���� �����ɴϴ�.
            TeamProfile[i].setFont(f); //������ ������ ��Ʈ�� �������ݴϴ�.
            TeamProfile[i].setBackground(Color.black); //������ ������ �޹���� ���������� �������ݴϴ�.
            TeamProfile[i].setForeground(Color.green); //������ ������ ���ڻ��� �ʷϻ����� �������ݴϴ�.
            //������ �� ������ �̷� ������ ������ ������ �����Դϴ�.
            TeamProfile[i].setEditable(false); //�������� ����ڰ� �������� ���ϰ� �������ݴϴ�.
            TeamProfile[i].setVisible(true);
         }
         
         TS.setBounds(20,20,440,325); //�ۻ���� �ؽ�Ʈ������(��ũ���� ����)�� ��ġ�� ũ�⸦ �����Ѵ�.
         TF.setBounds(20,350,440,30); //�ۻ���� �ؽ�Ʈ �ʵ��� ��ġ�� ũ�⸦ �����Ѵ�.
         
         TA.setLineWrap(true); // JTextArea���� �ڵ����� �ٹٲ��� ���ִ� �޼����Դϴ�.
         TA.setEditable(false); //�ؽ�Ʈ ����� ����ڰ� �������� ���ϰ� �������ݴϴ�.

         TeamProfile[picNum].setVisible(true);//ù ȭ�鿡�� ��Ÿ�� �������� ���̰� �մϴ�.
         
         
         
         pj1Menu[0].addActionListener(new ActionListener(){ // ù��° ��ư�Դϴ�.
            public void actionPerformed(ActionEvent e) {
               showflag = false;//paintComponent�� ������ �۵����� �ʰ� �մϴ�.
               removeAll();
               repaint();
               setBackground(Color.LIGHT_GRAY); //�޹���� ��ȸ������ �ٲߴϴ�.
               add(imageLabel = new JLabel(image[picNum])); //�̹��� ���̺� ������ �ٿ��ݴϴ�.
               imageLabel.setBounds(100,0,250,250); // ������ ��ġ�� ũ�⸦ �����Ѵ�.
               add(TeamProfile[picNum]);
               TeamProfile[picNum].setBounds(20,275,440,200); //��ġ�� �̸� �������ݴϴ�.
               imageLabel.setIcon(image[picNum]); // �̹��� ���̺� �̹����� �������ݴϴ�.    
               picNum ++; // �̹��� ��ȣ ����. ���� �̹����� �Ѿ�ϴ�.
               picNum %= image.length; // 3�� �Ѿ �迭�� ������ ����� ���� ���� ���� picNum�� image.lenth�� ���� �������� �����ݴϴ�.
               
               
            }
         });
         
         pj1Menu[1].addActionListener(new ActionListener(){ // �� ��° ��ư�Դϴ�.
            public void actionPerformed(ActionEvent e) {
               showflag = true; //showflag�� true�� �ٲ��־� paintComponent�� ������ �۵��ǰ� �մϴ�.
               removeAll();
               repaint();
               setBackground(Color.WHITE); //�޹���� �Ͼ������ �ٲߴϴ�.
            }
         });
         
         pj1Menu[2].addActionListener(new ActionListener(){ // ����° ��ư�� �������� ȣ��� �������Դϴ�.
            public void actionPerformed(ActionEvent e) {
               showflag = false;//paintComponent�� ������ �۵����� �ʰ� �մϴ�.
               removeAll();
               repaint();
               setBackground(Color.LIGHT_GRAY);//�޹���� ��ȸ������ �ٲߴϴ�.
               add(TS);
               add(TF);
               addSlider();
               
            }
         });
         
         GameMenu[0].addActionListener(new ActionListener(){ // ����° ��ư�� �������� ȣ��� �������Դϴ�.
             public void actionPerformed(ActionEvent e) {
                 showflag = false;//paintComponent�� ������ �۵����� �ʰ� �մϴ�.
                 removeAll();
                 repaint();
                 new OpenChallenge_13();
                 
              }
           });
         
         TF.addActionListener(new ActionListener(){ // �ۻ������ TextField�� �Է� �� ���� �Է½� ȣ��� �������Դϴ�.
            public void actionPerformed(ActionEvent e) {
               JTextField t = (JTextField)e.getSource(); // TextField�� �Էµ� ������ �ҷ��ɴϴ�.
               TA.append(t.getText() + " "); // �ؽ�Ʈ����� �ؽ�Ʈ�ʵ��� ������ ���Դϴ�.
               t.setText(""); //�ؽ�Ʈ�ʵ��� ������ ��ĭ���� �ʱ�ȭ�մϴ�.
            }
         });
         
         
      }
      
      public void paintComponent(Graphics g) {
          super.paintComponent(g);
          if (showflag == true) { //��ư1, ��ư3 ���¿��� ���� �Ⱥ��̰� �ؾ� �ϹǷ� showflag�� true�϶��� ���� ����� �մϴ�.
                red = (int)(Math.random()*256); //R ���� 0~255 �߿� �������� �����ݴϴ�.
                blue = (int)(Math.random()*256);//G ���� 0~255 �߿� �������� �����ݴϴ�.
                green = (int)(Math.random()*256);//B ���� 0~255 �߿� �������� �����ݴϴ�.
                size = (int)(Math.random()*10+1);//ũ�⸦ 1~10 �߿� �������� �����ݴϴ�.
                //+1�� ���ִ� ������  Math.random()�� 0���� �����ϱ� �����Դϴ�.
             
                g.setColor(new Color(red,green,blue)); // ������ ������ RGB���� ������ color���� ����� g�� �������� �������ݴϴ�.
                g.fillOval(location_x, location_y, size, size); //���콺�� x,y ��ǥ�� ������ size ũ���� ���� ����ϴ�.
             
             }
          }
      
      private void addSlider() {
          // �����̴��� 3�� �����ϰ� ����� �����Ѵ�.
                for(int i=0; i<sl.length; i++) {
                   // 0~255 ������ ���� ������ �� �ִ� �����̴� ����. �ʱ갪�� 128
                   sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
                   sl[i].setPaintLabels(true);
                   sl[i].setPaintTicks(true);
                   sl[i].setPaintTrack(true);
                   sl[i].setMajorTickSpacing(50);
                   sl[i].setMinorTickSpacing(10);
                   // �����̴��� ����� �����ϴ� �ڵ���Դϴ�.
                   
                   // �����̴��� Change ������ ���
                   sl[i].addChangeListener(new MyChangeListener());
                   sl[i].setLocation(20+ 150*i,400);
                   sl[i].setSize(150,50);
                   add(sl[i]); // �����̴��� ����Ʈ�ҿ� �����մϴ�.
                   sl[i].setVisible(true); //�����̴��� �Ⱥ��̰� �մϴ�.
              
             
                }
                
                sl[0].setForeground(Color.RED); // s[0] �����̴��� RED �� ����
                sl[1].setForeground(Color.GREEN); // s[1] �����̴��� GREEN �� ����
                sl[2].setForeground(Color.BLUE); // s[0] �����̴��� BLUE �� ����
                
             }
          
       }
      
      class MyMouseListener extends MouseAdapter { // ���콺 ����͸� ��ӹ޴� MyMouseListener�� ����ϴ�.
         public void mousePressed(MouseEvent e) {
        	 if (showflag == true) { //��ư1, ��ư3 ���¿��� ���� ��ġ�� ������ �ʾƾ� �ϹǷ� ���⵵ showflag�� true�϶��� �۵��ǰ� �մϴ�.
        	     repaint();// ���콺�� Ŭ���Ǿ������� �ٽ� �׷��ݴϴ�.
        		 location_x = e.getX(); // ���콺�� ���� x��ǥ�� �˾Ƴ��ϴ�.
        		 location_y = e.getY(); // ���콺�� ���� y��ǥ�� �˾Ƴ��ϴ�.
        		 System.out.printf("���� ��ġ >> %d, %d \n",location_x,location_y);
        		 //���� ��ġ�� �ý��� �󿡼� �� �� �ְ� ����Ʈ�� ������ݴϴ�.
        	 }
         }
      }
      
      class MyChangeListener implements ChangeListener { // ü���������ʸ� ��ӹ޴� MyChangeListener�� ����ϴ�.
          public void stateChanged(ChangeEvent e) { // �����̴��� ���� ������ �� ȣ��
             // 3���� �����̴��κ��� ���� ��� colorLabel�� ���� ����
        	  
             int r = sl[0].getValue(); // R ���� �� ���
             int g = sl[1].getValue(); // G ���� �� ���
             int b = sl[2].getValue(); // B ���� �� ���
             TA.setForeground(new Color(r,g,b)); // r,g,b ������ ���ο� �� ����
          }
       }
         
      
      
   public static void main(String[] args) { //���� �ڵ��Դϴ�.
      new MyFrame(); //MyFrame�� ���� ������ݴϴ�.
   }
}

