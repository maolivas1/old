package me.Meatie.msgedit;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	
	 public static void save(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MessageEditor/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "config.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "config.yml"));
	    } catch (Exception e) {
	    	Bukkit.broadcastMessage(Listiner.format("&e[MsgEdit] &cEcception Saveing: " + e.getMessage()));
	    }
	    }
	 
	    public static String get(String thing) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MessageEditor/", "config.yml"));
	        if (c.contains(thing))
	        return c.get(thing).toString();
	        else Bukkit.broadcastMessage(Listiner.format("&e[MsgEdit] &cError: Config Value &e" + thing + " &cCould Not Be Loaded."));
	    } catch (Exception e) {
	    	Bukkit.broadcastMessage(Listiner.format("&e[MsgEdit] &cEcception Loading: " + e.getMessage()));
	    }
			return null;
	    }
}