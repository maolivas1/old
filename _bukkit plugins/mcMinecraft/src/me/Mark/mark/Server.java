package me.Mark.mark;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class Server {
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    public static void start() throws Exception {
        System.out.println("PocketLink Server Started");
        
    	Thread thread = new Thread(new Runnable() {
   	     public void run() {
   	    	 try {
   	        ServerSocket listener = new ServerSocket(9001);
   	        try {while (true) {new Handler(listener.accept()).start();}
   	        } finally {listener.close();}
   	    	 } catch (Exception e) {}
   	     }

   	});
   	thread.start();
        

    }
    
    private static class Handler extends Thread {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;
        
        public Handler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                writers.add(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) return;
                    Logic.think(input);
                }
            } catch (IOException e) { System.out.println(e);
            } finally {
                if (out != null) writers.remove(out);
                try {socket.close();} catch (IOException e) {}
            }
        }
    }
    
    public static void send(String msg) {
    	for (PrintWriter writer : writers) writer.println(msg);
    }
    
}