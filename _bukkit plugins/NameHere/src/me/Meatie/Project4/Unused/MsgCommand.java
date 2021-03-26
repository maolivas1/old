package me.Meatie.Project4.Unused;

import me.Meatie.Project2.Main;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MsgCommand {

	@SuppressWarnings("deprecation")
	public static void cmd(CommandSender player, String[] args, ProxiedPlayer p) {
		if (args.length >= 2) {
					String msg = Main.format(fix(args).substring(args[0].length() + args[1].length() + 2));
					player.sendMessage(ChatColor.GOLD + "PM " + ChatColor.GRAY + Main.format(Main.nick(p.getName()) + ChatColor.GREEN + msg));
					if (p != player)
					p.sendMessage(ChatColor.GOLD + "PM " + ChatColor.GRAY + Main.format(Main.nick(player.getName()) + ChatColor.GREEN + msg));
					return;
		} else player.sendMessage(Main.format("&c&l/msg &7&lPlayer"));
	}
	public static String fix(String[] args) {
		StringBuilder builder = new StringBuilder();
		for(String s : args) {
		    builder.append(" ");
		    builder.append(s);
		}
		return builder.toString();
	}
}