package me.Mark.myRealm;

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

public class invCommand implements CommandExecutor {
	
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Stuff For Sale");
			
			
			//Select Command Inv
			ItemStack sapling = new ItemStack(Material.COMMAND, 1);
			ItemMeta meta = sapling.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + "Commands");
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + "Pay to use commands");
			meta.setLore(lore);
			sapling.setItemMeta(meta);
			inv.setItem(1 - 1, sapling);
			
			player.openInventory(inv);
			
		}
		
		return true;
	}
	
	
	
	
}
