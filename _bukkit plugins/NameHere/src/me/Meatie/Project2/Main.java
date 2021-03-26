package me.Meatie.Project2;

import org.bukkit.plugin.java.JavaPlugin;

import me.Meaie.Cmd.Perms;
import me.Meatie.Command.SaveCommand;
import me.Meatie.Command.SetWarpCommand;
import me.Meatie.Command.SpawnCommand;
import me.Meatie.Command.WarpCommand;

public class Main extends JavaPlugin {
	
	public static Main inst;
	
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new Perms(), this);
		getServer().getPluginManager().registerEvents(new Fix(), this);
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("save").setExecutor(new SaveCommand());
		getCommand("setwarp").setExecutor(new SetWarpCommand());
		getCommand("warp").setExecutor(new WarpCommand());
		inst = this;
		Fix.NoLagg();
}
}