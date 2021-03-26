package me.Meatie.Project2;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	
	 public static void save(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "data.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "data.yml"));
	         Bukkit.broadcastMessage(Fix.format("&cConfig Value &e" + thing + " &cSet To &e" + value));
	    } catch (Exception e) {
	    	Bukkit.broadcastMessage(Fix.format("&cEcception Saveing: " + e.getMessage()));
	    }
	    }
	 
	    public static String get(String thing) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "data.yml"));
	        if (c.contains(thing)) {
	        return c.get(thing).toString();
	        } else {
	        	Bukkit.broadcastMessage(Fix.format("&cError: Config Value &e" + thing + " &cCould Not Be Loaded."));
	        }
	    } catch (Exception e) {
	    	Bukkit.broadcastMessage(Fix.format("&cEcception Loading: " + e.getMessage()));
	    }
			return null;
	    }
}