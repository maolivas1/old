package me.mark.myplot;

import me.mark.api.ActionBarAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlot extends JavaPlugin {

public static MyPlot inst;

@Override
public void onEnable() {
	inst = this;
	Bukkit.getServer().getPluginManager().registerEvents(new chickenEvent(), this);
	//getCommand("help").setExecutor(new helpCommand());
	getCommand("spawn").setExecutor(new spawnCommand());
	getCommand("join").setExecutor(new joinCommand());
	getCommand("setspawn").setExecutor(new setSpawnCommand());
	getCommand("leave").setExecutor(new leaveCommand());
	ActionBarAPI.start();
	}
}
