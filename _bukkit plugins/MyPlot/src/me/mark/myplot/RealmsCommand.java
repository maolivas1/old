package me.mark.myplot;

import me.mark.api.FancyMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class RealmsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
			FancyMessage m = new FancyMessage("Realms you have access to: ").color(ChatColor.BLUE).then("Yours").color(ChatColor.DARK_GREEN).tooltip("Teleport To Your Realm!").command("/realm");
    		for (String home : Config.gethomes(sender.getName()))
    		m.then(", ").color(ChatColor.BLUE).then(home).color(ChatColor.DARK_GREEN).tooltip("Teleport To " + home + "'s Realm!").command("/realm " + home);
    		m.send(sender);
		return true;
	}
}
