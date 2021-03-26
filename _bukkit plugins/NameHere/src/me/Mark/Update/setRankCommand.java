package me.Mark.Update;

import me.Meatie.Project2.Fix;
import me.Meatie.Project2.PermsConfig;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class setRankCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (!sender.isOp()) return true;
				 if (args.length >= 2) {
					 for (OfflinePlayer p : Bukkit.getOfflinePlayers())
						 if (p.getName().equalsIgnoreCase(args[0])) {
							 PermsConfig.saveRank(p.getName(), args[1]);
							 sender.sendMessage(ChatColor.RED + p.getName() + ChatColor.GRAY + " Is Now Rank " + ChatColor.GREEN + Fix.format(args[1]));
							 return true;
						 }
						 sender.sendMessage(ChatColor.RED + "Unknown Player");
				 } else sender.sendMessage(ChatColor.RED + "/setrank player rank");
		return true;
	}
}