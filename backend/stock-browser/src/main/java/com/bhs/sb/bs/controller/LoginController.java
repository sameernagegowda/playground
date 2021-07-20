package com.bhs.sb.bs.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bhs.sb.bs.api.LoginApi;
import com.bhs.sb.bs.model.User;
import com.bhs.sb.bs.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@Controller
@CrossOrigin
public class LoginController implements LoginApi {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value = "/login", produces = { "application/json" }, method = RequestMethod.POST)
	public ResponseEntity<User> login(
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "email", required = true) String email,
			@NotNull @ApiParam(value = "", required = true) @Valid @RequestParam(value = "password", required = true) String password) {
		com.bhs.sb.bs.dao.User userDAO = userRepository.findUserByEmail(email);
		if (userDAO != null && userDAO.getPassword().equals(password)) {
			User user = new User();
			user.setName(userDAO.getName());
			user.setEmail(userDAO.getEmail());
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(new User(), HttpStatus.NOT_FOUND);
	}

}
