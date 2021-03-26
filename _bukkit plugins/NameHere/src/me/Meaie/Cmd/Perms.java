package me.Meaie.Cmd;

import me.Meatie.Project2.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

public class Perms implements Listener {
	
	public static int cheats = 0;
	
	@EventHandler
	public void add(PlayerLoginEvent event) {
		update(event.getPlayer());
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		event.getPlayer().removeAttachment(event.getPlayer().addAttachment(Main.inst));
	}
	
	public static void update(Player player) {
		PermissionAttachment attachment = player.addAttachment(Main.inst);
		
		attachment.setPermission("bukkit.command.seed",true);
		attachment.setPermission("bukkit.command.list",true);
		attachment.setPermission("bukkit.command.say",true);
		attachment.setPermission("bukkit.command.teleport",true);
		attachment.setPermission("bukkit.command.time",true);
		attachment.setPermission("bukkit.command.clear",true);
		attachment.setPermission("bukkit.command.give",true);
		attachment.setPermission("bukkit.command.gamemode",true);
	}
}