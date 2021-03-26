package me.mark.flappy;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Tick {
	
	static int fly = 0;
	
	public static void start() {
		
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  
			  if (Kea.list.contains("32"))
				  Move.p1("up");
			  else
				  Move.p1("down");
			  
			  if (Kea.list.contains("10")) {
				  Move.setLoc(FlappyBordom.p1, "bird.png", 400, 500, 50, 50);
				  Move.setLoc(FlappyBordom.pipe1, "pipe.png", 800, 800, 100, 500);
				  Move.setLoc(FlappyBordom.pipe2, "pipe2.png", 800, 100, 100, 500);
				  Move.setLoc(FlappyBordom.pipe3, "pipe.png", 1200, 600, 100, 500);
				  Move.setLoc(FlappyBordom.pipe4, "pipe2.png", 1200, -100, 100, 500);
			  }
		  }
		  }, 0, 4);
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  Move.pipea();
			  
			  if (FlappyBordom.pipe1.getX() < 0) {
				  int y = new Random().nextInt(400) - 300;
				  FlappyBordom.pipe1.setLocation(900, y + 700);
				  FlappyBordom.pipe2.setLocation(900, y);
			  }
			  
			  Move.pipeb();
			  
			  if (FlappyBordom.pipe3.getX() < 0) {
				  int y = new Random().nextInt(400) - 300;
				  FlappyBordom.pipe3.setLocation(900, y + 700);
				  FlappyBordom.pipe4.setLocation(900, y);
			  }
			  
			  
		  }
		  }, 0, 10);
		  
	}
	
	
	
	
}
