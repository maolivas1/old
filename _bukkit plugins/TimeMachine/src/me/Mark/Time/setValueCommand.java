package me.Mark.Time;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class setValueCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (player.isOp()) {
				String item = player.getInventory().getItemInHand().getType().toString();
				
				if (ConfigStuff.getWorth(item) == -1.0) {
				
				ConfigStuff.setWorth(item);
				player.sendMessage(ChatColor.GRAY + "Added " + item.toLowerCase().replace("_", " "));
				
				} else {
					
					ConfigStuff.setWorth(item);
					player.sendMessage(ChatColor.GRAY + "Removed " + item.toLowerCase().replace("_", " "));
					
				}
			}
		}
		
		return true;
	}
	
	
	
	
}
