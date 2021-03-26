package me.Meatie.OnlineTool;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		try {
			   FileInputStream in = new FileInputStream(new File(System.getProperty("user.dir")) + "/server.properties");
			   Properties properties = new Properties();
			   properties.load(in);
			   String mode = properties.getProperty("online-mode").toString();
			   
			   if (mode.equals("true"))
				   online();
			   else
				 offline();
					} catch (Exception e) {}
}
	
	public void offline() {
		System.out.println("Server is Offline mode, Converting to Online.");
		
           ArrayList<String> list = new ArrayList<String>();
		
		try {
			//TODO Set online-mode to true automatically
		        YamlConfiguration c = new YamlConfiguration();
				for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
		        c.set(player.getName(), player.getUniqueId().toString());
				System.out.println("Offline " + player.getName() + " " + player.getUniqueId());
				list.add(player.getName());
				}
		        c.save(new File(new File(System.getProperty("user.dir")), "UniqueIds.yml"));
		        
		        
		        //TODO Server Restart Automatically
		        System.out.println("Done, Please Change online-mode to true in you'r server.proprties then Restart server To Contenue...");
	    } catch (Exception e) {}
	}
	
	
	
	public void online() {
		try {
		System.out.println("Server is Online mode, Finishing Fixes.");
		ArrayList<String> list = new ArrayList<String>();
		
		for (OfflinePlayer player : Bukkit.getOfflinePlayers()) {
			System.out.println("Online " + player.getName() + " " + player.getUniqueId());
			list.add(player.getName());
		}
		Map<String, UUID> response = new UUIDGetter(Arrays.asList("Meatie", "SpoonDefender")).call();
		for (String name : response.keySet()) {
			System.out.println("UUIDGetter " + name + " " + response.get(name));
		}
		
    } catch (Exception e) {}
	}
	

	
	
	
}