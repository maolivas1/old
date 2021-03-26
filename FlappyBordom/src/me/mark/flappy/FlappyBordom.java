package me.mark.flappy;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlappyBordom {

	  static JFrame frame = new JFrame("Flappy Bird");
	  static JPanel panel = new JPanel();
	  static JLabel p1 = new JLabel(new ImageIcon("bird.png"));
	  static JLabel back = new JLabel(new ImageIcon("back.png"));
	  
	  static JLabel pipe1 = new JLabel(new ImageIcon("pipe.png"));
	  static JLabel pipe2 = new JLabel(new ImageIcon("pipe2.png"));
	  
	  static JLabel pipe3 = new JLabel(new ImageIcon("pipe.png"));
	  static JLabel pipe4 = new JLabel(new ImageIcon("pipe2.png"));
	  
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(1000, 1000);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
		    Kea.start();
		    Tick.start();
		    
		    frame.add(p1);
		    frame.add(pipe1);
		    frame.add(pipe2);
		    
		    frame.add(pipe3);
		    frame.add(pipe4);
		    
		    Terrain.add("back.png", 0, 0, FlappyBordom.frame.getWidth(), FlappyBordom.frame.getHeight(), FlappyBordom.back);
	  }
	
}
