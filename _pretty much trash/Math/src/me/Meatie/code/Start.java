package me.Meatie.code;

import java.awt.FlowLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Start {
		
	  static JFrame frame = new JFrame("");
	
	  public static void main(String args[]) {
	        
			frame.setSize(1000, 1000);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   
	        JLabel label = new JLabel();
	        label.setSize(1000, 1000);
	        frame.add(label);
		  label.setText("<html>3.14");
		  int x = 0;
		  
		  while (1 > x) {
		try {Thread.sleep(100);} catch(Exception e) {}
		String msg = label.getText().replace("</html>", "") + new Random().nextInt(10) + "</html>";
		double length = msg.length();
		if (length/140 == Integer.valueOf((int)(length/140))) msg = msg + "<br>";
		  label.setText(msg);
		  }
		  
	  }
		
		    
	  
}