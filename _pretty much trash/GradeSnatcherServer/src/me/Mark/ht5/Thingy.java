package me.Mark.ht5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;

import org.java_websocket.WebSocket;
import org.java_websocket.handshake.ClientHandshake;

public class Thingy {
	public static HashMap<String, String> email = new HashMap<String, String>();
	public static ArrayList<String> needsLogin = new ArrayList<String>();
	public static HashMap<String, String> verify = new HashMap<String, String>();
	public static WebSocket console;
	
	//Console input
	public static boolean handel(String in) throws Exception {
		if (in.startsWith("add ")) {
			
		}
		return true;
	}
	
	public static void join(WebSocket conn, ClientHandshake handshake) {
	}
	
	public static void start() {
		try (BufferedReader br = new BufferedReader(new FileReader("H:/Mark/Documents/NotifyMe/data.txt"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	
		    	String[] args = line.split(" ");
		    	
		    	email.put(args[0], args[2]);
		    	
		    	line = args[0] + " " + args[1];
		    	
		       needsLogin.add(line);
		       log("Needs Login: " + args[0]);
		    }
		} catch (FileNotFoundException e) {} catch (IOException e) {}
	}
	
	public static void leave(WebSocket conn, int code, String reason, boolean remote) {
		if (conn == console)
			console = null;
	}
	
	//Handel stuff from client
	public static void stuff(WebSocket conn, String msg) throws IOException {
		
     if (msg.startsWith("signup")) {
			String[] args = msg.split(",");
			String user = args[1];
			String pass = args[2];
			String email = args[3];
			
			String thing = user + " " + pass + " " + email;
			
			log("New User Signup: " + user);
			
			 String code = new BigInteger(130, new SecureRandom()).toString(32);
			verify.put(code, thing);
			//log("Verify Code: " + code);
			Mail.verify(email, user, code);
			send(conn, "ping");
		} else if (msg.equals("console")) {
			
			if (console == null) {
				console = conn;
				send(conn, "welcome");
				log("Console Connected");
				
				//send first user that needs login
				
				String login  = needsLogin.get(0);
				needsLogin.remove(login);
				needsLogin.add(login);
				send(console, "login " + login);
				
			} else {
				send(conn, "full");
			}
			
		} else if (msg.startsWith("verify")) {
			String[] args = msg.split(",");
			String code = args[1];
			if(msg.contains("@")) {
				//Unsubscribe
				if (Data.remove(code)) {
					send(conn, "yes");
					if (needsLogin.contains(code))
						needsLogin.remove(code);
					if (email.containsKey(code))
						email.remove(code);
					log("Unsubscribed: " + code);
				} else send(conn, "no");
			} else
			
				//Verify Signup
			if (verify.get(code) != null) {
				send(conn, "yes");
				Data.add(verify.get(code));
				String[] a = verify.get(code).split(",");
				log("Verified: " + a[0]);
				verify.remove(code);
			} else send(conn, "no");
			
		} else if (msg.startsWith("error,")) {
			String[] args = msg.split(",");
			String failed = args[1];
			log("Failed To Login: " + failed);
			
			if (needsLogin.contains(failed))
				needsLogin.remove(failed);
			
			Mail.failed(email.get(failed), failed);
			
			stuff(conn, "done");
		} else if (msg.startsWith("done")) {
			String login  = needsLogin.get(0);
			needsLogin.remove(login);
			needsLogin.add(login);
			send(console, "login " + login);
			String[] args = login.split(" ");
			log("Next User: " + args[0]);
		}
		
		
	}
	
	public static void send(WebSocket user, String msg) {
		user.send(msg);
	}

	
	public static void log(String msg) {
		Main.chat(msg);
	}
	
}
