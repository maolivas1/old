package me.Mark.oneHourGame;

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
	
	//9:27 - 10:27
	
	static JFrame frame = new JFrame("Mark's 1 Hour Game");
	static JPanel panel = new JPanel();
	static JLabel p1 = new JLabel(new ImageIcon("images/P1/down.gif"));
	static JLabel i1 = new JLabel(new ImageIcon("images/P1/health.png"));
	static JLabel back = new JLabel();
	static ArrayList<JLabel> mobs = new ArrayList<JLabel>();
	  static HashMap<JLabel, Integer> mobspeed = new HashMap<JLabel, Integer>();
	
	  static int itemx;
	  static int itemy;
	  
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(1000, 800);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
		    frame.add(p1);
		    //frame.add(i1);
		    
			 int x =  new Random().nextInt((730 - 0) + 1) + 0;
			 int y =  new Random().nextInt((956 - 0) + 1) + 0;
			Terrain.add("health.png", x, y, 50, 50, i1);
			itemx = x;
			itemy = y;
		    
		    addMob(15);
	        
	        Terrain.load();
	        Kea.start();
	        Map.load();
	        Tick.start();
	        AI.start();
	        //AI.noLagg();
		    //ItemDrop.start();
		    
		    
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
