package me.mark.myedit;

import java.util.ArrayList;
import java.util.HashMap;

import me.mark.api.ActionBarAPI;
import me.mark.myplot.Listiner;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;


public class setCommand implements CommandExecutor {
	
	static HashMap<Player, ArrayList<String>> undo = new HashMap<Player, ArrayList<String>>();
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			if (Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("admin") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("owner")) {
			
			Location pos1 = clickEvent.pos1.get(player);
			Location pos2 = clickEvent.pos2.get(player);
			
			if (args.length >= 1) {
				try {
				String arg0 = args[0];
				if (!arg0.contains(":")) arg0 += ":0";
				String[] c = arg0.split(":");
				Material block = Material.getMaterial(Integer.parseInt(c[0]));
				int damage = Integer.parseInt(c[1]);
				fill(player, pos1, pos2, block, damage);
				ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "Set Blocks", 20);
				return true;
				} catch (Exception e) {
					ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "Unknown ID...", 20);
				}
			}
			
			if (pos1 != null && pos2 != null) {
			if (inRegion(pos1) && inRegion(pos2)) {
				if (player.getItemInHand().getType().isBlock()) {
				
				Material block = player.getItemInHand().getType();
				int damage = player.getItemInHand().getDurability();
				fill(player, pos1, pos2, block, damage);
				ActionBarAPI.sendActionBar(player, ChatColor.GOLD + "" + ChatColor.BOLD + "Set Blocks", 20);
				} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "You're not holding a block lol", 40);
			} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "One of you'r points is outside the realm!", 40);
			} else ActionBarAPI.sendActionBar(player, ChatColor.RED + "" + ChatColor.BOLD + "One of you'r points isn't set!", 40);
			} else player.sendMessage(ChatColor.RED + "Only Mod and up can do that!");
		}
		return true;
	}
	
	public boolean inRegion(Location loc) {
	    for(@SuppressWarnings("unused") ProtectedRegion re : WGBukkit.getRegionManager(loc.getWorld()).getApplicableRegions(loc))
	    	return true;
	    	return false;
	}
	
	@SuppressWarnings("deprecation")
	public void fill(Player player, Location l1, Location l2, Material block, int damage) {
		
		if (l1.getX() > l2.getX()) {
			double temp = l1.getX();
			l1.setX(l2.getX());
			l2.setX(temp);
		}
		
		if (l1.getY() > l2.getY()) {
			double temp = l1.getY();
			l1.setY(l2.getY());
			l2.setY(temp);
		}
		
		if (l1.getZ() > l2.getZ()) {
			double temp = l1.getZ();
			l1.setZ(l2.getZ());
			l2.setZ(temp);
		}
		
		String temp = l1.getX() + "," + l1.getY() + "," + l1.getZ() + "," + l2.getX() + "," + l2.getY() + "," + l2.getZ();
		
        for(double x = l1.getX(); x <= l2.getX(); x++)
        for(double y = l1.getY(); y <= l2.getY(); y++)
        for(double z = l1.getZ(); z <= l2.getZ(); z++) {
        	Block b = new Location(Bukkit.getWorld("plotworld"), x, y, z).getBlock();
        	temp += "," + b.getTypeId() + ":" + b.getData();
        	b.setType(block);
        	b.setData((byte)damage);
        }
        if (!undo.containsKey(player)) undo.put(player, new ArrayList<String>());
        undo.get(player).add(temp);
	}
	
}