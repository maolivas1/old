package me.Mark.mark;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigStuff {

	public static void setWorth(int id, double price, int durability) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worth.yml"));
			 c.set("price." + id + "," + durability, price);
	         c.save(new File(file, "worth.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static double getWorth(String block) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "worth.yml"));
	        if (c.contains("price." + block)) {
		        return Double.valueOf(c.get("price." + block).toString());
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return -1.0;
	}
	
	public static ArrayList<String> getWorths() {
		ArrayList<String> list = new ArrayList<String>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "worth.yml"));
	        
	        for(String block : c.getConfigurationSection("price").getKeys(false))
	        	list.add(block);
	        
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
	
	public static void addCommand(String cmd, int block, double price) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "cmds.yml"));
			 c.set("cmd." + cmd + ".price", price);
			 c.set("cmd." + cmd + ".block", block);
	         c.save(new File(file, "cmds.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static ArrayList<String> getCommands() {
		ArrayList<String> list = new ArrayList<String>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "cmds.yml"));
	        
	        for(String block : c.getConfigurationSection("cmd").getKeys(false))
	        	list.add(block);
	        
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
	public static int getCmdBlock(String cmd) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "cmds.yml"));
	        if (c.contains("cmd." + cmd + ".block")) {
		        return Integer.valueOf(c.get("cmd." + cmd + ".block").toString());
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return 20;
	}
	
	public static double getCmdPrice(String cmd) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "cmds.yml"));
	        if (c.contains("cmd." + cmd + ".price")) {
		        return Double.valueOf(c.get("cmd." + cmd + ".price").toString());
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return -1.0;
	}
	
	public static void setType(String type) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "config.yml"));
			 c.set("type", type);
	         c.save(new File(file, "config.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static String getType() {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "config.yml"));
	        
	        return c.get("type").toString();
	        
	    } catch (Exception e) {System.out.println(e.getMessage()); 
	    setType("defult");
	    return "error";}
	}
	
}
