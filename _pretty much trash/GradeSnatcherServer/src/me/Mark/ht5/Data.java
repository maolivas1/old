package me.Mark.ht5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Data {
	
	
	public static void add(String text) {
		try(FileWriter fw = new FileWriter("H:/Mark/Documents/NotifyMe/data.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			{
			    out.println(text);
			} catch (Exception e) {}
	}
	
	@SuppressWarnings("resource")
	public static boolean remove(String text) {
		boolean here = false;
		String all = null;
		try {
		BufferedReader br = new BufferedReader(new FileReader("H:/Mark/Documents/NotifyMe/data.txt"));
		    String line;
		    while ((line = br.readLine()) != null)
		    	if (!line.startsWith(text)) {
		    		if (all != null) all = all + "\n" + line;
		    		else all = line;
		    	 } else here = true;
		    
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("H:/Mark/Documents/NotifyMe/data.txt").getAbsoluteFile()));
			bw.write(all);
			bw.close();
		    
		} catch (Exception e) {}
		return here;
	}
	
}
