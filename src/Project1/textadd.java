package Project1;
import javax.swing.*;


import java.awt.event.*;
import java.awt.*;

public class textadd extends JFrame {
   private JTextField tf = new JTextField(35);
   private JTextArea ta = new JTextArea(15, 35); // ���ٿ� 35�� �Է� ����, 15�� �Է�â
   
   public textadd() {
      setTitle("�ۻ��");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      // c.add(new MenuPanel(bt1), BorderLayout.NORTH); // ��ư�� ���� MenuPanel ����

      c.add(new JScrollPane(ta));
      
      c.add(tf);

      // �ؽ�Ʈ�ʵ忡 <Enter> Ű �Է� �� �߻��ϴ� Action �̺�Ʈ�� ������ ���
      tf.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JTextField t = (JTextField)e.getSource();
            ta.append(t.getText()); // �ؽ�Ʈ�ʵ��� ���ڿ��� �ؽ�Ʈ���� â�� ���� 
            t.setText(""); // ���� �ؽ�Ʈ�ʵ忡 �Էµ� ���� �����
         }
      });

      setSize(400,400);
      setVisible(true);
   }
      
   public static void main(String [] args) {
      new textadd();
   }
}