package me.Mark.blockMe;

import java.io.File;
import java.util.ArrayList;

import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigStuff {
	
	@SuppressWarnings("unchecked")
	public static void addCmd(String warp) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "cmds.yml"));
			 ArrayList<String> list = new ArrayList<String>();
			 list = (ArrayList<String>) c.getList("blocked");
		        list.add(warp);
			 c.set("blocked", list);
	         c.save(new File(file, "cmds.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static void delCmd(String warp) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Stuff/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "cmds.yml"));
			 ArrayList<String> list = (ArrayList<String>) c.getList("blocked");
		        list.remove(warp);
			 c.set("blocked", list);
	         c.save(new File(file, "cmds.yml"));
	    } catch (Exception e) {System.out.println(e.getMessage());}
	}
	
	@SuppressWarnings("unchecked")
	public static ArrayList<String> getCmds() {
		ArrayList<String> list = null;
		try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Stuff/", "cmds.yml"));
	        list = (ArrayList<String>) c.getList("blocked");
	    } catch (Exception e) {System.out.println(e.getMessage());}
		return list;
	}
	
}
