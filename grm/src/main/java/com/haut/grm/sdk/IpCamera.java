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
/*     */ public class IpCamera
/*     */ {
/*     */   public static final String connectorDllName = "sdk_connector";
/*     */   public static final int LOGOUT_WAIT_MINUTES = 20;
/*     */   public static final int PTZ_COMMAND_ZOOM_IN = 24;
/*     */   public static final int PTZ_COMMAND_ZOOM_OUT = 23;
/*     */   public static final int PTZ_COMMAND_FOCUS_NEAR = 21;
/*     */   public static final int PTZ_COMMAND_FOCUS_FAR = 22;
/*     */   public static final int PTZ_COMMAND_IRIS_OPEN = 53;
/*     */   public static final int PTZ_COMMAND_IRIS_CLOSE = 54;
/*     */   public static final int PTZ_CONTROL_START = 0;
/*     */   public static final int PTZ_CONTROL_STOP = 1;
/*     */   public static final int PTZ_COMMAND_LEFT = 27;
/*     */   public static final int PTZ_COMMAND_RIGHT = 28;
/*     */   public static final int PTZ_COMMAND_UP = 25;
/*     */   public static final int PTZ_COMMAND_DOWN = 26;
/*     */   public static final int PTZ_COMMAND_AUX_ON = 47;
/*     */   public static final int PTZ_COMMAND_AUX_OFF = 48;
/*     */   public static final int PTZ_COMMAND_AUX_LIGHT = 3;
/*     */   public static final int PTZ_COMMAND_AUX_FAR_LIGHT = 5;
/*     */   public static final int PTZ_COMMAND_AUX_BRUSH = 1;
/*     */   public static final int H_SPEED = 80;
/*     */   public static final int V_SPEED = 80;
/*     */   public static final int H_SPEED_SLOW = 40;
/*     */   public static final int V_SPEED_SLOW = 40;
/*  61 */   private static Map<Long, SdkContext> map = new HashMap();
/*     */   private static ScheduledFuture<?> logoutFuture;
/*     */   private static IpCamera singleton;
/*     */   
/*     */   private void initSDK() throws Throwable {
///*  66 */     System.loadLibrary("sdk_connector");
///*  67 */     wdInit();
/*     */   }
/*     */   
/*     */   private IpCamera()
/*     */     throws Throwable
/*     */   {
/*  73 */     initSDK();
/*     */   }
/*     */   
/*     */   public static IpCamera getInstance() throws Throwable {
/*  77 */     if (singleton == null)
/*  78 */       singleton = new IpCamera();
/*  79 */     return singleton;
/*     */   }
/*     */   
/*     */   public synchronized SdkContext getContext(DeviceCamera camera) {
/*  83 */     if (camera == null)
/*  84 */       return null;
/*  85 */     SdkContext profile = new SdkContext();
/*  86 */     if (map.get(camera.getId()) == null) {
/*  87 */       profile.setIpAddress(camera.getIpAddress());
/*  88 */       if (camera.getUsername() != null) {
/*  89 */         profile.setUser(camera.getUsername());
/*     */       } else {
/*  91 */         profile.setUser("admin");
/*     */       }
/*  93 */       if (camera.getPassword() != null) {
/*  94 */         profile.setPassword(camera.getPassword());
/*     */       } else
/*  96 */         profile.setPassword("admin");
/*  97 */       profile = connect(profile);
/*  98 */       map.put((Long)camera.getId(), profile);
/*     */     }
/*     */     else {
/* 101 */       profile = (SdkContext)map.get(camera.getId());
/* 102 */       if (profile.isClosed()) {
/* 103 */         profile = connect(profile);
/* 104 */         map.put((Long)camera.getId(), profile);
/*     */       }
/*     */     }
/*     */     
/* 108 */     return profile;
/*     */   }
/*     */   
/*     */   public SdkContext connect(SdkContext profile) {
/* 112 */     profile.setProfileId(wdLogin(profile.getIpAddress(), profile.getPort(), profile.getUser(), profile.getPassword()));
/* 113 */     return profile;
/*     */   }
/*     */   
/*     */   public SdkContext disconnect(SdkContext profile) {
/* 117 */     if (!profile.isClosed()) {
/* 118 */       wdLogout(profile.getProfileId());
/* 119 */       profile.setProfileId(-1);
/*     */     }
/* 121 */     return profile;
/*     */   }
/*     */   
/*     */   public boolean zoomInStart(SdkContext profile) {
/* 125 */     if (profile.isClosed()) {
/* 126 */       return false;
/*     */     }
/* 128 */     return wdCommand(profile.getProfileId(), 24, 80, 80, 0) >= 0;
/*     */   }
/*     */   
/*     */   public boolean zoomInStart(DeviceCamera camera)
/*     */   {
/* 133 */     return zoomInStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean zoomInStop(SdkContext profile) {
/* 137 */     if (profile.isClosed()) {
/* 138 */       return false;
/*     */     }
/* 140 */     boolean result = wdCommand(profile.getProfileId(), 24, 80, 80, 1) >= 0;
/*     */     
/* 142 */     return result;
/*     */   }
/*     */   
/*     */   public boolean zoomInStop(DeviceCamera camera) {
/* 146 */     return zoomInStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean zoomOutStart(SdkContext profile) {
/* 150 */     if (profile.isClosed()) {
/* 151 */       return false;
/*     */     }
/* 153 */     boolean result = wdCommand(profile.getProfileId(), 23, 80, 80, 0) >= 0;
/*     */     
/* 155 */     return result;
/*     */   }
/*     */   
/*     */   public boolean zoomOutStart(DeviceCamera camera) {
/* 159 */     return zoomOutStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean leftStart(SdkContext profile) {
/* 163 */     if (profile.isClosed()) {
/* 164 */       return false;
/*     */     }
/* 166 */     boolean result = wdCommand(profile.getProfileId(), 27, 40, 40, 0) >= 0;
/*     */     
/* 168 */     return result;
/*     */   }
/*     */   
/*     */   public boolean leftStart(DeviceCamera camera) {
/* 172 */     return leftStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean leftStop(SdkContext profile) {
/* 176 */     if (profile.isClosed()) {
/* 177 */       return false;
/*     */     }
/* 179 */     boolean result = wdCommand(profile.getProfileId(), 27, 40, 40, 1) >= 0;
/*     */     
/* 181 */     return result;
/*     */   }
/*     */   
/*     */   public boolean leftStop(DeviceCamera camera) {
/* 185 */     return leftStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean rightStart(SdkContext profile) {
/* 189 */     if (profile.isClosed()) {
/* 190 */       return false;
/*     */     }
/* 192 */     boolean result = wdCommand(profile.getProfileId(), 28, 40, 40, 0) >= 0;
/*     */     
/* 194 */     return result;
/*     */   }
/*     */   
/*     */   public boolean rightStart(DeviceCamera camera) {
/* 198 */     return rightStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean rightStop(SdkContext profile) {
/* 202 */     if (profile.isClosed()) {
/* 203 */       return false;
/*     */     }
/* 205 */     boolean result = wdCommand(profile.getProfileId(), 28, 40, 40, 1) >= 0;
/*     */     
/* 207 */     return result;
/*     */   }
/*     */   
/*     */   public boolean rightStop(DeviceCamera camera) {
/* 211 */     return rightStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean upStart(SdkContext profile) {
/* 215 */     if (profile.isClosed()) {
/* 216 */       return false;
/*     */     }
/* 218 */     boolean result = wdCommand(profile.getProfileId(), 25, 40, 40, 0) >= 0;
/*     */     
/* 220 */     return result;
/*     */   }
/*     */   
/*     */   public boolean upStart(DeviceCamera camera) {
/* 224 */     return upStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean upStop(SdkContext profile) {
/* 228 */     if (profile.isClosed()) {
/* 229 */       return false;
/*     */     }
/* 231 */     boolean result = wdCommand(profile.getProfileId(), 25, 40, 40, 1) >= 0;
/*     */     
/* 233 */     return result;
/*     */   }
/*     */   
/*     */   public boolean upStop(DeviceCamera camera) {
/* 237 */     return upStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean downStart(SdkContext profile) {
/* 241 */     if (profile.isClosed()) {
/* 242 */       return false;
/*     */     }
/* 244 */     boolean result = wdCommand(profile.getProfileId(), 26, 40, 40, 0) >= 0;
/*     */     
/* 246 */     return result;
/*     */   }
/*     */   
/*     */   public boolean downStart(DeviceCamera camera) {
/* 250 */     return downStart(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean downStop(SdkContext profile) {
/* 254 */     if (profile.isClosed()) {
/* 255 */       return false;
/*     */     }
/* 257 */     boolean result = wdCommand(profile.getProfileId(), 26, 40, 40, 1) >= 0;
/*     */     
/* 259 */     return result;
/*     */   }
/*     */   
/*     */   public boolean downStop(DeviceCamera camera) {
/* 263 */     return downStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean zoomOutStop(SdkContext profile) {
/* 267 */     if (profile.isClosed()) {
/* 268 */       return false;
/*     */     }
/* 270 */     return wdCommand(profile.getProfileId(), 23, 80, 80, 1) >= 0;
/*     */   }
/*     */   
/*     */   public boolean zoomOutStop(DeviceCamera camera) {
/* 274 */     return zoomOutStop(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean brushOn(SdkContext profile) {
/* 278 */     if (profile.isClosed()) {
/* 279 */       return false;
/*     */     }
/* 281 */     return wdCommand(profile.getProfileId(), 47, 0, 0, 1) >= 0;
/*     */   }
/*     */   
/*     */   public boolean brushOn(DeviceCamera camera) {
/* 285 */     return brushOn(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean brushOff(SdkContext profile) {
/* 289 */     if (profile.isClosed()) {
/* 290 */       return false;
/*     */     }
/* 292 */     return wdCommand(profile.getProfileId(), 48, 0, 0, 1) >= 0;
/*     */   }
/*     */   
/*     */   public boolean brushOff(DeviceCamera camera) {
/* 296 */     return brushOff(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean lightOn(SdkContext profile) {
/* 300 */     if (profile.isClosed()) {
/* 301 */       return false;
/*     */     }
/* 303 */     return wdCommand(profile.getProfileId(), 47, 0, 0, 3) >= 0;
/*     */   }
/*     */   
/*     */   public boolean lightOn(DeviceCamera camera) {
/* 307 */     return lightOn(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean lightOff(SdkContext profile) {
/* 311 */     if (profile.isClosed()) {
/* 312 */       return false;
/*     */     }
/* 314 */     return wdCommand(profile.getProfileId(), 48, 0, 0, 3) >= 0;
/*     */   }
/*     */   
/*     */   public boolean lightOff(DeviceCamera camera) {
/* 318 */     return lightOff(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean farLightOn(SdkContext profile) {
/* 322 */     if (profile.isClosed()) {
/* 323 */       return false;
/*     */     }
/* 325 */     return wdCommand(profile.getProfileId(), 47, 0, 0, 5) >= 0;
/*     */   }
/*     */   
/*     */   public boolean farLightOn(DeviceCamera camera) {
/* 329 */     return farLightOn(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean farLightOff(SdkContext profile) {
/* 333 */     if (profile.isClosed()) {
/* 334 */       return false;
/*     */     }
/* 336 */     return wdCommand(profile.getProfileId(), 48, 0, 0, 5) >= 0;
/*     */   }
/*     */   
/*     */   public boolean farLightOff(DeviceCamera camera) {
/* 340 */     return farLightOff(getContext(camera));
/*     */   }
/*     */   
/*     */   public boolean setPreset(SdkContext profile, int position) {
/* 344 */     if ((profile.isClosed()) || (position < 1) || (position > 255)) {
/* 345 */       return false;
/*     */     }
/* 347 */     return wdSetPreset(profile.getProfileId(), position, "DOOR_" + position) >= 0;
/*     */   }
/*     */   
/*     */   public boolean setPreset(DeviceCamera camera, int position) {
/* 351 */     return setPreset(getContext(camera), position);
/*     */   }
/*     */   
/*     */   public boolean deletePreset(SdkContext profile, int position) {
/* 355 */     if ((profile.isClosed()) || (position < 1) || (position > 255)) {
/* 356 */       return false;
/*     */     }
/* 358 */     return wdClearPreset(profile.getProfileId(), position) >= 0;
/*     */   }
/*     */   
/*     */   public boolean deletePreset(DeviceCamera camera, int position) {
/* 362 */     return deletePreset(getContext(camera), position);
/*     */   }
/*     */   
/*     */   public boolean turnToPreset(SdkContext profile, int position) {
/* 366 */     if ((profile.isClosed()) || (position < 1) || (position > 255)) {
/* 367 */       return false;
/*     */     }
/* 369 */     return wdGotoPreset(profile.getProfileId(), position, 80, 80) >= 0;
/*     */   }
/*     */   
/*     */   public boolean turnToPreset(DeviceCamera camera, int position) {
/* 373 */     return turnToPreset(getContext(camera), position);
/*     */   }
/*     */   
/*     */   private synchronized void scheduleOrPostponeLogout()
/*     */   {
/* 378 */     if (logoutFuture != null) {
/* 379 */       logoutFuture.cancel(false);
/*     */     }
/*     */     
/* 382 */     logoutFuture = GlobalHandler.getScheduler().schedule(this.logoutThread, new DateTime().plusMinutes(20).toDate());
/*     */   }
/*     */   
/* 385 */   private final Runnable logoutThread = new Runnable()
/*     */   {
/*     */     public void run() {
/* 388 */       for (SdkContext context : IpCamera.map.values()) {
/* 389 */         context = IpCamera.this.disconnect(context);
/*     */       }
/* 391 */       System.out.println("SUCCESS LOGOUT");
/*     */     }
/*     */   };
/*     */   
/*     */   public static native boolean wdInit();
/*     */   
/*     */   public static native boolean wdCleanup();
/*     */   
/*     */   public static native int wdLogin(String paramString1, short paramShort, String paramString2, String paramString3);
/*     */   
/*     */   public static native void wdLogout(int paramInt);
/*     */   
/*     */   public static native int wdCommand(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
/*     */   
/*     */   public static native int wdSetPreset(int paramInt1, int paramInt2, String paramString);
/*     */   
/*     */   public static native int wdGotoPreset(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   public static native int wdClearPreset(int paramInt1, int paramInt2);
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\IpCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */