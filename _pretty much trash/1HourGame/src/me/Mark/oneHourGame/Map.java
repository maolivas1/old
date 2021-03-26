package me.Mark.oneHourGame;

import java.util.ArrayList;

public class Map {
	
	static ArrayList<Integer> x = new ArrayList<Integer>();
	static ArrayList<Integer> y = new ArrayList<Integer>();
	
	public static void load() {
		
		add(x, 0);
		add(x, 730);
		
		add(y, 0);
		add(y, 956);
		
	}
	
	public static void add(ArrayList<Integer> type, int low) {
			type.add(low);
	}
	
}
