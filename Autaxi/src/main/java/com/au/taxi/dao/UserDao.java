package com.au.taxi.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.au.taxi.model.User;

public interface UserDao extends CrudRepository<User, String> {
	
	
	
	public List<User> findAllByName(String name);
	
	public List<User> findAllByNameContaining(String name);
	
	public User findOneByUserIdAndPassword(String userId, String password);

}
