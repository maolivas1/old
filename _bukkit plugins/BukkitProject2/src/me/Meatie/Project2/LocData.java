package me.Meatie.Project2;

import java.io.File;

import me.Meatie.Command.TeleportCommand;
import me.Meatie.Command.WorldCommand;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class LocData {
	
	public static void save(Player user) {
		 try {
		        YamlConfiguration c = new YamlConfiguration();
		        Location loc = user.getLocation();
		        
		        c.set(user.getName() + ".world", loc.getWorld());
		        c.set(user.getName() + ".x", loc.getX());
		        c.set(user.getName() + ".y", loc.getY());
		        c.set(user.getName() + ".z", loc.getZ());
		        c.set(user.getName() + ".yaw", loc.getYaw());
		        c.set(user.getName() + ".pitch", loc.getPitch());
		        File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
		        c.save(new File(file, "loc.yml"));
		    } catch (Exception e) {}
	}
	
	public static void read(final Player user) {
		try {
			
		if (TeleportCommand.online(user.getName()) == null) return;
		
        File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "loc.yml"));
        
        WorldCommand.load(c.get(user.getName() + ".world").toString());
        
        World world = Bukkit.getWorld(c.get(user.getName() + ".world").toString());
        double x = Double.parseDouble(c.get(user.getName() + ".x").toString());
        double y = Double.parseDouble(c.get(user.getName() + ".y").toString());
        double z = Double.parseDouble(c.get(user.getName() + ".z").toString());
        float yaw = Float.parseFloat(c.get(user.getName() + ".yaw").toString());
        float pitch = Float.parseFloat(c.get(user.getName() + ".pitch").toString());
        
        Location loc = new Location(world, x, y, z);
	    loc.setPitch(pitch);
	    loc.setYaw(yaw);
		user.teleport(loc);
		
    } catch (Exception e) {}
	}
	
}
