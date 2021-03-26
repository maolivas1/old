package me.Meatie.Project4.Unused;

import java.lang.reflect.Field;

import net.minecraft.server.v1_8_R1.EntitySkeleton;
import net.minecraft.server.v1_8_R1.PathfinderGoal;
import net.minecraft.server.v1_8_R1.PathfinderGoalSelector;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftSkeleton;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class SawnMob_ implements Listener {
	
	@EventHandler
	public void inv(InventoryClickEvent event) {
		if (Mob.spawnmob.contains(event.getWhoClicked().getName())) {
			if (event.getCurrentItem() != null)
			if (event.getCurrentItem().getType() == Material.MONSTER_EGG) {
			Player player = (Player)event.getWhoClicked();
			spawn(player.getLocation(), unformat(event.getCurrentItem().getItemMeta().getDisplayName()).toUpperCase());
			player.closeInventory();
			}
			event.setCancelled(true);
		}
	}
	
	private String unformat(String raw) {
	   return ChatColor.stripColor(raw).replace(' ', '_').toUpperCase();
	}
	
	@SuppressWarnings("deprecation")
	public void spawn(Location loc, String name) {
        if (name.equals("SKELETON_HORSE") || name.equals("UNDEAD_HORSE") || name.equals("MULE") || name.equals("DONKEY") || name.equals("HORSE")) {
        	spawnHorse(loc, name);
        	return;
        }
        if (name.equals("WITHER_SKELETON")) {
        	spawnWitherSkeleton(loc);
        	return;
        }
        if (name.equals("SPIDER_JOCKEY")) {
        	spawnSpiderJockey(loc);
        	return;
        }
        if (name.equals("CHICKEN_JOCKEY")) {
        	spawnChickenJockey(loc);
        	return;
        }
	loc.getWorld().spawnCreature(loc, EntityType.valueOf(unformat(name)));
	}
	
	public void spawnHorse(Location loc, String name) {
        if (Variant.valueOf(name) == null) return;
        Entity e = loc.getWorld().spawnEntity(loc, EntityType.HORSE);
        ((Horse)e).setVariant(Variant.valueOf(name));
	}
	
	public void spawnWitherSkeleton(Location loc) {
		try {
		Entity skeleton = loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
        EntitySkeleton ent = ((CraftSkeleton)skeleton).getHandle();
            ent.setSkeletonType(1);
            Field selector = EntitySkeleton.class.getDeclaredField("goalSelector");
            selector.setAccessible(true);
            Field e = EntitySkeleton.class.getDeclaredField("e");
            e.setAccessible(true);
            PathfinderGoalSelector goals = (PathfinderGoalSelector)selector.get(ent);
            goals.a(4, (PathfinderGoal)e.get(ent));
		} catch (Throwable e) { }  
    }
	
	public void spawnSpiderJockey(Location loc) {
		Entity spider = loc.getWorld().spawnEntity(loc, EntityType.SPIDER);
		Entity skeleton = loc.getWorld().spawnEntity(loc, EntityType.SKELETON);
		spider.setPassenger(skeleton);
	}
	public void spawnChickenJockey(Location loc) {
		Entity chicken = loc.getWorld().spawnEntity(loc, EntityType.CHICKEN);
		Zombie zombie = (Zombie) loc.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
		zombie.setBaby(true);
		chicken.setPassenger(zombie);
	}
	
	@EventHandler
	public void exit(InventoryCloseEvent event) {
		if (Mob.spawnmob.contains(event.getPlayer().getName()))
			Mob.spawnmob.remove(event.getPlayer().getName());
	}
	
}
