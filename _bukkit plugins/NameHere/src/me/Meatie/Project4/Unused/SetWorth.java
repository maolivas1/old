package me.Meatie.Project4.Unused;

import me.Meatie.Data.EcoData;
import me.Meatie.Project2.Commands;
import me.Meatie.Project2.Fix;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SetWorth {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		Material type = player.getItemInHand().getType();
		if (type != Material.AIR)
			if (args.length == 2) {
		EcoData.setPrice(type.toString(), Double.parseDouble(args[1]));
		player.sendMessage(Fix.format("&2&lSetWorth Of &7&l" + type.toString() + "&2&l To $&7&l" + EcoData.getPrice(type.toString())));
			} else Commands.send(player, "&c&l/setworth &7&lPrice");	
	 else Commands.send(player, "&c&lCan't Sell Air");
	}
}
