package com.haut.grm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.AnaMoban;
import com.haut.grm.model.Plane;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.wenzhou.OutInLetter;
import com.haut.grm.repository.meta.UserRepository;
import com.haut.grm.service.AuthUserService;
import com.haut.grm.service.PlaneService;



@RestController
public class PlaneController {
	
	@Autowired
	private PlaneService pService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private AuthUserService authService;
	
	@RequestMapping(value={"/save/plane"}, method={RequestMethod.POST})
	public void savePlane(@RequestBody Plane plane) {
		if(plane.getId()==null) {
			
			
			User u= authService.getCurrentUser(userRepo);
			plane.setInput_user(u);
			String businessKey="PL"+plane.getInput_time().getTime();
			plane.setPlane_business(businessKey);
			
			
			pService.savePlane(plane);
		}else {
			pService.updatePlane(plane);
		}
		
	}
	
	//PlaneView
	@RequestMapping(value={"/plane/getplane/{id}"}, method={RequestMethod.GET})
	@JsonView({Views.PlaneView.class})
	public Plane getOnePlaneById(@PathVariable("id") Long id) {
		return pService.getPlaneById(id);
	}
	
	
	@RequestMapping(value={"/save/tzd"}, method={RequestMethod.POST})
	public void savePlane(@RequestBody OutInLetter letter) {
		if(letter.getId()==null) {
			
			
			User u= authService.getCurrentUser(userRepo);
			letter.setCreateby(u);
			letter.setCreate_time(new Date());
			pService.saveLetter(letter);
		}else {
			pService.updateOutInLetter(letter);
		}
		
	}
	
	@RequestMapping(value={"/plane/getletter/{id}"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public OutInLetter getOneLetterById(@PathVariable("id") Long id) {
		return pService.getLetterById(id);
	}
	
	
	@RequestMapping(value={"/delete/zb/{name}"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public void deleteByName(@PathVariable("name") String name) {
		System.out.println(name);
		pService.deleteZbByName(name);
	}
	
	
	
	
	
	
}
