package me.Mark.code;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {
	  static JFrame frame = new JFrame("OOF");
	  static JPanel panel = new JPanel();
	  static HashMap<String, JLabel> player = new HashMap<String, JLabel>();
		static ArrayList<Integer> x = new ArrayList<Integer>();
	  public static void main(String args[]) throws IOException {
			frame.setSize(1500, 1000);
		  
		    frame.setLayout(new BorderLayout());
		    ImageIcon icon = new ImageIcon("images/back/10.gif");
		    icon = new ImageIcon(icon.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH));
		    frame.setContentPane(new JLabel(icon));
		    frame.setLayout(new FlowLayout());
		  
		    frame.getContentPane().add(panel);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
		    Multiplayer.join("p1");
		    Multiplayer.join("p2");
		    
		   Tick.start();
		   
		x.add(0);
		x.add(frame.getWidth() - 180);
		
		frame.setIconImage(ImageIO.read(new File("images/logo.png")));
	  }
	  
}