package me.Meatie.swan;

import java.util.ArrayList;

import me.Meatie.Project2.ConfigData;
import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class muteCommand implements CommandExecutor {

	public static ArrayList<String> list = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (sender.hasPermission("meatie.mute")) {
		 if (args.length == 1) {
		 for (OfflinePlayer p: Bukkit.getOfflinePlayers())
			 if (p.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
				 
				 if (list.contains(p.getName())) {
					 list.remove(p.getName());
					 ConfigData.saveunMute(p.getName());
					 Bukkit.broadcastMessage(Fix.format("&a" + p.getName() + " &cunMuted"));
					 return true;
				 }
				 
				 ConfigData.saveMute(p.getName());
				 list.add(p.getName());
				 Bukkit.broadcastMessage(Fix.format("&a" + p.getName() + " &cMuted"));
				 return true;
			 }
			 sender.sendMessage(ChatColor.RED + "Unknown Player");
		 } else sender.sendMessage(ChatColor.RED + "/mute " + ChatColor.GRAY + "player");
		 } else sender.sendMessage(ChatColor.RED + "Ur Not Allowed.");
		return true;
	}
	
}