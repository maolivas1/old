package me.Meatie.Project4.Unused;

import java.util.Map;

import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.databases.ProtectionDatabaseException;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;

public class Claim {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		
		WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
		WorldGuardPlugin worldGuard = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		
		Selection sel = worldEdit.getSelection(player);
         if (sel != null) {
        	 
      		if (excist(player))
      		player.sendMessage(Fix.format("&2You have successfully moved you'r area"));
      		else player.sendMessage(Fix.format("&2You have successfully claimed you'r area"));
        	 
        ProtectedCuboidRegion region = new ProtectedCuboidRegion(player.getName(), new BlockVector(sel.getNativeMinimumPoint()), new BlockVector(sel.getNativeMaximumPoint()));
        DefaultDomain owners = new DefaultDomain();
        owners.addPlayer(worldGuard.wrapPlayer(player));
        region.setOwners(owners);
        worldGuard.getRegionManager(player.getWorld()).addRegion(region);
        
         try {
        	 worldGuard.getRegionManager(player.getWorld()).save();
		} catch (ProtectionDatabaseException e) {}
        
    } else player.sendMessage(Fix.format("&4Please select a region"));
		
	}
	
	@SuppressWarnings("rawtypes")
	public static boolean excist(Player player) {
		WorldGuardPlugin worldGuard = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		RegionManager regionManager = worldGuard.getRegionManager(player.getWorld());
		Map map = regionManager.getRegions();
		for (Object key : map.keySet())
		if (key.toString().equalsIgnoreCase(player.getName()))
			return true;
		return false;
	}
	
}
