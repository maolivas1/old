package me.Mark.selector;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class Move {
	
	static int x;
	static int y;
	static JLabel last;

	public static void move(String dir) {
		//System.out.println("Moveing Selector: " + dir);
		
		if (dir == "up") {
			if (y > 0)
			y--;
		} else if (dir == "down") {
			if (Game.gameFile.containsKey(x + "-" + (y + 1)))
			y++;
		} else if (dir == "left") {
			if (x > 0)
			x--;
		} else if (dir == "right") {
			if (Game.gameFile.containsKey((x + 1) + "-" + y))
			x++;
		}
		
		String loc = x + "-" + y;
		if (Game.gameFile.containsKey(loc)) {
			//System.out.println(Game.gameFile.get(loc));
			JLabel label = Game.loc.get(loc);
			if (last != label)
			addBorder(label);
		}
		
	}
	
	public static void addBorder(JLabel label) {
		Border border = BorderFactory.createLineBorder(Game.borderColor, Game.borderSize);
		label.setBorder(border);
		if (last != null)
		takeBorder(last);
		last = label;
	}
	
	public static void takeBorder(JLabel label) {
		label.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEmptyBorder(), ""));
	}
}
