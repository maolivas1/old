package me.Meatie.Command;

import me.Meatie.Listiner.Fix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TopCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		Fix.tp((player.getWorld().getHighestBlockAt(player.getLocation()).getLocation()), player);
		
		}
		return true;
	}
}
