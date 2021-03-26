package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Delhome {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			if (HomeData.read(player, args[1].toLowerCase()) != null) {
			HomeData.delete(player, args[1].toLowerCase());
			Commands.send(player, "&2&lHome &7&l" + args[1].toLowerCase() + "&2&l Deleted");
			} else Commands.send(player, "&c&lUnknown Home");
		} else Commands.send(player, "&c&l/delhome &7&lname");
	}
}
