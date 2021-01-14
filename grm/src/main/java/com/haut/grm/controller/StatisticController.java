/*    */ package com.haut.grm.controller;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.EntryTemperatureView;
/*    */ import com.haut.grm.json.view.Views.EntryTemperatureWithStoreView;
//import com.haut.grm.model.Gbhistorystockamount;
import com.haut.grm.model.MyStockSum;
import com.haut.grm.model.UntilEntryTem;
/*    */ import com.haut.grm.model.entry.EntryTemperature;
import com.haut.grm.repository.MyStockSumRepository;
/*    */ import com.haut.grm.service.StatisticService;

import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.PathVariable;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class StatisticController
/*    */ {
/*    */   @Autowired
/*    */   private StatisticService statisticService;


			
/*    */   
/*    */   @RequestMapping(value={"/retrieve/entry_temperature/at/{hour}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @JsonView({Views.EntryTemperatureWithStoreView.class})
/*    */   public List<EntryTemperature> getTempsAt(@PathVariable("hour") String hour)
/*    */   {
/* 25 */     return this.statisticService.getTempsAt(hour);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/retrieve/entry_temperature/at/{hour}/{storeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @JsonView({Views.EntryTemperatureView.class})
/*    */   public List<EntryTemperature> getTempsAt(@PathVariable("hour") String hour, @PathVariable("storeId") Long storeId) {
/* 31 */     return this.statisticService.getTempsAt(hour, storeId);
/*    */   }




	@RequestMapping(value={"/retrieve/entry_temperature/my/{storeId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public List<UntilEntryTem> getTempsmyAt(@PathVariable("storeId") Long storeId) {
		return this.statisticService.getTemmyTem(storeId);
	}
	
	@RequestMapping(value={"/retrieve/mystocksum"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
	@JsonView({Views.IdView.class})
	public List<MyStockSum> getKucun() {
		return statisticService.getAllMystockSum();
	}
	
	
//	@RequestMapping(value={"/retrieve/gbhistoryamount/{stockid}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
//	@JsonView({Views.IdView.class})
//	public List<Gbhistorystockamount> getgbhistoryamountBystockid(@PathVariable("stockid") int stockid) {
//		return statisticService.getGbhistorystockamountbyStockid(stockid);
//	}
	
	
	
//	@RequestMapping(value={"/retrieve/stock/mystock"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
//	@JsonView({Views.IdView.class})
//	public List<UntilEntryTem> getMystockSum() {
//		Date now=new Date();
//		
//	}
	
	



/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\StatisticController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */