package me.Meatie.Project4.Unused;

import java.util.ArrayList;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Ignore {

	public static ArrayList<String> ignore = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase()))
					if (ignore.contains(player.getName() + "-" + p.getName())) {
						ignore.remove(player.getName() + "-" + p.getName());
						Commands.send(player, "&2&lUn-Ignoring &7&l" + p.getName());
					} else {
					ignore.add(player.getName() + "-" + p.getName());
					Commands.send(player, "&c&lIgnoring &7&l" + p.getName());
					}
		}
	}
}
