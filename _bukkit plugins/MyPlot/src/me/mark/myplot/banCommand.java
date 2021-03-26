package me.mark.myplot;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.object.Plot;
public class banCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (Listiner.getRank(player).equals("owner") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("admin")) {
				if (args.length == 1) {
					
					
				    final Plot plot = (Plot) PS.get().IMP.wrapPlayer(player).getCurrentPlot();
					String realm = "";
		        	for (UUID owners : plot.getOwners())
		        		realm = Bukkit.getServer().getOfflinePlayer(owners).getName();
		        	
		        	for (OfflinePlayer pl : Bukkit.getOfflinePlayers()) {
		        		if (pl.getName().equalsIgnoreCase(args[0])) {
		        			
		        			
				
							
							if (Listiner.getRank(args[0], player.getLocation()).equals("owner")) {
								player.sendMessage(ChatColor.RED + "Can't ban realm owner!");
								return true;
							}
							if (Listiner.getRank(args[0], player.getLocation()).equals("coowner") && !Listiner.getRank(player).equals("owner")) {
								player.sendMessage(ChatColor.RED + "You can't ban Co-Owners!");
								return true;
							}
							if (Listiner.getRank(args[0], player.getLocation()).equals("admin") && !Listiner.getRank(player).equals("coowner")  && !Listiner.getRank(player).equals("owner")) {
								player.sendMessage(ChatColor.RED + "You can't ban Co-Owners!");
								return true;
							}
							if (Listiner.getRank(args[0], player.getLocation()).equals("mod") && !Listiner.getRank(player).equals("owner") && !Listiner.getRank(player).equals("coowner")  && !Listiner.getRank(player).equals("admin")) {
								player.sendMessage(ChatColor.RED + "You can't ban Moderators!");
								return true;
							}
							
							Config.setrank(args[0], realm, "banned");
							Config.delhome(args[0], realm);
							player.sendMessage(ChatColor.GREEN + "Banned " + ChatColor.GRAY + pl.getName() + ChatColor.GREEN + " from " + ChatColor.GRAY + realm + "'s" + ChatColor.GREEN + " realm");
							
							for (Player p : Bukkit.getOnlinePlayers())
								if (p.getName().equalsIgnoreCase(args[0])) {
									p.sendMessage(ChatColor.RED + "Banned from " + ChatColor.GRAY + realm + ChatColor.RED + "'s realm!");
									if (Listiner.getRealm(p).equals(Listiner.getRealm(player)))
										p.teleport(Bukkit.getWorld("plotworld").getSpawnLocation());
								}
							return true;
		        		}
		        	}
		        	player.sendMessage(ChatColor.RED + "Unknown player: " + ChatColor.GRAY + args[0]);
				} else player.sendMessage(ChatColor.GREEN + "/ban " + ChatColor.GRAY + "player");
			} else player.sendMessage(ChatColor.RED + "You Must be Mod or higher to do this!");
		}
		
		return true;
	}
	
	
}
