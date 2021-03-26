package me.Meatie.Project4.Unused;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Back_ implements Listener {

	
	@EventHandler
	public void teleport(PlayerTeleportEvent event) {
		Back.back.put(event.getPlayer().getName(), event.getPlayer().getLocation());
	}
	
}
