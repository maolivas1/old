package me.Meatie.Project4.Unused;

import java.util.HashMap;

import me.Meatie.Data.NickData;
import me.Meatie.Project2.Commands;
import me.Meatie.Project2.Fix;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Nick {

	public static HashMap<String, String> nick = new HashMap<String, String>();
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			NickData.save(player, args[1]);
			Commands.send(player, "&2&lNickname Now &7&l" + args[1].replace("&", "§"));
			
    		if(ChatColor.stripColor(Fix.format(args[1])).length() <= 14)
       		 player.setPlayerListName(Fix.format(args[1]));
       		 else
       	     player.setPlayerListName(Fix.format(args[1]).substring(0, 14));
		} else Commands.send(player, "&c&l/nick &7&lNickname");
	}
}