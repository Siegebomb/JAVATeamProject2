package test;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.*;
import java.util.Random;


//JFrame�� ��� ���� MyFrame Class
public class MyFrame extends JFrame{
   private JLabel imageLabel; // �̹��� ���̺�
   private ImageIcon [] images = new ImageIcon [3]; // �̹��� ��ü �迭
   int currentId; // ���� ���õ� �̹��� ��ȣ(0~2).
   
   private JButton team = new JButton("���Ұ�"); //team ���Ұ� ��ư ����
   private JButton paint = new JButton("������"); //paint ������ ��ư ����
   private JButton love = new JButton("�ۻ��"); //love �ۻ�� ��ư ����
   
   private boolean showflag = false; // �������� ���� �������� ������ �����ϴ� ����
   
   private JTextField tf =new JTextField(20); //�Է�â�� ũ�Ⱑ 20�� �ؽ�Ʈ �ʵ� tf�� �����Ѵ�.
   private JTextArea ta = new JTextArea(7,20); //ũ�Ⱑ 7 * 20�� �ؽ�Ʈ ������ �����Ѵ�.
   
   MyPanel panel = new MyPanel(); //MyPanel Ŭ������ ������ ��ü panel�� �����Ѵ�.
   
   //MyFrame ������ ����
   public MyFrame() {
      setTitle("������ 1��°"); // ������ Ÿ��Ʋ "������ 1��°"
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ������ �����츦 ������ ���α׷��� ����ǵ��� ����
      
      Container c = getContentPane(); // ����Ʈ ���� �˾Ƴ���.
      c.setLayout(new BorderLayout(30, 20)); //����Ʈ �ҿ� Border ��ġ�����ڸ� �ܴ�.
      
      JPanel p1 = new JPanel(); // p1 �г��� �����Ѵ�.
      p1.add(team); //p1�гο� team ��ư�� �����Ѵ�.
      p1.add(paint); //p1�гο� paint ��ư�� �����Ѵ�.
      p1.add(love); //p1�гο� love ��ư�� �����Ѵ�.
      p1.setSize(20,10); //p1 �г��� ũ��� 20 * 10���� �Ѵ�.
      c.add(p1,BorderLayout.NORTH); // ����Ʈ �� c�� ���ʿ� p1�г��� �����Ѵ�.
     
      c.add(panel, BorderLayout.CENTER); //����Ʈ �� c�� �߾ӿ� MyPanel�� ����
      
      for(int i=0; i<images.length; i++) //�̹��� ��ü �迭�� �迭�� ũ�� ��ŭ �ݺ��ؼ� �̹��� �����ϱ�
         images[i] = new ImageIcon("images/image"+i+".jpg"); //images ������ images�� �����ͼ� �����ϱ�

      currentId = 0; // ���� ���õ� �̹��� ��ȣ

      panel.setVisible(true); //�г��� ���̰� �Ѵ�.
      setSize(700, 700); //������ ũ�⸦ 700*700���� �����Ѵ�.
      setVisible(true); // �������� ��µǵ��� �����Ѵ�.
   }//MyFrame ������ ����

   
      // JPanel�� ��ӹ޴� MyPanel�� �����Ѵ�.
    class MyPanel extends JPanel{
        Container c = getContentPane(); // ����Ʈ ���� �˾Ƴ���.
        int x; //���� x�� ����
        int y; //���� y�� ����
        
