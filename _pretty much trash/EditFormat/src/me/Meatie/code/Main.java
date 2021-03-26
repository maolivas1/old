package me.Meatie.code;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;


public class Main {
	
	  static JFrame frame = new JFrame("Fixie Thing");
	  
	  public static void main(String args[]) {
		  
			frame.setSize(100, 100);
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        File[] listOfFiles = new File("H:/Mark/Desktop/Music/Skrillex").listFiles();
	        for (int i = 0; i < listOfFiles.length; i++)
	        if (listOfFiles[i].isFile()) {
	        System.out.println(listOfFiles[i].getName());
	        try {
				Files.copy(listOfFiles[i].toPath(), Paths.get("H:/Mark/Desktop/Music/new/" + listOfFiles[i].getName().substring(3).replaceAll("\\(.*?\\)","").replaceAll("-", " ").replaceAll("_", " ")));
			} catch (IOException e) {}
	      }
	        
	        }
	  
}