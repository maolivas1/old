package me.Meatie.Listiner;

import me.Meatie.Data.RankData;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class Build implements Listener {
	
	
	@EventHandler
	public void destroy(BlockBreakEvent event) {
		if (RankData.get(event.getPlayer().getWorld().getName(), event.getPlayer().getName()) == null)
			event.setCancelled(true);
	}
	
	@EventHandler
	public void create(BlockPlaceEvent event) {
		if (RankData.get(event.getPlayer().getWorld().getName(), event.getPlayer().getName()) == null)
			event.setCancelled(true);
	}
	
}