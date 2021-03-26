package me.Meatie.Project4.Unused;

import java.io.File;

import me.Meatie.Project2.Main;

import org.bukkit.configuration.file.YamlConfiguration;

public class EcoData {
	
	public static void setPrice(String item, double price) {
		 try {
			 File file = new File(Main.dir);
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "worth.yml"));
	        c.set(item, price);
	        c.save(new File(file, "worth.yml"));
	    } catch (Exception e) {}
	    }
	    
	    public static double getPrice(String item) {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "worth.yml"));
	        if (c.contains(item))
	        return Double.parseDouble((c.get(item).toString()));
			return 0;
	    }
	    
		public static void addMoney(String user, double money) {
			 try {
				 File file = new File(Main.dir);
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "money.yml"));
				 
				 if (!c.contains(user)) {
					 c.set(user, money);
				 } else c.set(user, Double.parseDouble(c.get(user).toString()) + money);
				 
		        c.save(new File(file, "money.yml"));
		    } catch (Exception e) {}
		    }
		
		public static void takeMoney(String user, double money) {
			 try {
				 File file = new File(Main.dir);
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "money.yml"));
				 
				 if (!c.contains(user)) {
					 c.set(user, -money);
				 } else c.set(user, Double.parseDouble(c.get(user).toString()) - money);
				 
		        c.save(new File(file, "money.yml"));
		    } catch (Exception e) {}
		    }
		
	    public static double getMoney(String name) {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(Main.dir, "money.yml"));
	        
	        if (c.contains(name))
	        return Double.parseDouble((c.get(name).toString()));
			return 0;
	    }
	    
		public static void payMoney(String user, String target, double money) {
			 try {
				 File file = new File(Main.dir);
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "money.yml"));
				 
				 if (c.contains(user)) 
				 c.set(user, Double.parseDouble(c.get(user).toString()) - money);
				 else c.set(user, -money);
				 
				 if (c.contains(target))
				 c.set(target, Double.parseDouble(c.get(target).toString()) + money);
				 else c.set(target, money);
				 
		        c.save(new File(file, "money.yml"));
		    } catch (Exception e) {}
		    }
		
}
