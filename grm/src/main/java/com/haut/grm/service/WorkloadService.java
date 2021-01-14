/*    */ package com.haut.grm.service;
/*    */ 
/*    */ import com.haut.grm.model.Store;
/*    */ import com.haut.grm.model.business.WorkloadSchedule;
/*    */ import com.haut.grm.model.dto.WorkloadScheduleDto;
/*    */ import com.haut.grm.model.type.WorkloadCategory;
/*    */ import com.haut.grm.repository.StoreRepository;
/*    */ import com.haut.grm.repository.business.WorkloadScheduleRepository;
/*    */ import com.haut.grm.repository.type.WorkloadCategoryRepository;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class WorkloadService
/*    */ {
/*    */   @Autowired
/*    */   private WorkloadCategoryRepository wcRepo;
/*    */   @Autowired
/*    */   private WorkloadScheduleRepository wsRepo;
/*    */   @Autowired
/*    */   private StoreRepository storeRepo;
/*    */   @Autowired
/*    */   private CommonService commonService;
/*    */   
/*    */   public List<WorkloadCategory> getWorkloadCategories()
/*    */   {
/* 33 */     return this.wcRepo.findAll();
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public WorkloadCategory createWorkloadCategory(WorkloadCategory workloadCategory)
/*    */   {
/* 40 */     this.commonService.createCreateLog("新建仓内作业类型 [" + workloadCategory.getName() + "]");
/* 41 */     return (WorkloadCategory)this.wcRepo.save(workloadCategory);
/*    */   }
/*    */   
/*    */   public WorkloadCategory updateWorkloadCategory(WorkloadCategory workloadCategory)
/*    */   {
/* 46 */     this.commonService.createUpdateLog("修改仓内作业类型 [" + workloadCategory.getId() + "]");
/* 47 */     return (WorkloadCategory)this.wcRepo.save(workloadCategory);
/*    */   }
/*    */   
/*    */   public void deleteWorkloadCategory(WorkloadCategory workloadCategory) {
/* 51 */     this.commonService.createDeleteLog("删除仓内作业类型 [" + workloadCategory.getName() + 
/* 52 */       "] ~[" + workloadCategory.getId() + "]~");
/* 53 */     this.wcRepo.delete(workloadCategory);
/*    */   }
/*    */   
/*    */   public List<WorkloadSchedule> getWorkloadSchedules(Long id) {
/* 57 */     Store store = (Store)this.storeRepo.findOne(id);
/* 58 */     return this.wsRepo.findByStore(store);
/*    */   }
/*    */   
/*    */   public WorkloadSchedule createWorkloadSchedule(WorkloadScheduleDto workloadScheduleDto)
/*    */   {
/* 63 */     Store store = (Store)this.storeRepo.findOne(workloadScheduleDto.getStoreId());
/* 64 */     WorkloadCategory wc = (WorkloadCategory)this.wcRepo.findOne(workloadScheduleDto
/* 65 */       .getCategoryId());
/* 66 */     WorkloadSchedule ws = new WorkloadSchedule();
/* 67 */     ws.setCategory(wc);
/* 68 */     ws.setStore(store);
/* 69 */     ws.setColor(workloadScheduleDto.getColor());
/* 70 */     ws.setStartDate(workloadScheduleDto.getStartDate());
/* 71 */     ws.setEndDate(workloadScheduleDto.getEndDate());
/* 72 */     ws.setStartTime(workloadScheduleDto.getStartTime());
/* 73 */     ws.setEndTime(workloadScheduleDto.getEndTime());
/* 74 */     SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");
/* 75 */     this.commonService.createCreateLog("新建仓内作业 [日期: " + 
/* 76 */       myFmt.format(ws.getStartDate()) + " - " + 
/* 77 */       myFmt.format(ws.getEndDate()) + " 时间段: " + ws.getStartTime() + 
/* 78 */       " - " + ws.getEndTime() + " 类型:" + ws.getCategory().getName() + 
/* 79 */       " ]");
/* 80 */     return (WorkloadSchedule)this.wsRepo.save(ws);
/*    */   }
/*    */   
/*    */   public void deleteWorkloadSchedule(Long workloadScheduleId) {
/* 84 */     WorkloadSchedule ws = (WorkloadSchedule)this.wsRepo.getOne(workloadScheduleId);
/* 85 */     SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日");
/* 86 */     this.commonService.createDeleteLog("删除仓内作业 [日期: " + 
/* 87 */       myFmt.format(ws.getStartDate()) + " - " + 
/* 88 */       myFmt.format(ws.getEndDate()) + " 时间段: " + ws.getStartTime() + 
/* 89 */       " - " + ws.getEndTime() + " 类型:" + ws.getCategory().getName() + 
/* 90 */       " ]");
/* 91 */     this.wsRepo.delete(ws);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\WorkloadService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */