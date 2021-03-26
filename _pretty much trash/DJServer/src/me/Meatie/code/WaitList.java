package me.Meatie.code;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import org.java_websocket.WebSocket;

public class WaitList {
	
	static ArrayList<WebSocket> djs = new ArrayList<WebSocket>();
	static String song = null;
	static WebSocket dj;
	
	public static void join(WebSocket conn) {
		boolean set = false;
		if (djs.size() == 0) set = true;
		djs.add(conn);
		if (set == true) skip();
	}
	
	public static void leave(WebSocket conn) {
		djs.remove(conn);
		if (dj == conn) skip();
	}
	
	//Set Current DJ
	public static void skip() {
		//Time.time = -1;
		if (djs.size() == 0) {
			Video.setVideo("0");
			song = null;
		}
		for (WebSocket conn : djs) {
			String name = Handel.usernames.get(conn);
			getNextSong(name);
			Handel.send(conn, "#push");
			PlayList.push(name);
			dj = conn;
			//Put at back of list
			djs.remove(conn);
			djs.add(conn);
			return;
		}
		return;
	}
	
	public static void getNextSong(String name) {
		File file = new File("H:/Mark/Documents/webdata/" + name + "/playlist/");
		int count = 0;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    while (br.readLine() != null) count++;
		} catch (IOException e) {}
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    int l = 0;
		    while ((line = br.readLine()) != null) {
			       if (++l == count) {
				    String id = line.substring(0, 11);
			    	 getLength(id);
			    	 Video.setVideo(id);
			    	 song = id;
			       }
			    }
		} catch (IOException e) {}
		return;
	}

public static void getLength(String id) throws IOException {
	  URL url = new URL("https://www.googleapis.com/youtube/v3/videos?id=" + id + "&part=contentDetails&key=AIzaSyDykHEdP9XIdhcwzZXUaMFjMm2n6d0M9Zg");
	  URLConnection con = url.openConnection();
	  InputStream in = con.getInputStream();
	  String encoding = con.getContentEncoding();
	  encoding = encoding == null ? "UTF-8" : encoding;
	  
	  ByteArrayOutputStream baos = new ByteArrayOutputStream();
	  byte[] buf = new byte[8192];
	  int len = 0;
	  while ((len = in.read(buf)) != -1) {
	      baos.write(buf, 0, len);
	  }
	  for (String line : baos.toString().split("\n")) {
		    if (line.contains("duration")) {
		    	line = line.substring(19,  line.length() - 3);
		    	int time = 0;
		    	if (line.contains("M")) {
		       String[] stuff = line.split("M");
		       int mins = Integer.valueOf(stuff[0]);
		       int secs = Integer.valueOf(stuff[1]);
		       time = mins*60 + secs -5;
		    	} else {
		    		time = Integer.valueOf(line)-5;
		    	}
		        Time.set(time);
		    }
		}
}


}