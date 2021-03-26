package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Main;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.Plugin;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;

public class Server {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		
		String server = args[0].toLowerCase();
		
		if (server.equals("creative") || server.equals("survival") || server.equals("games") || server.equals("meca") || server.equals("factions"))
		connect(player, server);
	}
	
	public static void connect(Player player, String server) {
	    ByteArrayDataOutput out = ByteStreams.newDataOutput();
	    out.writeUTF("Connect");
	    out.writeUTF(server);
	    player.sendPluginMessage((Plugin) Main.inst, "BungeeCord", out.toByteArray());
	}
	
}
