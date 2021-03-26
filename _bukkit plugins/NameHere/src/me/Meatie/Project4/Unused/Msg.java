package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;
import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Msg {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length >= 2) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					String msg = Fix.format(event.getMessage().substring(args[0].length() + args[1].length() + 2));
					player.sendMessage(ChatColor.GOLD + "PM " + ChatColor.GRAY + Fix.format(Fix.nick(p.getName()) + ChatColor.GREEN + msg));
					if (p != player)
					p.sendMessage(ChatColor.GOLD + "PM " + ChatColor.GRAY + Fix.format(Fix.nick(player.getName()) + ChatColor.GREEN + msg));
					return;
				}
			for (OfflinePlayer p : Bukkit.getOfflinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
				String msg = event.getMessage().substring(args[0].length() + args[1].length() + 3);
				MailData.save(player, p.getName(), msg);
				Commands.send(player, "&2&lMain Send To &7&l" + p.getName());
					return;
				}
			Commands.send(player, "&c&lUnknown Player");
		} else Commands.send(player, "&c&l/msg &7&l Player");
	}
	
}
