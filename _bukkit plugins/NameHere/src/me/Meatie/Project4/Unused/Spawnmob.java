package me.Meatie.Project4.Unused;

import java.util.HashMap;

import me.Meatie.Project2.Commands;
import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Spawnmob {

	static HashMap<String, Integer> count = new HashMap<String, Integer>();
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (!player.isOp()) return;
		
		if (args.length == 2)
		if(args[1].equalsIgnoreCase("wolf"))
			spawn(player, EntityType.WOLF, "Wolf");
		else if(args[1].equalsIgnoreCase("chicken"))
			spawn(player, EntityType.CHICKEN, "Chicken");
		else if(args[1].equalsIgnoreCase("cow"))
			spawn(player, EntityType.COW, "Cow");
		else if(args[1].equalsIgnoreCase("horse"))
			spawn(player, EntityType.HORSE, "Horse");
		else if(args[1].equalsIgnoreCase("ocelot") || args[1].equals("cat"))
			spawn(player, EntityType.OCELOT, "Cat");
		else if(args[1].equalsIgnoreCase("pig"))
			spawn(player, EntityType.PIG, "Pig");
		else if(args[1].equalsIgnoreCase("sheep"))
			spawn(player, EntityType.SHEEP, "Sheep");
		else if(args[1].equalsIgnoreCase("bat"))
			spawn(player, EntityType.BAT, "Bat");
		else if(args[1].equalsIgnoreCase("mooshroom") || args[1].equals("mushroom") || args[1].equals("mcow"))
			spawn(player, EntityType.MUSHROOM_COW, "Mushroom Cow");
		else if(args[1].equalsIgnoreCase("squid"))
			spawn(player, EntityType.SQUID, "Squid");
		else if(args[1].equalsIgnoreCase("villager"))
			spawn(player, EntityType.VILLAGER, "Villager");
		else if(args[1].equalsIgnoreCase("rabbit"))
			spawn(player, EntityType.RABBIT, "Rabbit");
		else if(args[1].equalsIgnoreCase("cavespider"))
			spawn(player, EntityType.CAVE_SPIDER, "Cave Spider");
		else if(args[1].equalsIgnoreCase("spider"))
			spawn(player, EntityType.SPIDER, "Spider");
		else if(args[1].equalsIgnoreCase("zombiepigman") || args[1].equals("pigzombie") || args[1].equals("zombiepig"))
			spawn(player, EntityType.PIG_ZOMBIE, "Zombie Pigman");
		else if(args[1].equalsIgnoreCase("blaze"))
			spawn(player, EntityType.BLAZE, "Blaze");
		else if(args[1].equalsIgnoreCase("creeper"))
			spawn(player, EntityType.CREEPER, "Creeper");
		else if(args[1].equalsIgnoreCase("endermite"))
			spawn(player, EntityType.ENDERMITE, "Endermite");
		else if(args[1].equalsIgnoreCase("ghast"))
			spawn(player, EntityType.GHAST, "Ghast");
		else if(args[1].equalsIgnoreCase("magmacube"))
			spawn(player, EntityType.MAGMA_CUBE, "Magma Cube");
		else if(args[1].equalsIgnoreCase("silverfish"))
			spawn(player, EntityType.SILVERFISH, "Silverfish");
		else if(args[1].equalsIgnoreCase("skeleton"))
			spawn(player, EntityType.SKELETON, "Skeleton");
		else if(args[1].equalsIgnoreCase("slime"))
			spawn(player, EntityType.SLIME, "Slime");
		else if(args[1].equalsIgnoreCase("witch"))
			spawn(player, EntityType.WITCH, "Witch");
		else if(args[1].equalsIgnoreCase("zombie"))
			spawn(player, EntityType.ZOMBIE, "Zombie");
		else if(args[1].equalsIgnoreCase("guardian"))
			spawn(player, EntityType.GUARDIAN, "Guardian");
		else if(args[1].equalsIgnoreCase("snowman"))
			spawn(player, EntityType.SNOWMAN, "Snow Man");
		else if(args[1].equalsIgnoreCase("irongolem"))
			spawn(player, EntityType.IRON_GOLEM, "Iron Golem");
		else Commands.send(player, "&c&l/spawnmob &7&lmob");
		else Commands.send(player, "&c&l/spawnmob &7&lMod");
	}
	
	@SuppressWarnings("deprecation")
	public static void spawn(Player player, EntityType type, String name) {
		if (count.get(player.getName()) == null)
		count.put(player.getName(), 1);
		//TODO FIx this to let player spawn 20 mobs then have to wait for the timer.
		else if (count.get(player.getName()) == 20) {
			 Commands.send(player, "&a&lWait A While To Spawn More Mobs...");
			 return;
		}
		count.put(player.getName(), count.get(player.getName()) + 1);
		
		Location loc = player.getTargetBlock(null, 100).getLocation();
        loc.getWorld().spawnCreature(loc, type);
        Commands.send(player, "&a&lSpawned a " + name);
	}
	
	public static void start() {
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	count.clear();
            }
        }, 0L, 2400L);
	}
	
}
