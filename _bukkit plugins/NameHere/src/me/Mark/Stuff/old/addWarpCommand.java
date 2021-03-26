package me.Mark.Stuff.old;

import me.Mark.stuff.ConfigStuff;
import me.Mark.stuff.Vaulteconomy;
import net.milkbowl.vault.economy.Economy;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class addWarpCommand implements CommandExecutor {
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			if (sender.isOp())
			if (args.length >= 1)
				for (Player p : Bukkit.getOnlinePlayers())
					if (p.getName().equalsIgnoreCase(args[0])) {
						
						int set = ConfigStuff.getWarpCount(p.getName(), "set");
						int unset = ConfigStuff.getWarpCount(p.getName(), "unset");
						
						if (set + unset >= 3) {
							p.sendMessage(ChatColor.RED + "Can't Have More Than 3 Warps... You Wern't Charged");
							return true;
						}
						
						    ConfigStuff.setWarpCont(p.getName(), "unset",  unset + 1);
						    
						    
						    Economy economy = Vaulteconomy.economy;
						    double price = 1000;
							if(economy != null) {
								double bal = economy.getBalance(p.getName());
								if (bal >= price) {
								    economy.withdrawPlayer(p.getName(), price);  
								} else {
									p.sendMessage(ChatColor.RED + "You need " + price + " but only have " + bal);
									return true;
								}
							} else p.sendMessage(ChatColor.RED + "Economy thing not working....");
						    
							p.sendMessage(ChatColor.GREEN + "You Can Now Set " + ++unset + " warps");
							return true;
					}
		return true;
	}
	
	
	
	
}
