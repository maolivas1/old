package me.Mark.pocketLinkPc;

import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.MaterialData;

import com.google.common.collect.Iterables;

public class Listiner implements Listener {
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String msg = event.getMessage();
		Server.send("a " + player.getName() + ": " + msg);
	}
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		Server.send("&e" + player.getName() + " joined the game");
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		Server.send("&e" + player.getName() + " left left game");
	}
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void breakBlock(BlockBreakEvent event) {
    	if (!event.isCancelled()) {
    	Location loc = event.getBlock().getLocation();
    	String world = event.getBlock().getLocation().getWorld().getName();
    	Collection<ItemStack> drop = event.getBlock().getDrops(event.getPlayer().getItemInHand());
    	String dmg = "0";
    	int d = 0;
    	if (drop.size() != 0) {
    	d = Iterables.get(drop, 0).getTypeId();
    	MaterialData damage = Iterables.get(drop, 0).getData();
    	dmg = damage.toString().substring(5, 6);
    	}
    	Server.send("b " + world + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + d + " " + dmg);
    	}
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void placeBlock(BlockPlaceEvent event) {
    	if (!event.isCancelled()) {
    		Location loc = event.getBlock().getLocation();
        	String world = event.getBlock().getLocation().getWorld().getName();
    		int block = event.getBlock().getTypeId();
    		int damage = event.getBlock().getData();
    		//Rotation isn't used yet..
    		byte rotation = event.getBlock().getState().getData().getData();
    		Server.send("c " + world + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + block + " " + damage + " " + rotation);
    	}
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void pickup(PlayerPickupItemEvent event) {
    	//if this laggs too much make it so items aren't droped when broken, but added to inv (unless inv is full)
    	Location loc = event.getPlayer().getLocation();
    	String world = event.getPlayer().getWorld().getName();
    	int id = event.getItem().getItemStack().getType().getId();
    	Server.send("d " + world + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + id);
    }
    
    

}
