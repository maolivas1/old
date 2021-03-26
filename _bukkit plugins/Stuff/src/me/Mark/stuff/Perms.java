package me.Mark.stuff;

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
		attachment.setPermission("minecraft.command.me",false);
		attachment.setPermission("bukkit.command.version",false);
		attachment.setPermission("lockette.user.create.*",true);
		attachment.setPermission("coreprotect.inspect",true);
		attachment.setPermission("essentials.hat",true);
		attachment.setPermission("essentials.nick",true);
		attachment.setPermission("essentials.nick.color",true);
		attachment.setPermission("essentials.mail",true);
		attachment.setPermission("essentials.mail.send",true);
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
	event.getPlayer().removeAttachment(event.getPlayer().addAttachment(Main.inst));
	}
}