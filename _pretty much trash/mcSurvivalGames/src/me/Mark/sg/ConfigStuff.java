package me.Mark.sg;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigStuff {

	@SuppressWarnings("unchecked")
	public static void add(String type, Location loc) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "data.yml"));
			 if (loc != null) {
			 List<String> list = (List<String>)c.getList(type);
			 if (list == null) list = new ArrayList<String>();
			 int x = ((int) loc.getX());
			 int y = ((int) loc.getY());
			 int z = ((int) loc.getZ());
			 list.add(x + "," + y + "," + z);
			 c.set(type, list);
			 } else c.set(type, null);
	         c.save(new File(file, "data.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<Location> get(String type) {
		ArrayList<Location> list = new ArrayList<Location>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "data.yml"));
	        List<String> loop = (List<String>)c.getList(type);
	        for (String l : loop) {
	        	String[] arg = l.split(",");
	        	double x = Integer.parseInt(arg[0]);
	        	double y = Integer.parseInt(arg[1]);
	        	double z = Integer.parseInt(arg[2]);
	        	Location loc = new Location(Bukkit.getWorld("world"), x, y, z); 
	        	list.add(loc);
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
}
