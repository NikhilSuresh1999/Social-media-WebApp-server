package com.nikhil.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nikhil.model.User;
import com.nikhil.repository.UserRepository;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;


@Service
public class CustomUserDetailsImplementation implements UserDetailsService {
    
	@Autowired
	private UserRepository userRepository;
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmail(username);
		
		
		if(user==null || user.isLogin_with_google()) {
			
			throw new UsernameNotFoundException("username not find with email"+username);
			
		}
		
		List<GrantedAuthority>authorities=new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),authorities);
	}

}
