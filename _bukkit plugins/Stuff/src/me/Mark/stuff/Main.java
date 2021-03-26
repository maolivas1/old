package me.Mark.stuff;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new Perms(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new SpawnRegion(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new invClick(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new AntiRetard(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new AntiJon(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new CmdFix(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new mobEggs(), this);
		//Bukkit.getServer().getPluginManager().registerEvents(new BetterMobs(), this);
		getCommand("help").setExecutor(new helpCommand());
		getCommand("c").setExecutor(new inspectCommand());
		getCommand("inspect").setExecutor(new inspectCommand());
		//getCommand("gen").setExecutor(new genCommand());
		//getCommand("mob").setExecutor(new mobCommand());
		//getCommand("tick").setExecutor(new tickCommand());
		//getCommand("buy").setExecutor(new buyCommand());
		//getCommand("setvalue").setExecutor(new setValueCommand());
		//getCommand("addcmd").setExecutor(new addCmdCommand());
		//getCommand("restrict").setExecutor(new restrictCommand());
		//getCommand("write").setExecutor(new writeCommand());
		//Vaulteconomy.load();
	}
	
}