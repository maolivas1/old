package me.Meatie.Listiner;

import me.Meatie.Data.LocData;
import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class Leave implements Listener {
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		LocData.save(player);
		
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
                Fix.unload();
            }
        }, 20L);
	}
	
	
}
