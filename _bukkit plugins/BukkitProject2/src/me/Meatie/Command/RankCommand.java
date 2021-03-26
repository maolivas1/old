package me.Meatie.Command;

import me.Meatie.Data.RankData;
import me.Meatie.Listiner.Fix;
import me.Meatie.Listiner.LoadWorld;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RankCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (args.length == 2) {
			
			if (!(sender instanceof Player)) return true;
			Player player = (Player) sender;
			
			if (args[1].equalsIgnoreCase("guest") || args[1].equalsIgnoreCase("builder") || args[1].equalsIgnoreCase("mod") || args[1].equalsIgnoreCase("admin")) {
				if (TeleportCommand.online(args[0]) != null) {
					Player target = TeleportCommand.online(args[0]);
					clear(sender.getName(), target.getName());
					RankData.save(sender, args[0].toLowerCase(), args[1].toLowerCase());
					LoadWorld.reload(player.getWorld().getName());
					sender.sendMessage(ChatColor.GREEN + target.getName() + ChatColor.RED +  " is now " + ChatColor.GREEN + args[1] + ChatColor.RED + " in you'r world.");
				} else sender.sendMessage(ChatColor.RED + args[0] + " isn't online.");
			} else sender.sendMessage(ChatColor.RED + "/rank"  + ChatColor.GRAY + " player " + ChatColor.GREEN +  "guest" + ChatColor.RED + " - " + ChatColor.GREEN + "builder"  + ChatColor.RED + " - " + ChatColor.GREEN + "trusted" + ChatColor.RED + " - " + ChatColor.GREEN + "mod"
					 + ChatColor.RED + " - " + ChatColor.GREEN + "admin");
		} else sender.sendMessage(ChatColor.RED + "/rank"  + ChatColor.GRAY + " player " + ChatColor.GREEN +  "guest" + ChatColor.RED + " - " + ChatColor.GREEN + "builder"  + ChatColor.RED + " - " + ChatColor.GREEN + "trusted" + ChatColor.RED + " - " + ChatColor.GREEN + "mod"
				 + ChatColor.RED + " - " + ChatColor.GREEN + "admin");
		return true;
	}
	
	public void clear(String world, String user) {
		
		for (String name:  LoadWorld.map.keySet()) {
			if (name.toLowerCase().equals(world.toLowerCase() + " " + user.toLowerCase()))
					Fix.remove(name);
		}
		
	}
	
}