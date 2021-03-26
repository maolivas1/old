package me.Meatie.code;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Spawn {
	
	public static void start() {
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  int x = new Random().nextInt(Main.frame.getWidth()) + 50;
			  int y = new Random().nextInt(Main.frame.getHeight()) + 50;
			  
			  add("angel", x, y);

			  
		  }
		  }, 0, 1000);
	}
	
	public static void add(String type, int x, int y) {
		
		for (JLabel thing : Main.things) {
			if (Main.status.get(thing) == "sit") {
				Main.status.put(thing, "walk");
				thing.setIcon(new ImageIcon("images/" + type + "/down.gif"));
				thing.setLocation(x, y);
				return;
			}
		}
		
		
	}
	
}
