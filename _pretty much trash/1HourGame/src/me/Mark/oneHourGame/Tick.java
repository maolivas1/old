package me.Mark.oneHourGame;

import java.util.Timer;
import java.util.TimerTask;

public class Tick {
	
	static boolean print = false;
	
	public static void start() {
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
		  
			  if (Kea.list.contains("a"))
				  Move.p1("left");
			  
			  if (Kea.list.contains("d"))
				  Move.p1("right");
			  
			  if (Kea.list.contains("w"))
				  Move.p1("up");
			  
			  if (Kea.list.contains("s"))
				  Move.p1("down");
		  }
		  }, 0, 10);
	}
	
	
	
	
}
