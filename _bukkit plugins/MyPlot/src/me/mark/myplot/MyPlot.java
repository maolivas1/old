package me.mark.myplot;

import me.mark.api.ActionBarAPI;
import me.mark.fun.motdCommand;
import me.mark.fun.timeCommand;
import me.mark.multiinv.teleportEvent;
import me.mark.myedit.clickEvent;
import me.mark.myedit.setCommand;
import me.mark.myedit.undoCommand;
import me.mark.myedit.wandCommand;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.intellectualcrafters.plot.api.PlotAPI;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

public class MyPlot extends JavaPlugin {

public static MyPlot inst;
public static PlotAPI plot;
static WorldGuardPlugin wg;
//static WorldEditPlugin we;

@Override
public void onEnable() {
	inst = this;
	Bukkit.getServer().getPluginManager().registerEvents(new autoRank(), this);
	Bukkit.getServer().getPluginManager().registerEvents(new cmdFix(), this);
	Bukkit.getServer().getPluginManager().registerEvents(new Listiner(), this);
	Bukkit.getServer().getPluginManager().registerEvents(new clickEvent(), this);
	Bukkit.getServer().getPluginManager().registerEvents(new teleportEvent(), this);
	Bukkit.getServer().getPluginManager().registerEvents(new ProEvents(), this);
	//Bukkit.getServer().getPluginManager().registerEvents(new Chairs(), this);
	getCommand("home").setExecutor(new homeCommand());
	getCommand("homes").setExecutor(new RealmsCommand());
	getCommand("help").setExecutor(new helpCommand());
	getCommand("expand").setExecutor(new giveRankCommand());
	getCommand("rep").setExecutor(new repCommand());
	getCommand("rank").setExecutor(new rankCommand());
	getCommand("setspawn").setExecutor(new setspawnCommand());
	getCommand("list").setExecutor(new listCommand());
	getCommand("kick").setExecutor(new kickCommand());
	getCommand("ban").setExecutor(new banCommand());
	getCommand("unban").setExecutor(new unbanCommand());
	getCommand("banlist").setExecutor(new banlistCommand());
	getCommand("ranks").setExecutor(new ranksCommand());
	getCommand("wand").setExecutor(new wandCommand());
	getCommand("set").setExecutor(new setCommand());
	getCommand("undo").setExecutor(new undoCommand());
	getCommand("pvp").setExecutor(new pvpCommand());
	getCommand("spawn").setExecutor(new spawnCommand());
	getCommand("motd").setExecutor(new motdCommand());
	getCommand("time").setExecutor(new timeCommand());
	getCommand("pro").setExecutor(new proCommand());
	wg = (WorldGuardPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
	//we = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
	ActionBarAPI.start();
	}
}
