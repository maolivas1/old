package me.mark.myplot;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class setspawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			
			for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation())) {
				String region = r.getId();
				String rank = Config.getrank(player.getName(), region);
				
				if (player.isOp() || rank.equals("coowner") || rank.equals("owner")) {
					
					Location loc = player.getLocation();
					Config.setspawn(region, loc);
					player.sendMessage(ChatColor.GREEN + "Setspawn to: " + ChatColor.GRAY + ((int) loc.getX()) + ChatColor.GREEN + ", " + ChatColor.GRAY + ((int) loc.getY()) + ChatColor.GREEN + ", " + ChatColor.GRAY + ((int)loc.getZ()) + ChatColor.GREEN + " in " + ChatColor.GRAY + region + ChatColor.GREEN + "'s realm!");
					
				} else player.sendMessage(ChatColor.RED + "Only Co-Owner and up can do that!");
				
				
			}
			
		}
		
		return true;
	}
	
}
