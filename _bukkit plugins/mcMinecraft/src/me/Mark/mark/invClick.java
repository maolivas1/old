package me.Mark.mark;

import java.util.ArrayList;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class invClick implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void click(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inv = event.getInventory();
		Economy economy = Vaulteconomy.economy;
		if (inv.getName().equals(ChatColor.DARK_GREEN + "Stuff For Sale")) {
			event.setCancelled(true);
			player.closeInventory();
			if (clicked == null) return;
			String block = clicked.getTypeId() + "," + clicked.getDurability();
			
			if (clicked.getType().equals(Material.COMMAND)) {
				openinv2(player);
				return;
			}
			
			double price = ConfigStuff.getWorth(block.toString());
			if (price != -1.0) {
			double bal = economy.getBalance(player.getName());
					
					if (bal >= price) {
						openinv(player, block);
					} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
				
		}
	} else if (inv.getName().equals(ChatColor.DARK_GREEN + "How Manny You Want?")) {
		event.setCancelled(true);
		player.closeInventory();
		int ammount = clicked.getAmount();
		int id = clicked.getTypeId();
		int dur = clicked.getDurability();
		String block = id + "," + dur;
		double price = ConfigStuff.getWorth(block);
		if (price != -1.0) {
			price = ammount * price;
			double bal = economy.getBalance(player.getName());
			if (bal >= price) {
				buy(player, block, ammount);
			} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
		}
	} else if (inv.getName().equals(ChatColor.DARK_GREEN + "What Command?")) {
		event.setCancelled(true);
		player.closeInventory();
		/*
		if (clicked.getType().equals(Material.COMPASS)) {
			//open anvil to select name
			
			double price = 10000;//10,000
			if (price != -1.0) {
				double bal = economy.getBalance(player.getName());
				if (bal >= price) {
					
					//economy.withdrawPlayer(player.getName(), price);
					
					
				} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
			return;
			}
		}
		*/
		if (clicked.getType().equals(Material.AIR)) return;
		if (clicked.getItemMeta().getDisplayName() == null) return;
		if (!clicked.getItemMeta().getDisplayName().contains("/")) return;
		String cmd = ChatColor.stripColor(clicked.getItemMeta().getDisplayName()).replace("/", "");
		double price = ConfigStuff.getCmdPrice(cmd.replace(" " , "-"));
		if (price != -1.0) {
			double bal = economy.getBalance(player.getName());
			if (bal >= price) {
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), cmd.replace("player",  player.getName()));
				economy.withdrawPlayer(player.getName(), price);
			} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
		}
	}
	}
	
	@SuppressWarnings("deprecation")
	public void buy(Player player, String block, int count) {
		Economy economy = Vaulteconomy.economy;
		double price = ConfigStuff.getWorth(block) * count;
	    economy.withdrawPlayer(player.getName(), price);
		String[] a = block.split(",");
		int id = Integer.parseInt(a[0]);
		short dur = Short.parseShort(a[1]);
		String n = Material.getMaterial(id).toString().replace("_", " ").toLowerCase();
		String nick = n.substring(0, 1).toUpperCase() + n.substring(1);
		player.sendMessage(ChatColor.GREEN + "Bought " + count + " " + nick + " for " + price);
		Inventory inv = player.getInventory();
		ItemStack item = new ItemStack(id, count);
		item.setDurability(dur);
		inv.addItem(item);
	}
	
	@SuppressWarnings({ "unused", "deprecation" })
	public void openinv2(Player player) {
		ArrayList<String> list = ConfigStuff.getCommands();
		
		int size = 0;
		int slot = 0;
		for (String cmd : list)
			size++;
		
		if (size <= 8) size = 9;
		else if (size <= 9) size = 18;
		else if (size <= 18) size = 27;
		else if (size <= 27) size = 36;
		else if (size <= 36) size = 45;
		else if (size <= 45) size = 54;
		
		Inventory inv = Bukkit.createInventory(null, size, ChatColor.DARK_GREEN + "What Command?");
		
		for (String cmd : list) {
			ItemStack sapling = new ItemStack(ConfigStuff.getCmdBlock(cmd), 1);
			ItemMeta meta = sapling.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "/" + cmd.replace("-", " ").replace("@p", player.getName()));
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + "/" + cmd.replace("-", " ").replace("@p", player.getName()) + " for " + ConfigStuff.getCmdPrice(cmd));
			meta.setLore(lore);
			sapling.setItemMeta(meta);
			inv.setItem(slot, sapling);
			slot++;
		}
		
		player.openInventory(inv);
	}
	
	public void openinv(Player player, String block) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "How Manny You Want?");
		add(inv, block, 1, 1);
		add(inv, block, 16, 3);
		add(inv, block, 32, 5);
		add(inv, block, 64, 7);
		player.openInventory(inv);
	}
	
	@SuppressWarnings("deprecation")
	public void add(Inventory inv, String block, int count, int slot) {
		String[] a = block.split(",");
		int id = Integer.parseInt(a[0]);
		short dur = Short.parseShort(a[1]);
		double price = ConfigStuff.getWorth(block) * count;
		ItemStack sapling = new ItemStack(id, count);
		sapling.setDurability(dur);
		ItemMeta meta = sapling.getItemMeta();
		String n = Material.getMaterial(id).toString().replace("_", " ");
		String nick = n.substring(0, 1).toUpperCase() + n.substring(1).toLowerCase();
		meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + nick);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Buy " + count + " " + nick + " for " + price);
		meta.setLore(lore);
		sapling.setItemMeta(meta);
		inv.setItem(slot, sapling);
	}
}
