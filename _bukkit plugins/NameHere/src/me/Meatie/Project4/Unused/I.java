package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;

public class I {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
	    int count = 1;
		if (args.length == 3) count =  Integer.parseInt(args[2]);
		if (args.length >= 2)
	    if(Material.getMaterial(args[1].toUpperCase()) == null) {
	    	Commands.send(player, "&c&lInvalid Item");
	    	return;
	    }
	    	player.getInventory().addItem(new ItemStack(Material.getMaterial(args[1].toUpperCase()), count));
	    	Commands.send(player, "&2&lEnjoy You'r &7&l" + args[1]);
	}
	
}
