package me.Meatie.Listiner;

import me.Meatie.Data.LocData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {

	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		LocData.read(player);
        		
		player.sendMessage(ChatColor.GREEN + "Visit " + ChatColor.RED + "bubblecraft.info" + ChatColor.GREEN + " for a update about the server");
		
        		event.setJoinMessage(null);
        		for (Player p : Bukkit.getOnlinePlayers()) {
        			if (p != player) {
        			p.sendMessage(ChatColor.YELLOW + player.getName() + " Joined The Game.");	
        			}
        		}	
	}
	
	
}
