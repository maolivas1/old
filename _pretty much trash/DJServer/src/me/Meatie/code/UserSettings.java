package me.Meatie.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.java_websocket.WebSocket;

public class UserSettings {

	public static void setValue(String name, String thing, String value) {
		String all = null;
		boolean alrety = false;
		File file = new File("H:/Mark/Documents/webdata/" + name + "/settings.yml");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if (line.startsWith(thing)) {
		    	   String id = line.substring(0, thing.length());
		    	   line = id + " " + value;
		    	   alrety = true;
		       }
		       if (line != "\n" && line != "" && line != null) {
		    	   if (all == null) all = line;
		    	   else all = all + "\n" + line;
		       }
		    }
		       if (alrety == false) {
		    	   line = thing + " " + value;
		    	   all = all + "\n" + line;
		       }
		    setFile(name, all);
	} catch (FileNotFoundException e) {
		try {
			String line = thing + " " + value;
			setFile(name, line);
		} catch (FileNotFoundException e1) {}
	} catch (IOException e) {}
	}
	
	public static void setFile(String name, String all) throws FileNotFoundException {
		File f = new File("H:/Mark/Documents/webdata/" + name);
		if (!f.exists() || !f.isDirectory()) f.mkdir();
		
		PrintWriter writer = new PrintWriter("H:/Mark/Documents/webdata/" + name + "/settings.yml");
		writer.println(all);
		writer.close();
	}
	
	public static String getValue(WebSocket user, String thing) {
		String name = Handel.usernames.get(user);
		File file = new File("H:/Mark/Documents/webdata/" + name + "/settings.yml");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (line.startsWith(thing)) {
		    		line = line.substring(thing.length() + 1);
		    		return line;
		    	}
		    }
		} catch (IOException e) {}
		return null;
	}
	
}
