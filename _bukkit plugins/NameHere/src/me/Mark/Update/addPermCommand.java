package me.Mark.Update;

import me.Meatie.Project2.Fix;
import me.Meatie.Project2.PermsConfig;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class addPermCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if (!sender.isOp()) return true;
				 if (args.length >= 2) {
					 if (args[1].startsWith("-")) {
						 PermsConfig.delGroupPerm(args[0], args[1].substring(1));
						 sender.sendMessage(ChatColor.RED + args[0] + ChatColor.GRAY + " No Longer Has " + ChatColor.GREEN + Fix.format(args[1].substring(1)));
						 return true;
					 }
					 PermsConfig.saveGroupPerm(args[0], args[1]);
					 sender.sendMessage(ChatColor.RED + args[0] + ChatColor.GRAY + " Now Has Perm " + Fix.format(args[1]));
				 } else sender.sendMessage(ChatColor.RED + "/addperm group perm");
		return true;
	}
}