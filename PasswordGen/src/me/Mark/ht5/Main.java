package me.Mark.ht5;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
	  
    static JFrame frame = new JFrame("Passwordgen Console");
    static JTextArea messageArea = new JTextArea(8, 40);
	
	  public static void main(String args[]) {
			frame.setSize(500, 500);
	        messageArea.setEditable(false);
	        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        frame.pack();
		  
		    String[] n = null;
		   try {
				WebServer.start(n);
			} catch (Exception e) {}

		    
	  }
	  
	    public static void chat(String msg) {
	    	 messageArea.append(msg + "\n");
	    }
	  
}