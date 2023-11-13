package com.nikhil.service;

import java.util.List;

import com.nikhil.exception.UserException;
import com.nikhil.model.User;

public interface UserService {

	
	
	public User findUserById(Long userId)throws UserException;
	
	public User findUserProfileByJwt(String jwt)throws UserException;
	
	public User updateUser(Long userId,User user)throws UserException;
	
	public User followUser(Long userid,User user)throws UserException;
	
	public List<User>searchUser(String query);
}
