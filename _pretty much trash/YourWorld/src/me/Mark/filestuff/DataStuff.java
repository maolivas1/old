package me.Mark.filestuff;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import me.Mark.yourworld.Fix;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class DataStuff {
	
	//Save world player logged out in
	 public static void saveWorld(Player player) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/YourWorld/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "current.yml"));
			 String name = player.getName();
			 String world = player.getLocation().getWorld().getName();
			 c.set(name, world);
	         c.save(new File(file, "current.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	    }
	 
	 //Get world player logged out in
		public static String getWorld(String player) {
			try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/YourWorld/", "current.yml"));
		        if (c.contains(player)) {
		        	String world = c.get(player).toString();
			        return world;
		        }
		    } catch (Exception e) {System.out.println(e.getMessage());}
			Fix.debug("Couldnt find world, sending to hub");
			return "default";
		}
	
	public static Location getLoc(String player, String w) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/YourWorld/", "loc.yml"));
	        
	        if (c.contains(player + "." + w + ".x")) {
	        	double x = Double.parseDouble(c.get(player + "." + w + ".x").toString());
	        	double y = Double.parseDouble(c.get(player + "." + w + ".y").toString());
	        	double z = Double.parseDouble(c.get(player + "." + w + ".z").toString());
	        	float yaw = Float.parseFloat(c.get(player + "." + w + ".yaw").toString());
	        	float pitch = Float.parseFloat(c.get(player + "." + w + ".pitch").toString());
	        	//If the world was deleted, tp them to spawn
	        	if (!Fix.isCreated(w))
	        		return Bukkit.getWorld("world").getSpawnLocation();
	        	//If World isn't loaded, load it
	        	else if (!Fix.isLoaded(w))
	        	Fix.load(w);
	        	
	        	Location loc = new Location(Bukkit.getWorld(w), x, y, z);
	        	loc.setYaw(yaw);
	        	loc.setPitch(pitch);
		        return loc;
	        }
	        //If the default thing isn't set send them to main world
	        if (player == "default")
	        return Bukkit.getWorld("world").getSpawnLocation();
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return getLoc("default", "world");
	}
	
	 public static void saveLoc(Player player) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/YourWorld/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "loc.yml"));
			 String name = player.getName();
			 Location loc = player.getLocation();
			 String world = loc.getWorld().getName();
			 //c.set(name + "." + world + ".world", loc.getWorld().getName());
			 c.set(name + "." + world + ".x", loc.getX());
			 c.set(name + "." + world + ".y", loc.getY());
			 c.set(name + "." + world + ".z", loc.getZ());
			 c.set(name + "." + world + ".yaw", loc.getYaw());
			 c.set(name + "." + world + ".pitch", loc.getPitch());
	         c.save(new File(file, "loc.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	    }
	 
	 public static void addWorld(String player, String world) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/YourWorld/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worlds.yml"));
			 c.set(player + "." + world, "true");
			 c.save(new File(file, "worlds.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	 }
	 
	 public static void delWorld(String player, String world) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/YourWorld/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worlds.yml"));
			 c.set(player + "." + world, null);
			 c.save(new File(file, "worlds.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	 }
	 
		public static ArrayList<String> getWorlds(String player) {
			ArrayList<String> list = new ArrayList<String>();
			try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/YourWorld/", "worlds.yml"));
		        
		        for(String world : c.getConfigurationSection(player).getKeys(false))
		        	list.add(world);
		        
		    } catch (Exception e) {System.out.println(e.getMessage());}
			return list;
		}
		
		 public static void saveWorldData(String world, HashMap<String, String> data) {
			 try {
				 File file = new File(System.getProperty("user.dir") + "/plugins/YourWorld/");
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worldData.yml"));
				 c.set(world + ".name", data.get("name"));
				 c.set(world + ".lore", data.get("lore"));
				 c.set(world + ".block", data.get("block"));
				 c.save(new File(file, "worldData.yml"));
		    } catch (Exception e) {System.out.println(e.getMessage());}
		 }
		 
			public static HashMap<String, String> getWorldData(String world) {
				HashMap<String, String> map = new HashMap<String, String>();
				try {
			        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/YourWorld/", "worldData.yml"));
			        
			        map.put("name", c.get(world + ".name").toString());
			        map.put("lore", c.get(world + ".lore").toString());
			        map.put("block", c.get(world + ".block").toString());
			        
			    } catch (Exception e) {System.out.println(e.getMessage());}
				return map;
			}
	
}
