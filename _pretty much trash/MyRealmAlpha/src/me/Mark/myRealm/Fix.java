package me.Mark.myRealm;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Fix implements Listener {
	
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
    
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(null);
		for (Player p : Bukkit.getOnlinePlayers())
			if (p != player)
				p.sendMessage(ChatColor.YELLOW + player.getName() + " Joined The Game.");
	}
	
	  @EventHandler
	  public void sign(SignChangeEvent sign) {
		sign.setLine(0, format(sign.getLine(0)));
	    sign.setLine(1, format(sign.getLine(1)));
	    sign.setLine(2, format(sign.getLine(2)));
	    sign.setLine(3, format(sign.getLine(3)));
	}
		
		@EventHandler
		public void console(ServerCommandEvent event) {
			if (event.getCommand().equalsIgnoreCase("stop"))
			for (Player p : Bukkit.getOnlinePlayers())
			p.kickPlayer("Server Stoped, Probably Restarting");
		}
		
		@EventHandler
		public void food(FoodLevelChangeEvent event) {
		   event.setCancelled(true);
		}
		
		
	public static String format(String input) {
		return ChatColor.translateAlternateColorCodes('&', 
				   input.replace("(heart)", "❤").replace("(check)", "✔").replace("(music)", "♪").replace("(tempc)", "℃")
					.replace("(plane)", "✈").replace("(x)", "✘").replace("(pencil)", "✎").replace("(mail)", "✉")
					.replace("(right)", "➡").replace("(music2)", "♫").replace("(snowflake)", "❄").replace("(tempf)", "℉"));
	}
}
