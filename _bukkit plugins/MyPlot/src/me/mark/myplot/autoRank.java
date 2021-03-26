package me.mark.myplot;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class autoRank implements Listener {

	static HashMap<Player, Integer> rep = new HashMap<Player, Integer>();
	static HashMap<Player, Integer> microRep = new HashMap<Player, Integer>();
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		rep.put(player, Config.getrep(player));
		microRep.put(player, 0);
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		Config.setrep(player, rep.get(player));
		rep.remove(player);
		microRep.remove(player);
	}
	
	@EventHandler 
	public void destroy(BlockBreakEvent event) {
		Player player = event.getPlayer();
		if (!event.isCancelled())
		if (microRep.get(player) == 100) {
			microRep.put(player, 0);
			rep.put(player, rep.get(player) + 1);
			Config.setrep(player, rep.get(player));
			checkRankup(player);
		} else microRep.put(player, microRep.get(player) + 1);
	}
	
	@EventHandler
	public void place(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (!event.isCancelled())
		if (microRep.get(player) == 100) {
			microRep.put(player, 0);
			rep.put(player, rep.get(player) + 1);
			Config.setrep(player, rep.get(player));
			checkRankup(player);
		} else microRep.put(player, microRep.get(player) + 1);
	}
	
	@EventHandler
	public void command(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		if (!event.isCancelled())
		if (microRep.get(player) == 100) {
			microRep.put(player, 0);
			rep.put(player, rep.get(player) + 1);
			Config.setrep(player, rep.get(player));
			checkRankup(player);
		} else microRep.put(player, microRep.get(player) + 1);
	}
	
	public static void checkRankup(Player player) {
		int r = rep.get(player);
		
		if (r == 4500000) rankup(player, 25);
		else if (r == 4200000) rankup(player, 24);
		else if (r == 4000000) rankup(player, 23);
		else if (r == 3750000) rankup(player, 22);
		else if (r == 3500000) rankup(player, 21);
		else if (r == 3200000) rankup(player, 20);
		else if (r == 2750000) rankup(player, 19);
		else if (r == 2500000) rankup(player, 18);
		else if (r == 2200000) rankup(player, 17);
		else if (r == 1750000) rankup(player, 16);
		else if (r == 1500000) rankup(player, 15);
		else if (r == 1200000) rankup(player, 14);
		else if (r == 1000000) rankup(player, 13);
		else if (r == 750000) rankup(player, 12);
		else if (r == 500000) rankup(player, 11);
		else if (r == 250000) rankup(player, 10);
		else if (r == 150000) rankup(player, 9);
		else if (r == 100000) rankup(player, 8);
		else if (r == 75000) rankup(player, 7);
		else if (r == 50000) rankup(player, 6);
		else if (r == 30000) rankup(player, 5);
		else if (r == 15000) rankup(player, 4);
		else if (r == 5000) rankup(player, 3);
		else if (r == 1000) rankup(player, 2);
		else if (r == 100) rankup(player, 1);
	}
	
	
	public static void rankup(Player player, int rank) {
		if (rank != 1)
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "perms player removegroup " + player.getName() + " " + (rank - 1));
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "perms player addgroup " + player.getName() + " " + rank);
		int e = 3;
		if (rank >= 4) e = 6;
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "expand " + player.getName() + " " + e);
		player.sendMessage(ChatColor.GREEN + "You're Now rank " + ChatColor.GRAY + rank + ChatColor.GREEN + "!");
		
		//TODO enable redstone in realm at rank 8
	}
	
}
