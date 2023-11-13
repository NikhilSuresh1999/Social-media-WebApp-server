package com.nikhil.service;

import java.util.List;

import com.nikhil.exception.TwitException;
import com.nikhil.exception.UserException;
import com.nikhil.model.Twit;
import com.nikhil.model.User;
import com.nikhil.request.TwitReplyRequest;

public interface TwitService {
	
	
	public Twit createTwit(Twit req,User user)throws UserException;
    public List<Twit>findAllTwit();
    public Twit retwit(Long twitId,User user)throws UserException,TwitException;
    
    public Twit findById(Long twitId)throws TwitException;
    
    public void deleteTwitById(Long twitId,Long userId)throws TwitException,UserException;
    
    
    public Twit removeFromRetwit(Long twitId,User user)throws TwitException,UserException;
    
    public Twit createdReply(TwitReplyRequest req,User user)throws TwitException;
    
    public List<Twit>getUserTwit(User user);
    
    public List<Twit>findByLikesContainsUser(User user);
}
