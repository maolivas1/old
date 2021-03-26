package me.Meatie.Project2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		//ConfigData.error();
		//ConfigData.speed();
	}
	
	 @EventHandler
	 public void lavaflow(BlockFromToEvent event) {
		 if (on == false) return;
	 if (event.getBlock().getType() == Material.LAVA) {
	 set(event.getBlock().getLocation());
	 event.setCancelled(true);
	  }
	 }
	 
	 static int speed = 4;
	 
	 public void set(final Location loc) {
		 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
	            @Override
	            public void run() {
	            Block b1 = new Location(loc.getWorld(), loc.getX() + 1, loc.getY(), loc.getZ()).getBlock();
	              if (b1.getType() == Material.AIR) b1.setType(Material.LAVA);
	            Block b2 = new Location(loc.getWorld(), loc.getX() - 1, loc.getY(), loc.getZ()).getBlock();
           	  if (b2.getType() == Material.AIR) b2.setType(Material.LAVA);
	            Block b3 = new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ() + 1).getBlock();
           	  if (b3.getType() == Material.AIR) b3.setType(Material.LAVA);
	            Block b4 =  new Location(loc.getWorld(), loc.getX(), loc.getY(), loc.getZ() - 1).getBlock();
           	  if (b4.getType() == Material.AIR) b4.setType(Material.LAVA);
	            }
		 }, speed);
	 }
	 
	 static boolean on = false;
	 static String error = "&eCan't Do That.";
	 static String enable = "&aEnabled Lava Flow";
	 static String disable = "&cDisabled Lave Flow";
	 
		@EventHandler
		public void command(PlayerCommandPreprocessEvent event) {
			if (event.isCancelled()) return;
			Player player = event.getPlayer();
			if (!player.hasPermission("lavaflow.toggle")) {
			player.sendMessage(ChatColor.translateAlternateColorCodes('&', error));
			return;
			}
			String[] args = event.getMessage().substring(1).split(" ");
			String cmd = args[0].toLowerCase();
		 if (cmd.equals("lava")) {
			 if (on == false) {
			 player.sendMessage(ChatColor.translateAlternateColorCodes('&', enable));
			 on = true;
			 } else {
				 player.sendMessage(ChatColor.translateAlternateColorCodes('&', disable));
				 on = false;
			 }
		 }
		}
	
}