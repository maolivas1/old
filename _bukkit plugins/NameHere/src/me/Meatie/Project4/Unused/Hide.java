package me.Meatie.Project4.Unused;

import java.util.ArrayList;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Hide {

	public static ArrayList<String> hiden = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (hiden.contains(player.getName())) {
			for (Player p : Bukkit.getOnlinePlayers())
				p.showPlayer(player);
			Commands.send(player, "&c&lUn-Hidden");
			hiden.remove(player.getName());
		} else {
			for (Player p : Bukkit.getOnlinePlayers())
				p.hidePlayer(player);
			Commands.send(player, "&2&lHidden");
			hiden.add(player.getName());
		}
	}
}
