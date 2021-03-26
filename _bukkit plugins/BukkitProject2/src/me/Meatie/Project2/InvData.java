package me.Meatie.Project2;

import java.io.File;
import java.util.List;

import me.Meatie.Command.TeleportCommand;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InvData {
	
	 public static void save(Player user) {
		 try {
	        YamlConfiguration c = new YamlConfiguration();
	        
	        Damageable d = (Damageable) user;
	        
	        c.set("stats.fire", user.getFireTicks());
	        c.set("stats.saturation", user.getSaturation());
	        c.set("stats.level", user.getFoodLevel());
	        c.set("stats.exp", user.getExp());
	        c.set("stats.level", user.getLevel());
	        c.set("stats.health", d.getHealth());
	        c.set("gamemode", user.getGameMode().name());
	        c.set("inventory.armor", user.getInventory().getArmorContents());
	        c.set("inventory.content", user.getInventory().getContents());
	        File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + user.getWorld().getName() + "/invs/");
	        c.save(new File(file, user.getName() + ".yml"));
	    } catch (Exception e) {}
	    }
	 
		@SuppressWarnings("unchecked")
	    public static void load(final Player user) {
			try {
			if (TeleportCommand.online(user.getName()) == null) return;
			
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
				@SuppressWarnings("deprecation")
				@Override
	            public void run() {
					File filee = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + user.getWorld().getName() + "/invs/" + user.getName() + ".yml");
					if(!filee.exists()) {
						//New Stuffs, no file was found
				        user.setGameMode(GameMode.SURVIVAL);
				        user.setHealth(20);
				        user.setExp((float) 0);
				        user.setFoodLevel(20);
				        user.setSaturation(20);
				        user.setFireTicks(0);
				        user.setLevel(0);
						user.getInventory().setArmorContents(null);
						user.getInventory().setContents(null);
						return;
					}
					
	        final File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/" + user.getWorld().getName() + "/invs/");
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, user.getName()+".yml"));
	        ItemStack[] content = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
	        user.getInventory().setArmorContents(content);
	        content = ((List<ItemStack>) c.get("inventory.content")).toArray(new ItemStack[0]);
	        
	        GameMode mode = gamemode(c.get("gamemode").toString());
	        double health = Double.parseDouble(c.get("stats.health").toString());
	        double exp = Double.parseDouble(c.get("stats.exp").toString().replace("0.", "."));
	        double foodlevel = Double.parseDouble(c.get("stats.level").toString());
	        double saturation = Double.parseDouble(c.get("stats.saturation").toString());
	        double fire = Double.parseDouble(c.get("stats.fire").toString());
	        int level = Integer.parseInt(c.get("stats.level").toString());
	        
	        user.getInventory().setContents(content);
	        user.setGameMode(mode);
	        user.setHealth(health);
	        user.setExp((float) exp);
	        user.setFoodLevel((int) foodlevel);
	        user.setSaturation((int) saturation);
	        user.setFireTicks((int) fire);
	        user.setLevel(level);
	        
	            }
	        });
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
