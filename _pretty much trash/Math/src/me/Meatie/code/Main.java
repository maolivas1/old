package me.Meatie.code;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Main {
	
	  static JFrame frame = new JFrame("GPA Time");
	  static JPanel panel = new JPanel();
	  
		static JLabel one_ = new JLabel("Class 1");
		static JTextField one = new JTextField(2);
		
		static JLabel two_ = new JLabel("Class 2");
		static JTextField two = new JTextField(2);
		
		static JLabel three_ = new JLabel("Class 3");
		static JTextField three = new JTextField(2);
		
		static JLabel four_ = new JLabel("Class 4");
		static JTextField four = new JTextField(2);
		
		static JLabel five_ = new JLabel("Class 5");
		static JTextField five = new JTextField(2);
		
		static JLabel six_ = new JLabel("Class 6");
		static JTextField six = new JTextField(2);
		
		static JButton button = new JButton("Math!");
		
	  public static void main(String args[]) {
		  
		    frame.getContentPane().add(panel);
			frame.setSize(110, 230);
			frame.setVisible(true);
			frame.setLayout(new FlowLayout());
			frame.setLocationRelativeTo(null);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		    
		    
			frame.add(one_);
		    frame.add(one);
		    
			frame.add(two_);
		    frame.add(two);
		    
			frame.add(three_);
		    frame.add(three);
		    
			frame.add(four_);
		    frame.add(four);
		    
			frame.add(five_);
		    frame.add(five);
		    
			frame.add(six_);
		    frame.add(six);
		    
		    frame.add(button);
		    
		    one.setText("82");
		    two.setText("92");
		    three.setText("93");
		    four.setText("85");
		    five.setText("79");
		    six.setText("");
		    
		    button.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  math();
		      }
		    });
		    
		    math();
	  }
	  
	  //GPA Calculator
	  
	  public static void math() {
		  if (!(isNum(one.getText()) && isNum(two.getText()) && isNum(three.getText()) && isNum(four.getText()) && isNum(five.getText()))) {
			  System.out.println("Put Numbers In All The Things");
			  return;
		  }
		  
		  int num = Integer.valueOf(one.getText());
		  //int c2 = Integer.valueOf(two.getText());
		  //int c3 = Integer.valueOf(three.getText());
		  //int c4 = Integer.valueOf(four.getText());
		  //int c5 = Integer.valueOf(five.getText());
		  //int c6 = Integer.valueOf(six.getText());
		  
		  
		  double solve = num;
		  
		  
		  //d=2r
		  //π=d/c
		  
		  //π=2r/c
		  
		  
		  

		  
		  
		  
		  System.out.println(solve);
	  }
	  
	  
	  public static boolean isNum(String str) {
	      try { 
	          Integer.parseInt(str);
	     } catch (NumberFormatException e) {
	         return false;
	     }
	      return true;
	  }
		
		    
	  
}