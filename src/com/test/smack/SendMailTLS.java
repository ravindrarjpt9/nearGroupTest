package com.test.smack;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMailTLS {

	public static void main(String[] args) {

		final String username = "prashant@neargroupapp.com";
		final String password = "Khelo12345";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "465");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {
			
			
			 
			  
			  
			StringBuffer stb = new StringBuffer();
			   stb.append("<html><body><font  face=\"Verdana\" size = \"2\"><br>");
			  stb.append("Hi Ravindra,<p><p>");
			  stb.append("Welcome! We have put a lot of time and effort into building <b>NearGroup</b>, an app which connects Neighbours.").append("<p>").
			  append("Using NearGroup you can find nearby-people who are interested in: sports, fitness, carpool, flatmate, volunteering, parenting, seeking local-advice, networking and much much more.");
			  stb.append("<p>We know NearGroup is not perfect, we launched it very recently. As you play around with it could please share your thoughts, feedback and suggestion? <b>You can do so by just replying to this email.</b>");
			  stb.append("<p>And please do spread the word about our app. Do tell your friends and neighbours. They can download it by visiting <a href=\"http://get.neargroup.in\">get.neargroup.in</a>");
			  stb.append("<p>Regards,<br>").append("Prashant Pitti<br>").append("IIT Madras Alumni<br>Co founder - <a href=\"http://neargroup.in\">NearGroup</a><br>");
			  stb.append("</body></html>");
			  			  
			  
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("prashant@neargroupapp.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("ravindrarjpt9@gmail.com"));
			message.setSubject("Hello, from NearGroup. Connecting Neighbours‏");
			message.setText(stb.toString());
			message.setHeader("X-Mailer", "Email");
			message.setContent(stb.toString(), "text/html");
		      message.setSentDate(new Date());
			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
}
