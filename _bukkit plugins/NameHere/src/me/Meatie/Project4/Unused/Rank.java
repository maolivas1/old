package me.Meatie.Project4.Unused;

import java.util.HashMap;

import me.Meatie.Data.RankData;
import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Rank {

	public static HashMap<String, String> rank = new HashMap<String, String>();
	
	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 3) {
			for (OfflinePlayer p : Bukkit.getOfflinePlayers())
				if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					
					String rank = args[2].toLowerCase();
					if (rank.equals("builder") || rank.equals("mod")) {
					
					RankData.set(p.getName(), rank);
				    Commands.send(player, "&7&l" + p.getName() + "&2&l Is Now Ranked &7&l" + rank);
				    
					for (Player pl : Bukkit.getOnlinePlayers())
						if (pl.getName().equals(p.getName()))
							Commands.send(pl, "&7&l" + player.getName() + " &2&lRanked You &7&l" + rank); 
				    
					} else Commands.send(player, "&c&l/rank &7&lPlayer &2&l[&7&lbuilder&2&l, &7&lmod&2&l]");
					return;
				}
			Commands.send(player, "&c&lUnknown Player");
		} else {
			if (rank.containsKey(player.getName()))
			Commands.send (player, "&2&l You'r Rank Is &7&l" + rank.get(player.getName()));
			else Commands.send (player, "&2&l You'r Rank Is &7&lGuest");
		}
	}
	
	public static String getRank(Player player) {
		String rank = "guest";
		if (Rank.rank.containsKey(player.getName()))
			rank = Rank.rank.get(player.getName());
		return rank;
	}
	
}
