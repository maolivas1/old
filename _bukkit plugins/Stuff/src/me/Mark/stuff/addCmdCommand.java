package me.Mark.stuff;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class addCmdCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (player.isOp())
			if (args.length >= 2) {
				if (buyCommand.isInteger(args[1])) {
				int item = player.getInventory().getItemInHand().getType().getId();
				//TODO get item data so died wool and stuff can be used
				//int dmg = player.getInventory().getItemInHand().getItemMeta().get
				ConfigStuff.addCommand(args[0], item, Double.valueOf(args[1]));
				player.sendMessage(ChatColor.GRAY + "Added Command " + args[0] + " for " + args[1]);
				}
			}
			
		}
		
		return true;
	}
	
	
	
	
}
