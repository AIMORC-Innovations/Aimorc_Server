package com.aimorc.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aimorc.registration.RegitrationException.UserNotFoundException;
import com.aimorc.registration.entity.User;
import com.aimorc.registration.service.UserService;

@RestController
@RequestMapping("/login")
@Validated
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/userlogin")
	public List<User> getusers() {
		return this.userService.getAllLoginInUsers();
	}

	@GetMapping("/userlogin/{userid}")
	public User findLoginUserById(@PathVariable("userid") Long userid) {
		return userService.findLoginById(userid);
	}

    @PostMapping("/userlogin")
    public User loginUser(@RequestBody User userToLogin){
        return userService.loginUser(userToLogin);
    }
       
	@PostMapping("/getuserid")
	public User getuserid(@RequestBody User login) throws UserNotFoundException {
		return this.userService.getuserid(login.getUsername())
				.orElseThrow(() -> new UserNotFoundException("User not found with this name: " + login.getUsername()));
	}
}
