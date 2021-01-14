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
import com.haut.grm.model.AnaMoban;
import com.haut.grm.model.MyDateJs;
import com.haut.grm.model.Plane;
import com.haut.grm.model.SdTfDate;
import com.haut.grm.model.SdTfPlane;
import com.haut.grm.model.StorePerTemWater;
import com.haut.grm.model.business.MyStockSumHistory;
import com.haut.grm.model.business.StockAnalysis;
import com.haut.grm.model.business.StockId;
import com.haut.grm.model.business.StockSum;
import com.haut.grm.model.ies.Analysis;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.wenzhou.OutInLetter;
import com.haut.grm.repository.StorePerTemRepository;
import com.haut.grm.repository.meta.UserRepository;
import com.haut.grm.service.AuthUserService;
import com.haut.grm.service.PlaneService;
import com.haut.grm.service.SdTFService;
import com.haut.grm.service.StockIdService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(tags="通风模块")
@RestController
public class SdTfController {
	
	@Autowired
	private SdTFService tfService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private StorePerTemRepository storePerTemRepo;
	
	
	
	@ApiOperation(value = "保存通风计划")
	@RequestMapping(value={"/v1/saveVenPlan"}, method={RequestMethod.PUT})
	public void saveTfPlane(@RequestBody SdTfPlane tfpl) {
		if(tfpl.getId()==null) {
			tfpl.setInputer(AuthUserService.getCurrentUser(userRepo));
			tfpl.setInputtime(new Date());
			tfpl.setCode(getTfplBusinessKey());

		}
		Set<StorePerTemWater> sets=tfpl.getStorePerTemWater();
		tfpl=tfService.saveSdTfPlane(tfpl);
		if(sets!=null) {
			if(sets.size()>0) {
				for(StorePerTemWater sw:sets) {
					sw.setSdTfPlane(tfpl);
					storePerTemRepo.save(sw);
				}
			}
			
		}
		
	}
	
	@ApiOperation(value = "通过Id查询通风计划")
	@RequestMapping(value={"/v1/findVenPlanById/{tfplId}"}, method={RequestMethod.GET})
	@JsonView({Views.SdTfPlaneToEntryView.class})
	public SdTfPlane geTfPlaneById(@PathVariable("tfplId") Long tfplId){
		return tfService.getSdTfPlaneById(tfplId);
	}
	
	@ApiOperation(value = "通过Id删除通风计划")
	@RequestMapping(value={"/v1/delPlan/{tfplId}"}, method={RequestMethod.DELETE})
	public void DeleteTfPlaneById(@PathVariable("tfplId") Long tfplId){
//		System.out.println(tfplId);
//		return;
//		tfService.deleteSdTfPlaneById(tfplId);
		
		SdTfPlane sdtfpl=tfService.getSdTfPlaneById(tfplId);
		Set<StorePerTemWater> sets=sdtfpl.getStorePerTemWater();
		
		for(StorePerTemWater spt:sets) {
			storePerTemRepo.delete(spt);
		}
		
		tfService.deleteSdTfPlaneById(tfplId);
	}
	
	@ApiOperation(value = "通过Id查询通风记录")
	@RequestMapping(value={"/v1/accVenLogById/{id}"}, method={RequestMethod.GET})
	@JsonView({Views.SdTfDateToTfPlaneAndStoreView.class})
	public SdTfDate getTfDataById(@PathVariable("id") Long id){
		return tfService.getSdTfDataById(id);
	}
	
	@ApiOperation(value = "通过Id删除通风记录")
	@RequestMapping(value={"/v1/deleteVenLogById/{id}"}, method={RequestMethod.DELETE})
	public void deleteTfDataById(@PathVariable("id") Long id){
		tfService.deleteSdTfDataById(id);
	}
	
	
	
	
	@ApiOperation(value = "保存通风记录")
	@RequestMapping(value={"/v1/subVenLog"}, method={RequestMethod.PUT})
	public void saveTfData(@RequestBody SdTfDate sdTfDate) {
		if(sdTfDate.getId()==null) {
			sdTfDate.setInputer(AuthUserService.getCurrentUser(userRepo));
			sdTfDate.setInputtime(new Date());
			sdTfDate.setCode(getTfDataBusinessKey());
		}
		tfService.saveSdTfData(sdTfDate);
	}
	

	@ApiOperation(value = "通过depotId查询通风计划")
	@RequestMapping(value={"/v1/ventilatePlan/{depotId}"}, method={RequestMethod.GET})
	@JsonView({Views.SdTfPlaneToEntryView.class})
	public List<SdTfPlane> getAllTfplas(@PathVariable("depotId") Long depotId){
		System.out.println("depotid:"+depotId);
		return tfService.getAllTfPlanes(depotId);
	}
	
	@ApiOperation(value = "通过depotId查询通风通风数据")
	@RequestMapping(value={"/v1/accVenLogBydepotId/{depotId}"}, method={RequestMethod.GET})
	@JsonView({Views.SdTfDateToTfPlaneAndStoreView.class})
	public List<SdTfDate> getAllTfDatas(@PathVariable("depotId") Long depotId){
		System.out.println("depotid:"+depotId);
		return tfService.getAllTfDates(depotId);
	}
	
	
	@RequestMapping(value={"/get/data/all/tfpls/{depotId}"}, method={RequestMethod.GET})
	@JsonView({Views.DataSdTfPlaneToEntryView.class})
	public DataTablesOutput<SdTfPlane> getAllDataTfplas(@Valid DataTablesInput input,@PathVariable Long depotId){
		return tfService.getAllSdTfPlaneTable(input, depotId);
	}
	
	
	@RequestMapping(value={"/get/data/all/tfdatas/{depotId}"}, method={RequestMethod.GET})
	@JsonView({Views.DataSdTfDateToTfPlaneAndStoreView.class})
	public DataTablesOutput<SdTfDate> getAllDataTfDatas(@Valid DataTablesInput input,@PathVariable Long depotId){
//		System.out.println("depotId:"+depotId);
		return tfService.getAllSdTfDataTable(input, depotId);
	};
	
	
	public String getTfplBusinessKey() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
		String str=sdf.format(date);
		str="通风计划"+str;
		System.out.println(str);
		List<SdTfPlane> list= tfService.getSdTfPlanesByCodeLike(str);
		System.out.println(list.size());
		int count=list.size();
	
		count++;
		if(count<10) {
			str=str+"000"+count;
		}else if(count>=10&&count<100) {
			str=str+"00"+count;
		}else if(count>=100&&count<1000) {
			str=str+"0"+count;
		}else {
			str=str+count;
		}
		return str;
	}
	
	
	public String getTfDataBusinessKey() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
		String str=sdf.format(date);
		str="通风记录"+str;
		List<SdTfDate> list= tfService.getSdTfDatesByCodeLike(str);
		int count=list.size();
		count++;
		if(count<10) {
			str=str+"000"+count;
		}else if(count>=10&&count<100) {
			str=str+"00"+count;
		}else if(count>=100&&count<1000) {
			str=str+"0"+count;
		}else {
			str=str+count;
		}
		return str;
	}
	
	
	
	
	
	
	
}
