package me.Mark.better;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class cmdHandler implements Listener {
	
	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		String[] args = event.getMessage().split(" ");
		String cmd = args[0];
		
		if (cmd.equalsIgnoreCase("/warp") || cmd.equalsIgnoreCase("/warps")) {
			player.chat("/pw list");
			event.setCancelled(true);
		} else if (cmd.equalsIgnoreCase("/setwarp")) {
			if (args.length >= 2) player.chat("/pw set " + args[1]);
			else player.sendMessage(ChatColor.GREEN + "/setwarp <name>");
			event.setCancelled(true);
		} else if (cmd.equalsIgnoreCase("/delwarp") || cmd.equalsIgnoreCase("/deletewarp")) {
			if (args.length >= 2) player.chat("/pw remove " + args[1]);
			else player.sendMessage(ChatColor.GREEN + "/delwarp <name>");
			event.setCancelled(true);
		}
		
	}
	
}
