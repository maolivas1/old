package me.Mark.mark;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.Warps;

public class cmdFix implements Listener {
	
	Essentials ess = Vaulteconomy.ess;
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		String cmd = event.getMessage().toLowerCase();
		Player player = event.getPlayer();
		if (cmd.startsWith("/pl") || cmd.startsWith("/bukkit:") || cmd.startsWith("/plugins") || cmd.startsWith("/ver") || cmd.startsWith("/version")
				 || cmd.startsWith("/minecraft:") || cmd.startsWith("/essentials:")) {
			event.setCancelled(true);
			player.sendMessage("Unknown command. Type '/help' for help.");
			
			
		} else if (cmd.startsWith("/setwarp") || cmd.startsWith("/sethome")) {
			event.setCancelled(true);
			
			try {
				Warps w = ess.getWarps();
	            w.setWarp(player.getName(), player.getLocation());
			} catch (Exception e) {}
			
			player.sendMessage(ChatColor.GREEN + "Warp Set: " + ChatColor.GOLD +  player.getName());
			
		} else if (cmd.equals("/inspect") || cmd.equals("/c")) {
			event.setCancelled(true);
			player.chat("/core inspect");
			
		} else if (cmd.equals("/home")) {
			event.setCancelled(true);
			player.chat("/warp " + player.getName());
			
		} else if (cmd.equals("/sell")) {
			event.setCancelled(true);
			
			ItemStack item = player.getItemInHand();
			
			if (ess.getWorth().getPrice(item) == null) {
				player.sendMessage(ChatColor.DARK_RED + "Item not found in shop, setting sell value to: " + ChatColor.GREEN + "$1");
				ess.getWorth().setPrice(item, 1);
			} else {
				player.chat("/sell hand");
			}
		} else if (cmd.equals("/time")) {
			event.setCancelled(true);
			player.sendMessage(ChatColor.GRAY + "/day or /night");
		}
		
		
	}
	
	
}
