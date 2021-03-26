package me.Meatie.Project4.Unused;

import java.io.File;
import java.util.List;

import me.Meatie.Project2.Fix;
import me.Meatie.Project2.Main;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class MailData {
	
	 public static void save(Player user, String target, String msg) {
		 try {
			 File file = new File(Main.dir);
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "mail.yml"));
			 
			 List<String> mail = c.getStringList(user.getName());
			 mail.add(user.getName() + ": " + msg);
			 c.set(target, mail);
			 
	        c.save(new File(file, "mail.yml"));
	    } catch (Exception e) {}
	    }
	 
	    public static void load(Player user) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "mail.yml"));
	        
	        if (c.get(user.getName()) == null)
	        	return;
	        else user.sendMessage(Fix.format("&6Mail:"));
	        
	        List<String> mail = c.getStringList(user.getName());
            for (String s : mail)
              user.sendMessage(Fix.format(s));
			
            clear(user);
	    } catch (Exception e) {}
	    }
	    
		 public static void clear(Player user) {
			 try {
				 File file = new File(Main.dir);
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "mail.yml"));
				 
				 c.set(user.getName(), null);
				 
		        c.save(new File(file, "mail.yml"));
		    } catch (Exception e) {}
		    }
}
