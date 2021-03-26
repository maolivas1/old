package me.Mark.code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Tick {
	
	static ArrayList<String> list = new ArrayList<String>();
	
	
	public static void start() {
		  Main.panel.setFocusable(true);
		  Main.panel.requestFocusInWindow();
		
		  Main.panel.addKeyListener(new KeyListener() {
			 
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
          	 System.out.println(list);
           }
       });
		
		
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  //Player 1
			  
			  if (list.contains("87") && list.contains("68")) {//w and d (right kick)
				  Move.kick("right", "p1");
				  return;
			  }
			  
			  if (list.contains("87") && list.contains("65")) {//w and a (left kick)
				  Move.kick("left", "p1");
				  return;
			  }
			  
			  if (list.contains("87"))//w (stand)
				  Move.stand("p1");
			  
			  if (list.contains("83"))//s (sit)
				  Move.sit("p1");
				  
			  if (list.contains("65"))//a (move left)
				  Move.move("left", "p1");
			  
			  if (list.contains("68"))//d (move right)
				  Move.move("right", "p1");
			  
			  //Player 2
			  
			  if (list.contains("38") && list.contains("39")) {//up and right (right kick)
				  Move.kick("right", "p2");
				  return;  
			  }
			  
			  if (list.contains("38") && list.contains("37")) {//up and left (left kick)
				  Move.kick("left", "p2");
				  return;
			  }
			  
			  if (list.contains("38"))//up (stand)
				  Move.stand("p2");
			  
			  if (list.contains("40"))//down (sit)
				  Move.sit("p2");
			  
			  if (list.contains("37"))//left (move left)
				  Move.move("left", "p2");
			  
			  if (list.contains("39"))//right (move right)
				  Move.move("right", "p2");
		  }
		  }, 0, 2);
		  /*
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  if (Main.player.get("p1").getY() != Main.frame.getHeight() - 350)
				  Move.fix("p1");
			  
			  if (Main.player.get("p2").getY() != Main.frame.getHeight() - 350)
				  Move.fix("p2");
			  
		  }
		  }, 0, 500);
		  */
	}
	
	
	
	
}
