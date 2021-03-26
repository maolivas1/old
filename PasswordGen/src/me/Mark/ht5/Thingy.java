package me.Mark.ht5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.java_websocket.WebSocket;

public class Thingy {
	
	public static void stuff(WebSocket conn, String msg) throws IOException {
		Main.chat(msg);
		String url = "https://www.whois.com/whois/" + msg;
		String date = getDate(url);
		Main.chat("Date: " + date);
		conn.send(date);
		String phase = getPhase(date);
		Main.chat("Phase: " + phase);
		conn.send(phase);
		String debt = getDebt(date);
		Main.chat("Debt: " + debt);
		conn.send(debt);
	}
	
	public static String getDate(String url) {
		String data = fetch(url, "Registration Date:");
		int i = data.indexOf("Registration Date:");
		String date = data.substring(i + 46, i + 56);
		return date;
	}
	
	public static String getPhase(String date) {
		String month = date.substring(5, 7);
		String day = date.substring(9, 10);
		String year = date.substring(0, 4);
		String link = "http://www.moonpage.com/index.html?go=T&auto_dst=T&tzone=pt&hour=0&min=0&sec=0&m=" + month + "&d=" + day +"&y=" + year;
		String data = fetch(link, "<h3>");
		String phase = data.substring(4, 9);
		return phase;
	}
	
	public static String getDebt(String date) {
		String month = date.substring(5, 7);
		String day = date.substring(9, 10);
		String year = date.substring(0, 4);
		String link = "https://treasurydirect.gov/NP/debt/search?startMonth=" + month + "&startDay=" + day + "&startYear=" + year;
		String debt = fetch(link, "<td a");
		int i = debt.indexOf(">");
		int n = debt.indexOf("</td>");
		debt = debt.substring(i + 1, n);
		return debt;
	}
	
	@SuppressWarnings("resource")
	private static String fetch(String urll, String thing) {
		try {
		    URL url;
		    InputStream is = null;
		    BufferedReader br;
		    String line;

		    try {
		        url = new URL(urll);
		        is = url.openStream();
		        br = new BufferedReader(new InputStreamReader(is));

		        while ((line = br.readLine()) != null) {
		        	 System.out.println(line);
		        	if (line.contains(thing)) {
		        		if (thing == "<td a") {
		        		if (line.contains(",")) {
		        		return line;
		        		}
		        		} else return line;
		        	}
		           
		        }
		    } catch (MalformedURLException mue) {	
		         mue.printStackTrace();
		    } catch (IOException ioe) {
		         ioe.printStackTrace();
		    } finally { try { if (is != null) is.close();
		    } catch (IOException ioe) {}
		    }
		} catch (Exception e) {Main.chat("" + e);}
		return "error";
    }
	
	public static void send(WebSocket user, String msg) {
		user.send(msg);
	}
	
}
