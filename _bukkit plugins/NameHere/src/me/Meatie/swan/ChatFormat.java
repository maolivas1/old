package me.Meatie.swan;

import java.util.HashMap;

import me.Meatie.Project2.ConfigData;
import me.Meatie.Project2.Fix;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerLoginEvent;

public class ChatFormat implements Listener {
	
	static HashMap<String, String> prefix = new HashMap<String, String>();
	
	@EventHandler
	public static void login(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		if (player.hasPermission("prefix.10"))
		prefix.put(player.getName(), ConfigData.getPrefix("10"));
		else if (player.hasPermission("prefix.9"))
		prefix.put(player.getName(), ConfigData.getPrefix("9"));
		else if (player.hasPermission("prefix.8"))
		prefix.put(player.getName(), ConfigData.getPrefix("8"));
		else if (player.hasPermission("prefix.7"))
		prefix.put(player.getName(), ConfigData.getPrefix("7"));
		else if (player.hasPermission("prefix.6"))
		prefix.put(player.getName(), ConfigData.getPrefix("6"));
		else if (player.hasPermission("prefix.5"))
		prefix.put(player.getName(), ConfigData.getPrefix("5"));
		else if (player.hasPermission("prefix.4"))
		prefix.put(player.getName(), ConfigData.getPrefix("4"));
		else if (player.hasPermission("prefix.3"))
		prefix.put(player.getName(), ConfigData.getPrefix("3"));
		else if (player.hasPermission("prefix.2"))
		prefix.put(player.getName(), ConfigData.getPrefix("2"));
		else if (player.hasPermission("prefix.1"))
		prefix.put(player.getName(), ConfigData.getPrefix("1"));
		else prefix.put(player.getName(), ConfigData.getPrefix("0"));
	}
	
	@EventHandler
	public void chat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		//if (muteCommand.list.contains(event.getPlayer().getName())) {
		//	event.setCancelled(true);
		//	Commands.send(event.getPlayer(), "&cYour Muted");
		//}
		String pre = prefix.get(player.getName());
		if (pre == null) pre = "";
      event.setFormat(Fix.format(pre) + ChatColor.WHITE + event.getPlayer().getDisplayName() + ChatColor.WHITE + ": %2$s");
		if (player.hasPermission("chat.color"))
		event.setMessage(Fix.format(event.getMessage()));
	}
	
	
}
