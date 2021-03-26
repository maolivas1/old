package me.mark.flappy;

import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Terrain {
	
	public static void add(String path, final int x, final int y, final int sizew,  final int sizeh, final JLabel label) {
		final ImageIcon icon = new ImageIcon(path);
		FlappyBordom.frame.add(label);
		final Timer timer = new Timer();
		timer.schedule(new TimerTask() {
		  public void run() {
				label.setLocation(x, y);
				label.setIcon(new ImageIcon(icon.getImage().getScaledInstance(sizew, sizeh, Image.SCALE_SMOOTH)));
		  }
		  }, 0, 1000);
		  
	}
}