package me.Meatie.code;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Main {
	
	  static JFrame frame = new JFrame("The Most Epicest Game Of All Time");
	  static JPanel panel = new JPanel();
	  static JLabel p1 = new JLabel(new ImageIcon("images/P1/down.gif"));
	  static JLabel back = new JLabel();
	  static ArrayList<JLabel> mobs = new ArrayList<JLabel>();
	  static HashMap<JLabel, Integer> mobspeed = new HashMap<JLabel, Integer>();
	//JOptionPane.showMessageDialog(null,"Error: Please enter number bigger than 0", "Error Massage",JOptionPane.ERROR_MESSAGE);
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(1000, 800);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.setResizable(false);
		    
		    frame.add(p1);
		    
		    addMob(15);
		    
		  Terrain.load();
		   AI.start();
		   Map.load();
		   Kea.start();
		   Tick.start(); 
		   //AI.noLagg();
		   try {
			frame.setIconImage(ImageIO.read(new File("images/P1/down.gif")));
		} catch (IOException e) {}
	  }
	  
	  public static void addMob(int count) {
		  while(count > 0) {
			  JLabel mob = new JLabel(new ImageIcon("images/Cow/down.gif"));
			    int x = new Random().nextInt(frame.getWidth()) + 1;
			    int y = new Random().nextInt(frame.getHeight()) + 1;
		  count--;
		  int speed = new Random().nextInt(2) + 1;
		    mob.setLocation(x, y);
		    mobspeed.put(mob, speed);
		    frame.add(mob);
		    mobs.add(mob);

		  }
	  }
	  
}