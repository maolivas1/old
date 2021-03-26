package me.Mark.AI;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AI {
	
	  static JFrame frame = new JFrame("");
	  static JPanel panel = new JPanel();
	  static JTextField text = new JTextField(20);
	
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(500, 75);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
	        text.setSize(450, 30);
	        text.setVisible(true);
		    
	        frame.add(text);
		    
	        Kea.load();
	        
	        Data.save("fullname", "marcus");
	        Data.save("name", "mark");
	        Data.load();
	  }
	
}
