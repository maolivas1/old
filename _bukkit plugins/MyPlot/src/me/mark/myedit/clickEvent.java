package me.mark.myedit;

import java.util.ArrayList;
import java.util.HashMap;

import me.mark.api.ActionBarAPI;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class clickEvent implements Listener {

	static HashMap<Player, Location> pos1 = new HashMap<Player, Location>();
	static HashMap<Player, Location> pos2 = new HashMap<Player, Location>();
	ArrayList<Player> editmode = new ArrayList<Player>();
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void click(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if (player.getItemInHand().getType() == Material.FEATHER) {
			//TODO if items name is "Selection Tool"
			event.setCancelled(true);
		if(event.getAction() == (Action.RIGHT_CLICK_BLOCK)) {
			if (!editmode.contains(player)) editmode.add(player);
			if (check(player, event.getClickedBlock().getLocation(), pos1.get(player))) {
			pos2.put(player, event.getClickedBlock().getLocation());
			ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "Set Point 2", 20);
			effect(player, event.getClickedBlock().getLocation());
			} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "Selection too big..", 20);
		} else if (event.getAction() == (Action.LEFT_CLICK_BLOCK)) {
			if (!editmode.contains(player)) editmode.add(player);
			if (check(player, event.getClickedBlock().getLocation(), pos2.get(player))) {
			pos1.put(player, event.getClickedBlock().getLocation());
			ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "Set Point 1", 20);
			effect(player, event.getClickedBlock().getLocation());
			} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "Selection too big..", 20);
		} else if (event.getAction() == (Action.LEFT_CLICK_AIR) || event.getAction() == (Action.RIGHT_CLICK_AIR)) {
			if (editmode.contains(player)) editmode.remove(player);
			ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "Disabled editing mode", 20);
		}
		}
		
		if (editmode.contains(player)) {
		
		if (player.getItemInHand().getType() == Material.WATCH) {
			//TODO if items name is "Undo Tool"
			player.chat("/undo 1");
		}
		
		 if (player.isSneaking() && player.getItemInHand().getType().isBlock()) {
			 if (event.getAction() == (Action.LEFT_CLICK_BLOCK) || event.getAction() == (Action.RIGHT_CLICK_BLOCK)) {
				 Block block = event.getClickedBlock();
				 int id = block.getTypeId();
				 int data = block.getData();
					player.chat("/set " + id + ":" + data);
					event.setCancelled(true);
					effect(player, player.getLocation());
			 } else {
					player.chat("/set");
					event.setCancelled(true);
					effect(player, player.getLocation()); 
			 }
				}
		}
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		Player player = event.getPlayer();
		//TODO do i really want to do this... hmm?
		//Removes /undo logs when a player leaves the game
		if (setCommand.undo.containsKey(player))
			setCommand.undo.remove(player);
	}
	
	public static void effect(Player player, Location loc) {
		loc = loc.add(0, 1, 0);
        loc.getWorld().playEffect(loc, Effect.CLICK1, 51);
        loc.getWorld().playEffect(loc, Effect.HAPPY_VILLAGER, 51);
	}
	
	public boolean check(Player player, Location l1, Location l2) {
		int level = 0;
		if (player.hasPermission("rank.25")) level = 25;
		else if (player.hasPermission("rank.24")) level = 24;
		else if (player.hasPermission("rank.23")) level = 23;
		else if (player.hasPermission("rank.22")) level = 22;
		else if (player.hasPermission("rank.21")) level = 21;
		else if (player.hasPermission("rank.20")) level = 20;
		else if (player.hasPermission("rank.19")) level = 19;
		else if (player.hasPermission("rank.18")) level = 18;
		else if (player.hasPermission("rank.17")) level = 17;
		else if (player.hasPermission("rank.16")) level = 16;
		else if (player.hasPermission("rank.15")) level = 15;
		else if (player.hasPermission("rank.14")) level = 14;
		else if (player.hasPermission("rank.13")) level = 13;
		else if (player.hasPermission("rank.12")) level = 12;
		else if (player.hasPermission("rank.11")) level = 11;
		else if (player.hasPermission("rank.10")) level = 10;
		else if (player.hasPermission("rank.9")) level = 9;
		else if (player.hasPermission("rank.8")) level = 8;
		else if (player.hasPermission("rank.7")) level = 7;
		else if (player.hasPermission("rank.6")) level = 5;
		else if (player.hasPermission("rank.4")) level = 4;
		else if (player.hasPermission("rank.3")) level = 3;
		else if (player.hasPermission("rank.2")) level = 2;
		else if (player.hasPermission("rank.1")) level = 1;
		else if (player.hasPermission("rank.guest")) level = 0;
		
		if (level <= 2) return false;
		int blocks = count(player, l1, l2);
		if (blocks > (level - 2) * 256)
			return false;
		
		return true;
	}
	
	public int count(Player player, Location l1, Location l2) {
		if (l1 == null || l2 == null) return 0;
		return (int) (Math.abs(l1.getX()+1 - l2.getX()) * Math.abs(l1.getY()+1 - l2.getY()) * Math.abs(l1.getZ()+1 - l2.getZ()));
	}
	
}
