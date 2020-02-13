package com.ust.user.entity;

import com.ust.user.service.bo.UserBO;

public class CurrentUser {

	private String token;
	private UserBO user;
	
	public CurrentUser() {
		super();
	}
	
	public CurrentUser(String token, UserBO user) {
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserBO getUser() {
		return user;
	}

	public void setUser(UserBO user) {
		this.user = user;
	}
	
	
}