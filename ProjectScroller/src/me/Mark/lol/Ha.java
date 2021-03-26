package me.Mark.lol;
/*
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import me.Mark.code.Main;


public class Ha {

	public static boolean active = false;
	
	public static void p1(String loc, String player) {
		if (active == false) {
			active = true;
			//Main.player.get(player).setIcon(new ImageIcon("images/" + player + "/" + loc + "-ha.gif"));
			JLabel star = new JLabel();
			Terrain.add("star.gif", Main.player.get(player).getX(), Main.player.get(player).getY() - 100, 50, 50, star);
			
			//if (loc == "left")
			//move(star, -1, Main.player.get(player).getY() - 100, 0);
			//else if (loc == "right")
			//move(star, 1, Main.player.get(player).getY() - 100, 0);
		}
	}
	
	public static void move(JLabel star, final int direction, final int y, final int count) {
		
		new Timer().schedule(new TimerTask() {
		            @Override
		            public void run() {}},500);
		
		if (count == 20) {
			Main.frame.remove(star);
			System.out.println("Star Removed!");
			active = false;
			return;
		}
		star.setLocation(star.getX() + direction, y);
		System.out.println("#" + count);
		
		  move(star, direction, y, count + 1);
	}
	
}
*/