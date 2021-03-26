package me.Mark.ht5;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;

public class WebServer extends WebSocketServer {
	
	public WebServer(int port) throws UnknownHostException {
		super(new InetSocketAddress(port));
	}

	public WebServer(InetSocketAddress address) {
		super(address);
	}

	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {}

	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {}

	@Override
	public void onMessage(WebSocket conn, String msg) {
		try {
			Thingy.stuff(conn, msg);
		} catch (FileNotFoundException e) {} catch (UnsupportedEncodingException e) {} catch (IOException e) {}
	}

	static WebServer server;
	
	public static void start(String[] args) throws Exception {
		WebSocketImpl.DEBUG = true;
		WebServer s = new WebServer(8887);
		server = s;
		s.start();
		Main.chat("Server started on port: " + s.getPort());
	}
	
	
	public void onFragment(WebSocket conn, Framedata fragment) {
		
	}
	
	@Override
	public void onError(WebSocket conn, Exception ex) {
		
	}
	
}