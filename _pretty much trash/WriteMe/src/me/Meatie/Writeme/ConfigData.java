package me.Meatie.Writeme;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	
	 public static void save(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "data.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "data.yml"));
	    } catch (Exception e) {}
	    }
	 
	    public static String get(String thing) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "data.yml"));
	        if (c.contains(thing)) {
	        return c.get(thing).toString();
	        }
	    } catch (Exception e) {}
			return null;
	    }
}