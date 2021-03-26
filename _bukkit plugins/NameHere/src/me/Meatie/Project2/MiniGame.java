package me.Meatie.Project2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import me.Meatie.Project2.Commands;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class MiniGame {

	public static void cmd(Player player, String[] args, PlayerCommandPreprocessEvent event) {
		event.setCancelled(true);
		if (args.length == 2) {
			String map = args[1].toLowerCase();
			if (map.equals("cops1") || map.equals("cops2") || map.equals("cops3") || map.equals("cops4")) {
				//load(map);
				if (available(25567)) {
					loadServer(25567, map);
					Commands.send(player, "&2&lLoaded &7&l" + map + " &2&lOn Server &7&l1");
					return;
				}
				if (available(25568)) {
					loadServer(25568, map);
					Commands.send(player, "&2&lLoaded &7&l" + map + " &2&lOn Server &7&l2");
					return;
				}
				Commands.send(player, "&c&lAll Servers Buisy At The Moment.");
		  } else Commands.send(player, "&c&lAvalible Maps: &7&lcops1, cops2, cops3, cops4");
		} else Commands.send(player, "&c&l/minigame &7&ltype");
	}
	
	public static void loadServer(int port, String name) {
		File src = new File(Main.dir + "Maps/" + name + "/");
		File dest = new File(System.getProperty("user.dir") + "/Servers/" + port + "/" + name + "/");
		copyFolder(src, dest);
		try {
		//Runtime.getRuntime().exec("cmd /h start " + Main.dir + port + "\run.bat");
		//Desktop.getDesktop().open(new File(System.getProperty("user.dir") + "\\" + port + ".bat"));
		Runtime.getRuntime().exec("java -Xms3G -Xmx3G -jar " + System.getProperty("user.dir") + "/Servers/" + port + "/spigot.jar");
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	private static boolean available(int port) {
	    try (Socket ignored = new Socket("localhost", port)) {
	        return false;
	    } catch (IOException ignored) {
	        return true;
	    }
	}
	
	/*
	public static void load(String name) {
		File src = new File(Main.dir + "Maps/" + name + "/");
		File dest = new File(System.getProperty("user.dir") + "/" + name + "/");
		copyFolder(src, dest);
		Bukkit.getServer().createWorld(new WorldCreator(name));
	}
	*/
	
	public boolean Acceptible(int grade) {
		if (grade <= 100) {
			return true;
		}
		return false;
	}
	
	
    public static void copyFolder(File src, File dest) {
    	try {
        	if(src.isDirectory()){
        		if(!dest.exists()) dest.mkdir();
        		String files[] = src.list();
        		for (String file : files) {
        		   File srcFile = new File(src, file);
        		   File destFile = new File(dest, file);
        		   copyFolder(srcFile,destFile);
        		}     
        	} else {
        		InputStream in;
					in = new FileInputStream(src);
        	        OutputStream out = new FileOutputStream(dest); 
        	        byte[] buffer = new byte[1024];
        	        int length;
        	        while ((length = in.read(buffer)) > 0)
        	    	   out.write(buffer, 0, length);
        	        in.close();
        	        out.close();
        }
    	} catch (Exception e) {}
    }
	
}
