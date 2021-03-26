package me.Meatie.Perms;

import me.Mark.yourworld.Main;

import org.bukkit.command.CommandSender;
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
		attachment.setPermission("multiinv.exempt",false);
		attachment.setPermission("lockette.user.create.*",true);
		attachment.setPermission("coreprotect.inspect",true);
		attachment.setPermission("essentials.setwarp",true);
		attachment.setPermission("essentials.warp.overwrite." + player.getName(),true);
		
		attachment.setPermission("essentials.enchant",true);
		attachment.setPermission("essentials.fly",true);
		attachment.setPermission("essentials.gamemode",true);
		attachment.setPermission("essentials.god",true);
		attachment.setPermission("essentials.hat",true);
		attachment.setPermission("essentials.heal",true);
		attachment.setPermission("essentials.repair",true);
		attachment.setPermission("essentials.repair.all",true);
		attachment.setPermission("essentials.repair.armor",true);
		attachment.setPermission("essentials.repair.enchanted",true);
		attachment.setPermission("essentials.time",true);
		attachment.setPermission("essentials.time.set",true);
		attachment.setPermission("essentials.help",true);
		attachment.setPermission("essentials.ignore",true);
		attachment.setPermission("essentials.list",true);
		attachment.setPermission("essentials.mail",true);
		attachment.setPermission("essentials.mail.send",true);
		attachment.setPermission("essentials.msg",true);
		attachment.setPermission("essentials.msg.color",true);
		attachment.setPermission("essentials.msg.format",true);
		attachment.setPermission("essentials.msg.magic",true);
		attachment.setPermission("essentials.msg.multiple",true);
		attachment.setPermission("essentials.msg.url",true);
		attachment.setPermission("essentials.nick",true);
		attachment.setPermission("essentials.nick.color",true);
		attachment.setPermission("essentials.nick.format",true);
		attachment.setPermission("essentials.nick.magic",true);
		attachment.setPermission("essentials.seen",true);
		attachment.setPermission("essentials.spawner",true);
		attachment.setPermission("essentials.spawner.*",true);
		attachment.setPermission("essentials.suicide",true);
		attachment.setPermission("essentials.whois",true);
		attachment.setPermission("essentials.clearinventory",true);
		attachment.setPermission("essentials.invsee",true);
		attachment.setPermission("essentials.mute",true);
		attachment.setPermission("essentials.remove",true);//killall
		attachment.setPermission("essentials.spawnmob",true);
		attachment.setPermission("essentials.spawnmob.*",true);
		attachment.setPermission("essentials.spawnmob.stack",true);
		attachment.setPermission("essentials.back",true);
		attachment.setPermission("essentials.back.ondeath",true);
		attachment.setPermission("essentials.delhome",true);
		attachment.setPermission("essentials.home",true);
		attachment.setPermission("essentials.jump",true);
		attachment.setPermission("essentials.sethome",true);
		attachment.setPermission("essentials.top",true);
		attachment.setPermission("essentials.tp",true);
		attachment.setPermission("essentials.tpa",true);
		attachment.setPermission("essentials.tpaccept",true);
		attachment.setPermission("essentials.tpahere",true);
		attachment.setPermission("essentials.tpdeny",true);
		attachment.setPermission("essentials.warp",true);
		attachment.setPermission("essentials.warp.list",true);
		attachment.setPermission("essentials.warps.*",true);
		
		
		// for (String perm : ConfigData.getPerms(player.getName()))
	    //attachment.setPermission(perm,true);
	}
	
	
	public static void addPerm(CommandSender player, String perm) {
		PermissionAttachment attachment = player.addAttachment(Main.inst);
		attachment.setPermission(perm,true);
		//ConfigData.savePerm(player.getName(), perm);
	}
	
	
	@EventHandler
	public void leave(PlayerQuitEvent event) {
	event.getPlayer().removeAttachment(event.getPlayer().addAttachment(Main.inst));
	}
}