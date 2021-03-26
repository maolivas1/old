package me.Mark.VideoStream;

public class Stream {
	
	public static void handel(String msg) {
		System.out.println(msg);
		
		WebServer.sendAll(msg);
	}

}
