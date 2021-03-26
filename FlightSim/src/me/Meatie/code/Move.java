package me.Meatie.code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Move {
	
	//static String last = "";
	
	public static void p1(String loc) {
		
			if (loc == "right") {
			    if (!Map.y.contains(Main.p1.getX() + 1)) Main.p1.setLocation(Main.p1.getX() + 1, Main.p1.getY());
				Main.p1.setIcon(new ImageIcon("images/" + Main.name + "/right.gif"));
				//last = "right";
				return;
			} if (loc == "left") {
			    if (!Map.y.contains(Main.p1.getX() - 1)) Main.p1.setLocation(Main.p1.getX() - 1, Main.p1.getY());
				Main.p1.setIcon(new ImageIcon("images/" + Main.name + "/left.gif"));
				//last = "left";
				return;
			} if (loc == "up") {
		        if (!Map.x.contains(Main.p1.getY() - 1)) Main.p1.setLocation(Main.p1.getX(), Main.p1.getY() - 1);
				Main.p1.setIcon(new ImageIcon("images/" + Main.name + "/up.gif"));
				//last = "up";
				return;
			} if (loc == "down") {
				if (!Map.x.contains(Main.p1.getY() + 1)) Main.p1.setLocation(Main.p1.getX(), Main.p1.getY() + 1);
				Main.p1.setIcon(new ImageIcon("images/" + Main.name + "/down.gif"));
				//last = "down";
				return;
			}
	}
	
	public static void cow(JLabel label, String loc) {
		
		int speed = Main.mobspeed.get(label);
		
		if (loc == "right") {
		    if (!Map.y.contains(label.getX() + speed)) label.setLocation(label.getX() + speed, label.getY());
		    label.setIcon(new ImageIcon("images/trump/right.gif"));
			return;
		} if (loc == "left") {
		    if (!Map.y.contains(label.getX() - speed)) label.setLocation(label.getX() - speed, label.getY());
		    label.setIcon(new ImageIcon("images/trump/left.gif"));
			return;
		} if (loc == "up") {
	        if (!Map.x.contains(label.getY() - speed)) label.setLocation(label.getX(), label.getY() - speed);
	        label.setIcon(new ImageIcon("images/trump/up.gif"));
			return;
		} if (loc == "down") {
			if (!Map.x.contains(label.getY() + speed)) label.setLocation(label.getX(), label.getY() + speed);
			label.setIcon(new ImageIcon("images/trump/down.gif"));
			return;
		}
}
	
}
