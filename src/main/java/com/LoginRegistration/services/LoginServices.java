package com.LoginRegistration.services;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Optional;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.Repository.LoginRepository;
import com.LoginRegistration.Repository.RegisterRepository;
import com.LoginRegistration.entity.Password;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Profile;
import com.LoginRegistration.entity.Register;
import com.LoginRegistration.entity.Userdata;

@Service
public class LoginServices implements UserDetailsService {

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private RegisterRepository registerRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Login> logins = this.loginRepository.findByUsername(username);
		if (logins.get().getUsername().equals(username)) {
			String str = logins.get().getPassword();
			Base64.Decoder decoder = Base64.getDecoder();
			String dStr = new String(decoder.decode(str));
			  new ResponseEntity<String>("Success",HttpStatus.OK);
			return new User(logins.get().getUsername(), dStr, new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found");
		}
	}

	public int getUserId(String username) {
		int userid = loginRepository.findByUsername(username).get().getUserid();
		return userid;
	}

	public static String getEncodedString(String password) {
		String encrytedpassword = Base64.getEncoder().encodeToString(password.getBytes());
		return encrytedpassword;
	}

	@Transactional
	public boolean getUserDetails(String username, String password) throws UserNotFoundException {
		String encryptedpassword = getEncodedString(password);
		Login login = new Login();
		Optional<Login> logins = this.loginRepository.findByUsername(username);
		loginRepository.findByUsernameAndPassword(username, encryptedpassword);
		if (logins.get().getUsername().equals(username)
				&& logins.get().getPassword().toString().equalsIgnoreCase(encryptedpassword)) {
			// login.setLastlogin(lastlogin);
			// this.loginRepository.updateLastLogin(username, lastlogin);
		
			return true;
		} else {
		
			return false;
		}
	}

	public boolean getIdAndAns(String username, int security_id, String security_answer) throws UserNotFoundException {
		int userid = loginRepository.findByUsername(username).get().getUserid();
		Register register = registerRepository.findById(userid);
		Register security = new Register();
		security.setSecurity_id(register.getSecurity_id());
		security.setSecurity_answer(register.getSecurity_answer());
		if (register.getSecurity_id() == security_id && register.getSecurity_answer().equals(security_answer)) {
			return true;
		}
		return false;
	}

	@Transactional
	public ResponseEntity<String> setpassword(Password password) {
		Optional<Login> logins = this.loginRepository.findByUsername(password.getUsername());
		String encryptedpassword = getEncodedString(password.getNewpassword());
		loginRepository.updatePassword(password.getUsername(), encryptedpassword);
			return new ResponseEntity<String>("Password updated succesfully", HttpStatus.OK);
		}
		

	public boolean getSecurityIdAndAns(Password fp) {
		int userid = loginRepository.findByUsername(fp.getUsername()).get().getUserid();
		Register register = registerRepository.findById(userid);
		Register security = new Register();
		security.setSecurity_id(register.getSecurity_id());
		security.setSecurity_answer(register.getSecurity_answer());
		if (register.getSecurity_id() == fp.getSecurity_id()
				&& register.getSecurity_answer().toString().equalsIgnoreCase(fp.getSecurity_answer()))
     return true;
return false;
	}

	@Transactional
	public ResponseEntity<String> updatePassword(Password password) {
		Optional<Login> userid = this.loginRepository.findByUsername(password.getUsername());
		String encryptedoldpassword = getEncodedString(password.getOldpassword());
		String encryptednewpassword = getEncodedString(password.getNewpassword());
		if (userid.get().getPassword().toString().equals(encryptedoldpassword)) {
			loginRepository.updatePassword(password.getUsername(), encryptednewpassword);
			return new ResponseEntity<String>("Password updated succesfully", HttpStatus.OK);
		}
		if (encryptedoldpassword.toString().equals(encryptednewpassword)) {
			return new ResponseEntity<String>("Old password is same as new password! give some different password",
					HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("Check Credentials and update!", HttpStatus.BAD_REQUEST);

	}

	public Profile getProfileDetails(String sessionusername) throws UserNotFoundException {
		int userid = loginRepository.findByUsername(sessionusername).get().getUserid();
		Register register = registerRepository.findById(userid);
		Profile profile = new Profile();
		profile.setFirstname(register.getFirstname());
		profile.setLastname(register.getLastname());
		profile.setDob(register.getDob());
		profile.setPhonenum(register.getPhonenum());
		profile.setGender(register.getGender());
		profile.setAddress(register.getAddress());
		return profile;
	}

	@Transactional
	public ResponseEntity<String> updateuserdetails(Profile profile) {
		int userid = loginRepository.findByUsername(profile.getUsername()).get().getUserid();
		registerRepository.updateDetails(profile.getFirstname(), profile.getLastname(), profile.getDob(),
				profile.getGender(), profile.getPhonenum(), profile.getAddress(), userid);
		return new ResponseEntity<String>("Details updated succesfully", HttpStatus.OK);

	}

	public boolean registeruser(Userdata newuser) {
		Login login = new Login();
		Register register = new Register();
		String statusMessage = "";
		statusMessage = "User Succecssfully registered!";
		String message = "Welcome from AIMORC Innovations, You are Successfully registered for our Portal. Thank you!";
		String subject = "Confirm Registration";
		String from = "aimorc.ecomm@gmail.com";
		String encryptedpassword = getEncodedString(newuser.getPassword());
		Optional<Login> existingusername = loginRepository.findByUsername(newuser.getUsername());
		login.setUsername(newuser.getUsername());
		login.setPassword(encryptedpassword);
		login.setLastlogin(newuser.getCreated_on());
		if (login.getUsername().equals(existingusername)) {
			new ResponseEntity<String>("User already exists Please Login!", HttpStatus.ACCEPTED);
			return false;
		}
		loginRepository.save(login);
		int userid = getUserId(login.getUsername());
		System.out.println(userid);
		register.setUserid(userid);
		register.setFirstname(newuser.getFirstname());
		register.setLastname(newuser.getLastname());
		register.setDob(newuser.getDob());
		register.setGender(newuser.getGender());
		register.setPhonenum(newuser.getPhonenum());
		register.setAddress(newuser.getAddress());
		register.setCreated_on(newuser.getCreated_on());
		register.setSecurity_id(newuser.getSecurity_id());
		register.setSecurity_answer(newuser.getSecurity_answer());
		registerRepository.save(register);
		sendEmail(message, subject, login.getUsername(), from);
		new ResponseEntity<String>("success!", HttpStatus.ACCEPTED);
		return true;
	}

	private static void sendEmail(String message, String subject, String username, String from) {
		// variable for gmail
		String host = "smtp.gmail.com";
		// get system properties
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");// for security
		properties.put("mail.smtp.auth", "true");
		// for aunthenication //gettingSession object
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("aimorc.ecomm@gmail.com", "AIMORC@15");
			}

		});
		session.setDebug(true);
		// compose message
		MimeMessage mimemessage = new MimeMessage(session);
		try {
			// from email
			mimemessage.setFrom(from);
			// recepient email
			mimemessage.addRecipient(Message.RecipientType.TO, new InternetAddress(username));
			// adding subject to message
			mimemessage.setSubject(subject); // adding textmessage
			mimemessage.setText(message);
			// send
			Transport.send(mimemessage);
			System.out.println("Sent successfully...........");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
