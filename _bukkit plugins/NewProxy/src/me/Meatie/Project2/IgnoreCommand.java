package me.Meatie.Project2;

import java.util.ArrayList;

import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class IgnoreCommand {

	public static ArrayList<String> ignore = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public static void cmd(ProxiedPlayer player, String[] args) {
		if (args.length == 2)
			   for (ServerInfo server : ProxyServer.getInstance().getServers().values())
			        for (ProxiedPlayer p : server.getPlayers())
				    if (p.getName().toLowerCase().startsWith(args[1].toLowerCase()))
					if (ignore.contains(player.getName() + "-" + p.getName())) {
					ignore.remove(player.getName() + "-" + p.getName());
					player.sendMessage(Main.format("&2&lUn-Ignoring &7&l" + p.getName()));
					return;
					} else {
				     ignore.add(player.getName() + "-" + p.getName());
					 player.sendMessage(Main.format("&c&lIgnoring &7&l" + p.getName()));
					 return;
					}
		player.sendMessage(Main.format("&c&lUnown Player"));
		}
}