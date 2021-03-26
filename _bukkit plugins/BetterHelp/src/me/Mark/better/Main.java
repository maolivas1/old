package me.Mark.better;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main inst;
	
	@Override
	public void onEnable() {
		getCommand("c").setExecutor(new cCommand());
		getCommand("inspect").setExecutor(new cCommand());
		getCommand("spawn").setExecutor(new spawnCommand());
		getCommand("help").setExecutor(new helpCommand());
		getServer().getPluginManager().registerEvents(new cmdHandler(), this);
		
		inst = this;
}
}
