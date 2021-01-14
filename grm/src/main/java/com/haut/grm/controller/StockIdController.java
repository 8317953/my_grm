package com.haut.grm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
import com.haut.grm.model.business.MyStockSumHistory;
import com.haut.grm.model.business.StockAnalysis;
import com.haut.grm.model.business.StockId;
import com.haut.grm.model.business.StockSum;
import com.haut.grm.model.ies.Analysis;
import com.haut.grm.model.meta.User;
import com.haut.grm.model.wenzhou.OutInLetter;
import com.haut.grm.repository.meta.UserRepository;
import com.haut.grm.service.AuthUserService;
import com.haut.grm.service.PlaneService;
import com.haut.grm.service.StockIdService;



@RestController
public class StockIdController {
	
	@Autowired
	private StockIdService stockService;
	
	@Autowired
	private UserRepository userRepo;
	
	
	//PlaneView
	@RequestMapping(value={"/stock/getstockbyid/{id}"}, method={RequestMethod.GET})
	public StockId getOnePlaneById(@PathVariable("id") Long id) {
		return stockService.getStockIdById(id);
	}
	
	
	@RequestMapping(value={"/save/stockana"}, method={RequestMethod.POST})
	public void saveStockAna(@RequestBody StockAnalysis sa) {
		if(sa.getId()==null) {

			Date date=new Date();
			sa.setAuditTime(date);
			sa.setInputer(AuthUserService.getCurrentUser(userRepo));
			sa.setAuditor(AuthUserService.getCurrentUser(userRepo));
			sa.setInputTime(date);
			sa.setBusinessKey(getBusinessKey());
		}
		stockService.saveStockAna(sa);
	}
	
	
	
	@RequestMapping(value={"/stock/getanakey"}, method={RequestMethod.GET})
	public  String getBusinessKey() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
		String str=sdf.format(date);
		str="验"+str;
		List<StockAnalysis> list=stockService.findByBussinessKeyLike(str);
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
	
	
	@RequestMapping(value={"/stock/ana/{id}"}, method={RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public StockAnalysis getOneStockAnaById(@PathVariable("id") Long id) {
		System.out.println(id);
		return stockService.findStockAnaById(id);
	}
	
	
	
//	@RequestMapping(value={"/save/iesana"}, method={RequestMethod.POST})
//	public void saveIesAna(@RequestBody Analysis a) {
//		stockService.saveIesAna(a);
//	}
	
	
	
	
//	public  String getBarcode() {
//		Date date=new Date();
//		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
//		String str=sdf.format(date);
//		List<Analysis> list=stockService.findIesAnaLikeBarcode(str);
//		int count=list.size();
//		count++;
//		if(count<10) {
//			str=str+"00"+count;
//		}else if(count>=10&&count<100) {
//			str=str+"0"+count;
//		}else {
//			str=str+count;
//		}
//		return str;
//	}
	
	
	@RequestMapping(value={"/mygetall/stock"}, method={RequestMethod.GET})
	public List<StockId> getAllStockId(){
		return stockService.getAllStockId();
	}
	
	
	@RequestMapping(value={"/mygetall/data/stock"}, method={RequestMethod.GET})
	public DataTablesOutput<StockId> getAllDataStockId(DataTablesInput input){
		return stockService.getAllDataStockId(input);
	}
	
	
	@RequestMapping(value={"/mygetall/data/stocksum"}, method={RequestMethod.GET})
	public DataTablesOutput<StockSum> getAllDataStockSum(DataTablesInput input){
		return stockService.getAllDataStockSum(input);
	}
	
	@RequestMapping(value={"/mygetall/stocksum"}, method={RequestMethod.GET})
	public List<StockSum> getAllStockSum(){
		return stockService.getAllStockSumm();
	}
	
	
	
	@RequestMapping(value={"/save/my/stock"}, method={RequestMethod.POST})
	public void saveStockAna(@RequestBody StockId stock) {
		if(stock.getId()==null) {
			
			Date date=new Date();
			stock.setAuditTime(date);
			stock.setInputTime(date);
			
			stock.setAuditor(AuthUserService.getCurrentUser(userRepo));
			stock.setInputer(AuthUserService.getCurrentUser(userRepo));
			
			stock.setBusinessKey(getStockIdBusinessKey());
		}
		stockService.saveStockId(stock);
	}
	
	
	
	public  String getStockIdBusinessKey() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("YYYYMMdd");
		String str=sdf.format(date);
		str="货位"+str;
		List<StockId> list=stockService.findStockIdByBussinessKeyLike(str);
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
	
	@RequestMapping(value={"/mygetall/data/stocksumhistory"}, method={RequestMethod.GET})//历史货位以及关联出入库结算
	public DataTablesOutput<MyStockSumHistory> getAllDataStockSumHistory(DataTablesInput input){
		return stockService.getAllMyStockSumHistoryData(input);
	}
	
	
	
	@RequestMapping(value={"/find/stocksum/cargo/{id}"}, method={RequestMethod.GET})
	public StockSum getStockSumByCargoId(@PathVariable("id") Long id) {
		System.out.println(id);
		
		return stockService.getStockSumByCargo_Id(id);
		
	}
	
	
	
//	@JsonView({Views.MyDateJsView.class})
	@RequestMapping(value={"/mygetall/data/mydatejs"}, method={RequestMethod.GET})
	public DataTablesOutput<MyDateJs> getAllDataMyDateJs(DataTablesInput input){
		return stockService.getAllMyDateJsData(input);
	}
	
	
}
