package util;


import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	//Email: tdemoch0712@gmail.com
	//Password: lbdfhdspmyqmlnkx
	
	
	public static void sendEmail(String receiver, String subject,String content) {
		final String from = "tdemoch0712@gmail.com";
		final String password = "lbdfhdspmyqmlnkx";
		
		//Properties : khai báo các thuộc tính
				Properties props = new Properties();
				props.put("mail.smtp.host", "smtp.gmail.com");
				
				//TLS: 587
				//SSL: 465
				props.put("mail.smtp.port", "587");
				
				//Bật xác thực
				props.put("mail.smtp.auth", "true");
				
				//Bật TLS
				props.put("mail.smtp.starttls.enable", "true");
				
				// create Authenticator
				Authenticator auth = new Authenticator() {

					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						// TODO Auto-generated method stub
						return new PasswordAuthentication(from,password);
					}
						
						
				};
				
				//Tạo phiên làm việc
				Session session = Session.getInstance(props,auth);
				
				//Tạo một tin nhắn
				MimeMessage msg = new MimeMessage(session);
				
				try {
					//Khai báo kiểu nội dung
					msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
					
					//Khai báo người gửi
					msg.setFrom(from);
					
					//Khai báo người nhận
					msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(receiver,false));
					
					// Tiêu đề email
					msg.setSubject(subject);
					
					// Quy địnhg ngày gửi
					msg.setSentDate(new Date());
					
					//Quy định email nhận phản hồi
					//msg.setReplyTo(InternetAddress.parse(from,false));
					
					//Nội dung
					//msg.setText("Đây là phần nội dung","UTF-8");
					
					msg.setContent(content, "text/HTML; charset=UTF-8");
					
					//Gửi email
					Transport.send(msg);
					
					System.out.println("Email sent");
				} catch (MessagingException e) {
					System.out.println("Something wrong");
					e.printStackTrace();
				}
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		String receiver = "maisonhai456@gmail.com";
		String header = "ALERT";
		String content = "<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "\r\n"
				+ "<body>\r\n"
				+ "    <h1>Hi phuong</h1>\r\n"
				+ "    <p>Your data has been leaked. It's in our hand right now !</p>\r\n"
				+ "    <h2>This is your face id</h2>\r\n"
				+ "    <img src=\"https://image.lag.vn/upload/news/21/04/09/0_YJTL.jpeg\" height=\"300\" width=\"200\" style=\"border: 0;\">\r\n"
				+ "    <p>Please contact us through <a href=\"https://www.facebook.com/profile.php?id=100024965899954\">here</a>. If you\r\n"
				+ "        want\r\n"
				+ "        your data back\r\n"
				+ "    </p>\r\n"
				+ "    <strong>Enjoy the day !</strong>\r\n"
				+ "</body>\r\n"
				+ "\r\n"
				+ "</html>";		
		sendEmail(receiver, header, content);
//		for(int i = 0; i<5; i++) {
//			
//		}
		
		
		
		
	}
	
}
