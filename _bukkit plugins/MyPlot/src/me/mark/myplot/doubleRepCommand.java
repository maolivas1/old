package me.mark.myplot;

import java.util.Calendar;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class doubleRepCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String cmd, String[] args) {
		
		
		if (sender.isOp()) {
			if (args.length >= 2) {
			for (OfflinePlayer p : Bukkit.getOfflinePlayers()) {
				if (p.getName().equalsIgnoreCase(args[0])){
					
					if (args[1].equalsIgnoreCase("lifetime")) {
						sender.sendMessage(ChatColor.GREEN + p.getName() + " is now Pro for life!");
						Config.setDonator(p.getName(), "lifetime");
						return true;
					}
					
					int days = 0;
					if (args[1].equalsIgnoreCase("day")) {
						days = 1;
					} else if (args[1].equalsIgnoreCase("week")) {
						days = 7;
					} else if (args[1].equalsIgnoreCase("month")) {
							days = 32;
					}
					
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(calendar.getTime());
					calendar.add(Calendar.DAY_OF_YEAR, days);
					Date date = calendar.getTime();
					
					String time = date.getYear() + " " + date.getMonth() + " " + date.getDate() + " " + date.getHours() + " " + date.getMinutes();
					sender.sendMessage(ChatColor.GREEN + p.getName() + " is now Pro untill: " + time);
					Config.setDonator(p.getName(), time);
					return true;
				}
			}
			sender.sendMessage(ChatColor.RED + "Player not found niba");
			} else sender.sendMessage(ChatColor.RED + "/pro player time");
		}
		
		return true;
	}
	
	
}