package me.mark.flappy;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Move {
	
	public static void p1(String loc) {
		//FlappyBordom.p1.setIcon(new ImageIcon(".gif"));
			if (loc == "up")
			    FlappyBordom.p1.setLocation(FlappyBordom.p1.getX(), FlappyBordom.p1.getY() - 1);
			if (loc == "down")
			 FlappyBordom.p1.setLocation(FlappyBordom.p1.getX() , FlappyBordom.p1.getY() + 1);
	}
	
	public static void pipea() {
			    FlappyBordom.pipe1.setLocation(FlappyBordom.pipe1.getX() - 1, FlappyBordom.pipe1.getY());
			    FlappyBordom.pipe2.setLocation(FlappyBordom.pipe2.getX() - 1, FlappyBordom.pipe2.getY());
	}
	
	public static void pipeb() {
	    FlappyBordom.pipe3.setLocation(FlappyBordom.pipe3.getX() - 1, FlappyBordom.pipe3.getY());
	    FlappyBordom.pipe4.setLocation(FlappyBordom.pipe4.getX() - 1, FlappyBordom.pipe4.getY());
}
	
	public static void setLoc(JLabel label, String img, int x, int y, int sizex, int sizey) {
		ImageIcon icon = new ImageIcon(img);
		label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(sizex, sizey, Image.SCALE_SMOOTH)));
	    label.setLocation(x, y);
	}
	
}
