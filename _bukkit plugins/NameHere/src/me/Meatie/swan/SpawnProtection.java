package me.Meatie.swan;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnProtection implements Listener {

	@EventHandler
	public void destroy(BlockBreakEvent event) {
		if (!allowed(event.getBlock().getLocation(), event.getPlayer()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void place(BlockPlaceEvent event) {
		if (!allowed(event.getBlock().getLocation(), event.getPlayer()))
			event.setCancelled(true);
	}
	
	public boolean allowed(Location loc, Player player) {
		if (loc.getX() > -185 && loc.getX() < -132 && loc.getZ() > 228 && loc.getZ() < 278)
			if (!player.hasPermission("build.spawn"))
				return false;
		return true;
	}
}