package me.Meatie.Project2;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

public class Main extends Plugin implements Listener {
	
	public static Main inst;
	
	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerListener(this, this);
	}
    /*
	@SuppressWarnings("deprecation")
	@EventHandler
	public void chat(ChatEvent event) {
		ProxiedPlayer player = (ProxiedPlayer) event.getSender();
		//String[] args = event.getMessage().substring(1).split(" ");
		if (event.getMessage().startsWith("/")) return;
		event.setCancelled(true);
		   for (ServerInfo server : ProxyServer.getInstance().getServers().values())
			        for (ProxiedPlayer p : server.getPlayers())
			        	if (!IgnoreCommand.ignore.contains(p.getName() + "-" + player.getName()))
			    	    p.sendMessage(nickFormat(player.getName()) + ChatColor.WHITE + ": " + format(event.getMessage()));
			    	    log(player.getName() + ChatColor.WHITE + ": " + event.getMessage());
			    		//Lain.think(player, event.getMessage());
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PostLoginEvent event) {
		   for (ServerInfo server : ProxyServer.getInstance().getServers().values())
		        for (ProxiedPlayer p : server.getPlayers())
		        p.sendMessage(ChatColor.YELLOW + event.getPlayer().getName() + " Joined The Game");
		event.getPlayer().sendMessage(format("&9&lWelcome To The Server"));
	}
	
	@SuppressWarnings("deprecation")
	public void leave(ServerDisconnectEvent event) {
		   for (ServerInfo server : ProxyServer.getInstance().getServers().values())
		        for (ProxiedPlayer p : server.getPlayers())
		        p.sendMessage(ChatColor.YELLOW + event.getPlayer().getName() + " Left The Game");
	}
	*/
	public static String nickFormat(String input) {
	input = input.replace("&k", "").replace("&l", "").replace("&n", "")
			     .replace("&K", "").replace("&L", "").replace("&N", "");
		return ChatColor.translateAlternateColorCodes('&', 
		   input.replace("(heart)", "❤").replace("(check)", "✔").replace("(music)", "♪").replace("(tempc)", "℃")
				.replace("(plane)", "✈").replace("(x)", "✘").replace("(pencil)", "✎").replace("(mail)", "✉")
				.replace("(right)", "➡").replace("(music2)", "♫").replace("(snowflake)", "❄").replace("(tempf)", "℉"));
	}
	
	public static String format(String input) {
	input = input.replace("&k", "").replace("&l", "").replace("&n", "")
			     .replace("&K", "").replace("&L", "").replace("&N", "");
		return caps(ChatColor.translateAlternateColorCodes('&', 
		   input.replace("(heart)", "❤").replace("(check)", "✔").replace("(music)", "♪").replace("(tempc)", "℃")
				.replace("(plane)", "✈").replace("(x)", "✘").replace("(pencil)", "✎").replace("(mail)", "✉")
				.replace("(right)", "➡").replace("(music2)", "♫").replace("(snowflake)", "❄").replace("(tempf)", "℉")));
	}
	
	public static String Consoleformat(String input) {
		input = input.toLowerCase().replace("&k", "").replace("&m", "").replace("&l", "").replace("&n", "").replace("&o", "");
		return caps(ChatColor.translateAlternateColorCodes('&', input));
	}
	
	public static String caps(String str) {
		String[] args = str.split(" ");
		String newString = "";
		for (String s : args) {
			int count = 0;
		for (int i = s.length() - 1; i >= 0; i--)
	        if (Character.isUpperCase(s.charAt(i)))
	        	count++;
		if (count > 2)
		    newString = newString + " " + s.toLowerCase();
		    else if (newString == "") newString = s;
		    else newString = newString + " " + s;
		}
		return newString;
	}
	
	public static void log(String msg) {
		inst.getLogger().info(Consoleformat(msg));
	}
	
	
}