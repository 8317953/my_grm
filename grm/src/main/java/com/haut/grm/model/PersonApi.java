package com.haut.grm.model;

import java.io.Serializable;

/**
 * @author 10231
 *
 */
public class PersonApi implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5746751332993188359L;

	private String name;
	
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	
	
}
