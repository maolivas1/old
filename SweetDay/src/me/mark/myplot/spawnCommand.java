package me.mark.myplot;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String cmd, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (args.length == 2) {
				Location loc = Config.getspawn(args[0], args[1]);
				if (loc != null) {
					player.teleport(loc);
				} else player.sendMessage("Can't find spawn " + args[1] + " in arena " + args[0]);
				return true;
			}
			
			
			player.teleport(player.getWorld().getSpawnLocation());
		}
		
		return true;
	}
	
}
