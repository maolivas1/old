package me.Meatie.Project4.Unused;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Spawn {
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		player.teleport(Bukkit.getServer().getWorlds().get(0).getSpawnLocation());
		player.setGameMode(GameMode.SURVIVAL);
	}
	
}
