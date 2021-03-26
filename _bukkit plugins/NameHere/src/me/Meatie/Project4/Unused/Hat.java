package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class Hat {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (player.getInventory().getHelmet() != null)
		player.getInventory().addItem(player.getInventory().getHelmet());
        player.getInventory().setHelmet(player.getItemInHand());
        player.setItemInHand(new ItemStack(Material.AIR));
        Commands.send(player, "&2&lEnjoy You'r New Hat");
	}
	
}
