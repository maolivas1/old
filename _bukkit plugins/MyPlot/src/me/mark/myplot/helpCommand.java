package me.mark.myplot;

import me.mark.api.FancyMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;


public class helpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
		
		FancyMessage m = new FancyMessage("list").color(ChatColor.BLUE).tooltip("List of players in current realm").command("/list");
		if (sender.hasPermission("essentials.msg")) m.then(", ").color(ChatColor.WHITE).then("msg").color(ChatColor.BLUE).suggest("/msg ").tooltip("Private message someone");
		m.then(", ").color(ChatColor.WHITE).then("realm").color(ChatColor.BLUE).command("/realm").tooltip("Teleport to you're realm, or /realms");
		m.then(", ").color(ChatColor.WHITE).then("rep").color(ChatColor.BLUE).command("/rep").tooltip("Show your current rep");
		if (sender.hasPermission("essentials.warp")) m.then(", ").color(ChatColor.WHITE).then("warp").color(ChatColor.BLUE).suggest("/warp ").tooltip("Tp to a warp");
		if (sender.hasPermission("essentials.mail")) m.then(", ").color(ChatColor.WHITE).then("mail").color(ChatColor.BLUE).suggest("/mail ").tooltip("Send someone a msg to read latter");
		if (sender.hasPermission("essentials.ignore")) m.then(", ").color(ChatColor.WHITE).then("ignore").color(ChatColor.BLUE).suggest("/ignore ").tooltip("Hide a players chat messages");
		if (sender.hasPermission("essentials.nick")) m.then(", ").color(ChatColor.WHITE).then("nick").color(ChatColor.BLUE).suggest("/nick ").tooltip("Change you're nickname");
		//if (sender.hasPermission("essentials.tpa")) m.then(", ").color(ChatColor.WHITE).then("tpa").color(ChatColor.BLUE).suggest("/tpa ").tooltip("Request to tp to someone");
		//if (sender.hasPermission("essentials.tpaccept")) m.then(", ").color(ChatColor.WHITE).then("tpaccept").color(ChatColor.BLUE).command("/tpaccept").tooltip("Accept a teleport request");
		//if (sender.hasPermission("essentials.tpdeny")) m.then(", ").color(ChatColor.WHITE).then("tpdeny").color(ChatColor.BLUE).command("/tpdeny").tooltip("Deny a teleport request");
		//if (sender.hasPermission("essentials.tptoggle")) m.then(", ").color(ChatColor.WHITE).then("tptoggle").color(ChatColor.BLUE).command("/tptoggle").tooltip("Disable / Enable others from teleporting to you");
		if (sender.hasPermission("essentials.clearinventory")) m.then(", ").color(ChatColor.WHITE).then("clear").color(ChatColor.BLUE).command("/clear").tooltip("Clear you're inventory");
		if (sender.hasPermission("essentials.fly")) m.then(", ").color(ChatColor.WHITE).then("fly").color(ChatColor.BLUE).command("/fly").tooltip("Fly without creative mode");
		if (sender.hasPermission("essentials.remove")) m.then(", ").color(ChatColor.WHITE).then("killall").color(ChatColor.RED).command("/killall all 500").tooltip("Clean up mobs, Drops etc..");
		//if (sender.hasPermission("essentials.tp")) m.then(", ").color(ChatColor.WHITE).then("tp").color(ChatColor.BLUE).suggest("/tp").tooltip("Tp to a player");
		if (sender.hasPermission("essentials.heal")) m.then(", ").color(ChatColor.WHITE).then("heal").color(ChatColor.BLUE).command("/heal").tooltip("Heal yourself");
		if (sender.hasPermission("essentials.item")) m.then(", ").color(ChatColor.WHITE).then("item").color(ChatColor.BLUE).command("/i dirt 1 name:lol-I-Clicked-The-help-Text").tooltip("Give yourself items");
		if (sender.hasPermission("essentials.hat")) m.then(", ").color(ChatColor.WHITE).then("hat").color(ChatColor.BLUE).command("/hat").tooltip("Put stuff on you'r head!");
		if (sender.hasPermission("essentials.invsee")) m.then(", ").color(ChatColor.WHITE).then("invsee").color(ChatColor.BLUE).suggest("/invsee").tooltip("Peek into people's inventories");
		
		for(ProtectedRegion r : WGBukkit.getRegionManager(player.getWorld()).getApplicableRegions(player.getLocation())) {
			String region = r.getId();
			String rank = Config.getrank(player.getName(), region);
			
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod") || rank.equals("trusted")) m.then(", ").color(ChatColor.WHITE).then("ranks").color(ChatColor.DARK_GREEN).command("/ranks").tooltip("List players ranks");
			if (player.isOp() || rank.equals("mod") || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin")) m.then(", ").color(ChatColor.WHITE).then("rank").color(ChatColor.DARK_GREEN).suggest("/rank ").tooltip("Give people rank");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner")) m.then(", ").color(ChatColor.WHITE).then("setspawn").color(ChatColor.DARK_GREEN).command("/setspawn ").tooltip("Set realm spawn");
			if (player.isOp() || rank.equals("trusted") || rank.equals("mod") || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") && sender.hasPermission("essentials.gamemode")) m.then(", ").color(ChatColor.WHITE).then("gamemode").color(ChatColor.DARK_GREEN).suggest("/gamemde ").tooltip("Change you're gamemode");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod")) m.then(", ").color(ChatColor.WHITE).then("ban").color(ChatColor.DARK_GREEN).suggest("/ban ").tooltip("Ban someone");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod")) m.then(", ").color(ChatColor.WHITE).then("unban").color(ChatColor.DARK_GREEN).suggest("/unban ").tooltip("unBan someone");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod")) m.then(", ").color(ChatColor.WHITE).then("banlist").color(ChatColor.DARK_GREEN).command("/banlist").tooltip("List Banned Players");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod")) m.then(", ").color(ChatColor.WHITE).then("kick").color(ChatColor.DARK_GREEN).suggest("/kick ").tooltip("Kick someone");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod")) m.then(", ").color(ChatColor.WHITE).then("wand").color(ChatColor.DARK_GREEN).command("/wand").tooltip("Get editing wand, 1. Click Corners\n2. Sneak & click block with empty hand\nOr Sneak & click air with block in hand\nClick air with this tool to disable edit mode");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin") || rank.equals("mod")) m.then(", ").color(ChatColor.WHITE).then("undo").color(ChatColor.DARK_GREEN).command("/undo").tooltip("Get undo wand\nClick to undo edit");
			if (player.isOp() || rank.equals("coowner") || rank.equals("owner") || rank.equals("admin")) m.then(", ").color(ChatColor.WHITE).then("pvp").color(ChatColor.DARK_GREEN).command("/pvp").tooltip("Enable or disable PVP in realm!");
			
		}
		
		m.send(player);
		
		}
		return true;
	}
	
}