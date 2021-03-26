package me.mark.udp;
import java.net.*;

//https://systembash.com/a-simple-java-udp-server-and-udp-client/

class UDPClient {
	
   public static void main(String args[]) throws Exception {
	   byte[] bytes = new byte[2];
	   bytes[0] = 1; //Appears to be 0 or 1
	   bytes[1] = 32; //Appears to range from -100 to 100
	   send("192.168.5.130", 9876, bytes);
   }
   
   public static void send(String ip, int port, byte[] bytes) {
	   try {
	      DatagramSocket clientSocket = new DatagramSocket();
	      clientSocket.send(new DatagramPacket(bytes, bytes.length, InetAddress.getByName(ip), port));
	      clientSocket.close();
	   } catch (Exception e) {}
   }
   
}