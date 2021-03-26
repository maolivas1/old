package me.Mark.Stuff.old;

import java.util.ArrayList;
import java.util.Collection;

import me.Mark.stuff.ConfigStuff;
import me.Mark.stuff.Vaulteconomy;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.Warps;

public class setWarpCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (sender.isOp())
			if (args.length >= 1) {
						
				Warps w = Vaulteconomy.ess.getWarps();
				
				ArrayList<String> list = ConfigStuff.getPlayerWarps(player.getName());
				if (list != null)
				for (String warp : list) {
					if (warp.equalsIgnoreCase(args[0])) {
						//Warp belongs to player, let them set it
						try {
							w.setWarp(args[0], player.getLocation());
						} catch (Exception e) {}
						player.sendMessage(ChatColor.GREEN + "SetWarp " + args[0]);
						return true;
					}
				}
				
						int set = ConfigStuff.getWarpCount(player.getName(), "set");
						int unset = ConfigStuff.getWarpCount(player.getName(), "unset");
						
						if (unset == 0) {
							player.sendMessage(ChatColor.RED + "Buy a warp from shop first.");
							return true;
						}
						    
				            Collection<String> warps = w.getList();
				            for (String warp : warps)
				            	if (warp.equalsIgnoreCase(args[0])) {
				            		//allow if warp belongs to player
				            		player.sendMessage(ChatColor.RED + "Warp name Alrety Taken");
				            		return true;
				            	}
						    
						    Economy economy = Vaulteconomy.economy;
						    double price = 1000;
							if(economy != null) {
								double bal = economy.getBalance(player.getName());
								if (bal >= price) {
								    economy.withdrawPlayer(player.getName(), price);  
								} else {
									player.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
									return true;
								}
							} else player.sendMessage(ChatColor.RED + "Economy thing not working....");
						    
							try {
								w.setWarp(args[0], player.getLocation());
							} catch (Exception e) {}
							
							player.sendMessage(ChatColor.GREEN + "SetWarp " + args[0]);
							ConfigStuff.addPlayerWarp(player.getName(), args[0]);
						    ConfigStuff.setWarpCont(player.getName(), "unset",  unset - 1);
						    ConfigStuff.setWarpCont(player.getName(), "set",  set + 1);
							return true;
			}
		}
		return true;
	}
	
	
	
	
}
