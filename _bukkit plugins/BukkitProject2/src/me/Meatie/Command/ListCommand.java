package me.Meatie.Command;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ListCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
			String list = "";
			for (Player p : Bukkit.getOnlinePlayers())
			list = p.getName() + " " + list;
			sender.sendMessage(ChatColor.YELLOW + list);
			
		return true;
	}
}
