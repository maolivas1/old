package me.Meatie.Project4.Unused;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Debug {

	public static boolean debug = false;
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (debug == false) {
		player.sendMessage(ChatColor.GREEN + "Debug Mode " + ChatColor.DARK_GREEN + "Enabled");
		debug = true;
		} else {
			player.sendMessage(ChatColor.GREEN + "Debug Mode " + ChatColor.DARK_RED + "Disabled");
			debug = false;
		}
	}
	
}
