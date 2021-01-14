package com.haut.grm.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haut.grm.model.business.StockSum;
import com.haut.grm.model.ies.GrainTraffic;
import com.haut.grm.repository.business.StockChangeRepository;
import com.haut.grm.repository.business.StockIdRepository;
import com.haut.grm.repository.business.StockSumRepository;
import com.haut.grm.repository.ies.GrainTrafficRepository;

@Service
public class TimeTaskService
{
	@Autowired
	private StockSumRepository stockSumRepo;
	
	@Autowired
	private StockChangeRepository stockChangeRepository;
	
	
	@Autowired
	private StockIdRepository stockRepo;
	
	@Autowired
	private GrainTrafficRepository gtRepo;
	
	public void stockDateAmountTimeTask() {
		List<StockSum> list=stockSumRepo.findAll();
		
		Date[] dates=getMyDates();
		
		List<GrainTraffic> gts= gtRepo.findByOutTimeBetweenAndIsFinished(dates[0], dates[1], true);
		
		for(StockSum ss:list) {
			Long stock_id=ss.getId();
			
			for(GrainTraffic gt:gts) {
				
			}
		}
		
	}
	
	
	public static Date moveTime(Date date,int day){
        Calendar   calendar   =   new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.DATE,day);//把日期往后增加一天.整数往后推,负数往前移动
        return date=calendar.getTime();   //这个时间就是日期往后推一天的结果
    }
	
	
	public static Date[] getMyDates() {
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		
		Calendar calendar = Calendar.getInstance();
		// 时
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		// 分
		calendar.set(Calendar.MINUTE, 0);
		// 秒
		calendar.set(Calendar.SECOND, 0);
		// 毫秒
		calendar.set(Calendar.MILLISECOND, 0);
		
		Date time1 = calendar.getTime();
		
		calendar.add(calendar.DATE, -1);
		
		Date time2 = calendar.getTime();
		
		String t2=sdf.format(time2);
		String t1=sdf.format(time1);
		
		System.out.println(t2+"   "+t1);
		
		Date[] dates=new Date[2];
		
		dates[0]=time2;
		dates[1]=time1;
		
		return dates;
		
	}
	
	
	
//	public static void main(String[] args) {
//		Date d=new Date();
//		
//		Date d2=moveTime(d,1);
//		
//		
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
//		
//		
//		String str=sdf.format(d);
//		String str2=sdf.format(d2);
//		
//		
//		System.out.println(str);
//		
//		System.out.println(str2);
//	}
	
	
//	public static void main(String[] args) {
////		Calendar calendar = Calendar.getInstance();
////		// 时
////		calendar.set(Calendar.HOUR_OF_DAY, 0);
////		// 分
////		calendar.set(Calendar.MINUTE, 0);
////		// 秒
////		calendar.set(Calendar.SECOND, 0);
////		// 毫秒
////		calendar.set(Calendar.MILLISECOND, 0);
////		
////		Date time = calendar.getTime();
////		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
////		String format = df.format(time);
////		System.out.println(format);
//		
//		getMyDates();
//	}

	
	

}

