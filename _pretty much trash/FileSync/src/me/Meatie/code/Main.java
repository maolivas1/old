package me.Meatie.code;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
		
	  public static void main(String args[]) {
		  
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  File folder = new File("H:\\Mark\\Desktop\\public\\");
			  File[] listOfFiles = folder.listFiles();

			      for (int i = 0; i < listOfFiles.length; i++)
			        if (listOfFiles[i].isFile()) {
			          
					   	try {
					    	   File afile = listOfFiles[i];
					    	   if(afile.renameTo(new File("H:\\Mark\\Desktop\\webview\\" + afile.getName())))
						          System.out.println("File Moved! " + listOfFiles[i].getName());
					    	   else System.out.println("File is failed to move!");
					    	} catch(Exception e){}
			        }
			  
			  
		  }
		  }, 0, 1000);
	  }
		    
	  
}