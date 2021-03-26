package me.Mark.Stuff.old;

import me.Mark.stuff.fwCommand;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowHitEvent implements Listener {

	@EventHandler
	public void arrowHit(ProjectileHitEvent event) {
		
		EntityType type = event.getEntityType();
		
		if (type.equals(EntityType.ARROW)) {
		Location loc = event.getEntity().getLocation();
		fwCommand.spawnFirework(loc);
		}
	}
	
}
