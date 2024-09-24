package vn.iostar.services.impl;



import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import vn.iostar.Models.UserModel;
import vn.iostar.dao.impl.UserDaoimpl;
import vn.iostar.services.IUserService;

public class UserServiceimpl implements IUserService {
	UserDaoimpl userDao = new UserDaoimpl();

	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {

		return userDao.findByUserName(username);
	}

	@Override
	public void insert(UserModel user) {
		userDao.insert(user);

	}

	@Override
	public UserModel register(String username, String email, String password) {

		userDao.insert(new UserModel(username, email, password));
		return null;

	}

	@Override
	public boolean send(String to, String subject, String password) {
		// Get properties object
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.host", sendEmail.HOST_NAME);
		props.put("mail.smtp.socketFactory.port", sendEmail.SSL_PORT);
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.port", sendEmail.SSL_PORT);

		// get Session
		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(sendEmail.APP_EMAIL, sendEmail.APP_PASSWORD);
			}
		});

		// compose message
		try {
			
			MimeMessage message = new MimeMessage(session);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Testing Subject");
			message.setText("123456");

			// send message
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

	public static void main(String[] args) {

		String to = "22110213@student.hcmute.edu.vn";
		String subject = "Thanh Cong";
		String mess = "";
		IUserService User = new UserServiceimpl();
		User.send(to, subject, mess);
	}

	
}
