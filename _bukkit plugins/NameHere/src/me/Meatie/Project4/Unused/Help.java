package me.Meatie.Project4.Unused;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Help {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		player.sendMessage(ChatColor.GREEN + "spawn, ci, hat, msg, ignore, invsee, crafting, nick, warp, sethome, home, delhome, "
				+ "pay, worth, sell, bal, tpa, tpahere, inspect, back");
		
		//if (Rank.getRank(player).equals("mod") || player.isOp())
			player.sendMessage(ChatColor.BLUE + "Mod: tp, killall, repair, spawnmob, head");
		
		if (player.isOp())
			player.sendMessage(ChatColor.RED + "Owner: setworth, setwarp, delwarp, sudo, fly, heal, debug");
	}
	
}
