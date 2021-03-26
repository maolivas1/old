package me.Meaie.Cmd;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		sender.sendMessage(ChatColor.GREEN + "/home " + ChatColor.GRAY + "Teleport to you'r world");
		sender.sendMessage(ChatColor.GREEN + "/privacy " + ChatColor.GRAY + "Set you'r world privacy");
		sender.sendMessage(ChatColor.GREEN + "/rank " + ChatColor.GRAY + "Rank someone in you'r world");
		sender.sendMessage(ChatColor.GREEN + "/spawn " + ChatColor.GRAY + "Teleport to main spawn");
		sender.sendMessage(ChatColor.GREEN + "/tp " + ChatColor.GRAY + "Teleport to a player");
		sender.sendMessage(ChatColor.GREEN + "/world " + ChatColor.GRAY + "Teleport to a world");
		
		return true;
	}
	
}
