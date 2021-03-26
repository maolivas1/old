package me.Mark.stuff;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class helpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		sender.sendMessage(ChatColor.GREEN + "/tell, /inspect, /hat, /nick, /mail");
		
		return true;
	}	
}