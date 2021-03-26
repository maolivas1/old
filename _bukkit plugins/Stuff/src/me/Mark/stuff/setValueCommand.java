package me.Mark.stuff;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class setValueCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (player.isOp())
			if (args.length >= 1) {
				if (buyCommand.isInteger(args[0])) {
				String item = player.getInventory().getItemInHand().getType().toString();
				ConfigStuff.setWorth(item, Double.valueOf(args[0]));
				player.sendMessage(ChatColor.GRAY + "SetValue of " + item + " to " + args[0]);
				}
			}
			
		}
		
		return true;
	}
	
	
	
	
}
