package me.Meatie.Project4.Unused;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {

	@EventHandler
	public void quit(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (God.god.contains(player.getName()))
			God.god.remove(player.getName());
		
		if (Hide.hiden.contains(player.getName()))
			Hide.hiden.remove(player.getName());
		
		if (Tpa.tpa.containsKey(player.getName()))
			Tpa.tpa.remove(player.getName());
		
		if (Fly.fly.contains(player.getName()))
			Fly.fly.remove(player.getName());
		
		if (Back.back.containsKey(player.getName()))
			Back.back.remove(player.getName());
	}
	
}
