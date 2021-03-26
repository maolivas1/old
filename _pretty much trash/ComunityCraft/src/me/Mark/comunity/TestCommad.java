package me.Mark.comunity;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TestCommad implements CommandExecutor {
	
	public class TestCommand implements CommandExecutor {

		@Override
		public boolean onCommand(CommandSender sender, Command arg1, String args2, String[] args) {
			if (sender instanceof Player) {
				Player player = (Player)sender;
				
			if (args.length == 1)
			Comunity.tick();
			else Comunity.powerup(player);
			
			}
			return true;
		}
	
		
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
		if (args.length == 1)
		Comunity.tick();
		else Comunity.powerup(player);
		
		}
		return true;
	}

	
}
