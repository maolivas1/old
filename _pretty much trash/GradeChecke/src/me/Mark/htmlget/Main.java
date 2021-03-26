package me.Mark.htmlget;

import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
	
	public static void main(String args[]) throws IOException {
		  URL url = new URL("http://markstuff.net/grades");
		  URLConnection con = url.openConnection();
		  InputStream in = con.getInputStream();
		  String encoding = con.getContentEncoding();
		  encoding = encoding == null ? "UTF-8" : encoding;
		  
		  ByteArrayOutputStream baos = new ByteArrayOutputStream();
		  byte[] buf = new byte[8192];
		  int len = 0;
		  while ((len = in.read(buf)) != -1) {
		      baos.write(buf, 0, len);
		  }
		  String body = new String(baos.toByteArray(), encoding);
		  System.out.println(body);
		  
		  String[] lines = body.split("<div");
		  for(String line : lines) {
			  if (line.contains("%")) {
		      String percent = line.split("=\"")[1].split("<div>")[0].replace("\">", " ").replace("%", "");
		      System.out.println(percent);
			  }
		  }
		  Desktop.getDesktop().open(new File("H:\\Program Files\\Chrome\\Application\\chrome.exe"));
	  }
	
	//
	
}
