package com.haut.grm.model;

import java.io.Serializable;

public class MyUser implements Serializable{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = -1052256002229810875L;
	private String username;
	private String pwd;
	
	private String id;
	
	public MyUser() {}
	
	public MyUser(String username, String pwd,String id) {
		super();
		this.username = username;
		this.pwd = pwd;
		this.id=id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
