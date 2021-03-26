package me.Meatie.swan;

import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class tpserverCommand implements CommandExecutor {

	@SuppressWarnings("deprecation")
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		 if(sender instanceof Player) {
			 sender.sendMessage(ChatColor.RED + "Console / Command Blocks Only!");
			 return true;
		 }
		 
		           if (args.length == 2)
				for (Player p : Bukkit.getOnlinePlayers())
					if (args[0].equals(p.getName())) {
						p.teleport(p.getWorld().getSpawnLocation());
						tpServer(p, args[1]);
					}

		return true;
	}
	
	
	public void tpServer(Player player, String server) {
          ByteArrayDataOutput out = ByteStreams.newDataOutput();
          out.writeUTF("Connect");
          out.writeUTF(server);
          player.sendPluginMessage(Main.inst, "BungeeCord", out.toByteArray());
			
		}
	
}
