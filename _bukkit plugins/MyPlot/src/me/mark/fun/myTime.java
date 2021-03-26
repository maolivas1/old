package me.mark.fun;

import me.mark.myplot.Listiner;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class myTime {
	
	
	
	//Called on going to new realm, and login
	public static void update(Player player, String realm) {
		
		if (timeCommand.offset.containsKey(realm)) {
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (Listiner.getRealm(p).equals(realm)) {
				
				Integer offset = timeCommand.offset.get(realm);
				//long time = player.getWorld().getTime();
				
				//TODO check if number is negative, or too big...
				
				//player.sendMessage("Setting time to: " + time + " offset: " + offset);
				p.setPlayerTime(offset, true);
				
				
			}
		}
		
		}
	}
	
	
}
