package com.bhs.sb.bs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bhs.sb.bs.api.UserApi;
import com.bhs.sb.bs.dao.User;
import com.bhs.sb.bs.model.NewUser;
import com.bhs.sb.bs.repository.UserRepository;

import io.swagger.annotations.ApiParam;

@Controller
@CrossOrigin
public class UserController implements UserApi {

	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/user", produces = { "application/json" }, consumes = {
			"application/json" }, method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(
			@ApiParam(value = "New User object", required = true) @Valid @RequestBody NewUser newUser) {
		User user = new User();
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
		user = userRepository.save(user);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}	

}
