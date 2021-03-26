package me.Meatie.swan;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class hubCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if(sender instanceof Player){
		        Player player = (Player) sender;
		        for (World w : Bukkit.getWorlds())
		        	if (w.getName().equals("hubworld")) {
		        		player.teleport(w.getSpawnLocation());
		        	return true;	
		        	}
				 
		    }
		return true;
	}
	
}
