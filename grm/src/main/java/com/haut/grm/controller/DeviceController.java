/*    */ package com.haut.grm.controller;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.AlertMessageView;
/*    */ import com.haut.grm.json.view.Views.SmsTemplateView;
/*    */ import com.haut.grm.model.DeviceCamera;
/*    */ import com.haut.grm.model.DeviceGsmModem;
/*    */ import com.haut.grm.model.dto.StorePositionDto;
/*    */ import com.haut.grm.model.meta.SmsTemplate;
/*    */ import com.haut.grm.service.DeviceService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.web.bind.annotation.RequestBody;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.RestController;
/*    */ 
/*    */ 
/*    */ @RestController
/*    */ public class DeviceController
/*    */ {
/*    */   @Autowired
/*    */   private DeviceService deviceService;
/*    */   
/*    */   @RequestMapping(value={"/retrieve/device/gsm_modem"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public DeviceGsmModem getDeviceGsmModem()
/*    */   {
/* 27 */     return this.deviceService.getDeviceGsmModem();
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/update/device/gsm_modem"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public DeviceGsmModem updateDeviceGsmModem(@RequestBody DeviceGsmModem gsmModem) {
/* 32 */     return this.deviceService.updateDeviceGsmModem(gsmModem);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/retrieve/device/gsm_modem/message"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @JsonView({Views.SmsTemplateView.class})
/*    */   public SmsTemplate getAlertMessage() {
/* 38 */     return this.deviceService.getAlertMessage();
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/update/device/gsm_modem/message"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   @JsonView({Views.AlertMessageView.class})
/*    */   public SmsTemplate updateAlertMessage(@RequestBody SmsTemplate alertMessage) {
/* 44 */     return this.deviceService.updateAlertMessage(alertMessage);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/update/device/camera"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void updateStoreCamera(@RequestBody DeviceCamera camera) {
/* 49 */     this.deviceService.updateDeviceCamera(camera);
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/update/camera/position"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*    */   public void updateCameraPosition(@RequestBody List<StorePositionDto> positionData) {
/* 54 */     this.deviceService.updateCameraPosition(positionData);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\DeviceController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */