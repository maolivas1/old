package me.Mark.ht5;

import java.io.IOException;
import java.util.HashMap;
import java.util.Random;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Thingy {
	
	static HashMap<WebSocket, String> ids = new HashMap<WebSocket, String>();
	static HashMap<String, String> pastas = new HashMap<String, String>();
	static HashMap<String, String> icon = new HashMap<String, String>();
	static HashMap<String, Integer> flowx = new HashMap<String, Integer>();
	static HashMap<String, Integer> flowy = new HashMap<String, Integer>();
	
	static int pasta = 0;
	
	//Console input
	public static boolean handel(String in) throws Exception {
			Handel.sendAll(in);
		return true;
	}
	
	public static void join(WebSocket conn, ClientHandshake handshake) {
		String id = conn.toString().substring(33);
		ids.put(conn, id);
		
		Random r = new Random();
        int x = r.nextInt(1000) + 1;
        int y = r.nextInt(1000) + 1;
        int pic = r.nextInt(4) + 1;
        String img = "angel";
        if (pic == 2) img = "cow";
        else if (pic == 3) img = "p1";
        else if (pic == 4) img = "trump";
        icon.put(id, img);
		
		flowx.put(id, x);
		flowy.put(id, y);
		
		for (String p : pastas.keySet()) {
			String[] loc = pastas.get(p).split(" ");
			sendAll("pasta" + p + " add " + loc[0] + " " + loc[1] + " pasta 50 50");
		}
		
		for (WebSocket user : WebServer.online) {
			String mid = ids.get(user);
				int mx = flowx.get(mid);
				int my = flowy.get(mid);
				send(conn, mid + " add " + toPrecent(mx) + " " + toPrecent(my) + " " + icon.get(mid) + " 50 50");
				//if (user != conn)
				send(user, id + " add " + toPrecent(x) + " " + toPrecent(y) + " " + icon.get(id) + " 50 50");
			}
	}
	
	public static void leave(WebSocket conn, int code, String reason, boolean remote) {
		String id = ids.get(conn);
		sendAll(id + " leave");
		ids.remove(conn);
	}
	
	
	//Handel stuff from client
	public static void stuff(WebSocket conn, String msg) throws IOException {
		String id = ids.get(conn);
		
		if (msg.equals("right")) {
			int x = flowx.put(id, flowx.get(id) + 1);
			int y = flowy.get(id);
			sendAll(id + " set " + toPrecent(x) + " " + toPrecent(y) + " " + msg);
			return;
		} else if (msg.equals("left")) {
			int x = flowx.put(id, flowx.get(id) - 1);
			int y = flowy.get(id);
			sendAll(id + " set " + toPrecent(x) + " " + toPrecent(y) + " " + msg);
			return;
		} else if (msg.equals("up")) {
			int x = flowx.get(id);
			int y = flowy.put(id, flowy.get(id) - 1);
			sendAll(id + " set " + toPrecent(x) + " " + toPrecent(y) + " " + msg);
			return;
		} else if (msg.equals("down")) {
			int x = flowx.get(id);
			int y = flowy.put(id, flowy.get(id) + 1);
			sendAll(id + " set " + toPrecent(x) + " " + toPrecent(y) + " " + msg);
			return;
		} else if (msg.startsWith("eat")) {
			String food = msg.split(" ")[1];
			sendAll(food + " leave");
		}
		
		log(id + " " + msg);
		
	}
	
	public static String toPrecent(int x) {
		String mx = String.valueOf(x);
		String newx;
		newx =  mx.substring(0, mx.length() -1) + "." + mx.substring(mx.length() -1) + "%";
		if (newx.length() == 3) newx = 0 + newx;
		return newx;
	}
	
	public static void send(WebSocket user, String msg) {
		log(msg);
		user.send(msg);
	}
	
	public static void sendAll(String msg) {
		log("Global: " + msg);
		
		for (WebSocket user : WebServer.online) {
			user.send(msg);
		}
	}
	
	public static void log(String msg) {
		Main.chat(msg);
	}
	
}
