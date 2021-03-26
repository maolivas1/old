package me.Mark.LightningBow;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class LightningBow implements Listener {
	
	static int min_distance;
	static int max_distance;
	static String name;
	static String justPlayer;
	String arrows = "";
	
	@EventHandler
	public void hit(EntityDamageByEntityEvent event) {
		
		if (event.getDamager() instanceof Arrow) {
			
			Location loc = null;
			
			if (justPlayer.equals("true"))
				if (!(event.getEntity() instanceof Player))
					return;
			
			loc = event.getEntity().getLocation();
			
		
		Arrow arrow = (Arrow) event.getDamager();
		Player player = (Player) arrow.getShooter();
		
		if (arrow.getShooter() instanceof Player) {
			double space = loc.distance(player.getLocation());
		        if (space > min_distance && space < max_distance)
				if (arrows.contains(String.valueOf(arrow.getEntityId())))
				loc.getWorld().strikeLightning(loc);
		}
		}
	}
	
	@EventHandler
	public void fire(EntityShootBowEvent event) {
		if (event.getEntity() instanceof Player) {
			if (event.getBow().hasItemMeta())
				if(event.getBow().getItemMeta().hasDisplayName())
					if (event.getBow().getItemMeta().getDisplayName().equals(name))
						arrows = arrows + String.valueOf(event.getProjectile().getEntityId());
		}
		
	}
	
	@EventHandler
	public void hit(final ProjectileHitEvent event) {
			if (arrows.contains(String.valueOf(event.getEntity().getEntityId()))) {
				
				//Wait 0.05 second so we don't remove it before its checked in the above event
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
		            @Override
		            public void run() {
		            	arrows = arrows.replace(String.valueOf(event.getEntity().getEntityId()), "");
		            }
		        }, 1L);
				
			}
	}
	

}
