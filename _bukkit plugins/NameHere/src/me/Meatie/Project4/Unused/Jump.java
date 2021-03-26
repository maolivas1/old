package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Commands;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Jump {

	@SuppressWarnings("deprecation")
	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		Location loc = player.getTargetBlock(null, 100).getLocation();
		loc.setYaw(player.getLocation().getYaw());
		loc.setPitch(player.getLocation().getPitch());
		loc.setY(loc.getY() + 1);
		player.teleport(loc);
		Commands.send(player, "&a&lJumped To New Location");
	}
}
