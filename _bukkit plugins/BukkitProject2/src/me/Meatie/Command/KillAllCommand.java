package me.Meatie.Command;

import me.Meaie.Cmd.Msg;
import me.Meatie.Data.RankData;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class KillAllCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		if (RankData.check(player.getWorld().getName(), player.getName(), "admin")) {
			
			int count = 0;
			
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("*")) {
					for (Entity entitie: player.getWorld().getEntities()) {
						EntityType type = entitie.getType();
					if (type != EntityType.ENDER_CRYSTAL && type != EntityType.ITEM_FRAME
					&& type != EntityType.LEASH_HITCH && type != EntityType.PAINTING && type != EntityType.PLAYER && type != EntityType.WEATHER) {
						count++;
	                entitie.remove();
					}
					}
					sender.sendMessage(ChatColor.GREEN + "Removed* " + ChatColor.RED + count + ChatColor.GREEN + " Things From World.");
					return true;
				}
				if (args[0].equalsIgnoreCase("**")) {
					for (Entity entitie: player.getWorld().getEntities()) {
						EntityType type = entitie.getType();
					if (type != EntityType.PLAYER && type != EntityType.WEATHER) {
						count++;
	                entitie.remove();
					}
					}
					sender.sendMessage(ChatColor.GREEN + "Removed** " + ChatColor.RED + count + ChatColor.GREEN + " Things From World.");
					return true;
				}
			}
			
			for (Entity entitie: player.getWorld().getEntities()) {
				EntityType type = entitie.getType();
				
				if (type != EntityType.BOAT && type != EntityType.ENDER_CRYSTAL && type != EntityType.ENDER_DRAGON && type != EntityType.ITEM_FRAME
						 && type != EntityType.LEASH_HITCH && type != EntityType.MINECART  && type != EntityType.MINECART_CHEST && type != EntityType.MINECART_COMMAND
						 && type != EntityType.MINECART_FURNACE && type != EntityType.MINECART_HOPPER && type != EntityType.MINECART_MOB_SPAWNER
						 && type != EntityType.MINECART_TNT && type != EntityType.PAINTING && type != EntityType.PLAYER && type != EntityType.WITHER
						 && type != EntityType.WOLF && type != EntityType.WEATHER) {
					count++;
                entitie.remove();
				}
		}
			sender.sendMessage(ChatColor.GREEN + "Removed " + ChatColor.RED + count + ChatColor.GREEN + " Things From World.");
		} else Msg.notallowed(sender);
	}
		return true;
	}
	
}
