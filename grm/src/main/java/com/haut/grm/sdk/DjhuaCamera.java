///*     */ package com.haut.grm.sdk;
///*     */ 
///*     */ import com.haut.grm.model.DeviceCamera;
///*     */ import com.haut.grm.model.ies.GrainTraffic;
///*     */ import com.haut.grm.model.ies.IesCameraImage;
///*     */ import com.haut.grm.model.ies.IesCameraRegistry;
///*     */ import java.io.PrintStream;
///*     */ import java.util.HashMap;
///*     */ import java.util.Map;
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ 
///*     */ public class DjhuaCamera
///*     */ {
///*     */   public static final String connectorDllName = "djhua_camera_connector";
///*     */   public static final String EVENT_IVS_TRAFFICGATE_NAME = "自动检测";
///*     */   public static final String EVENT_IVS_TRAFFIC_MANUALSNAP_NAME = "手动提取";
///*     */   public static final long EVENT_IVS_TRAFFICGATE = 24L;
///*     */   public static final long EVENT_IVS_TRAFFIC_MANUALSNAP = 280L;
///*     */   public static final long EVENT_IVS_TRAFFIC_TOLLGATE = 288L;
///*  25 */   private static DjhuaCamera singleton = new DjhuaCamera();
///*     */   
///*  27 */   private static Map<Long, CameraContext> map = new HashMap();
///*     */   
///*     */   private void loadSdkOnly() {
///*  30 */     System.loadLibrary("djhua_camera_connector");
///*     */   }
///*     */   
///*     */   private DjhuaCamera() {
///*  34 */     loadSdkOnly();
///*     */   }
///*     */   
///*     */   public Map<Long, CameraContext> getMap() {
///*  38 */     return map;
///*     */   }
///*     */   
///*     */   public static DjhuaCamera getInstance() {
///*  42 */     return singleton;
///*     */   }
///*     */   
///*     */   public synchronized void connect(DeviceCamera camera) throws Exception {
///*  46 */     if (map.get(camera.getId()) == null) {
///*  47 */       CameraContext context = new CameraContext(camera.getUsername() == null ? "admin" : camera.getUsername(), camera.getPassword() == null ? "admin" : camera.getPassword(), camera.getIpAddress(), (Long)camera.getId());
///*  48 */       context.setProfileId(start(context.getIpAddress(), context.getUser(), context.getPassword()));
///*  49 */       System.out.println("车牌设备连接成功：" + context.getProfileId());
///*  50 */       if (context.isClosed())
///*  51 */         throw new Exception("无法启动");
///*  52 */       map.put((Long)camera.getId(), context);
///*     */     }
///*     */     else {
///*  55 */       CameraContext context = (CameraContext)map.get(camera.getId());
///*  56 */       if (context.isClosed())
///*  57 */         context.setProfileId(start(context.getIpAddress(), context.getUser(), context.getPassword()));
///*  58 */       map.put((Long)camera.getId(), context);
///*     */     }
///*     */   }
///*     */   
///*     */   public synchronized void connect2(DeviceCamera camera) throws Exception {
///*  63 */     if (map.get(camera.getId()) == null) {
///*  64 */       CameraContext context = new CameraContext(camera.getUsername() == null ? "admin" : camera.getUsername(), camera.getPassword() == null ? "admin" : camera.getPassword(), camera.getIpAddress(), (Long)camera.getId());
///*  65 */       context.setProfileId(start2(context.getIpAddress(), context.getUser(), context.getPassword()));
///*  66 */       System.out.println("大华设备连接成功：" + context.getProfileId());
///*  67 */       if (context.isClosed())
///*  68 */         throw new Exception("无法启动");
///*  69 */       map.put((Long)camera.getId(), context);
///*     */     }
///*     */     else {
///*  72 */       CameraContext context = (CameraContext)map.get(camera.getId());
///*  73 */       if (context.isClosed())
///*  74 */         context.setProfileId(start2(context.getIpAddress(), context.getUser(), context.getPassword()));
///*  75 */       map.put((Long)camera.getId(), context);
///*     */     }
///*     */   }
///*     */   
///*     */   public synchronized void disconnect(DeviceCamera camera) throws Exception {
///*  80 */     if (map.get(camera.getId()) != null) {
///*  81 */       CameraContext context = (CameraContext)map.get(camera.getId());
///*  82 */       if (!context.isClosed()) {
///*  83 */         stop(context.getProfileId());
///*  84 */         context.setProfileId(-1L);
///*     */       }
///*     */     }
///*     */   }
///*     */   
///*     */   public void snap(Long id) throws Exception {
///*  90 */     if ((map.get(id) != null) && (!((CameraContext)map.get(id)).isClosed())) {
///*  91 */       snap(((CameraContext)map.get(id)).getProfileId());
///*     */     }
///*     */     else {
///*  94 */       throw new Exception("no such camera");
///*     */     }
///*     */   }
///*     */   
///*     */   public void up(Long id, String plate) throws Exception {
///*  99 */     if ((map.get(id) != null) && (!((CameraContext)map.get(id)).isClosed())) {
///* 100 */       up(((CameraContext)map.get(id)).getProfileId(), plate);
///*     */     }
///*     */     else {
///* 103 */       throw new Exception("no such camera");
///*     */     }
///*     */   }
///*     */   
///*     */   public void down(Long id) throws Exception {
///* 108 */     if ((map.get(id) != null) && (!((CameraContext)map.get(id)).isClosed())) {
///* 109 */       down(((CameraContext)map.get(id)).getProfileId());
///*     */     }
///*     */     else {
///* 112 */       throw new Exception("no such camera");
///*     */     }
///*     */   }
///*     */   
///*     */   public boolean snapshot(IesCameraRegistry cr, GrainTraffic gt) throws Exception {
///* 117 */     if ((map.get(cr.getCamera().getId()) == null) || (((CameraContext)map.get(cr.getCamera().getId())).isClosed())) {
///* 118 */       connect2(cr.getCamera());
///*     */     }
///* 120 */     IesCameraImage image = new IesCameraImage();
///* 121 */     image.setGrainTraffic(gt);
///* 122 */     image.setRegistry(cr);
///* 123 */     DjhuaCallback.insertImage(image);
///* 124 */     return snapshot(((CameraContext)map.get(cr.getCamera().getId())).getProfileId(), ((Long)gt.getId()).longValue());
///*     */   }
///*     */   
///*     */   public static native long start(String paramString1, String paramString2, String paramString3);
///*     */   
///*     */   public static native long start2(String paramString1, String paramString2, String paramString3);
///*     */   
///*     */   public static native void stop(long paramLong);
///*     */   
///*     */   public static native long snap(long paramLong);
///*     */   
///*     */   public static native boolean snapshot(long paramLong1, long paramLong2);
///*     */   
///*     */   public static native long up(long paramLong, String paramString);
///*     */   
///*     */   public static native long down(long paramLong);
///*     */   
///*     */   public static native boolean init();
///*     */   
///*     */   public static native void cleanup();
///*     */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\DjhuaCamera.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */