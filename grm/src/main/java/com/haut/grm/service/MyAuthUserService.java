package com.haut.grm.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.grm.model.meta.MyUserDetails;

@Service
public class MyAuthUserService{
	
	@Autowired
	private  HttpServletRequest request;
	
//	public void getCurrentToken() {
//		request.gethe
//	}
}
