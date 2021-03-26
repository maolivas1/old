package me.Meatie.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import net.minecraft.util.org.apache.commons.io.IOUtils;

import org.bukkit.command.CommandSender;

public class PrivacyData {

	public static String read(String world) {
		try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/privacy.txt");
			    FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    String line;
			    br.close();
			    fr.close();
			    while((line = br.readLine()) != null) {
			        if(line.toLowerCase().startsWith(world.toLowerCase())) {
						String[] args = line.split(" ");
						return args[1].toLowerCase();
			        }
			    }
			    return "null";
    } catch (Exception e) {}
		return "null";
	}
	
	public static void save(CommandSender player, String type) {
		clean(player);
		if (type.toLowerCase().equals("public")) return;
		try(PrintWriter output = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "/plugins/Meatie/privacy.txt",true)))  {
		    output.printf("%s\r\n", player.getName() + " " +  type);
		}  catch (Exception e) {}
	}
	
	public static void clean(CommandSender player) {
	    try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/privacy.txt");
	    	String content = IOUtils.toString(new FileInputStream(file));
	    	content = content.replaceAll("(?m)^" + player.getName() + ".*", "");
	    	content = content.replaceAll("(?m)^[ \t]*\r?\n", "");
	    	IOUtils.write(content, new FileOutputStream(file));
	    } catch (Exception e) {}
	}
	

	
}
