package me.Meatie.swan;

import java.io.File;
import java.util.List;

import me.Meatie.Project2.Fix;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	
	 public static void save(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "data.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "data.yml"));
	         Bukkit.broadcastMessage(Fix.format("&cConfig Value &e" + thing + " &cSet To &e" + value));
	    } catch (Exception e) {
	    	Bukkit.broadcastMessage(Fix.format("&cEcception Saveing: " + e.getMessage()));
	    }
	    }
	 
	    public static String get(String thing) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "data.yml"));
	        if (c.contains(thing)) {
	        return c.get(thing).toString();
	        } else {
	        	Bukkit.broadcastMessage(Fix.format("&cError: Config Value &e" + thing + " &cCould Not Be Loaded."));
	        }
	    } catch (Exception e) {
	    	Bukkit.broadcastMessage(Fix.format("&cEcception Loading: " + e.getMessage()));
	    }
			return null;
	    }
	    //TODO Reputation
		 public static void saveRep(String thing, int value) {
			 try {
				 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "rep.yml"));
				 c.set(thing, value);
		         c.save(new File(file, "rep.yml"));
		    } catch (Exception e) {}
		    }
		 
		    public static int getRep(String thing) {
				try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "rep.yml"));
		        if (c.contains(thing)) {
		        return Integer.valueOf(c.get(thing).toString());
		        }
		    } catch (Exception e) {}
				return 0;
		    }
		    
		    //TODO Mute
			 public static void saveMute(String thing) {
				 try {
					 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
					 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "mute.yml"));
					 List<String> list = c.getStringList("muted");
					 list.add(thing);
					 c.set("muted", list);
			         c.save(new File(file, "mute.yml"));
			    } catch (Exception e) {}
			    }
			 
			 public static void saveunMute(String thing) {
				 try {
					 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
					 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "mute.yml"));
					 List<String> list = c.getStringList("muted");
					 list.remove(thing);
					 c.set("muted", list);
			         c.save(new File(file, "mute.yml"));
			    } catch (Exception e) {}
			    }
			 
			    public static boolean getMute(String thing) {
					try {
			        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "mute.yml"));
			        List<String> list = c.getStringList("muted");
			        if (list.contains(thing)) {
			        return true;
			        }
			    } catch (Exception e) {}
					return false;
			    }
				    //TODO Prefix
					 public static void savePrefix(String thing, String value) {
						 try {
							 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
							 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "prefix.yml"));
							 c.set(thing, value);
					         c.save(new File(file, "prefix.yml"));
					    } catch (Exception e) {}
					    }
					 
					    public static String getPrefix(String thing) {
							try {
					        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "prefix.yml"));
					        if (c.contains(thing))
					        return c.get(thing).toString();
					    } catch (Exception e) {}
							return null;
					    }
					    public static List<String> getPerms(String thing) {
							try {
					        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/perms", "group.yml"));
					        List<String> list = c.getStringList(thing);
					        return list;
					    } catch (Exception e) {}
							return null;
					    }
					    //TODO Permissions
						 public static void savePerm(String player, String perm) {
							 try {
								 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
								 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "perms.yml"));
								 List<String> list = c.getStringList(player);
								 list.add(perm);
								 c.set(player, list);
						         c.save(new File(file, "perms.yml"));
						    } catch (Exception e) {}
						    }
}