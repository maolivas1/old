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
	
	HashMap<String, Integer> rep = new HashMap<String, Integer>();
	HashMap<String, Integer> rank = new HashMap<String, Integer>();
	static HashMap<Integer, Integer> rankup = new HashMap<Integer, Integer>();
	
	public static void startup() {
		rankup.put(0, 100);//100
		rankup.put(1, 500);//500
		rankup.put(2, 1000);//1,000
		rankup.put(3, 5000);//5,000
		rankup.put(4, 15000);//15,000
		rankup.put(4, 50000);//50,000
		rankup.put(5, 100000);//100,000
		rankup.put(6, 150000);//150,000
		rankup.put(7, 300000);//300,000
		rankup.put(8, 500000);//500,000
		rankup.put(9, 1000000);//1,000,000
		rankup.put(10, 1500000);//1,500,000
	}
	
	@EventHandler
	public void join(PlayerJoinEvent event) {
		rep.put(event.getPlayer().getName(), ConfigData.getRep(event.getPlayer().getName()));
		rank.put(event.getPlayer().getName(), ConfigData.getRank(event.getPlayer().getName()));
	}
	
	@EventHandler
	public void quit(PlayerQuitEvent event) {
		ConfigData.saveRep(event.getPlayer().getName(), rep.get(event.getPlayer().getName()));
		ConfigData.saveRank(event.getPlayer().getName(), rank.get(event.getPlayer().getName()));
		rep.remove(event.getPlayer().getName());
		rank.remove(event.getPlayer().getName());
	}
	
	@EventHandler
	public void blockbreak(BlockBreakEvent event) {
		addRep(event.getPlayer().getName());
	}
	
	@EventHandler
	public void blockplace(BlockPlaceEvent event) {
		addRep(event.getPlayer().getName());
	}
	
	public void addRep(String name) {
		rep.put(name, rep.get(name) + 1);
	}
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		
	  if (cmd.equals("rep") || cmd.equals("reputation") || cmd.equals("rank")) {
		 event.setCancelled(true);
		 int level = rank.get(event.getPlayer().getName());
		 int points = rep.get(event.getPlayer().getName());
		 Commands.sendmsg(player, "&aYour Rank Is &c" + level + " &aYou Have &c" + points + " &aRep.");
		 //Rankup Stuff
		 if (!rankup.containsKey(level)) return;
		 if (rankup.get(level) > points)
			 Commands.sendmsg(player, "&aNeed &c" + (rankup.get(level) - points) + " &a More Rep To Rankup."); 
		 else setrank(player, level + 1);

	  }
	}
	
	public void setrank(Player player, int level) {
		 Commands.sendmsg(player, "&aYou Are Now Level &c" + level + "&a!");
		 rank.put(player.getName(), level);
		 
		 if (level == 1) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(60);
		 else if (level == 2) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(80);
		 else if (level == 3) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(100);
		 else if (level == 4) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(150);
		 else if (level == 5) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(500);
		 else if (level == 6) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(1000);
		 else if (level == 7) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(5000);
		 else if (level == 8) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(10000);
		 else if (level == 9) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(50000);
		 else if (level == 10) Bukkit.getWorld(player.getName()).getWorldBorder().setSize(100000);
		 //1 3 5 8
		 if (level == 1 || level == 2 || level == 4)
		 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "perms player setperm " + player.getName() + " " + player.getName() + ":rank." + level + " true");
		 
		 if (level == 1) Commands.sendmsg(player, "&aYou Now Have Access To Commands: &ctop, head, fly, gamemode, give, heal, time, setspawn");
		 else if (level == 2) Commands.sendmsg(player, "&aYou Now Have Access To Commands: &cgod, fix, more, speed, tp, tphere"); 
		 else if (level == 4) Commands.sendmsg(player, "&aYou Now Have Access To Commands: &cspawner, vanish, fill, op");
	}
	
	
}
