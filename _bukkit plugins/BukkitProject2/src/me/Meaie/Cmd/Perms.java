package me.Meaie.Cmd;

import me.Meatie.Project2.Main;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

public class Perms implements Listener {
	
	@EventHandler
	public void add(PlayerLoginEvent event) {
		
		PermissionAttachment attachment = event.getPlayer().addAttachment(Main.inst);
		attachment.setPermission("bukkit.command.seed",true);
		attachment.setPermission("bukkit.command.give",true);
		attachment.setPermission("bukkit.command.time",true);
		attachment.setPermission("bukkit.command.gamemode",true);
		attachment.setPermission("bukkit.command.xp",true);
		attachment.setPermission("bukkit.command.toggledownfall",true);
		attachment.setPermission("bukkit.command.enchant",true);
		attachment.setPermission("bukkit.command.weather",true);
		attachment.setPermission("bukkit.command.clear",true);
		attachment.setPermission("bukkit.command.effect",true);
		attachment.setPermission("bukkit.command.setworldspawn",true);
		attachment.setPermission("bukkit.command.achievement",true);
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		PermissionAttachment attachment = event.getPlayer().addAttachment(Main.inst);
		event.getPlayer().removeAttachment(attachment);
	}
}

//kick = mod
//say = trusted
//list


//Make Custom Commands:
/*ban
* bans
* ranks
* unban
* defaultgamemode
* difficulty
*/