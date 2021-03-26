package me.Mark.fix;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
		Fix.core();
	}
}