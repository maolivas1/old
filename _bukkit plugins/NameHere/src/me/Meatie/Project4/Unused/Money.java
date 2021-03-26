package me.Meatie.Project4.Unused;

import me.Meatie.Data.EcoData;
import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Money {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			for (OfflinePlayer p : Bukkit.getOfflinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					Commands.send(player, "&7&l" + p.getName() + " &2&lHas $&7&l" + String.valueOf(EcoData.getMoney(p.getName())).replace(".0", ""));
					return;
				}
			Commands.send(player, "&c&lUnknown Player");
			return;
		}
		Commands.send(player, "&2&lYou Have $&7&l" + String.valueOf(EcoData.getMoney(player.getName())).replace(".0", ""));
	}
}
