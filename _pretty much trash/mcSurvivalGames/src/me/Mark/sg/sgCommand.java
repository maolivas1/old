package me.Mark.sg;

import java.util.ArrayList;
import java.util.Set;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class sgCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (args.length == 0) {
				player.sendMessage("/sg join");
				player.sendMessage("/sg leave");
				player.sendMessage("/sg start");
			}   else if (args[0].equalsIgnoreCase("join")) {
					if (!events.active) {
						
						if (!emptyInv(player)) player.sendMessage(ChatColor.DARK_RED + "I'e recomend emptying you're inv before you join next time...");
						
						ArrayList<Location> spawns = ConfigStuff.get("spawns");
						Location loc = (Location) spawns.toArray()[events.inGame.size()];
						player.teleport(loc);
						events.inGame.add(player.getName());
						events.alert(ChatColor.GREEN + player.getName() + " Joined the game!");
						player.setGameMode(GameMode.SURVIVAL);
					} else player.sendMessage(ChatColor.RED + "Game Currently Active");
					
				} else if (args[0].equalsIgnoreCase("leave")) {
					player.teleport(Bukkit.getWorld("world").getSpawnLocation());
					events.alert(ChatColor.RED + player.getName() + " Left the game!");
					events.inGame.remove(player.getName());
					events.check();
				} else if (args[0].equalsIgnoreCase("start")) {
					if (events.inGame.size() > 1) {
						events.active = true;
						events.fillChest();
						events.alert(ChatColor.GREEN + " Game Starting!");
					} else player.sendMessage(ChatColor.RED + "Bruh... you guna fight yourself?");
				}
			
			
			if (player.isOp()) {
			if (args.length == 0) {
				player.sendMessage("/sg addChest");
				player.sendMessage("/sg addSpawn");
				player.sendMessage("/sg resetChests");
				player.sendMessage("/sg resetSpawns");
				player.sendMessage("/sg end - ends current round and resets stuff");
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("addchest")) {
					Location loc = player.getTargetBlock((Set<Material>) null, 100).getLocation();
					ConfigStuff.add("chests", loc);
					player.sendMessage(ChatColor.GREEN + "Added Chest: " + loc.getX() + " " + loc.getY() + " " + loc.getZ());
				} else if (args[0].equalsIgnoreCase("addSpawn")) {
					Location loc = player.getLocation();
					ConfigStuff.add("spawns", loc);
					player.sendMessage(ChatColor.GREEN + "Added Spawn: " + loc.getX() + " " + loc.getY() + " " + loc.getZ());
				} else if (args[0].equalsIgnoreCase("resetchests")) {
					ConfigStuff.add("chests", null);
					player.sendMessage(ChatColor.RED + "Chest Locations Reset");
				} else if (args[0].equalsIgnoreCase("resetspawns")) {
					ConfigStuff.add("spawns", null);
					player.sendMessage(ChatColor.RED + "Spawn Locations Reset");
				} else if (args[0].equalsIgnoreCase("end")) {
					events.alert(ChatColor.DARK_PURPLE + "Game Forcefully ended");
					player.sendMessage(ChatColor.DARK_PURPLE + "Game Forcefully ended");
					events.active = false;
					for (String p : events.inGame) {
						events.inGame.remove(p);
						Bukkit.getPlayer(p).teleport(Bukkit.getWorld("world").getSpawnLocation());
					}
				}
			}
			}
		}
		
		return true;
	}

	public boolean emptyInv(Player player) {
		for(ItemStack item : player.getInventory().getContents())
		    if(item != null) return false;
		return true;
	}
	
	
	
}
