package me.Meaie.Cmd;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class Msg {

	public static void notallowed(CommandSender sender) {
	
	int num = new Random().nextInt(11);
	String msg = "";
	
	if (num == 0)
		msg = "You'r Not Allowed";
	if (num == 1)
		msg = "Can't Do That";
	if (num == 2)
		msg = "Sorry, Thats Not Guna Happen";
	if (num == 3)
		msg = "Uh... Nope";
	if (num == 4)
		msg = "Not Allowed";
	if (num == 5)
		msg = "Try Again... Never (Not Allowed)";
	if (num == 6)
		msg = "Sttop";
	if (num == 7)
		msg = "You'r Forbidden To Use That Command";
	if (num == 8)
		msg = "You'r Restricted To Use That Command";
	if (num == 9)
		msg = "That Command Is Off Limits";
	if (num == 10)
		msg = "No Permissions";
	
	sender.sendMessage(ChatColor.RED + msg);
	
	
	}
	
	public static void debug(String msg) {
		Bukkit.broadcastMessage(ChatColor.LIGHT_PURPLE + "Debug: " + msg);
	}
	
	
}
