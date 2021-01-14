/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.haut.grm.bean.GlobalHandler;
/*     */ import com.haut.grm.model.DeviceCamera;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.ies.GrainTraffic;
/*     */ import com.haut.grm.model.type.CameraManufacturer;
/*     */ import com.haut.grm.repository.DeviceCameraRepository;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.ies.GrainTrafficRepository;
///*     */ import com.haut.grm.sdk.DjhuaCamera;
/*     */ import com.haut.grm.sdk.HkCamera;
/*     */ import com.haut.grm.sdk.IpCamera;
/*     */ import com.haut.grm.sdk.KdCamera;
///*     */ import com.haut.grm.util.LEDUtil;
/*     */ import com.haut.grm.util.SMSUtil;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.http.HttpStatus;
/*     */ import org.springframework.http.ResponseEntity;
/*     */ import org.springframework.http.ResponseEntity.BodyBuilder;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ public class SdkController
/*     */ {
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private DeviceCameraRepository cameraRepo;
/*     */   @Autowired
/*     */   private GrainTrafficRepository gtRepo;
/*     */   @Autowired
/*     */   private GlobalHandler _gHandler;
/*     */   






/*     */   @RequestMapping(value={"/sdk/zoom_in_start/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean zoomInStart(@PathVariable("id") Long id)
/*     */     throws Throwable
/*     */   {
/*  41 */     Store store = (Store)this.storeRepo.findOne(id);
/*  42 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().zoomInStart(store.getCamera()) : IpCamera.getInstance().zoomInStart(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/zoom_in_stop/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean zoomInStop(@PathVariable("id") Long id) throws Throwable {
/*  47 */     Store store = (Store)this.storeRepo.findOne(id);
/*  48 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().zoomInStop(store.getCamera()) : IpCamera.getInstance().zoomInStop(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/zoom_out_start/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean zoomOutStart(@PathVariable("id") Long id) throws Throwable {
/*  53 */     Store store = (Store)this.storeRepo.findOne(id);
/*  54 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().zoomOutStart(store.getCamera()) : IpCamera.getInstance().zoomOutStart(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/zoom_out_stop/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean zoomOutStop(@PathVariable("id") Long id) throws Throwable {
/*  59 */     Store store = (Store)this.storeRepo.findOne(id);
/*  60 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().zoomOutStop(store.getCamera()) : IpCamera.getInstance().zoomOutStop(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_left_start/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean leftStart(@PathVariable("id") Long id) throws Throwable {
/*  65 */     Store store = (Store)this.storeRepo.findOne(id);
/*  66 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().leftStart(store.getCamera()) : IpCamera.getInstance().leftStart(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_left_stop/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean leftStop(@PathVariable("id") Long id) throws Throwable {
/*  71 */     Store store = (Store)this.storeRepo.findOne(id);
/*  72 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().leftStop(store.getCamera()) : IpCamera.getInstance().leftStop(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_right_start/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean rightStart(@PathVariable("id") Long id) throws Throwable {
/*  77 */     Store store = (Store)this.storeRepo.findOne(id);
/*  78 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().rightStart(store.getCamera()) : IpCamera.getInstance().rightStart(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_right_stop/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean rightStop(@PathVariable("id") Long id) throws Throwable {
/*  83 */     Store store = (Store)this.storeRepo.findOne(id);
/*  84 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().rightStop(store.getCamera()) : IpCamera.getInstance().rightStop(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_up_start/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean upStart(@PathVariable("id") Long id) throws Throwable {
/*  89 */     Store store = (Store)this.storeRepo.findOne(id);
/*  90 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().upStart(store.getCamera()) : IpCamera.getInstance().upStart(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_up_stop/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean upStop(@PathVariable("id") Long id) throws Throwable {
/*  95 */     Store store = (Store)this.storeRepo.findOne(id);
/*  96 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().upStop(store.getCamera()) : IpCamera.getInstance().upStop(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_down_start/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean downStart(@PathVariable("id") Long id) throws Throwable {
/* 101 */     Store store = (Store)this.storeRepo.findOne(id);
/* 102 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().downStart(store.getCamera()) : IpCamera.getInstance().downStart(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/pan_down_stop/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean downStop(@PathVariable("id") Long id) throws Throwable {
/* 107 */     Store store = (Store)this.storeRepo.findOne(id);
/* 108 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().downStop(store.getCamera()) : IpCamera.getInstance().downStop(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/brush/on/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean brushOn(@PathVariable("id") Long id) throws Throwable {
/* 113 */     Store store = (Store)this.storeRepo.findOne(id);
/* 114 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().brushOn(store.getCamera()) : IpCamera.getInstance().brushOn(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/brush/off/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean brushOff(@PathVariable("id") Long id) throws Throwable {
/* 119 */     Store store = (Store)this.storeRepo.findOne(id);
/* 120 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().brushOff(store.getCamera()) : IpCamera.getInstance().brushOff(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/light/on/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean lightOn(@PathVariable("id") Long id) throws Throwable {
/* 125 */     Store store = (Store)this.storeRepo.findOne(id);
/* 126 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().lightOn(store.getCamera()) : IpCamera.getInstance().lightOn(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/light/off/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean lightOff(@PathVariable("id") Long id) throws Throwable {
/* 131 */     Store store = (Store)this.storeRepo.findOne(id);
/* 132 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().lightOff(store.getCamera()) : IpCamera.getInstance().lightOff(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/far_light/on/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean farLightOn(@PathVariable("id") Long id) throws Throwable {
/* 137 */     Store store = (Store)this.storeRepo.findOne(id);
/* 138 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().lightOn(store.getCamera()) : IpCamera.getInstance().farLightOn(store.getCamera());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/sdk/far_light/off/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public boolean farLightOff(@PathVariable("id") Long id) throws Throwable {
/* 143 */     Store store = (Store)this.storeRepo.findOne(id);
/* 144 */     return store.getCamera().getManufacturer().getCodeId().equals(Integer.valueOf(2)) ? HkCamera.getInstance().lightOff(store.getCamera()) : IpCamera.getInstance().farLightOff(store.getCamera());
/*     */   }
/*     */   
///*     */   @RequestMapping(value={"/sdk/kd/{id}/{action}/{speed}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
///*     */   public ResponseEntity<Boolean> kdSdk(@PathVariable("id") Long id, @PathVariable("action") String action, @PathVariable("speed") Integer speed) throws Throwable {
///* 149 */     return delegateKdSdkCall(id, action, speed);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/sdk/kd/{id}/{action}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
///*     */   public ResponseEntity<Boolean> kdSdk(@PathVariable("id") Long id, @PathVariable("action") String action) throws Throwable {
///* 154 */     return delegateKdSdkCall(id, action, null);
///*     */   }
/*     */   
/*     */   @RequestMapping(value={"/scale/restart"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void scaleRestart() throws Exception {
/* 159 */     this._gHandler.initScale();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/led/restart"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void ledRestart() throws Exception {
/* 164 */     this._gHandler.initLed();
/*     */   }
/*     */   
///*     */   @RequestMapping(value={"/snapshot/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
///*     */   public void snapshot(@PathVariable("id") Long id) throws Exception {
///* 169 */     DjhuaCamera.getInstance().snap(id);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/strobe_up/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
///*     */   public void strobeUp(@PathVariable("id") Long id) throws Exception {
///* 174 */     DjhuaCamera.getInstance().up(id, "豫A00001");
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/strobe_down/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
///*     */   public void strobeDown(@PathVariable("id") Long id) throws Exception {
///* 179 */     DjhuaCamera.getInstance().down(id);
///*     */   }
///*     */   
///*     */   @RequestMapping(value={"/led/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
///*     */   public void led(@PathVariable("id") Long id) throws Exception {
///* 184 */     LEDUtil.sendLED((GrainTraffic)this.gtRepo.findOne(id));
///*     */   }
/*     */   
/*     */   @RequestMapping(value={"/led/on"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void ledOn()
/*     */     throws Exception
/*     */   {}
/*     */   
/*     */   @RequestMapping(value={"/led/off"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void ledOff() throws Exception
/*     */   {}
/*     */   
/*     */   @RequestMapping(value={"/sms/send/{number}/{content}"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void smsSend(@PathVariable String number, @PathVariable String content) throws Exception
/*     */   {
/* 199 */     SMSUtil.sendMessage(number, content);
/*     */   }
/*     */   
///*     */   private ResponseEntity<Boolean> delegateKdSdkCall(Long id, String action, Integer speed) throws Throwable
///*     */   {
///* 204 */     DeviceCamera camera = (DeviceCamera)this.cameraRepo.findOne(id);
///* 205 */     if (camera != null) {
///* 206 */       boolean result = false;
///* 207 */       String str; switch ((str = action).hashCode()) {case -696286120:  if (str.equals("zoomIn")) {} break; case -110027141:  if (str.equals("zoomOut")) {} break; case -104437901:  if (str.equals("moveStop")) {} break; case 3739:  if (str.equals("up")) break; break; case 3089570:  if (str.equals("down")) {} break; case 3317767:  if (str.equals("left")) {} break; case 108404047:  if (str.equals("reset")) {} break; case 108511772:  if (str.equals("right")) {} break; case 884244085:  if (!str.equals("zoomStop")) {
///*     */           break label355;
///* 209 */           KdCamera.getInstance().up(camera, speed);
///*     */           
///*     */           break label368;
///* 212 */           KdCamera.getInstance().up(camera, speed);
///*     */           
///*     */           break label368;
///* 215 */           KdCamera.getInstance().up(camera, speed);
///*     */           
///*     */           break label368;
///* 218 */           KdCamera.getInstance().up(camera, speed);
///*     */           
///*     */           break label368;
///* 221 */           KdCamera.getInstance().moveReset(camera, speed);
///*     */           
///*     */           break label368;
///* 224 */           KdCamera.getInstance().moveStop(camera, speed);
///*     */           break label368;
///*     */         } else {
///* 227 */           KdCamera.getInstance().zoomStop(camera, speed);
///*     */           
///*     */           break label368;
///* 230 */           KdCamera.getInstance().zoomIn(camera, speed);
///*     */           
///*     */           break label368;
///* 233 */           KdCamera.getInstance().zoomOut(camera, speed); }
///* 234 */         break; }
///*     */       label355:
///* 236 */       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
///*     */       label368:
///* 238 */       return new ResponseEntity(Boolean.valueOf(result), HttpStatus.OK);
///*     */     }
///* 240 */     return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
///*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\SdkController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */