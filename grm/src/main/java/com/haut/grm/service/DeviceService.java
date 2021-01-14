/*    */ package com.haut.grm.service;
/*    */ 
/*    */ import com.haut.grm.model.DeviceCamera;
/*    */ import com.haut.grm.model.DeviceGsmModem;
/*    */ import com.haut.grm.model.Store;
/*    */ import com.haut.grm.model.dto.StorePositionDto;
/*    */ import com.haut.grm.model.meta.SmsTemplate;
/*    */ import com.haut.grm.repository.DeviceCameraRepository;
/*    */ import com.haut.grm.repository.DeviceGsmModemRepository;
/*    */ import com.haut.grm.repository.meta.SmsTemplateRepository;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class DeviceService
/*    */ {
/*    */   @Autowired
/*    */   private DeviceGsmModemRepository gsmModemRepo;
/*    */   @Autowired
/*    */   private SmsTemplateRepository messageRepo;
/*    */   @Autowired
/*    */   private DeviceCameraRepository cameraRepo;
/*    */   @Autowired
/*    */   private CommonService commonService;
/*    */   
/*    */   public DeviceGsmModem getDeviceGsmModem()
/*    */   {
/* 33 */     return (DeviceGsmModem)this.gsmModemRepo.findOne(Long.valueOf(1L));
/*    */   }
/*    */   
/*    */   public DeviceGsmModem updateDeviceGsmModem(DeviceGsmModem gsmModem) {
/* 37 */     this.commonService.createUpdateLog("修改短信猫信息");
/* 38 */     return (DeviceGsmModem)this.gsmModemRepo.save(gsmModem);
/*    */   }
/*    */   
/*    */   public SmsTemplate getAlertMessage()
/*    */   {
/* 43 */     return (SmsTemplate)this.messageRepo.findOne(Long.valueOf(1L));
/*    */   }
/*    */   
/*    */   public SmsTemplate updateAlertMessage(SmsTemplate alertMessage)
/*    */   {
/* 48 */     this.commonService.createUpdateLog("修改短信模板");
/* 49 */     return (SmsTemplate)this.messageRepo.save(alertMessage);
/*    */   }
/*    */   
/*    */   public DeviceCamera updateDeviceCamera(DeviceCamera deviceCamera)
/*    */   {
/* 54 */     if (deviceCamera.getStore() != null) {
/* 55 */       this.commonService.createUpdateLog("修改实景摄像机参数 [" + deviceCamera.getStore().getName() + "]");
/*    */     } else
/* 57 */       this.commonService.createUpdateLog("修改实景摄像机参数");
/* 58 */     return (DeviceCamera)this.cameraRepo.save(deviceCamera);
/*    */   }
/*    */   
/*    */   public DeviceCamera getCameraWithId(Long id) {
/* 62 */     return (DeviceCamera)this.cameraRepo.findOne(id);
/*    */   }
/*    */   
/*    */   public Set<DeviceCamera> getCameraWithTypeCodeId(int plateTypeCodeid) {
/* 66 */     return this.cameraRepo.findByType_CodeId(Integer.valueOf(plateTypeCodeid));
/*    */   }
/*    */   
/*    */   public void updateCameraPosition(List<StorePositionDto> positionData) {
/* 70 */     for (StorePositionDto position : positionData) {
/* 71 */       DeviceCamera camera = (DeviceCamera)this.cameraRepo.findOne(position.getRef());
/* 72 */       camera.setPositionX(position.getX());
/* 73 */       camera.setPositionY(position.getY());
/* 74 */       this.cameraRepo.save(camera);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\DeviceService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */