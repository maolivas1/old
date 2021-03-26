package me.Mark.Update;

import me.Meatie.Project2.ChatFormat;
import me.Meatie.Project2.ConfigData;
import me.Meatie.Project2.Main;
import me.Meatie.Project2.PermsConfig;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.permissions.PermissionAttachment;

public class Permissions implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void login(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		addPerms(player, PermsConfig.getRank(player.getName()));
		 ChatFormat.login(player);
	}
	
	public static void addPerm(CommandSender player, String perm) {
		PermissionAttachment attachment = player.addAttachment(Main.inst);
		attachment.setPermission(perm,true);
		ConfigData.savePerm(player.getName(), perm);
	}
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
	event.getPlayer().removeAttachment(event.getPlayer().addAttachment(Main.inst));
	}
	
	public void addPerms(Player player, String rank) {
		PermissionAttachment attachment = player.addAttachment(Main.inst);
		 for (String perm : PermsConfig.getPerms(rank))
		     attachment.setPermission(perm,true);
		 String child = PermsConfig.getChild(rank);
		 if (child != null)
	addPerms(player, child);
	}
}