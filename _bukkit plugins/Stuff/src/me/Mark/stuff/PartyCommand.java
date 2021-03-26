package me.Mark.stuff;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class PartyCommand implements CommandExecutor {

	static boolean party = false;
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (party == false) {
			party = true;
			sender.sendMessage(ChatColor.GREEN + "Party Enabled!!");
		} else {
			party = false;
			sender.sendMessage(ChatColor.RED + "Party Disabled..");
		}
		
		return true;
	}
	
	public static void run() {
      Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.inst, new Runnable() {
          @Override
          public void run() {
        	  if (party == true) {
         	 int xoff = new Random().nextInt(50) - 25;//0 - 25
         	 int zoff = new Random().nextInt(50) - 25;//0 - 25
         	Location loc = new Location(Bukkit.getWorld("world"), -288 + xoff, 28, -256 + zoff);
             fwCommand.spawnFirework(loc);
             
             int xoff2 = new Random().nextInt(50) - 25;//0 - 25
         	 int zoff2 = new Random().nextInt(50) - 25;//0 - 25
          	Location loc2 = new Location(Bukkit.getWorld("world"), -149 + xoff2, 109, -219 + zoff2);
            fwCommand.spawnFirework(loc2);
        	  }
          }
      }, 0L, 20L);
	}
	
	
	
}
