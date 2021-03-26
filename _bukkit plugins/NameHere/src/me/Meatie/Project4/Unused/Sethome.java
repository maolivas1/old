package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Sethome {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			HomeData.save(player, args[1].toLowerCase());
			Commands.send(player, "&2&lSet Home &7&l" + args[1].toLowerCase());
		} else Commands.send(player, "&c&l/sethome &7&lname");
	}
}
