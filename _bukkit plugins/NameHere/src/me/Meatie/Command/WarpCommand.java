package me.Meatie.Command;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
			if (sender instanceof Player) {
				Player player = (Player)sender;
			
		  if (args.length == 1) {
			  if (read(args[0]) != null) {
				  player.teleport(read(args[0]));
				  sender.sendMessage("Warped To " + args[0]);
			  } else sender.sendMessage("Unknown Warp");
		  } else sender.sendMessage("/warp name");
		}
		
		return true;
	}
	
	 public static Location read(String name) {
		 try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File((System.getProperty("user.dir") + "/plugins/Tools/"), "warps.yml"));
		        double x = Double.parseDouble(c.get(name + ".x").toString());
		        double y = Double.parseDouble(c.get(name + ".y").toString());
		        double z = Double.parseDouble(c.get(name + ".z").toString());
		        float yaw = Float.parseFloat(c.get(name + ".yaw").toString());
		        float pitch = Float.parseFloat(c.get(name + ".pitch").toString());
		        Location loc = new Location(Bukkit.getWorld("world"), x, y, z);
		        loc.setYaw(yaw);
		        loc.setPitch(pitch);
			 return loc;
	    } catch (Exception e) {}
		 return null;
	    }
	
}
