package me.Meatie.Writeme;

import me.Metie.Command.writeCommand;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		getCommand("write").setExecutor(new writeCommand());
	}
}