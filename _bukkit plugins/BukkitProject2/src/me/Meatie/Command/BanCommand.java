package me.Meatie.Command;

import me.Meaie.Cmd.Msg;
import me.Meatie.Data.BanData;
import me.Meatie.Data.RankData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		if (args.length == 1)
			
				if (RankData.check(player.getWorld().getName(), player.getName(), "admin")) {
					
					BanData.save(player.getWorld().getName(), args[0]);
					Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.RED + " Banned " + ChatColor.GREEN + args[0] + ChatColor.RED + " From " + ChatColor.GREEN + player.getWorld().getName() + "'s world");
			
				} else Msg.notallowed(sender);
		}
		return true;
}
}