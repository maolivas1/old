package me.Mark.Commands;

import java.util.ArrayList;
import java.util.HashMap;

import me.Mark.filestuff.DataStuff;
import me.Mark.yourworld.Fix;

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


public class homeCommand implements CommandExecutor {

	public static HashMap<String, String> temp = new HashMap<String, String>();
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			String name = player.getName();
			
			if (Fix.isCreated(name) || Fix.isCreated(name + "_FLAT")) {
				openInv(player, "teleport");
			} else {
				openInv(player, "create");
			}
		}
		
		return true;
	}
	
	public static void openInv(Player player, String type) {
		String name = player.getName();
		if (type.equals("create")) {
			//Open inv to select which world type to create
			Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Create World Type");
			if (!Fix.isCreated(name)) {
			ItemStack sapling = new ItemStack(Material.SAPLING, 1);
			ItemMeta meta = sapling.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Default");
			sapling.setItemMeta(meta);
			inv.setItem(3, sapling);
			}
			if (!Fix.isCreated(name + "_FLAT")) {
			ItemStack grass = new ItemStack(Material.GRASS, 1);
			ItemMeta meta2 = grass.getItemMeta();
			meta2.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Flat");
			grass.setItemMeta(meta2);
			inv.setItem(5, grass);
			}

			player.openInventory(inv);
		} else if (type.equals("teleport")) {
			//Open inv to select which world to goto
			
			ArrayList<String> list = DataStuff.getWorlds(player.getName());
			
			int size = 0;
			int slot = 0;
			for (@SuppressWarnings("unused") String world : list) {
				size++;
			}
			
			if (size <= 9) {
				size = 9;
			} else if (size >= 18) {
				size = 18;
			}
			
			Inventory inv = Bukkit.createInventory(null, size, ChatColor.DARK_GREEN + "Select World To Teleport To");
			
			for (String world : list) {
				HashMap<String, String> map = DataStuff.getWorldData(world);
				temp.put(player.getName() + slot, world);
				ItemStack sapling = new ItemStack(Material.getMaterial(map.get("block")), 1);
				ItemMeta meta = sapling.getItemMeta();
				meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + map.get("name"));
				ArrayList<String> lore = new ArrayList<String>();
				lore.add(map.get("lore"));
				meta.setLore(lore);
				sapling.setItemMeta(meta);
				inv.setItem(slot, sapling);
				slot++;
			}
			
			//If player has more worlds to create
			if (!Fix.isCreated(player.getName() + "_FLAT") || !Fix.isCreated(player.getName())) {
			temp.put(player.getName() + 8, "#tp");
			ItemStack book = new ItemStack(Material.BOOK_AND_QUILL, 1);
			ItemMeta meta = book.getItemMeta();
			meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Create New");
			book.setItemMeta(meta);
			inv.setItem(8, book);
			}
			
			
			player.openInventory(inv);
		}
		
		
	}
	
	
	
	
}
