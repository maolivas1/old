package me.mark.fun;

import me.mark.api.FancyMessage;
import me.mark.myplot.Config;
import me.mark.myplot.Listiner;
import me.mark.myplot.messages;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class motdCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String args2, String[] args) {
		
		if (sender instanceof Player) {
			final Player player = (Player)sender;
			String realm = Listiner.getRealm(player);
			
			if (Config.isDonator(realm)) {
			if (Listiner.getRank(player).equals("owner") || Listiner.getRank(player).equals("coowner") || player.isOp()) {
					
			if (args.length == 0) {
			String title = FunConfig.getmsg(realm, "title");
			String subtitle = FunConfig.getmsg(realm, "subtitle");
			String bar = FunConfig.getmsg(realm, "bar");
			int fadein = FunConfig.getint(realm, "fadein");
			int stay = FunConfig.getint(realm, "stay");
			int fadeout = FunConfig.getint(realm, "fadeout");
			int duration = FunConfig.getint(realm, "duration");
			
			if (title != null) new FancyMessage(color(title)).tooltip("Click to edit Title").suggest("/d t " + title).send(player);
			else new FancyMessage("Click to add title!").color(ChatColor.BLUE).tooltip("Click to add Title").suggest("/d t TitleHere").send(player);
			
			if (subtitle != null) new FancyMessage(color(subtitle)).tooltip("Click to edit SubTitle").suggest("/d s " + title).send(player);
			else new FancyMessage("Click to add Subtitle!").color(ChatColor.BLUE).tooltip("Click to add SubTitle").suggest("/d s SubTitleHere").send(player);
			
			new FancyMessage("Fade In: " + fadein).color(ChatColor.BLUE).tooltip("Click to edit fade in time").suggest("/d fadein " + fadein).send(player);
			new FancyMessage("Duration: " + stay).color(ChatColor.BLUE).tooltip("Click to edit duration").suggest("/d stay " + stay).send(player);
			new FancyMessage("Fade Out: " + fadeout).color(ChatColor.BLUE).tooltip("Click to edit fade out time").suggest("/d fadeout " + fadeout).send(player);
			
			if (bar != null) new FancyMessage(color(bar)).tooltip("Click to edit Action Bar msg").suggest("/d bar " + bar).send(player);
			else  new FancyMessage("Click to add ActonBar msg").color(ChatColor.BLUE).tooltip("Click to add Action Bar msg").suggest("/d bar MsgHere").send(player);
			
			new FancyMessage("Duration: " + duration).color(ChatColor.BLUE).tooltip("Click to edit duration of Action Bar msg").suggest("/d duration " + duration).send(player);
			
			} else if (args.length >= 1) {
				if (args[0].equalsIgnoreCase("t")) {
					String title = get(args);
					if (args.length == 1) {
						FunConfig.setmsg(realm, "title", null);
						new FancyMessage("Title Removed!").color(ChatColor.RED).tooltip("Click to add Title").suggest("/d t TitleHere").send(player);
						return true;
					}
					FunConfig.setmsg(realm, "title", title);
					new FancyMessage("Title set to: " + color(title)).tooltip("Click to edit Title").suggest("/d t " + title).send(player);
				} else if (args[0].equalsIgnoreCase("s")) {
					String subtitle = get(args);
					FunConfig.setmsg(realm, "subtitle", subtitle);
					new FancyMessage("SubTitle set to: " + color(subtitle)).tooltip("Click to edit Subtitle").suggest("/d s " + subtitle).send(player);
				} else if (args[0].equalsIgnoreCase("fadein") || args[0].equalsIgnoreCase("fadeout") || args[0].equalsIgnoreCase("stay")) {
					if (StringUtils.isNumeric(args[1])) {
						FunConfig.setmsg(realm, args[0].toLowerCase(), args[1]);
						new FancyMessage(args[0] + " time set to: " + args[1]).color(ChatColor.BLUE).tooltip("Click to edit " + args[0] + " time").suggest("/d " + args[0] + " " + args[1]).send(player);
					} else player.sendMessage(ChatColor.RED + args[1] + " needs to be a number");
				} else if (args[0].equalsIgnoreCase("duration")) {
					if (StringUtils.isNumeric(args[1])) {
						FunConfig.setmsg(realm, "duration", args[1]);
						new FancyMessage("Duration set to: " + args[1]).color(ChatColor.BLUE).tooltip("Click to edit duration of Action Bar msg").suggest("/d duration " + args[1]).send(player);
					} else player.sendMessage(ChatColor.RED + args[1] + " needs to be a number");
				} else if (args[0].equalsIgnoreCase("bar")) {
					String bar = get(args);
					FunConfig.setmsg(realm, "bar", bar);
					new FancyMessage("ActionBar set to: " + color(bar)).tooltip("Click to edit ActionBar").suggest("/d bar " + bar).send(player);
				}
			}
				} else player.sendMessage(ChatColor.RED + "Only Co-Owner and Owner can do this!");
			} else messages.notPro(player);
		} 
		return true;
	}
	
	public static String color(String msg) {
		return ChatColor.translateAlternateColorCodes('&', msg);
	}
	
	
	public String get(String[] args) {
		String lol = null;
		boolean first = false;
		for (String temp : args)
			if (first == false)
				first = true;
			else
				if (lol == null) lol = temp;
				else lol = lol + " " + temp;
		return lol;
	}
	
}