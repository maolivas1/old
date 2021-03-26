package me.Mark.ht5;

import java.io.IOException;
import java.util.HashMap;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Thingy {
	
	static HashMap<WebSocket, String> ids = new HashMap<WebSocket, String>();
	
	//Console input
	public static boolean handel(String in) throws Exception {
			Handel.sendAll(in);
		return true;
	}
	
	public static void join(WebSocket conn, ClientHandshake handshake) {
		String id = conn.toString().substring(33);
		ids.put(conn, id);
	}
	
	public static void leave(WebSocket conn, int code, String reason, boolean remote) {
		ids.remove(conn);
	}
	
	
	//Handel stuff from client
	public static void stuff(WebSocket conn, String msg) throws IOException {
		String id = ids.get(conn);
		log(id + " " + msg);
		
		sendAll(msg);
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
