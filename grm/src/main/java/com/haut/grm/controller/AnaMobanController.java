package com.haut.grm.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.AnaMoban;
import com.haut.grm.model.Door;
import com.haut.grm.model.dto.AnaZbMb;
import com.haut.grm.model.ies.GrainTraffic;
import com.haut.grm.model.standard.code.GrainVariety;
import com.haut.grm.model.type.AnaBzType;
import com.haut.grm.service.PlaneService;

import java.lang.reflect.Field;

@RestController
public class AnaMobanController {
	
	@Autowired
	private PlaneService plService;
	
	@RequestMapping(value={"/getall/mbbz"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@JsonView({Views.BaseTypeView.class})
	public List<AnaBzType> getAllAnaBzTypes() {
		return plService.getAllAnaBzTypes();
	}
	
	@RequestMapping(value={"/getana/byname/{name}"}, method={RequestMethod.GET})
	@JsonView({Views.MyBaseNameView.class})
	public List<AnaMoban> getAnaMobanLikeName(@PathVariable("name") String name) {
		return plService.getAnaMobanLikeName(name);
	}
	
	
	@RequestMapping(value={"/getanamoban/bygvname/{name}"}, method={RequestMethod.GET})
	@JsonView({Views.MyBaseNameView.class})
	public AnaMoban getAnaMobanByGvId(@PathVariable("name") String name) {
		return plService.getAnaMobanByGvName(name);
	}
	
	
	@RequestMapping(value={"/save/moban/zbtype"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	@JsonView({Views.DoorWithStoreView.class})
	public void saveMobanAndType(@RequestBody AnaZbMb mb) {
		
		
		AnaMoban anaMoban=new AnaMoban();
		anaMoban.setGv(mb.getGv());
		int i=0;
		for(String str: mb.getStrs()) {
			i++;
			AnaBzType at=plService.findBzTypeByName(str);
			if(at==null&&str!=null&&!"".equals(str)) {
				at=new AnaBzType();
				at.setName(str);
				at=plService.saveAnaBzType(at);
				
			}
			setAttribute(anaMoban,"a"+i,str);
		}
		plService.saveAnaMoban(anaMoban);
		
	}
	
	
	
	
	public static void setAttribute(Object o,String field, Object keyWord) {
	    try { 
	        Field f = o.getClass().getDeclaredField(field); 
	        f.setAccessible(true); 
	        f.set(o, keyWord); 
	    } catch (Exception e) { 
	        e.printStackTrace(); 
	    } 
	}

	
	
	
	
	
}
