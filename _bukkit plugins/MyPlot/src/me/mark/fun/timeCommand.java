package me.mark.fun;

import java.util.HashMap;

import me.mark.myplot.Listiner;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class timeCommand implements CommandExecutor {

	static HashMap<String, Integer> offset = new HashMap<String, Integer>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String cmd, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			
			String realm = Listiner.getRealm(player);
			
			if (Listiner.getRank(player).equals("owner") || Listiner.getRank(player).equals("coowner") || Listiner.getRank(player).equals("mod") || Listiner.getRank(player).equals("trusted") || player.isOp()) {
				
				
				if (args.length >= 1) {
					int time = -1;
					if (args[0].equalsIgnoreCase("day")) time =  0;
					if (args[0].equalsIgnoreCase("noon")) time =  6000;
					if (args[0].equalsIgnoreCase("sunset")) time =  12000;
					if (args[0].equalsIgnoreCase("night")) time =  14000;
					if (args[0].equalsIgnoreCase("midnight")) time =  18000;
					if (time == -1)
					if (StringUtils.isNumeric(args[0])) time = Integer.parseInt(args[0]);
					else player.sendMessage(ChatColor.GREEN + "/time " + ChatColor.GRAY + "day, noon, sunset, night, midnight");
					long realtime = player.getWorld().getTime();
					
					int off = (int) (realtime - time);
					
					player.sendMessage("RealTime: " + realtime + " Time: " + time + " Offset: " + off);
					offset.put(realm, time);
					myTime.update(player, realm);
					
				}
			} else player.sendMessage(ChatColor.RED + "Only Trusted and up can set time");
		}
		return true;
	}
}
