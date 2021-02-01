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

import com.haut.grm.model.Qtfmmodel;

import com.haut.grm.service.QtfmmodelService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="阀门模型")
@RestController
public class QtfmmodelController {
	
	@Autowired
	private QtfmmodelService qtfmmodelService;

	
	@ApiOperation(value = "保存阀门模型记录")
	@RequestMapping(value={"/v1/saveqtfmmodel"}, method={RequestMethod.PUT})
	public void saveQtfmmodel(@RequestBody Qtfmmodel qtfmmodel) {
		qtfmmodelService.saveQtfmmodel(qtfmmodel);
	}
	
	@ApiOperation(value = "通过ID查询阀门模型记录")
	@RequestMapping(value={"/v1/findqtfmmodelById/{qtfmmodelId}"}, method={RequestMethod.GET})
	@JsonView({Views.QtfmmodelView.class})
	public Qtfmmodel getQtfmmodelById(@PathVariable("qtfmmodelId") Long qtfmmodelId){
		return qtfmmodelService.getQtfmmodelById(qtfmmodelId);
	}
	
	@ApiOperation(value = "通过ID删除阀门模型记录")
	@RequestMapping(value={"/v1/delqtfmmodel/{qtfmmodelId}"}, method={RequestMethod.DELETE})
	public void DeleteQtfmmodelById(@PathVariable("qtfmmodelId") Long qtfmmodelId){
		qtfmmodelService.deleteQtfmmodelById(qtfmmodelId);
	}
	
	
	

	@ApiOperation(value = "查询所有的阀门模型记录")
	@RequestMapping(value={"/v1/getall/qtfmmodel"}, method={RequestMethod.GET})
	@JsonView({Views.QtfmmodelView.class})
	public List<Qtfmmodel> getAllQtfmmodels(){
		return qtfmmodelService.getAllQtfmmodels();

	}
	
	
	@RequestMapping(value={"/get/data/all/qtfmmodel"}, method={RequestMethod.GET})
	@JsonView({Views.QtfmmodelDatableView.class})
	public DataTablesOutput<Qtfmmodel> getAllDataQtfmmodels(@Valid DataTablesInput input){
		return qtfmmodelService.getAllQtfmmodelTable(input);

	}
	

	
    //end
}