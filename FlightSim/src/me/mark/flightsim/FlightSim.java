package me.mark.flightsim;

import java.awt.FlowLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FlightSim {

	  static JFrame frame = new JFrame("Flight Simulatror!");
	  static JPanel panel = new JPanel();
	  static JLabel back = new JLabel();
	  ArrayList<JLabel> planes = new ArrayList<JLabel>();
	  static JLabel mine;
	
	public static void main(String[] args) {
		
		frame.getContentPane().add(panel);
		frame.setSize(1000, 800);
		frame.setVisible(true);
		frame.setLayout(new FlowLayout());
		frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
		
	    Kea.listen();
		Map.gen();
		
		Map.add("plane.png", 0, 500, 76, 76, mine);
		
		   try {
			frame.setIconImage(ImageIO.read(new File("images/plane.png")));
		} catch (IOException e) {}
	}
	  
		
	
	
}
