package me.Meatie.Project2;

import me.Meaie.Cmd.Perms;
import me.Meatie.Command.CheatsCommand;
import me.Meatie.Command.HatCommand;
import me.Meatie.Command.HealCommand;
import me.Meatie.Command.KillAllCommand;
import me.Meatie.Command.RepairCommand;
import me.Meatie.Command.Shortcuts;
import me.Meatie.Command.SpawnCommand;
import me.Meatie.Command.TopCommand;
import me.Meatie.Listiner.Fix;
import me.Meatie.Listiner.NoLagg;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public static Main inst;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Perms(), this);
		getServer().getPluginManager().registerEvents(new Fix(), this);
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("killall").setExecutor(new KillAllCommand());
		getCommand("repair").setExecutor(new RepairCommand());
		getCommand("fix").setExecutor(new RepairCommand());
		getCommand("gm").setExecutor(new Shortcuts());
		getCommand("i").setExecutor(new Shortcuts());
		getCommand("ci").setExecutor(new Shortcuts());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("hat").setExecutor(new HatCommand());
		getCommand("top").setExecutor(new TopCommand());
		getCommand("cheats").setExecutor(new CheatsCommand());
		inst = this;
		NoLagg.start();
}
}
