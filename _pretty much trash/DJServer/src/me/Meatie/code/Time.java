package me.Meatie.code;

import java.util.Timer;
import java.util.TimerTask;

public class Time {
	
	static int totalTime = -1;
	static int time = -1;
	
	 public static void set(int secs) {
		time = secs;
		totalTime = secs;
	}
	 
		public static void start() {
			  new Timer().scheduleAtFixedRate(new TimerTask() {
			  public void run() {
				  if (time < 0) return;
				  if (--time == 0) {
					  WaitList.skip();
				  }
			  }
			  }, 0, 1000);
		}
		
}
