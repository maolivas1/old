package me.Mark.ht5;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Handel {
	
	//Console input
	public static boolean handel(String in) throws Exception {
		Handel.sendAll(in);
		return true;
	}
	
	public static void join(WebSocket conn, ClientHandshake handshake) {
		String ip = conn.getRemoteSocketAddress().getAddress().getHostAddress();
		log(ip + " Connected");
	}
	
	public static void leave(WebSocket conn, int code, String reason, boolean remote) {
		String ip = conn.getRemoteSocketAddress().getAddress().getHostAddress();
		log(ip + " Disconected");
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
