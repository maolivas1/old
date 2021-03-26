package me.Mark.ht5;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Thingy {
	
	public static ArrayList<String> features = new ArrayList<String>();
	
	//Console input
	public static boolean handel(String in) throws Exception {
		sendAll(in);
		return true;
	}
	
	public static void join(WebSocket conn, ClientHandshake handshake) {
		for (String meme : features)
			conn.send(meme);
	}
	
	public static void start() {
		boolean start = false;
	    boolean skip = false;
		  String page = get("https://ifunny.co/");
		  Scanner scanner = new Scanner(page);
		  String last = null;
		  while (scanner.hasNextLine()) {
		    String line = scanner.nextLine();
		    
		    if (line.startsWith("        <div class=\"js-content-container content-list__container\">"))
		    	start = true;
		    
		    if (start == true) {
		    	if (skip == true) {
		    		skip = false;
		    	} else {
		    	
		    		line = line.replace(" ", "");
		    		if (line.contains(".jpg")) {
		    		line = line.substring(line.indexOf("src")+5);
		    		line = line.substring(0, line.indexOf("alt")-1);
		    		System.out.println(line);
		    		if (last != null)
		    		features.add(last);
		    		last = line;
		    	/*	} else if (line.contains(".mp4")) {
		    			line = line.substring(line.indexOf("data-video")+12);
		    			line = line.substring(0, line.indexOf("data-cid")-1);
		    			System.out.println(line);
		    			features.add(last);
		    			features.add(line);
		    			skip = true;
		    			last = null;
		    	*/
		    		} else if (line.contains(".webm")) {
		    			line = line.substring(line.indexOf("webm")+6);
		    			line = line.substring(0, line.indexOf("data")-1);
		    			System.out.println(line);
		    			features.add(line);
		    			last = null;
		    		}
		    }
		    }
		  }
  		if (last != null)
  		features.add(last);
		  scanner.close();
	}
	
	public static void leave(WebSocket conn, int code, String reason, boolean remote) {}
	
	//Handel stuff from client
	public static void stuff(WebSocket conn, String msg) throws IOException {}
	
	public static void send(WebSocket user, String msg) {
		user.send(msg);
	}
	
	public static void sendAll(String msg) {
		log("Global: " + msg);
		for (WebSocket user : WebServer.online)
			user.send(msg);
	}

	
	public static void log(String msg) {
		Main.chat(msg);
	}
	
	
	public static void tick() {
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  
		  }
		  }, 0, 1000);
	}
	
	public static String get(String path) {
		String body = null;
		try {
		  URL url = new URL(path);
		  URLConnection con = url.openConnection();
		  InputStream in = con.getInputStream();
		  String encoding = con.getContentEncoding();
		  encoding = encoding == null ? "UTF-8" : encoding;
		  
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  byte[] buf = new byte[8192];
		  int len = 0;
		  while ((len = in.read(buf)) != -1)
		      baos.write(buf, 0, len);
		  body = new String(baos.toByteArray(), encoding);
	} catch (Exception e) {}
		return body;
	}
}
