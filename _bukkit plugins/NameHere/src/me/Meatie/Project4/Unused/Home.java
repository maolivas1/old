package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Home {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			Location loc = HomeData.read(player, args[1].toLowerCase());
			if (loc != null) {
			player.teleport(loc);
			Commands.send(player, "&2&lWelcom To Home &7&l" + args[1].toLowerCase());
			} else Commands.send(player, "&c&lUnknown Home");
		} else {
			Commands.send(player, "&c&l/home &7&lname");
			player.sendMessage(HomeData.list(player));
		}
	}
}
