package me.Meatie.Project4.Unused;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Plot {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 1) {
		event.setCancelled(true);
		player.sendMessage(ChatColor.GREEN + "plot claim " + ChatColor.DARK_GREEN + "Claim Plot You'r Standing On");
		player.sendMessage(ChatColor.GREEN + "plot auto " + ChatColor.DARK_GREEN + "Claim Next Avalible Plot");
		player.sendMessage(ChatColor.GREEN + "plot home " + ChatColor.DARK_GREEN + "Teleport To Plot Home");
		player.sendMessage(ChatColor.GREEN + "plot list " + ChatColor.DARK_GREEN + "List Plot Homes");
		player.sendMessage(ChatColor.GREEN + "plot add " + ChatColor.DARK_GREEN + "Let Someone Build In You'r Plot");
		player.sendMessage(ChatColor.GREEN + "plot remove " + ChatColor.DARK_GREEN + "Deny Someone To Build In You'r Plot");
		}
	}
	
}
