package me.Meatie.Project4.Unused;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class God_ implements Listener {

	@EventHandler
	public void damage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			Player player = (Player)event.getEntity();
			if (God.god.contains(player.getName()))
				event.setCancelled(true);
		}
	}
	
}
