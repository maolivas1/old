package me.Mark.code;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Multiplayer {

	public static void join(String p) {
		 Main.player.put(p, new JLabel(new ImageIcon("images/" + p + "/right.gif")));
		    Main.frame.add(Main.player.get(p));
		    try {Thread.sleep(100);} catch(Exception e) {}
		    //TODO
		    /*
		     * without the wait above both players show up but they don't teleport down
		     * but with the wait only one shows up.. and they don't teleport
		     */
		    
		    
			Main.player.get(p).setLocation(200, Main.frame.getHeight() - 350);
		
	}
	
}
