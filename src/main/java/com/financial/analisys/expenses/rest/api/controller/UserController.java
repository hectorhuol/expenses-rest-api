package com.financial.analisys.expenses.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	public UserBO createUser(@RequestBody UserBO user) {
		return userService.createUser(user);
	}

	@RequestMapping(path = "/user", method = RequestMethod.PUT)
	public void updateUser(@RequestBody UserBO user) {
		userService.updateUser(user);
	}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable String id) {
		userService.deleteUser(id);
	}

	@RequestMapping(path = "/user/{id}", method = RequestMethod.GET)
	public UserBO getUser(@PathVariable String id) {
		return userService.getUser(id);
	}

	@RequestMapping(path = "/user", method = RequestMethod.GET)
	public List<UserBO> getAllUsers() {
		return userService.getAllUsers();
	}
}
