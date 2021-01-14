/*     */ package com.haut.grm.activiti.listener;
import com.alibaba.fastjson.JSONObject;
//import com.haut.grm.model.Gbhistorystockamount;
import com.haut.grm.model.MyStockSum;
import com.haut.grm.model.Store;
/*     */ 
/*     */ import com.haut.grm.model.business.BusinessData;
/*     */ import com.haut.grm.model.business.BusinessNotification;
import com.haut.grm.model.business.WorkloadSchedule;
/*     */ import com.haut.grm.model.meta.ActivitiGroup;
/*     */ import com.haut.grm.model.meta.User;
import com.haut.grm.model.type.WorkloadCategory;
//import com.haut.grm.repository.GbhistorystockamountRepository;
import com.haut.grm.repository.MyStockSumRepository;
import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.base.BusinessDataRepository;
import com.haut.grm.repository.business.WorkloadScheduleRepository;
/*     */ import com.haut.grm.repository.meta.ActivitiGroupRepository;
import com.haut.grm.repository.type.WorkloadCategoryRepository;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.util.ActivitiWebServiceUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.List;
import java.util.Map;

/*     */ import org.activiti.engine.FormService;
/*     */ import org.activiti.engine.HistoryService;
/*     */ import org.activiti.engine.RepositoryService;
/*     */ import org.activiti.engine.RuntimeService;
/*     */ import org.activiti.engine.TaskService;
/*     */ import org.activiti.engine.delegate.event.ActivitiEntityEvent;
/*     */ import org.activiti.engine.delegate.event.ActivitiEvent;
/*     */ import org.activiti.engine.delegate.event.ActivitiEventListener;
import org.activiti.engine.delegate.event.ActivitiEventType;
/*     */ import org.activiti.engine.history.HistoricProcessInstance;
/*     */ import org.activiti.engine.history.HistoricProcessInstanceQuery;
/*     */ import org.activiti.engine.task.IdentityLink;
/*     */ import org.activiti.engine.task.Task;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.annotation.Lazy;
/*     */ import org.springframework.stereotype.Component;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Component
/*     */ public class ProcessEventListener
/*     */   implements ActivitiEventListener
/*     */ {
/*     */   @Autowired
/*     */   @Lazy
/*     */   private RepositoryService repositoryService;
/*     */   @Autowired
/*     */   @Lazy
/*     */   private RuntimeService runtimeService;
/*     */   @Autowired
/*     */   @Lazy
/*     */   private TaskService taskService;
/*     */   @Autowired
/*     */   @Lazy
/*     */   private HistoryService historyService;
/*     */   @Autowired
/*     */   @Lazy
/*     */   private FormService formService;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   @Autowired
/*     */   private BusinessDataRepository bdRepo;
/*     */   @Autowired
/*     */   private ActivitiGroupRepository agRepo;
@Autowired
private WorkloadScheduleRepository workRepo;

@Autowired
private StoreRepository storeRepo;

@Autowired
private WorkloadCategoryRepository workTypeRepo;


//	@Autowired
//	private GbhistorystockamountRepository gbhistoryamountRepo;
	
	@Autowired
	private MyStockSumRepository mystocksumRepo;


/*     */   
/*     */   public void onEvent(ActivitiEvent event)
/*     */   {
	
	
	if(event.getType()==ActivitiEventType.TASK_COMPLETED) {
		HistoricProcessInstance pi = (HistoricProcessInstance)this.historyService.createHistoricProcessInstanceQuery()
				.processInstanceId(event.getProcessInstanceId()).singleResult();
		User user = this.commonService.getUserByUsername(pi.getStartUserId());
		BusinessNotification notif = new BusinessNotification();
		notif.setUser(user);
		notif.setContent("用户 " + user.getOfficialName() + " 流程" + pi.getProcessDefinitionName() + " " + pi.getBusinessKey() + "结束 ");
		notif.setTitle(pi.getProcessDefinitionName() + " 结束");
		notif.setTime(new Date());
		BusinessData data = this.bdRepo.findByBusinessKey(pi.getBusinessKey());
//		System.out.println(data.getContent());
	}
	
//				boolean myb=true;
//				if(myb) {
//					return;
//				}
	
	
	
/*  60 */     switch (event.getType())
/*     */     {
/*     */     case PROCESS_COMPLETED_WITH_ERROR_END_EVENT: 
/*  63 */       Task task = (Task)((ActivitiEntityEvent)event).getEntity();
/*  64 */       sendNotificationForTaskCreated(task);
/*  65 */       break;
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     case TASK_COMPLETED: 
				System.out.println("complete");
/*  75 */       HistoricProcessInstance pi = 
/*     */       
/*  77 */         (HistoricProcessInstance)this.historyService.createHistoricProcessInstanceQuery().processInstanceId(event.getProcessInstanceId()).singleResult();
/*  78 */       BusinessData data = this.bdRepo.findByBusinessKey(pi.getBusinessKey());
Map<String,Object> map = JSONObject.parseObject(data.getContent());

if(Integer.valueOf(map.get("step").toString())<1) {
	System.out.println("step:"+Integer.valueOf(map.get("step").toString()));
	return;
}

User user = this.commonService.getUserByUsername(pi.getStartUserId());
/*  79 */       BusinessNotification notif = new BusinessNotification();
/*  80 */       notif.setUser(user);
/*  81 */       notif.setContent("用户 " + user.getOfficialName() + " 流程" + pi.getProcessDefinitionName() + " " + pi.getBusinessKey() + "结束 ");
/*  82 */       notif.setTitle(pi.getProcessDefinitionName() + " 结束");
/*  83 */       notif.setTime(new Date());
/*     */       




if("workload".equals(data.getUrl())) {
	System.out.println(data.getContent());
	Map<String,Object> jsonToMap = JSONObject.parseObject(data.getContent());
	
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	SimpleDateFormat sdf2=new SimpleDateFormat("yyyy-MM-dd");
	
	WorkloadSchedule work=new WorkloadSchedule();
	String startTime=jsonToMap.get("startTime").toString();
	String endTime=jsonToMap.get("endTime").toString();
	Date startDate=null;
	Date endDate=null;
	try {
		startDate=sdf2.parse(jsonToMap.get("startDate").toString());
		endDate=sdf2.parse(jsonToMap.get("endDate").toString());
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	WorkloadCategory wtype=workTypeRepo.getOne(Long.valueOf(jsonToMap.get("categoryId").toString()));
	Store store=storeRepo.getOne(Long.valueOf(jsonToMap.get("storeId").toString()));
	work.setBusinessKey(data.getBusinessKey());
	work.setStartDate(startDate);
	work.setEndDate(endDate);
	work.setStartTime(startTime);
	work.setEndTime(endTime);
	work.setStore(store);
	work.setCategory(wtype);
	work.setColor(jsonToMap.get("color").toString());
	workRepo.save(work);
	return;
}


/*  86 */       if (data != null)
/*     */       {
	
	
	
/*     */         try {
					System.out.println(data.getContent());//原来是监听这complete  在这里生成货位  原来里面存的地址也是为 存储货位用的请求地址
/*  89 */           ActivitiWebServiceUtil.saveData(data.getUrl(), data.getContent());
/*     */         }
/*     */         catch (Exception e)
/*     */         {
/*  93 */           notif.setContent(notif.getContent() + "  \n数据保存错误");
/*  94 */           e.printStackTrace();
/*     */         }
/*  96 */         this.commonService.createNotification(notif); 




System.out.println(data.getUrl());

String[] strs=data.getUrl().split("/");
String wei=strs[strs.length-1];
System.out.println("wei:"+wei);
if("stockChanges".equals(wei)) {
//	Map<String,Object> jsonToMap = JSONObject.parseObject(data.getContent());
//	System.out.println(jsonToMap);
//	System.out.println(jsonToMap.get("targetStock"));
//	System.out.println(jsonToMap.get("sourceStock"));
//	String businessKey=jsonToMap.get("businessKey").toString();
//	Date now=new Date();
////	businessKey
//	
//	if(jsonToMap.get("targetStock")!=null) {
//		String[] mytargets=jsonToMap.get("targetStock").toString().split("/");
//		String mytarget=mytargets[mytargets.length-1];
//		
//		if(mytarget!=null) {
//			Long stockid=Long.valueOf(mytarget);
//			System.out.println("stockid:"+stockid);
//			MyStockSum my1=mystocksumRepo.findOne(stockid);
//			System.out.println(my1.getHasamount());
//			
//			Gbhistorystockamount gbha=new Gbhistorystockamount();
//			
//			gbha.setAmount(my1.getHasamount()+Double.valueOf(jsonToMap.get("amount").toString()));
//			
//			gbha.setStockid(stockid.intValue());
//			gbha.setBusinesskey(businessKey);
//			gbha.setInput_time(now);
//			gbha.setInorout(1);
//			gbhistoryamountRepo.save(gbha);
//		}
//	}
//	
//	if(jsonToMap.get("sourceStock")!=null) {
//		String[] sourstocks=jsonToMap.get("sourceStock").toString().split("/");
//		String mysource=sourstocks[sourstocks.length-1];
//		
//		if(mysource!=null) {
//			Long stockid=Long.valueOf(mysource);
//			System.out.println("stockid:"+stockid);
//			
//			MyStockSum my1=mystocksumRepo.findOne(stockid);
//			System.out.println(my1.getHasamount());
//			
//			
//			Gbhistorystockamount gbha=new Gbhistorystockamount();
//			
//			gbha.setAmount(my1.getHasamount()-Double.valueOf(jsonToMap.get("amount").toString()));
//			
//			gbha.setStockid(stockid.intValue());
//			gbha.setBusinesskey(businessKey);
//			gbha.setInput_time(now);
//			gbha.setInorout(0);//出
//			
//			gbhistoryamountRepo.save(gbha);
//			
//		}
//	}
	
	
}
System.out.println("结束");


				
				

}
/*  97 */       break;
/*     */     }
/*     */     
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public boolean isFailOnException()
/*     */   {
/* 107 */     return false;
/*     */   }
/*     */   
/*     */   private void sendNotificationForTaskCreated(Task task) {
/* 111 */     List<IdentityLink> links = this.taskService.getIdentityLinksForTask(task.getId());
/* 112 */     for (IdentityLink link : links) {
/* 113 */       if (("candidate".equals(link.getType())) && (link.getUserId() != null)) {
/* 114 */         User user = this.commonService.getUserByUsername(link.getUserId());
/* 115 */         if (user != null)
/*     */         {
/* 117 */           BusinessNotification notif = new BusinessNotification();
/* 118 */           notif.setUser(user);
/* 119 */           notif.setContent("您是该业务的负责人之一,请酌情完成该任务");
/* 120 */           notif.setTitle(task.getName());
/* 121 */           notif.setTime(new Date());
/* 122 */           this.commonService.createNotification(notif);
/*     */         }
/* 124 */       } else if (("candidate".equals(link.getType())) && (link.getGroupId() != null)) {
/* 125 */         String[] _roles = link.getGroupId().split(";");
/* 126 */         String[] arrayOfString1; int j = (arrayOfString1 = _roles).length; for (int i = 0; i < j; i++) { String _role = arrayOfString1[i];
/* 127 */           ActivitiGroup role = this.agRepo.findByCode(_role.trim());
/* 128 */           if (role != null)
/*     */           {
/* 130 */             BusinessNotification notif = new BusinessNotification();
/* 131 */             notif.setActivitiGroup(role);
/* 132 */             notif.setContent("您属于" + role.getName() + "的负责群组,请尽快完成该审核任务");
/* 133 */             notif.setTitle(task.getName());
/* 134 */             notif.setTime(new Date());
/* 135 */             this.commonService.createNotification(notif);
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\activiti\listener\ProcessEventListener.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */