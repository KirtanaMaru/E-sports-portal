package app.com.utility;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;

import app.com.pojos.Event;

public class NotifactionSender {
	public void sendEmail(String to,Event event) {
		
		System.out.println("in TLS EMAIL");
		final String fromEmail = "mgmalumninetwork@gmail.com"; //requires valid gmail id
		final String password = "ridoshcqhooytulg"; // correct password for gmail id
		final String toEmail = to; // can be any email id 
		String msgbody="Dear user the new Sport event is waiting for you please find Event details below Title :"+event.getTitle()+" Sport :"+event.getSport()+" Date :"+event.getDate()+" Location :"+event.getLocation()+" Contact Details: "+event.getMobile();
		System.out.println("TLSEmail Start");
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com"); //SMTP Host
		props.put("mail.smtp.port", "587"); //TLS Port
		props.put("mail.smtp.auth", "true"); //enable authentication
		props.put("mail.smtp.starttls.enable", "true"); //enable STARTTLS
		
                //create Authenticator object to pass in Session.getInstance argument
		Authenticator auth = new Authenticator() {
			//override the getPasswordAuthentication method
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		};
		Session session = Session.getInstance(props, auth);
		
		EmailUtil.sendEmail(session, toEmail,"E-Sport Portal New Notifaction", msgbody);
		
	}

	
}

