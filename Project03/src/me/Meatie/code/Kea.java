package me.Meatie.code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Kea {
	
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void start() {
		  Main.panel.setFocusable(true);
		  Main.panel.requestFocusInWindow();
		
		  Main.panel.addKeyListener(new KeyListener() {
			 
             @Override
             public void keyTyped(KeyEvent e) {}
             
             @Override
             public void keyReleased(KeyEvent e) {
            	 list.remove(String.valueOf(e.getKeyChar())); 
             }

             @Override
             public void keyPressed(KeyEvent e) {
            	 if (!list.contains(String.valueOf(e.getKeyChar())))
            	 list.add(String.valueOf(e.getKeyChar()));
             }
         });
		 
	}
    
}
