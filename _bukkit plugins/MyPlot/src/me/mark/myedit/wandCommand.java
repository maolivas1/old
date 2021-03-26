package me.mark.myedit;

import me.mark.myplot.Listiner;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class wandCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] arg3) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("admin") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("owner")) {
			
			player.getInventory().addItem(new ItemStack(Material.FEATHER, 1));
			
			} else player.sendMessage(ChatColor.RED + "Only Mod and up can do that!");
			
		}
		return true;
	}
	
}