package me.Meatie.Project2;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {
	
	public static String getMsg() {
		try {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MeatiesShit/", "config.yml"));
		return c.get("msg").toString();
    } catch (Exception e) {}
		return null;
	}
	
	public static String getMsg2() {
		try {
        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MeatiesShit/", "config.yml"));
		return c.get("login").toString();
    } catch (Exception e) {}
		return null;
	}
	
}
