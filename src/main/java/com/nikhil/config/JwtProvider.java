package com.nikhil.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


@Service
public class JwtProvider {
	
	
	SecretKey key=Keys.hmacShaKeyFor(JwtConstant.SECRET_KEY.getBytes());
    
	
	
	//@SuppressWarnings("deprecation")
	public String generateToken(Authentication auth) {
		
		
		String jwt=Jwts.builder()
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime()+86400000))
				.claim("email",auth.getName())
				.signWith(key)
				.compact();
		
		 System.out.println("Generated JWT Token: " + jwt);
		return jwt;
                 
	}
	
	public String getEmailFromToken(String jwt) {
		jwt=jwt.substring(7);
		
		//@SuppressWarnings("deprecation")
		Claims claims=Jwts.parser().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
		
		String email=String.valueOf(claims.get("email"));
		return email;
	}
}
