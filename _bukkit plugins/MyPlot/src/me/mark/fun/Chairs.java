package me.mark.fun;

import me.mark.myplot.MyPlot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class Chairs implements Listener {
	  
	  @EventHandler
	  public void onPlayerInteract(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    if (event.getClickedBlock() != null) {
	      Block block = event.getClickedBlock();
	      if ((event.getAction() == Action.RIGHT_CLICK_BLOCK) && !player.isInsideVehicle()) {
	          if (block.getType().equals(Material.WOOD_STAIRS)) {
	            Entity chair = player.getWorld().spawnEntity(player.getLocation(), EntityType.ARROW);
	            chair.teleport(block.getLocation().add(0.5D, 0.2D, 0.5D));
	            chair.setPassenger(player);
	            
	          //  for(Player p : Bukkit.getServer().getOnlinePlayers())
	          //      ((CraftPlayer) p).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(chair.getEntityId()));
	            
	            event.setCancelled(true);
	            return;
	          }
	      }
	    }
	  }
	  
	  
	  @EventHandler
	  public void onPlayerTeleport(PlayerTeleportEvent event) {
	        final Player player = event.getPlayer();
	        if (player.getVehicle() != null)
		        if (player.getVehicle().getType().equals(EntityType.ARROW)) {
		        	final Entity arrow = player.getVehicle();
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MyPlot.inst, new Runnable() {
	            @Override
	            public void run() {
	    	        if (player.getVehicle() == null) {
	    		        	player.setSneaking(false);
	    		        	arrow.remove();
	    	        }
	    		        }
	        }, 5L);
	        
		        }
	  }
	  
}
