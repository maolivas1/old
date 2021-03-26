package me.Meaie.Cmd;

import me.Meatie.Data.RankData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Restrications implements Listener {
	
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		String[] args = event.getMessage().split(" ");
		String cmd = args[0].toLowerCase().replace("/", "");
		Player player = event.getPlayer();
		
		if (player.isOp()) return;
		
		if (cmd.startsWith("bukkit:") || cmd.startsWith("minecraft:")) {
			player.sendMessage(ChatColor.RED + "Sorry, Can't Do That..");
			event.setCancelled(true);
		}

		if (args.length >= 2)
		if (online(args[1]) != null) {
		String world = online(args[1]).getWorld().getName();
		
		if (cmd.equals("give"))
			if (notRank(event, world, player, "mod"))
				return;
			
		 if (cmd.equals("enchant"))
			if (notRank(event, world, player, "mod"))
				return;
			
	     if (cmd.equals("effect"))
			if (notRank(event, world, player, "mod"))
				return;
			
		  if (cmd.equals("clear"))
			if (notRank(event, world, player, "admin"))
				return;
		}
		
		if (args.length >= 3)
		if (online(args[2]) != null) {
		String world = online(args[2]).getWorld().getName();
		
		if (cmd.equals("gamemode"))
			if (notRank(event, world, player, "mod"))
				return;
		
		if (cmd.equals("xp"))
			if (notRank(event, world, player, "mod"))
				return;
		}
		
		if (args.length >= 4)
		if (online(args[3]) != null) {
		String world = online(args[3]).getWorld().getName();
		
		if (cmd.equals("achievement"))
			if (notRank(event, world, player, "trusted"))
				return;
		}
		
		//Self Commands
		if (args.length == 2) {
		if (cmd.equals("gamemode"))
			if (notRank(event, player.getWorld().getName(), player, "mod"))
			return;
		
		if (cmd.equals("xp"))
			if (notRank(event, player.getWorld().getName(), player, "mod"))
			return;
		}
		
		if (args.length == 1)
		if (cmd.equals("clear"))
			if (notRank(event, player.getWorld().getName(), player, "trusted"))
			return;
		
		
	}
	
	public boolean notRank(PlayerCommandPreprocessEvent event, String world, Player player, String rank) {
		
		if (world.equals(player.getName()))
		return false;
			
			if (!RankData.check(world, player.getName(), rank)) {
				Msg.notallowed(player);
				event.setCancelled(true);
				return true;
				}
		
		return false;
	}
	
	@SuppressWarnings("deprecation")
	public static Player online(String player) {
		for (Player p : Bukkit.getOnlinePlayers()) {
		if (p.getName().equalsIgnoreCase(player))
			return p;
		}
		return null;
	}
	
}
