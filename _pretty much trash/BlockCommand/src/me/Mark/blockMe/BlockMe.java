package me.Mark.blockMe;

import java.util.ArrayList;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class BlockMe implements Listener {
	
	static ArrayList<String> cmds = new ArrayList<String>();
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent event) {
		if (event.isCancelled()) return;
		Player player = event.getPlayer();
		String[] args = event.getMessage().substring(1).split(" ");
		String cmd = args[0].toLowerCase();
		
	 if (cmd.equals("c") ) {
		 if (!player.hasPermission("cmdblock."))
		 event.setCancelled(true);
	 }
	}
	
	
}
