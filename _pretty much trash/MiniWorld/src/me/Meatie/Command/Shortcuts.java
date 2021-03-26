package me.Meatie.Command;

import java.util.Arrays;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Shortcuts implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		String cmd = command.getName();
		String arg = Arrays.toString(args).replace("[", "").replace("]", "");
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		if (cmd.equalsIgnoreCase("gm"))
			player.chat("/gamemode " + arg);
		
		if (cmd.equalsIgnoreCase("i"))
			player.chat("/give " + player.getName() + " " + arg);
		
		if (cmd.equalsIgnoreCase("ci"))
			player.chat("/clear");
		}
		return true;
	}
}
