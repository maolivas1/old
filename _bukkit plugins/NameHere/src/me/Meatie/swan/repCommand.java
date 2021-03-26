package me.Meatie.swan;

import me.Meatie.Project2.Commands;
import me.Meatie.Project2.Perms;
import me.Meatie.Project2.Reputation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class repCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 int rep = Reputation.rep.get(sender.getName());
		 
		 if (args.length >= 1) {
			 if (!args[0].equals("s"))
		 Commands.sendmsg(sender, "&aYou Have &c" + rep + " &aRep.");
		 } else {
			 Commands.sendmsg(sender, "&aYou Have &c" + rep + " &aRep.");
		 }
		 
		 if (rep >= 1000)
			 if (!sender.hasPermission("essentials.nick")) {
			 addPerm(sender, "essentials.nick");
			 Commands.sendmsg(sender,  "&aYou Can Now use &c/nick");
		 }
		 
		 if (rep >= 2000) //2,000
			 if (!sender.hasPermission("meatie.kick")) {
			 addPerm(sender, "meatie.kick");
			 Commands.sendmsg(sender,  "&aYou Can Now use &c/kick");
		 }
		 
		 if (rep >= 5000) //5,000
			 if (!sender.hasPermission("essentials.heal")) {
			 addPerm(sender, "essentials.heal");
			 Commands.sendmsg(sender,  "&aYou Can Now use &c/heal");
		 }
		 
		 if (rep >= 50000) //50,000
			 if (!sender.hasPermission("essentials.time")) {
			 addPerm(sender, "essentials.time");
			 Commands.sendmsg(sender,  "&aYou Can Now use &c/time");
		 }
		 
		 if (rep >= 100000) //100,000
			 if (!sender.hasPermission("essentials.repair")) {
			 addPerm(sender, "essentials.repair");
			 Commands.sendmsg(sender,  "&aYou Can Now use &c/repair");
		 }
		 
		 
		return true;
	}
	
	public void addPerm(CommandSender player, String perm) {
		Perms.addPerm(player, perm);
	}
	
}
