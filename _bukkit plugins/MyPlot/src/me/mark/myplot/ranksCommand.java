package me.mark.myplot;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ranksCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			player.chat("/rank list");
		}
		return true;
	}
	
	

	
}
