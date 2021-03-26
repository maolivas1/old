package me.Mark.Time;

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

import com.earth2me.essentials.Essentials;

public class invClick implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void click(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inv = event.getInventory();
		Economy economy = Vaulteconomy.economy;
		if (event.getClickedInventory() == null) return;
		if (inv.getName().equals(ChatColor.DARK_GREEN + "Stuff For Sale")) {
			event.setCancelled(true);
			player.closeInventory();
			if (clicked == null || clicked.getType().equals(Material.AIR)) return;
			String block = clicked.getType().toString();
			double price = getPrice(block);
			if (price != -1.0) {
			double bal = economy.getBalance(player.getName());
					
					if (bal >= price) {
						openinv(player, block);
					} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
				
		}
	} else if (inv.getName().equals(ChatColor.DARK_GREEN + "How Manny You Want?")) {
		event.setCancelled(true);
		player.closeInventory();
		if (clicked == null) return;
		int ammount = clicked.getAmount();
		String block = clicked.getType().toString();
		//double price = ConfigStuff.getWorth(block);
		double price = getPrice(block);
		if (price != -1.0) {
			price = ammount * price;
			double bal = economy.getBalance(player.getName());
			if (bal >= price) {
				buy(player, block, ammount);
			} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
		}
	}
	}
	
	@SuppressWarnings("deprecation")
	public void buy(Player player, String block, int count) {
		Economy economy = Vaulteconomy.economy;
		double price = getPrice(block) * count;
	    economy.withdrawPlayer(player.getName(), price);
		player.sendMessage(ChatColor.GREEN + "Bought " + count + " " + block + " for " + price);
		Inventory inv = player.getInventory();
		ItemStack item = new ItemStack(Material.getMaterial(block.toUpperCase()), count);
		inv.addItem(item);
	}
	
	public static double getPrice(String item) {
		Essentials ess = Vaulteconomy.ess;
		double price = Double.parseDouble(ess.getWorth().getPrice(new ItemStack(Material.getMaterial(item.toUpperCase()))).toString());
		return Math.round(price * 1.1);
	}
	
	public void openinv(Player player, String block) {
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "How Manny You Want?");
		add(inv, block, 1, 1);
		add(inv, block, 16, 3);
		add(inv, block, 32, 5);
		add(inv, block, 64, 7);
		player.openInventory(inv);
	}
	
	public void add(Inventory inv, String block, int count, int slot) {
		double price = getPrice(block) * count;
		ItemStack sapling = new ItemStack(Material.getMaterial(block), count);
		ItemMeta meta = sapling.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + block);
		ArrayList<String> lore = new ArrayList<String>();
		lore.add(ChatColor.GREEN + "Buy " + count + " " + block + " for " + price);
		meta.setLore(lore);
		sapling.setItemMeta(meta);
		inv.setItem(slot, sapling);
	}
	
}
