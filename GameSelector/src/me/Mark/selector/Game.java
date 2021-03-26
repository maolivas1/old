package me.Mark.selector;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game {
	
	  static JFrame frame = new JFrame("");
	  static JPanel panel = new JPanel();
	
	  public static void main(String args[]) {
			frame.getContentPane().add(panel);
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		    frame.setUndecorated(true);
			
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        panel.setOpaque(true);
	        panel.setBackground(Color.WHITE);
	        panel.setLayout(null);
		
	        System.out.println("---------- Wii Games ----------");
	        list(new File("H:/Mark/Desktop/Game Stuffs/All Games/Wii"));
	        System.out.println("---------- N46 Games ----------");
	        list(new File("H:/Mark/Desktop/Game Stuffs/All Games/N64"));
	        System.out.println("---------- Gamecube Games ----------");
	        list(new File("H:/Mark/Desktop/Game Stuffs/All Games/Gamecube"));
	        
	        //Refresh
	        frame.validate();
	        frame.repaint();
	        
	        //Controls
	        Kea.start();
	        Tick.start();
	}
	  
	  //TODO Config
	  static int space = 20;
	  static int size = 150;
	  static Color borderColor = Color.green;
	  static int borderSize = 10;
	  
	  static int x = 0;
	  static int y = 0;
	  
	  public static void list(File folder) {
		    for (File fileEntry : folder.listFiles())
		        if (fileEntry.isDirectory()) list(fileEntry);
		        else {
		        	String name = fileEntry.getName().substring(0, fileEntry.getName().length() - 4);
		        	String file = fileEntry.getName().substring(0, fileEntry.getName().length());
		        	String path = "H:/Mark/Desktop/Game Stuffs/Covers/" + name + ".jpg";
		        	
		        	File f = new File(path);
					if(!(f.exists() && !f.isDirectory())) {
					    System.err.println("404: " + path);
					} else {
					System.out.println(x + " " + y + " " + name);
		        	add(path, file);
					}
					
		        }
		}
	  
	  static HashMap<String, String> gameFile = new HashMap<String, String>();
	  static HashMap<String, JLabel> loc  = new HashMap<String, JLabel>();
	  
		public static void add(String path, String file) {
			JLabel label = new JLabel();
		    label.setIcon(new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH)));
		    label.setSize(size, size);
		    label.setLocation(x * (size + space) + space, y * (size + space) + space);
		    panel.add(label);
		    
		    gameFile.put(x + "-" + y, file);
		    loc.put(x + "-" + y, label);
		    
        	if (++x * (size + space) > frame.getWidth() - (size + space)) {
        	x = 0;
        	y++;
        	}
		}
	
	
}
