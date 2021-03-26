package me.Mark.mark;

import java.util.ArrayList;

import net.milkbowl.vault.economy.Economy;

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


public class buyCommand implements CommandExecutor {
	
	Economy economy = Vaulteconomy.economy;
	
	@SuppressWarnings({ "unused", "deprecation" })
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			int count = 1;
			
			if (args.length >= 2) {
				if (isInteger(args[1]))
				count = Integer.parseInt(args[1]);
			}
			/*
			if (args.length >= 1) {
			double price = ConfigStuff.getWorth(args[0].toUpperCase());
			if (price != -1.0) {
			price = price * count;
			if(economy != null) {
				double bal = economy.getBalance(player.getName());
				
				if (bal >= price) {
					
				    economy.withdrawPlayer(player.getName(), price);
					player.sendMessage(ChatColor.GREEN + "Bought " + count + " " + args[0] + " for " + price);
					
					Inventory inv = player.getInventory();
					ItemStack item = new ItemStack(Material.getMaterial(args[0].toUpperCase()), count);
					inv.addItem(item);
					
					
				} else  player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
			} else player.sendMessage(ChatColor.RED + "Economy thing not working....");
			} else player.sendMessage(ChatColor.RED + args[0] + " isn't for sale...");
		} else {
		*/
		
			//Open inv showing what's for sale
			
			ArrayList<String> list = ConfigStuff.getWorths();
			
			int size = 0;
			int slot = 0;
			for (String block : list)
				size++;
			
			if (size <= 8) size = 9;
			else if (size <= 9) size = 18;
			else if (size <= 18) size = 27;
			else if (size <= 27) size = 36;
			else if (size <= 36) size = 45;
			else if (size <= 45) size = 54;
			
			Inventory inv = Bukkit.createInventory(null, size, ChatColor.DARK_GREEN + "Stuff For Sale");
			
			for (String block : list) {
				String[] a = block.split(",");
				int id = Integer.parseInt(a[0]);
				short dur = Short.parseShort(a[1]);
				ItemStack sapling = new ItemStack(id, 1);
				sapling.setDurability(dur);
				ItemMeta meta = sapling.getItemMeta();
				String n = Material.getMaterial(id).toString().replace("_", " ").toLowerCase();
				String nick = n.substring(0, 1).toUpperCase() + n.substring(1);
				meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + nick);
				ArrayList<String> lore = new ArrayList<String>();
				lore.add(ChatColor.GREEN + nick + " for " + ConfigStuff.getWorth(block));
				meta.setLore(lore);
				sapling.setItemMeta(meta);
				inv.setItem(slot, sapling);
				slot++;
			}
			
			//Select Command Inv
			ItemStack sapling = new ItemStack(Material.COMMAND, 1);
			ItemMeta meta = sapling.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Commands");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + "Pay to use commands");
			meta.setLore(lore);
			sapling.setItemMeta(meta);
			inv.setItem(size - 1, sapling);
			
			player.openInventory(inv);
			
		//}
		}
		
		return true;
	}
	
	public static boolean isInteger(String s) {
	    try {
	        Integer.parseInt(s);
	    } catch(NumberFormatException e) {return false; 
	    } catch(NullPointerException e) {return false;}
	    return true;
	}
	
	
	
	
}
