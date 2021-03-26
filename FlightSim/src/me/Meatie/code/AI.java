package me.Meatie.code;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class AI {
	
	
	
	public static void start() {
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  for (JLabel label : Main.mobs) {
			  if (Math.abs(Main.p1.getX() - label.getX()) > Math.abs(Main.p1.getY() - label.getY()))
			                    if (Main.p1.getX() > label.getX())
			                    Move.cow(label, "right");
			                    else Move.cow(label, "left");
			                    else if (Main.p1.getY() > label.getY())
			                    Move.cow(label, "down");
			                    else Move.cow(label, "up");
			  }
			  
		  }
      }, 0, 60);
}
	
}