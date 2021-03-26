package me.Meatie.Perms;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Cmd implements Listener {

	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		
		if (cmd.equals("c") || cmd.equals("inspect")) {
			 event.setCancelled(true);
			 player.chat("/core inspect");
		} else if (cmd.equals("kick")) {
			event.setCancelled(true);
			
			//tempban player for 1 min
		}
		
	}
	
}
