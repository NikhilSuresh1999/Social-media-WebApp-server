package com.nikhil.util;

import com.nikhil.model.Like;
import com.nikhil.model.Twit;
import com.nikhil.model.User;

public class TwitUtil {
	
	public final static boolean isLikedByReqUser(User reqUser,Twit twit)
	{
		
		for(Like like:twit.getLikes())
		{
			if(like.getUser().getId().equals(reqUser.getId()))
			{
				return true;
			}
		}
		return false;
	}
	
	public final static boolean isRetwitedByReqUser(User reqUser,Twit twit)
	{
		for(User user: twit.getRetwitUser())
		{
			if(user.getId().equals(reqUser.getId()))
			{
				return true;
			}
		}
		return false;
	}

}
