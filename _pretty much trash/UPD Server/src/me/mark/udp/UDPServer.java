package me.mark.udp;
import java.net.*;

//https://systembash.com/a-simple-java-udp-server-and-udp-client/

class UDPServer {
   public static void main(String args[]) throws Exception {
         @SuppressWarnings("resource")
		DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            while(true) {
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
                  System.out.println("RECEIVED: " + new String(receivePacket.getData()));
               }
      }
}