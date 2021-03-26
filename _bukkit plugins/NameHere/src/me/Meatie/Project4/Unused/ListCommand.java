package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class ListCommand {

	@SuppressWarnings("deprecation")
	public static void cmd(CommandSender player, String[] args) {
		String list = "";
	    for (ServerInfo server : ProxyServer.getInstance().getServers().values())
	    for (ProxiedPlayer p : server.getPlayers())
		if (list == "") list = p.getName();
		else list = list + ChatColor.GREEN + ", " + ChatColor.WHITE + p.getName();
		player.sendMessage(ChatColor.GREEN + Main.format(list));
	}
	
}
