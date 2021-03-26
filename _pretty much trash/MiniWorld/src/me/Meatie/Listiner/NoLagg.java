package me.Meatie.Listiner;

import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.scheduler.BukkitScheduler;

public class NoLagg {
	
	
	public static void start() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(Main.inst, new Runnable() {
            @Override
            public void run() {
		for (World world: Bukkit.getWorlds())
			for (Entity entitie: world.getEntities()) {
				EntityType type = entitie.getType();
				if (type == EntityType.ARROW || type == EntityType.EGG || type == EntityType.ENDER_PEARL || type == EntityType.ENDER_SIGNAL || type == EntityType.EXPERIENCE_ORB
						|| type == EntityType.FALLING_BLOCK || type == EntityType.PRIMED_TNT || type == EntityType.SMALL_FIREBALL || type == EntityType.SNOWBALL
						|| type == EntityType.SPLASH_POTION || type == EntityType.THROWN_EXP_BOTTLE || type == EntityType.WITHER_SKULL
						|| type == EntityType.BAT || type == EntityType.CAVE_SPIDER || type == EntityType.ENDERMAN || type == EntityType.FIREWORK) 
                entitie.remove();
		}
            }
        }, 0L, 6000L);
	}
	
}
