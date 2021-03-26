package me.mark.myplot;

import org.bukkit.entity.Chicken;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class chickenEvent implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void grab(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		
		Entity mob = event.getRightClicked();
		 if(mob instanceof Chicken) { 
			 Entity e = player;
			 while (e.getPassenger() != null)
				 e = e.getPassenger(); 
			 e.setPassenger(mob);
		 }
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler 
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if (player.getPassenger() == null) {
			Entity chicken = player.getWorld().spawnEntity(player.getLocation(), EntityType.CHICKEN);
			chicken.setSilent(true);
			((LivingEntity) chicken).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE, 1));
			player.setPassenger(chicken);
		}
		
		
		
	}
	
	
}
