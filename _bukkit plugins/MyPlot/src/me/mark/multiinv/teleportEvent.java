package me.mark.multiinv;

import me.mark.fun.motdEvents;
import me.mark.fun.myTime;
import me.mark.myplot.Listiner;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

public class teleportEvent implements Listener {

	@EventHandler
	public void tp(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		//Realm player is leaving
		String leaving = Listiner.getRealm(player.getLocation());
		if (leaving == null) leaving = "spawn";
		//Realm player is going to
		String realm = Listiner.getRealm(event.getTo());
		if (realm == null) realm = "spawn";
		if (!leaving.equals(realm)) {
		DataFun.set(player, leaving);
		DataFun.get(player, realm);
		
		motdEvents.motd(player, realm);
		myTime.update(player, realm);
		}
	}
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String realm = Listiner.getRealm(player.getLocation());
		motdEvents.motd(player, realm);
		myTime.update(player, realm);
		
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		DataFun.set(player, Listiner.getRealm(player.getLocation()));
	}
	
}
