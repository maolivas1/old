package me.Meatie.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import net.minecraft.util.org.apache.commons.io.IOUtils;

public class BanData {
	
	//TODO add to /world, /tp and login events
	public static boolean read(String world, String user) {
		
		try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/bans.txt");
			    FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    br.close();
			    fr.close();
			    if (br.toString().contains(user))
						return true;
    } catch (Exception e) {}
		return false;
	}
	
	public static void save(String world, String user) {
	    try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/bans.txt");
	    	String content = IOUtils.toString(new FileInputStream(file));
	    	content = content.replaceAll("(?m)^" + user + ".*", "");
	    	content = content.replaceAll("(?m)^[ \t]*\r?\n", "");
	    	IOUtils.write(content, new FileOutputStream(file));
	    } catch (Exception e) {}
		
		RankData.exists(world);
		try(PrintWriter output = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/bans.txt",true)))  {
		    output.printf("%s\r\n", user);
		    output.close();
		}  catch (Exception e) {}
	}
	
}
