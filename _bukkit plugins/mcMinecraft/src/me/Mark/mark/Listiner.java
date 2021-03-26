package me.Mark.mark;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Listiner implements Listener {
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		String nick = player.getDisplayName();
		send(nick + ": " + event.getMessage());
	}
	/*
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String nick = player.getDisplayName();
		send(nick + " &eJoined the &a" + Mark.type + " &eServer");
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		String nick = player.getDisplayName();
		send(nick + " &eLeft the &a" + Mark.type + " &eServer");
	}
	*/
	public void send(String msg) {
		if (Mark.type.equals("Survival")) Server.send(msg);
		else Client.send(msg);
	}

}
