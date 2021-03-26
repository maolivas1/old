package me.Meatie.client;

import javax.swing.JFrame;

public class Main {
	
	  static JFrame frame = new JFrame("Dj Client Running...");
	  
	  public static void main(String args[]) {
		  
			frame.setSize(500, 500);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
		    try {
				BreadClient.start();
			} catch (Exception e) {}
		    
	  }
	  
}