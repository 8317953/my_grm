package com.haut.grm.controller;

import java.util.List;

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
import com.haut.grm.model.SdTfSb;
import com.haut.grm.service.SdTfSbService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "通风设备")
@RestController
public class SdTfSbController {

	@Autowired
	private SdTfSbService tfsbService;
	
	@ApiOperation(value = "保存通风设备")
	@RequestMapping(value = { "/v1/saveTfSb" }, method = { RequestMethod.PUT })
	public void saveTfSb(@RequestBody SdTfSb sdtfsb) {
		tfsbService.saveSdTfSb(sdtfsb);
	}
	
	
	@ApiOperation(value="查询通风设备")
	@RequestMapping(value = {"v1/findTfSb"},method= {RequestMethod.GET})
	@JsonView({Views.TfEquipStatusToEquipView.class})
	public List<SdTfSb> findTfSb(){
		
		return tfsbService.getAllTfSb();
	}
	
	@ApiOperation(value="删除通风设备")
	@RequestMapping(value = {"v1/delTfSb/{id}"},method= {RequestMethod.GET})
	public void delTfSb(@PathVariable Long id) {
		tfsbService.delSdTfSb(id);
	}
	
	@ApiOperation(value="查询通风设备通过ID")
	@RequestMapping(value = {"v1/findSdTfSbById/{id}"},method= {RequestMethod.GET})
	@JsonView({Views.TfEquipStatusToEquipView.class})
	public SdTfSb findSdTfSbById (@PathVariable("id") Long id) {
		return tfsbService.getSdTfSbById(id);
	}
	
}
