package me.Meatie.Listiner;

import java.util.ArrayList;
import java.util.List;

import me.Meatie.Data.InvData;
import me.Meatie.Data.LocData;
import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Fix implements Listener{
	
	 static List<String> list = new ArrayList<String>();
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		event.setFormat(event.getPlayer().getName() + ": " + event.getMessage());
	}
	
	//Disable Weather
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
	
	//Disable Hunger
	@EventHandler
	public void hunger(FoodLevelChangeEvent event) {
		event.setCancelled(true);
	}
	
	//Disable Fall, Lightnng, Drowning, Poision and Contact Damage.
	@EventHandler
	public void damage(EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			DamageCause cause = event.getCause();
			if (cause == DamageCause.FALL || cause == DamageCause.LIGHTNING || cause == DamageCause.DROWNING || cause == DamageCause.POISON || cause == DamageCause.CONTACT)
				event.setCancelled(true);
		}
	}
	
	//Save player data when server is manly saved.
	@SuppressWarnings("deprecation")
	@EventHandler
	public void command(ServerCommandEvent event) {
		if (event.getCommand().equals("save-all"))
			for (Player p : Bukkit.getOnlinePlayers())
				LocData.save(p);
		//TODO Save Invs too
	}
	
	//Unload worlds when their empty.
	@EventHandler
	public void worldchange(PlayerChangedWorldEvent event) {
		Fix.unload();
	}
	
	//Stop item drop when switching worlds
	@EventHandler
	public void drop(PlayerDropItemEvent event) {
		if (list.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
	
	public static void unload() {
		for(World w: Bukkit.getServer().getWorlds()) {
			if (!w.getName().equals("world")) {
			if (w.getPlayers().size() == 0) {
				
				for (String name:  LoadWorld.map.keySet())
					if (name.contains(w.getName() + " "))
						remove(name);
				
				Bukkit.unloadWorld(w, true);
				return;
			}
			}
			}
	}
	
	
	public static void tp(Location loc, final Player player) {
		list.add(player.getName());
			InvData.save(player);
			InvData.load(player);
		
		player.teleport(loc);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	list.remove(player.getName());
            }
        }, 1L);
		
	}
	
	public static void remove(final String name) {
	Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	LoadWorld.map.remove(name);
            }
        }, 20L);
		
	}
}
