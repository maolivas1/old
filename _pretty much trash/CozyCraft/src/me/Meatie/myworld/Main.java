package me.Meatie.myworld;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new Commands(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Reputation(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new BetterMobs(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Perms(), this);
		
		Fix.quick = ConfigData.get("quick");
		Fix.top = ConfigData.get("top");
		Fix.bottom = ConfigData.get("bottom");
		Fix.login = ConfigData.get("login");
		Fix.leave = ConfigData.get("leave");
		Fix.motd = ConfigData.get("motd");
	}
}