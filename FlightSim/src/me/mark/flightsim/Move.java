package me.mark.flightsim;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Move {
	
	public static void move(String loc, JLabel label) {
		
			if (loc == "right") {
			    label.setLocation(label.getX() + 1, label.getY());
			    label.setIcon(new ImageIcon("images/plane.png"));
			} else if (loc == "up") {
				label.setLocation(label.getX(),label.getY() - 1);
		        label.setIcon(new ImageIcon("images/plane.png"));
			} else if (loc == "down") {
				label.setLocation(label.getX(), label.getY() + 1);
				label.setIcon(new ImageIcon("images/plane.png"));
			}
	}
	
}
