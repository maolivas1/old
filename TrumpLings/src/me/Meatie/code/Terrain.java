package me.Meatie.code;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Terrain {
	
	public static void load() {
		add("tree.png", 500, 300, 150, 150, null);
	}
	
	public static void add(String path, final int x, final int y, final int sizew,  final int sizeh, JLabel label) {
		final ImageIcon icon = new ImageIcon("images/" + path);
		
		final JLabel item;
		if (label == null)
		item = new JLabel();
		else item = label;
		
			  if (item != Main.back) {
				  Main.frame.remove(Main.back);
				  Main.frame.add(item);
				  add("stars.jpg", 0, 0, Main.frame.getWidth(), Main.frame.getHeight(), Main.back);
			  } else Main.frame.add(item);
			  
			  
		  new Timer().schedule(new TimerTask() {
		  public void run() {
				item.setLocation(x, y);
				if (sizew != 0 || sizeh != 0)
					item.setIcon(new ImageIcon(icon.getImage().getScaledInstance(sizew, sizeh, java.awt.Image.SCALE_SMOOTH)));
					else item.setIcon(icon);
		  }
		  }, 0, 50); 
	}
}