package me.Mark.stuff;


import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class genCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if (sender.isOp()) {
			
			if (Bukkit.getOnlinePlayers().isEmpty()) {
				return true;
			}
			
			int max = 10;
			if (args.length >= 1){
				max = Integer.parseInt(args[0]);
			}
			
			int coal = 0;
			int iron = 0;
			int gold = 0;
			int redstone = 0;
			int lapis = 0;
			int diamond = 0;
			int emerald = 0;
			
			int count = 0;
			while (count != max) {
				count++;
				
				int x = rand(-233, -90);
				int y = rand(0, 71);
				int z = rand(149, 292);
				Block block = new Location(Bukkit.getWorld("world"), x, y, z).getBlock();
				if (block.getType() == Material.STONE) {
				Material ore = ore();
				block.setType(ore);
				System.out.println(x + " " + y + " " + z + " " + ore);
				if (ore == Material.COAL_ORE) coal++;
				else if (ore == Material.IRON_ORE) iron++;
				else if (ore == Material.GOLD_ORE) gold++;
				else if (ore == Material.REDSTONE_ORE) redstone++;
				else if (ore == Material.LAPIS_ORE) lapis++;
				else if (ore == Material.DIAMOND_ORE) diamond++;
				else if (ore == Material.EMERALD_ORE) emerald++;
				}
			}
			
			if (coal != 0) sender.sendMessage(ChatColor.RED + "" + coal + ChatColor.GREEN + " Coal");
			if (iron != 0) sender.sendMessage(ChatColor.RED + "" + iron + ChatColor.GREEN + " Iron");
			if (gold != 0) sender.sendMessage(ChatColor.RED + "" + gold + ChatColor.GREEN + " Gold");
			if (redstone != 0) sender.sendMessage(ChatColor.RED + "" + redstone + ChatColor.GREEN + " Redstone");
			if (lapis != 0) sender.sendMessage(ChatColor.RED + "" + lapis + ChatColor.GREEN + " Lapis");
			if (diamond != 0) sender.sendMessage(ChatColor.RED + "" + diamond + ChatColor.GREEN + " Diamond");
			if (emerald != 0) sender.sendMessage(ChatColor.RED + "" + emerald + ChatColor.GREEN + " Emerald");
			
		} else {
			sender.sendMessage(ChatColor.RED + " Ur Not Allowed!");
		}
		
		
		return true;
	}
	
	
	public static int rand(int min, int max) {
	    return new Random().nextInt((max - min) + 1) + min;
	}
	
	public static Material ore() {
		int num = rand(1, 100);
		if (num < 23) return Material.COAL_ORE;//23
		else if (num < 41) return Material.IRON_ORE;//18
		else if (num < 54) return Material.GOLD_ORE;//13
		else if (num < 72) return Material.REDSTONE_ORE;//18
		else if (num < 84) return Material.LAPIS_ORE;//12
		else if (num < 93) return Material.DIAMOND_ORE;//9
		else if (num < 100) return Material.EMERALD_ORE;//7
		return Material.EMERALD_ORE;
	}
	
	
	
	
}
