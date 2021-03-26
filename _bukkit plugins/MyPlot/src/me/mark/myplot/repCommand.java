package me.mark.myplot;

import me.mark.api.FancyMessage;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class repCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String cmd, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		int rep = autoRank.rep.get(player);
		int microRep = autoRank.microRep.get(player);
		if (Config.isDonator(player.getName()))
		new FancyMessage("You Have ").tooltip("and " + microRep + " micro rep!").color(ChatColor.BLUE).then(rep + "").tooltip("and " + microRep + " micro rep!").color(ChatColor.GREEN).then(" rep!").color(ChatColor.BLUE).tooltip("and " + microRep + " micro rep!").send(player);
		else new FancyMessage("You Have ").tooltip("Upgrade to Pro to view Microrep!").color(ChatColor.BLUE).then(rep + "").tooltip("Upgrade to Pro to view Microrep!").color(ChatColor.GREEN).then(" rep!").color(ChatColor.BLUE).tooltip("Upgrade to Pro to view Microrep!").send(player);
		}
		return true;
	}
	
}