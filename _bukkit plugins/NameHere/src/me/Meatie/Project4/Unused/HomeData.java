package me.Meatie.Project4.Unused;

import java.io.File;

import me.Meatie.Project2.Main;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class HomeData {
	
	public static void save(Player player, String home) {
		 try {
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "homes.yml"));
			 String user = player.getName();
			 Location loc = player.getLocation();
		        c.set(Main.type + "." + user + "." + home + ".world", loc.getWorld().getName());
		        c.set(Main.type + "." + user + "." + home + ".x", loc.getX());
		        c.set(Main.type + "." + user + "." + home + ".y", loc.getY());
		        c.set(Main.type + "." + user + "." + home + ".z", loc.getZ());
		        c.set(Main.type + "." + user + "." + home + ".yaw", loc.getYaw());
		        c.set(Main.type + "." + user + "." + home + ".pitch", loc.getPitch());
		        c.save(new File(Main.dir, "homes.yml"));
		    } catch (Exception e) {}
	}
	
	public static Location read(Player player, String home) {
		try {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "homes.yml"));
        String user = player.getName();
        World world = Bukkit.getWorld(c.get(Main.type + "." + user + "." + home + ".world").toString());
        double x = Double.parseDouble(c.get(Main.type + "." + user + "." + home + ".x").toString());
        double y = Double.parseDouble(c.get(Main.type + "." + user + "." + home + ".y").toString());
        double z = Double.parseDouble(c.get(Main.type + "." + user + "." + home + ".z").toString());
        float yaw = Float.parseFloat(c.get(Main.type + "." + user + "." + home + ".yaw").toString());
        float pitch = Float.parseFloat(c.get(Main.type + "." + user + "." + home + ".pitch").toString());
        
        Location loc = new Location(world, x, y, z);
	    loc.setPitch(pitch);
	    loc.setYaw(yaw);
		return loc;
    } catch (Exception e) {}
		return null;
	}
	
	public static void delete(Player player, String home) {
		 try {
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "homes.yml"));
			 String user = player.getName();
		        c.set(Main.type + "." + user + "." + home, null);
		        c.save(new File(Main.dir, "homes.yml"));
		    } catch (Exception e) {}
	}
	
	public static String list(Player player) {
		YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "homes.yml"));
		String list = "";
		for(String key : c.getKeys(false))
			if (key.startsWith(player.getName()))
			  if (list == "") list = key;
			else list = list + ChatColor.GREEN + ", " + ChatColor.WHITE + key;
		return list;
	}
	
}
