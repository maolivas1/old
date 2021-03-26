package me.Mark.blockMe;


import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new BlockMe(), this);
		
		BlockMe.cmds = ConfigStuff.getCmds();
	}
}