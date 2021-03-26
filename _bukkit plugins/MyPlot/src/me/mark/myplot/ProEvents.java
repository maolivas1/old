package me.mark.myplot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ProEvents implements Listener {

	ArrayList<Player> ending = new ArrayList<Player>();
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		if (Config.isDonator(player.getName())) {
			
			String e = Config.getExpire(player.getName());
			if (e.equals("lifetime")) return;
			String[] expire = e.split(" ");
			
			int year = Integer.parseInt(expire[0]);
			int month = Integer.parseInt(expire[1]);
			int day = Integer.parseInt(expire[2]);
			int hour = Integer.parseInt(expire[3]);
			int min = Integer.parseInt(expire[4]);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(calendar.getTime());
			Date date = calendar.getTime();
			
			if (year <= date.getYear() || month <= date.getMonth() || day <= date.getDate() || hour <= date.getHours() || min <= date.getMinutes()) {
				messages.proExpired(player);
				ending.add(player);
			}
		}
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		
		if (ending.contains(player)) {
			ending.remove(player);
			Config.setDonator(player.getName(), null);
		}
		
	}
	
	
}
