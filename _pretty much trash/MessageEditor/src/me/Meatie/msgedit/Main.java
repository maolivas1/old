package me.Meatie.msgedit;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin {
	
    static String quick;
    static String top;
    static String bottom;
    static String login;
    static String leave;
    static String motd;
    static boolean ownlogin;
	public static Main inst;
	
	public void onEnable() {
	inst = this;
	
	Bukkit.getServer().getPluginManager().registerEvents(new Listiner(), this);
	quick = ConfigData.get("quick");
	top = ConfigData.get("top");
	bottom = ConfigData.get("bottom");
	login = ConfigData.get("login");
	leave = ConfigData.get("leave");
	motd = ConfigData.get("motd");
	if (ConfigData.get("ownlogin").equalsIgnoreCase("true")) ownlogin = true;
	else ownlogin = false;
	}
	
	
}
