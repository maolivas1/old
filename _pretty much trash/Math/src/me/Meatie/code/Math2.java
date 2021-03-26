package me.Meatie.code;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Math2 {
	
	  static JFrame frame = new JFrame("Graph Time");
	  static JPanel panel = new JPanel();
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(1000, 800);
			//frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			//frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    //frame.setResizable(false);
		    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		    
		    int x = 0;
		    String eq = "x * 2";
		   
		    try {
				while (x < 800 && Integer.valueOf(String.valueOf(new ScriptEngineManager().getEngineByName("JavaScript").eval(eq.replace("x", String.valueOf(x)))).replace(".0", "")) < 1000 && Integer.valueOf(String.valueOf(new ScriptEngineManager().getEngineByName("JavaScript").eval(eq.replace("x", String.valueOf(x)))).replace(".0", "")) > -1000) {
					
				    int solve = Integer.valueOf(String.valueOf(new ScriptEngineManager().getEngineByName("JavaScript").eval(eq.replace("x", String.valueOf(x)))).replace(".0", ""));
					
				    if (eq.contains("-x")) x = x + 1;
				    else x = x - 1;
					add(x, solve);
					//System.out.println(x + " " + solve);
				}
			} catch (NumberFormatException e1) {e1.printStackTrace();} catch (ScriptException e1) {e1.printStackTrace();}
		    
		    
		   try {
			frame.setIconImage(ImageIO.read(new File("pixel.png")));
		} catch (IOException e) {}
	  }
	  
	  
		public static void add(final int x, final int y) {
			final ImageIcon icon = new ImageIcon("pixel.png");
			final JLabel item = new JLabel();
			 Math2.frame.add(item);
			 
			  new Timer().schedule(new TimerTask() {
			  public void run() {
			item.setLocation(x + frame.getWidth() / 2, y + frame.getHeight() / 2);
			item.setIcon(new ImageIcon(icon.getImage().getScaledInstance(10, 10, java.awt.Image.SCALE_SMOOTH)));
			  }
			  }, 0, 1); 
		}
		
		    
	  
}