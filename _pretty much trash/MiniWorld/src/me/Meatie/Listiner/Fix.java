package me.Meatie.Listiner;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Fix implements Listener{
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		event.setFormat(event.getPlayer().getName() + ": " + event.getMessage());
	}
	
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
}
