package com.example.signup.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.signup.dto.LoginDto;
import com.example.signup.dto.UserDto;
import com.example.signup.service.UserService;
@RestController

public class UserController {
	
	@Autowired
	 private UserService userService;

	    public UserController(UserService userService) {
	        this.userService = userService;
	    }


	    // handler method to handle user registration request


	    // handler method to handle register user form submit request
	    @PostMapping("/register")
	    public ResponseEntity<UserDto> saveAllowanc(@RequestBody UserDto userDto) {
	        userService.saveUser(userDto);
	        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
	    }

//	    @GetMapping("/register/{emailId}")
//	    public ResponseEntity<UserDto> getUser(@PathVariable("emailId") String emailId) {
//	        UserDto alluser = this.userService.signupByEmail(emailId);
//	        ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//	        return ResponseEntity.of(Optional.of(alluser));
//	    }

	    @PostMapping("/login")
	    public String login(@RequestBody LoginDto loginDto) {
	        String msg = this.userService.login(loginDto);

	        return msg;
	                //ResponseEntity(HttpStatus.FOUND, HttpStatus.valueOf(msg));
	        // return new ResponseEntity<>(loginDto1, HttpStatus.ACCEPTED);


	    }
}


