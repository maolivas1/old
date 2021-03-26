package me.Mark.Time;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new invClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new mobClick(), this);
		Bukkit.getServer().getPluginManager().registerEvents(new Fix(), this);
		getCommand("buy").setExecutor(new buyCommand());
		getCommand("add").setExecutor(new setValueCommand());
		getCommand("d").setExecutor(new dCommand());
		getCommand("spawn").setExecutor(new spawnCommand());
		getCommand("firework").setExecutor(new fireworkCommand());
		getCommand("fw").setExecutor(new fireworkCommand());
		getCommand("inspect").setExecutor(new inspectCommand());
		getCommand("c").setExecutor(new inspectCommand());
		Vaulteconomy.load();
	}
	
	
}
