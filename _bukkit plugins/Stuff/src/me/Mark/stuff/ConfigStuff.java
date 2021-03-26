package me.Mark.stuff;

import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigStuff {

	public static void setWorth(String item, double price) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worth.yml"));
			 c.set("price." + item, price);
	         c.save(new File(file, "worth.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static double getWorth(String item) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "worth.yml"));
	        if (c.contains("price." + item)) {
		        return Double.valueOf(c.get("price." + item).toString());
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
	
	public static void setRestricted(UUID uuid, boolean yes) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "restricted.yml"));
			 c.set(uuid.toString(), yes);
	         c.save(new File(file, "restricted.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static boolean getRestricted(UUID uuid) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "restricted.yml"));
	        if (c.contains(uuid.toString()))
		        return true;
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return false;
	}
	
	public static String getVoteBlock(String vote) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "voteStuff.yml"));
	        if (c.contains("vote." + vote + ".block")) {
		        return c.get("vote." + vote + ".block").toString();
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return "GLASS";
	}
	
	public static double getVotePrize(String vote) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "voteStuff.yml"));
	        if (c.contains("vote." + vote + ".prize")) {
		        return Double.valueOf(c.get("vote." + vote + ".prize").toString());
	        }
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return 100;
	}
	
	public static ArrayList<String> getVoteStuff() {
		ArrayList<String> list = new ArrayList<String>();
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "voteStuff.yml"));
	        
	        for(String block : c.getConfigurationSection("vote").getKeys(false))
	        	list.add(block);
	        
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
	public static void setWarpCont(String player, String type, int count) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "warpCount.yml"));
			 c.set(player + "." + type, count);
	         c.save(new File(file, "warpCount.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	public static int getWarpCount(String player, String type) {
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "warpCount.yml"));
	        if (c.contains(player + "." + type))
		        return c.getInt(player + "." + type);
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public static void addPlayerWarp(String player, String warp) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "warps.yml"));
			 ArrayList<String> list = new ArrayList<String>();
			 if (c.getList(player) != null) list = (ArrayList<String>) c.getList(player);
		        list.add(warp);
			 c.set(player, list);
	         c.save(new File(file, "warps.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static void delPlayerWarp(String player, String warp) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "warps.yml"));
			 ArrayList<String> list = (ArrayList<String>) c.getList(player);
		        list.remove(warp);
			 c.set(player, list);
	         c.save(new File(file, "warps.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getPlayerWarps(String player) {
		ArrayList<String> list = null;
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "warps.yml"));
	        list = (ArrayList<String>) c.getList(player);
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
}
