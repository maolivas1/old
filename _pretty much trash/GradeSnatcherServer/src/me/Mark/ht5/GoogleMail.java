package me.Mark.ht5;

import com.sun.mail.smtp.SMTPTransport;
import com.sun.net.ssl.internal.ssl.Provider;

import java.security.Security;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author doraemon
 */
public class GoogleMail {
    private GoogleMail() {
    }


    public static void send(String to, String title, String msg) {
		try {
			SendEmail(to, title, msg);
		} catch (MessagingException e) {}
    }
    
    public static void SendEmail(String recipientEmail, String title, String message) throws AddressException, MessagingException {
        GoogleMail.Send("markscodebot", recipientEmail, "", title, message);
    }

    public static void Send(final String username, String recipientEmail, String ccEmail, String title, String message) throws AddressException, MessagingException {
        Security.addProvider(new Provider());
        final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";

        // Get a Properties object
        Properties props = System.getProperties();
        props.setProperty("mail.smtps.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.port", "465");
        props.setProperty("mail.smtp.socketFactory.port", "465");
        props.setProperty("mail.smtps.auth", "true");

        props.put("mail.smtps.quitwait", "false");

        Session session = Session.getInstance(props, null);

        // -- Create a new message --
        final MimeMessage msg = new MimeMessage(session);

        // -- Set the FROM and TO fields --
        msg.setFrom(new InternetAddress(username + "@gmail.com"));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail, false));

        if (ccEmail.length() > 0) {
            msg.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail, false));
        }

        msg.setSubject(title);
        msg.setText(message, "utf-8");
        msg.setSentDate(new Date());

        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");

        t.connect("smtp.gmail.com", username, "SecretBotPassword");
        t.sendMessage(msg, msg.getAllRecipients());      
        t.close();
    }
}