package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextField extends JFrame{
   private JTextField tf=new JTextField(20);
   private JTextArea ta=new JTextArea(7,20);
   private JButton[]button=new JButton[3];
   private String[]text= {"��ư1","��ư2","��ư3"};
   private ImageIcon[]image= {
         new ImageIcon(""),
         new ImageIcon(""),
         new ImageIcon("")};
   private JLabel imageLabel=new JLabel();
   
   public TextField() {
      setTitle("�� ������Ʈ");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c=getContentPane();
      c.setLayout(new BorderLayout());
      
      c.add(new JLabel("�Է� �� <ENTER>Ű�� �Է��ϼ���"));
      c.add(tf);
      c.add(new JScrollPane(ta));
      
      tf.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JTextField t=(JTextField)e.getSource();
            ta.append(t.getText() + "\n");
            
            t.setText("");
         }
      });
      
      JPanel BPanel=new JPanel();
      BPanel.setBackground(Color.GRAY);
      ButtonGroup g=new ButtonGroup();
      for(int i=0; i<button.length;i++) {
         button[i]=new JButton(text[i]);
         g.add(button[i]);;
         BPanel.add(button[i]);
         button[i].addItemListener(new MyItemListener());
      }
      
      button[1].setSelected(true);
      c.add(BPanel,BorderLayout.NORTH);
      c.add(imageLabel,BorderLayout.CENTER);
      imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
   
      setSize(300,300);
      setVisible(true);
      
      }
      
   class MyItemListener implements ItemListener{
      public void itemStateChanged(ItemEvent e) {
         if(e.getStateChange()==ItemEvent.DESELECTED)
            return;

      }
   }
   public static void main(String[]args) {
      new TextField();
   }

}