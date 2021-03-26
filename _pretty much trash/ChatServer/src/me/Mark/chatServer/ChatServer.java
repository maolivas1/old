package me.Mark.chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;

public class ChatServer {
    private static HashSet<PrintWriter> writers = new HashSet<PrintWriter>();
    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(9001);
        try {while (true) {new Handler(listener.accept()).start();}
        } finally {listener.close();}
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
                System.out.println(out);

                while (true) {
                    String input = in.readLine();
                    if (input == null) return;
                    System.out.println(input);
                    for (PrintWriter writer : writers) {
                        writer.println(input);
                    }
                }
            } catch (IOException e) { System.out.println(e);
            } finally {
                if (out != null) writers.remove(out);
                try {socket.close();} catch (IOException e) {}
            }
        }
    }
}