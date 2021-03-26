package me.Mark.myRealm;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main inst;
	
	public void onEnable() {
		inst = this;
		
		//Setup PlotMe
		
		
		
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
		getCommand("inv").setExecutor(new invCommand());
	}
	
	
}
