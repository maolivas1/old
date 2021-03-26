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
		PermissionAttachment attachment = event.getPlayer().addAttachment(Main.inst);
		event.getPlayer().removeAttachment(attachment);
	}
	
	public static void update(Player player) {
		PermissionAttachment attachment = player.addAttachment(Main.inst);
		player.removeAttachment(attachment);
		
		attachment.setPermission("bukkit.command.seed",true);
		attachment.setPermission("bukkit.command.list",true);
		attachment.setPermission("bukkit.command.say",true);
		attachment.setPermission("meatie.hat",true);
		
		if (cheats >= 1) {
			attachment.setPermission("meatie.top",true);
			attachment.setPermission("meatie.spawn",true);
			attachment.setPermission("bukkit.command.teleport",true);
			attachment.setPermission("bukkit.command.time",true);
			attachment.setPermission("bukkit.command.toggledownfall",true);
			attachment.setPermission("bukkit.command.weather",true);
		}
		
		if (cheats >= 2) {
			attachment.setPermission("meatie.killall",true);
			attachment.setPermission("meatie.repair",true);
			attachment.setPermission("meatie.heal",true);
		}
		
		if (cheats >= 3) {
		attachment.setPermission("bukkit.command.give",true);
		attachment.setPermission("bukkit.command.gamemode",true);
		attachment.setPermission("bukkit.command.xp",true);
		attachment.setPermission("bukkit.command.enchant",true);
		attachment.setPermission("bukkit.command.clear",true);
		attachment.setPermission("bukkit.command.effect",true);
		attachment.setPermission("bukkit.command.achievement",true);
		}
	}
}