package me.Mark.yourworld;

import me.Mark.Commands.homeCommand;
import me.Meatie.Perms.Cmd;
import me.Meatie.Perms.Perms;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new BasicListener(), this);
		getCommand("home").setExecutor(new homeCommand());
		
		Bukkit.getServer().getPluginManager().registerEvents(new Perms(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Cmd(), this);
	}
	
}
