package me.Meatie.Project4.Unused;

import java.io.File;

import me.Meatie.Project2.Main;

import org.bukkit.configuration.file.YamlConfiguration;

public class RankData {
	
	 public static void set(String user, String rank) {
		 try {
			 File file = new File(Main.dir);
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "ranks.yml"));
	        c.set(user, rank);
	        Rank.rank.put(user, rank);
	        c.save(new File(file, "ranks.yml"));
	    } catch (Exception e) {}
	    }
	 
	    public static void load(String user) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "ranks.yml"));
	        if (c.contains(user))
	        Rank.rank.put(user, c.get(user).toString());
	    } catch (Exception e) {}
	    }
}
