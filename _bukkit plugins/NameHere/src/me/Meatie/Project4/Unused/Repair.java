package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Repair {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		Material item = player.getItemInHand().getType();
		
		if (item != Material.AIR) {
			String name = item.toString().toLowerCase();
			if (name.contains("sword") || name.contains("spade") || name.contains("axe") || name.contains("hoe")
					|| name.contains("helmet") || name.contains("chestplate") || name.contains("leggings")
					|| name.contains("boots") || name.contains("fishing_rod") || name.contains("flint_and_steel")
					|| name.contains("shears") || name.contains("carrot_on_a_stick") || name.contains("bow")) {
				
		player.getItemInHand().setDurability((short) 0);
		Commands.send(player, "&2&lItem In Hand Repaired");
		
			} else Commands.send(player, "&c&lCan't Repair That...");	
		} else Commands.send(player, "&c&lThats Not A Item...");	
	}
}
