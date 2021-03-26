package me.Meatie.code;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
			  /*
			  if (Kea.list.contains("q"))
				  print();
			  
			  if (Kea.list.contains("e"))
				  print();
		  */
		  }
		  }, 0, 10);
	}
	
	static void print() {
		if (print == false) {
			print = true;
			System.out.println(Main.p1.getX() + " " + Main.p1.getY());
		  Runnable task = new Runnable() {
		    public void run() {
				  print = false;
		    }
		  };
		  Executors.newSingleThreadScheduledExecutor().schedule(task, 1, TimeUnit.SECONDS);
		}
	}
	
	
	
	
}
