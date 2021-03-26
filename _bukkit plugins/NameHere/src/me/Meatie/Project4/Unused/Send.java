package me.Meatie.Project4.Unused;

import me.Meatie.Data.MailData;
import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Send {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length >= 2) {
			for (OfflinePlayer p : Bukkit.getOfflinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
				String msg = event.getMessage().substring(args[0].length() + args[1].length() + 3);
				MailData.save(player, p.getName(), msg);
				Commands.send(player, "&2&lMain Send To &7&l" + p.getName());
					return;
				}
			Commands.send(player, "&c&lUnknown Player");
		} else Commands.send(player, "&c&l/send &7&lPlayer Message");
	}
}
