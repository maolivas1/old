package me.Mark.Stuff.old;

import java.util.ArrayList;

import me.Mark.stuff.ConfigStuff;

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

public class voteCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
		    openInv(player);
		}
		
		return true;
	}
	
	@SuppressWarnings("unused")
	public void openInv(Player player) {
		
		ArrayList<String> list = ConfigStuff.getVoteStuff();
		
		int size = 0;
		int slot = 0;
		for (String thing : list)
			size++;
		
		if (size <= 8) size = 9;
		else if (size <= 9) size = 18;
		else if (size <= 18) size = 27;
		else if (size <= 27) size = 36;
		else if (size <= 36) size = 45;
		else if (size <= 45) size = 54;
		
		Inventory inv = Bukkit.createInventory(null, size, ChatColor.DARK_GREEN + "Stuff to Vote for");
		
		for (String vote : list) {
			ItemStack sapling = new ItemStack(Material.getMaterial(ConfigStuff.getVoteBlock(vote)), 1);
			ItemMeta meta = sapling.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + vote);
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + "Vote for " + vote + " and get " + ConfigStuff.getVotePrize(vote));
			meta.setLore(lore);
			sapling.setItemMeta(meta);
			inv.setItem(slot, sapling);
			slot++;
		}
		player.openInventory(inv);
	}
	
	public static void openInv2(Player player, String vote) {
		
		Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GREEN + "Select Thingy");
		
			ItemStack sapling = new ItemStack(Material.getMaterial(ConfigStuff.getVoteBlock(vote)), 1);
			ItemMeta meta = sapling.getItemMeta();
			meta.setDisplayName(ChatColor.DARK_GREEN + "" + ChatColor.BOLD + vote);
			ArrayList<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GREEN + "" + ConfigStuff.getVotePrize(vote));
			meta.setLore(lore);
			sapling.setItemMeta(meta);
			inv.setItem(0, sapling);

		player.openInventory(inv);
		
		
	}
	
	
	
	
}
