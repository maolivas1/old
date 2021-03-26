package me.Meatie.Project2;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.scheduler.BukkitScheduler;

public class Fix implements Listener{
	
	 //Fix Chat Format
	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		event.setFormat(event.getPlayer().getName() + ": " + event.getMessage());
	}
	
	//Disable Weather
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
    
	//Disable Blocks
    @SuppressWarnings("deprecation")
	@EventHandler
    public void place(BlockPlaceEvent event) {
    	int block = event.getBlock().getTypeId();
    	//No RedstoneWire, Redstone Repeter, Redstone Compariter, TNT, CommandBlock
    	if (block == 55  || block == 93 || block == 94 || block == 149 || block == 150 || block == 46 || block == 137)
        event.setCancelled(true);
    }
	
	//Login Stuff
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		event.setJoinMessage(null);
		
		if (!load(player)) {
			player.kickPlayer(ChatColor.RED + "Not WhiteListed, Visit " + ChatColor.GREEN + "bubblecraft.info" + ChatColor.RED + " To Change That.");
			return;
		}

        		for (Player p : Bukkit.getOnlinePlayers())
        			if (p != player)
        			p.sendMessage(ChatColor.YELLOW + player.getName() + " Joined The Game.");	
	}
	
	 
	    public boolean load(Player user) {
			try {
	        File file = new File(System.getProperty("user.dir") + "/plugins/Tools/");
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "whitelist.yml"));
	        if (c.get(user.getName()).toString().equalsIgnoreCase("true"))
	        return true;
	    } catch (Exception e) {}
			return false;
	    }
	
	public static void NoLagg() {
        BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(Main.inst, new Runnable() {
            @Override
            public void run() {
		for (World world: Bukkit.getWorlds())
			for (Entity entitie: world.getEntities()) {
				EntityType type = entitie.getType();
				if (type == EntityType.ARROW || type == EntityType.EGG || type == EntityType.ENDER_PEARL || type == EntityType.ENDER_SIGNAL || type == EntityType.EXPERIENCE_ORB
						|| type == EntityType.FALLING_BLOCK || type == EntityType.PRIMED_TNT || type == EntityType.SMALL_FIREBALL || type == EntityType.SNOWBALL
						|| type == EntityType.SPLASH_POTION || type == EntityType.THROWN_EXP_BOTTLE || type == EntityType.WITHER_SKULL
						|| type == EntityType.BAT || type == EntityType.CAVE_SPIDER || type == EntityType.ENDERMAN || type == EntityType.FIREWORK) 
                entitie.remove();
		}
            }
        }, 0L, 6000L);
	}
}
