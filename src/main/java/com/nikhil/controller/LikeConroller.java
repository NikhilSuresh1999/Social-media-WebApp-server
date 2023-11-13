package com.nikhil.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nikhil.dto.LikeDto;
import com.nikhil.dto.mapper.LikeDtoMapper;
import com.nikhil.exception.TwitException;
import com.nikhil.exception.UserException;
import com.nikhil.model.Like;
import com.nikhil.model.User;
import com.nikhil.service.LikeService;
import com.nikhil.service.UserService;

@RestController
@RequestMapping("/api")
public class LikeConroller {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@PostMapping("/{twitId}/like")
	public ResponseEntity<LikeDto>likeTwit(@PathVariable Long twitId,
			@RequestHeader("Authorization")String jwt)throws UserException,TwitException

	{
		
		User user=userService.findUserProfileByJwt(jwt);
		Like like=likeService.likeTwit(twitId, user);
		
		LikeDto likeDto=LikeDtoMapper.toLikeDto(like, user);
		
		return new ResponseEntity<LikeDto>(likeDto,HttpStatus.CREATED);
		
		
		
	}
	
	@PostMapping("/twit/{twitId}")
	public ResponseEntity<List<LikeDto>>getAllLikes(@PathVariable Long twitId,
			@RequestHeader("Authorization")String jwt)throws UserException,TwitException
	

	{
		
		User user=userService.findUserProfileByJwt(jwt);
		List<Like>likes=likeService.getAllLikes(twitId);
		
		List<LikeDto> likeDtos=LikeDtoMapper.toLikeDtos(likes, user);
		
		return new ResponseEntity<>(likeDtos,HttpStatus.CREATED);
		
		
		
	}
	
	

}
