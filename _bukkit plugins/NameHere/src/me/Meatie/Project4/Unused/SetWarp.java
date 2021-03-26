package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SetWarp {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			WarpData.save(args[1].toLowerCase(), player.getLocation());
			Commands.send(player, "&2&lSet Warp &7&l" + args[1].toLowerCase());
		} else Commands.send(player, "&c&l/setwarp &7&lname");
	}
}
