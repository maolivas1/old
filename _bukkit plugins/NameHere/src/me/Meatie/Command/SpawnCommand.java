package me.Meatie.Command;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		player.teleport(Bukkit.getWorld("world").getSpawnLocation());
		
		}
		return true;
	}
}
