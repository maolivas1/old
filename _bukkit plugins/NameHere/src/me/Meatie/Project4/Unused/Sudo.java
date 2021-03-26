package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Sudo {
	
	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length >= 2)
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					p.chat(event.getMessage().substring(args[0].length() + args[1].length() + 3));
					Commands.send(player, "&2&lForced Command On &7&l" + p.getName());
					return;
				}
	}
	
}
