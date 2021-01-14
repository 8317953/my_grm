/*    */ package com.haut.grm.service;
//import com.haut.grm.model.Gbhistorystockamount;
import com.haut.grm.model.MyStockSum;
import com.haut.grm.model.UntilEntryTem;
/*    */ 
/*    */ import com.haut.grm.model.entry.EntryTemperature;
//import com.haut.grm.repository.GbhistorystockamountRepository;
import com.haut.grm.repository.MyStockSumRepository;
import com.haut.grm.repository.UntilEntryTemRepository;
/*    */ import com.haut.grm.repository.entry.EntryTemperatureRepository;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class StatisticService
/*    */ {
/*    */   @Autowired
/*    */   private EntryTemperatureRepository entryTemperatureRepo;
/*    */   

	@Autowired
	private UntilEntryTemRepository utemRepo;
	
	
	@Autowired
	private MyStockSumRepository myStockSumRepo;

//	@Autowired
//	private GbhistorystockamountRepository gbHisamountRepo;

/*    */   public List<EntryTemperature> getTempsAt(String hour)
/*    */   {
/* 18 */     return this.entryTemperatureRepo.findByHour(hour);
/*    */   }
/*    */   
/*    */   public List<EntryTemperature> getTempsAt(String hour, Long storeId) {
/* 22 */     return this.entryTemperatureRepo.findByHourAndStore(hour, storeId);
/*    */   }


public List<UntilEntryTem> getTemmyTem(Long store_id){
	
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	Calendar c = Calendar.getInstance();
	c.setTime(new Date());
	c.add(Calendar.MONTH, -1);
	Date m = c.getTime();
	String mon = format.format(m);
	return utemRepo.findByStore_idAndTime(store_id, mon);
}


public List<MyStockSum> getAllMystockSum(){
	return myStockSumRepo.findAll();
}


//public List<Gbhistorystockamount> getGbhistorystockamountbyStockid(int stockid){
//	return gbHisamountRepo.myfindByStockid(stockid);
//}




/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\StatisticService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */