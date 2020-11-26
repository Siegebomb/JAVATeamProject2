package Project1;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class picture extends JFrame {
   private JLabel imageLabel; // �̹��� ���̺�
   private ImageIcon [] images = new ImageIcon [3]; // �̹��� ��ü �迭
   int currentId; // ���� ���õ� �̹��� ��ȣ(0~2).
   
   public picture() {
      setTitle("�� �Ұ�");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      Container c = getContentPane(); // ����Ʈ�� ���
      c.setLayout(new BorderLayout()); // ����Ʈ�ҿ� BorderLayout ����

         JButton bt1 = new JButton("�� �Ұ�");

       // �̹��� ���� �ε�.
      // ������Ʈ�� images ������ images0.jpg, image1.jpg, image2.jpg, image3.jpg
      for(int i=0; i<images.length; i++)  
         images[i] = new ImageIcon("images/image" + i + ".gif");

      currentId = 0; // ���� ���õ� �̹��� ��ȣ
      imageLabel = new JLabel(images[currentId]); // ���� ���õ� �̹����� ���̺� ���
      c.add(imageLabel, BorderLayout.CENTER); // �̹��� ���̺��� CENTER�� ����
      c.add(new MenuPanel(bt1), BorderLayout.NORTH); // ��ư�� ���� MenuPanel ����
      
      setSize(500,500);
      setVisible(true);
   }

   // �� ���� ȭ��ǥ ��ư�� ���� �޴� �г�
   class MenuPanel extends JPanel {
      public MenuPanel(JButton bt1) {
         setBackground(Color.GRAY);
         
         add(bt1);   
         
         // ���� ȭ��ǥ ��ư�� Action ������ �ޱ�
         bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               currentId --; // �̹��� ��ȣ ����. ���� �̹���
               currentId += images.length;   // currentId�� ������ �� �� �ֱ� ������ 4�� ����
               currentId %= images.length; // 4 �� �Ѵ� ���� ���� ���� �̹��� ������ ������ ����
               imageLabel.setIcon(images[currentId]); // �̹��� ���̺� �̹��� ����
            }
         });
         
         
      }
   }
   
   public static void main(String [] args) {
      new picture();
   }
} 