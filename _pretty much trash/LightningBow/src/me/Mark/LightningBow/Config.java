package me.Mark.LightningBow;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class Config {

	public static void set(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/LightningBow/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "config.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "config.yml"));
	    } catch (Exception e) {}
	}
	
	public static String get(String thing) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/LightningBow/", "config.yml"));
	        if (c.contains(thing))
		        return c.get(thing).toString();
	    } catch (Exception e) {}
		return null;
	}
	
}
