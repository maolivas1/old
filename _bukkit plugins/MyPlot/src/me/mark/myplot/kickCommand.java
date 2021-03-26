package me.mark.myplot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kickCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (Listiner.getRank(player).equals("owner") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("admin")) {
				if (args.length == 1) {
					for (Player p : Bukkit.getOnlinePlayers()) {
						if (args[0].equalsIgnoreCase(p.getName())) {
						if (Listiner.getRealm(p).equals(Listiner.getRealm(player))) {
							
							if (Listiner.getRank(p).equals("owner")) {
								player.sendMessage(ChatColor.RED + "Can't kick realm owner!");
								return true;
							}
							if (Listiner.getRank(p).equals("coowner") && !Listiner.getRank(player).equals("owner")) {
								player.sendMessage(ChatColor.RED + "You can't kick Co-Owners!");
								return true;
							}
							if (Listiner.getRank(p).equals("admin") && !Listiner.getRank(player).equals("owner")  && !Listiner.getRank(player).equals("coowner")) {
								player.sendMessage(ChatColor.RED + "You can't kick Co-Owners!");
								return true;
							}
							if (Listiner.getRank(p).equals("mod") && !Listiner.getRank(player).equals("owner") && !Listiner.getRank(player).equals("coowner") && !Listiner.getRank(player).equals("admin")) {
								player.sendMessage(ChatColor.RED + "You can't kick Moderators!");
								return true;
							}
							
							player.sendMessage(ChatColor.GREEN + "Kicked " + ChatColor.GRAY + p.getName() + ChatColor.GREEN + " from " + ChatColor.GRAY + Listiner.getRealm(player) + "'s" + ChatColor.GREEN + " realm");
							p.sendMessage(ChatColor.RED + "Kicked from " + ChatColor.GRAY + Listiner.getRealm(player) + ChatColor.RED + "'s realm!");
							p.teleport(Bukkit.getWorld("plotworld").getSpawnLocation());
							
						} else player.sendMessage(ChatColor.GRAY + args[0] + ChatColor.RED + " isn't currently in this realm.");
						return true;
						}
					}
					player.sendMessage(ChatColor.GRAY + args[0] + ChatColor.RED + " isn't currently in this realm.");
				} else player.sendMessage(ChatColor.GREEN + "/kick " + ChatColor.GRAY + "player");
			} else player.sendMessage(ChatColor.RED + "You Must be Mod or higher to do this!");
		}
		
		return true;
	}
	
	
}
