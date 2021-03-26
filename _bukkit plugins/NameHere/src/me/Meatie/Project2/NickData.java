package me.Meatie.Project2;

import java.io.File;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class NickData {
	
	public static String dir = "H:/Mark/Documents/Minecraft Stuff/Network/Data/nicks.yml";
	 
	    public static void load(String user) {
			try {
				Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(dir));
				if (config.getKeys().contains(user))
	            NickCommand.nick.put(user, config.get(user).toString());
	    } catch (Exception e) {}
	    }
}