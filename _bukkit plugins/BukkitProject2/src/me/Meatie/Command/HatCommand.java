package me.Meatie.Command;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class HatCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		
		if (player.getItemInHand() != null) {
			
			if (player.getInventory().getHelmet() != null)
			player.getInventory().addItem(player.getInventory().getHelmet());
			
			player.getInventory().setHelmet(player.getItemInHand());
			player.setItemInHand(new ItemStack(Material.AIR, 1));
			
			
		} else {
			player.sendMessage(ChatColor.RED + "U Aint Got Much In Ur Hand...");
		}
		
		}
		return true;
	}
}
