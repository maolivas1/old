package me.Mark.AI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.util.Random;

import com.gtranslate.Audio;
import com.gtranslate.Language;

public class Kea {
	
	static String name = Data.get("name");
	static String botname = "Jarvis";
	static String favoriteColor = "blue";
	
	public static void load() {
		  AI.text.addActionListener(new ActionListener() {
			    public void actionPerformed(ActionEvent e) {
			        System.out.println(name + ": " + AI.text.getText());
			        AI.text.setEditable(false);
			        think(AI.text.getText());
			        AI.text.setText("");
			        AI.text.setEditable(true);
			}
	});
}
	
	public static void think(String input) {
		String msg = input.toLowerCase();
		
		     if (msg.contains("what") && (msg.contains("name") || (msg.contains("call") && msg.contains("you")))) load("botsname");
		else if (msg.contains("color") && msg.contains("what") && (msg.contains("favorite") || msg.contains("like"))) load("favoritecolor");
		else if (msg.contains("time")) load("time");
		else load("error");
	}
	
	public static void chat(String msg) {
		System.out.println(botname + ": " + msg);
		
		try {
			Audio audio = Audio.getInstance();
			InputStream sound = audio.getAudio(msg, Language.ENGLISH);
			audio.play(sound);
		} catch (Exception e) {}
	}
	
	public static void load(String input) {
		 int num = new Random().nextInt(5);
		if (input.equals("botsname")) {
			     if (num == 0) chat("My name is " + botname);
			else if (num == 1) chat("My name is " + botname);
			else if (num == 2) chat("Hello " + name + ", My name is " + botname);
			else if (num == 3) chat("You can call me " + botname);
			else if (num == 4) chat("I am known as " + botname);
		} else if (input.equals("favoritecolor")) {
		     if (num == 0 || num == 1 || num == 2) chat("My favorite color is " + favoriteColor);
		else if (num == 3 || num == 4) chat(favoriteColor + " Is my favorite color");
		} else if (input.equals("time")) {
		     if (num == 0 || num == 1 || num == 2) chat("It's " + Work.getTime());
		else if (num == 3 || num == 4) chat(Work.getTime());
		} else if (input.equals("error")) {
		     if (num == 0) chat("I'm Sorry, I dont know what to say about that");
		else if (num == 1) chat("I did not recognise any commands in what you just said");
		else if (num == 2) chat("Try to word that a litte difrently, I didnt understand it");
		else if (num == 3) chat("I was unable to desifre what you just said, try to word it difrently");
		else if (num == 4) chat("I'm sorry, Im not shure what to say about that");
		}
	}
	
	
}
