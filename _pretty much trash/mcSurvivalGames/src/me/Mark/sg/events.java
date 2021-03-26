package me.Mark.sg;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class events implements Listener {
	
	static boolean active = false;
	static ArrayList<String> inGame = new ArrayList<String>();
	
	@EventHandler
	public void destroy(BlockBreakEvent event) {
		if (inGame.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void build(BlockPlaceEvent event) {
		if (inGame.contains(event.getPlayer().getName()))
			event.setCancelled(true);
	}
	
	@EventHandler
	public void move(PlayerMoveEvent event) {
		if (inGame.contains(event.getPlayer().getName()) && !active)
		if (event.getFrom().getZ() != event.getTo().getZ() && event.getFrom().getX() != event.getTo().getX())
			event.getPlayer().teleport(event.getFrom());
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		if (inGame.contains(player.getName())) {
			events.alert(ChatColor.RED + player.getName() + " Left the game!");
			events.inGame.remove(player.getName());
			check();
		}
	}
	
	@EventHandler 
	public void die(PlayerDeathEvent event) {
		Player player = (Player) event.getEntity();
		if (inGame.contains(player.getName())) {
			events.alert(ChatColor.RED + player.getName() + " Died!");
			events.inGame.remove(player.getName());
			check();
		}
	}
	
	public static void fillChest() {
		ArrayList<Location> chests = ConfigStuff.get("chests");
		for (Location loc : chests) {
		Block block = loc.getWorld().getBlockAt(loc);
		Chest chest = ((Chest) block.getState());
		chest.getInventory().addItem(new ItemStack(randItem(), 1));
		chest.getInventory().addItem(new ItemStack(randItem(), 1));
		chest.getInventory().addItem(new ItemStack(randItem(), 1));
		}
	}
	
	public static Material randItem() {
	    Random rand = new Random();
	    int n = rand.nextInt((4) + 1);
		if (n == 0) return Material.BOW;
		else if (n == 1) return Material.ARROW;
		else if (n == 2) return Material.WOOD_SWORD;
		else if (n == 3) return Material.STONE_SWORD;
		else if (n == 4) return Material.ARROW;
		return Material.IRON_SWORD;
	}
	
	public static void check() {
		if (inGame.size() == 1) {
			String winner = inGame.get(0);
			events.inGame.remove(winner);
			Bukkit.broadcastMessage(ChatColor.GREEN + winner + " wins!");
			active = false;
		}
		
	}
	
	public static void alert(String msg) {
		for (String p : inGame)
		Bukkit.getPlayer(p).sendMessage(msg);
	}
	
}
