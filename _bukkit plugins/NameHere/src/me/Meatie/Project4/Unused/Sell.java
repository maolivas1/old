package me.Meatie.Project4.Unused;

import me.Meatie.Data.EcoData;
import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class Sell {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		Material type = player.getItemInHand().getType();
		if (type != Material.AIR) {
			double price = EcoData.getPrice(type.toString());
			if (price != 0) {
				int ammount = player.getItemInHand().getAmount();
				Commands.send(player, "&2&lSold &7&l" + ammount + " " + type.toString() + "&2&l for $&7&l" + String.valueOf(price * ammount).replace(".0", ""));
				player.setItemInHand(new ItemStack(Material.AIR));
				EcoData.addMoney(player.getName(), price * ammount);
				
			} else Commands.send(player, "&c&lCan't Sell That Item");
		} else Commands.send(player, "&c&lCan't Sell Air");
	}
}
