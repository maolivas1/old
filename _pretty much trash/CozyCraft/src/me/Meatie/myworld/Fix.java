package me.Meatie.myworld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

@SuppressWarnings("deprecation")
public class Fix implements Listener {
	
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
    
    static String quick;
    static String top;
    static String bottom;
    static String login;
    static String leave;
    static String motd;
    
	@EventHandler
	public void join(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
        	TitleAPI.sendTabTitle(player, top.replace("$player", player.getName()), bottom.replace("$player", player.getName()));
	}
	
	   @EventHandler
	    public void update(ServerListPingEvent event){
	          event.setMotd(format(motd));
	     }
	   
	   //Adventure Mode Nothing...
	   @EventHandler
	   public void destroy(BlockBreakEvent event) {
		   if (event.getPlayer().getGameMode() == GameMode.ADVENTURE)
			   event.setCancelled(true);
	   }
	   
	   @EventHandler
	   public void place(BlockPlaceEvent event) {
		   if (event.getPlayer().getGameMode() == GameMode.ADVENTURE)
			   event.setCancelled(true);
	   }
	   
	   @EventHandler
	   public void interact(PlayerInteractEvent event) {
		   if (event.getPlayer().getGameMode() == GameMode.ADVENTURE)
			   event.setCancelled(true);
	   }
	   
	   @EventHandler
	   public void pickup(PlayerPickupItemEvent event) {
		   if (event.getPlayer().getGameMode() == GameMode.ADVENTURE)
			   event.setCancelled(true);
	   }
	   
	   @EventHandler
	   public void attack(EntityDamageEvent event) {
			   if(event.getEntity() instanceof Player) {
			   Player player = (Player)event.getEntity();
			   if (player.getGameMode() == GameMode.ADVENTURE)
				   event.setCancelled(true);
				}
	   }
	   //Adventure Mode Nothing...
	   
	   
	   //No Death Screen
		  @EventHandler
		  public void onPlayerDeath(PlayerDeathEvent e) {
		    final Player player = e.getEntity();
		    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
		      public void run() {
		        if (player.isDead())
		          try {
		            Object nmsPlayer = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
		            Object packet = Class.forName(nmsPlayer.getClass().getPackage().getName() + ".PacketPlayInClientCommand").newInstance();
		            Class<?> enumClass = Class.forName(nmsPlayer.getClass().getPackage().getName() + ".EnumClientCommand");
		            for (Object ob : enumClass.getEnumConstants())
		              if (ob.toString().equals("PERFORM_RESPAWN"))
		                packet = packet.getClass().getConstructor(new Class[] { enumClass }).newInstance(new Object[] { ob });
		            Object con = nmsPlayer.getClass().getField("playerConnection").get(nmsPlayer);
		            con.getClass().getMethod("a", new Class[] { packet.getClass() }).invoke(con, new Object[] { packet });
		          } catch (Exception e) {}
		      }
		    });
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
		
		
	public static String format(String input) {
		return ChatColor.translateAlternateColorCodes('&',input.replace("(heart)", "❤").replace("(check)", "✔").replace("(x)", "✘"));
	}
}
