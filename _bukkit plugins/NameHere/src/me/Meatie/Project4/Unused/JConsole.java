package me.Meatie.Project4.Unused;

import java.awt.FlowLayout;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JConsole {
	
	  static JFrame frame = new JFrame("Project3 Console");
	  static JTextField box = new JTextField("");
	
	public static void start() {
		
		frame.setSize(300, 500);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.add(box);
		
	   try {
		frame.setIconImage(ImageIO.read(new File("meatie.png")));
	} catch (IOException e) {}
	   
	   frame.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent windowEvent) {
		    	System.out.println("Project3 Console Terminated.");
		    }
		});
	   
	   
	}
	
	
}