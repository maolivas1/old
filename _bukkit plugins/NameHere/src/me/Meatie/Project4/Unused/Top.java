package me.Meatie.Project4.Unused;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Top {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		player.teleport(getTop(player.getLocation()));
	}
	
	public static Location getTop(Location loc) {
		      double y = loc.getWorld().getMaxHeight();
		      while(y > 0) {
		         y = y - 1;
		         Location loc2 = new Location(loc.getWorld(), loc.getX(), y, loc.getZ());
				if (loc.getWorld().getBlockAt(loc2).getType() != Material.AIR) {
					loc2.setPitch(loc.getPitch());
					loc2.setYaw(loc.getYaw());
					loc2.setY(y + 1);
		         return loc2;
				}
		      }
		      return loc;
	}
	
}
