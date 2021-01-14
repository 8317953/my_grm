/*     */ package com.haut.grm.bean;
/*     */ 
/*     */ import com.haut.grm.model.system.SystemStatus;
/*     */ import com.haut.grm.repository.system.SystemStatusRepository;
///*     */ import com.haut.grm.sdk.DjhuaCamera;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import java.io.PrintStream;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.event.ContextRefreshedEvent;
/*     */ import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
/*     */ import org.springframework.scheduling.support.CronTrigger;
/*     */ 
/*     */ @org.springframework.stereotype.Component
/*     */ public class GlobalHandler
/*     */ {
	
	
	/*
	 * 定时服务 在bean 里gloablehanderl     包含定时服务
	 */
	
	
	
	
	
	
	
	
	
	
	
	
/*     */   private static ThreadPoolTaskScheduler taskScheduler;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   @Autowired
/*     */   private com.haut.grm.service.TrafficService trafficService;
/*     */   @Autowired
/*     */   private SystemStatusRepository statusRepo;
/*     */   @Autowired
/*     */   private com.haut.grm.repository.CompanyRepository companyRepo;
/*     */   @Autowired
/*     */   private com.haut.grm.repository.business.StockSumRepository sumRepo;
/*     */   @Autowired
/*     */   private com.haut.grm.service.DeviceService deviceService;
///*     */   @Autowired
///*     */   private com.haut.grm.service.ScheduledTask tasks;
/*     */   private static ScheduledFuture<?> tempFuture;
/*     */   private static ScheduledFuture<?> measureFuture;
/*     */   private static ScheduledFuture<?> doorCollectFuture;
/*     */   private static ScheduledFuture<?> scCollectFuture;
/*     */   private static ScheduledFuture<?> ledOnFuture;
/*     */   private static ScheduledFuture<?> ledOffFuture;
/*     */   
/*     */   public static ThreadPoolTaskScheduler getScheduler()
/*     */   {
/*  41 */     return taskScheduler;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   private void initTaskScheduler()
/*     */   {
/*  78 */     taskScheduler = new ThreadPoolTaskScheduler();
/*  79 */     taskScheduler.setPoolSize(100);
/*  80 */     taskScheduler.setThreadNamePrefix("GRM_TaskScheduler");
/*  81 */     taskScheduler.setWaitForTasksToCompleteOnShutdown(false);
/*  82 */     taskScheduler.initialize();
/*     */   }
/*     */   
/*     */   @org.springframework.context.event.EventListener({ContextRefreshedEvent.class})
/*     */   private void onApplicationRefreshed(ContextRefreshedEvent event) {
/*  87 */     if (event.getApplicationContext().getParent() != null)
/*  88 */       return;
/*  89 */     if (taskScheduler == null)
/*  90 */       initTaskScheduler();
/*  91 */     reInit();
/*     */   }
/*     */   
/*     */   @org.springframework.context.event.EventListener({org.springframework.context.event.ContextClosedEvent.class})
/*     */   private void onApplicationClosed(org.springframework.context.event.ContextClosedEvent event) {
/*  96 */     taskScheduler.shutdown();
/*  97 */     taskScheduler.getScheduledExecutor().shutdown();
/*  98 */     taskScheduler.destroy();
/*     */   }
/*     */   
/*     */   public void reInit()
/*     */   {
///* 103 */     initScale();///////////////////////////////////////////////////////////////////////////////////初始化
///* 104 */     initLed();
///*     */     
///* 106 */     initDjhua();
///* 107 */     initHk();
///* 108 */     initWd();
///*     */     
///* 110 */     initCore();
///* 111 */     restartScheduler();
/*     */   }
/*     */   //这里就是定时服务所在！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！-------------------------------------
/*     */   public void initScheduler() {
/* 115 */     SystemStatus _sched = this.statusRepo.findByCode("SCHEDULER");
/* 116 */     if (this.commonService.moduleActive("SCHEDULER_TEMP")) {
/* 117 */       Runnable taskTemp = new Runnable() {
/*     */         public void run() {
///* 119 */           GlobalHandler.this.tasks.tempScan();
/* 120 */           GlobalHandler.this.commonService.createSystemLog("开始自动数获取粮情");
/*     */         }
/* 122 */       };
/* 123 */       tempFuture = taskScheduler.schedule(taskTemp, new CronTrigger(this.commonService.getSystemVariableWithKey("SCHEDULE_TEMP_CRON")));
/*     */     }
/* 125 */     if (this.commonService.moduleActive("SCHEDULER_MEASURE")) {
/* 126 */       Runnable taskMeasure = new Runnable() {
/*     */         public void run() {
///* 128 */           GlobalHandler.this.tasks.measureAll();
/* 129 */           GlobalHandler.this.commonService.createSystemLog("开始自动数量监测");
/* 130 */           com.haut.grm.model.Company company = (com.haut.grm.model.Company)GlobalHandler.this.companyRepo.findOne(Long.valueOf(1L));
/* 131 */           java.util.List<com.haut.grm.model.business.StockSum> datas = GlobalHandler.this.sumRepo.findByCargo_Compartment_Store_Depot_Id(Long.valueOf(1L));
/*     */           try {
///* 133 */             com.haut.grm.shengju.ShengjuService.getInstance().sendStockSums(datas, company, "create", GlobalHandler.this.commonService);
/*     */           } catch (Throwable e) {
/* 135 */             System.out.println("定时数量统计上传省局失败");
/*     */           }
/*     */         }
/* 138 */       };
/* 139 */       measureFuture = taskScheduler.schedule(taskMeasure, new CronTrigger(this.commonService.getSystemVariableWithKey("SCHEDULE_MEASURE_CRON")));
/*     */     }
/* 141 */     if (this.commonService.moduleActive("DOOR")) {
/* 142 */       Runnable taskDoorCollect = new Runnable() {
/*     */         public void run() {
///* 144 */           GlobalHandler.this.tasks.doorCollectAll();
/*     */         }
/* 146 */       };
/* 147 */       doorCollectFuture = taskScheduler.schedule(taskDoorCollect, new CronTrigger(this.commonService.getSystemVariableWithKey("SCHEDULE_DOOR_COLLECT_CRON")));
/*     */     }
/* 149 */     Runnable taskScCollect = new Runnable() {
/*     */       public void run() {
///* 151 */         GlobalHandler.this.trafficService.generateStockChangeFromGrainTrafficIn24Hours();
/*     */       }
/* 153 */     };
/* 154 */     scCollectFuture = taskScheduler.schedule(taskScCollect, new CronTrigger("0 0 2 * * ?"));
/* 155 */     Runnable ledOn = new Runnable() {
/*     */       public void run() {
/*     */         try {
///* 158 */           com.haut.grm.util.LEDUtil.turnOn();
///* 159 */           com.haut.grm.util.LEDUtil.refreshDynamic();
/*     */         } catch (Exception e) {
/* 161 */           GlobalHandler.this.commonService.createSystemLog("LED刷新屏幕内容失败");
/* 162 */           System.out.println("LED刷新屏幕内容失败");
/*     */         }
/*     */       }
/* 165 */     };
/* 166 */     Runnable ledOff = new Runnable() {
/*     */       public void run() {
/*     */         try {
/*     */           
/*     */         } catch (Exception e) {
/* 171 */           GlobalHandler.this.commonService.createSystemLog("LED关闭屏幕失败");
/* 172 */           System.out.println("LED关闭屏幕失败");
/*     */         }
/*     */       }
/* 175 */     };
/* 176 */     ledOnFuture = taskScheduler.schedule(ledOn, new CronTrigger(this.commonService.getSystemVariableWithKey("SCHEDULE_LED_ON_CRON")));
/* 177 */     ledOffFuture = taskScheduler.schedule(ledOff, new CronTrigger(this.commonService.getSystemVariableWithKey("SCHEDULE_LED_OFF_CRON")));
/* 178 */     _sched.setValue(Boolean.valueOf(true));
/* 179 */     this.statusRepo.save(_sched);
/*     */   }
/*     */   
/*     */   public void initDjhua()
/*     */   {
/* 184 */     SystemStatus _dh = this.statusRepo.findByCode("DH_SDK");
/* 185 */     SystemStatus _dhc = this.statusRepo.findByCode("DH_CALLBACK");
/*     */     try {
///* 187 */       DjhuaCamera.getInstance();
/* 188 */       _dh.setValue(Boolean.valueOf(true));
/* 189 */       System.out.println("大华SDK 初始化成功");
/* 190 */       java.util.Set<com.haut.grm.model.DeviceCamera> cameras = this.deviceService.getCameraWithTypeCodeId(2);
/*     */       try {
///* 192 */         for (com.haut.grm.model.DeviceCamera camera : cameras)
///* 193 */           DjhuaCamera.getInstance().disconnect(camera);
///* 194 */         for (com.haut.grm.model.DeviceCamera camera : cameras)
///* 195 */           DjhuaCamera.getInstance().connect(camera);
/* 196 */         _dhc.setValue(Boolean.valueOf(true));
/* 197 */         System.out.println("大华车牌回调 初始化成功，车牌设备数量：" + cameras.size());
/*     */       } catch (Throwable e) {
/* 199 */         e.printStackTrace();
/* 200 */         _dhc.setValue(Boolean.valueOf(false));
/* 201 */         System.out.println("大华车牌回调 初始化失败，车牌设备数量：" + cameras.size());
/*     */       }
/*     */       
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 209 */       this.statusRepo.save(_dh);
/*     */     }
/*     */     catch (Throwable e)
/*     */     {
/* 204 */       e.printStackTrace();
/* 205 */       System.out.println("大华SDK 初始化失败");
/* 206 */       _dh.setValue(Boolean.valueOf(false));
/* 207 */       _dhc.setValue(Boolean.valueOf(false));
/*     */     }
/*     */     
/* 210 */     this.statusRepo.save(_dhc);
/*     */   }
/*     */   
/*     */   public void initLed() {
/* 214 */     SystemStatus _led = this.statusRepo.findByCode("LED");
/*     */     try {
///* 216 */       com.haut.grm.util.LEDUtil.initLED(this.commonService.getSystemVariableWithKey("LED_IP"));
/* 217 */       _led.setValue(Boolean.valueOf(true));
/* 218 */       System.out.println("LED 初始化成功");
/*     */     } catch (Throwable e) {
/* 220 */       e.printStackTrace();
/* 221 */       System.out.println("LED 初始化失败");
/* 222 */       _led.setValue(Boolean.valueOf(false));
/*     */     }
/* 224 */     this.statusRepo.save(_led);
/*     */   }
/*     */   
/*     */   public void initCore() {
/* 228 */     SystemStatus _core = this.statusRepo.findByCode("CORE");
/*     */     try {
/* 230 */       String coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
/* 231 */       com.haut.grm.util.MeasureWebServiceUtil.execute(coreUrl, "getOnlineZhuji", null);
/* 232 */       coreUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_2.0");
/* 233 */       com.haut.grm.util.MeasureWebServiceUtil.execute(coreUrl, "getOnlineZhuji", null);
/* 234 */       _core.setValue(Boolean.valueOf(true));
/* 235 */       System.out.println("核心服务 初始化成功");
/*     */     } catch (Throwable e) {
/* 237 */       e.printStackTrace();
/* 238 */       _core.setValue(Boolean.valueOf(false));
/* 239 */       System.out.println("核心服务 初始化失败");
/*     */     }
/*     */   }
/*     */   
/*     */   public void initScale() {
/* 244 */     SystemStatus _scale = this.statusRepo.findByCode("SCALE");
/*     */     try
/*     */     {
/* 247 */       com.haut.grm.util.ScaleSocketUtil.init(this.commonService.getSystemVariableWithKey("SCALE_PORT"));
/* 248 */       _scale.setValue(Boolean.valueOf(true));
/* 249 */       System.out.println("地磅 初始化成功");
/*     */     } catch (Throwable e) {
/* 251 */       e.printStackTrace();
/* 252 */       System.out.println("地磅 初始化失败");
/* 253 */       _scale.setValue(Boolean.valueOf(true));
/*     */     }
/* 255 */     this.statusRepo.save(_scale);
/*     */   }
/*     */   
/*     */   public void initWd() {
/* 259 */     SystemStatus _wd = this.statusRepo.findByCode("WD_SDK");
/*     */     try {
/* 261 */       com.haut.grm.sdk.IpCamera.getInstance();
/* 262 */       _wd.setValue(Boolean.valueOf(true));
/* 263 */       System.out.println("微电SDK 初始化成功");
/*     */     } catch (Throwable e) {
/* 265 */       e.printStackTrace();
/* 266 */       _wd.setValue(Boolean.valueOf(false));
/* 267 */       System.out.println("微电SDK 初始化失败");
/*     */     }
/* 269 */     this.statusRepo.save(_wd);
/*     */   }
/*     */   
/*     */   public void initHk() {
/* 273 */     SystemStatus _hk = this.statusRepo.findByCode("HK_SDK");
/*     */     try {
/* 275 */       com.haut.grm.sdk.HkCamera.getInstance();
/* 276 */       _hk.setValue(Boolean.valueOf(true));
/* 277 */       System.out.println("海康SDK 初始化成功");
/*     */     } catch (Throwable e) {
/* 279 */       e.printStackTrace();
/* 280 */       _hk.setValue(Boolean.valueOf(false));
/* 281 */       System.out.println("海康SDK 初始化失败");
/*     */     }
/* 283 */     this.statusRepo.save(_hk);
/*     */   }
/*     */   
/*     */   public void restartScheduler() {
/* 287 */     if (tempFuture != null) {
/* 288 */       tempFuture.cancel(true);
/* 289 */       tempFuture = null;
/*     */     }
/* 291 */     if (measureFuture != null) {
/* 292 */       measureFuture.cancel(true);
/* 293 */       measureFuture = null;
/*     */     }
/* 295 */     if (doorCollectFuture != null) {
/* 296 */       doorCollectFuture.cancel(true);
/* 297 */       doorCollectFuture = null;
/*     */     }
/* 299 */     if (scCollectFuture != null) {
/* 300 */       scCollectFuture.cancel(true);
/* 301 */       scCollectFuture = null;
/*     */     }
/* 303 */     if (ledOnFuture != null) {
/* 304 */       ledOnFuture.cancel(true);
/* 305 */       ledOnFuture = null;
/*     */     }
/* 307 */     if (ledOffFuture != null) {
/* 308 */       ledOffFuture.cancel(true);
/* 309 */       ledOffFuture = null;
/*     */     }
/* 311 */     initScheduler();
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\GlobalHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */