package me.mark.myplot;

import java.util.ArrayList;

import me.mark.api.ActionBarAPI;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class leaveCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String cmd, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (joinCommand.que.containsKey(player)) {
				String arena = joinCommand.que.get(player);
				joinCommand.que.remove(player);
				
				ArrayList<Player> list = joinCommand.players.get(arena);
				if (list.contains(player)) {
					list.remove(player);
					joinCommand.players.put(arena, list);
				}
				ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "left query!", 40);
		} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "You wern't in a query!", 40);
			
			
			
		}
		
		return true;
	}
	
}
