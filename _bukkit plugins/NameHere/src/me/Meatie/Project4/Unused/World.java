package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class World {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
	    for (org.bukkit.World w: Bukkit.getWorlds())
	    	if (w.getName().equalsIgnoreCase(args[1])) {
	    		player.teleport(w.getSpawnLocation());
	    		Commands.send(player, "&2&lTeleported to &7&l" + w.getName());
	    		return;
	}
	    Commands.send(player, "&c&lUnknown World");
	}
	
}
