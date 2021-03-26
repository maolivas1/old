package me.Meatie.swan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class kickCommand implements CommandExecutor {

	ArrayList<String> list = new ArrayList<String>();
	
	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (sender.hasPermission("meatie.kick")) {
			 if (!sender.isOp())
			 if (list.contains(sender.getName())) {
				 sender.sendMessage(ChatColor.RED + "Has It Been 5 minnets Since You'r Last Kick?");
				 return true;
			 }
		 if (args.length >= 1) {
		 for (OfflinePlayer p: Bukkit.getOfflinePlayers())
			 if (p.getName().toLowerCase().startsWith(args[0].toLowerCase())) {
				 if(sender instanceof Player) {
		  			 Player player = (Player)sender;
		  			DateFormat dateFormat = new SimpleDateFormat("MM/dd HH:mm");
		  			Date date = new Date();
				 player.chat("/mail send meatie I Kicked " + p.getName() + " " + dateFormat.format(date));
				 }
				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tempban " + p.getName() + " " + 61 + "kicked By " + sender.getName() + " For 1 Minute");
				 Bukkit.broadcastMessage(ChatColor.GRAY + sender.getName() + ChatColor.GREEN + " Kicked " + ChatColor.GRAY + p.getName());
				 for (Player pl : Bukkit.getOnlinePlayers())
					 if (!pl.getName().equals(sender.getName()))
				 pl.sendMessage(ChatColor.GRAY + "If you beleave " + sender.getName() + " is abusing kicking please report them.");
				 if (!sender.isOp())
					 cooldown(sender.getName());
				 return true;
			 }
			 sender.sendMessage(ChatColor.RED + "Unknown Player");
		 } else sender.sendMessage(ChatColor.RED + "/kick " + ChatColor.GRAY + "player");
		 } else sender.sendMessage(ChatColor.RED + "Ur Not Allowed.");
		return true;
	}
	
	public void cooldown(final String player) {
		list.add(player);
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	list.remove(player);
            }
        }, 300000L);
	}
	
}