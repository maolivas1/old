package me.Meatie.Project4.Unused;

import me.Meatie.Commands.Claim;
import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Trust {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
      		if (Claim.excist(player)) {
      			String target = avalible(args[1]);
      			if (target != null) {
      			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "region addmember "  + player.getName() + " " + target + " -w world");
      			player.sendMessage(Fix.format("&2Trusted &e" + target));
      			} else player.sendMessage(Fix.format("&4Unknown player"));
      		} else player.sendMessage(Fix.format("&4You don't have a area."));
	}
	
	public static String avalible(String name) {
		for (OfflinePlayer player: Bukkit.getOfflinePlayers())
			if (player.getName().toLowerCase().startsWith(name.toLowerCase())) 
				return player.getName();
		return null;
	}
	
}
