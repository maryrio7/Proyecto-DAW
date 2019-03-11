package paquete1.in;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {
	private String userEmail;
	private String myHash;
	
	public SendingEmail(String userEmail, String myHash) {
		this.userEmail = userEmail;
		this.myHash = myHash;
	}
	public void sendMail() {
		String email = "mariodaw2019@gmail.com";
		String pword = "practicas";
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.con");
		properties.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, pword);
			}
		});
		
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("Mario practica - Email Verification Link");
			message.setText("Link de verificación...");
			message.setText("Tu link de verificación: "+"http://localhost:8084/Email_verification/ActivateAccount?key1="+userEmail+"?key2="+myHash);
			Transport.send(message);
		
		} catch (Exception ex) {
			System.out.println("SendingEmail "+ex);
		}
	}
	
}
