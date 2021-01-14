/*     */ package com.haut.grm.sdk;
/*     */ 
/*     */ import com.haut.grm.bean.GlobalHandler;
/*     */ import com.haut.grm.model.DeviceCamera;
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
/*     */ public class KdCamera
/*     */ {
/*     */   public static final String connectorDllName = "kd_sdk_connector";
/*     */   public static final int LOGOUT_WAIT_MINUTES = 20;
/*     */   public static final int DEFAULT_SPEED = 50;
/*     */   public static final String PTZ_COMMAND_MOVE_STOP = "movestop";
/*     */   public static final String PTZ_COMMAND_MOVE_UP = "moveup";
/*     */   public static final String PTZ_COMMAND_MOVE_DOWN = "movedown";
/*     */   public static final String PTZ_COMMAND_MOVE_LEFT = "moveleft";
/*     */   public static final String PTZ_COMMAND_MOVE_LEFT_UP = "move_leftup";
/*     */   public static final String PTZ_COMMAND_MOVE_LEFT_DOWN = "move_leftdown";
/*     */   public static final String PTZ_COMMAND_MOVE_RIGHT = "moveright";
/*     */   public static final String PTZ_COMMAND_MOVE_RIGHT_UP = "move_rightup";
/*     */   public static final String PTZ_COMMAND_MOVE_RIGHT_DOWN = "move_rightdown";
/*     */   public static final String PTZ_COMMAND_MOVE_RESET = "ptz_reset";
/*     */   public static final String PTZ_COMMAND_ZOOM_STOP = "zoomstop";
/*     */   public static final String PTZ_COMMAND_ZOOM_IN = "zoomtele";
/*     */   public static final String PTZ_COMMAND_ZOOM_OUT = "zoomwide";
/*  47 */   private static Map<Long, KdContext> map = new HashMap();
/*     */   private static ScheduledFuture<?> logoutFuture;
/*     */   private static KdCamera singleton;
/*     */   
/*     */   private void initSDK() throws Throwable {
/*  52 */     System.loadLibrary("kd_sdk_connector");
/*  53 */     kdInit();
/*     */   }
/*     */   
/*     */   private KdCamera()
/*     */     throws Throwable
/*     */   {
/*  59 */     initSDK();
/*     */   }
/*     */   
/*     */   public static KdCamera getInstance() throws Throwable {
/*  63 */     if (singleton == null)
/*  64 */       singleton = new KdCamera();
/*  65 */     return singleton;
/*     */   }
/*     */   
/*     */   public synchronized KdContext getContext(DeviceCamera camera) {
/*  69 */     if (camera.getIpAddress() == null)
/*  70 */       return null;
/*  71 */     KdContext profile = new KdContext();
/*  72 */     if (map.get(camera.getId()) == null) {
/*  73 */       profile.setIpAddress(camera.getIpAddress());
/*  74 */       if (camera.getUsername() != null) {
/*  75 */         profile.setUser(camera.getUsername());
/*     */       } else {
/*  77 */         profile.setUser("admin");
/*     */       }
/*  79 */       if (camera.getPassword() != null) {
/*  80 */         profile.setPassword(camera.getPassword());
/*     */       } else
/*  82 */         profile.setPassword("admin");
/*  83 */       profile = connect(profile);
/*  84 */       map.put((Long)camera.getId(), profile);
/*     */     }
/*     */     else {
/*  87 */       profile = (KdContext)map.get(camera.getId());
/*  88 */       if (profile.isClosed()) {
/*  89 */         profile = connect(profile);
/*  90 */         map.put((Long)camera.getId(), profile);
/*     */       }
/*     */     }
/*     */     
/*  94 */     return profile;
/*     */   }
/*     */   
/*     */   public KdContext connect(KdContext profile) {
/*  98 */     profile.setProfileId(kdLogin(profile.getFormattedIp(), profile.getPort(), profile.getUser(), profile.getPassword()));
/*  99 */     return profile;
/*     */   }
/*     */   
/*     */   public KdContext disconnect(KdContext profile) {
/* 103 */     if (!profile.isClosed()) {
/* 104 */       kdLogout(profile.getProfileId());
/* 105 */       profile.setProfileId(-1L);
/*     */     }
/* 107 */     return profile;
/*     */   }
/*     */   
/*     */   public boolean command(KdContext profile, String command, Integer speed) {
/* 111 */     if (profile.isClosed())
/* 112 */       return false;
/* 113 */     if (speed == null)
/* 114 */       speed = Integer.valueOf(50);
/* 115 */     return kdCommand(profile.getProfileId(), command, speed.intValue());
/*     */   }
/*     */   
/*     */   public boolean snapshot(KdContext profile, String path) {
/* 119 */     if (profile.isClosed())
/* 120 */       return false;
/* 121 */     return kdSnapshot(profile.getProfileId(), path);
/*     */   }
/*     */   
/*     */   public boolean zoomIn(DeviceCamera camera, Integer speed) {
/* 125 */     return command(getContext(camera), "zoomtele", speed);
/*     */   }
/*     */   
/*     */   public boolean zoomOut(DeviceCamera camera, Integer speed) {
/* 129 */     return command(getContext(camera), "zoomwide", speed);
/*     */   }
/*     */   
/*     */   public boolean zoomStop(DeviceCamera camera, Integer speed) {
/* 133 */     return command(getContext(camera), "zoomstop", speed);
/*     */   }
/*     */   
/*     */   public boolean moveReset(DeviceCamera camera, Integer speed) {
/* 137 */     return command(getContext(camera), "ptz_reset", speed);
/*     */   }
/*     */   
/*     */   public boolean moveStop(DeviceCamera camera, Integer speed) {
/* 141 */     return command(getContext(camera), "movestop", speed);
/*     */   }
/*     */   
/*     */   public boolean up(DeviceCamera camera, Integer speed) {
/* 145 */     return command(getContext(camera), "moveup", speed);
/*     */   }
/*     */   
/*     */   public boolean down(DeviceCamera camera, Integer speed) {
/* 149 */     return command(getContext(camera), "movedown", speed);
/*     */   }
/*     */   
/*     */   public boolean left(DeviceCamera camera, Integer speed) {
/* 153 */     return command(getContext(camera), "moveleft", speed);
/*     */   }
/*     */   
/*     */   public boolean right(DeviceCamera camera, Integer speed) {
/* 157 */     return command(getContext(camera), "moveright", speed);
/*     */   }
/*     */   
/*     */   public boolean leftUp(DeviceCamera camera, Integer speed) {
/* 161 */     return command(getContext(camera), "move_leftup", speed);
/*     */   }
/*     */   
/*     */   public boolean leftDown(DeviceCamera camera, Integer speed) {
/* 165 */     return command(getContext(camera), "move_leftdown", speed);
/*     */   }
/*     */   
/*     */   public boolean rightUp(DeviceCamera camera, Integer speed) {
/* 169 */     return command(getContext(camera), "move_rightup", speed);
/*     */   }
/*     */   
/*     */   public boolean rightDown(DeviceCamera camera, Integer speed) {
/* 173 */     return command(getContext(camera), "move_rightdown", speed);
/*     */   }
/*     */   
/*     */   public boolean snapshot(DeviceCamera camera, String path) {
/* 177 */     return snapshot(getContext(camera), path);
/*     */   }
/*     */   
/*     */   private synchronized void scheduleOrPostponeLogout() {
/* 181 */     if (logoutFuture != null) {
/* 182 */       logoutFuture.cancel(true);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/* 188 */     logoutFuture = GlobalHandler.getScheduler().schedule(this.logoutThread, new DateTime().plusMinutes(20).toDate());
/*     */   }
/*     */   
/* 191 */   private final Runnable logoutThread = new Runnable()
/*     */   {
/*     */     public void run() {
/* 194 */       for (KdContext context : KdCamera.map.values()) {
/* 195 */         context = KdCamera.this.disconnect(context);
/*     */       }
/*     */     }
/*     */   };
/*     */   
/*     */   public static native boolean kdInit();
/*     */   
/*     */   public static native boolean kdCleanup();
/*     */   
/*     */   public static native long kdLogin(long paramLong, short paramShort, String paramString1, String paramString2);
/*     */   
/*     */   public static native boolean kdLogout(long paramLong);
/*     */   
/*     */   public static native boolean kdCommand(long paramLong, String paramString, int paramInt);
/*     */   
/*     */   public static native boolean kdSnapshot(long paramLong, String paramString);
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\KdCamera.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */