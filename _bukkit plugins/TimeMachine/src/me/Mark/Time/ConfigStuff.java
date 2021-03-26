package me.Mark.Time;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigStuff {
	
	public static void setWorth(String item) {
		
		if (getWorth(item) == 0) {
			//Item already their, remove it.
			
			 try {
				 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worth.yml"));
				 List<String> list = Arrays.asList(c.getString("shop"));
				 list.remove(item);
				 c.set("shop", list);
		         c.save(new File(file, "worth.yml"));
		    } catch (Exception e) {System.out.println(e.getMessage());}
			 
			 return;
			
		}
		
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worth.yml"));
			 List<String> list = Arrays.asList(c.getString("shop"));
			 list.add(item);
			 c.set("shop", list);
	         c.save(new File(file, "worth.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static double getWorth(String item) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "worth.yml"));
	        List<String> list = Arrays.asList(c.getString("shop"));
	        if (list.contains(item)) {
		        return 1;
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return -1.0;
	}
	
	public static List<String> getWorths() {
		ArrayList<String> list = new ArrayList<String>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "worth.yml"));
	        
	        return Arrays.asList(c.getString("shop"));

	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
}
