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

import com.haut.grm.model.Nhdata;

import com.haut.grm.service.NhdataService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="能耗模块")
@RestController
public class NhdataController {
	
	@Autowired
	private NhdataService nhdataService;

	
	@ApiOperation(value = "保存能耗")
	@RequestMapping(value={"/v1/savenhdata"}, method={RequestMethod.PUT})
	public void saveNhdata(@RequestBody Nhdata nhdata) {
		nhdataService.saveNhdata(nhdata);
	}
	
	@ApiOperation(value = "通过ID查询能耗信息")
	@RequestMapping(value={"/v1/findnhdataById/{nhdataId}"}, method={RequestMethod.GET})
	@JsonView({Views.NhdataView.class})
	public Nhdata getNhdataById(@PathVariable("nhdataId") Long nhdataId){
		return nhdataService.getNhdataById(nhdataId);
	}
	
	@ApiOperation(value = "通过ID删除能耗信息")
	@RequestMapping(value={"/v1/delnhdata/{nhdataId}"}, method={RequestMethod.DELETE})
	public void DeleteNhdataById(@PathVariable("nhdataId") Long nhdataId){
		nhdataService.deleteNhdataById(nhdataId);
	}
	
	
	

	@ApiOperation(value = "查询所有的能耗信息")
	@RequestMapping(value={"/v1/getall/nhdata"}, method={RequestMethod.GET})
	@JsonView({Views.NhdataView.class})
	public List<Nhdata> getAllNhdatas(){
		return nhdataService.getAllNhdatas();

	}
	
	
	@RequestMapping(value={"/get/data/all/nhdata"}, method={RequestMethod.GET})
	@JsonView({Views.NhdataDatableView.class})
	public DataTablesOutput<Nhdata> getAllDataNhdatas(@Valid DataTablesInput input){
		return nhdataService.getAllNhdataTable(input);

	}
	
    //codeid*Integer,
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findnhdataBycodeid/{codeid}"}, method={RequestMethod.GET})
	@JsonView({Views.NhdataView.class})
	public Nhdata getNhdataByCodeid(@PathVariable("codeid") Integer codeid){
		return nhdataService.getNhdataByCodeid(codeid);
	}
	
    //code*String,s
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/findnhdataBycode/{code}"}, method={RequestMethod.GET})
	@JsonView({Views.NhdataView.class})
	public List<Nhdata> getNhdataByCode(@PathVariable("code") String code){
		return nhdataService.getNhdataByCode(code);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(value={"/v1/getnhdata/likecode/{code}"}, method={RequestMethod.GET})
	@JsonView({Views.NhdataView.class})
	public List<Nhdata> getNhdataByLikeCode(@PathVariable("code") String code){
		return nhdataService.getNhdataByLikeCode(code);
	}
    //end

	

	
}
