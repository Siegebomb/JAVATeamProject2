package Project1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class mainFrame extends JFrame {
	
	public mainFrame() {
		setTitle("�� ������Ʈ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		Container c2 = getContentPane();
		setLayout(new BorderLayout(20,30));
		
		c.add(new Button("���Ұ�"),BorderLayout.NORTH);
		c.add(new Button("������"),BorderLayout.NORTH);
		c.add(new Button("�ۻ��"),BorderLayout.NORTH);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		mainFrame mf = new mainFrame();
		
		// TODO Auto-generated method stub

	}

}
