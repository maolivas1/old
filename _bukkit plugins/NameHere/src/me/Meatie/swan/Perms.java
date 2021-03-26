package me.Meatie.swan;

import me.Meatie.Project2.ConfigData;
import me.Meatie.Project2.Main;

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
		attachment.setPermission("minecraft.command.time",true);
		attachment.setPermission("minecraft.command.me",false);
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
		attachment.setPermission("essentials.recipe",true);
		attachment.setPermission("essentials.seen",true);
		attachment.setPermission("essentials.whois",true);
		attachment.setPermission("essentials.ban.notify",true);
		attachment.setPermission("essentials.clearinventory",true);
		attachment.setPermission("essentials.kick.notify",true);
		attachment.setPermission("essentials.mute.notify",true);
		attachment.setPermission("essentials.back.ondeath",true);
		attachment.setPermission("essentials.delhome",true);
		attachment.setPermission("essentials.home",true);
		attachment.setPermission("essentials.sethome.multiple",true);
		attachment.setPermission("essentials.sethome.multiple.unlimited",true);
		attachment.setPermission("essentials.tpaccept",true);
		attachment.setPermission("essentials.tpahere",true);
		attachment.setPermission("essentials.tpdeny",true);
		attachment.setPermission("essentials.tptoggle",true);
		attachment.setPermission("essentials.warp",true);
		attachment.setPermission("essentials.warp.list",true);
		attachment.setPermission("essentials.warps.*",true);
		attachment.setPermission("essentials.chat.color",true);
		attachment.setPermission("essentials.chat.format",true);
		attachment.setPermission("essentials.chat.magic",true);
		attachment.setPermission("essentials.chat.url",true);
		attachment.setPermission("essentials.joinfullserver",true);
		attachment.setPermission("essentials.nick.color",true);
		attachment.setPermission("essentials.nick.format",true);
		attachment.setPermission("essentials.spawner.bat",true);
		attachment.setPermission("essentials.spawner.chicken",true);
		attachment.setPermission("essentials.spawner.cow",true);
		attachment.setPermission("essentials.spawner.mooshroom",true);
		attachment.setPermission("essentials.spawner.pig",true);
		attachment.setPermission("essentials.spawner.rabbit",true);
		attachment.setPermission("essentials.spawner.sheep",true);
		attachment.setPermission("essentials.spawner.squid",true);
		attachment.setPermission("essentials.spawner.villager",true);
		attachment.setPermission("essentials.spawner.cavespider",true);
		attachment.setPermission("essentials.spawner.enderman",true);
		attachment.setPermission("essentials.spawner.spider",true);
		attachment.setPermission("essentials.spawner.zombiepigman",true);
		attachment.setPermission("essentials.spawner.blaze",true);
		attachment.setPermission("essentials.spawner.creeper",true);
		attachment.setPermission("essentials.spawner.endermite",true);
		attachment.setPermission("essentials.spawner.silverfish",true);
		attachment.setPermission("essentials.spawner.magmacube",true);
		attachment.setPermission("essentials.spawner.skeleton",true);
		attachment.setPermission("essentials.spawner.slime",true);
		attachment.setPermission("essentials.spawner.witch",true);
		attachment.setPermission("essentials.spawner.witherskeleton",true);
		attachment.setPermission("essentials.spawner.zombie",true);
		attachment.setPermission("essentials.spawner.horse",true);
		attachment.setPermission("essentials.spawner.cat",true);
		attachment.setPermission("essentials.spawner.wolf",true);
		attachment.setPermission("essentials.spawner.irongolem",true);
		attachment.setPermission("essentials.spawner.snowman",true);
		attachment.setPermission("essentials.signs.break.balance",true);
		attachment.setPermission("essentials.signs.break.buy",true);
		attachment.setPermission("essentials.signs.break.disposal",true);
		attachment.setPermission("essentials.signs.break.enchant",true);
		attachment.setPermission("essentials.signs.break.free",true);
		attachment.setPermission("essentials.signs.break.gamemode",true);
		attachment.setPermission("essentials.signs.break.heal",true);
		attachment.setPermission("essentials.signs.break.info",true);
		attachment.setPermission("essentials.signs.break.kit",true);
		attachment.setPermission("essentials.signs.break.mail",true);
		attachment.setPermission("essentials.signs.break.protection",true);
		attachment.setPermission("essentials.signs.break.repair",true);
		attachment.setPermission("essentials.signs.break.sell",true);
		attachment.setPermission("essentials.signs.break.spawnmob",true);
		attachment.setPermission("essentials.signs.break.time",true);
		attachment.setPermission("essentials.signs.break.trade",true);
		attachment.setPermission("essentials.signs.break.warp",true);
		attachment.setPermission("essentials.signs.break.weather",true);
		attachment.setPermission("essentials.signs.color",true);
		attachment.setPermission("essentials.signs.create.balance",true);
		attachment.setPermission("essentials.signs.create.disposal",true);
		attachment.setPermission("essentials.signs.create.info",true);
		attachment.setPermission("essentials.signs.create.mail",true);
		attachment.setPermission("essentials.signs.create.protection",true);
		attachment.setPermission("essentials.signs.create.trade",true);
		attachment.setPermission("essentials.signs.create.warp",true);
		attachment.setPermission("essentials.signs.format",true);
		attachment.setPermission("essentials.signs.magic",true);
		attachment.setPermission("essentials.signs.use.balance",true);
		attachment.setPermission("essentials.signs.use.buy",true);
		attachment.setPermission("essentials.signs.use.disposal",true);
		attachment.setPermission("essentials.signs.use.enchant",true);
		attachment.setPermission("essentials.signs.use.free",true);
		attachment.setPermission("essentials.signs.use.gamemode",true);
		attachment.setPermission("essentials.signs.use.heal",true);
		attachment.setPermission("essentials.signs.use.info",true);
		attachment.setPermission("essentials.signs.use.kit",true);
		attachment.setPermission("essentials.signs.use.mail",true);
		attachment.setPermission("essentials.signs.use.protection",true);
		attachment.setPermission("essentials.signs.use.repair",true);
		attachment.setPermission("essentials.signs.use.sell",true);
		attachment.setPermission("essentials.signs.use.spawnmob",true);
		attachment.setPermission("essentials.signs.use.time",true);
		attachment.setPermission("essentials.signs.use.trade",true);
		attachment.setPermission("essentials.signs.use.warp",true);
		attachment.setPermission("essentials.signs.use.weather",true);
		attachment.setPermission("essentials.repair.all",true);
		attachment.setPermission("essentials.repair.armor",true);
		attachment.setPermission("essentials.repair.enchanted",true);
		attachment.setPermission("lockette.user.create.*",true);
		attachment.setPermission("coreprotect.inspect",true);
		attachment.setPermission("essentials.tpa",true);
		attachment.setPermission("essentials.hat",true);
		attachment.setPermission("essentials.back",true);
		attachment.setPermission("essentials.invsee",true);
		attachment.setPermission("essentials.sethome",true);
		attachment.setPermission("essentials.nick",true);
		attachment.setPermission("essentials.spawner",true);
		attachment.setPermission("essentials.top",true);
		attachment.setPermission("essentials.jump",true);
		attachment.setPermission("essentials.fly",true);
		attachment.setPermission("essentials.setwarp",true);
		attachment.setPermission("essentials.warp.overwrite." + player.getName(),true);
		attachment.setPermission("meatie.kick",true);
		
		 for (String perm : ConfigData.getPerms(player.getName()))
	     attachment.setPermission(perm,true);
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
}