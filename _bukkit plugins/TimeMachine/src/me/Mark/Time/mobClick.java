package me.Mark.Time;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class mobClick implements Listener {
	
	@EventHandler
	public void click(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		if (event.getClickedInventory() == null) return;
	    if (event.getClickedInventory().getName().equals(ChatColor.DARK_GREEN + "What Mob You Wana Be?")) {
			event.setCancelled(true);
			player.closeInventory();
			if (clicked == null || clicked.getType().equals(Material.AIR)) return;
			String name = ChatColor.stripColor(clicked.getItemMeta().getDisplayName());
			
			if (name.equals("Un Disguise")) {
				player.sendMessage(ChatColor.GOLD + "UnDisguised");
				Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "ud " + player.getName());
				return;
			}
			
			player.sendMessage(ChatColor.GREEN + "Disgised as: " + ChatColor.GOLD + name);
			
			name = name.replace(" ", "_");
			name = name.replace("Elder_Guardian", "guardian elder");
			name = name.replace("Wither", "witherboss");
			name = name.replace("Witer_Skeleton", "skeleton wither");
			
				d(player, name);
	        }
	}
	
	public void d(Player player, String mob) {
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "od " + player.getName() + " " + mob);
	}
	
}
