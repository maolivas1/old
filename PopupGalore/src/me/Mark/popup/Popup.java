package me.Mark.popup;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Popup {
	
	  public static void main(String args[]) throws IOException {
		  
		  new Timer().scheduleAtFixedRate(new TimerTask() {
		  public void run() {
			  
			  int num = ThreadLocalRandom.current().nextInt(1, 8 + 1);
			  int size = ThreadLocalRandom.current().nextInt(50, 300 + 1);
			  int x = ThreadLocalRandom.current().nextInt(0, (int) (Toolkit.getDefaultToolkit().getScreenSize().getWidth() + 1));
			  int y = ThreadLocalRandom.current().nextInt(0, (int) (Toolkit.getDefaultToolkit().getScreenSize().getHeight() + 1));
			  
		        JFrame frame = new JFrame();
		        frame.setUndecorated(true);
		        frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		        frame.setType(javax.swing.JFrame.Type.UTILITY);
		        
		        ImageIcon imageIcon = new ImageIcon("images/" + num + ".jpg");
		        Image image = imageIcon.getImage();
		        Image newimg = image.getScaledInstance(size, size,  Image.SCALE_SMOOTH);
		        imageIcon = new ImageIcon(newimg);
		        
		        frame.getContentPane().add(new JLabel(imageIcon));
		        
		        frame.pack();
		        frame.setLocation(x,y);
		        frame.setVisible(true);
		  }
		  }, 0, 5000);
	  }
}
