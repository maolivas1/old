package me.Meatie.Project2;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new Perms(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
	}
}