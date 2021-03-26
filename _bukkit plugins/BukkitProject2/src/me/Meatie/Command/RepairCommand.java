package me.Meatie.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepairCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		if (player.getItemInHand() != null)
			player.getItemInHand().setDurability((short) 0);
		
		}
		return true;
	}
}
