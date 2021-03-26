package me.Meatie.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import org.java_websocket.WebSocket;

public class PlayList {

	public static void setName(String name, String videoId, String videoName) {
		String all = null;
		boolean alrety = false;
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       if (line.startsWith(videoId)) {
		    	   String id = line.substring(0, 11);
		    	   line = id + " " + videoName;
		    	   alrety = true;
		       }
		       if (line != "\n" && line != "" && line != null) {
		    	   if (all == null) all = line;
		    	   else all = all + "\n" + line;
		       }
		    }
		       if (alrety == false) {
		    	   line = videoId + " " + videoName;
		    	   all = all + "\n" + line;
		       }
		    setFile(name, all);
	} catch (FileNotFoundException e) {
		try {
			String line = videoId + " " + videoName;
			setFile(name, line);
		} catch (FileNotFoundException e1) {}
	} catch (IOException e) {
		Handel.log("IOExeption..");
		e.printStackTrace();
	}
	}
	
	public static void moveUp(String name, String videoId) throws IOException {
		String all = null;
		int value = 0;
		String temp = "";
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (line.startsWith(videoId)) {
		    		value = 1;
		    		temp = line;
		    	} else {
		    		if (value == 1) {
		    			value = 2;
		    			if (all == null) all = line + "\n" + temp;
		    			else all = all + "\n" + line + "\n" + temp;
		    		} else if (line != "\n" && line != "" && line != null) {//TODO Try To reduce this line <-----
				    	   if (all == null) all = line;
				    	   else all = all + "\n" + line;
				       }
		    	}
		    }
		    setFile(name, all);
	}
	}
	
	public static void moveDown(String name, String videoId) throws IOException {
		String all = null;
		String temp = "";
		String last = "";
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (line.startsWith(videoId)) {
		    		temp = last;
		    		all = all.replace(last, line);
		    		all = all + "\n" + temp;
		    		
		    		temp = line;
		    	} else {
		    		last = line;
		    		if (line != "\n" && line != "" && line != null) {//TODO Try To reduce this line <-----
				    	   if (all == null) all = line;
				    	   else all = all + "\n" + line;
				       }
		    	}
		    }
		    setFile(name, all);
	}
	}
	
	public static void delVideo(String name, String videoId) throws IOException {
		String all = null;
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if (!line.startsWith(videoId)) {
		     if (line != "\n" && line != "" && line != null) {//TODO Try To reduce this line <-----
				    	if (all == null) all = line;
				    	else all = all + "\n" + line;
				       }
		    	}
		    }
		    setFile(name, all);
	}
	}
	
	@SuppressWarnings("resource")
	public static void push(String name) {
		try {
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist");
		int count = 0;
		String all = null;
		String push= "";
		{
		BufferedReader br = new BufferedReader(new FileReader(file));
		    while ((br.readLine()) != null)
		    	count++;
		}
		{
		int temp = 1;
		BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
		    while ((line = br.readLine()) != null) {
		    	if (count != temp) {
		    		temp++;
			    	if (all == null) all = line;
			    	else all = all + "\n" + line;
		    } else {
		    	push = line;
		    }
	}
	}
		all = push + "\n" + all;
		setFile(name, all);
		} catch(Exception e) {}
	}
	
	public static void setFile(String name, String all) throws FileNotFoundException {
		File f = new File("H:/Mark/Documents/webdata/" + name);
		if (!f.exists() || !f.isDirectory()) f.mkdir();
		
		PrintWriter writer = new PrintWriter("H:/Mark/Documents/webdata/" + name + "/playlist/");
		writer.println(all);
		writer.close();
	}
	
	public static void getPlaylist(WebSocket user) throws FileNotFoundException, IOException {
		String name = Handel.usernames.get(user);
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist/");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       Handel.send(user, "#addPlayList " + line);
		    }
		}
	}
	
}
