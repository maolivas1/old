package me.Meatie.Project4.Unused;

import java.util.Random;

import me.Meatie.Project2.Fix;
import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Lain {
	
	public static void think(Player player, String data) {
		String msg = data.toLowerCase();
		
		if (!msg.contains("lain")) return;
		
		
			
		if ((msg.contains("like") || msg.contains("love") || msg.contains("(heart)")) && (msg.contains("you") || msg.contains(" u ")))
			send(player, "like");
		else if ((msg.contains(" u ") || msg.contains("you")) && (msg.contains("live") || msg.contains("at") || msg.contains("home") || msg.contains("house")))
			send(player, "home");
		else if ((msg.contains("what") || msg.contains("how")) && (msg.contains("/back") || (msg.contains("back") && (msg.contains("cmd") || msg.contains("command")))))
			send(player, "back");
		else if ((msg.contains("what") || msg.contains("how")) && (msg.contains("/bal") || (msg.contains("bal") && (msg.contains("cmd") || msg.contains("command")))))
			send(player, "bal");
		else if (msg.contains("help"))
			send(player, "help");
		
		
	}
	
	public static void send(Player player, String msg) {
	    int num = new Random().nextInt(5);
		if (msg.equals("like"))
			if (num == 0) chat(player, "I don't know what to say about that player...");
			else if (num == 1) chat(player, "I get asked that a lot..");
			else if (num == 2) chat(player, "player, I was programed by a Meatie, what are you trying to say about him?");
			else if (num == 3) chat(player, "Sorry player, I'm a computer AI");
			else if (num == 4) chat(player, "...");
			 if (msg.equals("help"))
				if (num == 0) chat(player, "Type /help for a list of commands you can use.");
				else if (num == 1) chat(player, "Try the command /help to see all the commands that you can use");
				else if (num == 2) chat(player, "You should try out /help");
				else if (num == 3) chat(player, "/help might help you.");
				else if (num == 4) chat(player, "Help? try /help");
			 if (msg.equals("home"))
				if (num == 0) chat(player, "I live on this server");
				else if (num == 1) chat(player, "You could say i'm non existent because I'm just code");
				else if (num == 2) chat(player, "In a pinaple under the sea");
				else if (num == 3) chat(player, "Acording to my ip adress's location I live somewhere in California.");
				else if (num == 4) chat(player, "I'm somewhere in California, you should never tell anyone you'r location. But I'm a server, so thats public anyway :P");
			 if (msg.equals("back"))
				if (num == 0) chat(player, "/back is used to return to were you were last.");
				else if (num == 1) chat(player, "Its a command you can use to go back.");
				else if (num == 2) chat(player, "/back brings you to were you were before you teleported last.");
				else if (num == 3) chat(player, "You can use /back by typing it in chat.");
				else if (num == 4) chat(player, "/back teleportes you back.");
			 if (msg.equals("bal"))
				if (num == 0) chat(player, "/bal is used to check how much in-game money you have.");
				else if (num == 1) chat(player, "You can do /bal <name> to check how much money other people have.");
				else if (num == 2) chat(player, "You might also like /baltop, it shows evryones money!");
				else if (num == 3) chat(player, "/bal is cosmetic meaning it dosn't effect gameplay.");
				else if (num == 4) chat(player, "You can do /bal <name> to check how much money other people have");
	}
	
	public static void chat(final Player player, final String msg) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
            @Override
            public void run() {
        		String send = ChatColor.DARK_PURPLE + "Lain" + ChatColor.WHITE + ": " + ChatColor.GRAY  + Fix.format(msg).replace("player", player.getName());
        		Bukkit.broadcastMessage(send);
            }
        });

	}
	
	
//12345
//67890
	
	//16273849
	
	
	
	
}

