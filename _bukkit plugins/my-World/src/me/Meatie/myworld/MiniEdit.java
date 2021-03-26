package me.Meatie.myworld;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class MiniEdit implements Listener {
	
	HashMap<String, Location> loc1 = new HashMap<String, Location>();
	HashMap<String, Location> loc2 = new HashMap<String, Location>();
	
	@EventHandler
	public void interact(PlayerInteractEvent event) {
		if (event.getClickedBlock() == null) return;
		if (event.getPlayer().getItemInHand().getType() != Material.FEATHER) return;
		Player player = event.getPlayer();
		Location loc = event.getClickedBlock().getLocation();
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			loc1.put(player.getName(), loc);
			Commands.sendmsg(player, "&aSecond Position Set At: &7" + loc.getX() + " " + loc.getY() + " " + loc.getZ());
		}
		else if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			event.setCancelled(true);
			loc2.put(player.getName(), loc);
			Commands.sendmsg(player, "&aFirst Position Set At: &7" + loc.getX() + " " + loc.getY() + " " + loc.getZ());
		}
	}
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		
	  if (cmd.equals("set") || cmd.equals("fill") || cmd.equals("replace")) {
		  event.setCancelled(true);
		  if (!player.hasPermission("minecraft.command.fill")) {
			  Commands.sendmsg(player, "&cCan't Do That.");
			  return;
		  }
			if (args.length >= 2) {
			if (!loc1.containsKey(player.getName())) {
				Commands.sendmsg(player, "&cSet A Second Position First.");
				return;
			}
			if (!loc2.containsKey(player.getName())) {
				Commands.sendmsg(player, "&cSet A First Position First.");
				return;
			}
		  
		 event.setCancelled(true);
		 Location p1 = loc1.get(player.getName());
		 Location p2 = loc2.get(player.getName());
		 if (cmd.equals("fill") || cmd.equals("set"))
		 player.chat("/minecraft:fill " + String.valueOf(p1.getX()).replace(".0", "") + " " + String.valueOf(p1.getY()).replace(".0", "") + " " + String.valueOf(p1.getZ()).replace(".0", "") + " " + String.valueOf(p2.getX()).replace(".0", "") + " " + String.valueOf(p2.getY()).replace(".0", "") + " " + String.valueOf(p2.getZ()).replace(".0", "") + " " + args[1]);
		 else if (args.length >= 3) {
				player.chat("/minecraft:fill " + String.valueOf(p1.getX()).replace(".0", "") + " " + String.valueOf(p1.getY()).replace(".0", "") + " " + String.valueOf(p1.getZ()).replace(".0", "") + " " + String.valueOf(p2.getX()).replace(".0", "") + " " + String.valueOf(p2.getY()).replace(".0", "") + " " + String.valueOf(p2.getZ()).replace(".0", "") + " " + args[2] + " 0 replace " + args[1]);
				} else Commands.sendmsg(player, "&a/replace &cReplaceFrom &cReplaceTo");
			} else Commands.sendmsg(player, "&a/fill &cType");
	  }
	}
}
