package com.nikhil.response;

import lombok.AllArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
	
	
	
	private String jwt;
	public String getJwt() {
		return jwt;
	}
	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	private boolean status;
	public AuthResponse(String jwt, boolean status) {
		super();
		this.jwt = jwt;
		this.status = status;
	}
	
	public AuthResponse()
	{
		
	}
	
	
//	public AuthResponse(String token, boolean b) {
//		jwt=token;
//		status=b;
//	}
	
//	public AuthResponse(String token, boolean success) {
//        jwt = token;
//        status = success;
//    }
	

}
