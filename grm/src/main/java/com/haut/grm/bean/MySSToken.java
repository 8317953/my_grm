package com.haut.grm.bean;

import java.io.Serializable;

public class MySSToken implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -435440707960468721L;
	private String token;
	
	
	public MySSToken(String token) {
		this.token=token;
	}
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
