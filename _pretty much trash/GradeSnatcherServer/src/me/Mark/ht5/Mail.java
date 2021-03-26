package me.Mark.ht5;

public class Mail {

	
	public static void verify(String email, String user, String code) {
		
		String msg = "Vefify you signed up for Grade Notifications at Markstuff.net\n" +
		              "Aeries Username: " + user + "\n" +
		              "Click to verify: http://markstuff.net/verify?code="  + code + "\n" +
		              "\n" + 
		              "If you didn't signup for this please ignore this email";
		GoogleMail.send(email, "Verify Signup - Markstuff.net", msg);
	}
	
	public static void update(String email, String user, String teacher, String period, String subject, int grade, int lastGrade) {
		String msg = "";
		if (grade > lastGrade) {
		msg = "You're grade in " + teacher + "'s period " + period + " " + subject + " class has incresed to " + grade + "\n" +
		              "You're Grade was " + lastGrade + "\n" +
		              "Incresed" + (grade + lastGrade) + "\n";
		} else {
		msg = "You're grade in " + teacher + "'s period " + period + " " + subject + " class has decresed to " + grade + "%\n" +
		              "You're Grade was " + lastGrade + "\n" +
		              "Decresed" + (grade + lastGrade) + "%\n";
		}
		msg = msg + "\nIf you would like to unsubscribe from these emails please click here: http://markstuff.net/unsubscribe?code=" + user;
		GoogleMail.send(email, "Grade Update - Markstuff.net", msg);
	}
	
	public static void failed(String email, String user) {
		String msg = "Unable to sign in to you're Aeries acccount\n" +
		              "Aeries Username: " + user + "\n" +
		              "Please fill out this fourm again with correct Aeries login: http://markstuff.net/notify";
		GoogleMail.send(email, "Verify Signup - Markstuff.net", msg);
	}
	
}
