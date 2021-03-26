package me.Meatie.Project2;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.ServerPing;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Main extends Plugin implements Listener {
	
	public static Main inst;
	
	@Override
	public void onEnable() {
		ProxyServer.getInstance().getPluginManager().registerListener(this, this);
		inst = this;
	}
	
	  @EventHandler(priority=64)
	  public void onPing(ProxyPingEvent ev) {
	    ServerPing r = ev.getResponse();
	    ServerPing.Players p = r.getPlayers();
	    p = new ServerPing.Players(p.getOnline() + 1, p.getOnline(), p.getSample());
	    ServerPing ping = new ServerPing(r.getVersion(), p, r.getDescription(), r.getFaviconObject());
	    ev.setResponse(ping);
	  }
	
	@SuppressWarnings("deprecation")
	public void broadcast(String msg) {
		   for (ServerInfo server : ProxyServer.getInstance().getServers().values())
		        for (ProxiedPlayer p : server.getPlayers())
		    	    p.sendMessage(ChatColor.translateAlternateColorCodes('&',msg));
			inst.getLogger().info(ChatColor.translateAlternateColorCodes('&',msg));	
	}
	
	@EventHandler
	public void join(ServerKickEvent event) {
		event.getPlayer().connect(inst.getProxy().getServerInfo("lobby"));
	}
	
	/* 	@EventHandler
	public void chat(ChatEvent event) {
		//ProxiedPlayer player = (ProxiedPlayer) event.getSender();
		//String[] args = event.getMessage().substring(1).split(" ");
		if (event.getMessage().startsWith("/")) return;
		event.setCancelled(true);
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
	
	
}