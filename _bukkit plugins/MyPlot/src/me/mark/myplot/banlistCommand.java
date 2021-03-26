package me.mark.myplot;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.object.Plot;

public class banlistCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			final Player p = (Player)sender;

			try {
		    final Plot plot = (Plot) PS.get().IMP.wrapPlayer(p).getCurrentPlot();
		    	String owner = "";
	        	for (UUID owners : plot.getOwners())
	        		owner = Bukkit.getServer().getOfflinePlayer(owners).getName();
	        	
		    		if (p.getName().equals(owner) || Config.getrank(p.getName().toLowerCase(), owner).equals("coowner") || Config.getrank(p.getName().toLowerCase(), owner).equals("mod") || Config.getrank(p.getName().toLowerCase(), owner).equals("trusted") || p.isOp()) {
		    		String banned = "";
		    		ArrayList<String> list = Config.getplayers(owner);
		    		for (String pl : list)
		    			if (Config.getrank(pl, owner).equals("banned"))
		    				if (banned.equals("")) banned = pl;
		    				else banned = banned + ", " + pl;
		    		if (!banned.equals("")) p.sendMessage(ChatColor.GREEN + "Banned: " + ChatColor.GRAY + banned);
		    		else p.sendMessage(ChatColor.GREEN + "No one is banned!");
		    		} else p.sendMessage(ChatColor.RED + "Can't do that here..");
		    		
			} catch (Exception e) {p.sendMessage(ChatColor.RED + "You're not in a realm!");}
		}
		return true;
	}
	
	

	
}
