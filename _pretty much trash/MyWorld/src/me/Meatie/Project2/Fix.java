package me.Meatie.Project2;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.inventory.EntityEquipment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

@SuppressWarnings("deprecation")
public class Fix implements Listener {
	
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
	//&11&22&33&44&55&66&77&88&99&aa&bb&cc&dd&ee&ff
	@EventHandler
	public void join(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		event.setJoinMessage(null);
		for (Player p : Bukkit.getOnlinePlayers())
			if (p != player)
				p.sendMessage(ChatColor.YELLOW + player.getName() + " Joined The Game.");
        	TitleAPI.sendTabTitle(player, format("&9&lWelcome To The &2&lSurvival &9&lServer"), null);
        	Commands.send(player, "&9&lWelcome To The &2&lSurvival &9&lServer");
	}
	/*
	@EventHandler
	public void chat(PlayerChatEvent event) {
		//Lain.think(event.getPlayer(), event.getMessage());
		event.setMessage(caps(event.getMessage()));
	}
	/*
	public static String caps(String str) {
		String[] args = str.split(" ");
		String newString = "";
		for (String s : args) {
			int count = 0;
		for (int i = s.length() - 1; i >= 0; i--)
	        if (Character.isUpperCase(s.charAt(i)))
	        	count++;
		if (count > 2)
		    newString = newString + " " + s.toLowerCase();
		    else if (newString == "") newString = s;
		    else newString = newString + " " + s;
		}
		return newString;
	}
	/*
	public static String filter(String str) {
		
		String msg = str.replace(" ", "").toLowerCase();
		
		return str;
	}
	*/
	
	@EventHandler
	public void interact(PlayerInteractEntityEvent event) {
		Player player = event.getPlayer();
		 if (event.getRightClicked().getType() == EntityType.PLAYER) {
		Player target = (Player)event.getRightClicked();
			if (player.isSneaking())
			player.chat("/invsee " + target.getName());
		}
	}
	
	  @EventHandler
	  public void sign(SignChangeEvent sign) {
		sign.setLine(0, format(sign.getLine(0)));
	    sign.setLine(1, format(sign.getLine(1)));
	    sign.setLine(2, format(sign.getLine(2)));
	    sign.setLine(3, format(sign.getLine(3)));
	}
		
		@EventHandler
		public void console(ServerCommandEvent event) {
			if (event.getCommand().equalsIgnoreCase("stop"))
			for (Player p : Bukkit.getOnlinePlayers())
			p.kickPlayer("Server Stoped, Probably Restarting");
		}
		
		static public boolean food = false;
		
		@EventHandler
		public void food(FoodLevelChangeEvent event) {
			if (!food) event.setCancelled(true);
		}
		
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
			    horse.setCarryingChest(randBoolean());
			}
		}
		
		  @EventHandler
		  public void onPlayerDeath(PlayerDeathEvent e) {
		    final Player player = e.getEntity();
		    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.inst, new Runnable() {
		      public void run() {
		        if (player.isDead())
		          try {
		            Object nmsPlayer = player.getClass().getMethod("getHandle", new Class[0]).invoke(player, new Object[0]);
		            Object packet = Class.forName(nmsPlayer.getClass().getPackage().getName() + ".PacketPlayInClientCommand").newInstance();
		            Class<?> enumClass = Class.forName(nmsPlayer.getClass().getPackage().getName() + ".EnumClientCommand");
		            for (Object ob : enumClass.getEnumConstants())
		              if (ob.toString().equals("PERFORM_RESPAWN"))
		                packet = packet.getClass().getConstructor(new Class[] { enumClass }).newInstance(new Object[] { ob });
		            Object con = nmsPlayer.getClass().getField("playerConnection").get(nmsPlayer);
		            con.getClass().getMethod("a", new Class[] { packet.getClass() }).invoke(con, new Object[] { packet });
		          } catch (Exception e) {}
		      }
		    });
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
		
		
	public static String format(String input) {
		return ChatColor.translateAlternateColorCodes('&', 
				   input.replace("(heart)", "❤").replace("(check)", "✔").replace("(music)", "♪").replace("(tempc)", "℃")
					.replace("(plane)", "✈").replace("(x)", "✘").replace("(pencil)", "✎").replace("(mail)", "✉")
					.replace("(right)", "➡").replace("(music2)", "♫").replace("(snowflake)", "❄").replace("(tempf)", "℉"));
	}
}
