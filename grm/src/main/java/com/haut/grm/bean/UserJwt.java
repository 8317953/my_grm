package com.haut.grm.bean;

import java.io.Serializable;

import com.haut.grm.model.meta.User;

public class UserJwt implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3172560267972959526L;

	private String id;
	
	private User user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
