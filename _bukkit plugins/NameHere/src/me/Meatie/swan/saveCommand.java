package me.Meatie.swan;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class saveCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
		 Commands.sendmsg(sender, "&dServer Saved!");
		return true;
	}
	
}