package me.Meatie.Command;

import me.Meatie.Listiner.Fix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HomeCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
			
		if (args.length == 0) {
			//If the world exists
			if (WorldCommand.exists(sender.getName())) {
				//Load the world if its not loaded
				if (!WorldCommand.loaded(sender.getName()))
					WorldCommand.load(sender.getName());
				
				Fix.tp(Bukkit.getWorld(sender.getName()).getSpawnLocation(), player);
				//player.teleport(Bukkit.getWorld(sender.getName()).getSpawnLocation());
				
			} else sender.sendMessage(ChatColor.RED + "/home " + ChatColor.GREEN + "normal" + ChatColor.RED +  " - " + ChatColor.GREEN +  "flat");
			
		} else if (args.length == 1) {
			
			WorldCreator worldCreator = new WorldCreator(sender.getName());
			worldCreator.generateStructures(false);
			String type = args[0];
			if (type.equalsIgnoreCase("flat"))
			worldCreator.type(WorldType.FLAT);
			else if (type.equalsIgnoreCase("normal"))
			worldCreator.type(WorldType.NORMAL);
			else {
			 sender.sendMessage(ChatColor.RED + "/home " + ChatColor.GREEN + "normal" + ChatColor.RED +  " - " + ChatColor.GREEN +  "flat");
				return true;
			}
			
			Bukkit.getServer().createWorld(worldCreator);
			
		}
		}
		
		
		return true;
	}
}
