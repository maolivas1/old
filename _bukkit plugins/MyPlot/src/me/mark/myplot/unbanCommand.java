package me.mark.myplot;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class unbanCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (Listiner.getRank(player).equals("owner") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("admin")) {
				if (args.length == 1) {
					
					if (Config.getrank(args[0], Listiner.getRealm(player)).equals("banned")) {
						Config.setrank(args[0], Listiner.getRealm(player), "none");
						player.sendMessage(ChatColor.GREEN + "UnBanned " + ChatColor.GRAY + args[0]);
					} else player.sendMessage(ChatColor.GRAY + args[0] + ChatColor.RED + " isn't banned..");
				} else player.sendMessage(ChatColor.GREEN + "/unban " + ChatColor.GRAY + "player");
			} else player.sendMessage(ChatColor.RED + "You Must be Mod or higher to do this!");
		}
		
		return true;
	}
	
	
}
