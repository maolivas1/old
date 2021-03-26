package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Warp {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			Location loc = WarpData.read(args[1].toLowerCase());
			if (loc != null) {
			player.teleport(loc);
			Commands.send(player, "&2&lWarped To &7&l" + args[1].toLowerCase());
			} else Commands.send(player, "&c&lUnknown Warp");
		} else Commands.send(player, "&c&l/warp &7&lname");
	}
}
