package me.mark.flappy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Kea {
	
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void start() {
		  FlappyBordom.panel.setFocusable(true);
		  FlappyBordom.panel.requestFocusInWindow();
		
		  FlappyBordom.panel.addKeyListener(new KeyListener() {
			 
             @Override
             public void keyTyped(KeyEvent e) {}
             
             @Override
             public void keyReleased(KeyEvent e) {
            	 list.remove(String.valueOf(e.getKeyCode()));
             }

             @Override
             public void keyPressed(KeyEvent e) {
            	 if (!list.contains(String.valueOf(e.getKeyCode())))
            	 list.add(String.valueOf(e.getKeyCode()));
            	// System.out.println(String.valueOf(e.getKeyCode()));
             }
         });
	}
    
}
