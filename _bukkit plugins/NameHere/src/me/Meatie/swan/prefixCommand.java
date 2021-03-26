package me.Meatie.swan;

import me.Meatie.Project2.ConfigData;
import me.Meatie.Project2.Fix;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class prefixCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (!sender.isOp()) return true;

				 if (args.length >= 2) {
					 if (!isNum(args[0])) {
						 sender.sendMessage(ChatColor.RED + "/prefix 1 - 10 prefix");
						 return true;
					 }
					 ConfigData.savePrefix(args[0], args[1]);
					 sender.sendMessage(ChatColor.RED + args[0] + ChatColor.GRAY + " Now Uses Prefix " + Fix.format(args[1]));
				 } else {
					 sender.sendMessage(ChatColor.RED + "/prefix 0 - 10 prefix");
					 if (ConfigData.getPrefix("0") != null)
					 sender.sendMessage(ChatColor.RED + "0 " + Fix.format(ConfigData.getPrefix("0")));
					 if (ConfigData.getPrefix("1") != null)
					 sender.sendMessage(ChatColor.RED + "1 " + Fix.format(ConfigData.getPrefix("1")));
					 if (ConfigData.getPrefix("2") != null)
					 sender.sendMessage(ChatColor.RED + "2 " + Fix.format(ConfigData.getPrefix("2")));
					 if (ConfigData.getPrefix("3") != null)
					 sender.sendMessage(ChatColor.RED + "3 " + Fix.format(ConfigData.getPrefix("3")));
					 if (ConfigData.getPrefix("4") != null)
					 sender.sendMessage(ChatColor.RED + "4 " + Fix.format(ConfigData.getPrefix("4")));
					 if (ConfigData.getPrefix("5") != null)
					 sender.sendMessage(ChatColor.RED + "5 " + Fix.format(ConfigData.getPrefix("5")));
					 if (ConfigData.getPrefix("6") != null)
					 sender.sendMessage(ChatColor.RED + "6 " + Fix.format(ConfigData.getPrefix("6")));
					 if (ConfigData.getPrefix("7") != null)
					 sender.sendMessage(ChatColor.RED + "7 " + Fix.format(ConfigData.getPrefix("7")));
					 if (ConfigData.getPrefix("8") != null)
					 sender.sendMessage(ChatColor.RED + "8 " + Fix.format(ConfigData.getPrefix("8")));
					 if (ConfigData.getPrefix("9") != null)
					 sender.sendMessage(ChatColor.RED + "9 " + Fix.format(ConfigData.getPrefix("9")));
					 if (ConfigData.getPrefix("10") != null)
					 sender.sendMessage(ChatColor.RED + "10 " + Fix.format(ConfigData.getPrefix("10")));
				 }
		return true;
	}
	
	public static boolean isNum(String str) {
	  try  {
	    Double.parseDouble(str);
	  } catch(NumberFormatException e) {
	    return false;  
	  }
	  return true;
	}
	
}
