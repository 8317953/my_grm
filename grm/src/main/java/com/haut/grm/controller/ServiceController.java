/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.haut.grm.bean.GlobalHandler;
/*     */ import com.haut.grm.model.Door;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.repository.DoorRepository;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.service.EntryService;
/*     */ import com.haut.grm.service.StoreService;
/*     */ import com.haut.grm.util.MeasureWebServiceUtil;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import javax.servlet.ServletContext;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class ServiceController
/*     */ {
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   @Autowired
/*     */   private StoreService storeService;
/*     */   @Autowired
/*     */   private EntryService entryService;
/*     */   @Autowired
/*     */   private DoorRepository doorRepo;
/*     */   @Autowired
/*     */   private GlobalHandler _gHandler;
/*     */   @Autowired
/*     */   ServletContext servletContext;
/*     */   public static final String MODEL_ICON_ROOT_PATH = "/WEB-INF/assets/admin/pages/img/";
/*     */   public static final String MODEL_ICON_RELATIVE_PATH = "../assets/admin/pages/img/";
/*     */   
/*     */   @RequestMapping(value={"/grain_alarm"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public String grainAlarm(@RequestParam("barnCode") Integer storeCodeId, @RequestParam(value="door", required=false) Integer doorCodeId, @RequestParam("alarmType") Integer alarmType, @RequestParam(value="doorAlarmType", required=false) Integer doorAlarmType)
/*     */   {
/*  48 */     if (alarmType.intValue() == 2) {
/*  49 */       Door door = this.doorRepo.findByStore_Depot_IdAndStore_CodeIdAndCodeId(Long.valueOf(1L), storeCodeId, doorCodeId);
/*  50 */       this.entryService.createEntryDoor(door, 1);
/*     */     }
/*  52 */     if (alarmType.intValue() == 3) {
/*  53 */       Door door = this.doorRepo.findByStore_Depot_IdAndStore_CodeIdAndCodeId(Long.valueOf(1L), storeCodeId, doorCodeId);
/*  54 */       this.entryService.createEntryDoor(door, 2);
/*     */     }
/*  56 */     if (alarmType.intValue() == 4) {
/*  57 */       this.entryService.createEntrySafety(storeCodeId);
/*     */     }
/*  59 */     if (alarmType.intValue() == 5) {
/*  60 */       Door door = this.doorRepo.findByStore_Depot_IdAndStore_CodeIdAndCodeId(Long.valueOf(1L), storeCodeId, doorCodeId);
/*  61 */       this.entryService.createEntryDoor(door, 3);
/*     */     }
/*  63 */     return "true";
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   @RequestMapping(value={"/model_icon_upload"}, method={org.springframework.web.bind.annotation.RequestMethod.POST}, produces={"application/json"})
/*     */   public String handleFileUpload(@RequestParam("file") MultipartFile file)
/*     */   {
/*     */     try
/*     */     {
/*  76 */       BufferedOutputStream stream = 
/*  77 */         new BufferedOutputStream(new FileOutputStream(new File(this.servletContext.getRealPath("/WEB-INF/assets/admin/pages/img/"), file.getOriginalFilename())));
/*  78 */       stream.write(file.getBytes());
/*  79 */       stream.close();
/*     */     } catch (IOException e) {
/*  81 */       e.printStackTrace();
/*     */     }
/*  83 */     return "../assets/admin/pages/img/" + file.getOriginalFilename();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/refresh/hardware"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void refreshHardware() throws Exception {
/*  88 */     List<Store> stores = this.storeService.getAllCenterStores();
/*  89 */     for (Store store : stores) {
/*  90 */       this.storeService.storeSetMeasureOngoing(store, false);
/*     */     }
/*  92 */     String coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
/*  93 */     MeasureWebServiceUtil.execute(coreUrl, "stopService", null);
/*  94 */     Thread.sleep(5000L);
/*  95 */     MeasureWebServiceUtil.execute(coreUrl, "startService", null);
/*  96 */     coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_2.0");
/*  97 */     MeasureWebServiceUtil.execute(coreUrl, "stopService", null);
/*  98 */     Thread.sleep(5000L);
/*  99 */     MeasureWebServiceUtil.execute(coreUrl, "startService", null);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/restart/scheduler"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void restartScheduler() throws Exception {
/* 104 */     this._gHandler.restartScheduler();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/restart/context"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void restartContext() throws Exception {
/* 109 */     this._gHandler.reInit();
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\ServiceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */