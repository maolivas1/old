package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Gm {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2)
			if (args[1].equals("0")) {
				player.setGameMode(GameMode.SURVIVAL);
				Commands.send(player, "&2&lGamemode Now &6&lSurvival");
				return;
			} else if (args[1].equals("1")) {
				player.setGameMode(GameMode.CREATIVE);
				Commands.send(player, "&2&lGamemode Now &6&lCreative");
				return;
			} else if (args[1].equals("2")) {
				player.setGameMode(GameMode.ADVENTURE);
				Commands.send(player, "&2&lGamemode Now &6&lAdventure");
				return;
			}
		Commands.send(player, "&c&l/gm &7&l0 1 2");
	}
	
}
