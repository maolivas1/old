package me.Meatie.swan;

import java.util.HashMap;

import me.Meatie.Project2.Commands;
import me.Meatie.Project2.ConfigData;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Reputation implements Listener {
	
	public static HashMap<String, Integer> rep = new HashMap<String, Integer>();
	
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		rep.put(event.getPlayer().getName(), ConfigData.getRep(event.getPlayer().getName()));
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent event) {
		ConfigData.saveRep(event.getPlayer().getName(), rep.get(event.getPlayer().getName()));
		rep.remove(event.getPlayer().getName());
	}
	
	@EventHandler
	public void blockbreak(BlockBreakEvent event) {
		if (!event.isCancelled())
		addRep(event.getPlayer().getName());
	}
	
	@EventHandler
	public void blockplace(BlockPlaceEvent event) {
		if (!event.isCancelled())
		addRep(event.getPlayer().getName());
	}
	
	public void addRep(String name) {
		rep.put(name, rep.get(name) + 1);
	}
	
	public static boolean takeRep(Player player, int ammunt, boolean silent) {
		if (rep.get(player.getName()) - ammunt > 0) {
		rep.put(player.getName(), rep.get(player.getName()) - ammunt);
		return true;
		}
		if (silent == false) Commands.sendmsg(player, "&cYou Don't Have Enouph Rep To Do That...");
		return false;
	}
	
	
}
