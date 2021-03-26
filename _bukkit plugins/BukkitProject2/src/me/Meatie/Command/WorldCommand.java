package me.Meatie.Command;

import java.io.File;

import me.Meaie.Cmd.Msg;
import me.Meatie.Data.BanData;
import me.Meatie.Data.PrivacyData;
import me.Meatie.Data.RankData;
import me.Meatie.Listiner.Fix;
import me.Meatie.Listiner.LoadWorld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorldCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String cmd = command.getName();
		
		if (cmd.equalsIgnoreCase("createworld")) {

			//Check If World Alrety Exsists
			if (exists(args[0])) {
				sender.sendMessage(ChatColor.RED + "World Alrety Exsists");
				return true;
			}
			
			//If Player Is Op
			if (!op(sender)) {
				Msg.notallowed(sender);
				return true;
			}
			
			if (args.length == 2) {
				
				WorldCreator worldCreator = new WorldCreator(args[0]);
				worldCreator.generateStructures(false);
				
				String type = args[1];
				if (type.equalsIgnoreCase("flat"))
				worldCreator.type(WorldType.FLAT);
				else if (type.equalsIgnoreCase("normal"))
				worldCreator.type(WorldType.NORMAL);
				else {
					sender.sendMessage(ChatColor.RED + "/createworld name" + ChatColor.GREEN + "flat / normal");
					return true;
				}
				
				Bukkit.getServer().createWorld(worldCreator);
				
				sender.sendMessage("Creating World: " + args[0] + " " + type.toLowerCase());
				
			} else return false;
		
		} else if (cmd.equalsIgnoreCase("world")) {
			
			if (sender instanceof Player) {
				Player player = (Player)sender;
				if (args.length == 1) {
					
					//If Dosn't World Exist
					if (!exists(args[0])) {
						sender.sendMessage(ChatColor.RED + "Unknown World... " + args[0]);
						return true;
					}
					
						//Privacy Stuff
					 if (PrivacyData.read(args[0]).equals("rank")) {
						 if (RankData.check(args[0], sender.getName(), null)) {
						//if (RankData.read(sender, args[0]) == null) {
							if (!sender.getName().toLowerCase().equals(args[0].toLowerCase())) {
							sender.sendMessage(ChatColor.RED + args[0] + "'s World Is Rank Only.");
							if (!op(sender))
							return true;
							}
						}
					} else if (PrivacyData.read(args[0]).equals("private")) {
						if (!sender.getName().toLowerCase().equals(args[0].toLowerCase())) {
							sender.sendMessage(ChatColor.RED + args[0] + "'s World Is Private.");
							if (!op(sender))
							return true;
						}
					}
					
					 //If player's banned
					 if (BanData.read(args[0], sender.getName())) {
						 sender.sendMessage(ChatColor.RED + "You'r Banned From That World.");
						 return true;
					 }
					 
					//Load World If Its Unloaded
					if (!loaded(args[0])) {
						load(args[0]);
					}
					
				     	Fix.tp(Bukkit.getWorld(args[0]).getSpawnLocation(), player);
						//player.teleport(Bukkit.getWorld(args[0]).getSpawnLocation());
						sender.sendMessage(ChatColor.GREEN + "Welcome to " + ChatColor.RED + args[0] + ChatColor.GREEN + "'s world.");
					} else sender.sendMessage(ChatColor.RED + "/world " + ChatColor.GRAY + "world");
			} else sender.sendMessage(ChatColor.RED + "Sorry Console, Not Today...");
		} else return false;
		
		return true;
	}
	
	public boolean op (CommandSender sender) {
		if (sender instanceof Player) {
			  Player player = (Player) sender;
			  if (player.isOp())
				  return true;
		}
		return false;
	}
	
	public static boolean exists(String world) {
		File file = new File(System.getProperty("user.dir") + "/" + world);
		if(file.exists())
			return true;
		return false;
	}
	
	public static boolean loaded(String world) {
		for(World w: Bukkit.getServer().getWorlds()) {
		  if(w.getName().equals(world))
		return true;
		}
		return false;
	}
	public static void load(String world) {
		if (exists(world)) {
	    LoadWorld.load(world);
		WorldCreator worldCreator = new WorldCreator(world);
		Bukkit.getServer().createWorld(worldCreator);
		}
	}
	
}
