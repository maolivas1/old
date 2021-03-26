package me.Meatie.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TopCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		if (!player.hasPermission("meatie.top")) {
			player.sendMessage("Not Allowed.");
			return true;
		}
		
		player.teleport(player.getWorld().getHighestBlockAt(player.getLocation()).getLocation());
		
		}
		return true;
	}
}
