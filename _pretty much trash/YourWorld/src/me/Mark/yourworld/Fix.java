package me.Mark.yourworld;

import java.io.File;

import me.Mark.filestuff.DataStuff;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

public class Fix {
	
	public static String format(String input) {
		return ChatColor.translateAlternateColorCodes('&',input);
	}
	
	public static boolean isLoaded(String world) {
		for (World w : Bukkit.getWorlds())
			if (w.getName().equals(world))
				return true;
		return false;
	}
	
	public static World getWorld(String world) {
		for (World w : Bukkit.getWorlds())
			if (w.getName().equalsIgnoreCase(world))
				return w;
		return Bukkit.getWorld("world");
	}
	
	public static boolean isCreated(String world) {
		File f = new File(System.getProperty("user.dir") + "/" + world + "/");
		if(f.exists())
		    return true;
		return false;
	}
	
	public static void load(String world) {
		if (isCreated(world))
			if (!isLoaded(world))
				Bukkit.createWorld(new WorldCreator(world));
	}
	
	public static void createWorld(String name, String type) {
		if (type.equals("default")) {
			Bukkit.createWorld(new WorldCreator(name));
		} else if (type.equals("flat")) {
			WorldCreator creator = new WorldCreator(name + "_FLAT");
			creator.type(WorldType.FLAT);
			Bukkit.createWorld(creator);
		}
		fixSpawn(name);
	}
	
	public static void debug(String msg) {
		Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "[Debug] " + msg);
	}
	
	public static void fixSpawn(String Wname) {
		World world = getWorld(Wname);
		Location loc = world.getSpawnLocation();
		int y = world.getHighestBlockAt(loc).getY();
		Fix.getWorld(Wname).setSpawnLocation((int)loc.getX(), y + 1, (int)loc.getZ());
	}
	
	public static void safeTpWorld(Player player, String world, boolean spawn) {
		 if (!isLoaded(world))
			 load(world);
		 if (spawn == true) {
			player.teleport(Bukkit.getWorld(world).getSpawnLocation());
		 } else {
			 player.teleport(DataStuff.getLoc(player.getName(), world));
		 }
	}
	
	public static void safeTp(Player player, Location loc) {
		String world = loc.getWorld().getName();
		 if (!isLoaded(world))
			 load(world);
			player.teleport(loc);
	}
	
}
