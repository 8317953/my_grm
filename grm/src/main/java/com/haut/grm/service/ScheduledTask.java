///*     */ package com.haut.grm.service;
///*     */ 
///*     */ import com.haut.grm.model.Company;
///*     */ import com.haut.grm.model.Door;
///*     */ import com.haut.grm.model.Store;
///*     */ import com.haut.grm.model.StoreStatus;
///*     */ import com.haut.grm.model.dto.TemperatureDataDto;
///*     */ import com.haut.grm.model.entry.DoorCollect;
///*     */ import com.haut.grm.model.entry.EntryDoor;
///*     */ import com.haut.grm.model.entry.EntryTemperature;
///*     */ import com.haut.grm.model.type.DoorState;
///*     */ import com.haut.grm.repository.CompanyRepository;
///*     */ import com.haut.grm.repository.StoreRepository;
///*     */ import com.haut.grm.repository.entry.EntryTemperatureRepository;
///*     */ import com.haut.grm.shengju.ShengjuService;
///*     */ import com.haut.grm.util.JSONUtil;
///*     */ import com.haut.grm.util.MeasureWebServiceUtil;
///*     */ import com.haut.grm.util.TemperatureUtil;
///*     */ import java.io.PrintStream;
///*     */ import java.util.Date;
///*     */ import java.util.HashMap;
///*     */ import java.util.Iterator;
///*     */ import java.util.List;
///*     */ import java.util.Map;
///*     */ import org.springframework.beans.factory.annotation.Autowired;
///*     */ import org.springframework.stereotype.Service;
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ @Service
///*     */ public class ScheduledTask
///*     */ {
///*     */   @Autowired
///*     */   private CommonService commonService;
///*     */   @Autowired
///*     */   private CompanyRepository companyRepo;
///*     */   @Autowired
///*     */   private StoreService storeService;
///*     */   @Autowired
///*     */   private StoreRepository storeRepo;
///*     */   @Autowired
///*     */   private EntryService entryService;
///*     */   @Autowired
///*     */   private EntryTemperatureRepository etRepo;
///*     */   @Autowired
///*     */   private MeasureTaskService measureTaskExecutor;
///*     */   
///*     */   public void tempScan()
///*     */   {
///*  51 */     if (!this.commonService.moduleActive("TEMP")) {
///*  52 */       return;
///*     */     }
///*  54 */     List<Store> stores = this.storeService.getAllCenterStores();
///*  55 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
///*     */     
///*  57 */     Iterator localIterator = stores.iterator(); break label263; for (;;) { Store store = (Store)localIterator.next();
///*  58 */       EntryTemperature et = new EntryTemperature();
///*     */       try {
///*  60 */         String coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
///*  61 */         String data = null;
///*  62 */         TemperatureDataDto temp = null;
///*     */         try {
///*  64 */           temp = TemperatureUtil.executeGetTemperature(coreUrl, store, Integer.valueOf(this.commonService.getSystemVariableWithKey("TEMP_WAIT")));
///*  65 */           data = JSONUtil.objectToJson(temp);
///*     */         }
///*     */         catch (Exception e) {
///*     */           try {
///*  69 */             temp = TemperatureUtil.executeGetTemperature(coreUrl, store, Integer.valueOf(this.commonService.getSystemVariableWithKey("TEMP_WAIT")));
///*  70 */             data = JSONUtil.objectToJson(temp);
///*     */           }
///*     */           catch (Exception e2) {
///*  73 */             temp = TemperatureUtil.executeGetTemperature(coreUrl, store, Integer.valueOf(this.commonService.getSystemVariableWithKey("TEMP_WAIT")));
///*  74 */             data = JSONUtil.objectToJson(temp);
///*     */           }
///*     */         }
///*  77 */         et.setData(data);
///*  78 */         et.setStore(store);
///*  79 */         et.setTime(new Date());
///*  80 */         this.etRepo.saveAndFlush(et);
///*     */         try {
///*  82 */           ShengjuService.getInstance().sendTemperature(temp, company, store, et.getTime(), (Long)et.getId(), "create");
///*     */         } catch (Throwable e) {
///*  84 */           System.out.println("定时粮情上传失败");
///*  85 */           e.printStackTrace();
///*     */         }
///*  57 */         if (localIterator.hasNext()) {}
///*     */       }
///*     */       catch (Exception localException1) {}
///*     */     }
///*     */     
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */     label263:
///*     */     
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*  91 */     this.commonService.createNotifyLog("完成定时粮情检测");
///*     */   }
///*     */   
///*     */   public void safetyRestart() {
///*  95 */     String coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
///*     */     try {
///*  97 */       MeasureWebServiceUtil.execute(coreUrl, "renyuanRestart", null);
///*     */     } catch (Exception e) {
///*  99 */       this.commonService.createNotifyLog("人员安全设备重启失败");
///* 100 */       e.printStackTrace();
///*     */     }
///*     */   }
///*     */   
///*     */   public void measureAll() {
///* 105 */     List<Store> stores = this.storeRepo.findByDepot_Id(new Long(1L));
///* 106 */     for (Store store : stores) {
///* 107 */       if (!store.getStatus().getIsMeasureOngoing().booleanValue())
///* 108 */         this.measureTaskExecutor.startMeasure(store, false, null, true);
///*     */     }
///*     */   }
///*     */   
///*     */   public void doorCollectAll() {
///* 113 */     if (!this.commonService.moduleActive("DOOR")) {
///* 114 */       return;
///*     */     }
///*     */     
///* 117 */     List<EntryDoor> eds = this.entryService.getEntryDoorsInRecent(Integer.valueOf(24));
///* 118 */     long openCount = 0L;
///* 119 */     long closeCount = 0L;
///* 120 */     Map<Door, Long> counts = new HashMap();
///* 121 */     for (EntryDoor ed : eds) {
///* 122 */       if (counts.get(ed.getDoor()) == null) {
///* 123 */         counts.put(ed.getDoor(), Long.valueOf(1L));
///*     */       }
///* 125 */       else if (ed.getState().getCodeId().intValue() != 3) {
///* 126 */         counts.put(ed.getDoor(), Long.valueOf(((Long)counts.get(ed.getDoor())).longValue() + 1L));
///*     */       }
///* 128 */       if (ed.getState().getCodeId().intValue() == 1)
///* 129 */         openCount += 1L;
///* 130 */       if (ed.getState().getCodeId().intValue() == 2) {
///* 131 */         closeCount += 1L;
///*     */       }
///*     */     }
///* 134 */     long max = 0L;
///* 135 */     Door maxDoor = null;
///* 136 */     for (Door door : counts.keySet()) {
///* 137 */       if (((Long)counts.get(door)).longValue() > max) {
///* 138 */         maxDoor = door;
///* 139 */         max = ((Long)counts.get(door)).longValue();
///*     */       }
///*     */     }
///* 142 */     DoorCollect dc = new DoorCollect();
///* 143 */     dc.setCloseCount(Long.valueOf(closeCount));
///* 144 */     dc.setOpenCount(Long.valueOf(openCount));
///* 145 */     dc.setComment(maxDoor.getStore().getName() + " - " + maxDoor.getName() + " (开关门总计:" + max + "次)");
///* 146 */     dc.setTime(new Date());
///* 147 */     this.entryService.createDoorCollect(dc);
///*     */   }
///*     */   
///*     */   public void generateMxzForToday() {}
///*     */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\ScheduledTask.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */