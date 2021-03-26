package me.mark.fun;

import me.mark.api.ActionBarAPI;
import me.mark.api.TitleAPI;
import me.mark.myplot.Config;

import org.bukkit.entity.Player;

public class motdEvents {
	
	//Called when player is going to new realm
	public static void motd(Player player, String realm) {
		
		if (Config.isDonator(realm)) {
		
		int fadein = FunConfig.getint(realm, "fadein");
		int stay = FunConfig.getint(realm, "stay");
		int fadeout = FunConfig.getint(realm, "fadeout");
		
		if (fadein == 0) {
			FunConfig.setmsg(realm, "fadein", "1");
			fadein = 3;
		}
		if (stay == 0) {
			FunConfig.setmsg(realm, "stay", "3");
			stay = 3;
		}
		if (fadeout == 0) {
			FunConfig.setmsg(realm, "fadeout", "1");
			fadeout = 3;
		}
		
		String title = FunConfig.getmsg(realm, "title");
		String subtitle = FunConfig.getmsg(realm, "subtitle");
		TitleAPI.sendTitle(player,fadein*20,stay*20,fadeout*20,title,subtitle);
		
		
		int duration = FunConfig.getint(realm, "duration");
		if (duration == 0) {
			FunConfig.setmsg(realm, "duration", "5");
			duration = 5;
		}
		
		String bar = FunConfig.getmsg(realm, "bar");
		if (bar != null) {
		ActionBarAPI.sendActionBar(player, motdCommand.color(bar), duration*20);
		}
		}	
	}
	
	
}
