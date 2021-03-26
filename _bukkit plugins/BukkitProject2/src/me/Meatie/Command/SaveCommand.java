package me.Meatie.Command;

import me.Meatie.Data.InvData;
import me.Meatie.Data.LocData;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SaveCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			
		Bukkit.savePlayers();
		
		for (World world: Bukkit.getWorlds())
			world.save();
		
		for (Player player: Bukkit.getOnlinePlayers()) {
				InvData.save(player);
				LocData.save(player);
		}
		
		sender.sendMessage("saved");
			
		return true;
	}
}
