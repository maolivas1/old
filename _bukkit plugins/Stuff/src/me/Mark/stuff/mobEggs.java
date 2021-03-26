package me.Mark.stuff;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class mobEggs implements Listener {

	@EventHandler
	public void die(EntityDeathEvent event) {
		
        int rand = new Random().nextInt(5);
        if (rand == 1) {
		Entity entity = event.getEntity();
		EntityType type = event.getEntityType();
		DamageCause cause = entity.getLastDamageCause().getCause();
		if (cause.equals(DamageCause.ENTITY_ATTACK))
		if (type.equals(EntityType.CREEPER) || type.equals(EntityType.SKELETON) || type.equals(EntityType.SPIDER)
				|| type.equals(EntityType.ZOMBIE) || type.equals(EntityType.SLIME) || type.equals(EntityType.GHAST)
			    || type.equals(EntityType.PIG_ZOMBIE) || type.equals(EntityType.ENDERMAN) || type.equals(EntityType.CAVE_SPIDER)
			    || type.equals(EntityType.SILVERFISH) || type.equals(EntityType.BLAZE) || type.equals(EntityType.MAGMA_CUBE)
			    || type.equals(EntityType.BAT) || type.equals(EntityType.WITCH) || type.equals(EntityType.ENDERMITE)
			    || type.equals(EntityType.GUARDIAN) || type.equals(EntityType.PIG) || type.equals(EntityType.SHEEP)
			    || type.equals(EntityType.COW) || type.equals(EntityType.CHICKEN) || type.equals(EntityType.SQUID)
			    || type.equals(EntityType.WOLF) || type.equals(EntityType.MUSHROOM_COW) || type.equals(EntityType.OCELOT)
			    || type.equals(EntityType.HORSE) || type.equals(EntityType.RABBIT) || type.equals(EntityType.VILLAGER)) {//Shulker
		int id = entity.getType().ordinal() + 25;
		if (id >= 69) id += 21;//Pig - Rabbit Fix
		if (id == 102) id = 120;//Villager Fix
		//System.out.println(id);
        ItemStack drop = new ItemStack(Material.MONSTER_EGG, 1, (short) id);
        entity.getWorld().dropItem(entity.getLocation(), drop);
		}
	}
	}
	
}
