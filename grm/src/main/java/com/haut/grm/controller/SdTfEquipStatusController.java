package com.haut.grm.controller;

import java.util.Date;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.haut.grm.model.SdTfEquipStatus;
import com.haut.grm.model.StorePerTemWater;
import com.haut.grm.repository.StorePerTemRepository;
import com.haut.grm.service.AuthUserService;
import com.haut.grm.service.SdTfEquipStatusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @Description 通风设备状态的增删改查
 * @author fuq
 * @Date 2021/1/15 14点45分
 */
@Api(tags="通风设备状态")
@RestController
public class SdTfEquipStatusController {

	@Autowired
	private SdTfEquipStatusService sdtfequipstatusService;


	@ApiOperation(value = "保存通风设备状态")
	@RequestMapping(value = { "/v1/saveEquipStatus" }, method = { RequestMethod.PUT })
	public void saveTfEquipStatus(@RequestBody SdTfEquipStatus sdtfEquipStatus) {
		sdtfequipstatusService.saveSdTfEquipStatus(sdtfEquipStatus);
	}
	
	@ApiOperation(value = "通过Id删除通风设备状态")
	@RequestMapping(value={"/v1/delEquipStatus/{id}"}, method={RequestMethod.DELETE})
	public void delTfEquipStatus(@PathVariable("id") Long id) {
		sdtfequipstatusService.delSdTfEquipStatus(id);
	}
	
	@ApiOperation(value = "查询")
	@RequestMapping(value = {"v1/findTfEquipStatus"},method= {RequestMethod.GET})
	public DataTablesOutput<SdTfEquipStatus> findTfEquipStatus(@Valid DataTablesInput input) {
		return sdtfequipstatusService.getAllSdTfEquipStatus(input);
	}

}
