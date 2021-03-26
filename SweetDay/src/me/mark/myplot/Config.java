package me.mark.myplot;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class Config {
	
	public static void setspawn(String arena, String num, Location loc) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/SweetDay/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "spawns.yml"));
			 c.set(arena + "." + num + ".x", loc.getX());
			 c.set(arena + "." +num + ".y", loc.getY());
			 c.set(arena + "." +num + ".z", loc.getZ());
			 c.set(arena + "." +num + ".yaw", loc.getYaw());
			 c.set(arena + "." +num + ".pitch", loc.getPitch());
	         c.save(new File(file, "spawns.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static Location getspawn(String arena, String num) {
		Location loc = null;
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/SweetDay/", "spawns.yml"));
	        if (c.contains(arena + "." +num + ".x")) {
	        	double x = Double.valueOf(c.get(arena + "." +num + ".x").toString());
	        	double y = Double.valueOf(c.get(arena + "." +num + ".y").toString());
	        	double z = Double.valueOf(c.get(arena + "." +num + ".z").toString());
	        	float yaw = Float.valueOf(c.get(arena + "." +num + ".yaw").toString());
	        	float pitch = Float.valueOf(c.get(arena + "." +num + ".pitch").toString());
	        	loc = new Location(Bukkit.getWorld("world"), x, y, z);
	        	loc.setYaw(yaw);
	        	loc.setPitch(pitch);
		        return loc;
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return loc;
	}

}
