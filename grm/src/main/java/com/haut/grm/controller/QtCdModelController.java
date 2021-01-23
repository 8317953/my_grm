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

import com.haut.grm.model.QtCdModel;

import com.haut.grm.service.QtCdModelService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="充氮模型")
@RestController
public class QtCdModelController {
	
	@Autowired
	private QtCdModelService qtcdmodelService;

	
	@ApiOperation(value = "保存充氮模型")
	@RequestMapping(value={"/v1/saveqtcdmodel"}, method={RequestMethod.PUT})
	public void saveQtCdModel(@RequestBody QtCdModel qtcdmodel) {
		qtcdmodelService.saveQtCdModel(qtcdmodel);
	}
	
	@ApiOperation(value = "通过ID查询充氮模型")
	@RequestMapping(value={"/v1/findqtcdmodelById/{qtcdmodelId}"}, method={RequestMethod.GET})
	@JsonView({Views.QtCdModelView.class})
	public QtCdModel getQtCdModelById(@PathVariable("qtcdmodelId") Long qtcdmodelId){
		return qtcdmodelService.getQtCdModelById(qtcdmodelId);
	}
	
	@ApiOperation(value = "通过ID删除充氮模型")
	@RequestMapping(value={"/v1/delqtcdmodel/{qtcdmodelId}"}, method={RequestMethod.DELETE})
	public void DeleteQtCdModelById(@PathVariable("qtcdmodelId") Long qtcdmodelId){
		qtcdmodelService.deleteQtCdModelById(qtcdmodelId);
	}
	
	
	

	@ApiOperation(value = "查询所有的充氮模型")
	@RequestMapping(value={"/v1/getall/qtcdmodel"}, method={RequestMethod.GET})
	@JsonView({Views.QtCdModelView.class})
	public List<QtCdModel> getAllQtCdModels(){
		return qtcdmodelService.getAllQtCdModels();

	}
	
	
	@RequestMapping(value={"/get/data/all/qtcdmodel"}, method={RequestMethod.GET})
	@JsonView({Views.QtCdModelDatableView.class})
	public DataTablesOutput<QtCdModel> getAllDataQtCdModels(@Valid DataTablesInput input){
		return qtcdmodelService.getAllQtCdModelTable(input);

	}
	

	
}