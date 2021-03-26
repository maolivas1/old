package me.mark.myplot;

import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (args.length == 2) {
				
				Config.setspawn(args[0], args[1], player.getLocation());
				player.sendMessage("Setspawn: " + args[1] + " for arena " + args[0]);
				
			} else player.sendMessage("/setspawn <arena> <#>");

		}
		
		return true;
	}
	
}
