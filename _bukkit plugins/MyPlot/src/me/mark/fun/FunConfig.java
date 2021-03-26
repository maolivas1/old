package me.mark.fun;

import java.io.File;

import org.bukkit.configuration.file.YamlConfiguration;

public class FunConfig {

	public static void setmsg(String realm, String type, String msg) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "motd.yml"));
			 c.set(realm + "." + type, msg);
	         c.save(new File(file, "motd.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static String getmsg(String realm, String type) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "motd.yml"));
	        if (c.contains(realm + "." + type)) {
		        return c.get(realm + "." + type).toString();
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return null;
	}
	
	public static Integer getint(String realm, String type) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "motd.yml"));
	        if (c.contains(realm + "." + type)) {
		        return Integer.parseInt(c.get(realm + "." + type).toString());
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return 0;
	}
	
}
