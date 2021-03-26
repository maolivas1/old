package me.Meatie.Project2;

import org.bukkit.plugin.java.JavaPlugin;

import me.Meaie.Cmd.Perms;
import me.Meaie.Cmd.Restrications;
import me.Meatie.Command.BanCommand;
import me.Meatie.Command.HatCommand;
import me.Meatie.Command.HealCommand;
import me.Meatie.Command.HelpCommand;
import me.Meatie.Command.HomeCommand;
import me.Meatie.Command.InfoCommand;
import me.Meatie.Command.KickCommand;
import me.Meatie.Command.KillAllCommand;
import me.Meatie.Command.ListCommand;
import me.Meatie.Command.PrivacyCommand;
import me.Meatie.Command.RankCommand;
import me.Meatie.Command.RepairCommand;
import me.Meatie.Command.SaveCommand;
import me.Meatie.Command.SayCommand;
import me.Meatie.Command.Shortcuts;
import me.Meatie.Command.SpawnCommand;
import me.Meatie.Command.TeleportCommand;
import me.Meatie.Command.TopCommand;
import me.Meatie.Command.WorldCommand;
import me.Meatie.Listiner.Build;
import me.Meatie.Listiner.Fix;
import me.Meatie.Listiner.Join;
import me.Meatie.Listiner.Leave;
import me.Meatie.Listiner.NoLagg;

public class Main extends JavaPlugin {
	
	public static Main inst;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Restrications(), this);
		getServer().getPluginManager().registerEvents(new Perms(), this);
		getServer().getPluginManager().registerEvents(new Build(), this);
		getServer().getPluginManager().registerEvents(new Join(), this);
		getServer().getPluginManager().registerEvents(new Leave(), this);
		getServer().getPluginManager().registerEvents(new Fix(), this);
		getCommand("createworld").setExecutor(new WorldCommand());
		getCommand("world").setExecutor(new WorldCommand());
		getCommand("home").setExecutor(new HomeCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("privacy").setExecutor(new PrivacyCommand());
		getCommand("rank").setExecutor(new RankCommand());
		getCommand("tp").setExecutor(new TeleportCommand());
		getCommand("info").setExecutor(new InfoCommand());
		getCommand("help").setExecutor(new HelpCommand());
		getCommand("say").setExecutor(new SayCommand());
		getCommand("list").setExecutor(new ListCommand());
		getCommand("kick").setExecutor(new KickCommand());
		getCommand("ban").setExecutor(new BanCommand());
		getCommand("save").setExecutor(new SaveCommand());
		getCommand("killall").setExecutor(new KillAllCommand());
		getCommand("repair").setExecutor(new RepairCommand());
		getCommand("fix").setExecutor(new RepairCommand());
		getCommand("gm").setExecutor(new Shortcuts());
		getCommand("i").setExecutor(new Shortcuts());
		getCommand("ci").setExecutor(new Shortcuts());
		getCommand("heal").setExecutor(new HealCommand());
		getCommand("hat").setExecutor(new HatCommand());
		getCommand("top").setExecutor(new TopCommand());
		inst = this;
		NoLagg.start();
}
}
