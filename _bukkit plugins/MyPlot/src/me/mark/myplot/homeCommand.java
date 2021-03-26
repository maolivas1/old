package me.mark.myplot;

import java.util.ArrayList;

import me.mark.api.FancyMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotArea;
import com.sk89q.worldedit.BlockVector;
import com.sk89q.worldguard.protection.flags.DefaultFlag;
import com.sk89q.worldguard.protection.flags.StateFlag.State;
import com.sk89q.worldguard.protection.regions.ProtectedCuboidRegion;

public class homeCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String args2, String[] args) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			
			if (args.length == 1) {
				ArrayList<String> list = Config.gethomes(player.getName());
				if (args[0].equalsIgnoreCase("list")) {
					FancyMessage m = new FancyMessage("Realms you have access to: ").color(ChatColor.BLUE).then("Yours").color(ChatColor.DARK_GREEN).tooltip("Teleport To Your Realm!").command("/realm");
		    		for (String home : list)
		    		m.then(", ").color(ChatColor.BLUE).then(home).color(ChatColor.DARK_GREEN).tooltip("Teleport To " + home + "'s Realm!").command("/realm " + home);
		    		m.send(sender);
				} else if (list.contains(args[0])) {
					
					player.teleport(Config.getspawn(args[0]));
					
				} else player.sendMessage(ChatColor.RED + "Unknown realm: " + args[0]);
				
			} else
			
			for (final PlotArea area : PS.get().getPlotAreas("plotworld")) {
				Location loc = Config.getspawn(player.getName());
				if (loc != null)
				player.teleport(loc);
				else {
	                //Player dosn't have a plot, make it
	                player.chat("/plotsquared:plot auto");
	                
	                
	                Bukkit.getScheduler().scheduleSyncDelayedTask(MyPlot.inst, new Runnable() {
	                    @Override
	                    public void run() {
	                
	               Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "expand " + player.getName() + " 0");
		                for (Plot plot : area.getPlotsAbs(player.getUniqueId())) {
	                com.intellectualcrafters.plot.object.Location l = plot.getCenter();
	                Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()+16, 0, l.getZ()+16);
	                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()-15, 256, l.getZ()-15);
	                BlockVector v1 = new BlockVector(l1.getX(),l1.getY(),l1.getZ());
	                BlockVector v2 = new BlockVector(l2.getX(),l2.getY(),l2.getZ());
	                
                    ProtectedCuboidRegion region = new ProtectedCuboidRegion(player.getName(), v1, v2);
                    region.setFlag (DefaultFlag.BUILD, State.ALLOW);
                    region.setFlag (DefaultFlag.EXIT, State.DENY);
                    MyPlot.wg.getRegionManager(player.getWorld()).addRegion(region);
                    Config.setspawn(player.getName(), new Location(Bukkit.getWorld("plotworld"), l.getX(), l.getY(), l.getZ()));
            return;
		                }
		                
	                    }
	                }, 100L);
		                
				}
	                }

            //DefaultDomain owners = new DefaultDomain();
            //owners.addPlayer(MyPlot.wg.wrapPlayer(player));
            //region.setOwners(owners);
		
		}
		
		return true;
	}
}