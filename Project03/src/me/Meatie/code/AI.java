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
      }, 0, 20);
}
	
	
	public static void noLagg() {
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  for (JLabel label : Main.mobs)
				  for (JLabel l : Main.mobs)
					  if (label.getX() == l.getX() && label.getY() == l.getY()) {
						  Main.mobspeed.remove(l);
						  Main.frame.remove(l);
						  Main.mobs.remove(l);
						  }
		  }
    }, 0, 1000);
}
	
}