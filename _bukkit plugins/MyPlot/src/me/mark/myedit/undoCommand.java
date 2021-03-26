package me.mark.myedit;

import java.util.ArrayList;

import me.mark.api.ActionBarAPI;
import me.mark.myplot.Listiner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;


public class undoCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("admin") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("owner")) {
			
			if (args.length == 0) {
			player.getInventory().addItem(new ItemStack(Material.WATCH, 1));
			} else {
				undo(player);
				clickEvent.effect(player, player.getLocation());
			}
			
			} else player.sendMessage(ChatColor.RED + "Only Mod and up can do that!");
		}
		return true;
	}
	
	@SuppressWarnings("deprecation")
	public void undo(Player player) {
		if (!setCommand.undo.containsKey(player)) {
			ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "Nothing to undo..", 20);
			return;
		}
		ArrayList<String> list = setCommand.undo.get(player);
		if (list.size() != 0) {
		String data = list.get(list.size()-1);
		String[] args = data.split(",");
		Location l1 = new Location(Bukkit.getWorld("plotworld"), Double.parseDouble(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]));
		Location l2 = new Location(Bukkit.getWorld("plotworld"), Double.parseDouble(args[3]), Double.parseDouble(args[4]), Double.parseDouble(args[5]));
		
		int i = 6;
		
        for(double x = l1.getX(); x <= l2.getX(); x++)
        for(double y = l1.getY(); y <= l2.getY(); y++)
        for(double z = l1.getZ(); z <= l2.getZ(); z++) {
			String[] a = args[i++].split(":");
			Material block = Material.getMaterial(Integer.parseInt(a[0]));
			int damage = Integer.parseInt(a[1]);
			
        	Block b = new Location(Bukkit.getWorld("plotworld"), x, y, z).getBlock();
        	b.setType(block);
        	b.setData((byte)damage);
        	ActionBarAPI.sendActionBar(player, ChatColor.GREEN + "" + ChatColor.BOLD + "Undone!", 20);
        }
		
        list.remove(list.size()-1);
		} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "Nothing left to undo..", 20);
	}
	
}