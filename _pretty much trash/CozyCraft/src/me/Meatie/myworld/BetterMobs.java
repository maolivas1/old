package me.Meatie.myworld;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Horse.Variant;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class BetterMobs implements Listener {
	
	
	
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void death(PlayerDeathEvent event) {
		event.setDeathMessage(null);
		Player player = (Player)event.getEntity();
		ItemStack skull = new ItemStack(397, 1, (short) 3);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(player.getName());
		skull.setItemMeta(meta);
		player.getWorld().dropItem(player.getLocation(), skull);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void spawn(EntitySpawnEvent event) {
		Entity entity = event.getEntity();
		EntityType type = entity.getType();
		if (entity instanceof LivingEntity) {
		if (type == EntityType.ZOMBIE || type == EntityType.SKELETON || type == EntityType.PIG_ZOMBIE) {
		ItemStack skull = new ItemStack(397, 1, (short) 3);
		SkullMeta meta = (SkullMeta) skull.getItemMeta();
		meta.setOwner(randPlayer());
		skull.setItemMeta(meta);
	    EntityEquipment ee = ((LivingEntity)entity).getEquipment();
	    ee.setHelmet(new ItemStack(skull));
			}
		}
		if (type == EntityType.SHEEP) {
			Sheep sheep = (Sheep)entity;
			sheep.setColor(randColor());
		} else if (type == EntityType.PIG) {
			Pig pig = (Pig)entity;
			pig.setSaddle(randBoolean());
		} else if (type == EntityType.HORSE) {
			Horse horse = (Horse)entity;
			horse.setTamed(true);
			horse.setAdult();
			if (randBoolean() == true)
			horse.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			if (horse.getVariant() == Variant.DONKEY || horse.getVariant() == Variant.MULE)
		    horse.setCarryingChest(randBoolean());
		}
	}
	
	public String randPlayer() {
		ArrayList<String> list = new ArrayList<String>();
		for (OfflinePlayer p : Bukkit.getOfflinePlayers())
			list.add(p.getName());
		return list.get(new Random().nextInt(list.size()));
	}
	
	public DyeColor randColor() {
		int num = new Random().nextInt(14);
		if (num == 0) return DyeColor.BLACK;
		if (num == 1) return DyeColor.BLUE;
		if (num == 2) return DyeColor.BROWN;
		if (num == 3) return DyeColor.CYAN;
		if (num == 4) return DyeColor.GRAY;
		if (num == 5) return DyeColor.GREEN;
		if (num == 6) return DyeColor.LIGHT_BLUE;
		if (num == 7) return DyeColor.LIME;
		if (num == 8) return DyeColor.MAGENTA;
		if (num == 9) return DyeColor.ORANGE;
		if (num == 10) return DyeColor.PINK;
		if (num == 11) return DyeColor.PURPLE;
		if (num == 12) return DyeColor.RED;
		if (num == 13) return DyeColor.SILVER;
		if (num == 14) return DyeColor.WHITE;
		if (num == 15) return DyeColor.YELLOW;
		return DyeColor.WHITE;
	}
	
	public boolean randBoolean() {
		int num = new Random().nextInt(2);
		if (num == 0) return true;
		return false;
	}
	
}
