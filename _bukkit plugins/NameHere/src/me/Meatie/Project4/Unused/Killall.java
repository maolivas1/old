package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Killall {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		int count = 0;
		for (Entity entitie: player.getWorld().getEntities()) {
			EntityType type = entitie.getType();
			if (type != EntityType.ARMOR_STAND && type != EntityType.COMPLEX_PART && type != EntityType.DROPPED_ITEM && type != EntityType.EXPERIENCE_ORB
				&& type != EntityType.FISHING_HOOK && type != EntityType.BOAT && type != EntityType.ITEM_FRAME
				&& type != EntityType.MINECART && type != EntityType.MINECART_CHEST && type != EntityType.MINECART_COMMAND && type != EntityType.MINECART_FURNACE
				&& type != EntityType.MINECART_HOPPER && type != EntityType.MINECART_MOB_SPAWNER && type != EntityType.MINECART_TNT && type != EntityType.PAINTING
				&& type != EntityType.PLAYER && type != EntityType.PRIMED_TNT && type != EntityType.SPLASH_POTION && type != EntityType.THROWN_EXP_BOTTLE
				&& type != EntityType.UNKNOWN) {
				
				if (type == EntityType.WOLF) {
					Wolf wolf = (Wolf) entitie;
					if (wolf.getOwner() != null)
						return;
				}
				
			       entitie.remove();
			       count = count + 1;
			}
			Commands.send(player, "&a&lRemoved &7&l" + count + " &a&lEntitys");
	}
	}
}
