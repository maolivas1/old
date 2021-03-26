package me.Meatie.msgedit;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerListPingEvent;

public class Listiner implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
        	TitleAPI.sendTabTitle(player, Main.top.replace("$player", player.getName()), Main.bottom.replace("$player", player.getName()));
             send(player, format(Main.quick.replace("$player", player.getName())));
             
      	   if (Main.ownlogin == true)
             for (Player p : Bukkit.getOnlinePlayers())
            	 if (p != player)
            		 p.sendMessage(format(Main.login.replace("$player", player.getName())));
            	 else {
            		 
            	 }
	}
	
	   @EventHandler
	    public void update(ServerListPingEvent event) {
	          event.setMotd(format(Main.motd));
	     }
	
	//TODO Leave Message
	   

	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		final Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		if (cmd.equals("configedit")) {
	 event.setCancelled(true);
	 if (!player.isOp()) {
		 sendmsg(player, "&cOperators Only");
		 return;
	 }
			 if (args.length >= 2) {
				 String msg = event.getMessage().substring(args[0].length() + args[1].length() + 3);
				 if (args[1].equalsIgnoreCase("quick")) {
					 ConfigData.save("quick", msg);
					 Main.quick = msg;
				 } else if (args[1].equalsIgnoreCase("top")) {
			for (Player p : Bukkit.getOnlinePlayers())
			TitleAPI.sendTabTitle(p, Main.top.replace("$player", p.getName()), Main.bottom.replace("$player", p.getName()));
				 ConfigData.save("top", msg);
				 Main.top = msg;
			 } else if (args[1].equalsIgnoreCase("login")) {
				 ConfigData.save("login", msg);
				 Main.login = msg;
			 } else if (args[1].equalsIgnoreCase("bottom")) {
		for (Player p : Bukkit.getOnlinePlayers())
		TitleAPI.sendTabTitle(p, Main.top.replace("$player", p.getName()), Main.bottom.replace("$player", p.getName()));
				 ConfigData.save("bottom", msg);
				 Main.bottom = msg;
			 } else if (args[1].equalsIgnoreCase("leave")) {
				 ConfigData.save("leave", msg);
				 Main.leave = msg;
			 } else if (args[1].equalsIgnoreCase("motd")) {
				 ConfigData.save("motd", msg);
				 Main.motd = msg;
			 } else if (args[1].equalsIgnoreCase("ownlogin")) {
				 ConfigData.save("ownlogin", msg);
				 if (msg.equalsIgnoreCase("true")) Main.ownlogin = true;
				 else Main.ownlogin = false;
			 } else {
				 sendmsg(player, "&d/configedit");
				 sendmsg(player, "&dquick: &eMessage above inventory at login.");
				 sendmsg(player, "&dtop: &eMessage above player names in Tab list.");
				 sendmsg(player, "&dbottom: &eMessage below player names in Tab list.");
				 sendmsg(player, "&dlogin: &e'Player Joined the game!'");
				 sendmsg(player, "&dleave: &e'Player Left the game!'");
				 sendmsg(player, "&dmotd: &eMsg shown in server list");
				 sendmsg(player, "&downlogin: &eShow player their own login message?");
			 }
			 } else {
				 sendmsg(player, "&d/configedit");
				 sendmsg(player, "&dquick: &eMessage above inventory at login.");
				 sendmsg(player, "&dtop: &eMessage above player names in Tab list.");
				 sendmsg(player, "&dbottom: &eMessage below player names in Tab list.");
				 sendmsg(player, "&dlogin: &e'Player Joined the game!'");
				 sendmsg(player, "&dleave: &e'Player Left the game!'");
				 sendmsg(player, "&dmotd: &eMsg shown in server list");
				 sendmsg(player, "&downlogin: &eShow player their own login message?");
			 }
}
}
	
	  public static void send(Player p, String msg) {
		    String s = ChatColor.translateAlternateColorCodes('&', msg);
		    IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s + "\"}");
		    PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
		    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
		  }
	
	  public static void sendmsg(Player p, String msg) {
		  p.sendMessage(format(msg));
	  }
	  
	public static String format(String input) {
		return ChatColor.translateAlternateColorCodes('&',input);
	}
	
}
