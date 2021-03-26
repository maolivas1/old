package me.Meatie.Project2;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
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
	  
		@EventHandler
		public void command(PlayerCommandPreprocessEvent event) {
			if (event.isCancelled()) return;
			final Player player = event.getPlayer();
			String[] args = event.getMessage().substring(1).split(" ");
			String cmd = args[0].toLowerCase();
			
		 if (cmd.equals("c") || cmd.equals("inspect")) {
			 event.setCancelled(true);
			 player.chat("/core inspect");
		 } else if (cmd.equals("ban")) {
			 event.setCancelled(true);
			 if (player.hasPermission("meatie.ban")) {
			 if (args.length == 2) {
			 for (OfflinePlayer p: Bukkit.getOfflinePlayers())
				 if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + p.getName() + " 604801 Banned By " + player.getName());
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mail send meatie " + player.getName() + " #Banned# " + p.getName());
					 Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + ChatColor.GREEN + " Banned " + ChatColor.GRAY + p.getName());
					 player.getAddress().getAddress().getHostAddress().replace("/", "");
					 return;
				 }
				 player.sendMessage(ChatColor.RED + "Unknown Player");
			 } else player.sendMessage(ChatColor.RED + "/ban " + ChatColor.GRAY + "player");
			 } else player.sendMessage(ChatColor.RED + "Can't Do That...");
		 } else if (cmd.equals("mail")) {
			 if (args.length == 2)
				 if (args[1].equalsIgnoreCase("read")) {
		        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
		            @Override
		            public void run() {
						player.chat("/mail clear");
		            }
		        });
				 }
		 } else if (cmd.equals("builder")) {
			 event.setCancelled(true);
			 if (player.hasPermission("meatie.ban")) {
			 if (args.length == 2) {
				for (OfflinePlayer p: Bukkit.getOfflinePlayers())
				 if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "perms setrank " + p.getName() + " builder");
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mail send meatie " + player.getName() + " #Builder# " + p.getName());
					 Bukkit.broadcastMessage(ChatColor.GRAY + player.getName() + ChatColor.GREEN + " Gave Builder To " + ChatColor.GRAY + p.getName());
					 return;
				 }
				 player.sendMessage(ChatColor.RED + "Unknown Player");
			 } else player.sendMessage(ChatColor.RED + "/builder " + ChatColor.GRAY + "player");
			 } else player.sendMessage(ChatColor.RED + "Can't Do That..."); 
		 } else if (cmd.equals("help")) {
			 event.setCancelled(true);
			 player.sendMessage(ChatColor.GREEN + "back, bal, baltop, delhome, ec, hat, home, ignore, invsee, list, mail msg, nick, pay, recpie, seen, sell, sethome, suicide, tpa, tpaccept, "
			 		+ "tpahere, tptoggle, warp, whois, wb, worth, spawn");
			 if (player.hasPermission("group.youtube"))
			 player.sendMessage(ChatColor.DARK_PURPLE + "Youtube Commands: vanish, heal, head, top, tp");
			 if (player.hasPermission("group.mod"))
			 player.sendMessage(ChatColor.DARK_GREEN + "Mod Commands: tp, top, mute, kick, ban");
			 
			 
		 }
		 
		}
}
