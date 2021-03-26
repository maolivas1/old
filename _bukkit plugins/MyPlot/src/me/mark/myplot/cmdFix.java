package me.mark.myplot;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class cmdFix implements Listener {
	
	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if (player.isOp()) return;
		
		String[] args = event.getMessage().split(" ");
		String cmd = args[0].toLowerCase().replace("/", "");
		
		if (cmd.contains(":")) {
			player.sendMessage("Unknown command. Type 'help' for help.");
			event.setCancelled(true);
		}
		
		
		for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation())) {
			String region = r.getId();
			String rank = Config.getrank(player.getName(), region);
			
			//Gamemode
			if (cmd.equals("gamemode") || cmd.equals("adventure") || cmd.equals("creative") || cmd.equals("gm") || cmd.equals("gmc") || cmd.equals("gms") || cmd.equals("survival")) {
				if (!rank.equals("trusted") && !rank.equals("mod") && !rank.equals("coowner") && !rank.equals("owner") && !rank.equals("admin")) {
					player.sendMessage(ChatColor.RED + "Only Trusted and up can do that!");
					event.setCancelled(true);
					return;
				}

				if (!rank.equals("mod") && !rank.equals("coowner") && !rank.equals("owner")  && !rank.equals("admin")) {
					
					if (cmd.equals("adventure") || cmd.equals("creative") || cmd.equals("gm") || cmd.equals("gmc") || cmd.equals("gms") || cmd.equals("survival")) {
						if (args.length >= 2) {
							player.sendMessage(ChatColor.RED + "Only Mod and up can do that to others!");
							event.setCancelled(true);
							return;
						}
					}
					
					if (args.length >= 3) {
					player.sendMessage(ChatColor.RED + "Only Mod and up can do that to others!");
					event.setCancelled(true);
				}
				}
			}
		}
		
		
	}

}
