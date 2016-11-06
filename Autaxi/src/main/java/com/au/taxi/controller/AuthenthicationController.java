package com.au.taxi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.au.taxi.dao.UserDao;
import com.au.taxi.model.User;
import com.au.taxi.request.AuthenthicationRequest;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/auth")
public class AuthenthicationController {
	
	@Autowired
	private UserDao userDao;
	
	@ApiOperation(value = "Validate username and password")
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public User login(@RequestBody AuthenthicationRequest request) {
		User user = userDao.findOneByUserIdAndPassword(request.getUsername(), request.getPassword());
		return user;
	}

}
