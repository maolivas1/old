package me.Meatie.Command;

import me.Meatie.Data.InvData;
import me.Meatie.Data.RankData;
import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
		if (sender instanceof Player) {
			Player player = (Player)sender;
			Player target;
			if (args.length == 1) {
				
		if (TeleportCommand.online(args[0]) != null)
		target = TeleportCommand.online(args[0]);
		else {
			sender.sendMessage(ChatColor.RED + "Unknown Player..");
			return true;
		}
		
		if (target.getWorld().getName().equals(player.getName()) || RankData.check(target.getWorld().getName(), sender.getName(), "mod")) {
				InvData.save(target);
				InvData.load(target);
			
			target.sendMessage(ChatColor.GREEN + player.getName() + ChatColor.RED + " Kicked You From " + ChatColor.GREEN + target.getWorld().getName() + ChatColor.RED + "'s World");
			target.teleport(Bukkit.getWorld("world").getSpawnLocation());
		} else sender.sendMessage(ChatColor.RED + "Player's In World You'r Can't Do That In");
			} else sender.sendMessage(ChatColor.RED + "/kick " + ChatColor.GRAY + "player");
		}
		
			
		return true;
	}
}
