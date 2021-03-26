package me.Meatie.Command;

import me.Meatie.Listiner.LoadWorld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class InfoCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		sender.sendMessage(ChatColor.GREEN + "List o' Ranks:");
		for (String name: LoadWorld.map.keySet())
            sender.sendMessage(name.toString() + " - " + LoadWorld.map.get(name).toString());
		return true;
	}
}
