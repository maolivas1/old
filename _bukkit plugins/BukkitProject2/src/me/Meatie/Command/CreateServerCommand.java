package me.Meatie.Command;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import me.Meaie.Cmd.Msg;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CreateServerCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
			

		
			//If Player Is Op
		    if (!sender.isOp()) {
				Msg.notallowed(sender);
				return true;
			}
			
			if (!(args.length == 1)) return true;
			if (!getWorld(args[0])) return true;
			
			int id = getID();
			
			if (id == 0) {
				sender.sendMessage(ChatColor.RED + "Max Servers Curently In Use, Use ");
				return true;
			}
			
			
			
	    	File srcFolder = new File("H:/Mark/Documents/Minecraft Stuff/Worlds/#server");
	    	File destFolder = new File("H:/Mark/Documents/Minecraft Stuff/Temp Servers/" + id);
	        copyFolder(srcFolder, destFolder);
	        	
		    	File srcWorld = new File("H:/Mark/Documents/Minecraft Stuff/Worlds/" + args[0] + "/world");
		    	File destWorld = new File("H:/Mark/Documents/Minecraft Stuff/Temp Servers/" + id + "/world");
	        	copyFolder(srcWorld, destWorld);
	        	
				sender.sendMessage("Creating Server ID: " + id + " " + args[0]);
		
		return true;
	}
	
	public int getID() {
		if (exists(1))
			return 1;
		
		if (exists(2))
			return 2;
		
		if (exists(3))
			return 3;
		
		if (exists(4))
			return 4;
		
		if (exists(5))
			return 5;
			
		return 0;
	}
	
	public boolean getWorld(String world) {
		
		if (world.equalsIgnoreCase("dropper"))
			return true;
		
		return false;
	}
	
	public static boolean exists(int id) {
		File file = new File("H:/Mark/Documents/Minecraft Stuff/Temp Servers/" + id);
		if(file.exists())
			return false;
		return true;
	}
 
    public static void copyFolder(File src, File dest) {
    	try {
    	if(src.isDirectory()) {
    		
    		//if directory not exists, create it
    		if (src.exists())
    		if(!dest.exists())
    		   dest.mkdir();

    		
    		//list all the directory contents
    		String files[] = src.list();
 
    		for (String file : files) {
    		   File srcFile = new File(src, file);
    		   File destFile = new File(dest, file);
    		   copyFolder(srcFile,destFile);
    		}

    		Bukkit.broadcastMessage("1");
    	} else {
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
 
    	        byte[] buffer = new byte[1024];
 
    	        int length;
    	        while ((length = in.read(buffer)) > 0)
    	    	   out.write(buffer, 0, length);
    	        in.close();
    	        out.close();
        		Bukkit.broadcastMessage("2");
    	}
    	} catch (IOException e) {}
    }
	
}
