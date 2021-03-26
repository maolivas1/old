package me.Mark.comunity;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Comunity extends JavaPlugin {
	static HashMap<Player, Integer> points = new HashMap<Player, Integer>();
	
	public void onEnable() {
		getCommand("test").setExecutor(new TestCommad());
		start();
	}
	
	public void start() {
      getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
            	tick();
            }
        }, 0L, 1200L);
	}
	
	public static void tick() {
		for (Player p:Bukkit.getOnlinePlayers()) {
			for (Player pl:Bukkit.getOnlinePlayers()) {
				if (pl != p)
				if (p.getWorld() == pl.getWorld()) {
				double distance = p.getLocation().distance(pl.getLocation());
				if (distance <= 50) {
					if (!points.containsKey(p)) points.put(p, 0);
					points.put(p, points.get(p) + 1);
					p.sendMessage(ChatColor.GREEN + "Debug: yumm, a point, your new total is: " + ChatColor.YELLOW + points.get(p) + " " + distance);
					
					//Make higher, like 50, or 100, just 5 for testing
					if (points.get(p) == 5) {
					points.put(p, 0);
					powerup(p);
					}
				}
				}
			}
		}
	}
	
	public static void powerup(Player p) {
		
		p.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 100, 1));
		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 1));
		ExperienceOrb orb = p.getWorld().spawn(p.getLocation(), ExperienceOrb.class);
		orb.setExperience(2);
		
		
		for(int i = 0; i <= 40; i++) {
            try {
            	ItemStack item = p.getInventory().getItem(i);
            	String name = item.getType().toString();
            	if (name.contains("HOE") || name.contains("PICKAXE") || name.contains("SPADE") || name.contains("AXE") || name.contains("SWORD") || name.contains("BOOTS")
            			 || name.contains("CHESTPLATE") || name.contains("HELMET") || name.contains("LEGGINGS") || name.contains("FISHING_ROD") || name.contains("SHEARS")
            			 || name.contains("BOW")) {
            		int d = item.getDurability() - 5;
            		if (d < 0) d = 0;
                item.setDurability((short) d);
            	}
            } catch(Exception e) {}
        }
		
		
		int rand = ThreadLocalRandom.current().nextInt(0, 3 + 1);
		
		if (rand == 0) p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1200, 1));
		else if (rand == 1) p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1200, 1));
		else if (rand == 2) p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1200, 1));
		else if (rand == 3) p.addPotionEffect(new PotionEffect(PotionEffectType.LUCK, 1200, 1));
		
		
	}
	
}
