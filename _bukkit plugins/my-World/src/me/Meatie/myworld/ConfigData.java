package me.Meatie.myworld;

import java.io.File;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigData {

	//TODO Main Config
	 public static void save(String thing, String value) {
		 try {
			 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
			 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "data.yml"));
			 c.set(thing, value);
	         c.save(new File(file, "data.yml"));
	         Bukkit.broadcastMessage(Fix.format("&cConfig Value &e" + thing + " &cSet To &e" + value));
	    } catch (Exception e) {}
	    }
	 
	    public static String get(String thing) {
			try {
	        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "data.yml"));
	        if (c.contains(thing)) {
	        return c.get(thing).toString();
	        } else {}
	    } catch (Exception e) {}
			return null;
	    }
	    //TODO Reputation
		 public static void saveRep(String thing, int value) {
			 try {
				 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
				 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "rep.yml"));
				 c.set(thing, value);
		         c.save(new File(file, "rep.yml"));
		    } catch (Exception e) {}
		    }
		 
		    public static int getRep(String thing) {
				try {
		        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "rep.yml"));
		        if (c.contains(thing)) {
		        return Integer.valueOf(c.get(thing).toString());
		        }
		    } catch (Exception e) {}
				return 0;
		    }
		    //TODO Rank
			 public static void saveRank(String thing, int value) {
				 try {
					 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
					 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "ranks.yml"));
					 c.set(thing, value);
			         c.save(new File(file, "ranks.yml"));
			    } catch (Exception e) {}
			    }
			 
			    public static int getRank(String thing) {
					try {
			        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "ranks.yml"));
			        if (c.contains(thing)) {
			        return Integer.valueOf(c.get(thing).toString());
			        }
			    } catch (Exception e) {}
					return 0;
			    }
			    //TODO Location
				 public static void saveLoc(String thing, Location loc) {
					 try {
						 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
						 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "loc.yml"));
						 c.set(thing + ".world", loc.getWorld().getName());
						 c.set(thing + ".x", loc.getX());
						 c.set(thing + ".y", loc.getY());
						 c.set(thing + ".z", loc.getZ());
						 c.set(thing + ".pitch", loc.getPitch());
						 c.set(thing + ".yaw", loc.getYaw());
				         c.save(new File(file, "loc.yml"));
				    } catch (Exception e) {}
				    }
				 
				    public static String getWorld(String p) {
						try {
				        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "loc.yml"));
				        if (c.contains(p))
				        return String.valueOf(c.get(p + ".world"));
				    } catch (Exception e) {}
						return "world";
				    }
				 
				    public static Location getLoc(String p) {
						try {
				        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "loc.yml"));
				        if (c.contains(p)) {
				        	Location loc = new Location(Bukkit.getWorld((String) c.get(p + ".world")), Double.parseDouble(String.valueOf(c.get(p + ".x"))), Double.parseDouble(String.valueOf(c.get(p + ".y"))), Double.parseDouble(String.valueOf(c.get(p + ".z"))));
				        	loc.setPitch((float) Double.parseDouble(String.valueOf(c.get(p + ".pitch"))));
				        	loc.setYaw((float) Double.parseDouble(String.valueOf(c.get(p + ".yaw"))));
				        return loc;
				        }
				    } catch (Exception e) {}
						Location loc = Bukkit.getWorld("world").getSpawnLocation();
						loc.setYaw(0);
						loc.setPitch(0);
						return loc;
				    }
				    
				    //TODO Bans
					 public static void saveBan(String world, String target) {
						 try {
							 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
							 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "bans.yml"));
							 List<String> bans = c.getStringList(world);
							 if (!bans.contains(target))
							 bans.add(target);
							 c.set(world, bans);
					         c.save(new File(file, "bans.yml"));
					    } catch (Exception e) {}
					    }
					 
					 public static void unBan(String world, String target) {
						 try {
							 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
							 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "bans.yml"));
							 List<String> bans = c.getStringList(world);
							 bans.remove(target);
							 c.set(world, bans);
					         c.save(new File(file, "bans.yml"));
					    } catch (Exception e) {}
					    }
					 
					    public static boolean getBan(String world, String target) {
							try {
					        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "bans.yml"));
							 List<String> bans = c.getStringList(world);
					        if (bans.contains(target))
					        return true;
					    } catch (Exception e) {}
							return false;
					    }
					    //TODO OP Data
						 public static void op(String world, String target) {
							 try {
								 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
								 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "ops.yml"));
								 List<String> bans = c.getStringList(world);
								 if (!bans.contains(target))
								 bans.add(target);
								 c.set(world, bans);
						         c.save(new File(file, "ops.yml"));
						    } catch (Exception e) {}
						    }
						 
						 public static void deop(String world, String target) {
							 try {
								 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/");
								 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "ops.yml"));
								 List<String> bans = c.getStringList(world);
								 bans.remove(target);
								 c.set(world, bans);
						         c.save(new File(file, "ops.yml"));
						    } catch (Exception e) {}
						    }
						 
						    public static boolean getOp(String world, String target) {
								try {
						        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/", "ops.yml"));
								 List<String> bans = c.getStringList(world);
						        if (bans.contains(target))
						        return true;
						    } catch (Exception e) {}
								return false;
						    }
}