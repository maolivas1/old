package me.Meatie.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {	
		Player player = (Player)sender;
		
		if (!player.hasPermission("meatie.heal")) {
			player.sendMessage("Not Allowed.");
			return true;
		}
		
		player.setHealth(20);
		player.setFoodLevel(20);
		player.setSaturation(20);
		player.setFireTicks(0);
		
		}
		return true;
	}
}
