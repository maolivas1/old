package me.Mark.oneHourGame;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ItemDrop {

	public static void start() {
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  int x =  new Random().nextInt((730 - 0) + 1) + 0;
			  int y =  new Random().nextInt((956 - 0) + 1) + 0;
			  int size =  new Random().nextInt((150 - 50) + 1) + 50;
			  Terrain.add("tree.png", x, y, size, size, null);
			  
		  }
		  }, 0, 5000);
	}
	
}
