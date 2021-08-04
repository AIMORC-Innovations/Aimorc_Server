package com.LoginRegistration.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.LoginRegistration.Exception.UserNotFoundException;
import com.LoginRegistration.Repository.LoginRepository;
import com.LoginRegistration.entity.JwtResponse;
import com.LoginRegistration.entity.Login;
import com.LoginRegistration.entity.Password;
import com.LoginRegistration.entity.Profile;
import com.LoginRegistration.entity.Userdata;
import com.LoginRegistration.helper.JWTUtil;
import com.LoginRegistration.services.LoginServices;
import com.google.gson.Gson;

@Controller
@CrossOrigin("*")
public class LoginController {

	@Autowired
	private JWTUtil jwtutil;

	@Autowired
	private AuthenticationManager authenicationManager;

	@Autowired
	private LoginServices loginServices;

	@Autowired
	private LoginRepository loginRepo;

	String sessionusername;

	@PostMapping("/getUserId")
	@ResponseBody
	public int getUserId(@RequestBody String username) {
		return this.loginServices.getUserId(username);

	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	@ResponseBody
	@Transactional
	public ResponseEntity<?> generateToken(@RequestBody Login login, HttpServletRequest response) throws Exception {
		System.out.println(login);
		this.authenicationManager
				.authenticate(new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword()));
		UserDetails userdetails = this.loginServices.loadUserByUsername(login.getUsername());
		String token = this.jwtutil.generateToken(userdetails);
		String username = (String) decodeToken(token);
		loginRepo.updateLastLogin(username, login.getLastlogin());
		return ResponseEntity.ok(new JwtResponse(token));
	}

	@PostMapping("/newUserRegistration")
	public void registeruser(@RequestBody Userdata newuser, HttpServletResponse response)
			throws UserNotFoundException, IOException {
		if (loginServices.registeruser(newuser)) {
			response.setStatus(200);
		} else {
			response.sendError(401, "Invalid Authenication");
			System.out.println("Invalid Authenication");
		}
	}

	@PostMapping("/forgotPassword")
	public void getIdAndAns(@RequestBody Password fp, HttpServletResponse response)
			throws UserNotFoundException, ServletException, IOException {
		if (loginServices.getIdAndAns(fp.getUsername(), fp.getSecurity_id(), fp.getSecurity_answer())) {
			response.setStatus(200);
		} else {
			response.sendError(401, "Invalid Authenication");
			System.out.println("Invalid Authenication");
		}
	}

	@PostMapping("/setPassword")
	public ResponseEntity<String> setpassword(@RequestBody Password password, HttpServletRequest request) {
		return this.loginServices.setpassword(password);
	}

	@PostMapping("/getSecurityIdAndAns")
	public void getSecurityIdAndAns(@RequestBody Password fp, HttpServletRequest request, HttpServletResponse response)
			throws UserNotFoundException, IOException {
		Object tokenUsername = decodeToken(fp.getToken());
		fp.setUsername((String) tokenUsername);
		if (loginServices.getSecurityIdAndAns(fp)) {
			response.setStatus(200);
		} else {
			response.sendError(401, "Invalid Authenication");
			System.out.println("Invalid Authenication");
		}
	}

	@PostMapping("/updatePassword")
	public ResponseEntity<String> updatePassword(@RequestBody Password password, HttpServletRequest request) {
		Object tokenUsername = decodeToken(password.getToken());
		if (password.getToken() != null) {
			password.setUsername((String) tokenUsername);
			return this.loginServices.updatePassword(password);
		}
		return new ResponseEntity<String>("Password entered already exist!", HttpStatus.OK);
	}

	@PostMapping("/decodeToken")
	@ResponseBody
	public Object decodeToken(@RequestBody String token) {
		Base64.Decoder decoder = Base64.getDecoder();
		String[] chunks = token.split("\\.");
		String header = new String(decoder.decode(chunks[0]));
		String payload = new String(decoder.decode(chunks[1]));
		Map<String, Object> map = new Gson().fromJson(payload, Map.class);
		Object output = null;
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			if (entry.getKey().equals("sub")) {
				output = entry.getValue();
			}
		}
		return output;
	}

	@PostMapping("/profile")
	@ResponseBody
	public Profile getProfileDetails(@RequestBody JwtResponse jwtresponse, HttpServletResponse response)
			throws UserNotFoundException, IOException {
		Object tokenUsername = decodeToken(jwtresponse.getToken());
		Profile profiledetails = loginServices.getProfileDetails((String) tokenUsername);
		return profiledetails;
	}

	@PostMapping("/updateProfileDetails")
	@ResponseBody
	public ResponseEntity<String> updateuserdetails(@RequestBody Profile profile, HttpServletRequest request)
			throws UserNotFoundException {
		Object tokenUsername = decodeToken(profile.getToken());
		profile.setUsername((String) tokenUsername);
		return this.loginServices.updateuserdetails(profile);
	}

}
