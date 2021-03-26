package me.mark.myplot;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.scheduler.BukkitScheduler;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;

public class Listiner implements Listener {
	
	static HashMap<Player, Location> tp = new HashMap<Player, Location>();
	
	@EventHandler
	public void die(PlayerDeathEvent event) {
		Player player = (Player)event.getEntity();
		for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation())) {
	         tp.put(player, Config.getspawn(r.getId()));
	         return;
		}
		tp.put(player, Bukkit.getWorld("plotworld").getSpawnLocation());
	}
	
	@EventHandler
	public void respawn(final PlayerRespawnEvent event) {
        BukkitScheduler scheduler = Bukkit.getScheduler();
        scheduler.scheduleSyncDelayedTask(MyPlot.inst, new Runnable() {
            @Override
            public void run() {
            	event.getPlayer().sendMessage("Teleporting!");
            	event.getPlayer().teleport(tp.get(event.getPlayer()));
            }
        }, 10L);
		
	}
	
	//Per realm tab list
	  @EventHandler
	  public void join(PlayerJoinEvent event) {
	    Player p = event.getPlayer();
	    
	    String rank = getRank(p);
	    if (rank.equals("banned")) {
	    	p.sendMessage(ChatColor.RED + "You were Banned from " + ChatColor.GRAY + getRealm(p) + ChatColor.RED + "'s realm..");
	    	p.teleport(Bukkit.getWorld("plotworld").getSpawnLocation());
	    }
	    
	    for (Player p2 : Bukkit.getOnlinePlayers()) {
	      if (p != p2) {
	        boolean hide = !getRealm(p, p.getLocation()).equals(getRealm(p2, p2.getLocation()));
	        if (hide) {
	        	p.hidePlayer(p2);
	        	p2.hidePlayer(p);
	        } else {
	        	p.showPlayer(p2);
	        	p2.showPlayer(p);
	        }
	      }
	    }
	  }
	  
	//Per realm tab list
	  @EventHandler
	  public void tp(final PlayerTeleportEvent event) {
	    	    Player p = event.getPlayer();
	    	    
	    	    if (Config.getrank(p.getName(), getRealm(p, event.getTo())).equals("banned")) {
	    	    	event.setCancelled(true);
	    	    	p.sendMessage(ChatColor.RED + "You'r Banned From " + ChatColor.GRAY + getRealm(p, event.getTo()) + "'s" + ChatColor.RED + " realm..");
	    	    	return;
	    	    }
	    	    
	    	    for (Player p2 : Bukkit.getOnlinePlayers()) {
	    	      if (p != p2) {
	    	    	boolean hide = !getRealm(p, event.getTo()).equals(getRealm(p2, p2.getLocation()));
	    	        if (hide) {
	    	        	p.hidePlayer(p2);
	    	        	p2.hidePlayer(p);
	    	        } else {
	    	        	p.showPlayer(p2);
	    	        	p2.showPlayer(p);
	    	        }
	    	        }
	    	    }
	  }
	  
	  public String getRealm(Player player, Location loc) {
		  for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(loc))
				return r.getId();
		  return null;
	  }
	  
	  public static String getRealm(Player player) {
		  for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation()))
				return r.getId();
		  return null;
	  }
	  
	  public static String getRealm(Location loc) {
		  for(ProtectedRegion r : WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc))
				return r.getId();
		  return null;
	  }
	  
	  public static String getRank(Player player) {
		  return Config.getrank(player.getName(), Listiner.getRealm(player));
	  }
	  
	  public static String getRank(String player, Location loc) {
		  return Config.getrank(player, Listiner.getRealm(loc));
	  }
	  
	  public static String getRank(String player, String realm) {
		  return Config.getrank(player, realm);
	  }
	  
	  //Per realm chat
	  @EventHandler
	  public void chat(AsyncPlayerChatEvent event) {
		  for (Player p : Bukkit.getOnlinePlayers())
			  if (!getRealm(p).equals(getRealm(event.getPlayer())))
				  event.getRecipients().remove(p);
	  }
}
