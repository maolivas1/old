package me.Mark.fix;

import net.coreprotect.CoreProtect;
import net.coreprotect.CoreProtectAPI;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class Fix implements Listener {
	
	WorldGuardPlugin wg = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
	static CoreProtectAPI cp;
	
	public static void core() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("CoreProtect");
		if (plugin != null) {
			cp = ((CoreProtect)plugin).getAPI();
		}
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void interact(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			double id = player.getItemInHand().getTypeId();
		if ((id <= 208 && id != 0) || id == 326 || id == 327 || id == 354 || id == 331) {
		if (event.getClickedBlock() != null) {
			if (player.isSneaking()) {
				Location loc = event.getClickedBlock().getLocation();
				BlockFace pos = event.getBlockFace();
				loc = new Location(loc.getWorld(), loc.getX() + pos.getModX(), loc.getY() + pos.getModY(), loc.getZ() + pos.getModZ());
				if (loc.getBlock().getType() == Material.AIR) {
					event.setCancelled(true);
					if (wg != null) {
					if (wg.canBuild(player, loc)) {
						place(player, loc);
					}
					} else {
						place(player, loc);
					}
					player.updateInventory();
				}
			}
		}
		}
		}
	}
	
	/*
	Doors
	Trap Doors
	Beds
	Signs
	All blocks that rotate (like pistons) or have position (like doors)
	 */
	
	@SuppressWarnings("deprecation")
	public void place(Player player, Location loc) {
		Material block = player.getItemInHand().getType();
		if (block == Material.WATER_BUCKET) {
			block = Material.WATER;
		} else if (block == Material.LAVA_BUCKET) {
			block = Material.LAVA;
		} else if (block == Material.REDSTONE) {
			block = Material.REDSTONE_WIRE;
		} else if (block == Material.CAKE) {
			block = Material.CAKE_BLOCK;
		}
		if (player.getGameMode() != GameMode.CREATIVE)
		player.getInventory().removeItem(new ItemStack(player.getItemInHand().getType(), 1));
		new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ()).getBlock().setType(block);
		if (cp != null) {
			cp.logPlacement(player.getName(), loc, block, (byte) 1);
		}
	}
	
	
}
