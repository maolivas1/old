package me.Meatie.Project2;

import java.io.File;

import me.Meatie.Project2.Main;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {
	
	//load defult values if their not set arety.
	public static void load() {
		if(!new File(System.getProperty("user.dir") + "/plugins/LavaFlow/config.yml").exists()) return;
		if (YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/LavaFlow", "config.yml")).get("msg-enable").toString() == null) {
			
		}
	}
	//set dufult values
	/*
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
	*/
	public static void speed() {
		if(!new File(System.getProperty("user.dir") + "/plugins/LavaFlow/config.yml").exists()) return;
		Main.speed = Integer.parseInt((String) YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/LavaFlow", "config.yml")).get("lava-speed"));
	}
	
	public static void error() {
		if(!new File(System.getProperty("user.dir") + "/plugins/LavaFlow/config.yml").exists()) return;
		Main.error = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/LavaFlow", "config.yml")).get("msg-error").toString();
	}
	
	public static void enable() {
		if(!new File(System.getProperty("user.dir") + "/plugins/LavaFlow/config.yml").exists()) return;
		Main.error = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/LavaFlow", "config.yml")).get("msg-enable").toString();
	}
	
	public static void disable() {
		if(!new File(System.getProperty("user.dir") + "/plugins/LavaFlow/config.yml").exists()) return;
		Main.error = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/LavaFlow", "config.yml")).get("msg-disable").toString();
	}
	
}