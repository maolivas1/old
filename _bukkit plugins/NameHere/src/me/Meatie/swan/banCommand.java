package me.Meatie.swan;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class banCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (sender.hasPermission("meatie.ban.day")) {
		 if (args.length == 2) {
		 for (OfflinePlayer p: Bukkit.getOfflinePlayers())
			 if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
				 int time = 86401;
				 //1 Day = 86401 //1 Week = 604801
				 if (sender.hasPermission("meatie.ban.week")) time = 604801;
				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + p.getName() + " " + time + "Banned By " + sender.getName());
				 Bukkit.broadcastMessage(ChatColor.GRAY + sender.getName() + ChatColor.GREEN + " Banned " + ChatColor.GRAY + p.getName());
				 return true;
			 }
			 sender.sendMessage(ChatColor.RED + "Unknown Player");
		 } else sender.sendMessage(ChatColor.RED + "/ban " + ChatColor.GRAY + "player");
		 } else sender.sendMessage(ChatColor.RED + "Ur Not Allowed.");
		return true;
	}
	
}

//MoblieLiteG2
//Password123