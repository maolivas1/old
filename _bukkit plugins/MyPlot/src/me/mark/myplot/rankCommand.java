package me.mark.myplot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import me.mark.api.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.config.C;
import com.intellectualcrafters.plot.database.DBFunc;
import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotPlayer;
import com.intellectualcrafters.plot.util.EventUtil;
import com.intellectualcrafters.plot.util.MainUtil;
import com.intellectualcrafters.plot.util.Permissions;

public class rankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender instanceof Player) {
			final Player p = (Player)sender;
			PlotPlayer player = PS.get().IMP.wrapPlayer(p);

			try {
		    final Plot plot = (Plot) player.getCurrentPlot();
		    if (plot.hasOwner()) {
		    	String owner = "";
	        	for (UUID owners : plot.getOwners())
	        		owner = Bukkit.getServer().getOfflinePlayer(owners).getName();
		    if (args.length == 2) {
		    if (plot.isOwner(player.getUUID()) || Config.getrank(p.getName(), owner).equals("mod") || Config.getrank(p.getName(), owner).equals("coowner") || p.isOp()) {
		    	
		    	if (Config.getrank(p.getName(), owner).equals("mod"))
		    		if (Config.getrank(args[0], owner).equals("mod") || Config.getrank(args[0], owner).equals("coowner")) {
		    			player.sendMessage(ChatColor.RED + "You can't set rank of people Mod or higher..");
		    			return true;
		    		}
		    	
		    	if (Config.getrank(p.getName(), owner).equals("coowner"))
		    		if (Config.getrank(args[0], owner).equals("coowner")) {
		    			player.sendMessage(ChatColor.RED + "You can't set rank of people Coowner or higher..");
		    			return true;
		    		}
		    	
		    final Set<UUID> uuids = MainUtil.getUUIDsFromString(args[0]);
		    if (!uuids.isEmpty()) {
		    Iterator<UUID> iter = uuids.iterator();
		    while (iter.hasNext()) {
		      UUID uuid = (UUID)iter.next();
		      if ((uuid == DBFunc.everyone) && (!Permissions.hasPermission(player, C.PERMISSION_TRUST_EVERYONE)) && (!Permissions.hasPermission(player, C.PERMISSION_ADMIN_COMMAND_TRUST))) {
		        player.sendMessage(ChatColor.RED + "This isn't you're plot");
		        iter.remove();
		      } else if (plot.isOwner(uuid)) {
		    	  player.sendMessage(ChatColor.RED + "Realm owner dosn't need to be a member");
		        iter.remove();
		      }
		    }
		    if (!uuids.isEmpty()) {
		        for (UUID uuid : uuids) {
		        	
		        	String rank = args[1].toLowerCase();
		        	if (rank.equals("none") || rank.equals("guest") || rank.equals("member") || rank.equals("trusted") || rank.equals("mod") || rank.equals("admin") || rank.equals("coowner")) {
		        		
		        		if (Config.getrank(p.getName().toLowerCase(), owner).equals("mod")) {
		        			if (rank.equals("mod") || rank.equals("admin") || rank.equals("coowner")) {
		        			player.sendMessage(ChatColor.RED + "You can set ranks Trusted and lower in this realm!");
		        			return true;
		        			}
		        		} else if (Config.getrank(p.getName().toLowerCase(), owner).equals("admin")) {
		        			if (rank.equals("admin") || rank.equals("coowner")) {
		        			player.sendMessage(ChatColor.RED + "You can set ranks Mod and lower in this realm!");
		        			return true;
		        			}
		        		} else if (Config.getrank(p.getName().toLowerCase(), owner).equals("coowner")) {
		        			if (rank.equals("coowner")) {
		        			player.sendMessage(ChatColor.RED + "You can set ranks Admin and lower in this realm!");
		        			return true;
		        			}
		        		}
		        		
		        		
		          if ((!plot.removeMember(uuid)) && (plot.getDenied().contains(uuid))) plot.removeDenied(uuid);
		          
		          if (plot.getTrusted().contains(uuid) && !rank.equals("member") && !rank.equals("trusted") && !rank.equals("mod") && !rank.equals("admin")  && !rank.equals("coowner"))
		        	  plot.removeTrusted(uuid);
		          
		          if (rank.equals("member") || rank.equals("trusted") || rank.equals("mod") || rank.equals("admin") || rank.equals("coowner")) {
		          plot.addTrusted(uuid);
		          EventUtil.manager.callTrusted(player, plot, uuid, true);
		          }
		          
		          Config.setrank(args[0], owner, rank);
		          Config.addhome(args[0], owner);
		          
		          if (!rank.equals("none")) {
		          player.sendMessage(ChatColor.GRAY + args[0] + ChatColor.GREEN + " Is now " + ChatColor.GRAY + rank + ChatColor.GREEN + " In " + ChatColor.GRAY + owner + ChatColor.GREEN + "'s realm!");
		          
		          for (Player pl : Bukkit.getOnlinePlayers()) {
		        	  if (pl.getName().equalsIgnoreCase(args[0])) {
		        		  FancyMessage m = new FancyMessage("You are now ").color(ChatColor.GREEN).then(rank).color(ChatColor.GRAY).then(" in ").color(ChatColor.GREEN);
		        		  m.then(owner).color(ChatColor.GRAY).tooltip("Teleport To " + owner + "'s Realm!").command("/realm " + owner).then("'s realm!").color(ChatColor.GREEN).tooltip("Teleport To " + owner + "'s Realm!").command("/realm " + owner);
		        		  m.send(pl);
		        		  return true;
		        	  }
		          }
		          } else {
		        	  Config.delhome(args[0], owner);
		        	  player.sendMessage(ChatColor.GRAY + args[0] + ChatColor.GREEN + " no longer has rank in " + ChatColor.GRAY + owner + ChatColor.GREEN + "'s realm!");
			          
			          for (Player pl : Bukkit.getOnlinePlayers()) {
			        	  if (pl.getName().equalsIgnoreCase(args[0])) {
			        		  pl.sendMessage(ChatColor.GREEN + "You no longer have rank in " + ChatColor.GRAY + owner + ChatColor.GREEN + "'s realm!");
			        		  return true;
			        	  }
			          }
		          }
		        		  
		        	} else player.sendMessage(ChatColor.RED + "Valid Ranks:" + ChatColor.GRAY + " none, Guest, Member, Trusted, Mod, Admin, CoOwner");
		        }
		    }
		    } else player.sendMessage(ChatColor.GRAY + args[0] + ChatColor.RED + " can't be found");
		    } else player.sendMessage(ChatColor.RED + "This isn't you're Realm...");
		    } else if (args.length == 1) {
		    	if (args[0].equalsIgnoreCase("list")) {
		    		if (p.getName().equals(owner) || Config.getrank(p.getName().toLowerCase(), owner).equals("coowner") || Config.getrank(p.getName().toLowerCase(), owner).equals("mod") || Config.getrank(p.getName().toLowerCase(), owner).equals("trusted") || p.isOp()) {
		    		String guest = "", member = "", trusted = "", mod = "", admin = "", coowner = "";
		    		ArrayList<String> list = Config.getplayers(owner);
		    		p.sendMessage(ChatColor.GREEN + "Owner: " + ChatColor.GRAY + owner);
		    		for (String pl : list) {
		    			if (Config.getrank(pl, owner).equals("guest"))
		    				if (guest.equals("")) guest = pl;
		    				else guest = guest + ", " + pl;
		    			if (Config.getrank(pl, owner).equals("admin"))
		    				if (admin.equals("")) admin = pl;
		    				else admin = admin + ", " + pl;
		    			if (Config.getrank(pl, owner).equals("member"))
		    				if (member.equals("")) member = pl;
		    				else member = member + ", " + pl;
		    			if (Config.getrank(pl, owner).equals("trusted"))
		    				if (trusted.equals("")) trusted = pl;
		    				else trusted = trusted + ", " + pl;
		    			if (Config.getrank(pl, owner).equals("mod"))
		    				if (mod.equals("")) mod = pl;
		    				else mod = mod + ", " + pl;
		    			if (Config.getrank(pl, owner).equals("coowner"))
		    				if (coowner.equals("")) coowner = pl;
		    				else coowner = coowner + ", " + pl;
		    		}
		    		if (!coowner.equals("")) p.sendMessage(ChatColor.GREEN + "Co-Owners: " + ChatColor.GRAY + coowner);
		    		if (!admin.equals("")) p.sendMessage(ChatColor.GREEN + "Admins: " + ChatColor.GRAY + admin);
		    		if (!mod.equals("")) p.sendMessage(ChatColor.GREEN + "Mods: " + ChatColor.GRAY + mod);
		    		if (!trusted.equals("")) p.sendMessage(ChatColor.GREEN + "Trusted: " + ChatColor.GRAY + trusted);
		    		if (!member.equals("")) p.sendMessage(ChatColor.GREEN + "Members: " + ChatColor.GRAY + member);
		    		if (!guest.equals("")) p.sendMessage(ChatColor.GREEN + "Guests: " + ChatColor.GRAY + guest);
		    		} else player.sendMessage(ChatColor.RED + "Can't do that here..");
		    	} else {
		    		player.sendMessage(ChatColor.GREEN + "/rank " + ChatColor.GRAY + "player rank");
		    	}
		    } else player.sendMessage(ChatColor.GREEN + "/rank " + ChatColor.GRAY + "player rank");
		  } else player.sendMessage(ChatColor.RED + "Realm not claimed");
			
			
			
		} catch (Exception e) {
			player.sendMessage(ChatColor.RED + "You're not in a realm!");
		}
		}
		return true;
	}
	
	

	
}
