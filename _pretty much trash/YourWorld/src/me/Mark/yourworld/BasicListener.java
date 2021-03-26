package me.Mark.yourworld;

import java.util.HashMap;

import me.Mark.Commands.homeCommand;
import me.Mark.filestuff.DataStuff;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BasicListener implements Listener  {
	
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Location loc = DataStuff.getLoc(player.getName(), DataStuff.getWorld(player.getName()));
	    Fix.safeTp(player, loc);
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		DataStuff.saveLoc(player);
		DataStuff.saveWorld(player);
	}
	
	@EventHandler
	public void teleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		DataStuff.saveLoc(player);
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		ItemStack clicked = event.getCurrentItem();
		Inventory inv = event.getInventory();
		//Create World Thingy
		if (inv.getName().equals(ChatColor.DARK_GREEN + "Create World Type")) {
			event.setCancelled(true);
			player.closeInventory();
			if (clicked == null) return;
			if (clicked.getType() == Material.GRASS) {
			DataStuff.addWorld(player.getName(), player.getName() + "_FLAT");
			HashMap<String, String> map = new HashMap<String, String>();
			map.put("name", player.getName() + "'s Flat World");
			map.put("lore", "defult world description...");
			map.put("block", "GRASS");
			DataStuff.saveWorldData(player.getName() + "_FLAT", map);
			Fix.createWorld(player.getName(), "flat");
			} else if (clicked.getType() == Material.SAPLING) {
				DataStuff.addWorld(player.getName(), player.getName());
				HashMap<String, String> map = new HashMap<String, String>();
				map.put("name", player.getName() + "'s Default World");
				map.put("lore", "defult world description...");
				map.put("block", "SAPLING");
				DataStuff.saveWorldData(player.getName(), map);
				Fix.createWorld(player.getName(), "default");
			}
			//Teleport world thingy
		} else if (inv.getName().equals(ChatColor.DARK_GREEN + "Select World To Teleport To")) {
			event.setCancelled(true);
			player.closeInventory();
			
			//If click empty slot, close inv
			if (clicked == null) return;
			
			int slot = event.getSlot();
			if (homeCommand.temp.containsKey(player.getName() + slot)) {
				String world = homeCommand.temp.get(player.getName() + slot);
				
				if (world.equals("#tp")) {
					homeCommand.openInv(player, "create");
					return;
				}
				
				if (world.equals(player.getWorld().getName())) {
					Fix.safeTpWorld(player, world, true);
					return;
				}
				
				if (!Fix.isCreated(world)) {
					//Removes the world from their list
					DataStuff.delWorld(player.getName(), world);
					player.sendMessage(ChatColor.RED + "World Not Found, Removeing From List");
					return;
				}
				Fix.safeTpWorld(player, world, false);
			}
			
			//TODO remove all keys starting with playerName from temp
			
		}
		
		}
	
}
