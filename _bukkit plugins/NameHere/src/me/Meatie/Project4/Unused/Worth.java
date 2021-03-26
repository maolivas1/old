package me.Meatie.Project4.Unused;

import me.Meatie.Data.EcoData;
import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Worth {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		Material type = player.getItemInHand().getType();
		double price = EcoData.getPrice(type.toString());
		Commands.send(player, "&7&l " + type + " &2&lIs Worth &7&l " + String.valueOf(price).replace(".0", ""));
	}
}
