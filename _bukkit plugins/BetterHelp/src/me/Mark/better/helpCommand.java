package me.Mark.better;

import me.Mark.stolenAPI.FancyMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		FancyMessage m = new FancyMessage("msg").color(ChatColor.BLUE).suggest("/msg ").tooltip("Private message someone");
		if (sender.hasPermission("essentials.ignore")) m.then(", ").color(ChatColor.WHITE).then("ignore").color(ChatColor.BLUE).command("/back").tooltip("Local mute someone");
		if (sender.hasPermission("essentials.mail")) m.then(", ").color(ChatColor.WHITE).then("mail").color(ChatColor.BLUE).command("/mail").tooltip("send/read in game mail!");
		if (sender.hasPermission("essentials.nick")) m.then(", ").color(ChatColor.WHITE).then("nick").color(ChatColor.BLUE).suggest("/nick ").tooltip("Change you're nickname!");
		
		if (sender.hasPermission("coreprotect.inspect")) m.then(", ").color(ChatColor.WHITE).then("inspect").color(ChatColor.DARK_AQUA).command("/inspect").tooltip("Inspect a block");
		
		if (sender.hasPermission("essentials.home")) m.then(", ").color(ChatColor.WHITE).then("home").color(ChatColor.DARK_PURPLE).suggest("/home ").tooltip("Tp to a set home");
		if (sender.hasPermission("essentials.sethome")) m.then(", ").color(ChatColor.WHITE).then("sethome").color(ChatColor.DARK_PURPLE).suggest("/sethome ").tooltip("Set a home");
		if (sender.hasPermission("essentials.delhome")) m.then(", ").color(ChatColor.WHITE).then("delhome").color(ChatColor.DARK_PURPLE).suggest("/delhome ").tooltip("Delete a home");
		if (sender.hasPermission("essentials.tpa")) m.then(", ").color(ChatColor.WHITE).then("tpa").color(ChatColor.DARK_PURPLE).suggest("/tpa ").tooltip("Request to tp so someone");
		if (sender.hasPermission("essentials.tpaccept")) m.then(", ").color(ChatColor.WHITE).then("tpaccept").color(ChatColor.DARK_PURPLE).command("/tpaccept").tooltip("Accept a tp request");
		if (sender.hasPermission("essentials.tpahere")) m.then(", ").color(ChatColor.WHITE).then("tpahere").color(ChatColor.DARK_PURPLE).suggest("/tpahere").tooltip("Request someone to tp to you");
		if (sender.hasPermission("essentials.tpdeny")) m.then(", ").color(ChatColor.WHITE).then("tpdeny").color(ChatColor.DARK_PURPLE).command("/tpdeny").tooltip("Deny a tp request");
		if (sender.hasPermission("essentials.warp")) m.then(", ").color(ChatColor.WHITE).then("warp").color(ChatColor.DARK_PURPLE).suggest("/warp ").tooltip("Tp to a warp");
		if (sender.hasPermission("essentials.back")) m.then(", ").color(ChatColor.WHITE).then("back").color(ChatColor.DARK_PURPLE).command("/back").tooltip("Tp to last location");
		
		if (sender.hasPermission("essentials.balance")) m.then(", ").color(ChatColor.WHITE).then("bal").color(ChatColor.GREEN).command("/bal").tooltip("Check how much $$ you got");
		if (sender.hasPermission("essentials.worth")) m.then(", ").color(ChatColor.WHITE).then("worth").color(ChatColor.GREEN).command("/worth").tooltip("See how much a item sells for");
		if (sender.hasPermission("essentials.pay")) m.then(", ").color(ChatColor.WHITE).then("pay").color(ChatColor.GREEN).suggest("/pay ").tooltip("Pay someone some cash!");
		if (sender.hasPermission("essentials.sell")) m.then(", ").color(ChatColor.WHITE).then("sell").color(ChatColor.GREEN).suggest("/sell ").tooltip("Sell items");
		
		if (sender.hasPermission("essentials.seen")) m.then(", ").color(ChatColor.WHITE).then("seen").color(ChatColor.RED).suggest("/seen ").tooltip("See when someone was last online");
		if (sender.hasPermission("essentials.invsee")) m.then(", ").color(ChatColor.WHITE).then("invsee").color(ChatColor.RED).suggest("/invsee ").tooltip("Peek into someone's inventory");
		
		if (sender.hasPermission("essentials.hat")) m.then(", ").color(ChatColor.WHITE).then("hat").color(ChatColor.AQUA).command("/hat").tooltip("Put a block on you're head!");
		//TODO Add all commands for all plugins I have
		//Make it easy to change color midway through (make a color variable, i can change it between lines)
		
		m.send(player);
			
		}
		return true;
}
}