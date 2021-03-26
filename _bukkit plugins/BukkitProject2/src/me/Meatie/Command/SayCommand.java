package me.Meatie.Command;

import me.Meaie.Cmd.Msg;
import me.Meatie.Data.RankData;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SayCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player player = (Player)sender;
		
		if (!RankData.check(player.getWorld().getName(), player.getName(), "trusted")) {
			
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (p.getWorld().getName().equals(player.getName())) {
					
					StringBuilder builder = new StringBuilder();
					for(String s : args) builder.append(s + " " );
					p.sendMessage(ChatColor.LIGHT_PURPLE + builder.toString());
				}
			}
			
		} else Msg.notallowed(sender);
		
		
		
		}
		return true;
	}
}
