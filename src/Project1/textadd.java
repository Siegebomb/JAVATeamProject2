package Project1;
import javax.swing.*;


import java.awt.event.*;
import java.awt.*;

public class textadd extends JFrame {
   private JTextField tf = new JTextField(35);
   private JTextArea ta = new JTextArea(15, 35); // 한줄에 35개 입력 가능, 15줄 입력창
   
   public textadd() {
      setTitle("글사랑");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Container c = getContentPane();
      c.setLayout(new FlowLayout());
      // c.add(new MenuPanel(bt1), BorderLayout.NORTH); // 버튼을 가진 MenuPanel 부착

      c.add(new JScrollPane(ta));
      
      c.add(tf);

      // 텍스트필드에 <Enter> 키 입력 때 발생하는 Action 이벤트의 리스너 등록
      tf.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            JTextField t = (JTextField)e.getSource();
            ta.append(t.getText()); // 텍스트필드의 문자열을 텍스트영역 창에 붙임 
            t.setText(""); // 현재 텍스트필드에 입력된 내용 지우기
         }
      });

      setSize(400,400);
      setVisible(true);
   }
      
   public static void main(String [] args) {
      new textadd();
   }
}