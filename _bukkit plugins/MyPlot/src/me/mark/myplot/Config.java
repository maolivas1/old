package me.mark.myplot;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class Config {

	public static void setregion(String player, String key, Location loc) {
		 try {
			 player = player.toLowerCase();
			 File file = new File(System.getProperty("user.dir") + "/plugins/WorldGuard/worlds/plotworld/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "regions.yml"));
			 c.set("regions." + player + "." + key + ".x", loc.getX());
			 c.set("regions." + player + "." + key + ".y", loc.getY());
			 c.set("regions." + player + "." + key + ".z", loc.getZ());
	         c.save(new File(file, "regions.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static void setrep(Player player, int rep) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "rep.yml"));
			 c.set(player.getName(), rep);
	         c.save(new File(file, "rep.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static Integer getrep(Player player) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "rep.yml"));
	        if (c.contains(player.getName())) {
		        return Integer.valueOf(c.get(player.getName()).toString());
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return 0;
	}
	
	public static void setrank(String player, String realm, String rank) {
		 try {
			 rank = rank.toLowerCase();
	         if (rank.equals("none")) rank = null;
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "ranks.yml"));
			 c.set(realm.toLowerCase() + "." + player.toLowerCase(), rank);
	         c.save(new File(file, "ranks.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static String getrank(String player, String realm) {
		if (player.equalsIgnoreCase(realm)) return "owner";
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "ranks.yml"));
	        if (c.contains(realm.toLowerCase() + "." + player.toLowerCase())) {
		        return c.get(realm.toLowerCase() + "." + player.toLowerCase()).toString();
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return "none";
	}
	
	public static ArrayList<String> getplayers(String realm) {
		ArrayList<String> list = new ArrayList<String>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "ranks.yml"));
	        
	        for(String pl : c.getConfigurationSection(realm.toLowerCase()).getKeys(false))
	        	list.add(pl);
	        
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public static void addhome(String player, String realm) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "realms.yml"));
			 ArrayList<String> list = new ArrayList<String>();
			 if (c.getList(player.toLowerCase()) != null) list = (ArrayList<String>) c.getList(player.toLowerCase());
			 if (!list.contains(realm))
		        list.add(realm);
			 c.set(player.toLowerCase(), list);
	         c.save(new File(file, "realms.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static void delhome(String player, String realm) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "realms.yml"));
			 ArrayList<String> list = new ArrayList<String>();
			 if (c.getList(player.toLowerCase()) != null) list = (ArrayList<String>) c.getList(player.toLowerCase());
			 if (list.contains(realm))
		        list.remove(realm);
			 c.set(player.toLowerCase(), list);
	         c.save(new File(file, "realms.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> gethomes(String player) {
		ArrayList<String> list = new ArrayList<String>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "realms.yml"));
	        
	        if (c.getList(player.toLowerCase()) != null) list = (ArrayList<String>) c.getList(player.toLowerCase());
	        
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
	public static void setspawn(String realm, Location loc) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "spawns.yml"));
			 c.set(realm.toLowerCase() + ".x", loc.getX());
			 c.set(realm.toLowerCase() + ".y", loc.getY());
			 c.set(realm.toLowerCase() + ".z", loc.getZ());
			 c.set(realm.toLowerCase() + ".yaw", loc.getYaw());
			 c.set(realm.toLowerCase() + ".pitch", loc.getPitch());
	         c.save(new File(file, "spawns.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static Location getspawn(String realm) {
		Location loc = null;
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "spawns.yml"));
	        if (c.contains(realm.toLowerCase() + ".x")) {
	        	double x = Double.valueOf(c.get(realm.toLowerCase() + ".x").toString());
	        	double y = Double.valueOf(c.get(realm.toLowerCase() + ".y").toString());
	        	double z = Double.valueOf(c.get(realm.toLowerCase() + ".z").toString());
	        	float yaw = Float.valueOf(c.get(realm.toLowerCase() + ".yaw").toString());
	        	float pitch = Float.valueOf(c.get(realm.toLowerCase() + ".pitch").toString());
	        	loc = new Location(Bukkit.getWorld("plotworld"), x, y, z);
	        	loc.setYaw(yaw);
	        	loc.setPitch(pitch);
		        return loc;
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return loc;
	}
	
	public static void setDonator(String player, String time) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "donators.yml"));
			 c.set(player.toLowerCase(), time);
	         c.save(new File(file, "donators.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static String getExpire(String player) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "donators.yml"));
	        if (c.contains(player.toLowerCase())) return c.get(player.toLowerCase()).toString();
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return null;
	}
	
	public static boolean isDonator(String player) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "donators.yml"));
	        if (c.contains(player.toLowerCase())) return true;
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return false;
	}
	
}
