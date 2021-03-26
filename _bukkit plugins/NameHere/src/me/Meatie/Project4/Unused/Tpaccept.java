package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Tpaccept {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (Tpa.tpa.containsKey(player.getName())) {
			String name = Tpa.tpa.get(player.getName());
			if (name.startsWith("#")) {
			name = name.replace("#", "");
				for (Player p : Bukkit.getOnlinePlayers())
					if (p.getName().equals(name)) {
						player.teleport(p.getLocation());
						Commands.send(p, "&2&lAccepted You'r Teleport Request");
						Commands.send(player, "&2&lAccepted &7&l" + p.getName() + "&2&l's Teleport Request");
						Tpa.tpa.remove(player.getName());
						return;
					}
			} else
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().equals(name)) {
					p.teleport(player.getLocation());
					Commands.send(player, "&2&lAccepted &7&l" + p.getName() + "&2&l's Teleport Request");
					Commands.send(p, "&7&l" + player.getName() + " &2&lAccepted You'r Teleport Request");
					Tpa.tpa.remove(player.getName());
				}
		} else if (!args[0].equals("AUTO"))
		Commands.send(player, "&c&lNo Pending Teleport Requests");
	}
}
