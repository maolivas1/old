package me.Meatie.Project4.Unused;

import java.io.File;

import me.Meatie.Project2.Main;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {
	
	public static void save() {
		if(!new File(System.getProperty("user.dir") + "/plugins/Project4/config.yml").exists()) {
		 try {
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Project4", "config.yml"));
		        c.set("server-type", "type");
		        c.save(new File(System.getProperty("user.dir") + "/plugins/Project4", "config.yml"));
		    } catch (Exception e) {}
		}
		ConfigData.load();
	}
	
	public static void load() {
		if(!new File(System.getProperty("user.dir") + "/plugins/Project4/config.yml").exists()) return;
		Main.type = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Project4", "config.yml")).get("server-type").toString();
		System.out.println("Main.type " + Main.type);
	}
	
}
