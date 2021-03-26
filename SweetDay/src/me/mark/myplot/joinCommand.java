package me.mark.myplot;

import java.util.ArrayList;
import java.util.HashMap;

import me.mark.api.ActionBarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class joinCommand implements CommandExecutor {

	static HashMap<String, ArrayList<Player>> players = new HashMap<String, ArrayList<Player>>();
	static HashMap<Player, String> que = new HashMap<Player, String>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String cmd, String[] args) {
			
		Player player = null;
		
		if (sender instanceof Player) {
			player = (Player)sender;
		} else if (args.length == 2)
			for (Player p : Bukkit.getOnlinePlayers())
			if (p.getName().equalsIgnoreCase(args[1]))
				player = p;
		
		if (player == null) return true;
		
		if (que.containsKey(player)) {
			ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "You're already in a query!", 40);
			return true;
		}
		
		if (args.length >= 1) {
					
				if (players.containsKey(args[0])) {
					ArrayList<Player> list = players.get(args[0]);
					
					if (list.size() == 6) {
						ActionBarAPI.sendActionBar(player, ChatColor.GREEN + "" + ChatColor.BOLD + "That game is full!", 40);
						return true;
					}
					
					if (!list.contains(player)) {
					list.add(player);
					players.put(args[0], list);
					ActionBarAPI.sendActionBar(player, ChatColor.GREEN + "" + ChatColor.BOLD + "Waiting for more players!", 40);
					que.put(player, args[0]);
					} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "You're already in the query!", 40);
				} else {
					ArrayList<Player> list = new ArrayList<Player>();
					list.add(player);
					players.put(args[0], list);
					ActionBarAPI.sendActionBar(player, ChatColor.GREEN + "" + ChatColor.BOLD + "Waiting for more players!", 40);
					que.put(player, args[0]);
				}
		}
		return true;
	}
	
}
