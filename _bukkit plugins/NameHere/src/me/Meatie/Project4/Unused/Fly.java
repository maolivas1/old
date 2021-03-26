package me.Meatie.Project4.Unused;

import java.util.ArrayList;

import me.Meatie.Project2.Commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Fly {

	public static ArrayList<String> fly = new ArrayList<String>();
	
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		
		if (args.length == 2) {
			Player target = getPlayer(args[1]);
			if (target != null) {
				if (fly.contains(target.getName())) {
					fly.remove(target.getName());
		            Commands.send(target, "&2&lFly Mode &c&lDisabled");
		            Commands.send(player, "&2&lFly Mode &c&lDisabled &2&lFor &7&l" + target.getName());
		            target.setFlying(false);
		            target.setAllowFlight(false);
				} else {
					fly.add(target.getName());
					Commands.send(target, "&2&lFly Mode &a&lEnabled");
					Commands.send(player, "&2&lFly Mode &a&lEnabled &2&lFor &7&l" + target.getName());
					target.setAllowFlight(true);
					target.setFlying(true);
				}
			} else Commands.send(player, "&c&lUnknown Player");
			
		} else {
		if (fly.contains(player.getName())) {
			fly.remove(player.getName());
            Commands.send(player, "&2&lFly Mode &c&lDisabled");
            player.setFlying(false);
            player.setAllowFlight(false);
		} else {
			fly.add(player.getName());
			Commands.send(player, "&2&lFly Mode &a&lEnabled");
			player.setAllowFlight(true);
			player.setFlying(true);
		}
	}
	}
	
	@SuppressWarnings("deprecation")
	public static Player getPlayer(String name) {
		for (Player p : Bukkit.getOnlinePlayers())
			if (p.getName().toLowerCase().startsWith(name.toLowerCase())) {
				return p;
			}
		return null;
	}
	
}
