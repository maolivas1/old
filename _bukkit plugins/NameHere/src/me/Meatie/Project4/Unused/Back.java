package me.Meatie.Project4.Unused;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Back {
	
	public static HashMap<String, Location> back = new HashMap<String, Location>();
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (back.containsKey(player.getName()))
			player.teleport(back.get(player.getName()));
	}
	
}
