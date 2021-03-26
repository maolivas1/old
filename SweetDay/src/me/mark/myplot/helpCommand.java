package me.mark.myplot;

import me.mark.api.FancyMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class helpCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
		
		FancyMessage m = new FancyMessage("msg").color(ChatColor.BLUE).suggest("/msg ").tooltip("Private message someone");
		if (sender.hasPermission("essentials.warp")) m.then(", ").color(ChatColor.WHITE).then("warp").color(ChatColor.BLUE).suggest("/warp ").tooltip("Tp to a warp");
		if (sender.hasPermission("essentials.nick")) m.then(", ").color(ChatColor.WHITE).then("nick").color(ChatColor.BLUE).suggest("/nick ").tooltip("Change you're nickname");
		if (sender.hasPermission("essentials.clearinventory")) m.then(", ").color(ChatColor.WHITE).then("clear").color(ChatColor.BLUE).command("/clear").tooltip("Clear you're inventory");
		if (sender.hasPermission("essentials.tp")) m.then(", ").color(ChatColor.WHITE).then("tp").color(ChatColor.BLUE).suggest("/tp").tooltip("Tp to a player");
		
		m.send(player);
		
		}
		return true;
	}
	
}