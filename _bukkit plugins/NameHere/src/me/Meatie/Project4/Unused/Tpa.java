package me.Meatie.Project4.Unused;

import java.util.HashMap;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Tpa {

	public static HashMap<String, String> tpa = new HashMap<String, String>();
	
	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					tpa.put(p.getName(), player.getName());
					Commands.send(player, "&2&lRequested To Teleport To &7&l" + p.getName());
					Commands.send(p, "&7&l" + player.getName() + " &2&lRequested To Teleport To You &7&l/tpa &2&lTo Accept");
					return;
				}
			Commands.send(player, "&c&lUnknown Player &7&l" + args[1]);
		} else {
			if (!tpa.containsKey(player.getName())) {
			Commands.send(player, "&c&l/tpa &7&lplayer");
			return;
			}
			String[] temp = {"AUTO"};
			Tpaccept.cmd(player, temp, event);
		}
	}
}