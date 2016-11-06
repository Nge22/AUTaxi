package com.au.taxi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.au.taxi.dao.UserDao;
import com.au.taxi.model.User;
import com.google.common.collect.Lists;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserDao userDao;
	
	
	@ApiOperation(value = "Get users by name")
	@RequestMapping(value="/name",method=RequestMethod.GET)
	public List<User> getUsersByName(@RequestParam(value="name",required=true) String name) {

		return userDao.findAllByNameContaining(name);
	}
	
	@ApiOperation(value = "Delete a user")
	@RequestMapping(value="/{userId}",method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable("userId") String userId) {
		userDao.delete(userId);
	}


	@ApiOperation(value = "Update a user")
	@RequestMapping(value="/{userId}",method=RequestMethod.PUT)
	public User updateUser(@PathVariable("userId") String userId,@RequestBody User user) {
		User databaseUser = userDao.findOne(userId);
		if(databaseUser == null){
			return null;
		}
		databaseUser.setEmail(user.getEmail());
		databaseUser.setName(user.getName());
		databaseUser.setPhoneNumber(user.getPhoneNumber());
		databaseUser.setLastName(user.getLastName());

		userDao.save(databaseUser);
		return databaseUser;
	}

	@ApiOperation(value = "Add new user")
	@RequestMapping(method=RequestMethod.POST)
	public User createUser(@RequestBody User user) {
		userDao.save(user);
		return user;
	}

	@ApiOperation(value = "Get all users")
	@RequestMapping(method=RequestMethod.GET)
	public List<User> getAllUsers() {
		Iterable<User> listUsers = userDao.findAll();

		return Lists.newArrayList(listUsers);
	}

	@ApiOperation(value = "Get one user")
	@RequestMapping(value="/{userId}",method=RequestMethod.GET)
	public User getOneUser(@PathVariable("userId") String userId) {
		User user = userDao.findOne(userId);

		return user;
	}
}
