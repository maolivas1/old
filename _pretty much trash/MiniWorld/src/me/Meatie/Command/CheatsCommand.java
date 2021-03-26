package me.Meatie.Command;

import me.Meaie.Cmd.Perms;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CheatsCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) return true;
		Player player = (Player)sender;
		
		if (!player.isOp()) {
			player.sendMessage(ChatColor.RED + "Not Allowed.");
			return true;
		}
		
		if (args[0].equals("0") || args[0].equals("1") || args[0].equals("2") || args[0].equals("3"))
		Perms.cheats = Integer.parseInt(args[0]);
			
		for (Player p: Bukkit.getOnlinePlayers())
			Perms.update(p);
		
		Bukkit.broadcastMessage(ChatColor.RED + player.getName() + ChatColor.GREEN + " set Cheats to: " + ChatColor.RED + Perms.cheats);
		
		return true;
	}
}
