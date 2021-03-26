package me.Mark.ht5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.java_websocket.WebSocket;

public class Thingy {
	
	public static HashMap<WebSocket, String> nick = new HashMap<WebSocket, String>();
	public static HashMap<String, String> pic = new HashMap<String, String>();
	public static HashMap<String, Integer> score = new HashMap<String, Integer>();
	public static ArrayList<String> emojis = new ArrayList<String>();
	public static int it = 0;
	public static int emoji = 0;
	
	public static void stuff(WebSocket conn, String msg) throws IOException {
		
		if (msg.startsWith("login ")) {
			String nickname = msg.substring(6).replace(" ", "_");
			
			if (nickname.contains("<") && nickname.contains(">")) {
				conn.send("<>");
				Main.chat("Invalid Nickname: " + nickname);
				return;
			} else if (nick.containsValue(nickname)) {
				conn.send("taken");
				Main.chat("Invalid Nickname: " + nickname);
				return;
			}
			
			nick.put(conn, nickname);
			Main.chat(nickname + " Joined!");
			
			for (WebSocket con : nick.keySet()) {
				con.send("join " + nickname + " 0");
				if (con != conn)
					if (score.containsKey(nick.get(con))) conn.send("join " + nick.get(con) + " " + score.get(nick.get(con)));
					else conn.send("join " + nick.get(con) + " 0");
			}
			
			if (nick.size() >= 3) {
				for (WebSocket con : nick.keySet())
					con.send("good");
				if (emoji == 0)
				startRound();
			} else {
				conn.send("wait");
			}
			
			if (emoji != 0) {
				conn.send("start " + emoji + " " + (new ArrayList<String>(nick.values())).get(it));
			}
			
			
		} else if (msg.startsWith("submit ")) {
			String url = msg.substring(7);
			pic.put(nick.get(conn), url);
			Main.chat(nick.get(conn) + " submited: " + url);
			for (WebSocket con : nick.keySet())
				con.send("submit " + nick.get(conn));
			
			Main.chat(pic.size() + " " + nick.size());
			if (pic.size() == nick.size() - 1) {
				for (String nick : pic.keySet()) {
					sendAll("image " + nick + " " + pic.get(nick));
				}
				sendAll("go");
			}
		} else if (msg.startsWith("pick ")) {
			String name = msg.substring(5);
			if (score.containsKey(name)) {
				score.put(name, score.get(name) + 1);
			} else {
				score.put(name, 1);
			}
			sendAll("score " + name + " " + score.get(name));
			startRound();
		} else if (msg.startsWith("highlight ")) {
			sendAll(msg);
		} else Main.chat("Unknown command: " + msg);
	}
	
	public static void startRound() {
		if (nick.size()-1 > it) {
			it++;
		} else {
			it = 1;
		}
		int rand = 1 + (int)(Math.random() * emojis.size());
		sendAll("start " + rand + " " + (new ArrayList<String>(nick.values())).get(it));
		emoji = rand;
		emojis.remove(rand);
		pic.clear();
	}
	
	public static void sendAll(String msg) {
		for (WebSocket conn : nick.keySet())
		    conn.send(msg);
	}
	
	public static void restart() {
		emojis.clear();
		int i = 1;
		while (i != 30) {
			emojis.add(String.valueOf(i));
			i++;
		}
		it = 0;
		emoji = 0;
		pic.clear();
		score.clear();
	}
	
}
