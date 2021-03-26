package me.Mark.VideoStream;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WebServer extends WebSocketServer {
	
	public static ArrayList<WebSocket> online = new ArrayList<WebSocket>();
	public WebServer(int port) throws UnknownHostException {super(new InetSocketAddress(port));}
	public WebServer(InetSocketAddress address) {super(address);}
	@Override public void onOpen(WebSocket conn, ClientHandshake handshake) {online.add(conn); ping();}
	@Override public void onClose(WebSocket conn, int code, String reason, boolean remote) {online.remove(conn);}
    @Override public void onMessage(WebSocket conn, String msg) {Stream.handel(msg);}
    
    static WebServer server;
	
	public static void main(String[] args) throws Exception {
		WebServer s = new WebServer(8887);
		server = s;
		s.start();
		System.out.println("Server started on port: " + s.getPort());
		BufferedReader sysin = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			String in = sysin.readLine();
			Stream.handel(in);
		}
	}
	
	@Override
	public void onError(WebSocket conn, Exception ex) {}
	
	public static void sendAll(String msg) {
		for (WebSocket s: online)
			s.send(msg);
	}
	
	public static void ping() {
		//request current video time from a user
			for (WebSocket s: online) {
				s.send("ping");
				return;
			}
	}
	
}