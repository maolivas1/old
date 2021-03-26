package me.Meatie.code;

public class Video {
	
	public static void setVideo(String id) {
		Handel.sendAll("set " + id);
	}
	
	
}
