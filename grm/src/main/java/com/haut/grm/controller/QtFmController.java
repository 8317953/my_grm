package com.haut.grm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;

import com.haut.grm.model.QtFm;

import com.haut.grm.service.QtFmService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="")
@RestController
public class QtFmController {
	
	@Autowired
	private QtFmService qtfmService;

	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/saveqtfm"}, method={RequestMethod.PUT})
	public void saveQtFm(@RequestBody QtFm qtfm) {
		qtfmService.saveQtFm(qtfm);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findqtfmById/{qtfmId}"}, method={RequestMethod.GET})
	@JsonView({Views.QtFmView.class})
	public QtFm getQtFmById(@PathVariable("qtfmId") Long qtfmId){
		return qtfmService.getQtFmById(qtfmId);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/delqtfm/{qtfmId}"}, method={RequestMethod.DELETE})
	public void DeleteQtFmById(@PathVariable("qtfmId") Long qtfmId){
		qtfmService.deleteQtFmById(qtfmId);
	}
	
	
	

	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/getall/qtfm"}, method={RequestMethod.GET})
	@JsonView({Views.QtFmView.class})
	public List<QtFm> getAllQtFms(){
		return qtfmService.getAllQtFms();

	}
	
	
	@RequestMapping(value={"/get/data/all/qtfm"}, method={RequestMethod.GET})
	@JsonView({Views.QtFmDatableView.class})
	public DataTablesOutput<QtFm> getAllDataQtFms(@Valid DataTablesInput input){
		return qtfmService.getAllQtFmTable(input);

	}
	

	
}