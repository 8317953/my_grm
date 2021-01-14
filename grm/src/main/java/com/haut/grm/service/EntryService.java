/*     */ package com.haut.grm.service;
/*     */ 
/*     */ import com.haut.grm.datatables.repository.DoorCollectDataTablesRepository;
/*     */ import com.haut.grm.datatables.repository.MeasureDiffDataTablesRepository;
/*     */ import com.haut.grm.model.Company;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreStatus;
/*     */ import com.haut.grm.model.entry.DoorCollect;
/*     */ import com.haut.grm.model.entry.EntryDoor;
/*     */ import com.haut.grm.model.entry.EntryMeasure;
/*     */ import com.haut.grm.model.entry.EntrySafety;
/*     */ import com.haut.grm.model.entry.EntryTemperature;
/*     */ import com.haut.grm.model.entry.MeasureDiff;
/*     */ import com.haut.grm.repository.CompanyRepository;
/*     */ import com.haut.grm.repository.DoorRepository;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.entry.EntryDoorRepository;
/*     */ import com.haut.grm.repository.entry.EntryMeasureRepository;
/*     */ import com.haut.grm.repository.entry.EntrySafetyRepository;
/*     */ import com.haut.grm.repository.entry.EntryTemperatureRepository;
/*     */ import com.haut.grm.repository.type.DoorStateRepository;
///*     */ import com.haut.grm.shengju.ShengjuService;
/*     */ import com.haut.grm.util.MeasureWebServiceUtil;
/*     */ import com.haut.grm.util.MessageProducer;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import javax.jms.JMSException;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
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
/*     */ @Service
/*     */ public class EntryService
/*     */ {
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private CompanyRepository companyRepo;
/*     */   @Autowired
/*     */   private EntryMeasureRepository entryMeasureRepo;
/*     */   @Autowired
/*     */   private EntryDoorRepository entryDoorRepo;
/*     */   @Autowired
/*     */   private EntryTemperatureRepository entryTemperatureRepo;
/*     */   @Autowired
/*     */   private MeasureDiffDataTablesRepository mdRepo;
/*     */   @Autowired
/*     */   private DoorCollectDataTablesRepository dcRepo;
/*     */   @Autowired
/*     */   private EntrySafetyRepository entrySafetyRepo;
/*     */   @Autowired
/*     */   private DoorStateRepository doorStateRepo;
/*     */   @Autowired
/*     */   private DoorRepository doorRepo;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   @Autowired
/*     */   private DeviceService deviceService;
/*     */   @Autowired
/*     */   private MessageProducer amqSender;
/*     */   
/*     */   public long countEntrySafety()
/*     */   {
/*  84 */     return this.entrySafetyRepo.count();
/*     */   }
/*     */   
/*     */   public long countEntryDoor() {
/*  88 */     return this.entryDoorRepo.count();
/*     */   }
/*     */   
/*     */   public long countEntryMeasure() {
/*  92 */     return this.entryMeasureRepo.count();
/*     */   }
/*     */   
/*     */   public long countEntryTemp() {
/*  96 */     return this.entryTemperatureRepo.count();
/*     */   }
/*     */   
/*     */   public long countEntryTempByStore(Long id) {
/* 100 */     return this.entryTemperatureRepo.countByStore_Id(id);
/*     */   }
/*     */   
/*     */   public long countEntrySafetyByStore(Long id) {
/* 104 */     return this.entrySafetyRepo.countByStore_Id(id);
/*     */   }
/*     */   
/*     */   public long countEntrySafetyByStoreAndIsActive(Long id, Boolean isActive) {
/* 108 */     return this.entrySafetyRepo.countByStore_IdAndActive(id, isActive);
/*     */   }
/*     */   
/*     */   public long countEntryDoorByStore(Long id) {
/* 112 */     return this.entryDoorRepo.countByDoor_Store_Id(id);
/*     */   }
/*     */   
/*     */   public long countEntryMeasureByStore(Long id) {
/* 116 */     return this.entryMeasureRepo.countByStore_Id(id);
/*     */   }
/*     */   
/*     */   public List<EntrySafety> getAllEntrySafetiesAlerting() {
/* 120 */     return this.entrySafetyRepo.findByActiveAndStoreNotNull(true);
/*     */   }
/*     */   
/*     */   public List<EntryMeasure> getAllEntryMeasures() {
/* 124 */     return this.entryMeasureRepo.findAll();
/*     */   }
/*     */   
/*     */   public EntryTemperature getEntryTemperatureById(Long id) {
/* 128 */     return (EntryTemperature)this.entryTemperatureRepo.findOne(id);
/*     */   }
/*     */   
/*     */   public List<EntryTemperature> getAllEntryTemperatures(Long storeId, Date start, Date end)
/*     */   {
/* 133 */     if (storeId != null) {
/* 134 */       return 
/* 135 */         this.entryTemperatureRepo.findByStoreAndTimeBetweenOrderByTimeDesc(
/* 136 */         (Store)this.storeRepo.findOne(storeId), start, end);
/*     */     }
/* 138 */     return this.entryTemperatureRepo.findByTimeBetweenOrderByTimeDesc(start, 
/* 139 */       end);
/*     */   }
/*     */   
/*     */   public List<EntryTemperature> getAllEntryTemperatures(Date start, Date end, List<Long> storeIds)
/*     */   {
/* 144 */     return 
/* 145 */       this.entryTemperatureRepo.findByTimeBetweenAndStore_IdInOrderByTimeDesc(start, end, 
/* 146 */       storeIds);
/*     */   }
/*     */   
/*     */   public List<EntryMeasure> getNewestEntryMeasures() {
/* 150 */     return this.entryMeasureRepo.findTop6ByStoreNotNullOrderByTimeDesc();
/*     */   }
/*     */   
/*     */   public List<EntrySafety> getNewestEntrySafeties() {
/* 154 */     return this.entrySafetyRepo.findTop6ByStoreNotNullOrderByTimeDesc();
/*     */   }
/*     */   
/*     */   public List<EntryTemperature> getNewestEntryTemps() {
/* 158 */     return this.entryTemperatureRepo.findTop6ByOrderByTimeDesc();
/*     */   }
/*     */   
/*     */   public EntryTemperature getNewestEntryTemp() {
/* 162 */     return this.entryTemperatureRepo.findTop1ByOrderByTimeDesc();
/*     */   }
/*     */   
/*     */   public List<EntryDoor> getNewestEntryDoors() {
/* 166 */     return this.entryDoorRepo.findTop6ByDoorNotNullOrderByTimeDesc();
/*     */   }
/*     */   
/*     */   public EntryDoor getNewestEntryDoorForStore(Long id) {
/* 170 */     return this.entryDoorRepo.findTop1ByDoor_Store_IdOrderByTimeDesc(id);
/*     */   }
/*     */   
/*     */   public EntryMeasure getNewestEntryMeasureForStore(Long id) {
/* 174 */     return this.entryMeasureRepo.findTop1ByStore_IdOrderByTimeDesc(id);
/*     */   }
/*     */   
/*     */   public EntrySafety getNewestEntrySafetyForStore(Long id) {
/* 178 */     return this.entrySafetyRepo.findTop1ByStore_IdOrderByTimeDesc(id);
/*     */   }
/*     */   
/*     */   public EntryTemperature getNewestEntryTempForStore(Long id) {
/* 182 */     return this.entryTemperatureRepo.findTop1ByStore_IdOrderByTimeDesc(id);
/*     */   }
/*     */   
/*     */   public EntryMeasure createEntryMeasure(EntryMeasure entryMeasure, Store store) {
/* 186 */     entryMeasure = (EntryMeasure)this.entryMeasureRepo.saveAndFlush(entryMeasure);
/* 187 */     Company company = (Company)this.companyRepo.findOne(Long.valueOf(1L));
/*     */     try {
///* 189 */       ShengjuService.getInstance().sendMeasure(entryMeasure, company, store, "create");
/*     */     } catch (Throwable e) {
/* 191 */       System.out.println("上传省局数量监测失败");
/* 192 */       e.printStackTrace();
/*     */     }
/* 194 */     return entryMeasure;
/*     */   }
/*     */   
/*     */   public EntryTemperature createEntryTemperature(Long id, String tData) {
/* 198 */     Store store = (Store)this.storeRepo.findOne(id);
/* 199 */     EntryTemperature et = new EntryTemperature();
/* 200 */     et.setData(tData);
/* 201 */     et.setStore(store);
/* 202 */     et.setTime(new Date());
/* 203 */     this.entryTemperatureRepo.save(et);
/* 204 */     return null;
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void createEntrySafety(Integer codeId)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 268	com/haut/grm/model/entry/EntrySafety
/*     */     //   3: dup
/*     */     //   4: invokespecial 270	com/haut/grm/model/entry/EntrySafety:<init>	()V
/*     */     //   7: astore_2
/*     */     //   8: aload_0
/*     */     //   9: getfield 115	com/haut/grm/service/EntryService:storeRepo	Lcom/haut/grm/repository/StoreRepository;
/*     */     //   12: lconst_1
/*     */     //   13: invokestatic 192	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/*     */     //   16: aload_1
/*     */     //   17: invokeinterface 271 3 0
/*     */     //   22: astore_3
/*     */     //   23: aload_2
/*     */     //   24: aload_3
/*     */     //   25: invokevirtual 275	com/haut/grm/model/entry/EntrySafety:setStore	(Lcom/haut/grm/model/Store;)V
/*     */     //   28: aload_2
/*     */     //   29: new 252	java/util/Date
/*     */     //   32: dup
/*     */     //   33: invokespecial 254	java/util/Date:<init>	()V
/*     */     //   36: invokevirtual 276	com/haut/grm/model/entry/EntrySafety:setTime	(Ljava/util/Date;)V
/*     */     //   39: aload_2
/*     */     //   40: iconst_1
/*     */     //   41: invokestatic 277	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
/*     */     //   44: invokevirtual 282	com/haut/grm/model/entry/EntrySafety:setActive	(Ljava/lang/Boolean;)V
/*     */     //   47: aload_0
/*     */     //   48: getfield 44	com/haut/grm/service/EntryService:entrySafetyRepo	Lcom/haut/grm/repository/entry/EntrySafetyRepository;
/*     */     //   51: aload_2
/*     */     //   52: invokeinterface 286 2 0
/*     */     //   57: pop
/*     */     //   58: aload_3
/*     */     //   59: invokevirtual 287	com/haut/grm/model/Store:getStatus	()Lcom/haut/grm/model/StoreStatus;
/*     */     //   62: iconst_1
/*     */     //   63: invokestatic 277	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
/*     */     //   66: invokevirtual 291	com/haut/grm/model/StoreStatus:setAlerting	(Ljava/lang/Boolean;)V
/*     */     //   69: aload_0
/*     */     //   70: getfield 115	com/haut/grm/service/EntryService:storeRepo	Lcom/haut/grm/repository/StoreRepository;
/*     */     //   73: aload_3
/*     */     //   74: invokeinterface 296 2 0
/*     */     //   79: pop
/*     */     //   80: aload_0
/*     */     //   81: getfield 297	com/haut/grm/service/EntryService:commonService	Lcom/haut/grm/service/CommonService;
/*     */     //   84: ldc_w 299
/*     */     //   87: invokevirtual 301	com/haut/grm/service/CommonService:moduleActive	(Ljava/lang/String;)Z
/*     */     //   90: ifeq +257 -> 347
/*     */     //   93: ldc_w 307
/*     */     //   96: astore 4
/*     */     //   98: new 309	java/text/SimpleDateFormat
/*     */     //   101: dup
/*     */     //   102: ldc_w 311
/*     */     //   105: invokespecial 313	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
/*     */     //   108: astore 5
/*     */     //   110: new 315	java/lang/StringBuilder
/*     */     //   113: dup
/*     */     //   114: ldc_w 317
/*     */     //   117: invokespecial 319	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   120: aload 4
/*     */     //   122: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   125: aload_3
/*     */     //   126: invokevirtual 324	com/haut/grm/model/Store:getName	()Ljava/lang/String;
/*     */     //   129: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   132: ldc_w 328
/*     */     //   135: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   138: aload_0
/*     */     //   139: getfield 330	com/haut/grm/service/EntryService:deviceService	Lcom/haut/grm/service/DeviceService;
/*     */     //   142: invokevirtual 332	com/haut/grm/service/DeviceService:getAlertMessage	()Lcom/haut/grm/model/meta/SmsTemplate;
/*     */     //   145: invokevirtual 338	com/haut/grm/model/meta/SmsTemplate:getSafetyAlert	()Ljava/lang/String;
/*     */     //   148: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   151: ldc_w 343
/*     */     //   154: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   157: aload 5
/*     */     //   159: new 252	java/util/Date
/*     */     //   162: dup
/*     */     //   163: invokespecial 254	java/util/Date:<init>	()V
/*     */     //   166: invokevirtual 345	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
/*     */     //   169: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   172: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   175: astore 4
/*     */     //   177: aload_3
/*     */     //   178: invokevirtual 352	com/haut/grm/model/Store:getConfig	()Lcom/haut/grm/model/StoreConfig;
/*     */     //   181: invokevirtual 356	com/haut/grm/model/StoreConfig:getManager	()Lcom/haut/grm/model/meta/User;
/*     */     //   184: ifnull +31 -> 215
/*     */     //   187: aload_3
/*     */     //   188: invokevirtual 352	com/haut/grm/model/Store:getConfig	()Lcom/haut/grm/model/StoreConfig;
/*     */     //   191: invokevirtual 356	com/haut/grm/model/StoreConfig:getManager	()Lcom/haut/grm/model/meta/User;
/*     */     //   194: invokevirtual 362	com/haut/grm/model/meta/User:getTelephone	()Ljava/lang/String;
/*     */     //   197: ifnull +18 -> 215
/*     */     //   200: aload_3
/*     */     //   201: invokevirtual 352	com/haut/grm/model/Store:getConfig	()Lcom/haut/grm/model/StoreConfig;
/*     */     //   204: invokevirtual 356	com/haut/grm/model/StoreConfig:getManager	()Lcom/haut/grm/model/meta/User;
/*     */     //   207: invokevirtual 362	com/haut/grm/model/meta/User:getTelephone	()Ljava/lang/String;
/*     */     //   210: aload 4
/*     */     //   212: invokestatic 367	com/haut/grm/util/SMSUtil:sendMessage	(Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   215: aload_0
/*     */     //   216: getfield 297	com/haut/grm/service/EntryService:commonService	Lcom/haut/grm/service/CommonService;
/*     */     //   219: invokevirtual 373	com/haut/grm/service/CommonService:getSafetyUsers	()Ljava/util/List;
/*     */     //   222: invokeinterface 376 1 0
/*     */     //   227: astore 7
/*     */     //   229: goto +33 -> 262
/*     */     //   232: aload 7
/*     */     //   234: invokeinterface 382 1 0
/*     */     //   239: checkcast 363	com/haut/grm/model/meta/User
/*     */     //   242: astore 6
/*     */     //   244: aload 6
/*     */     //   246: invokevirtual 362	com/haut/grm/model/meta/User:getTelephone	()Ljava/lang/String;
/*     */     //   249: ifnull +13 -> 262
/*     */     //   252: aload 6
/*     */     //   254: invokevirtual 362	com/haut/grm/model/meta/User:getTelephone	()Ljava/lang/String;
/*     */     //   257: aload 4
/*     */     //   259: invokestatic 367	com/haut/grm/util/SMSUtil:sendMessage	(Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   262: aload 7
/*     */     //   264: invokeinterface 388 1 0
/*     */     //   269: ifne -37 -> 232
/*     */     //   272: goto +54 -> 326
/*     */     //   275: astore 4
/*     */     //   277: aload 4
/*     */     //   279: invokevirtual 392	java/lang/Exception:printStackTrace	()V
/*     */     //   282: aload_0
/*     */     //   283: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   286: aload_2
/*     */     //   287: invokevirtual 397	com/haut/grm/util/MessageProducer:generateSafetyMessage	(Lcom/haut/grm/model/entry/EntrySafety;)V
/*     */     //   290: goto +75 -> 365
/*     */     //   293: astore 9
/*     */     //   295: aload 9
/*     */     //   297: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   300: goto +65 -> 365
/*     */     //   303: astore 8
/*     */     //   305: aload_0
/*     */     //   306: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   309: aload_2
/*     */     //   310: invokevirtual 397	com/haut/grm/util/MessageProducer:generateSafetyMessage	(Lcom/haut/grm/model/entry/EntrySafety;)V
/*     */     //   313: goto +10 -> 323
/*     */     //   316: astore 9
/*     */     //   318: aload 9
/*     */     //   320: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   323: aload 8
/*     */     //   325: athrow
/*     */     //   326: aload_0
/*     */     //   327: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   330: aload_2
/*     */     //   331: invokevirtual 397	com/haut/grm/util/MessageProducer:generateSafetyMessage	(Lcom/haut/grm/model/entry/EntrySafety;)V
/*     */     //   334: goto +31 -> 365
/*     */     //   337: astore 9
/*     */     //   339: aload 9
/*     */     //   341: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   344: goto +21 -> 365
/*     */     //   347: aload_0
/*     */     //   348: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   351: aload_2
/*     */     //   352: invokevirtual 397	com/haut/grm/util/MessageProducer:generateSafetyMessage	(Lcom/haut/grm/model/entry/EntrySafety;)V
/*     */     //   355: goto +10 -> 365
/*     */     //   358: astore 4
/*     */     //   360: aload 4
/*     */     //   362: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   365: return
/*     */     // Line number table:
/*     */     //   Java source line #208	-> byte code offset #0
/*     */     //   Java source line #209	-> byte code offset #8
/*     */     //   Java source line #210	-> byte code offset #23
/*     */     //   Java source line #211	-> byte code offset #28
/*     */     //   Java source line #212	-> byte code offset #39
/*     */     //   Java source line #213	-> byte code offset #47
/*     */     //   Java source line #214	-> byte code offset #58
/*     */     //   Java source line #215	-> byte code offset #69
/*     */     //   Java source line #216	-> byte code offset #80
/*     */     //   Java source line #218	-> byte code offset #93
/*     */     //   Java source line #219	-> byte code offset #98
/*     */     //   Java source line #220	-> byte code offset #102
/*     */     //   Java source line #219	-> byte code offset #105
/*     */     //   Java source line #221	-> byte code offset #110
/*     */     //   Java source line #222	-> byte code offset #138
/*     */     //   Java source line #223	-> byte code offset #151
/*     */     //   Java source line #221	-> byte code offset #172
/*     */     //   Java source line #225	-> byte code offset #177
/*     */     //   Java source line #226	-> byte code offset #187
/*     */     //   Java source line #228	-> byte code offset #200
/*     */     //   Java source line #227	-> byte code offset #212
/*     */     //   Java source line #229	-> byte code offset #215
/*     */     //   Java source line #230	-> byte code offset #244
/*     */     //   Java source line #231	-> byte code offset #252
/*     */     //   Java source line #229	-> byte code offset #262
/*     */     //   Java source line #234	-> byte code offset #272
/*     */     //   Java source line #235	-> byte code offset #277
/*     */     //   Java source line #238	-> byte code offset #282
/*     */     //   Java source line #239	-> byte code offset #290
/*     */     //   Java source line #240	-> byte code offset #295
/*     */     //   Java source line #236	-> byte code offset #303
/*     */     //   Java source line #238	-> byte code offset #305
/*     */     //   Java source line #239	-> byte code offset #313
/*     */     //   Java source line #240	-> byte code offset #318
/*     */     //   Java source line #242	-> byte code offset #323
/*     */     //   Java source line #238	-> byte code offset #326
/*     */     //   Java source line #239	-> byte code offset #334
/*     */     //   Java source line #240	-> byte code offset #339
/*     */     //   Java source line #243	-> byte code offset #344
/*     */     //   Java source line #246	-> byte code offset #347
/*     */     //   Java source line #247	-> byte code offset #355
/*     */     //   Java source line #248	-> byte code offset #360
/*     */     //   Java source line #251	-> byte code offset #365
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	366	0	this	EntryService
/*     */     //   0	366	1	codeId	Integer
/*     */     //   7	345	2	es	EntrySafety
/*     */     //   22	179	3	store	Store
/*     */     //   96	162	4	content	String
/*     */     //   275	3	4	e	Exception
/*     */     //   358	3	4	e	JMSException
/*     */     //   108	50	5	dateFormat	java.text.SimpleDateFormat
/*     */     //   242	11	6	user	com.haut.grm.model.meta.User
/*     */     //   227	36	7	localIterator	java.util.Iterator
/*     */     //   303	21	8	localObject	Object
/*     */     //   293	3	9	e	JMSException
/*     */     //   316	3	9	e	JMSException
/*     */     //   337	3	9	e	JMSException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   93	272	275	java/lang/Exception
/*     */     //   282	290	293	javax/jms/JMSException
/*     */     //   93	282	303	finally
/*     */     //   305	313	316	javax/jms/JMSException
/*     */     //   326	334	337	javax/jms/JMSException
/*     */     //   347	355	358	javax/jms/JMSException
/*     */   }
/*     */   
/*     */   /* Error */
/*     */   public void createEntryDoor(com.haut.grm.model.Door door, int i)
/*     */   {
/*     */     // Byte code:
/*     */     //   0: new 423	com/haut/grm/model/entry/EntryDoor
/*     */     //   3: dup
/*     */     //   4: invokespecial 425	com/haut/grm/model/entry/EntryDoor:<init>	()V
/*     */     //   7: astore_3
/*     */     //   8: aload_3
/*     */     //   9: aload_1
/*     */     //   10: invokevirtual 426	com/haut/grm/model/entry/EntryDoor:setDoor	(Lcom/haut/grm/model/Door;)V
/*     */     //   13: aload_3
/*     */     //   14: aload_1
/*     */     //   15: invokevirtual 430	com/haut/grm/model/Door:getStore	()Lcom/haut/grm/model/Store;
/*     */     //   18: invokevirtual 436	com/haut/grm/model/entry/EntryDoor:setStore	(Lcom/haut/grm/model/Store;)V
/*     */     //   21: aload_3
/*     */     //   22: new 252	java/util/Date
/*     */     //   25: dup
/*     */     //   26: invokespecial 254	java/util/Date:<init>	()V
/*     */     //   29: invokevirtual 437	com/haut/grm/model/entry/EntryDoor:setTime	(Ljava/util/Date;)V
/*     */     //   32: aload_3
/*     */     //   33: aload_0
/*     */     //   34: getfield 438	com/haut/grm/service/EntryService:doorStateRepo	Lcom/haut/grm/repository/type/DoorStateRepository;
/*     */     //   37: iload_2
/*     */     //   38: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   41: invokeinterface 443 2 0
/*     */     //   46: checkcast 449	com/haut/grm/model/type/DoorState
/*     */     //   49: invokevirtual 451	com/haut/grm/model/entry/EntryDoor:setState	(Lcom/haut/grm/model/type/DoorState;)V
/*     */     //   52: aload_0
/*     */     //   53: getfield 52	com/haut/grm/service/EntryService:entryDoorRepo	Lcom/haut/grm/repository/entry/EntryDoorRepository;
/*     */     //   56: aload_3
/*     */     //   57: invokeinterface 455 2 0
/*     */     //   62: pop
/*     */     //   63: goto +15 -> 78
/*     */     //   66: astore 4
/*     */     //   68: getstatic 215	java/lang/System:out	Ljava/io/PrintStream;
/*     */     //   71: ldc_w 456
/*     */     //   74: invokevirtual 223	java/io/PrintStream:println	(Ljava/lang/String;)V
/*     */     //   77: return
/*     */     //   78: aload_1
/*     */     //   79: aload_0
/*     */     //   80: getfield 438	com/haut/grm/service/EntryService:doorStateRepo	Lcom/haut/grm/repository/type/DoorStateRepository;
/*     */     //   83: iload_2
/*     */     //   84: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   87: invokeinterface 443 2 0
/*     */     //   92: checkcast 449	com/haut/grm/model/type/DoorState
/*     */     //   95: invokevirtual 458	com/haut/grm/model/Door:setState	(Lcom/haut/grm/model/type/DoorState;)V
/*     */     //   98: aload_0
/*     */     //   99: getfield 459	com/haut/grm/service/EntryService:doorRepo	Lcom/haut/grm/repository/DoorRepository;
/*     */     //   102: aload_1
/*     */     //   103: invokeinterface 461 2 0
/*     */     //   108: pop
/*     */     //   109: aload_0
/*     */     //   110: getfield 297	com/haut/grm/service/EntryService:commonService	Lcom/haut/grm/service/CommonService;
/*     */     //   113: ldc_w 464
/*     */     //   116: invokevirtual 466	com/haut/grm/service/CommonService:getSystemVariableWithKey	(Ljava/lang/String;)Ljava/lang/String;
/*     */     //   119: astore 4
/*     */     //   121: aload 4
/*     */     //   123: ldc_w 470
/*     */     //   126: invokevirtual 472	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
/*     */     //   129: astore 5
/*     */     //   131: aload_0
/*     */     //   132: getfield 297	com/haut/grm/service/EntryService:commonService	Lcom/haut/grm/service/CommonService;
/*     */     //   135: ldc_w 299
/*     */     //   138: invokevirtual 301	com/haut/grm/service/CommonService:moduleActive	(Ljava/lang/String;)Z
/*     */     //   141: ifeq +299 -> 440
/*     */     //   144: aload 5
/*     */     //   146: iconst_0
/*     */     //   147: aaload
/*     */     //   148: invokevirtual 476	java/lang/String:trim	()Ljava/lang/String;
/*     */     //   151: aload 5
/*     */     //   153: iconst_1
/*     */     //   154: aaload
/*     */     //   155: invokevirtual 476	java/lang/String:trim	()Ljava/lang/String;
/*     */     //   158: invokestatic 479	com/haut/grm/util/TimeUtil:nowBetween	(Ljava/lang/String;Ljava/lang/String;)Z
/*     */     //   161: ifeq +279 -> 440
/*     */     //   164: ldc_w 307
/*     */     //   167: astore 6
/*     */     //   169: new 309	java/text/SimpleDateFormat
/*     */     //   172: dup
/*     */     //   173: ldc_w 311
/*     */     //   176: invokespecial 313	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
/*     */     //   179: astore 7
/*     */     //   181: new 315	java/lang/StringBuilder
/*     */     //   184: dup
/*     */     //   185: ldc_w 317
/*     */     //   188: invokespecial 319	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/*     */     //   191: aload_1
/*     */     //   192: invokevirtual 430	com/haut/grm/model/Door:getStore	()Lcom/haut/grm/model/Store;
/*     */     //   195: invokevirtual 324	com/haut/grm/model/Store:getName	()Ljava/lang/String;
/*     */     //   198: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   201: aload_1
/*     */     //   202: invokevirtual 485	com/haut/grm/model/Door:getName	()Ljava/lang/String;
/*     */     //   205: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   208: ldc_w 486
/*     */     //   211: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   214: aload_3
/*     */     //   215: invokevirtual 488	com/haut/grm/model/entry/EntryDoor:getState	()Lcom/haut/grm/model/type/DoorState;
/*     */     //   218: invokevirtual 492	com/haut/grm/model/type/DoorState:getCodeId	()Ljava/lang/Integer;
/*     */     //   221: iconst_1
/*     */     //   222: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   225: invokevirtual 496	java/lang/Integer:equals	(Ljava/lang/Object;)Z
/*     */     //   228: ifeq +9 -> 237
/*     */     //   231: ldc_w 500
/*     */     //   234: goto +29 -> 263
/*     */     //   237: aload_3
/*     */     //   238: invokevirtual 488	com/haut/grm/model/entry/EntryDoor:getState	()Lcom/haut/grm/model/type/DoorState;
/*     */     //   241: invokevirtual 492	com/haut/grm/model/type/DoorState:getCodeId	()Ljava/lang/Integer;
/*     */     //   244: iconst_2
/*     */     //   245: invokestatic 440	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
/*     */     //   248: invokevirtual 496	java/lang/Integer:equals	(Ljava/lang/Object;)Z
/*     */     //   251: ifeq +9 -> 260
/*     */     //   254: ldc_w 502
/*     */     //   257: goto +6 -> 263
/*     */     //   260: ldc_w 504
/*     */     //   263: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   266: ldc_w 506
/*     */     //   269: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   272: aload_0
/*     */     //   273: getfield 330	com/haut/grm/service/EntryService:deviceService	Lcom/haut/grm/service/DeviceService;
/*     */     //   276: invokevirtual 332	com/haut/grm/service/DeviceService:getAlertMessage	()Lcom/haut/grm/model/meta/SmsTemplate;
/*     */     //   279: invokevirtual 508	com/haut/grm/model/meta/SmsTemplate:getDoorAlert	()Ljava/lang/String;
/*     */     //   282: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   285: ldc_w 511
/*     */     //   288: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   291: aload 7
/*     */     //   293: new 252	java/util/Date
/*     */     //   296: dup
/*     */     //   297: invokespecial 254	java/util/Date:<init>	()V
/*     */     //   300: invokevirtual 345	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
/*     */     //   303: invokevirtual 320	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */     //   306: invokevirtual 349	java/lang/StringBuilder:toString	()Ljava/lang/String;
/*     */     //   309: astore 6
/*     */     //   311: aload_0
/*     */     //   312: getfield 297	com/haut/grm/service/EntryService:commonService	Lcom/haut/grm/service/CommonService;
/*     */     //   315: invokevirtual 373	com/haut/grm/service/CommonService:getSafetyUsers	()Ljava/util/List;
/*     */     //   318: invokeinterface 376 1 0
/*     */     //   323: astore 9
/*     */     //   325: goto +33 -> 358
/*     */     //   328: aload 9
/*     */     //   330: invokeinterface 382 1 0
/*     */     //   335: checkcast 363	com/haut/grm/model/meta/User
/*     */     //   338: astore 8
/*     */     //   340: aload 8
/*     */     //   342: invokevirtual 362	com/haut/grm/model/meta/User:getTelephone	()Ljava/lang/String;
/*     */     //   345: ifnull +13 -> 358
/*     */     //   348: aload 8
/*     */     //   350: invokevirtual 362	com/haut/grm/model/meta/User:getTelephone	()Ljava/lang/String;
/*     */     //   353: aload 6
/*     */     //   355: invokestatic 367	com/haut/grm/util/SMSUtil:sendMessage	(Ljava/lang/String;Ljava/lang/String;)V
/*     */     //   358: aload 9
/*     */     //   360: invokeinterface 388 1 0
/*     */     //   365: ifne -37 -> 328
/*     */     //   368: goto +54 -> 422
/*     */     //   371: astore 6
/*     */     //   373: aload 6
/*     */     //   375: invokevirtual 392	java/lang/Exception:printStackTrace	()V
/*     */     //   378: aload_0
/*     */     //   379: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   382: aload_3
/*     */     //   383: invokevirtual 513	com/haut/grm/util/MessageProducer:generateDoorMessage	(Lcom/haut/grm/model/entry/EntryDoor;)V
/*     */     //   386: goto +54 -> 440
/*     */     //   389: astore 11
/*     */     //   391: aload 11
/*     */     //   393: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   396: goto +44 -> 440
/*     */     //   399: astore 10
/*     */     //   401: aload_0
/*     */     //   402: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   405: aload_3
/*     */     //   406: invokevirtual 513	com/haut/grm/util/MessageProducer:generateDoorMessage	(Lcom/haut/grm/model/entry/EntryDoor;)V
/*     */     //   409: goto +10 -> 419
/*     */     //   412: astore 11
/*     */     //   414: aload 11
/*     */     //   416: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   419: aload 10
/*     */     //   421: athrow
/*     */     //   422: aload_0
/*     */     //   423: getfield 395	com/haut/grm/service/EntryService:amqSender	Lcom/haut/grm/util/MessageProducer;
/*     */     //   426: aload_3
/*     */     //   427: invokevirtual 513	com/haut/grm/util/MessageProducer:generateDoorMessage	(Lcom/haut/grm/model/entry/EntryDoor;)V
/*     */     //   430: goto +10 -> 440
/*     */     //   433: astore 11
/*     */     //   435: aload 11
/*     */     //   437: invokevirtual 403	javax/jms/JMSException:printStackTrace	()V
/*     */     //   440: return
/*     */     // Line number table:
/*     */     //   Java source line #254	-> byte code offset #0
/*     */     //   Java source line #255	-> byte code offset #8
/*     */     //   Java source line #256	-> byte code offset #13
/*     */     //   Java source line #257	-> byte code offset #21
/*     */     //   Java source line #258	-> byte code offset #32
/*     */     //   Java source line #260	-> byte code offset #52
/*     */     //   Java source line #261	-> byte code offset #63
/*     */     //   Java source line #262	-> byte code offset #66
/*     */     //   Java source line #263	-> byte code offset #68
/*     */     //   Java source line #264	-> byte code offset #77
/*     */     //   Java source line #266	-> byte code offset #78
/*     */     //   Java source line #267	-> byte code offset #98
/*     */     //   Java source line #269	-> byte code offset #109
/*     */     //   Java source line #270	-> byte code offset #121
/*     */     //   Java source line #271	-> byte code offset #131
/*     */     //   Java source line #273	-> byte code offset #164
/*     */     //   Java source line #274	-> byte code offset #169
/*     */     //   Java source line #275	-> byte code offset #173
/*     */     //   Java source line #274	-> byte code offset #176
/*     */     //   Java source line #276	-> byte code offset #181
/*     */     //   Java source line #277	-> byte code offset #272
/*     */     //   Java source line #278	-> byte code offset #285
/*     */     //   Java source line #276	-> byte code offset #306
/*     */     //   Java source line #280	-> byte code offset #311
/*     */     //   Java source line #281	-> byte code offset #340
/*     */     //   Java source line #282	-> byte code offset #348
/*     */     //   Java source line #280	-> byte code offset #358
/*     */     //   Java source line #285	-> byte code offset #368
/*     */     //   Java source line #286	-> byte code offset #373
/*     */     //   Java source line #289	-> byte code offset #378
/*     */     //   Java source line #290	-> byte code offset #386
/*     */     //   Java source line #291	-> byte code offset #391
/*     */     //   Java source line #287	-> byte code offset #399
/*     */     //   Java source line #289	-> byte code offset #401
/*     */     //   Java source line #290	-> byte code offset #409
/*     */     //   Java source line #291	-> byte code offset #414
/*     */     //   Java source line #293	-> byte code offset #419
/*     */     //   Java source line #289	-> byte code offset #422
/*     */     //   Java source line #290	-> byte code offset #430
/*     */     //   Java source line #291	-> byte code offset #435
/*     */     //   Java source line #295	-> byte code offset #440
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	signature
/*     */     //   0	441	0	this	EntryService
/*     */     //   0	441	1	door	com.haut.grm.model.Door
/*     */     //   0	441	2	i	int
/*     */     //   7	420	3	ed	EntryDoor
/*     */     //   66	3	4	e	Exception
/*     */     //   119	3	4	pattern	String
/*     */     //   129	23	5	dates	String[]
/*     */     //   167	187	6	content	String
/*     */     //   371	3	6	e	Exception
/*     */     //   179	113	7	dateFormat	java.text.SimpleDateFormat
/*     */     //   338	11	8	user	com.haut.grm.model.meta.User
/*     */     //   323	36	9	localIterator	java.util.Iterator
/*     */     //   399	21	10	localObject	Object
/*     */     //   389	3	11	e	JMSException
/*     */     //   412	3	11	e	JMSException
/*     */     //   433	3	11	e	JMSException
/*     */     // Exception table:
/*     */     //   from	to	target	type
/*     */     //   52	63	66	java/lang/Exception
/*     */     //   164	368	371	java/lang/Exception
/*     */     //   378	386	389	javax/jms/JMSException
/*     */     //   164	378	399	finally
/*     */     //   401	409	412	javax/jms/JMSException
/*     */     //   422	430	433	javax/jms/JMSException
/*     */   }
/*     */   
/*     */   public void muteEntrySafetyForStore(Long id)
/*     */     throws Exception
/*     */   {
/* 298 */     Store store = (Store)this.storeRepo.findOne(id);
/* 299 */     store.getStatus().setAlerting(Boolean.valueOf(false));
/* 300 */     String rootUrl = this.commonService.getSystemVariableWithKey("CORE_SERVICE_URL_3.0");
/* 301 */     List<NameValuePair> urlParameters = new ArrayList();
/* 302 */     urlParameters.add(new BasicNameValuePair("shebei", store.getCodeId().toString()));
/* 303 */     MeasureWebServiceUtil.execute(rootUrl, "cleanAlarm", urlParameters);
/* 304 */     for (EntrySafety es : this.entrySafetyRepo.findByStore_IdOrderByTimeDesc(id)) {
/* 305 */       es.setActive(Boolean.valueOf(false));
/* 306 */       this.entrySafetyRepo.save(es);
/*     */     }
/* 308 */     this.storeRepo.save(store);
/*     */     try {
/* 310 */       this.amqSender.generateMuteSafetyMessage(store);
/*     */     } catch (JMSException e) {
/* 312 */       e.printStackTrace();
/*     */     }
/*     */   }
/*     */   
/*     */   public EntryMeasure getEntryMeasureById(Long id) {
/* 317 */     return (EntryMeasure)this.entryMeasureRepo.findOne(id);
/*     */   }
/*     */   
/*     */   public List<EntryDoor> getEntryDoorsInRecent(Integer hours) {
/* 321 */     return this.entryDoorRepo.findByTimeGreaterThanAndDoorNotNullOrderByTimeDesc(this.commonService.getLastDate(hours.intValue()));
/*     */   }
/*     */   
/*     */   public long countEntryDoorsInRecent(Integer hours, Long id) {
/* 325 */     return this.entryDoorRepo.countByDoor_Store_IdAndTimeGreaterThanOrderByTimeDesc(id, this.commonService.getLastDate(hours.intValue()));
/*     */   }
/*     */   
/*     */   public void generateMeasureDiff(EntryMeasure em) {
/* 329 */     EntryMeasure last = findLastAutoEntryMeasure((Long)em.getStore().getId());
/*     */     
/* 331 */     if (last != null) {
/* 332 */       MeasureDiff mDiff = new MeasureDiff();
/* 333 */       mDiff.setThisTime(em.getTime());
/* 334 */       mDiff.setThatTime(last.getTime());
/* 335 */       mDiff.setThisVolume(em.getVolume());
/* 336 */       mDiff.setThatVolume(last.getVolume());
/* 337 */       mDiff.setStore(em.getStore());
/*     */       try {
/* 339 */         Double a = Double.valueOf((em.getVolume().doubleValue() - last.getVolume().doubleValue()) / em.getVolume().doubleValue() * 100.0D);
/* 340 */         mDiff.setErrorPercentage(Double.valueOf((a.isInfinite()) || (a.isNaN()) ? 0.0D : a.doubleValue()));
/*     */       }
/*     */       catch (NumberFormatException e) {
/* 343 */         mDiff.setErrorPercentage(Double.valueOf(0.0D));
/*     */       }
/* 345 */       createMeasureDiff(mDiff);
/*     */     }
/*     */   }
/*     */   
/*     */   public EntryMeasure findLastAutoEntryMeasure(Long id) {
/* 350 */     return this.entryMeasureRepo.findTopByStore_IdAndIsAutoOrderByTimeDesc(id, true);
/*     */   }
/*     */   
/*     */   public void createMeasureDiff(MeasureDiff mDiff) {
/* 354 */     this.mdRepo.save(mDiff);
/*     */   }
/*     */   
/*     */   public void createDoorCollect(DoorCollect dc) {
/* 358 */     this.dcRepo.save(dc);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\EntryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */