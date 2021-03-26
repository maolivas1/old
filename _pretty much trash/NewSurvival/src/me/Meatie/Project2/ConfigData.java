package me.Meatie.Project2;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class ConfigData {

	
	 public static void save(Player user, String target, String msg) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/save.yml");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "save.yml"));
			 
			 List<String> mail = c.getStringList(user.getName());
			 mail.add(user.getName() + ": " + msg);
			 c.set(target, mail);
			 
	        c.save(new File(file, "save.yml"));
	    } catch (Exception e) {}
	    }
	 
	    public static boolean get(Player user, String target) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "save.yml"));
	        
	        if (c.get(user.getName()) == null) return false;
	        else user.sendMessage(Fix.format("&6Mail:"));
	        
	        List<String> mail = c.getStringList(user.getName());
            for (String s : mail)
              user.sendMessage(Fix.format(s));
			
            clear(user);
	    } catch (Exception e) {}
			return false;
	    }
	    
		 public static void clear(Player user) {
			 try {
				 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/save.yml");
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "save.yml"));
				 
				 c.set(user.getName(), null);
				 
		        c.save(new File(file, "save.yml"));
		    } catch (Exception e) {}
		    }
	
}
