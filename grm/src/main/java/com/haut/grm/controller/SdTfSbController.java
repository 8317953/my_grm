package com.haut.grm.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haut.grm.model.SdTfSb;
import com.haut.grm.service.SdTfSbService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 通风设备状态的增删改查
 * @author fuq
 * @Date 2021/1/18 8点45分
 */
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
	public DataTablesOutput<SdTfSb> findTfSb(@Valid DataTablesInput input) {
		
		return tfsbService.getAllSdTfSb(input);
	}
	
}
