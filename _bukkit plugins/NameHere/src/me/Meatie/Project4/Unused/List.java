
package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class List {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		String list = "";
		for (Player p : Bukkit.getOnlinePlayers())
		if (list == "") list = Fix.nick(p.getName());
		else list = list + ChatColor.GREEN + ", " + ChatColor.WHITE + Fix.nick(p.getName());
		player.sendMessage(ChatColor.GREEN + Fix.format(list));
	}
	
}
