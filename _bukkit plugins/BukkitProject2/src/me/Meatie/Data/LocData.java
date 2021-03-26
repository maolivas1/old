package me.Meatie.Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

import me.Meatie.Command.WorldCommand;
import net.minecraft.util.org.apache.commons.io.IOUtils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LocData {
	
	public static void save(Player player) {
		clean(player);
		try(PrintWriter output = new PrintWriter(new FileWriter(System.getProperty("user.dir") + "/plugins/Meatie/loc.txt",true)))  {
			Location loc = player.getLocation();
		    output.printf("%s\r\n", player.getName() + " " + player.getWorld().getName() + " " + loc.getX() + " " + loc.getY() + " " + loc.getZ() + " " + loc.getYaw() + " " + loc.getPitch());
		}  catch (Exception e) {}
	}
	
	public static void clean(Player player) {
	    try {
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/loc.txt");
	    	String content = IOUtils.toString(new FileInputStream(file));
	    	content = content.replaceAll("(?m)^" + player.getName() + ".*", "");
	    	content = content.replaceAll("(?m)^[ \t]*\r?\n", "");
	    	IOUtils.write(content, new FileOutputStream(file));
	    } catch (Exception e) {}
	}
	
	public static void read(Player player) {
		try {
			
			
			File file = new File(System.getProperty("user.dir") + "/plugins/Meatie/loc.txt");
			    FileReader fr = new FileReader(file);
			    BufferedReader br = new BufferedReader(fr);
			    String line;
			    while((line = br.readLine()) != null) {
			        if(line.startsWith(player.getName())) {
						String[] args = line.split(" ");
						//TODO If World dosn't exist their will be a error
						
						//Load World
						WorldCommand.load(args[1]);
						World world = Bukkit.getWorld(args[1]);
						double x = Double.parseDouble(args[2]);
						double y = Double.parseDouble(args[3]);
						double z = Double.parseDouble(args[4]);
						
						float yaw = Float.parseFloat(args[5]);
						float pitch = Float.parseFloat(args[6]);

						Location loc = new Location(world, x, y, z);
					    loc.setPitch(pitch);
					    loc.setYaw(yaw);
						player.teleport(loc);
			        }
			    }
			    br.close();
			    fr.close();
			    return;
    } catch (Exception e) {}
		return;
		
	}
	
}
