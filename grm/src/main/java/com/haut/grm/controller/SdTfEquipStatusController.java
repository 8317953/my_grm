package com.haut.grm.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
import com.haut.grm.model.SdTfEquipStatus;
import com.haut.grm.service.SdTfEquipStatusService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "通风设备状态")
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
	@RequestMapping(value = { "/v1/delEquipStatus/{id}" }, method = { RequestMethod.DELETE })
	public void delTfEquipStatus(@PathVariable("id") Long id) {
		sdtfequipstatusService.delSdTfEquipStatus(id);
	}

	@ApiOperation(value = "查询")
	@RequestMapping(value = { "v1/findTfEquipStatus" }, method = { RequestMethod.GET })
	@JsonView({ Views.TfEquipStatusToEquipView.class })
	public List<SdTfEquipStatus> findTfEquipStatus() {
		return sdtfequipstatusService.getAllTfEquipStatus();
	}
	
	@ApiOperation(value = "查询通风设备状态通过ID")
	@RequestMapping(value = { "v1/findTfEquipStatusById/{id}" }, method = { RequestMethod.GET })
	@JsonView({ Views.TfEquipStatusToEquipView.class })
	public SdTfEquipStatus findTfEquipStatusById(@PathVariable("id") Long id) {
		return sdtfequipstatusService.getTfEquipStatusById(id);
	}
}
