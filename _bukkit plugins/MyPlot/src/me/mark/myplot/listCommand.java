package me.mark.myplot;

import me.mark.api.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class listCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
		
		
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			
			String realm = getRealm(player);
			if (realm.equals(null)) {
				player.sendMessage(ChatColor.RED + "You're not in a realm..");
				return true;
			}
			
			String r = Config.getrank(player.getName(), realm);
			r = r.substring(0, 1).toUpperCase() + r.substring(1);
			r = r.replace("Coowner", "Co-Owner");
			FancyMessage m = new FancyMessage(player.getName()).color(ChatColor.BLUE).tooltip(r);
			
			for (Player p : Bukkit.getOnlinePlayers())
				if (realm.equals(getRealm(p)))
					if (p != player) {
						String rank = Config.getrank(p.getName(), realm);
						rank = rank.substring(0, 1).toUpperCase() + rank.substring(1);
					m.then(", ").color(ChatColor.WHITE).then(p.getName()).color(ChatColor.BLUE).tooltip(rank);
					}
			
			m.send(player);
			
		}
		
		return true;
	}
	
	public String getRealm(Player player) {
		for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()))
			return r.getId();
	return null;	
	}
	
	
}
