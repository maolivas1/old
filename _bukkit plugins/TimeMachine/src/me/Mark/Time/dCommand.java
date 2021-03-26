package me.Mark.Time;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;


public class dCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			openinv(player);
		}
		
		return true;
	}
	
	/*
ItemStack stack = new ItemStack(Material.MONSTER_EGG, 1, (short) 54);
player.getInventory().addItem(stack);
//inv.setItem(0, stack);
stack.setDurability((short) 54);
ItemMeta meta = stack.getItemMeta();
meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Creeper");
stack.setItemMeta(meta);
player.getInventory().addItem(stack);
	 */
	
	
	public void openinv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 36, ChatColor.DARK_GREEN + "What Mob You Wana Be?");
		//slot, woolID, name
		add(inv, 0, 12, "Bat");
		add(inv, 1, 0, "Chicken");
		add(inv, 2, 12, "Cow");
		add(inv, 3, 14, "Mushroom Cow");
		add(inv, 4, 6, "Pig");
		add(inv, 5, 7, "Rabbit");
		add(inv, 6, 0, "Sheep");
		add(inv, 7, 11, "Squid");
		add(inv, 8, 12, "Villager");
		add(inv, 9, 9, "Cave Spider");
		add(inv, 10, 15, "Enderman");
		add(inv, 11, 12, "Spider");
		add(inv, 12, 6, "Pig Zombie");
		add(inv, 13, 4, "Blaze");
		add(inv, 14, 5, "Creeper");
		add(inv, 15, 8, "Elder Guardian");
		add(inv, 16, 10, "Endermite");
		add(inv, 17, 8, "Ghast");
		add(inv, 18, 9, "Guardian");
		add(inv, 19, 14, "Magma Cube");
		add(inv, 20, 2, "Shulker");
		add(inv, 21, 8, "Silverfish");
		add(inv, 22, 8, "Skeleton");
		add(inv, 23, 5, "Slime");
		add(inv, 24, 10, "Witch");
		add(inv, 25, 7, "Wither Skeleton");
		add(inv, 26, 9, "Zombie");
		add(inv, 27, 4, "Horse");
		add(inv, 28, 4, "Ocelot");
		add(inv, 29, 8, "Wolf");
		add(inv, 30, 0, "Iron Golem");
		add(inv, 31, 0, "Snowman");
		add(inv, 32, 15, "Ender Dragon");
		add(inv, 33, 7, "Wither");
		add(inv, 34, 9, "Giant");
		
		add(inv, 35, 14, "Un Disguise");
		
		player.openInventory(inv);
	}
	
	public void add(Inventory inv, int slot, int id, String name) {
        ItemStack stack = new ItemStack(Material.WOOL, 1, (short) id);
		ItemMeta meta = stack.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + name);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "I Wana Be A " + name);
		meta.setLore(lore);
		stack.setItemMeta(meta);
		
		inv.setItem(slot, stack);
	}
	
}
