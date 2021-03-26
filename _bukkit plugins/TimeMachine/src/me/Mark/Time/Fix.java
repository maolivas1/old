package me.Mark.Time;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerCommandEvent;

public class Fix implements Listener {

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().equalsIgnoreCase("/d")) {
			event.setCancelled(true);
			Player player = event.getPlayer();
			player.chat("/stuff:d");
		}
	}
    
	@EventHandler
	public void join(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		event.setJoinMessage(null);
		for (Player p : Bukkit.getOnlinePlayers())
			if (p != player)
				p.sendMessage(format("&e$player Joined The Game.".replace("$player", player.getName())));
	}
	
		@EventHandler
		public void console(ServerCommandEvent event) {
			if (event.getCommand().equalsIgnoreCase("stop"))
			for (Player p : Bukkit.getOnlinePlayers())
			p.kickPlayer("Server Stoped, Probably Restarting");
		}
		
	  @EventHandler
	  public void sign(SignChangeEvent sign) {
		sign.setLine(0, format(sign.getLine(0)));
	    sign.setLine(1, format(sign.getLine(1)));
	    sign.setLine(2, format(sign.getLine(2)));
	    sign.setLine(3, format(sign.getLine(3)));
	}
	  
		public static String format(String input) {
			return ChatColor.translateAlternateColorCodes('&',input);
		}
	
}
