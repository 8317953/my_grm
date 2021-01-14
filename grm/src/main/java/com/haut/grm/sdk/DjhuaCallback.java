/////*     */ package com.haut.grm.sdk;
/////*     */ 
/////*     */ import com.haut.grm.bean.GlobalHandler;
/////*     */ import com.haut.grm.model.DeviceCamera;
/////*     */ import com.haut.grm.model.ies.IesCameraImage;
/////*     */ import com.haut.grm.model.ies.VehicleTraffic;
/////*     */ import com.haut.grm.repository.DeviceCameraRepository;
/////*     */ import com.haut.grm.repository.ies.IesCameraImageRepository;
/////*     */ import com.haut.grm.repository.ies.VehicleTrafficRepository;
/////*     */ import com.haut.grm.util.MessageProducer;
/////*     */ import java.io.PrintStream;
/////*     */ import java.text.SimpleDateFormat;
/////*     */ import java.util.Date;
/////*     */ import java.util.LinkedList;
/////*     */ import java.util.Map;
/////*     */ import java.util.concurrent.ScheduledExecutorService;
/////*     */ import java.util.concurrent.TimeUnit;
/////*     */ import javax.jms.JMSException;
/////*     */ import org.springframework.beans.factory.annotation.Autowired;
/////*     */ import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
/////*     */ import org.springframework.stereotype.Component;
/////*     */ 
/////*     */ 
/////*     */ 
/////*     */ 
/////*     */ 
/////*     */ 
/////*     */ 
/////*     */ 
/////*     */ @Component
/////*     */ public class DjhuaCallback
/////*     */ {
/////*     */   private static DeviceCameraRepository deviceCameraRepository;
/////*     */   private static VehicleTrafficRepository vehicleTrafficRepository;
/////*     */   private static IesCameraImageRepository iesCameraImageRepository;
/////*     */   private static MessageProducer amqSender;
/////*  37 */   private static final LinkedList<IesCameraImage> imageQueue = new LinkedList();
/////*     */   
/////*     */   @Autowired(required=true)
/////*     */   public void setMessageProducer(MessageProducer amqSender) {
/////*  41 */     amqSender = amqSender;
/////*     */   }
/////*     */   
/////*     */   @Autowired(required=true)
/////*     */   public void setDeviceCameraRepository(DeviceCameraRepository deviceCameraRepository) {
/////*  46 */     deviceCameraRepository = deviceCameraRepository;
/////*     */   }
/////*     */   
/////*     */   @Autowired(required=true)
/////*     */   public void setIesCameraImageRepository(IesCameraImageRepository iesCameraImageRepository) {
/////*  51 */     iesCameraImageRepository = iesCameraImageRepository;
/////*     */   }
/////*     */   
/////*     */   @Autowired(required=true)
/////*     */   public void setVehicleTrafficRepository(VehicleTrafficRepository vehicleTrafficRepository) {
/////*  56 */     vehicleTrafficRepository = vehicleTrafficRepository;
/////*     */   }
/////*     */   
///*     */   public static synchronized void onEvent(long profileId, final String plate, byte[] pic) {
///*  60 */     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年M月d日HH:mm:ss");
///*  61 */     System.out.println("收到车牌识别信号 车牌:" + plate + "  " + profileId + " " + dateFormat.format(new Date()));
///*  62 */     if ((plate == null) || (plate.equals(""))) {
///*  63 */       return;
///*     */     }
///*  65 */     VehicleTraffic vt = vehicleTrafficRepository.findTop1ByPlateAndInAndFinishedOrderByInTimeDesc(plate, Boolean.valueOf(true), Boolean.valueOf(false));
///*     */     
///*  67 */     VehicleTraffic _vt = vehicleTrafficRepository.findTop1ByPlateAndInAndDeadlineAfterOrderByTimeAsc(plate, Boolean.valueOf(false), new Date());
///*  68 */     if (vt == null) {
///*  69 */       if (_vt == null) {
///*  70 */         return;
///*     */       }
///*  72 */       vt = _vt;
///*     */     }
///*     */     
///*  75 */     if (vt.getDeadline().before(new Date())) {
///*  76 */       return;
///*     */     }
///*  78 */     for (Long cameraId : DjhuaCamera.getInstance().getMap().keySet()) {
///*  79 */       if (((CameraContext)DjhuaCamera.getInstance().getMap().get(cameraId)).getProfileId() == profileId) {
///*  80 */         DeviceCamera camera = (DeviceCamera)deviceCameraRepository.findOne(cameraId);
///*  81 */         if (vt.getIn().booleanValue()) {
///*  82 */           GlobalHandler.getScheduler().getScheduledExecutor().schedule(new Runnable()
///*     */           {
///*     */             public void run() {
///*     */               try {
///*  86 */                 DjhuaCamera.getInstance().up(DjhuaCallback.this, plate);
///*     */               } catch (Exception e) {
///*  88 */                 e.printStackTrace();
///*     */               }
///*     */             }
///*  91 */           }, 1000L, TimeUnit.MILLISECONDS);
///*     */           try {
///*  93 */             amqSender.generateVehicleMessage(plate, camera.getName(), false);
///*     */           } catch (JMSException e1) {
///*  95 */             e1.printStackTrace();
///*     */           }
///*  97 */           return;
///*     */         }
///*     */         
///* 100 */         GlobalHandler.getScheduler().getScheduledExecutor().schedule(new Runnable()
///*     */         {
///*     */           public void run() {
///*     */             try {
///* 104 */               DjhuaCamera.getInstance().up(DjhuaCallback.this, plate);
///*     */             } catch (Exception e) {
///* 106 */               e.printStackTrace();
///*     */             }
///*     */           }
///* 109 */         }, 1000L, TimeUnit.MILLISECONDS);
///* 110 */         vt.setIn(Boolean.valueOf(true));
///* 111 */         vt.setInTime(new Date());
///* 112 */         vt.setImage(pic);
///* 113 */         vt.setCamera(camera);
///* 114 */         vehicleTrafficRepository.save(vt);
///*     */         try {
///* 116 */           amqSender.generateVehicleMessage(plate, camera.getName(), true);
///*     */         } catch (JMSException e1) {
///* 118 */           e1.printStackTrace();
///*     */         }
///* 120 */         return;
///*     */       }
///*     */     }
///*     */   }
/////*     */   
/////*     */   public static synchronized void onEvent2(long profileId, String ip)
/////*     */   {
/////* 127 */     System.out.println("车牌设备重连成功：" + profileId + " - " + ip);
/////* 128 */     for (Long cameraId : DjhuaCamera.getInstance().getMap().keySet()) {
/////* 129 */       if (((CameraContext)DjhuaCamera.getInstance().getMap().get(cameraId)).getIpAddress().equals(ip)) {
/////* 130 */         ((CameraContext)DjhuaCamera.getInstance().getMap().get(cameraId)).setProfileId(profileId);
/////*     */       }
/////*     */     }
/////*     */   }
/////*     */   
/////*     */   /* Error */
/////*     */   public static synchronized void onEvent3(long profileId, byte[] pic, long serial)
/////*     */   {
/////*     */     // Byte code:
/////*     */     //   0: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   3: new 67	java/lang/StringBuilder
/////*     */     //   6: dup
/////*     */     //   7: ldc_w 294
/////*     */     //   10: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/////*     */     //   13: lload_0
/////*     */     //   14: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
/////*     */     //   17: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
/////*     */     //   20: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   23: getstatic 25	com/haut/grm/sdk/DjhuaCallback:imageQueue	Ljava/util/LinkedList;
/////*     */     //   26: invokevirtual 296	java/util/LinkedList:iterator	()Ljava/util/Iterator;
/////*     */     //   29: astore 5
/////*     */     //   31: goto +456 -> 487
/////*     */     //   34: aload 5
/////*     */     //   36: invokeinterface 155 1 0
/////*     */     //   41: checkcast 297	com/haut/grm/model/ies/IesCameraImage
/////*     */     //   44: astore 6
/////*     */     //   46: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   49: new 67	java/lang/StringBuilder
/////*     */     //   52: dup
/////*     */     //   53: ldc_w 299
/////*     */     //   56: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/////*     */     //   59: aload 6
/////*     */     //   61: invokevirtual 301	com/haut/grm/model/ies/IesCameraImage:getRegistry	()Lcom/haut/grm/model/ies/IesCameraRegistry;
/////*     */     //   64: invokevirtual 305	com/haut/grm/model/ies/IesCameraRegistry:getCamera	()Lcom/haut/grm/model/DeviceCamera;
/////*     */     //   67: invokevirtual 311	com/haut/grm/model/DeviceCamera:getId	()Ljava/io/Serializable;
/////*     */     //   70: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
/////*     */     //   73: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
/////*     */     //   76: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   79: invokestatic 133	com/haut/grm/sdk/DjhuaCamera:getInstance	()Lcom/haut/grm/sdk/DjhuaCamera;
/////*     */     //   82: invokevirtual 139	com/haut/grm/sdk/DjhuaCamera:getMap	()Ljava/util/Map;
/////*     */     //   85: invokeinterface 143 1 0
/////*     */     //   90: invokeinterface 149 1 0
/////*     */     //   95: astore 8
/////*     */     //   97: goto +380 -> 477
/////*     */     //   100: aload 8
/////*     */     //   102: invokeinterface 155 1 0
/////*     */     //   107: checkcast 161	java/lang/Long
/////*     */     //   110: astore 7
/////*     */     //   112: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   115: new 67	java/lang/StringBuilder
/////*     */     //   118: dup
/////*     */     //   119: ldc_w 318
/////*     */     //   122: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/////*     */     //   125: invokestatic 133	com/haut/grm/sdk/DjhuaCamera:getInstance	()Lcom/haut/grm/sdk/DjhuaCamera;
/////*     */     //   128: invokevirtual 139	com/haut/grm/sdk/DjhuaCamera:getMap	()Ljava/util/Map;
/////*     */     //   131: aload 7
/////*     */     //   133: invokeinterface 163 2 0
/////*     */     //   138: checkcast 167	com/haut/grm/sdk/CameraContext
/////*     */     //   141: invokevirtual 169	com/haut/grm/sdk/CameraContext:getProfileId	()J
/////*     */     //   144: invokevirtual 78	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
/////*     */     //   147: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
/////*     */     //   150: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   153: invokestatic 133	com/haut/grm/sdk/DjhuaCamera:getInstance	()Lcom/haut/grm/sdk/DjhuaCamera;
/////*     */     //   156: invokevirtual 139	com/haut/grm/sdk/DjhuaCamera:getMap	()Ljava/util/Map;
/////*     */     //   159: aload 7
/////*     */     //   161: invokeinterface 163 2 0
/////*     */     //   166: checkcast 167	com/haut/grm/sdk/CameraContext
/////*     */     //   169: invokevirtual 169	com/haut/grm/sdk/CameraContext:getProfileId	()J
/////*     */     //   172: lload_0
/////*     */     //   173: lcmp
/////*     */     //   174: ifne +303 -> 477
/////*     */     //   177: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   180: new 67	java/lang/StringBuilder
/////*     */     //   183: dup
/////*     */     //   184: lload_0
/////*     */     //   185: invokestatic 320	java/lang/String:valueOf	(J)Ljava/lang/String;
/////*     */     //   188: invokespecial 71	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
/////*     */     //   191: ldc_w 323
/////*     */     //   194: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
/////*     */     //   197: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
/////*     */     //   200: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   203: aload 6
/////*     */     //   205: invokevirtual 301	com/haut/grm/model/ies/IesCameraImage:getRegistry	()Lcom/haut/grm/model/ies/IesCameraRegistry;
/////*     */     //   208: invokevirtual 305	com/haut/grm/model/ies/IesCameraRegistry:getCamera	()Lcom/haut/grm/model/DeviceCamera;
/////*     */     //   211: invokevirtual 325	com/haut/grm/model/DeviceCamera:getIpAddress	()Ljava/lang/String;
/////*     */     //   214: invokestatic 133	com/haut/grm/sdk/DjhuaCamera:getInstance	()Lcom/haut/grm/sdk/DjhuaCamera;
/////*     */     //   217: invokevirtual 139	com/haut/grm/sdk/DjhuaCamera:getMap	()Ljava/util/Map;
/////*     */     //   220: aload 7
/////*     */     //   222: invokeinterface 163 2 0
/////*     */     //   227: checkcast 167	com/haut/grm/sdk/CameraContext
/////*     */     //   230: invokevirtual 284	com/haut/grm/sdk/CameraContext:getIpAddress	()Ljava/lang/String;
/////*     */     //   233: invokevirtual 101	java/lang/String:equals	(Ljava/lang/Object;)Z
/////*     */     //   236: ifeq +241 -> 477
/////*     */     //   239: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   242: ldc_w 326
/////*     */     //   245: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   248: new 54	java/text/SimpleDateFormat
/////*     */     //   251: dup
/////*     */     //   252: ldc_w 328
/////*     */     //   255: invokespecial 58	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;)V
/////*     */     //   258: astore 9
/////*     */     //   260: aload 9
/////*     */     //   262: new 83	java/util/Date
/////*     */     //   265: dup
/////*     */     //   266: invokespecial 85	java/util/Date:<init>	()V
/////*     */     //   269: invokevirtual 86	java/text/SimpleDateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
/////*     */     //   272: astore 10
/////*     */     //   274: ldc_w 330
/////*     */     //   277: iconst_2
/////*     */     //   278: anewarray 3	java/lang/Object
/////*     */     //   281: dup
/////*     */     //   282: iconst_0
/////*     */     //   283: lload_3
/////*     */     //   284: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/////*     */     //   287: aastore
/////*     */     //   288: dup
/////*     */     //   289: iconst_1
/////*     */     //   290: aload 10
/////*     */     //   292: aastore
/////*     */     //   293: invokestatic 335	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/////*     */     //   296: astore 11
/////*     */     //   298: ldc_w 338
/////*     */     //   301: iconst_2
/////*     */     //   302: anewarray 3	java/lang/Object
/////*     */     //   305: dup
/////*     */     //   306: iconst_0
/////*     */     //   307: lload_3
/////*     */     //   308: invokestatic 332	java/lang/Long:valueOf	(J)Ljava/lang/Long;
/////*     */     //   311: aastore
/////*     */     //   312: dup
/////*     */     //   313: iconst_1
/////*     */     //   314: aload 10
/////*     */     //   316: aastore
/////*     */     //   317: invokestatic 335	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/////*     */     //   320: astore 12
/////*     */     //   322: new 340	java/io/FileOutputStream
/////*     */     //   325: dup
/////*     */     //   326: aload 11
/////*     */     //   328: invokespecial 342	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
/////*     */     //   331: astore 13
/////*     */     //   333: aload 13
/////*     */     //   335: aload_2
/////*     */     //   336: invokevirtual 343	java/io/FileOutputStream:write	([B)V
/////*     */     //   339: aload 6
/////*     */     //   341: aload 12
/////*     */     //   343: invokevirtual 346	com/haut/grm/model/ies/IesCameraImage:setImagePath	(Ljava/lang/String;)V
/////*     */     //   346: getstatic 46	com/haut/grm/sdk/DjhuaCallback:iesCameraImageRepository	Lcom/haut/grm/repository/ies/IesCameraImageRepository;
/////*     */     //   349: aload 6
/////*     */     //   351: invokeinterface 349 2 0
/////*     */     //   356: pop
/////*     */     //   357: goto +78 -> 435
/////*     */     //   360: astore 14
/////*     */     //   362: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   365: ldc_w 352
/////*     */     //   368: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   371: getstatic 25	com/haut/grm/sdk/DjhuaCallback:imageQueue	Ljava/util/LinkedList;
/////*     */     //   374: aload 6
/////*     */     //   376: invokevirtual 354	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
/////*     */     //   379: pop
/////*     */     //   380: aload 13
/////*     */     //   382: invokevirtual 357	java/io/FileOutputStream:close	()V
/////*     */     //   385: goto +92 -> 477
/////*     */     //   388: astore 16
/////*     */     //   390: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   393: ldc_w 360
/////*     */     //   396: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   399: goto +78 -> 477
/////*     */     //   402: astore 15
/////*     */     //   404: getstatic 25	com/haut/grm/sdk/DjhuaCallback:imageQueue	Ljava/util/LinkedList;
/////*     */     //   407: aload 6
/////*     */     //   409: invokevirtual 354	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
/////*     */     //   412: pop
/////*     */     //   413: aload 13
/////*     */     //   415: invokevirtual 357	java/io/FileOutputStream:close	()V
/////*     */     //   418: goto +14 -> 432
/////*     */     //   421: astore 16
/////*     */     //   423: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   426: ldc_w 360
/////*     */     //   429: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   432: aload 15
/////*     */     //   434: athrow
/////*     */     //   435: getstatic 25	com/haut/grm/sdk/DjhuaCallback:imageQueue	Ljava/util/LinkedList;
/////*     */     //   438: aload 6
/////*     */     //   440: invokevirtual 354	java/util/LinkedList:remove	(Ljava/lang/Object;)Z
/////*     */     //   443: pop
/////*     */     //   444: aload 13
/////*     */     //   446: invokevirtual 357	java/io/FileOutputStream:close	()V
/////*     */     //   449: goto +28 -> 477
/////*     */     //   452: astore 16
/////*     */     //   454: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   457: ldc_w 360
/////*     */     //   460: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   463: goto +14 -> 477
/////*     */     //   466: astore 14
/////*     */     //   468: getstatic 61	java/lang/System:out	Ljava/io/PrintStream;
/////*     */     //   471: ldc_w 362
/////*     */     //   474: invokevirtual 94	java/io/PrintStream:println	(Ljava/lang/String;)V
/////*     */     //   477: aload 8
/////*     */     //   479: invokeinterface 256 1 0
/////*     */     //   484: ifne -384 -> 100
/////*     */     //   487: aload 5
/////*     */     //   489: invokeinterface 256 1 0
/////*     */     //   494: ifne -460 -> 34
/////*     */     //   497: return
/////*     */     // Line number table:
/////*     */     //   Java source line #136	-> byte code offset #0
/////*     */     //   Java source line #137	-> byte code offset #23
/////*     */     //   Java source line #138	-> byte code offset #31
/////*     */     //   Java source line #139	-> byte code offset #34
/////*     */     //   Java source line #140	-> byte code offset #46
/////*     */     //   Java source line #141	-> byte code offset #79
/////*     */     //   Java source line #142	-> byte code offset #112
/////*     */     //   Java source line #143	-> byte code offset #153
/////*     */     //   Java source line #144	-> byte code offset #177
/////*     */     //   Java source line #145	-> byte code offset #203
/////*     */     //   Java source line #147	-> byte code offset #239
/////*     */     //   Java source line #148	-> byte code offset #248
/////*     */     //   Java source line #149	-> byte code offset #260
/////*     */     //   Java source line #150	-> byte code offset #274
/////*     */     //   Java source line #151	-> byte code offset #298
/////*     */     //   Java source line #154	-> byte code offset #322
/////*     */     //   Java source line #156	-> byte code offset #333
/////*     */     //   Java source line #157	-> byte code offset #339
/////*     */     //   Java source line #158	-> byte code offset #346
/////*     */     //   Java source line #159	-> byte code offset #357
/////*     */     //   Java source line #160	-> byte code offset #360
/////*     */     //   Java source line #161	-> byte code offset #362
/////*     */     //   Java source line #164	-> byte code offset #371
/////*     */     //   Java source line #166	-> byte code offset #380
/////*     */     //   Java source line #167	-> byte code offset #385
/////*     */     //   Java source line #168	-> byte code offset #390
/////*     */     //   Java source line #163	-> byte code offset #402
/////*     */     //   Java source line #164	-> byte code offset #404
/////*     */     //   Java source line #166	-> byte code offset #413
/////*     */     //   Java source line #167	-> byte code offset #418
/////*     */     //   Java source line #168	-> byte code offset #423
/////*     */     //   Java source line #170	-> byte code offset #432
/////*     */     //   Java source line #164	-> byte code offset #435
/////*     */     //   Java source line #166	-> byte code offset #444
/////*     */     //   Java source line #167	-> byte code offset #449
/////*     */     //   Java source line #168	-> byte code offset #454
/////*     */     //   Java source line #171	-> byte code offset #463
/////*     */     //   Java source line #172	-> byte code offset #468
/////*     */     //   Java source line #141	-> byte code offset #477
/////*     */     //   Java source line #138	-> byte code offset #487
/////*     */     //   Java source line #178	-> byte code offset #497
/////*     */     // Local variable table:
/////*     */     //   start	length	slot	name	signature
/////*     */     //   0	498	0	profileId	long
/////*     */     //   0	498	2	pic	byte[]
/////*     */     //   0	498	3	serial	long
/////*     */     //   29	459	5	itr	java.util.Iterator<IesCameraImage>
/////*     */     //   44	395	6	image	IesCameraImage
/////*     */     //   110	111	7	cameraId	Long
/////*     */     //   95	383	8	localIterator	java.util.Iterator
/////*     */     //   258	3	9	dateFormat	SimpleDateFormat
/////*     */     //   272	43	10	dateString	String
/////*     */     //   296	31	11	path	String
/////*     */     //   320	22	12	relPath	String
/////*     */     //   331	114	13	fos	java.io.FileOutputStream
/////*     */     //   360	3	14	e	Throwable
/////*     */     //   466	3	14	e1	java.io.FileNotFoundException
/////*     */     //   402	31	15	localObject	Object
/////*     */     //   388	3	16	e	java.io.IOException
/////*     */     //   421	3	16	e	java.io.IOException
/////*     */     //   452	3	16	e	java.io.IOException
/////*     */     // Exception table:
/////*     */     //   from	to	target	type
/////*     */     //   333	357	360	java/lang/Throwable
/////*     */     //   380	385	388	java/io/IOException
/////*     */     //   333	371	402	finally
/////*     */     //   413	418	421	java/io/IOException
/////*     */     //   444	449	452	java/io/IOException
/////*     */     //   322	463	466	java/io/FileNotFoundException
/////*     */   }
/////*     */   
/////*     */   public static synchronized void insertImage(IesCameraImage image)
/////*     */   {
/////* 181 */     imageQueue.add(image);
/////*     */   }
/////*     */ }
////
////
/////* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\DjhuaCallback.class
//// * Java compiler version: 8 (52.0)
//// * JD-Core Version:       0.7.1
//// */