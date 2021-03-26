package me.Meatie.Project4.Unused;

import java.util.ArrayList;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Invsee {
	
	public static ArrayList<String> invsee = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
	event.setCancelled(true);
	if (args.length == 2) {
		for (Player p : Bukkit.getOnlinePlayers())
			if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
				player.openInventory(p.getInventory());
				invsee.add(player.getName());
				return;
			}
		Commands.send(player, "&c&lUnknown Player");
	} else Commands.send(player, "&c&l/invsee &7&lPlayer");
	}
	
}
