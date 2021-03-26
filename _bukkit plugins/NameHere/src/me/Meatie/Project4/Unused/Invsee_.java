package me.Meatie.Project4.Unused;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class Invsee_ implements Listener {

	@EventHandler
	public void inv(InventoryClickEvent event) {
		if (Invsee.invsee.contains(event.getWhoClicked().getName()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void exit(InventoryCloseEvent event) {
		if (Invsee.invsee.contains(event.getPlayer().getName()))
			Invsee.invsee.remove(event.getPlayer().getName());
	}
	
}
