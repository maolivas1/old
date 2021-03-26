package me.Meatie.Project2;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.server.ServerCommandEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

public class Fix implements Listener {
	
    @EventHandler
    public void onWeatherChange(WeatherChangeEvent event) {
        event.setCancelled(true);
    }
    /*
    public static String quick;
    public static String top;
    public static String bottom;
    public static String login;
    public static String leave;
    */
    
	@EventHandler
	public void join(PlayerJoinEvent event) {
		final Player player = event.getPlayer();
		event.setJoinMessage(null);
		for (Player p : Bukkit.getOnlinePlayers())
			if (p != player)
				p.sendMessage(format("&e$player Joined The Game.".replace("$player", player.getName())));
        	//TitleAPI.sendTabTitle(player, top.replace("$player", player.getName()), bottom.replace("$player", player.getName()));
        	//send(player, format(quick.replace("$player", player.getName())));
	}
	
		@EventHandler
		public void console(ServerCommandEvent event) {
			if (event.getCommand().equalsIgnoreCase("stop"))
			for (Player p : Bukkit.getOnlinePlayers())
			p.kickPlayer("Server Stoped, Probably Restarting");
		}
	   
	@EventHandler
	public void leave(PlayerQuitEvent event) {
		event.setQuitMessage(null);
		Bukkit.broadcastMessage(format("&e$player Left The Game.").replace("$player", event.getPlayer().getName()));
	}

	  @EventHandler
	  public void sign(SignChangeEvent sign) {
		sign.setLine(0, format(sign.getLine(0)));
	    sign.setLine(1, format(sign.getLine(1)));
	    sign.setLine(2, format(sign.getLine(2)));
	    sign.setLine(3, format(sign.getLine(3)));
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
	  
		public static String format(String input) {
			return ChatColor.translateAlternateColorCodes('&',input);
		}
		/*
		  public static void send(CommandSender p, String msg) {
			    String s = ChatColor.translateAlternateColorCodes('&', msg);
			    IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s + "\"}");
			    PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
			    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
			  }
		*/
		/*
		@EventHandler
		public void interactevent(PlayerInteractEntityEvent event) {
			Player player = event.getPlayer();
			 if (event.getRightClicked().getType() == EntityType.PLAYER) {
			Player target = (Player)event.getRightClicked();
				if (player.isSneaking())
				player.chat("/invsee " + target.getName());
			}
		}
		*/
	  
	  /*
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
		*/
		
		
		/*
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
		*/
}
