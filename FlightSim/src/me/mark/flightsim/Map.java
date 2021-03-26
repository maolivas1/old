package me.mark.flightsim;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Map {

	public static void add(String path, final int x, final int y, final int sizew,  final int sizeh, final JLabel label) {
		final ImageIcon icon = new ImageIcon("images/" + path);
		
			  if (label != FlightSim.back) {
				  FlightSim.frame.remove(FlightSim.back);
				  FlightSim.frame.add(label);
				  add("bg.jpg", 0, 0, FlightSim.frame.getWidth(), FlightSim.frame.getHeight(), FlightSim.back);
			  } else FlightSim.frame.add(label);
			  
		  new Timer().schedule(new TimerTask() {
		  public void run() {
			  label.setLocation(x, y);
				if (sizew != 0 || sizeh != 0)
					label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(sizew, sizeh, java.awt.Image.SCALE_SMOOTH)));
					else label.setIcon(icon);
		  }
		  }, 0, 50); 
	}

public static void gen() {
	int i = 0;
	while (i++ <= 9) {
		int x = (i * 100);
		int y = (int)(Math.random() * 600);
		 add("skyscraper.gif", x, y, 50, 1500, new JLabel());
	}
}
	
}
