package me.Mark.stuff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class AntiJon implements Listener {

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().startsWith("/op"))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void console(ServerCommandEvent event) {
		if (event.getCommand().startsWith("op"))
			event.setCancelled(true);
	}
	
	
}
