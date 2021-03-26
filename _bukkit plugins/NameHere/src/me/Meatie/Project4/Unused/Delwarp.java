package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Delwarp {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			Location loc = WarpData.read(args[1].toLowerCase());
			if (loc != null) {
			WarpData.delete(args[1].toLowerCase());
			Commands.send(player, "&2&lWarp &7&l" + args[1].toLowerCase() + "&2&l Deleted");
			} else Commands.send(player, "&c&lUnknown Warp");
		} else Commands.send(player, "&c&l/delwarp &7&lname");
	}
}
