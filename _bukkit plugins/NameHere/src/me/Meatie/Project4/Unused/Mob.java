package me.Meatie.Project4.Unused;

import java.util.ArrayList;

import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mob {

	public static ArrayList<String> spawnmob = new ArrayList<String>();
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		
		spawnmob.add(player.getName());
		
		Inventory inv = Bukkit.createInventory(null, 45, Fix.format("&9&lSpawn Mob"));
			//Passive
			inv.setItem(0, item("&dPig", 90));
			inv.setItem(1, item("&7Sheep", 91));
			inv.setItem(2, item("&8Cow", 92));
			inv.setItem(3, item("&7Chicken", 93));
			inv.setItem(4, item("&9Squid", 94));
			inv.setItem(5, item("&7Wolf", 95));
			inv.setItem(6, item("&cMushroom Cow", 96));
			inv.setItem(7, item("&eOcelot", 98));
			inv.setItem(8, item("&6Horse", 100));
			inv.setItem(9, item("&8Rabbit", 101));
			inv.setItem(10, item("&8Villager", 120));
		    inv.setItem(11, item("&8Bat", 65));
			//Hostile
			inv.setItem(12, item("&2Creeper", 50));
			inv.setItem(13, item("&7Skeleton", 51));
			inv.setItem(14, item("&8Spider", 52));
			inv.setItem(15, item("&3Zombie", 54));
			inv.setItem(16, item("&aSlime", 55));
			inv.setItem(17, item("&7Ghast", 56));
			inv.setItem(18, item("&dPig Zombie", 57));
			inv.setItem(19, item("&8Enderman", 58));
			inv.setItem(20, item("&8Cave Spider", 59));
			inv.setItem(21, item("&7Silverfish", 60));
			inv.setItem(22, item("&6Blaze", 61));
			inv.setItem(23, item("&4Magma Cube", 62));
			inv.setItem(24, item("&5Witch", 66));
			inv.setItem(25, item("&8Endermite", 67));
			inv.setItem(26, item("&7Guardian", 68));
			//Custom
			inv.setItem(27, item("&3Giant", 54));
			inv.setItem(28, item("&7Iron Golem", 91));
			inv.setItem(29, item("&7Snowman", 56));
			inv.setItem(30, item("&7Skeleton Horse", 60));
			inv.setItem(31, item("&7Undead Horse", 55));
			inv.setItem(32, item("&7Donkey", 120));
			inv.setItem(33, item("&7Mule", 120));
			inv.setItem(34, item("&7Wither Skeleton", 58));
			inv.setItem(35, item("&8Spider Jockey", 52));
			inv.setItem(36, item("&7Chicken Jockey", 93));
			/*
			 * Add Mobs:
			 * 
			 * Killer bunny
			 * Elder Guardian
			 * Wither Skeleton
			 * SpiderJockey (Skeleton On Spider)
			 * ChickenJockey (Baby Zombie on chicken)
			 * 
			 * 
			 * 
			 * 
			 */
			
			player.openInventory(inv);
	}
	
	public static ItemStack item(String name, int id) {
		ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1, (short)id);
		ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(Fix.format("&l" + name));
        ArrayList<String> lore = new ArrayList<String>();
        lore.add(Fix.format("&e&lClick To Spawn " + name));
        meta.setLore(lore);
        stack.setItemMeta(meta);
        return stack;
	}	
}
