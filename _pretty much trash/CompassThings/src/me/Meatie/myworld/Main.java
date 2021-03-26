package me.Meatie.myworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
	}
}