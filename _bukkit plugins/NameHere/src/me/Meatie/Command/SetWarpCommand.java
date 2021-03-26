package me.Meatie.Command;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
			if (!(sender instanceof Player)) return true;
				Player player = (Player)sender;
			
		  if (args.length != 1) {
			  sender.sendMessage("/setwarp name");
			  return true;
		  }
		/*	  
		  if (!read(player, args[0])) {
			  sender.sendMessage("You Can't Set That Warp, Didn't Create It");
			  return true;
		  }
		  */
		  save(player, args[0].toLowerCase());
		  sender.sendMessage("setwarp " + args[0]);
		
		return true;
	}
	
	 public static void save(Player player, String name) {
		 try {
		      File file = new File(System.getProperty("user.dir") + "/plugins/Tools/");
		      YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "warps.yml"));
		      Location loc = player.getLocation();
	          c.set(name + ".creator", player.getName());
	          c.set(name + ".x", loc.getX());
	          c.set(name + ".y", loc.getY());
	          c.set(name + ".z", loc.getZ());
	          c.set(name + ".yaw", loc.getYaw());
	          c.set(name + ".pitch", loc.getPitch());
	          
	        c.save(new File(file, "warps.yml"));
	    } catch (Exception e) {}
	    }
	 
	 public static boolean read(Player player, String warp) {
		 try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File((System.getProperty("user.dir") + "/plugins/Tools/"), "warps.yml"));
		        String name = c.get(warp.toLowerCase() + ".creator").toString();
	        	Bukkit.broadcastMessage("#" + name);
		        if (name.equalsIgnoreCase(player.getName()) || name == "")
		        	return true;
	    } catch (Exception e) {}
		 return false;
	    }
	
}
