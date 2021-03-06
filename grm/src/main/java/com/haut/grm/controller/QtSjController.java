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


@Api(tags="气体数据")
@RestController
public class QtSjController {
	
	@Autowired
	private QtSjService qtsjService;

	
	@ApiOperation(value = "保存气体数据")
	@RequestMapping(value={"/v1/saveqtsj"}, method={RequestMethod.PUT})
	public void saveQtSj(@RequestBody QtSj qtsj) {
		qtsjService.saveQtSj(qtsj);
	}
	
	@ApiOperation(value = "通过ID查询气体数据")
	@RequestMapping(value={"/v1/findqtsjById/{qtsjId}"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public QtSj getQtSjById(@PathVariable("qtsjId") Long qtsjId){
		return qtsjService.getQtSjById(qtsjId);
	}
	
	@ApiOperation(value = "通过ID删除气体数据")
	@RequestMapping(value={"/v1/delqtsj/{qtsjId}"}, method={RequestMethod.DELETE})
	public void DeleteQtSjById(@PathVariable("qtsjId") Long qtsjId){
		qtsjService.deleteQtSjById(qtsjId);
	}
	
	
	

	@ApiOperation(value = "查询所有的气体数据")
	@RequestMapping(value={"/v1/getall/qtsj"}, method={RequestMethod.GET})
	@JsonView({Views.QtSjView.class})
	public List<QtSj> getAllQtSjs(){
		return qtsjService.getAllQtSjs();

	}
	
	
	@RequestMapping(value={"/get/data/all/qtsj"}, method={RequestMethod.GET})
	@JsonView({Views.QtSjDatableView.class})
	public DataTablesOutput<QtSj> getAllDataQtSjs(@Valid DataTablesInput input){
		return qtsjService.getAllQtSjTable(input);

	}
	

    //store.id*Long,
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findqtsjBystore_id/{store_id}"}, method={RequestMethod.GET})
	@JsonView({Views.QtSjView.class})
	public QtSj getQtSjByStore_Id(@PathVariable("store_id") Long store_id){
		return qtsjService.getQtSjByStore_Id(store_id);
	}
	

    //code*String,
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findqtsjBycode/{code}"}, method={RequestMethod.GET})
	@JsonView({Views.QtSjView.class})
	public QtSj getQtSjByCode(@PathVariable("code") String code){
		return qtsjService.getQtSjByCode(code);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/getqtsj/likecode/{code}"}, method={RequestMethod.GET})
	@JsonView({Views.QtSjView.class})
	public List<QtSj> getQtSjByLikeCode(@PathVariable("code") String code){
		return qtsjService.getQtSjByLikeCode(code);
	}    //codeId*Integer,
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findqtsjBycodeid/{codeid}"}, method={RequestMethod.GET})
	@JsonView({Views.QtSjView.class})
	public QtSj getQtSjByCodeId(@PathVariable("codeid") Integer codeid){
		return qtsjService.getQtSjByCodeId(codeid);
	}
	

    //end




	
}
