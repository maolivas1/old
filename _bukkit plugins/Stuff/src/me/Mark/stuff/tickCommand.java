package me.Mark.stuff;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;


public class tickCommand implements CommandExecutor {
	
	int mobId;
	int genId;
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender.isOp()) {
			
			if (args.length >= 1) {
				
				if (args[0].equalsIgnoreCase("mob")) {
					
					if (args.length >= 2) {
						if (args[1].equalsIgnoreCase("stop")) {
							stopMobs();
						} else
						if (args.length >= 3) {
							startMobs(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
							sender.sendMessage(ChatColor.GREEN  + "Spawning " + Integer.parseInt(args[1]) + " Mobs every " + Integer.parseInt(args[2]) + " Secconds");
						} else sender.sendMessage(ChatColor.GRAY + "/tick mob <count> <delay>");
					} else sender.sendMessage(ChatColor.GRAY + "/tick mob stop /tick mob <count> <delay>");
					
				} else if (args[0].equalsIgnoreCase("gen")) {
					
					if (args.length >= 2) {
						if (args[1].equalsIgnoreCase("stop")) {
							stopMobs();
						} else
						if (args.length >= 3) {
							startMobs(Integer.parseInt(args[1]), Integer.parseInt(args[2]));
							sender.sendMessage(ChatColor.GREEN  + "Spawning " + Integer.parseInt(args[1]) + " Ores every " + Integer.parseInt(args[2]) + " Secconds");
						} else sender.sendMessage(ChatColor.GRAY + "/tick gen <count> <delay>");
					} else sender.sendMessage(ChatColor.GRAY + "/tick gen stop /tick gen <count> <delay>");
				}  else sender.sendMessage(ChatColor.GRAY + "/tick gen /tick mob");
			}  else sender.sendMessage(ChatColor.GRAY + "/tick gen /tick mob");
			
			
		} else {
			sender.sendMessage(ChatColor.RED + " Ur Not Allowed!");
		}
		
		
		return true;
	}
	
	public void startMobs(final int count, int time) {
		mobId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	

            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mob " + count);
            	
            }
        }, 0L, time);
	}
	
	public void stopMobs() {
		Bukkit.getServer().getScheduler().cancelTask(mobId);	
	}
	
	public void startGen(final int count, int time) {
		genId = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.inst, new Runnable() {
            @Override
            public void run() {
            	

            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "gen " + count);
            	
            }
        }, 0L, time);
	}
	
	public void stopGen() {
		Bukkit.getServer().getScheduler().cancelTask(genId);	
	}
	
	
	
	
}
