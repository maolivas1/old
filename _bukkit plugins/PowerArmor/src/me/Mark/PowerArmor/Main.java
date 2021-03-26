package me.Mark.PowerArmor;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerItemBreakEvent;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.*;

public class Main extends JavaPlugin implements Listener {
  
  public void onEnable() {
    getServer().getPluginManager().registerEvents(this, this);
    getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
      public void run() {
        for (Player p : Main.this.getServer().getOnlinePlayers()) {
          itemPotion(p, p.getInventory().getHelmet());
          itemPotion(p, p.getInventory().getChestplate());
          itemPotion(p, p.getInventory().getLeggings());
          itemPotion(p, p.getInventory().getBoots());
        }
      }
    }, 0L, 20);
  }
  
  public void itemPotion(Player p, ItemStack item) {
	    if (item == null) return;
	    if (!item.hasItemMeta()) return;
	    if (!item.getItemMeta().hasLore()) return;
	      String itemLore = ChatColor.stripColor((String)item.getItemMeta().getLore().get(0));
	      if (itemLore.equals("Infused with Strength")) {
	    	  p.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
	          p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999, 1));
	      }
	      if (itemLore.equals("Infused with Invisibility")) {
	    	  p.removePotionEffect(PotionEffectType.INVISIBILITY);
	    	  p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 1));
	      }
	  }
  
	@EventHandler
	public void playerHitPlayerEvent(EntityDamageByEntityEvent event) {
	Entity damager = event.getDamager(); 
	if (damager instanceof Player) {
	Player player = (Player) damager;
	if (player.getItemInHand() == null) return;
	if (!player.getItemInHand().hasItemMeta()) return;
	if (!player.getItemInHand().getItemMeta().hasLore()) return;
	if (ChatColor.stripColor(player.getItemInHand().getItemMeta().getLore().get(0)).equals("I come from the Iron Hills")) {
		LivingEntity target = (LivingEntity) event.getEntity();
		target.getWorld().playEffect(target.getLocation(),Effect.ZOMBIE_DESTROY_DOOR,1);
		player.playSound(target.getLocation(), Sound.ANVIL_LAND, 1.0F, 0.001F);
		if (!event.isCancelled())
		event.setDamage(event.getDamage() * 3);
	}
	if (ChatColor.stripColor(player.getItemInHand().getItemMeta().getLore().get(0)).equals("I come from the Iron Hills")) {
		LivingEntity target = (LivingEntity) event.getEntity();
		target.getWorld().playEffect(target.getLocation(),Effect.ZOMBIE_DESTROY_DOOR,1);
		player.playSound(target.getLocation(), Sound.ANVIL_LAND, 1.0F, 0.001F);
		if (!event.isCancelled())
		event.setDamage(event.getDamage() * 3);
	}
	if (ChatColor.stripColor(player.getItemInHand().getItemMeta().getLore().get(0)).equals("Lifesteal")) {
		if (!event.isCancelled())
		player.setHealth(player.getHealth() + 1);
	}
	}
	}
	
	@EventHandler
	public void click(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		int slot = event.getSlot();
		
		if (event.getCurrentItem() == null) return;
		if (!event.getCurrentItem().hasItemMeta()) return;
		if (!event.getCurrentItem().getItemMeta().hasLore()) return;
		
		String lore = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getLore().get(0));
		if (player.getGameMode() != GameMode.CREATIVE) {
		if (slot == 39 || slot == 38 || slot == 37 || slot == 36) {
			
			if (lore.equals("Infused with Strength")) {
				player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			} else if (lore.equals("Infused with Invisibility")) {
				player.removePotionEffect(PotionEffectType.INVISIBILITY);
			} else if (lore.equals("Glowing")) {
				player.removePotionEffect(PotionEffectType.NIGHT_VISION);
			} else if (lore.equals("Infused with Speed")) {
				player.removePotionEffect(PotionEffectType.SPEED);
			}
			
		}
		} else {
			if (slot == 5 || slot == 6 || slot == 7 || slot == 8) {
				
				if (lore.equals("Infused with Strength")) {
					player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				} else if (lore.equals("Infused with Invisibility")) {
					player.removePotionEffect(PotionEffectType.INVISIBILITY);
				} else if (lore.equals("Glowing")) {
					player.removePotionEffect(PotionEffectType.NIGHT_VISION);
				} else if (lore.equals("Infused with Speed")) {
					player.removePotionEffect(PotionEffectType.SPEED);
				}
				
			}
		}
	}
	
	@EventHandler
	public void damage(PlayerItemBreakEvent event) {
		Player player = event.getPlayer();
		String lore = ChatColor.stripColor(event.getBrokenItem().getItemMeta().getLore().get(0));
		
		if (lore.equals("Infused with Strength")) {
			player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
		} else if (lore.equals("Infused with Invisibility")) {
			player.removePotionEffect(PotionEffectType.INVISIBILITY);
		} else if (lore.equals("Glowing")) {
			player.removePotionEffect(PotionEffectType.NIGHT_VISION);
		} else if (lore.equals("Infused with Speed")) {
			player.removePotionEffect(PotionEffectType.SPEED);
		}
	}
	
	 public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
	        Player p = (Player)sender;
	         if (label.equalsIgnoreCase("legendary")) {
	             if(args.length == 0) {
	         p.sendMessage(ChatColor.GREEN + "" + ChatColor.BOLD + "Legendary");
	         p.sendMessage(ChatColor.GREEN + "Create " + ChatColor.DARK_GRAY + "> " + ChatColor.RED + "AFKMachine");
	         p.sendMessage(ChatColor.DARK_GREEN + "---------------------");
	         p.sendMessage(ChatColor.GREEN + "Commands " + ChatColor.DARK_GRAY + ">");
	         p.sendMessage(ChatColor.GREEN + "/legendary give");
	         p.sendMessage(ChatColor.DARK_GREEN + "---------------------");
	             }
	             if(args.length == 1) {
	                 if (p.hasPermission("Pyro.admin")) {
	                     if (args[0].equalsIgnoreCase("give")) {
	                    p.sendMessage(ChatColor.DARK_RED + "Incorrect Usage: " + ChatColor.RED + "/pyroaxe create <player> <pyroaxe,apollos,aegis,ethereals,hermes>");
	                     }
	                     if ((args.length == 2) && 
	                       (p.hasPermission("Pyro.admin")))
	                     {
	                       if (args[0].equalsIgnoreCase("give"))
	                       {
	                      // Player target = Bukkit.getPlayer(args[1]);

	       				for (Player target : Bukkit.getOnlinePlayers())
	    					if (target.getName().equalsIgnoreCase(args[1])) {
	    						
	 		                         if (args[2].equalsIgnoreCase("pyroaxe")) {
	 		                     ItemStack axe = (new ItemStack(Material.DIAMOND_AXE, 1));
	 		                     axe.addEnchantment(Enchantment.DAMAGE_ALL, 5);
	 		                     axe.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 2);
	 		                     ItemMeta meta = axe.getItemMeta();
	 		                     ArrayList<String> lore = new ArrayList<>();
	 		                     String randomNumber = getMode(4, Mode.NUMERIC);
	 		                     lore.add(ChatColor.GRAY + "Infinity enchantment.level." + randomNumber);
	 		                     meta.setDisplayName(ChatColor.DARK_RED + "Pyro Axe");
	 		                     lore.add(ChatColor.DARK_RED + "I come from the Iron Hills");
	 		                     String randomString = getString(8, Mode.APLHANUMERICSYMBOLIC);
	 		                     lore.add(ChatColor.GREEN + randomString);
	 		                     meta.setLore(lore);
	 		                     axe.setItemMeta(meta);
	 		                     target.getInventory().addItem(axe);
	 		                    }
	 		                     if (args[2].equalsIgnoreCase("Apollos")) {
	 		                     ItemStack apollos = (new ItemStack(Material.DIAMOND_HELMET, 1));
	 		                     apollos.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
	 		                     apollos.addEnchantment(Enchantment.PROTECTION_FIRE, 4);
	 		                     apollos.addEnchantment(Enchantment.THORNS, 3);
	 		                     apollos.addEnchantment(Enchantment.DURABILITY, 3);
	 		                     ItemMeta meta = apollos.getItemMeta();
	 		                     ArrayList<String> lore = new ArrayList<>();
	 		                     String randomNumber = getMode(4, Mode.NUMERIC);
	 		                     lore.add(ChatColor.GRAY + "Infinity enchantment.level." + randomNumber);
	 		                     meta.setDisplayName(ChatColor.DARK_GRAY + " " + ChatColor.DARK_RED + "Apollos" + ChatColor.DARK_GRAY + " ");
	 		                     lore.add(ChatColor.DARK_RED + " Glowing");
	 		                     lore.add(ChatColor.DARK_RED + " Implants");
	 		                     String randomString = getString(8, Mode.APLHANUMERICSYMBOLIC);
	 		                     lore.add(ChatColor.GREEN + randomString);
	 		                     meta.setLore(lore);
	 		                     apollos.setItemMeta(meta);
	 		                     target.getInventory().addItem(apollos);
	 		                     }
	 		                     if (args[2].equalsIgnoreCase("Aegis")) {
	 		                     ItemStack aegis = (new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
	 		                     ItemMeta meta = aegis.getItemMeta();
	 		                     aegis.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	 		                     aegis.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
	 		                     aegis.addUnsafeEnchantment(Enchantment.THORNS, 2);
	 		                     aegis.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	 		                     ArrayList<String> lore = new ArrayList<>();
	 		                     meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + " " + ChatColor.DARK_GRAY + ""+ ChatColor.BOLD + "Aegis" + ChatColor.DARK_RED + "" + ChatColor.BOLD + " ");
	 		                     lore.add(ChatColor.DARK_GREEN + "Infused with Strength");
	 		                     meta.setLore(lore);
	 		                     aegis.setItemMeta(meta);
	 		                     target.getInventory().addItem(aegis);
	 		                    }
	 		                     if (args[2].equalsIgnoreCase("Ethereals")) {
	 		                     ItemStack ethereals = (new ItemStack(Material.DIAMOND_LEGGINGS, 1));
	 		                     ItemMeta meta = ethereals.getItemMeta();
	 		                     ethereals.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	 		                     ethereals.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
	 		                     ethereals.addUnsafeEnchantment(Enchantment.THORNS, 2);
	 		                     ethereals.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	 		                     ArrayList<String> lore = new ArrayList<>();
	 		                     meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Ethereals");
	 		                     lore.add(ChatColor.DARK_GREEN + "Infused with Invisibility");
	 		                     meta.setLore(lore);
	 		                     ethereals.setItemMeta(meta);
	 		                     target.getInventory().addItem(ethereals);
	 		                    }
	 		                     if (args[2].equalsIgnoreCase("Hermes")) {
	 		                     ItemStack ethereals = (new ItemStack(Material.DIAMOND_BOOTS, 1));
	 		                     ItemMeta meta = ethereals.getItemMeta();
	 		                     ethereals.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
	 		                     ethereals.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 3);
	 		                     ethereals.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 3);
	 		                     ethereals.addUnsafeEnchantment(Enchantment.DURABILITY, 3);
	 		                     ArrayList<String> lore = new ArrayList<>();
	 		                     meta.setDisplayName(ChatColor.GOLD + "Hermes Boots");
	 		                     lore.add(ChatColor.DARK_RED + "Infused with Speed");
	 		                     meta.setLore(lore);
	 		                     ethereals.setItemMeta(meta);
	 		                     target.getInventory().addItem(ethereals);
	 		                     }
	    						
	    						return true;
	    					}
	    			//No player found
	                       
	                       

	             }
	                
	                     }

	         }
	             return true;
	         }
	       }
	  return false;
	         }
	
	
}
