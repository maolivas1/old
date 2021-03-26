package me.mark.multiinv;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import me.mark.myplot.Listiner;

import org.apache.commons.lang.StringUtils;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DataFun {

	@SuppressWarnings("deprecation")
	public static void set(Player player, String realm) {
		try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/MyPlot/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "inv.yml"));
			 
			 c.set(realm + "." + player.getName(), null);
			 c.set(realm + "." + player.getName() + ".gamemode", player.getGameMode().getValue());
			 c.set(realm + "." + player.getName() + ".health", player.getHealth());
			 c.set(realm + "." + player.getName() + ".hunger", player.getFoodLevel());
			 c.set(realm + "." + player.getName() + ".exp", player.getExp());
			 
			 Inventory inv = player.getInventory();
			 int i = 0;
			 while (i < 41) {
				 if (inv.getItem(i) != null) {
					 ItemStack item = inv.getItem(i);
					 c.set(realm + "." + player.getName() + "." + i + ".id", item.getTypeId() + ":" + item.getDurability() + " " + item.getAmount());
					 String name = item.getItemMeta().getDisplayName();
					 
					c.set(realm + "." + player.getName() + "." + i + ".name", name);
					 
					 List<String> lore = item.getItemMeta().getLore();
					 ArrayList<String> list = new ArrayList<String>();
					 if (lore != null)
					 for (String l: lore) {
						 list.add(l);
					 }
					 if (!list.isEmpty())
					 c.set(realm + "." + player.getName() + "." + i + ".lore", list);
					 
					 ArrayList<String> enchamtments = new ArrayList<String>();
					 Map<Enchantment, Integer> e = item.getEnchantments();
					 for (Entry<Enchantment, Integer> entry : e.entrySet()) {
							enchamtments.add(entry.getKey().getName() + " " + entry.getValue());
						}
					 if (!enchamtments.isEmpty())
					 c.set(realm + "." + player.getName() + "." + i + ".enchamtments", enchamtments);
					 
				 
				 }
				 i++;
			 }
			 
	         
				c.save(new File(file, "inv.yml"));
			} catch (IOException e) {
				System.out.println(e);
				
			}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static void get(Player player, String realm) {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/MyPlot/", "inv.yml"));
	        
	        	player.getInventory().clear();
	        	player.getInventory().setHelmet(null);
	        	player.getInventory().setChestplate(null);
	        	player.getInventory().setLeggings(null);
	        	player.getInventory().setBoots(null);
	        	
	        	if (c.contains(realm + "." + player.getName() + ".gamemode"))
	        		player.setGameMode(GameMode.getByValue((Integer.parseInt(c.get(realm + "." + player.getName() + ".gamemode").toString()))));
	        	else if (Listiner.getRank(player.getName(), realm).equals("owner"))
	        			player.setGameMode(GameMode.CREATIVE);
	        		 else player.setGameMode(GameMode.ADVENTURE);
	        	if (c.contains(realm + "." + player.getName() + ".health"))
	        		player.setHealth(Double.valueOf(c.get(realm + "." + player.getName() + ".health").toString()));
	        	else player.setHealth(20);
	        	if (c.contains(realm + "." + player.getName() + ".hunger"))
	        		player.setFoodLevel(Integer.parseInt(c.get(realm + "." + player.getName() + ".hunger").toString()));
	        	else player.setFoodLevel(20);
	        	if (c.contains(realm + "." + player.getName() + ".exp"))
	        		player.setExp(Float.valueOf(c.get(realm + "." + player.getName() + ".exp").toString()));
	        	else player.setExp(0);
	        		
	        if (c.contains(realm + "." + player.getName()))
	        for(String i : c.getConfigurationSection(realm + "." + player.getName()).getKeys(false)) {
	        	if (StringUtils.isNumeric(i)) {
	        	String[] idd = c.get(realm + "." + player.getName() + "." + i + ".id").toString().split(" ");
	        	int id = Integer.parseInt(idd[0].split(":")[0]);
	        	short damage = Short.parseShort(idd[0].split(":")[1]);
	        	int count = Integer.parseInt(idd[1]);
	        	
	        	ItemStack stack = new ItemStack(id, count);
	        	stack.setDurability(damage);
	        	
	        	if (c.contains(realm + "." + player.getName() + "." + i + ".enchamtments")) {
	        		ArrayList<String> enchamtments = (ArrayList<String>) c.get(realm + "." + player.getName() + "." + i + ".enchamtments");
	        		for (String en : enchamtments) {
	        			String[] data = en.split(" ");
	        			Enchantment enchant = Enchantment.getByName(String.valueOf(data[0]));
	        			stack.addUnsafeEnchantment(enchant, Integer.parseInt(data[1]));
	        		}
	        	}
	        	
	        	if (c.contains(realm + "." + player.getName() + "." + i + ".lore")) {
	        		ArrayList<String> lores = (ArrayList<String>) c.get(realm + "." + player.getName() + "." + i + ".lore");
	        			ItemMeta m = stack.getItemMeta();
		                m.setLore(lores);
		                stack.setItemMeta(m);
	        	}
	        	
	        	if (c.contains(realm + "." + player.getName() + "." + i + ".name")) {
	        		ItemMeta m = stack.getItemMeta();
	        		String name = (String) c.get(realm + "." + player.getName() + "." + i + ".name");
	                m.setDisplayName(name);
	                stack.setItemMeta(m);
	        	}
	        	

	        	
	        	player.getInventory().setItem(Integer.parseInt(i), stack);
	        	}
	        }
	}
	
}
