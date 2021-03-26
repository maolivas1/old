package me.Mark.stuff;


import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;


public class mobCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if (sender.isOp()) {
			if (Bukkit.getOnlinePlayers().isEmpty()) {
				return true;
			}
			
			int max = 10;
			if (args.length >= 1){
				max = Integer.parseInt(args[0]);
			}
			
			int count = 0;
			while (count != max) {
				count++;
				
				int x = rand(-233, -90);
				int z = rand(149, 292);
				Location loc = new Location(Bukkit.getWorld("world"), x, 72, z);
				if (loc.getBlock().getType() == Material.AIR) {
				EntityType type = mob();
				
				loc.getWorld().spawnEntity(loc, type);
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + " Ur Not Allowed!");
		}
		
		
		return true;
	}
	
	
	public static int rand(int min, int max) {
	    return new Random().nextInt((max - min) + 1) + min;
	}
	
	public static EntityType mob() {
		int num = rand(1, 13);
		if (num == 1) return EntityType.BAT;
		else if (num == 2) return EntityType.CHICKEN;
		else if (num == 3) return EntityType.COW;
		else if (num == 4) return EntityType.MUSHROOM_COW;
		else if (num == 5) return EntityType.PIG;
		else if (num == 6) return EntityType.RABBIT;
		else if (num == 7) return EntityType.SHEEP;
		else if (num == 8) return EntityType.VILLAGER;
		else if (num == 9) return EntityType.HORSE;
		else if (num == 10) return EntityType.OCELOT;
		else if (num == 11) return EntityType.WOLF;
		else if (num == 12) return EntityType.IRON_GOLEM;
		else if (num == 13) return EntityType.SNOWMAN;
		return EntityType.COW;
	}
	
	
	
	
}
