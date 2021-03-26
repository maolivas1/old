package me.Meatie.Project2;

import me.Metie.Command.fireworkCommand;
import me.Metie.Command.spawnCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
		
		
		getCommand("fw").setExecutor(new fireworkCommand());
		getCommand("firework").setExecutor(new fireworkCommand());
		getCommand("spawn").setExecutor(new spawnCommand());
		
		/*
		Fix.quick = ConfigData.get("quick");
		Fix.top = ConfigData.get("top");
		Fix.bottom = ConfigData.get("bottom");
		Fix.login = ConfigData.get("login");
		Fix.leave = ConfigData.get("leave");
		*/
		
		//getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
	}
}