/*     */ package com.haut.grm.sdk;
/*     */ 
/*     */ import com.haut.grm.bean.GlobalHandler;
/*     */ import com.haut.grm.model.DeviceCamera;
/*     */ import java.io.PrintStream;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import org.joda.time.DateTime;
/*     */ import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
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
/*     */ public class HkCamera
/*     */ {
/*     */   public static final int LOGOUT_WAIT_MINUTES = 20;
/*     */   public static final int PTZ_COMMAND_LIGHT = 2;
/*     */   public static final int PTZ_COMMAND_BRUSH = 3;
/*     */   public static final int PTZ_COMMAND_ZOOM_IN = 11;
/*     */   public static final int PTZ_COMMAND_ZOOM_OUT = 12;
/*     */   public static final int PTZ_COMMAND_LEFT = 23;
/*     */   public static final int PTZ_COMMAND_RIGHT = 24;
/*     */   public static final int PTZ_COMMAND_UP = 21;
/*     */   public static final int PTZ_COMMAND_DOWN = 22;
/*     */   public static final int PTZ_CONTROL_START = 0;
/*     */   public static final int PTZ_CONTROL_STOP = 1;
/*  36 */   private static Map<Long, HkContext> map = new HashMap();
/*     */   private static ScheduledFuture<?> logoutFuture;
/*     */   public static final String connectorDllName = "hk_sdk_connector";
/*     */   private static HkCamera singleton;
/*     */   
/*     */   public void initSDK() throws Throwable
/*     */   {
///*  43 */     System.loadLibrary("hk_sdk_connector");
///*  44 */     hkInit();
/*     */   }
/*     */   
/*     */   private HkCamera()
/*     */     throws Throwable
/*     */   {
/*  50 */     initSDK();
/*     */   }
/*     */   
/*     */   public static HkCamera getInstance() throws Throwable {
/*  54 */     if (singleton == null)
/*  55 */       singleton = new HkCamera();
/*  56 */     return singleton;
/*     */   }
/*     */   
/*     */   public synchronized HkContext getContext(DeviceCamera camera) {
/*  60 */     if (camera == null)
/*  61 */       return null;
/*  62 */     HkContext profile = new HkContext();
/*  63 */     if (map.get(camera.getId()) == null) {
/*  64 */       profile.setIpAddress(camera.getIpAddress());
/*  65 */       if (camera.getUsername() != null) {
/*  66 */         profile.setUser(camera.getUsername());
/*     */       } else {
/*  68 */         profile.setUser("");
/*     */       }
/*  70 */       if (camera.getPassword() != null) {
/*  71 */         profile.setPassword(camera.getPassword());
/*     */       } else {
/*  73 */         profile.setPassword("");
/*     */       }
/*  75 */       connect(profile);
/*     */       
/*  77 */       map.put((Long)camera.getId(), profile);
/*     */     }
/*     */     else {
/*  80 */       profile = (HkContext)map.get(camera.getId());
/*  81 */       if (profile.isClosed())
/*  82 */         connect(profile);
/*     */     }
/*  84 */     return profile;
/*     */   }
/*     */   
/*     */   public HkContext connect(HkContext profile) {
/*  88 */     long id = hkLogin(profile.getIpAddress(), profile.getPort(), profile.getUser(), profile.getPassword());
/*  89 */     System.out.println("THE HK id is : " + id);
/*  90 */     profile.setProfileId(id);
/*  91 */     return profile;
/*     */   }
/*     */   
/*     */   public HkContext disconnect(HkContext profile) {
/*  95 */     if (profile.isClosed()) {
/*  96 */       hkLogout(profile.getProfileId());
/*  97 */       profile.setProfileId(-1L);
/*     */     }
/*  99 */     return profile;
/*     */   }
/*     */   
/*     */   private synchronized void scheduleOrPostponeLogout() {
/* 103 */     if (logoutFuture != null) {
/* 104 */       logoutFuture.cancel(false);
/*     */     }
/* 106 */     logoutFuture = GlobalHandler.getScheduler().schedule(this.logoutThread, new DateTime().plusMinutes(20).toDate());
/*     */   }
/*     */   
/* 109 */   private final Runnable logoutThread = new Runnable()
/*     */   {
/*     */     public void run() {
/* 112 */       for (HkContext context : HkCamera.map.values()) {
/* 113 */         context = HkCamera.this.disconnect(context);
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   public boolean zoomInStart(HkContext profile) {
/* 119 */     if (profile.isClosed()) {
/* 120 */       return false;
/*     */     }
/* 122 */     return hkCommand(profile.getProfileId(), 11L, 0L);
/*     */   }
/*     */   
/*     */   public boolean zoomInStart(DeviceCamera camera)
/*     */   {
/* 127 */     return zoomInStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean zoomInStop(HkContext profile) {
/* 131 */     if (profile.isClosed()) {
/* 132 */       return false;
/*     */     }
/* 134 */     return hkCommand(profile.getProfileId(), 11L, 1L);
/*     */   }
/*     */   
/*     */   public boolean zoomInStop(DeviceCamera camera) {
/* 138 */     return zoomInStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean zoomOutStart(HkContext profile) {
/* 142 */     if (profile.isClosed()) {
/* 143 */       return false;
/*     */     }
/* 145 */     return hkCommand(profile.getProfileId(), 12L, 0L);
/*     */   }
/*     */   
/*     */   public boolean zoomOutStart(DeviceCamera camera) {
/* 149 */     return zoomOutStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean leftStart(HkContext profile) {
/* 153 */     if (profile.isClosed()) {
/* 154 */       return false;
/*     */     }
/* 156 */     return hkCommand(profile.getProfileId(), 23L, 0L);
/*     */   }
/*     */   
/*     */   public boolean leftStart(DeviceCamera camera) {
/* 160 */     return leftStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean leftStop(HkContext profile) {
/* 164 */     if (profile.isClosed()) {
/* 165 */       return false;
/*     */     }
/* 167 */     return hkCommand(profile.getProfileId(), 23L, 1L);
/*     */   }
/*     */   
/*     */   public boolean leftStop(DeviceCamera camera) {
/* 171 */     return leftStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean rightStart(HkContext profile) {
/* 175 */     if (profile.isClosed()) {
/* 176 */       return false;
/*     */     }
/* 178 */     return hkCommand(profile.getProfileId(), 24L, 0L);
/*     */   }
/*     */   
/*     */   public boolean rightStart(DeviceCamera camera) {
/* 182 */     return rightStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean rightStop(HkContext profile) {
/* 186 */     if (profile.isClosed()) {
/* 187 */       return false;
/*     */     }
/* 189 */     return hkCommand(profile.getProfileId(), 24L, 1L);
/*     */   }
/*     */   
/*     */   public boolean rightStop(DeviceCamera camera) {
/* 193 */     return rightStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean upStart(HkContext profile) {
/* 197 */     if (profile.isClosed()) {
/* 198 */       return false;
/*     */     }
/* 200 */     return hkCommand(profile.getProfileId(), 21L, 0L);
/*     */   }
/*     */   
/*     */   public boolean upStart(DeviceCamera camera) {
/* 204 */     return upStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean upStop(HkContext profile) {
/* 208 */     if (profile.isClosed()) {
/* 209 */       return false;
/*     */     }
/* 211 */     return hkCommand(profile.getProfileId(), 21L, 1L);
/*     */   }
/*     */   
/*     */   public boolean upStop(DeviceCamera camera) {
/* 215 */     return upStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean downStart(HkContext profile) {
/* 219 */     if (profile.isClosed()) {
/* 220 */       return false;
/*     */     }
/* 222 */     return hkCommand(profile.getProfileId(), 22L, 0L);
/*     */   }
/*     */   
/*     */   public boolean downStart(DeviceCamera camera) {
/* 226 */     return downStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean downStop(HkContext profile) {
/* 230 */     if (profile.isClosed()) {
/* 231 */       return false;
/*     */     }
/* 233 */     return hkCommand(profile.getProfileId(), 22L, 1L);
/*     */   }
/*     */   
/*     */   public boolean downStop(DeviceCamera camera) {
/* 237 */     return downStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean zoomOutStop(HkContext profile) {
/* 241 */     if (profile.isClosed()) {
/* 242 */       return false;
/*     */     }
/* 244 */     return hkCommand(profile.getProfileId(), 12L, 1L);
/*     */   }
/*     */   
/*     */   public boolean zoomOutStop(DeviceCamera camera) {
/* 248 */     return zoomOutStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean brushOn(HkContext profile) {
/* 252 */     if (profile.isClosed()) {
/* 253 */       return false;
/*     */     }
/* 255 */     return hkCommand(profile.getProfileId(), 0L, 3L);
/*     */   }
/*     */   
/*     */   public boolean brushOn(DeviceCamera camera) {
/* 259 */     return brushOn(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean brushOff(HkContext profile) {
/* 263 */     if (profile.isClosed()) {
/* 264 */       return false;
/*     */     }
/* 266 */     return hkCommand(profile.getProfileId(), 1L, 3L);
/*     */   }
/*     */   
/*     */   public boolean brushOff(DeviceCamera camera) {
/* 270 */     return brushOff(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean lightOn(HkContext profile) {
/* 274 */     if (profile.isClosed()) {
/* 275 */       return false;
/*     */     }
/* 277 */     return hkCommand(profile.getProfileId(), 0L, 2L);
/*     */   }
/*     */   
/*     */   public boolean lightOn(DeviceCamera camera) {
/* 281 */     return lightOn(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean lightOff(HkContext profile) {
/* 285 */     if (profile.isClosed()) {
/* 286 */       return false;
/*     */     }
/* 288 */     return hkCommand(profile.getProfileId(), 1L, 2L);
/*     */   }
/*     */   
/*     */   public boolean lightOff(DeviceCamera camera) {
/* 292 */     return lightOff(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean snapshot(HkContext profile, String path) {
/* 296 */     if (profile.isClosed()) {
/* 297 */       return false;
/*     */     }
/* 299 */     return hkSnapshot(profile.getProfileId(), path);
/*     */   }
/*     */   
/*     */   public boolean snapshot(DeviceCamera camera, String path) {
/* 303 */     return snapshot(getContext(camera), path);
/*     */   }
/*     */   
/*     */   public static native void hkInit();
/*     */   
/*     */   public static native void hkCleanup();
/*     */   
/*     */   public static native long hkLogin(String paramString1, short paramShort, String paramString2, String paramString3);
/*     */   
/*     */   public static native void hkLogout(long paramLong);
/*     */   
/*     */   public static native boolean hkCommand(long paramLong1, long paramLong2, long paramLong3);
/*     */   
/*     */   public static native boolean hkSnapshot(long paramLong, String paramString);
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\HkCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */