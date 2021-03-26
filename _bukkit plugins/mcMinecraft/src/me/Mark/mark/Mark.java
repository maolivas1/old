package me.Mark.mark;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Mark extends JavaPlugin {
	
	public static Mark inst;
	static String type = ConfigStuff.getType();
	
	public void onEnable() {
		System.out.println("Type: " + type);
		
		inst = this;
		
		//Bukkit.getServer().getPluginManager().registerEvents(new restrict(), this);
		
		//if (type.equals("Survival")) {
		Vaulteconomy.load();
		Bukkit.getServer().getPluginManager().registerEvents(new cmdFix(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new invClick(), this);
		//getCommand("buy").setExecutor(new buyCommand());
		//getCommand("setvalue").setExecutor(new setValueCommand());
		//getCommand("addcmd").setExecutor(new addCmdCommand());
		//try {Server.start();} catch (Exception e) {}
		//} else try {Client.start();} catch (Exception e) {}
		//Bukkit.getServer().getPluginManager().registerEvents(new Listiner(), this);
	}
	
}