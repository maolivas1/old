package me.Mark.stuff;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class AntiRetard implements Listener {

	static ArrayList<String> list = new ArrayList<String>();
	
	@EventHandler
	public void login(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (ConfigStuff.getRestricted(player.getUniqueId()))
			list.add(player.getUniqueId().toString());
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (list.contains(player.getUniqueId().toString()))
			list.remove(player.getUniqueId().toString());
	}
	
	@EventHandler
	public void place(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		Material block = event.getBlock().getType();
		
		if (block.equals(Material.TNT) || block.equals(Material.DISPENSER))
		if (!isAllowed(player))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void interact(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if (event.getItem() == null) return;
		Material item = event.getItem().getType();
		
		if (item.equals(Material.LAVA_BUCKET) || item.equals(Material.FLINT_AND_STEEL) || item.equals(Material.EXPLOSIVE_MINECART))
		if (!isAllowed(player))
			event.setCancelled(true);
	}
	
    @EventHandler
    public void onInventoryOpenEvent(InventoryOpenEvent event){
    	Player player = (Player)event.getPlayer();
        if (event.getInventory().getType().equals(InventoryType.DISPENSER)) {
    		if (!isAllowed(player))
    		event.setCancelled(true);
        }
    }
	
	
	public boolean isAllowed(Player player) {
		if (list.contains(player.getUniqueId().toString())) {
		player.sendMessage(ChatColor.RED + "You are no longer allowed to use this, ask someone who is allowed to help you.");
		return false;
		}
		return true;
	}
	
	
	
}
