package me.Meatie.myworld;

import java.io.File;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	//TODO Main Config
	 public static void save(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "data.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "data.yml"));
	         Bukkit.broadcastMessage(Fix.format("&cConfig Value &e" + thing + " &cSet To &e" + value));
	    } catch (Exception e) {}
	    }
	 
	    public static String get(String thing) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "data.yml"));
	        if (c.contains(thing)) {
	        return c.get(thing).toString();
	        } else {}
	    } catch (Exception e) {}
			return null;
	    }
	    //TODO Reputation
		 public static void saveRep(String thing, int value) {
			 try {
				 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "rep.yml"));
				 c.set(thing, value);
		         c.save(new File(file, "rep.yml"));
		    } catch (Exception e) {}
		    }
		 
		    public static int getRep(String thing) {
				try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "rep.yml"));
		        if (c.contains(thing)) {
		        return Integer.valueOf(c.get(thing).toString());
		        }
		    } catch (Exception e) {}
				return 0;
		    } 
}