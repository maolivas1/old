package me.Mark.sg;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Mark extends JavaPlugin {
	
	public static Mark inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new events(), this);
		getCommand("sg").setExecutor(new sgCommand());
	}
	
}