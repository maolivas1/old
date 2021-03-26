package me.Meatie.swan;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

public class PermsConfig {

				 public static void saveGroupPerm(String group, String perm) {
					 try {
						 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/perms");
						 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "group.yml"));
						 List<String> list = c.getStringList(group);
						 if (!list.contains(perm))
						 list.add(perm);
						 c.set(group, list);
				         c.save(new File(file, "group.yml"));
				    } catch (Exception e) {}
				    }
				 
				 public static void delGroupPerm(String thing, String perm) {
					 try {
						 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/perms");
						 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "group.yml"));
						 List<String> list = c.getStringList(thing);
						 list.remove(perm);
						 c.set(thing, list);
				         c.save(new File(file, "group.yml"));
				    } catch (Exception e) {}
				    }
				 
				    public static List<String> getPerms(String thing) {
						try {
				        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/perms", "group.yml"));
				        List<String> list = c.getStringList(thing);
				        return list;
				    } catch (Exception e) {}
						return null;
				    }
				    
					 public static void saveRank(String user, String rank) {
						 try {
							 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/perms");
							 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "rank.yml"));
							 c.set(user, rank);
					         c.save(new File(file, "rank.yml"));
					    } catch (Exception e) {}
					    }
					 
					    public static String getRank(String user) {
							try {
					        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/perms", "rank.yml"));
					        if (c.contains(user))
					        return c.get(user).toString();
					    } catch (Exception e) {}
							return "default";
					    }
					    
						 public static void saveChild(String group, String rank) {
							 try {
								 File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/perms");
								 YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(file, "child.yml"));
								 c.set(group, rank);
						         c.save(new File(file, "child.yml"));
						    } catch (Exception e) {}
						    }
					    
					    public static String getChild(String group) {
							try {
					        YamlConfiguration c = YamlConfiguration.loadConfiguration(new File(System.getProperty("user.dir") + "/plugins/Meatie/perms", "child.yml"));
					        if (c.contains(group))
					        return c.get(group).toString();
					    } catch (Exception e) {}
							return null;
					    }
					    
}