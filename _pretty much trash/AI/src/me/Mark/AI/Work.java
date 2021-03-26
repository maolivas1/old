package me.Mark.AI;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Work {
	
	
	public static String getTime() {
		String h = "am";
        
		int hr = Integer.parseInt(new SimpleDateFormat("HH").format(Calendar.getInstance().getTime()).toString());
		String min = new SimpleDateFormat("mm").format(Calendar.getInstance().getTime()).toString();
		
		if (hr > 12) {
			hr = hr - 12;
			h = "pm";
			}
		
		return hr + ":" + min + h;
	}
	
}
