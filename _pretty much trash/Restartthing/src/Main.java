

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Main {
	
	  static JFrame frame = new JFrame("Restart Button");
	  static JPanel panel = new JPanel();
		static ArrayList<Integer> x = new ArrayList<Integer>();
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(300, 300);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
		     JTextField pass = new JTextField();
		     frame.add(pass);
		     
			    JButton button = new JButton("Restart");
			    frame.add(button);
		     
	  }
	  
	  public void login() {
		    JButton button = new JButton("Restart");
		    button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		        JDialog d = new JDialog(frame, "Hello", true);
		        d.setLocationRelativeTo(frame);
		        d.setVisible(true);
		        
		        
		        
		        
		        
		      }
		    });
		    frame.add(button);
	  }
	  
}