        //MyPanel ������ ����
        public MyPanel() {   
           setBackground(Color.LIGHT_GRAY); //������ LIGHT GRAY�� �Ѵ�.
           setLayout(null); //��ġ�����ڰ� ����.
           
           add(imageLabel = new JLabel(images[currentId])); //���� �̹��� �迭 �� �̹��� ��ü�� �����ϰ�, JLabel�� �̹��� ���̺��� �߰��Ѵ�
           imageLabel.setBounds(50,50,500,500); //�̹��� ���̺��� ��ǥ�� (50,50)�̸� ũ��� 500*500���� �Ѵ�
         
           
           // ���Ұ� ��ư�� Action ������ �ޱ�
           // �͸� Ŭ������ �̿��Ѵ�.
           team.addActionListener(new ActionListener() {
              @Override //�������̵��Ѵ�
              public void actionPerformed(ActionEvent e) { 
                 showflag = false; //������ �Ѱ��� �������� �ʵ��� �Ѵ�.
                 tf.setVisible(false); //�ؽ�Ʈ �ʵ带 �������� �ʵ��� �Ѵ�.
                 ta.setVisible(false); //�ؽ�Ʈ ����� �������� �ʵ��� �Ѵ�.
                 
                 panel.setVisible(true); //�г��� �ٽ� ���̰� �Ѵ�.
                 setBackground(Color.LIGHT_GRAY); //������ LIGHT GRAY�� �Ѵ�. 
                 imageLabel.setVisible(true);//�̹��� ���� ���̰� �Ѵ�.
                 currentId ++; // �̹��� ��ȣ ����. ���� �̹����� �Ѿ�� �Ѵ�.
                 currentId %= images.length; // 3 �� �Ѵ� ���� ���� ���� �̹��� ������ ������ ���� 
                 imageLabel.setIcon(images[currentId]); // �̹��� ���̺� �̹��� ���� 
               }
            });
               
           
           // ������ ��ư�� Action ������ �ޱ�
           // �͸� Ŭ������ �̿��Ѵ�.
           paint.addActionListener(new ActionListener() {
              @Override //�������̵��Ѵ�
              public void actionPerformed(ActionEvent e) {
                 showflag = true; //������ �Ѱ��� �����ش�.
                 tf.setVisible(false); //�ؽ�Ʈ �ʵ带 �������� �ʵ��� �Ѵ�.
                 ta.setVisible(false); //�ؽ�Ʈ ����� �������� �ʵ��� �Ѵ�.
                 panel.setVisible(true); //�г��� �ٽ� ���̰� �Ѵ�.
                 imageLabel.setVisible(false); //�̹��� ���� ������ �ʰ� �Ѵ�.
                 
                 setBackground(Color.WHITE); // ����� �Ͼ�� ����� ��ư�� ������ ���Ͼ� ĵ������ ��Ÿ���� ��ó�� �����.
                 panel.addMouseListener(new MymouseAdapter()); //�гο� ���콺 �����ʸ� �ܴ�.
              }
           });
           
           
           // �ۻ�� ��ư�� Action ������ �ޱ�
           // �͸� Ŭ������ �̿��Ѵ�.
           love.addActionListener(new ActionListener() {
              @Override //�������̵��Ѵ�
              public void actionPerformed(ActionEvent e) {
                 showflag = false; //������ �Ѱ��� �������� �ʵ��� �Ѵ�.
                 tf.setVisible(true); //�ؽ�Ʈ �ʵ带 �����ֵ��� �Ѵ�.
                 ta.setVisible(true); //�ؽ�Ʈ ����� �����ֵ��� �Ѵ�.
                 
                     c.setLayout(null); // ����Ʈ ��c�� ��ġ�����ڸ� �����Ѵ�.
                     panel.setVisible(false); //�г��� ������ �ʰ� �Ѵ�.
                     JLabel la =new JLabel("�Է� �� ����Ű�� ��������"); // JLabel�� ���ڿ� ���̺� la�� �����.
                     la.setSize(500,50); //���ڿ� ���̺� la�� ũ�⸦ 500 * 50���� �Ѵ�.
                     la.setLocation(250,50); //���ڿ� ���̺� la�� ��ġ�� (250,50)���� �Ѵ�.
                     c.add(la); //����Ʈ �ҿ� ���ڿ� ���̺� la�� �߰��Ѵ�.
                     
                     tf.setSize(500,50); //�ؽ�Ʈ �ʵ��� ������� (500,50)���� �Ѵ�
                     tf.setLocation(80,100); //�ؽ�Ʈ �ʵ��� ��ġ�� (80, 100)���� �Ѵ�
                     ta.setSize(500,300); //�ؽ�Ʈ �������� ������� (500,300)���� �Ѵ�
                     ta.setLocation(80,180); //�ؽ�Ʈ �������� ��ġ�� (80, 180)���� �Ѵ�
                     c.add(tf); //����Ʈ�� c�� �ؽ�Ʈ�ʵ带 �����Ѵ�.
                     
                     //�ؽ�Ʈ �ʵ忡 <Enter> Ű �Է½� �߻��ϴ� Action �̺�Ʈ�� ������ ���
                     tf.addActionListener(new ActionListener (){
                        public void actionPerformed(ActionEvent e) {
                           JTextField t=(JTextField)e.getSource();
                           ta.append(t.getText()); //�ؽ�Ʈ �ʵ��� ���ڿ��� �ؽ�Ʈ���� â�� �߰�
                           t.setText(""); //���� �ؽ�Ʈ �ʵ忡 �Էµ� ���� �����
                        }
                     });
                     
                     c.add(ta); //����Ʈ �� c�� �ؽ�Ʈ ����� �����Ѵ�.
                     
              }} );

         
      }//MyPanel ������ �ݱ�
      
        
        //MouseAdapter�� ��ӹ޾Ƽ� MymouseAdapter�� ����
        class MymouseAdapter extends MouseAdapter{ 
           public void mouseClicked(MouseEvent e) { //���콺 Ŭ���� Ŭ���� ��ġ�� �˾Ƴ���.
              repaint(); // ������ ������ �� ���� �����ϴ� �޼ҵ�
              x=(int)e.getX(); //Ŭ���� ��ġ�� x ��ǥ
              y=(int)e.getY(); //Ŭ���� ��ġ�� y ��ǥ
           }
        } 
           
        //������ ����� ������ ũ���� ���� �׸��� ���ش�.
        public void  paintComponent(Graphics g) { //�������̵� �Ѵ�.
           super.paintComponent(g); //Jpanel�� paintComponent() ȣ��
           
           if (showflag == true) { //������ �ϴ� ���� �����ִ� ������ ���°� true��� �����Ѵ�.
            
              int red = (int)(Math.random()*256); //red�� �����ϸ鼭 ������ ���� �޾� ���� �ʱ�ȭ���ش�.
            int green = (int)(Math.random()*256); //green�� �����ϸ鼭 ������ ���� �޾� ���� �ʱ�ȭ���ش�.
            int blue = (int)(Math.random() * 256); //blue�� �����ϸ鼭 ������ ���� �޾� ���� �ʱ�ȭ���ش�.
            g.setColor(new Color(red,green,blue)); //��ü g�� ���� �����ϰ� ���� red, green, blue�� ����  �����Ѵ�.
               
            int size =(int)(Math.random()*10) + 1; //����� �����ϸ� ���ÿ� 1���� 10 ������ ������ ���� �޾� �ʱ�ȭ���ش�.
                 
            g.drawOval(x, y, size, size); //��ǥ(x,y)�� ��ġ���� size * size ũ���� �簢���� �����ϴ� Ÿ���� �׸���.
            }
        }

   }//MyPanel Ŭ���� �ݱ�

   public static void main(String[] args) { //main �Լ�
      new MyFrame(); 
   }
   
} //MyFrame Ŭ���� �ݱ