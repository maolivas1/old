package me.Meatie.Project4.Unused;

import java.io.File;
import java.util.List;

import me.Meatie.Project2.Main;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InvData {
	
	 public static void save(Player user) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Project4/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "temp.yml"));
	        Damageable d = (Damageable) user;
	        String name = user.getName();
	        c.set(name + ".fire", user.getFireTicks());
	        c.set(name + ".saturation", user.getSaturation());
	        c.set(name + ".hunger", user.getFoodLevel());
	        c.set(name + ".exp", user.getExp());
	        c.set(name + ".level", user.getLevel());
	        c.set(name + ".health", d.getHealth());
	        c.set(name + ".gamemode", user.getGameMode().name());
	        c.set(name + ".armor", user.getInventory().getArmorContents());
	        c.set(name + ".inv", user.getInventory().getContents());
	        c.save(new File(file, "temp.yml"));
	    } catch (Exception e) {}
	    }
	 
		@SuppressWarnings("unchecked")
	    public static void load(final Player user) {
			try {
				 Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
			        	@Override
			            public void run() {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Project4/", "temp.yml"));
	        String name = user.getName();
	        ItemStack[] content = ((List<ItemStack>) c.get(name + ".armor")).toArray(new ItemStack[0]);
	        user.getInventory().setArmorContents(content);
	        content = ((List<ItemStack>) c.get(name + ".inv")).toArray(new ItemStack[0]);
	        
	        GameMode mode = gamemode(c.get(name + ".gamemode").toString());
	        double health = Double.parseDouble(c.get(name + ".health").toString());
	        double exp = Double.parseDouble(c.get(name + ".exp").toString().replace("0.", "."));
	        double foodlevel = Double.parseDouble(c.get(name + ".hunger").toString());
	        double saturation = Double.parseDouble(c.get(name +".saturation").toString());
	        double fire = Double.parseDouble(c.get(name + ".fire").toString());
	        int level = Integer.parseInt(c.get(name + ".level").toString());
	        
	        user.getInventory().setContents(content);
	        user.setGameMode(mode);
	        user.setHealth(health);
	        user.setExp((float) exp);
	        user.setFoodLevel((int) foodlevel);
	        user.setSaturation((int) saturation);
	        user.setFireTicks((int) fire);
	        user.setLevel(level);
			        	}}, 20L);
	    } catch (Exception e) {}
	    }
		
		public static GameMode gamemode(String mode) {
			if (mode.equals("CREATIVE"))
				return GameMode.CREATIVE;
			if (mode.equals("SURVIVAL"))
				return GameMode.SURVIVAL;
			if (mode.equals("ADVENTURE"))
				return GameMode.ADVENTURE;
			return null;
		}
		
	
}
