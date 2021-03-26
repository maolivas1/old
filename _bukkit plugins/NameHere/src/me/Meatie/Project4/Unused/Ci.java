package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class Ci {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		player.getInventory().clear();
		player.getInventory().setBoots(new ItemStack(Material.AIR));
		player.getInventory().setLeggings(new ItemStack(Material.AIR));
		player.getInventory().setChestplate(new ItemStack(Material.AIR));
		player.getInventory().setHelmet(new ItemStack(Material.AIR));
		Commands.send(player, "&2&lCleared Inventory");
	}
	
}
