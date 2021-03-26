package me.Mark.pocketLink;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.block.BlockPlaceEvent;
import cn.nukkit.event.inventory.InventoryPickupItemEvent;
import cn.nukkit.event.player.PlayerChatEvent;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.level.Location;

public class Listiner implements Listener {
    PocketLink plugin;

    public Listiner(PocketLink plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void chat(PlayerChatEvent event) {
    	Player player = event.getPlayer();
    	String msg = event.getMessage();
    	Client.send("a " + player.getName() + ": " + msg);
    }
    
    @EventHandler
    public void join(PlayerJoinEvent event) {
    	Player player = event.getPlayer();
    	Client.send("&e" + player.getName() + " joined the game");
    }
    
    @EventHandler
    public void leave(PlayerQuitEvent event) {
    	Player player = event.getPlayer();
    	Client.send("&e" + player.getName() + " left the game");
    }
    
    @EventHandler
    public void breakBlock(BlockBreakEvent event) {
    	if (!event.isCancelled()) {
    	Location loc = event.getBlock().getLocation();
    	String world = event.getBlock().getLocation().getLevel().getName();
    	int drop = 0;
    	int damage = 0;
    	if (event.getDrops().length != 0) { drop = event.getDrops()[0].getId();
    	damage = event.getDrops()[0].getDamage();}
    	Client.send("b " + world + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + drop + " " + damage);
    	}
    }
    
    @EventHandler
    public void placeBlock(BlockPlaceEvent event) {
    	if (!event.isCancelled()) {
    		Location loc = event.getBlock().getLocation();
        	String world = event.getBlock().getLocation().getLevel().getName();
    		int block = event.getBlock().getId();
    		int damage = event.getBlock().getDamage();
    		Client.send("c " + world + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + block + " " + damage);
    	}
    }
    

	@EventHandler
    public void pickup(InventoryPickupItemEvent event) {
		Player player = event.getInventory().getHolder() instanceof Player ? (Player) event.getInventory().getHolder() : null;
        if (player == null) return;
    	Location loc = player.getLocation();
    	String world = loc.getLevel().getName();
    	long id = event.getItem().getId();
    	Client.send("d " + world + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + id);
    }
	
	
    
}