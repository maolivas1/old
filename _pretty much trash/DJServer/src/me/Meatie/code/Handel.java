package me.Meatie.code;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Handel {
	
	public static HashMap<WebSocket, String> usernames = new HashMap<WebSocket, String>();
	
	//Console input
	public static boolean handel(String in) throws Exception {
		if (in.startsWith("skip")) {
			WaitList.skip();
		} else Handel.sendAll(in);
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
		sendAll("#setIcon " + name + " leave");
		if (name == null)
		log(ip + " Disconected");
		else log(name + " Disconected");
		if (WaitList.djs.contains(conn)) {
			WaitList.leave(conn);
		}
	}
	
	@SuppressWarnings("resource")
	public static void msg(WebSocket conn, String msg) throws IOException {
		String ip = conn.getRemoteSocketAddress().getAddress().getHostAddress();
		
		String name = usernames.get(conn);
		if (name == null) name = ip;
		
		 if (msg.startsWith("chat")) {
			msg = msg.substring(4);
			sendAll("chat " + name + ": " + msg);
		} else if (msg.startsWith("register")) {
			//Register User
			String[] args = msg.substring(9).split(" ");
			String user = args[0].toLowerCase();
			String pass = args[1];
			
			File f = new File("H:/Mark/Documents/webdata/" + user);
			if (f.exists() && f.isDirectory()) {
				//User alrety Exsists
				send(conn, "#taken");
			} else {
				//Create account
				send(conn, "#unlock");
				usernames.put(conn, user);
				log(user + " Registered");
			    if (f.mkdir()) {
			    	PrintWriter writer = new PrintWriter("H:/Mark/Documents/webdata/" + user + "/pass", "UTF-8");
			    	writer.println(pass);
			    	writer.close();
			    }
			}
		} else if (msg.startsWith("login")) {
			String[] args = msg.substring(6).split(" ");
			String user = args[0].toLowerCase();
			String trypass = args[1];
			//hide password from console
			msg = msg.replace(trypass, "password");
			String content = new Scanner(new File("H:/Mark/Documents/webdata/" + user + "/pass")).useDelimiter("\\Z").next();
			if (content.equals(trypass)) {
				//Correct Login
				usernames.put(conn, user);
				log(user + " Logged in.");
				send(conn, "#unlock");
				
				//Send player stuffs
				PlayList.getPlaylist(conn);
				Backrounds.getBackrounds(conn);
				Backrounds.getUsers(conn);
				String back = UserSettings.getValue(conn, "back");
				if (back != null) send(conn, "#setBack " + back);
				String vol = UserSettings.getValue(conn, "vol");
				if (vol != null) send(conn, "#setVol " + vol);
				String icon = UserSettings.getValue(conn, "icon");
				if (icon != null) {
					sendAll("#setIcon " + user + " " + icon);
				} else {
					UserSettings.setValue(name, "icon", "images/icon/lemin.png");
				}
				if (WaitList.song != null) send(conn, "set " + WaitList.song);
				if (Time.time != -1) send(conn, "#setTime " + (Time.totalTime  - Time.time));
				
				//Send user all users.. icon thigys
				for (WebSocket me : WebServer.online) {
					if (me != conn) {
					String micon = UserSettings.getValue(me, "icon");
					String mname = usernames.get(me);
					if (micon != null) send(conn, "#setIcon " + mname + " " + micon);
					}
				}
				
				
			} else {
				//Incorect Password...
				send(conn, "#badpass");
			}
			return;
		} else if (msg.startsWith("addVideo")) {
			String[] args = msg.substring(9).split(" ");
			String id = args[0];
			String videoName = msg.substring(10 + args[0].length());
			PlayList.setName(name, id, videoName);
			return;
		} else if (msg.startsWith("upVideo")) {
			String id = msg.substring(8);
			PlayList.moveUp(name, id);
			return;
		} else if (msg.startsWith("downVideo")) {
			String id = msg.substring(10);
			PlayList.moveDown(name, id);
			return;
		} else if (msg.startsWith("delVideo")) {
			String id = msg.substring(9);
			PlayList.delVideo(name, id);
			return;
		} else if (msg.startsWith("dj")) {
			WaitList.join(conn);
			return;
		} else if (msg.startsWith("nodj")) {
			WaitList.leave(conn);
			return;
		} else if (msg.startsWith("myBack")) {
			String path = msg.substring(7);
			UserSettings.setValue(name, "back", path);
			return;
		} else if (msg.startsWith("vol")) {
			String vol = msg.substring(4);
			UserSettings.setValue(name, "vol", vol);
			return;
		} else if (msg.startsWith("myUser")) {
			String path  = msg.substring(7);
			UserSettings.setValue(name, "icon", path);
			sendAll("#setIcon " + name + " " + path);
			return;
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
