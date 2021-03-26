package me.mark.myplot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.intellectualcrafters.plot.PS;
import com.intellectualcrafters.plot.object.Plot;
import com.intellectualcrafters.plot.object.PlotArea;

public class giveRankCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command arg1, String arg2, String[] args) {
		
		if (sender.isOp()) {
		if (args.length == 2) {
			
			for (Player player : Bukkit.getOnlinePlayers()) {
				if (player.getName().equalsIgnoreCase(args[0])) {
					
					for (final PlotArea area : PS.get().getPlotAreas("plotworld"))
		                for (Plot plot : area.getPlotsAbs(player.getUniqueId())) {
					
					if (plot != null) {

						
		        com.intellectualcrafters.plot.object.Location l = plot.getCenter();
		        
				int s = getSize(l);//The last size of the realm
				int b = Integer.parseInt(args[1]);//Number of blocks to expand
				
				Location loc1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 0, l.getZ()+s+b);
                Location loc2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 256, l.getZ()-(s+b-1));
				updateRegion(player, loc1, loc2);
		        
		        //Dirt
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 1, l.getZ()+s+1);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 63, l.getZ()+s+b);
                fill(l1, l2, Material.DIRT);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 1, l.getZ()-(s+b-1));
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 63, l.getZ()-s);
                fill(l1, l2, Material.DIRT);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+1, 1, l.getZ()-(s+b-1));
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 63, l.getZ()+s+b);
                fill(l1, l2, Material.DIRT);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 1, l.getZ()-(s+b-1));
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s, 63, l.getZ()+s+b);
                fill(l1, l2, Material.DIRT);}
                
                //Stone
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 1, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 64, l.getZ()-s-b);
                fill(l1, l2, Material.STONE);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 1, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 64, l.getZ()+s+b+1);
                fill(l1, l2, Material.STONE);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 1, l.getZ()+s+b+1);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 64, l.getZ()+s+b+1);
                fill(l1, l2, Material.STONE);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 1, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 64, l.getZ()+s+b+1);
                fill(l1, l2, Material.STONE);}
                
                //Remove Old Barriers
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s, 65, l.getZ()-s);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+1, 255, l.getZ()-s);
                fill(l1, l2, Material.AIR);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s, 65, l.getZ()-s);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s, 255, l.getZ()+s+1);
                fill(l1, l2, Material.AIR);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s, 65, l.getZ()+s+1);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+1, 255, l.getZ()+s+1);
                fill(l1, l2, Material.AIR);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+1, 65, l.getZ()-s);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+1, 255, l.getZ()+s+1);
                fill(l1, l2, Material.AIR);}
                
                //Barriers
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 65, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 255, l.getZ()-s-b);
                fill(l1, l2, Material.BARRIER);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 65, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 255, l.getZ()+s+b+1);
                fill(l1, l2, Material.BARRIER);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 65, l.getZ()+s+b+1);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 255, l.getZ()+s+b+1);
                fill(l1, l2, Material.BARRIER);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 65, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 255, l.getZ()+s+b+1);
                fill(l1, l2, Material.BARRIER);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s-b, 255, l.getZ()-s-b);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b+1, 255, l.getZ()+s+b+1);
                fill(l1, l2, Material.BARRIER);}
                
                //Grass
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 64, l.getZ()+s+1);
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 64, l.getZ()+s+b);
                fill(l1, l2, Material.GRASS);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 64, l.getZ()-(s+b-1));
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 64, l.getZ()-s);
                fill(l1, l2, Material.GRASS);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+1, 64, l.getZ()-(s+b-1));
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()+s+b, 64, l.getZ()+s+b);
                fill(l1, l2, Material.GRASS);}
                
                {Location l1 = new Location(Bukkit.getWorld("plotworld"), l.getX()-(s+b-1), 64, l.getZ()-(s+b-1));
                Location l2 = new Location(Bukkit.getWorld("plotworld"), l.getX()-s, 64, l.getZ()+s+b);
                fill(l1, l2, Material.GRASS);}
                
					
                sender.sendMessage(ChatColor.GREEN + "Upgraded " + ChatColor.GRAY + args[0] + ChatColor.GREEN + "'s realm!");
					return true;
				} else player.sendMessage(ChatColor.RED + "Realm not claimed...");
				return true;
		      }
					player.sendMessage(ChatColor.GRAY + player.getName() + ChatColor.RED + " dosn't have a realm...");
				}
			}
			
			
			
		} else sender.sendMessage(ChatColor.GREEN + "/expand " + ChatColor.GRAY + "player blocks");
		} else sender.sendMessage(ChatColor.RED + "You can't do that...");
		
		return true;
	}
	
	public void fill(Location l1, Location l2, Material block) {
        for(double x = l1.getX(); x <= l2.getX(); x++)
        for(double y = l1.getY(); y <= l2.getY(); y++)
        for(double z = l1.getZ(); z <= l2.getZ(); z++)
        	new Location(Bukkit.getWorld("plotworld"), x, y, z).getBlock().setType(block);
	}
	
	public int getSize(com.intellectualcrafters.plot.object.Location l2) {
		Location l = new Location(Bukkit.getWorld("plotworld"), l2.getX(),l2.getY(),l2.getZ());
        for(double x = l.getX()-150; x <= l.getX(); x++)
        	if (new Location(Bukkit.getWorld("plotworld"), x,64,l.getZ()).getBlock().getType() == Material.STONE)
        		return (int) Math.abs((x - l.getX()));
		return 0;
	}
	
	public void updateRegion(Player player, Location l1, Location l2) {
		
		Config.setregion(player.getName(), "min", l1);
		Config.setregion(player.getName(), "max", l2);
		
		Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "wg reload");
	}

	
}