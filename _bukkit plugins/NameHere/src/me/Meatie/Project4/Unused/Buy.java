package me.Meatie.Project4.Unused;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Buy {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		player.sendMessage(ChatColor.RED + "Temporarly unavalible due to change in plugins.");
		/*
		if (args.length >= 2) {
			String item = args[1].toUpperCase();
			int ammount = 1;
			
			if (args.length == 3)
			if (!args[2].contains("."))
			ammount = Integer.parseInt(args[2]);
			
			double price = new BigDecimal(EcoData.getPrice(item) * 1.3 * ammount).setScale(2, RoundingMode.HALF_EVEN).doubleValue();
			double newPrice = (double)Math.round(price * 100) / 100;
			
			if (!(EcoData.getMoney(player.getName()) > price)) {
				Commands.send(player, "&c&lInsufishent Funds"); 
				return;
			}
			
			if (price != 0) {
				Commands.send(player, "&2&lBought &7&l" + ammount + " " + item + "&2&l for $&7&l" + String.valueOf(price).replace(".0", ""));
				EcoData.takeMoney(player.getName(), newPrice);
				player.getInventory().addItem(new ItemStack(Material.getMaterial(item), ammount));
			} else Commands.send(player, "&c&lCan't Buy That Item");
	}
	*/
	}
}