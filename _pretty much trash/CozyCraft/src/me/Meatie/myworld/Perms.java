package me.Meatie.myworld;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

public class Perms implements Listener {
	
	@EventHandler
	public void add(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		PermissionAttachment attachment = player.addAttachment(Main.inst);
		attachment.setPermission("minecraft.command.time",true);
		attachment.setPermission("minecraft.command.me",false);
		attachment.setPermission("coreprotect.inspect",true);
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
	event.getPlayer().removeAttachment(event.getPlayer().addAttachment(Main.inst));
	}
}