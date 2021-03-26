package me.Meatie.Project4.Unused;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import me.Meatie.Project2.Main;
import net.minecraft.server.v1_8_R1.EnumClientCommand;
import net.minecraft.server.v1_8_R1.PacketPlayInClientCommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class MiniGame implements Listener {
	
	static ArrayList<String> list = new ArrayList<String>();
	HashMap<String, Integer> score = new HashMap<String, Integer>();
	HashMap<Location, String> placed = new HashMap<Location, String>();
	
	public static void setup() {
		Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.inst, new Runnable() {
	            @SuppressWarnings("deprecation")
				@Override
	            public void run() {
	            	for (Player p : Bukkit.getOnlinePlayers())
	            		if (list.contains(p.getName()))
	            	p.getInventory().addItem(new ItemStack(Material.TNT));
	            }
	        }, 0L, 40L);
	}
	
	@EventHandler
	public void place(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		if (list.contains(player.getName())) {
			if (!player.isSneaking())
        if (event.getBlock().getType() == Material.TNT) {
          event.getBlock().setType(Material.AIR);
          ((TNTPrimed)player.getWorld().spawn(event.getBlock().getLocation(), TNTPrimed.class)).setFuseTicks(40);
          placed.put(event.getBlock().getLocation(), player.getName());
          Bukkit.broadcastMessage(ChatColor.GRAY + event.getBlock().getLocation().toString() + ChatColor.DARK_GRAY + " " + player.getName());
        } else event.setCancelled(true);
		}
	}
	
	@SuppressWarnings("rawtypes")
	@EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
        if (event.getEntity().getType() == EntityType.PRIMED_TNT) {
      Iterator it = event.blockList().iterator();
      int count = 0;
      while (it.hasNext()) {
       count = count + 1;
       it.next();
      }
      Location loc = new Location(event.getLocation().getWorld(), Math.round(event.getLocation().getX()), Math.round(event.getLocation().getY()), Math.round(event.getLocation().getZ()));
      if (placed.get(loc) != null) {
    	  
    	  if (score.get(placed.get(loc)) == null)
    		  score.put(placed.get(loc), 0);
    	  
    score.put(placed.get(loc), score.get(placed.get(loc)) + count);
    Bukkit.broadcastMessage(" " + score.get(placed.get(loc)));
    placed.remove(loc);
      } else Bukkit.broadcastMessage(ChatColor.RED + "No loc");
    }
    }
	//bukkit.org/threads/tnt-blow-up-specific-blocks.205236/
	//bukkit.org/threads/who-placed-tnt.331672/
	
	@EventHandler
	public void die(PlayerDeathEvent event) {
		final Player player = (Player) event.getEntity();
		if (list.contains(player.getName())) {
			event.setDeathMessage(null);
			
			tell(ChatColor.GREEN + player.getName() + ChatColor.RED + " Is Out Of The Game.");
			
			score.remove(player.getName());
			list.remove(player.getName());
			player.setGameMode(GameMode.SPECTATOR);
			//Disable respawn screen when player dies in mini-game
			//Wait a second before doing this.

			
			 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
		        	@Override
		            public void run() {
		                if (player.isDead())
		                ((CraftPlayer)player).getHandle().playerConnection.a(new PacketPlayInClientCommand(EnumClientCommand.PERFORM_RESPAWN));
		    			player.teleport(Bukkit.getWorld("city").getSpawnLocation());
		            }
		        });
		}
	}
	
	@EventHandler
	public void foodchange(FoodLevelChangeEvent event) {
		if (list.contains(event.getEntity().getName()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void drop(PlayerDropItemEvent event) {
		if (list.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void destroy(BlockBreakEvent event) {
		if (list.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		Player player = event.getPlayer();
		if (list.contains(player.getName())) {
			event.setCancelled(true);
			if (event.getMessage().toLowerCase().startsWith("/leave")) {
				tell(ChatColor.GREEN + player.getName() + ChatColor.RED + " Quit The Game.");
				list.remove(player.getName());
				player.chat("/spawn");
				InvData.load(player);
			} else player.sendMessage(ChatColor.RED + "Can't Do That While In-Game, Use /leave To Exit Game");
			
			/*
			if (cmd.startsWith("mini")) {
				
				InvData.save(player);
				
				player.setGameMode(GameMode.SURVIVAL);
				player.getInventory().clear();
				player.getInventory().setBoots(new ItemStack(Material.AIR));
				player.getInventory().setLeggings(new ItemStack(Material.AIR));
				player.getInventory().setChestplate(new ItemStack(Material.AIR));
				player.getInventory().setHelmet(new ItemStack(Material.AIR));
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 7));
				player.setFoodLevel(20);
				
				MiniGame.list.add(player.getName());
				player.teleport(Bukkit.getWorld("city").getSpawnLocation());
				
				event.setCancelled(true);
				return;
			} else */
			
		}
	}
	
	@SuppressWarnings("deprecation")
	public void tell(String msg) {
		for (Player p : Bukkit.getOnlinePlayers())
    		if (list.contains(p.getName()))
    			p.sendMessage(msg);
	}
	
}
