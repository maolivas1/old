package me.Meatie.myworld;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
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
        //	Commands.send(player, format(quick.replace("$player", player.getName())));
        	if (!Commands.loaded(ConfigData.getWorld(player.getName()))) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + ConfigData.getWorld(player.getName()));
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	final Location loc = ConfigData.getLoc(player.getName());
            	player.teleport(loc);
            }
        }, 5L);
        	} else player.teleport(ConfigData.getLoc(player.getName()));
	}
	
	@EventHandler
	public void teleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
	    Commands.send(player, event.getTo().getWorld().getName());
	    
		if (ConfigData.getBan(event.getTo().getWorld().getName(), player.getName())) {
		event.setCancelled(true);
			Commands.sendmsg(player, "&cYou'r Banned From &a" + event.getTo().getWorld().getName() + "&c's World.");
		}
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		ConfigData.saveLoc(event.getPlayer().getName(), event.getPlayer().getLocation());
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
        @Override
        public void run() {
    		for (World world : Bukkit.getWorlds())
    			if (!world.getName().equals("world"))
    			if (world.getPlayers().isEmpty())
    			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv unload " + world.getName());
        }
    }, 5L);
	}
	
	   @EventHandler
	    public void update(ServerListPingEvent event){
	          event.setMotd(format(motd));
	     }
	   
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
	public void interact(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		 if (event.getRightClicked().getType() == EntityType.PLAYER) {
		    Player target = (Player)event.getRightClicked();
			player.chat("/invsee " + target.getName());
		}
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
