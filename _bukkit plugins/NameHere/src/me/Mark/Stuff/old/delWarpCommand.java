package me.Mark.Stuff.old;

import java.util.ArrayList;

import me.Mark.stuff.ConfigStuff;
import me.Mark.stuff.Vaulteconomy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.earth2me.essentials.Warps;

public class delWarpCommand implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
			Player player = (Player)sender;
			if (sender.isOp())
			if (args.length >= 1) {
						
				Warps w = Vaulteconomy.ess.getWarps();
				
				ArrayList<String> list = ConfigStuff.getPlayerWarps(player.getName());
				if (list != null)
				for (String warp : list) {
					if (warp.equalsIgnoreCase(args[0])) {
						//Warp belongs to player
						try {
							w.removeWarp(warp);
						} catch (Exception e) {}
						ConfigStuff.delPlayerWarp(player.getName(), warp);
						int set = ConfigStuff.getWarpCount(player.getName(), "set");
						int unset = ConfigStuff.getWarpCount(player.getName(), "unset");
						ConfigStuff.setWarpCont(player.getName(), "set", set - 1);
						ConfigStuff.setWarpCont(player.getName(), "unset", unset + 1);
						player.sendMessage(ChatColor.GREEN + "Deleted Warp " + warp);
						return true;
					}
				}
			}
		}
		return true;
	}
	
	
}
