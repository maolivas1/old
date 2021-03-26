package me.Meatie.swan;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setwarpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player){
	        Player player = (Player) sender;
		player.chat("/essentials:setwarp "  + player.getName());
		}
		
		return true;
	}
}
