package me.Meatie.Command;

import me.Meatie.Data.BanData;
import me.Meatie.Data.PrivacyData;
import me.Meatie.Data.RankData;
import me.Meatie.Listiner.Fix;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeleportCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			Player target;
			if (args.length == 1) {
				
				//If Player Exists
				if (online(args[0]) != null) {
				target = online(args[0]);
				} else {
					sender.sendMessage(ChatColor.RED + "Unknown Player..");
					return true;
				}
				
				//If World isn't Private
			 if (PrivacyData.read(target.getWorld().getName()).equals("private")) {
				if (!sender.getName().toLowerCase().equals(target.getWorld().getName().toLowerCase())) {
					sender.sendMessage(ChatColor.RED + target.getName() + " Is In A Private World.");
					return true;
				}
				} else
					//if World Isn't Rank-Only
			 if (PrivacyData.read(target.getWorld().getName()).equals("rank")) {
				 if (RankData.check(target.getWorld().getName(), sender.getName(), null)) {
					if (!sender.getName().toLowerCase().equals(target.getWorld().getName().toLowerCase())) {
						sender.sendMessage(ChatColor.RED + target.getName() + " Is In A Rank-Only World.");
						return true;
					}
				}
			 }
			 
			 //if player's banned
			 if (BanData.read(target.getWorld().getName(), target.getName())) {
				 sender.sendMessage(ChatColor.RED + "You'r Banned From That World.");
				 return true;
			 }
			 
				//What we'v all been waiting for :D
			 Fix.tp(target.getLocation(), player);
				//player.teleport(target.getLocation());
				sender.sendMessage(ChatColor.GREEN + "Teleported To " + ChatColor.RED + target.getName() + ChatColor.GREEN + ".");
			} else sender.sendMessage(ChatColor.RED + "/tp " + ChatColor.GRAY + "player");

		
		
		}
		return true;
	}
	@SuppressWarnings("deprecation")
	public static Player online(String player) {
		for (Player p : Bukkit.getOnlinePlayers()) {
		if (p.getName().toLowerCase().startsWith(player.toLowerCase()))
			return p;
		}
		return null;
	}
	
}
