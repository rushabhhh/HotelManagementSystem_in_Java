import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;


public class SendEmail {
   SendEmail() {
        // Your Gmail username and password
        String username = "rushabhrathod018@gmail.com";
        String password = "jzqd efmk jneg xklc";

        // Enable TLS and set the SMTP server host and port
        Properties properties = new Properties();
        properties.setProperty("mail.smtp.starttls.enable", "true");
        String host = "smtp.gmail.com";
        int port = 587; // Use the TLS port
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.smtp.port", String.valueOf(port));

        // Set authentication
        properties.setProperty("mail.smtp.auth", "true");

        // Create a session with your Gmail account
        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Create a MimeMessage
            MimeMessage message = new MimeMessage(session);

            // Set From, To, Subject, and Text
            message.setFrom(new InternetAddress(username));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(UserDetail.emailtf.getText()));
            message.setSubject("Your Booking Details");
            message.setText("Name : "  + HotelBilling.billusernametf.getText() +"\nCheckin date : " +HotelBilling.checkindatetf.getText() + "\nCheckoutdate : " +HotelBilling.checkoutdatetf.getText()+ "\nCheckin Time : "+HotelBilling.checkintimetf.getText() +  "\nBill : " + HotelBilling.totaltf.getText() );

            // Send email
            Transport.send(message);
            System.out.println("Mail successfully sent");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
