package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Heal {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		player.setFireTicks(0);
		player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 7));
		player.setFoodLevel(20);
		Commands.send(player, "&2&lHealed");
	}
	
	
}
