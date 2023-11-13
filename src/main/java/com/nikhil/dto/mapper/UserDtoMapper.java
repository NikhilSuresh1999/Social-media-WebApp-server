package com.nikhil.dto.mapper;

import java.util.List;
import java.util.ArrayList;

import com.nikhil.dto.UserDto;
import com.nikhil.model.User;

public class UserDtoMapper {
	
	
	public static UserDto toUserDto(User user)
	{
		if (user == null) {
	        return null; // Handle the case where user is null
	    }
		
		
		UserDto userDto=new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFullName(user.getFullName());
		userDto.setImage(user.getImage());
		userDto.setBackgroundImage(user.getBackgroundImage());
		userDto.setBio(user.getBio());
		userDto.setBirthdate(user.getBirthDate());
		userDto.setFollowers(toUserDtos(user.getFollowers()));
		userDto.setFollowing(toUserDtos(user.getFollowings()));
		userDto.setLogin_with_google(user.isLogin_with_google());
		userDto.setLocation(user.getLocation());
		//userDto.setVerified();
		
		
		
		
		
		return userDto;
	}

	public static List<UserDto> toUserDtos(List<User> followers) {
		List<UserDto>userDtos=new ArrayList<>();
		
		for(User user:followers)
		{
			UserDto userDto=new UserDto();
			userDto.setId(user.getId());
			userDto.setEmail(user.getEmail());
			userDto.setFullName(user.getFullName());
			userDto.setImage(user.getImage());
			
			userDtos.add(userDto);
		}
		
		return userDtos;
	}

}
