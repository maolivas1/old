package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class More {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (player.getItemInHand().getType() != Material.AIR) {
		player.getItemInHand().setAmount(player.getItemInHand().getMaxStackSize());
		Commands.send(player, "&2&lItem In Hand Maxed Out");
		} else Commands.send(player, "&c&lThats Not A Item...");	
	}
}
