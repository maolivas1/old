package me.Meatie.myworld;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Reputation implements Listener {
	
	static HashMap<String, Integer> rep = new HashMap<String, Integer>();
	
	
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
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		
	  if (cmd.equals("rep") || cmd.equals("reputation") || cmd.equals("rank")) {
		 event.setCancelled(true);
		 int points = rep.get(event.getPlayer().getName());
		 Commands.sendmsg(player, "&aYou Have &c" + points + " &aRep.");
		 
		 int total = 0;
		 for (Player p : Bukkit.getOnlinePlayers())
			 total = rep.get(p.getName()) + total;
		 
		 double size = Bukkit.getWorld("world").getWorldBorder().getSize();
		 
		 Commands.sendmsg(player, "&aTotal Online Rep: &c" + total);
		 
		 if (size == 50)
			 if (total >= 500000) {//500,000
				 for (Player p : Bukkit.getOnlinePlayers())
					 takeRep(p, 500000/Bukkit.getOnlinePlayers().length, true);
				 Bukkit.getWorld("world").getWorldBorder().setSize(100);
				 Bukkit.broadcastMessage("&aGood Work Everyone, Time To Expand Your Awesome Buildings :D");
			 }
		 if (size == 100)
			 if (total >= 1000000) {//1,000,000
				 for (Player p : Bukkit.getOnlinePlayers())
					 takeRep(p, 500000/Bukkit.getOnlinePlayers().length, true);
				 Bukkit.getWorld("world").getWorldBorder().setSize(200);
				 Bukkit.broadcastMessage("&aGood Work Everyone, Time To Expand Your Awesome Buildings :D");
			 }
		 
	}
	}
	
	
}
