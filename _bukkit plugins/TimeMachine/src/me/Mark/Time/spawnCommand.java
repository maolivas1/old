package me.Mark.Time;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if(sender instanceof Player){
		        Player player = (Player) sender;
				 player.teleport(player.getWorld().getSpawnLocation());
		    }
		return true;
	}
	
}
