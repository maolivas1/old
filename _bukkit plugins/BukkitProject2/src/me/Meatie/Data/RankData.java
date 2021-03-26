package me.Meatie.Data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import me.Meatie.Listiner.LoadWorld;
import net.minecraft.util.org.apache.commons.io.IOUtils;

import org.bukkit.command.CommandSender;

public class RankData {
	
	
	public static boolean check(String world, String user, String rank) {
		
		if (!their(world)) return false;
		
		//TODO does the line of code below work?
		if (world.equals(user)) return true;
		
		if (rank.equals("owner"))
			if (get(world, user).equals("owner"))
				return true;
		
		if (rank.equals("admin"))
			if (get(world, user).equals("owner") || get(world, user).equals("admin"))
				return true;
			
			if (rank.equals("mod"))
				if (get(world, user).equals("owner") || get(world, user).equals("admin") || get(world, user).equals("mod"))
					return true;
			
			if (rank.equals("trusted"))
				if (get(world, user).equals("owner") || get(world, user).equals("admin") || get(world, user).equals("mod") || get(world, user).equals("trusted") )
			
			if (rank.equals("builder"))
				if (get(world, user).equals("owner") || get(world, user).equals("admin") || get(world, user).equals("mod") || get(world, user).equals("builder") || get(world, user).equals("trusted"))
					return true;
			
			if (rank.equals(null))
				if (get(world, user).equals(null))
					return true;
			
		return false;
	}
	
	public static boolean their(String world) {
		File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/rank.txt");
		if(file.exists())
			return true;
		return false;
	}
	
	
	public static String get(String world, String user) {
		
		if (world.equalsIgnoreCase(user)) return "admin";
		
		for (String name:  LoadWorld.map.keySet())
			//Correct World
			if (name.contains(world + " ")) {
				String[] args = name.split(" ");
				//Correct user
				if (args[1].equalsIgnoreCase(user))
					return LoadWorld.map.get(name);
			}
		return null;
	}
	/*
	public static String read(String world, String user) {
		
		if (world.equalsIgnoreCase(user)) return "owner";
		
		try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/rank.txt");
			    FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    String line;
			    while((line = br.readLine()) != null) {
				    br.close();
				    fr.close();
			        if(line.toLowerCase().startsWith(user.toLowerCase())) {
						String[] args = line.split(" ");
						return args[1].toLowerCase();
			        }
			    }
			    return null;
    } catch (Exception e) {}
		return null;
		
	}
	*/
	public static void save(CommandSender sender, String user, String rank) {
		clean(sender, user);
		
		if (rank.toLowerCase().equals("guest")) return;
		
		//Create Player's Folder If It dosn't exist.
		exists(sender.getName());
		try(PrintWriter output = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "/plugins/Meatie/" + sender.getName() + "/rank.txt",true)))  {
		    output.printf("%s\r\n", user + " " +  rank);
		}  catch (Exception e) {}
	}
	
	public static void clean(CommandSender sender, String user) {
	    try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + sender.getName() + "/rank.txt");
	    	String content = IOUtils.toString(new FileInputStream(file));
	    	content = content.replaceAll("(?m)^" + user + ".*", "");
	    	content = content.replaceAll("(?m)^[ \t]*\r?\n", "");
	    	IOUtils.write(content, new FileOutputStream(file));
	    } catch (Exception e) {}
	}
	
	public static void exists(String name) {
		File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + name);
		if(!file.exists())
			file.mkdir();
	}
	
}
