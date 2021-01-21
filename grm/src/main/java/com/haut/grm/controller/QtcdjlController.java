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

import com.haut.grm.model.Qtcdjl;

import com.haut.grm.service.QtcdjlService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="气体充氮记录")
@RestController
public class QtcdjlController {
	
	@Autowired
	private QtcdjlService qtcdjlService;

	
	@ApiOperation(value = "保存气体充氮记录")
	@RequestMapping(value={"/v1/saveqtcdjl"}, method={RequestMethod.PUT})
	public void saveQtcdjl(@RequestBody Qtcdjl qtcdjl) {
		qtcdjlService.saveQtcdjl(qtcdjl);
	}
	
	@ApiOperation(value = "通过ID查询气体充氮记录")
	@RequestMapping(value={"/v1/findqtcdjlById/{qtcdjlId}"}, method={RequestMethod.GET})
	@JsonView({Views.QtcdjlView.class})
	public Qtcdjl getQtcdjlById(@PathVariable("qtcdjlId") Long qtcdjlId){
		return qtcdjlService.getQtcdjlById(qtcdjlId);
	}
	
	@ApiOperation(value = "通过ID删除气体充氮记录")
	@RequestMapping(value={"/v1/delqtcdjl/{qtcdjlId}"}, method={RequestMethod.DELETE})
	public void DeleteQtcdjlById(@PathVariable("qtcdjlId") Long qtcdjlId){
		qtcdjlService.deleteQtcdjlById(qtcdjlId);
	}
	
	
	

	@ApiOperation(value = "查询所有的气体充氮记录")
	@RequestMapping(value={"/v1/getall/qtcdjl"}, method={RequestMethod.GET})
	@JsonView({Views.QtcdjlView.class})
	public List<Qtcdjl> getAllQtcdjls(){
		return qtcdjlService.getAllQtcdjls();

	}
	
	
	@RequestMapping(value={"/get/data/all/qtcdjl"}, method={RequestMethod.GET})
	@JsonView({Views.QtcdjlDatableView.class})
	public DataTablesOutput<Qtcdjl> getAllDataQtcdjls(@Valid DataTablesInput input){
		return qtcdjlService.getAllQtcdjlTable(input);

	}
	

	
}