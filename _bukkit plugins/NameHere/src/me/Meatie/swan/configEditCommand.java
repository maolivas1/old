package me.Meatie.swan;

import me.Meatie.Project2.Commands;
import me.Meatie.Project2.ConfigData;
import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class configEditCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (!sender.isOp()) return true;

				 if (args.length >= 2) {
					 
					 String msg = "";
					 int index;
					 for (index = 1; index < args.length; ++index)
				     msg = msg + " " + args[index];
					 msg = msg.substring(1);
					 
					 if (args[0].equalsIgnoreCase("quick")) {
						 ConfigData.save("quick", msg);
						 Fix.quick = msg;
					 } else if (args[0].equalsIgnoreCase("top")) {
							for (Player p : Bukkit.getOnlinePlayers())
								TitleAPI.sendTabTitle(p, Fix.top.replace("$sender", p.getName()), Fix.bottom.replace("$sender", p.getName()));
					 ConfigData.save("top", msg);
					 Fix.top = msg;
				 } else if (args[0].equalsIgnoreCase("login")) {
					 ConfigData.save("login", msg);
					 Fix.login = msg;
				 } else if (args[0].equalsIgnoreCase("bottom")) {
						for (Player p : Bukkit.getOnlinePlayers())
							TitleAPI.sendTabTitle(p, Fix.top.replace("$sender", p.getName()), Fix.bottom.replace("$sender", p.getName()));
					 ConfigData.save("bottom", msg);
					 Fix.bottom = msg;
				 } else if (args[0].equalsIgnoreCase("leave")) {
					 ConfigData.save("leave", msg);
					 Fix.leave = msg;
				 } else {
					 Commands.sendmsg(sender, "&d/configedit");
					 Commands.sendmsg(sender, "&dquick: &eMessage above inventory at login.");
					 Commands.sendmsg(sender, "&dtop: &eMessage above sender names in Tab list.");
					 Commands.sendmsg(sender, "&dbottom: &eMessage below sender names in Tab list.");
					 Commands.sendmsg(sender, "&dlogin: &e'sender Joined the game!'");
					 Commands.sendmsg(sender, "&dleave: &e'sender Left the game!'");
				 }
				 } else {
					 Commands.sendmsg(sender, "&d/configedit");
					 Commands.sendmsg(sender, "&dquick: &eMessage above inventory at login.");
					 Commands.sendmsg(sender, "&dtop: &eMessage above sender names in Tab list.");
					 Commands.sendmsg(sender, "&dbottom: &eMessage below sender names in Tab list.");
					 Commands.sendmsg(sender, "&dlogin: &e'sender Joined the game!'");
					 Commands.sendmsg(sender, "&dleave: &e'sender Left the game!'");
				 }
		return true;
	}
	
}
