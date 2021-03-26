package me.Mark.pocketLinkPc;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PocketLinkPc extends JavaPlugin {
	
	static PocketLinkPc inst;
	
	public void onEnable() {
		 inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new Listiner(), this);
		System.out.println("PocketLink Enabled!");
		try {
			Server.start();
		} catch (Exception e) {}
	}
	
}