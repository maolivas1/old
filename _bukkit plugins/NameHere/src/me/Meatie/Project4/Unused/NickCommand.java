package me.Meatie.Project4.Unused;

import java.util.HashMap;

import net.md_5.bungee.api.CommandSender;

public class NickCommand {

	public static HashMap<String, String> nick = new HashMap<String, String>();

	public static void cmd(CommandSender player, String[] args) {
		if (args.length == 2)
			NickCommand.nick.put(player.getName(), args[1]);
    }
	
}
