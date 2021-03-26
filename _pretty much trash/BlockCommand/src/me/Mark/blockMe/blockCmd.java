package me.Mark.blockMe;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class blockCmd implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (player.isOp())
			if (args.length >= 1)
				for (OfflinePlayer p : Bukkit.getOfflinePlayers())
					if (p.getName().equalsIgnoreCase(args[0])) {
						
						if (BlockMe.cmds.contains(args[1])) {
							ConfigStuff.setRestricted(p.getUniqueId(), false);
							player.sendMessage(ChatColor.GREEN + p.getName() + " Is No Longer Restricted.");
							if (AntiRetard.list.contains(player.getUniqueId().toString()))
								AntiRetard.list.remove(player.getUniqueId().toString());
						} else {
						ConfigStuff.setRestricted(p.getUniqueId(), true);
						player.sendMessage(ChatColor.GREEN + p.getName() + " Is Now Restricted.");
						AntiRetard.list.add(player.getUniqueId().toString());
						}
					}
			sender.sendMessage(ChatColor.RED + "Couldnt Find Player");
		}
		
		return true;
	}
	
	
	
	
}
