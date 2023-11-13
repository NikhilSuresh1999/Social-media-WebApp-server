package com.nikhil.service;

import java.util.List;

import com.nikhil.exception.TwitException;
import com.nikhil.exception.UserException;
import com.nikhil.model.Like;
import com.nikhil.model.User;

public interface LikeService {

	
	
	public Like likeTwit(Long twitId,User user)throws UserException,TwitException;
	
	public List<Like>getAllLikes(Long twitId) throws TwitException;
}
