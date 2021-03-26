package me.mark.myplot;

import me.mark.api.FancyMessage;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class messages {

	public static void notPro(Player player) {
		new FancyMessage("This isn't a ProRealm, Click here to learn how to upgrade to a ProRealm!").color(ChatColor.RED).tooltip("Click to learn how to\nupgrade to a ProRealm!").link("https://www.google.com/").send(player);
	}
	
	public static void proExpired(Player player) {
		new FancyMessage("Pro expired! You can keep it untill you logout, but don't forget to click here to renew it!").color(ChatColor.RED).tooltip("Click to learn how to\nupgrade to a ProRealm!").link("https://www.google.com/").send(player);
	}
	
}
