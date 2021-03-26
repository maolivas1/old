package me.Meatie.code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	  
    static JFrame frame = new JFrame("WebSocket Console");
    static JTextField textField = new JTextField(40);
    static JTextArea messageArea = new JTextArea(8, 40);
	
	  public static void main(String args[]) {
			frame.setSize(500, 500);
	        textField.setEditable(true);
	        messageArea.setEditable(false);
	        frame.getContentPane().add(textField, "North");
	        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setVisible(true);
	        frame.setLocationRelativeTo(null);
	        frame.pack();
	        
	        textField.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
						Handel.handel(textField.getText());
					} catch (Exception e1) {}
	                textField.setText("");
	            }
	        });
	        
	        
		  
		    String[] n = null;
		   try {
				WebServer.start(n);
			} catch (Exception e) {}

		    
	  }
	  
	    public static void chat(String msg) {
	    	 messageArea.append(msg + "\n");
	    }
	  
}