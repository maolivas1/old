package me.Mark.stuff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CmdFix implements Listener {

	@EventHandler
	public void cmd(PlayerCommandPreprocessEvent event) {
		if (event.getMessage().equalsIgnoreCase("/sell")) {
			event.setCancelled(true);
			event.getPlayer().chat("/sell hand");;
		}
	}
	
	
}
