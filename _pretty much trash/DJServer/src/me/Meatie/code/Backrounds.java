package me.Meatie.code;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.java_websocket.WebSocket;

public class Backrounds {

	public static void getBackrounds(WebSocket user) throws FileNotFoundException, IOException {
		File file = new File("H:/Mark/Documents/webdata/backrounds/");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       Handel.send(user, "#addBackround " + line);
		    }
		}
	}
	
	//User Icons
	public static void getUsers(WebSocket user) throws FileNotFoundException, IOException {
		File file = new File("H:/Mark/Documents/webdata/icons/");
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		       Handel.send(user, "#addUser " + line);
		    }
		}
	}
	
}