package me.Meatie.Command;

import me.Meatie.Data.PrivacyData;
import me.Meatie.Data.RankData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PrivacyCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length == 1) {
			
			if (args[0].equalsIgnoreCase("public") || args[0].equalsIgnoreCase("rank") || args[0].equalsIgnoreCase("private")) {
				PrivacyData.save(sender, args[0].toLowerCase());
				//TODO Test /privacy and kicking players that arn't rank or world owner.
				clear(sender.getName(), args[0]);
			sender.sendMessage(ChatColor.GREEN + "You'r World's Privacy Is Now: " + ChatColor.RED + args[0]);
			} else sender.sendMessage(ChatColor.RED + "/privacy " + ChatColor.GREEN +  "public" + ChatColor.RED + " - " + ChatColor.GREEN + "rank" + ChatColor.RED + " - " + ChatColor.GREEN + "private");
		} else {
			sender.sendMessage(ChatColor.RED + "/privacy " + ChatColor.GREEN +  "public" + ChatColor.RED + " - " + ChatColor.GREEN + "rank" + ChatColor.RED + " - " + ChatColor.GREEN + "private");
		
		if (PrivacyData.read(sender.getName()) != "null")
			sender.sendMessage(ChatColor.RED + "You'r World's Privacy Is " + ChatColor.GREEN + PrivacyData.read(sender.getName()));
			else sender.sendMessage(ChatColor.RED + "You'r World's Privacy Is " + ChatColor.GREEN + "public");
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void clear(String world, String type) {
		
		if (type.equalsIgnoreCase("public")) return;
		
		for (Player p : Bukkit.getOnlinePlayers())
			if (p.getWorld().getName().equals(world)) {
				
			if (type.equalsIgnoreCase("private"))
			if (!p.getName().equals(world))
			p.teleport(Bukkit.getWorld("world").getSpawnLocation());	
				
			if (type.equalsIgnoreCase("rank"))
			if (RankData.check(world, p.getName(), null))
			p.teleport(Bukkit.getWorld("world").getSpawnLocation());
			}
	}
	
}
