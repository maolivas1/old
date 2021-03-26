package me.Meatie.Command;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;

public class SaveCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
		Bukkit.savePlayers();
		
		for (World world: Bukkit.getWorlds())
			world.save();
		
		sender.sendMessage("saved");
		
		if (sender.isOp())
			if (args.length == 1)
				save(args[0]);
		
		return true;
	}
	
	 public static void save(String user) {
		 try {
		      File file = new File(System.getProperty("user.dir") + "/plugins/Tools/");
		      YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "whitelist.yml"));
	          c.set(user, "true");
	        c.save(new File(file, "whitelist.yml"));
	    } catch (Exception e) {}
	    }
	
}
