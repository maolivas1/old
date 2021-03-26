package me.Meatie.swan;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class Lobby implements Listener {
	
    
    @EventHandler
    public void dage(EntityDamageEvent event) {
    	event.setCancelled(true);
    }
    
    @EventHandler
    public void hunger(FoodLevelChangeEvent event) {
    	event.setCancelled(true);
    }
	
}
