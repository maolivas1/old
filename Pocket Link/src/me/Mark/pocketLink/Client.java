package me.Mark.pocketLink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    BufferedReader in;
    static PrintWriter out;

    public static void send(String msg) {
    	out.println(msg);
    }
    
    @SuppressWarnings("resource") 
    private void run() throws IOException {
        Socket socket = new Socket("127.0.0.1", 9002);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
        
        while (true) {
        	if (in != null) {
            String line = in.readLine();
            Logic.think(line);
        	}
        }
    }

    public static void start() throws Exception {
    	Thread thread = new Thread(new Runnable() {
    	     public void run() {
    	    	 Client client = new Client();
    	         try {
					client.run();
				} catch (IOException e) {
					//Keep connecting
					try {
						start();
					} catch (Exception e1) {}
				}
    	     }

    	});
    	thread.start();
    }
}