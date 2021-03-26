package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class Head {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
		ItemStack skull = new ItemStack(397, 1, (short) 3);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(args[1]);
		skull.setItemMeta(meta);
		player.getInventory().addItem(skull);
		Commands.send(player, "&a&lEnjoy &7&l" + args[1] + "&a&l's Head");
		} else Commands.send(player, "&c&l/head &7&lPlayer");
	}
}