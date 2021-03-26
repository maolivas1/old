package me.Meatie.myworld;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class Fix implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	  public void onMove(PlayerMoveEvent e) {
		
	    for (Player p : Bukkit.getOnlinePlayers()) {
	    	if (p != e.getPlayer()) {
	    	double closest = Double.MAX_VALUE;
	    	Player closestp = null;
	    	for(Player i : Bukkit.getOnlinePlayers()){
	    		double dist = i.getLocation().distance(e.getPlayer().getLocation());
	    		if (closest == Double.MAX_VALUE || dist < closest){
	    			closest = dist;
	    			closestp = i;
	      	}
	    	}
	      p.setCompassTarget(closestp.getLocation());
	    }
	    }
	  }
}