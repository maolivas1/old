package me.Mark.mark;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Logic {
	
	public static void think(String msg) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',msg));
		
	}

}
