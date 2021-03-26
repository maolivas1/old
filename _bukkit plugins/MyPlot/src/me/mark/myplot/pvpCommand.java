package me.mark.myplot;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class pvpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
		
		
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			String rank = Listiner.getRank(player);
			
			if (rank.equals("owner") || rank.equals("coowner") || rank.equals("admin") || player.isOp()) {
				
				for(ProtectedRegion region : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation())) {
					State state = region.getFlag(DefaultFlag.PVP);
						if (state == State.ALLOW || state == null) {
							region.setFlag (DefaultFlag.PVP, State.DENY);
							player.sendMessage(ChatColor.GREEN + "PVP now disabled in " + ChatColor.GRAY + region.getId() + "'s" + ChatColor.GREEN + " realm");
						} else {
							region.setFlag (DefaultFlag.PVP, State.ALLOW);
							player.sendMessage(ChatColor.GREEN + "PVP now enabled in " + ChatColor.GRAY + region.getId() + "'s" + ChatColor.GREEN + " realm");
						}
						
						return true;
				}
				player.sendMessage(ChatColor.RED + "You'r not in a realm..");
				
			}
			
			
		}
		
		return true;
	}
	
	public String getRealm(Player player) {
		for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()))
			return r.getId();
	return null;	
	}
	
	
}
