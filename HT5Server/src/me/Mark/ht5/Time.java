package me.Mark.ht5;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
	
	 
		public static void start() {
			  new Timer().scheduleAtFixedRate(new TimerTask() {
			  public void run() {
				  //Don't spawn more than 10 pastas at a time
				  if (Thingy.pastas.size() <= 10) {
					Random r = new Random();
					int x = r.nextInt(1000) + 1;
			        int y = r.nextInt(1000) + 1;
				  Thingy.sendAll("pasta" + Thingy.pasta + " add " + Thingy.toPrecent(x) + " " + Thingy.toPrecent(y) + " pasta 50 50");
				  Thingy.pastas.put("" + Thingy.pasta++, Thingy.toPrecent(x) + " " + Thingy.toPrecent(y));
				  }
			  }
			  }, 0, 5000);
		}
		
}