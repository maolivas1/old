package me.Meatie.Project4.Unused;

import java.io.File;

import me.Meatie.Project2.Main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class NickData {
	
	 public static void save(Player user, String nick) {
		 try {
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "nicks.yml"));
	        c.set(user.getName(), nick);
	        Nick.nick.put(user.getName(), nick);
	        c.save(new File(Main.dir, "nicks.yml"));
	    } catch (Exception e) {}
	    }
	 
	    public static void load(Player user) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "nicks.yml"));
	        if (c.contains(user.getName())) {
	        String nick = c.get(user.getName()).toString();
	        Nick.nick.put(user.getName(), nick);
	        }
	    } catch (Exception e) {}
	    }
}
