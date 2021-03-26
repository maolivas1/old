package me.Mark.AI;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Enumeration;
import java.util.Properties;

public class Data {
	
	public static void save(String data, String val) {
		File configFile = new File("config.properties");
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    props.setProperty(data, val);
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, null);
		    writer.close();
		} catch (Exception ex) {}
	}
	
	
	public static String  get(String get) {
		File configFile = new File("config.properties");
		String value = "";
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    
		    value = props.getProperty(get);
		    
		    reader.close();
		} catch (Exception ex) {}
		return value;
	}
	
	@SuppressWarnings("rawtypes")
	public static void load () {
		try {
			File configFile = new File("config.properties");
			 FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
	    Enumeration e = props.propertyNames();
	    while (e.hasMoreElements()) {
	      String key = (String)e.nextElement();
	      System.out.println(key + ": " + props.getProperty(key));
	    }
	    reader.close();
		} catch (Exception ex) {}
		
	}
	
	
}
