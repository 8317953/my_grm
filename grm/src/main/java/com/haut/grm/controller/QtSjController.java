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

import com.haut.grm.model.QtSj;

import com.haut.grm.service.QtSjService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="")
@RestController
public class QtSjController {
	
	@Autowired
	private QtSjService qtsjService;

	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/saveqtsj"}, method={RequestMethod.PUT})
	public void saveQtSj(@RequestBody QtSj qtsj) {
		qtsjService.saveQtSj(qtsj);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findqtsjById/{qtsjId}"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public QtSj getQtSjById(@PathVariable("qtsjId") Long qtsjId){
		return qtsjService.getQtSjById(qtsjId);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/delqtsj/{qtsjId}"}, method={RequestMethod.DELETE})
	public void DeleteQtSjById(@PathVariable("qtsjId") Long qtsjId){
		qtsjService.deleteQtSjById(qtsjId);
	}
	
	
	

	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/getall/qtsj"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public List<QtSj> getAllQtSjs(){
		return qtsjService.getAllQtSjs();

	}
	
	
	@RequestMapping(value={"/get/data/all/qtsj"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public DataTablesOutput<QtSj> getAllDataQtSjs(@Valid DataTablesInput input){
		return qtsjService.getAllQtSjTable(input);

	}
	

	
}