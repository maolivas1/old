package me.Meatie.Listiner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.bukkit.event.Listener;

public class LoadWorld implements Listener {

	public static HashMap<String, String> map = new HashMap<String, String>();
	
	public static void load(String world) {
		
		try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/rank.txt");
			    FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    String line;
			    while((line = br.readLine()) != null) {
						String[] args = line.split(" ");
						map.put(world +  " " + args[0], args[1]);
			    }
			    br.close();
			    fr.close();
    } catch (Exception e) {}
	}
	
	
	public static void reload(String world) {
		
		for (String name:  LoadWorld.map.keySet())
			if (name.contains(world + " "))
				Fix.remove(name);
		
		try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + world + "/rank.txt");
			    FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    String line;
			    while((line = br.readLine()) != null) {
						String[] args = line.split(" ");
						map.put(world +  " " + args[0], args[1]);
			    }
			    br.close();
			    fr.close();
    } catch (Exception e) {}
	}
	
}
