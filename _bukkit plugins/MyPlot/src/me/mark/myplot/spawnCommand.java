package me.mark.myplot;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			player.teleport(player.getWorld().getSpawnLocation());
		}
		
		return true;
	}
	
}
