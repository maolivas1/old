package me.Mark.stuff;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpawnRegion implements Listener {
	
	/*
	@EventHandler
	public void blockBreak(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode().equals(GameMode.SURVIVAL)) {
		if (event.getBlock().getType() == Material.QUARTZ_BLOCK)
			event.setCancelled(true);
		else if (event.getBlock().getType() == Material.GLASS)
		if (event.getBlock().getLocation().getY() == 255)
			event.setCancelled(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void place(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (player.getGameMode().equals(GameMode.SURVIVAL)) {
		if (event.getBlock().getTypeId() == 29 || event.getBlock().getTypeId() == 33)
			event.setCancelled(true);
		}
	}
	*/
	
/*
	public boolean isWithinRegion(Player player, String region) { 
		return isWithinRegion(player.getLocation(), region);
		}
 
	public boolean isWithinRegion(Block block, String region) { 
		return isWithinRegion(block.getLocation(), region); 
		}
 
	public boolean isWithinRegion(Location loc, String region) {
 	   WorldGuardPlugin guard = getWorldGuard();
    	Vector v = toVector(loc);
    	RegionManager manager = guard.getRegionManager(loc.getWorld());
    	ApplicableRegionSet set = manager.getApplicableRegions(v);
    	for (ProtectedRegion each : set)
       	 if (each.getId().equalsIgnoreCase(region))
       	     return true;
   	 return false;
	}

	private WorldGuardPlugin getWorldGuard() {
	    Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
	    if (plugin == null || !(plugin instanceof WorldGuardPlugin))
 	       return null;
 	   return (WorldGuardPlugin) plugin;
	}
 
	*/
	
	
}
