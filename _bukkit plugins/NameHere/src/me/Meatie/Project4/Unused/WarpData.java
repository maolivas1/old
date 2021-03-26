package me.Meatie.Project4.Unused;

import java.io.File;

import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

public class WarpData {
	
	public static void save(String warp, Location loc) {
		 try {
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "warps.yml"));
		        c.set(Main.type + "." + warp + ".world", loc.getWorld().getName());
		        c.set(Main.type + "." + warp + ".x", loc.getX());
		        c.set(Main.type + "." + warp + ".y", loc.getY());
		        c.set(Main.type + "." + warp + ".z", loc.getZ());
		        c.set(Main.type + "." + warp + ".yaw", loc.getYaw());
		        c.set(Main.type + "." + warp + ".pitch", loc.getPitch());
		        c.save(new File(Main.dir, "warps.yml"));
		    } catch (Exception e) {}
	}
	
	public static Location read(String warp) {
		try {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "warps.yml"));
        
        World world = Bukkit.getWorld(c.get(Main.type + "." + warp + ".world").toString());
        double x = Double.parseDouble(c.get(Main.type + "." + warp + ".x").toString());
        double y = Double.parseDouble(c.get(Main.type + "." + warp + ".y").toString());
        double z = Double.parseDouble(c.get(Main.type + "." + warp + ".z").toString());
        float yaw = Float.parseFloat(c.get(Main.type + "." + warp + ".yaw").toString());
        float pitch = Float.parseFloat(c.get(Main.type + "." + warp + ".pitch").toString());
        
        Location loc = new Location(world, x, y, z);
	    loc.setPitch(pitch);
	    loc.setYaw(yaw);
		return loc;
		
    } catch (Exception e) {}
		return null;
	}
	
	public static void delete(String warp) {
		 try {
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "warps.yml"));
		        c.set(Main.type + "." + warp, null);
		        c.save(new File(Main.dir, "warps.yml"));
		    } catch (Exception e) {}
	}
	
}
