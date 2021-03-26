package me.mark.flightsim;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Kea {
	
	static ArrayList<String> keys = new ArrayList<String>();
	
	public static void listen() {
		  FlightSim.panel.setFocusable(true);
		  FlightSim.panel.requestFocusInWindow();
		
		  FlightSim.panel.addKeyListener(new KeyListener() {
			  
             public void keyTyped(KeyEvent e) {}
             
             @Override
             public void keyReleased(KeyEvent e) {
            	 keys.remove(String.valueOf(e.getKeyCode())); 
             }

             @Override
             public void keyPressed(KeyEvent e) {
            	 if (!keys.contains(String.valueOf(e.getKeyCode())))
            	 keys.add(String.valueOf(e.getKeyCode()));
             }
         });
		 tick();
	}
	
	
	public static void tick() {
	  new Timer().scheduleAtFixedRate(new TimerTask() {
	  public void run() {		  
		  if (keys.contains("87"))
			  Move.move("up", FlightSim.mine);
		  
		 if (keys.contains("83"))
			 Move.move("down", FlightSim.mine);
		 
		 System.out.println(keys);
	  }
	  }, 0, 100);
	}
	
}
