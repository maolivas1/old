package me.Mark.code;

import java.util.HashMap;

import javax.swing.ImageIcon;

public class Move {
	
	static HashMap<String, String> state = new HashMap<String, String>();
	
	public static void move(String loc, String player) {
		Main.player.get(player).setIcon(new ImageIcon("images/" + player +  "/" + loc + ".gif"));
		state.put("p1", loc);
			if (loc == "right")
			    if (!Main.x.contains(Main.player.get(player).getX() + 1)) Main.player.get(player).setLocation(Main.player.get(player).getX() + 1, Main.player.get(player).getY());
			if (loc == "left")
			    if (!Main.x.contains(Main.player.get(player).getX() - 1)) Main.player.get(player).setLocation(Main.player.get(player).getX() - 1, Main.player.get(player).getY());
	}
	
	public static void sit(String player) {
		Main.player.get(player).setIcon(new ImageIcon("images/" + player +  "/" + state.get("p1") + "-sit.gif"));
}
	public static void stand(String player) {
		Main.player.get(player).setIcon(new ImageIcon("images/" + player +  "/" + state.get("p1") + ".gif"));
}
	public static void kick(String loc, String player) {
		Main.player.get(player).setIcon(new ImageIcon("images/" + player +  "/" + loc + "-punch.gif"));
}
	public static void fix(String player) {
		Main.player.get(player).setLocation(Main.player.get(player).getX() + 1,  Main.frame.getHeight() - 350);
}
	
}
