package me.Meatie.Project4.Unused;

import java.util.ArrayList;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class God {
	
	public static ArrayList<String> god = new ArrayList<String>();
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (god.contains(player.getName())) {
			god.remove(player.getName());
			Commands.send(player, "&c&lDisabled &7&lGod-Mode");
		} else {
			god.add(player.getName());
			Commands.send(player, "&2&lEnabled &7&lGod-Mode");
		}
	}
}
