package me.Mark.selector;

import java.util.Timer;
import java.util.TimerTask;

public class Tick {
	
	static int fly = 0;
	
	public static void start() {
		
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  
			  if (Kea.list.contains("w"))
				  Move.move("up");
			   if (Kea.list.contains("s"))
				  Move.move("down");
			   if (Kea.list.contains("a"))
				  Move.move("left");
			   if (Kea.list.contains("d"))
				  Move.move("right");
			  
		  }
		  }, 0, 100);
		  
	}
	
	
	
	
}
