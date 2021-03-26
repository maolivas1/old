package me.Mark.LightningBow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	 
	public static Main inst;
	
	public void onEnable() {
		inst = this;
		Bukkit.getServer().getPluginManager().registerEvents(new LightningBow(), this);
		
		//Config Setup:
		if (Config.get("min-distance") == null) Config.set("min-distance", "5");
		if (Config.get("max-distance") == null) Config.set("max-distance", "20");
		if (Config.get("bow-name") == null) Config.set("bow-name", "&e&lLightning Bow");
		if (Config.get("justPlayer") == null) Config.set("justPlayer", "false");
		if (Config.get("recipe.row1") == null) Config.set("recipe.row1", "ACA");
		if (Config.get("recipe.row2") == null) Config.set("recipe.row2", " B ");
		if (Config.get("recipe.row3") == null) Config.set("recipe.row3", " D ");
		if (Config.get("recipe.item.A") == null) Config.set("recipe.item.A", "Arrow");
		if (Config.get("recipe.item.B") == null) Config.set("recipe.item.B", "Bow");
		if (Config.get("recipe.item.C") == null) Config.set("recipe.item.C", "TNT");
		if (Config.get("recipe.item.D") == null) Config.set("recipe.item.D", "Diamond");
		if (Config.get("recipe.item.E") == null) Config.set("recipe.item.E", "");
		if (Config.get("recipe.item.F") == null) Config.set("recipe.item.F", "");
		if (Config.get("recipe.item.G") == null) Config.set("recipe.item.G", "");
		if (Config.get("recipe.item.H") == null) Config.set("recipe.item.H", "");
		if (Config.get("recipe.item.I") == null) Config.set("recipe.item.I", "");
		
		LightningBow.justPlayer = Config.get("justPlayer");
		LightningBow.min_distance = Integer.parseInt(Config.get("min-distance"));
		LightningBow.max_distance = Integer.parseInt(Config.get("max-distance"));
		LightningBow.name = ChatColor.translateAlternateColorCodes('&', Config.get("bow-name"));
		
		//Crafting Recipe
		ItemStack bow = new ItemStack(Material.BOW, 1);
		ItemMeta meta = bow.getItemMeta();
		meta.setDisplayName(LightningBow.name);
		bow.setItemMeta(meta);
		 
		ShapedRecipe myBow = new ShapedRecipe(bow);
		
		myBow.shape(Config.get("recipe.row1"),Config.get("recipe.row2"),Config.get("recipe.row3"));
		 
		if (!Config.get("recipe.item.A").equals("")) myBow.setIngredient('A', Material.valueOf(Config.get("recipe.item.A").toUpperCase()));
		if (!Config.get("recipe.item.B").equals("")) myBow.setIngredient('B', Material.valueOf(Config.get("recipe.item.B").toUpperCase()));
		if (!Config.get("recipe.item.C").equals("")) myBow.setIngredient('C', Material.valueOf(Config.get("recipe.item.C").toUpperCase()));
		if (!Config.get("recipe.item.D").equals("")) myBow.setIngredient('D', Material.valueOf(Config.get("recipe.item.D").toUpperCase()));
		if (!Config.get("recipe.item.E").equals("")) myBow.setIngredient('E', Material.valueOf(Config.get("recipe.item.E").toUpperCase()));
		if (!Config.get("recipe.item.F").equals("")) myBow.setIngredient('F', Material.valueOf(Config.get("recipe.item.F").toUpperCase()));
		if (!Config.get("recipe.item.G").equals(""))myBow.setIngredient('G', Material.valueOf(Config.get("recipe.item.G").toUpperCase()));
		if (!Config.get("recipe.item.H").equals(""))myBow.setIngredient('H', Material.valueOf(Config.get("recipe.item.H").toUpperCase()));
		if (!Config.get("recipe.item.I").equals(""))myBow.setIngredient('I', Material.valueOf(Config.get("recipe.item.I").toUpperCase()));
		 
		Bukkit.getServer().addRecipe(myBow);
		
	}
}