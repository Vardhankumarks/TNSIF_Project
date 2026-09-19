package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

//service class - crud operation
@Service
public class UserService {
	
	@Autowired
	public UserRepository userrepo;
	
	
	//post data
	public User addUser(User user) 
	{
		return userrepo.save(user);
	}
	
	//Display
	public List<User> getUser()
	{
		return userrepo.findAll();
	}
	
	
	//delete
	public void deleteUser(int id)
	{
		userrepo.deleteById(id);
	}
	
	//update
	public User updateUser(User user)
	{
		Integer id=user.getUserid();
		
		User user1=userrepo.findById(id).get();
		
		user1.setUserid(user.getUserid());
		user1.setName(user.getName());
		user1.setUsertype(user.getUsertype());
		user1.setPassword(user.getPassword());
		return userrepo.save(user1);
	}
}