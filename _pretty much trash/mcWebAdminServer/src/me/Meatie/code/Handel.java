package me.Meatie.code;

import java.io.IOException;
import java.util.HashMap;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Handel {
	
	public static HashMap<WebSocket, String> usernames = new HashMap<WebSocket, String>();
	
	//Console input
	public static boolean handel(String in) throws Exception {
		Handel.sendAll(in);
		return true;
	}
	
	public static void join(WebSocket conn, ClientHandshake handshake) {
		String ip = conn.getRemoteSocketAddress().getAddress().getHostAddress();
		String name = usernames.get(conn);
		if (name == null)
		log(ip + " Connected");
		else log(name + " Connected");
	}
	
	public static void leave(WebSocket conn, int code, String reason, boolean remote) {
		String ip = conn.getRemoteSocketAddress().getAddress().getHostAddress();
		String name = usernames.get(conn);
		
		
		
	}
	
	public static void msg(WebSocket conn, String msg) throws IOException {
		String ip = conn.getRemoteSocketAddress().getAddress().getHostAddress();
		
		String name = usernames.get(conn);
		if (name == null) name = ip;
		
		 if (msg.startsWith("chat")) {
			msg = msg.substring(4);
			sendAll("chat " + name + ": " + msg);
		 }
				
				
		log(name + ": " + msg);
	}
	

	
	public static void send(WebSocket user, String msg) {
		user.send(msg);
	}
	
	public static void sendAll(String msg) {
		for (WebSocket user : WebServer.online) {
			user.send(msg);
		}
	}
	
	public static void log(String msg) {
		Main.chat(msg);
		System.out.println("Log: " + msg);
	}
	
}
