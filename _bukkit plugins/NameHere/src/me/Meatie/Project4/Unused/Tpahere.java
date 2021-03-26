package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Tpahere {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					Tpa.tpa.put(p.getName(), "#" + player.getName());
					Commands.send(player, "&2&lRequested To Teleport &7&l" + p.getName() + "&2&l To You.");
					Commands.send(p, "&7&l" + player.getName() + "&2&lRequested You To Teleport To Them &7&l/tpa &2&lTo Accept");
					return;
				}
			Commands.send(player, "&c&lUnknown Player &7&l" + args[1]);
		} else {
			String[] temp = {"AUTO"};
			Tpaccept.cmd(player, temp, event);
			Commands.send(player, "&c&l/tpahere &7&lplayer");
		}
	}
}
