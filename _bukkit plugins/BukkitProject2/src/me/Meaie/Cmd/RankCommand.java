package me.Meaie.Cmd;

import me.Meatie.Project2.RankData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length == 2) {
			
			if (args[1].equalsIgnoreCase("guest") || args[1].equalsIgnoreCase("builder") || args[1].equalsIgnoreCase("mod") || args[1].equalsIgnoreCase("admin")) {
				if (online(args[0]) != null) {
					Player target = online(args[0]);
					RankData.save(args[0], args[1]);
					sender.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.RED +  " is now " + ChatColor.GREEN + args[1] + ChatColor.RED + " in you'r world.");
				} else sender.sendMessage(ChatColor.RED + args[0] + " isn't online.");
			} else sender.sendMessage(ChatColor.RED + "/rank"  + ChatColor.GRAY + " player " + ChatColor.GREEN +  "guest" + ChatColor.RED + " - " + ChatColor.GREEN + "builder"  + ChatColor.RED + " - " + ChatColor.GREEN + "trusted" + ChatColor.RED + " - " + ChatColor.GREEN + "mod"
					 + ChatColor.RED + " - " + ChatColor.GREEN + "admin");
		} else sender.sendMessage(ChatColor.RED + "/rank"  + ChatColor.GRAY + " player " + ChatColor.GREEN +  "guest" + ChatColor.RED + " - " + ChatColor.GREEN + "builder"  + ChatColor.RED + " - " + ChatColor.GREEN + "trusted" + ChatColor.RED + " - " + ChatColor.GREEN + "mod"
				 + ChatColor.RED + " - " + ChatColor.GREEN + "admin");
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public static Player online(String player) {
		for (Player p : Bukkit.getOnlinePlayers())
		if (p.getName().toLowerCase().startsWith(player.toLowerCase()))
			return p;
		return null;
	}
	
}