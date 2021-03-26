package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Tp {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					player.teleport(p.getLocation());
					Commands.send(player, "&2&lTeleported To &6&l" + p.getName());
					return;
				}
			Commands.send(player, "&c&lUnknown Player &7&l" + args[1]);
		} else Commands.send(player, "&c&l/tp &7&l player");
	}
	
}
