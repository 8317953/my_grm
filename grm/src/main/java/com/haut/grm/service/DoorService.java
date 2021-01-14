/*    */ package com.haut.grm.service;
/*    */ 
/*    */ import com.haut.grm.model.Door;
/*    */ import com.haut.grm.model.Store;
/*    */ import com.haut.grm.repository.DoorRepository;
/*    */ import com.haut.grm.repository.StoreRepository;
/*    */ import com.haut.grm.sdk.IpCamera;
/*    */ import com.haut.grm.sdk.SdkContext;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class DoorService
/*    */ {
/*    */   @Autowired
/*    */   private StoreRepository storeRepo;
/*    */   @Autowired
/*    */   private DoorRepository doorRepo;
/*    */   @Autowired
/*    */   private CommonService commonService;
/*    */   
/*    */   public Door updateDoor(Door door)
/*    */   {
/* 26 */     this.commonService.createUpdateLog("修改仓门 [" + door.getId() + "]信息");
/* 27 */     return (Door)this.doorRepo.save(door);
/*    */   }
/*    */   
/*    */   public Door getDoorById(Long id) {
/* 31 */     return (Door)this.doorRepo.findOne(id);
/*    */   }
/*    */   
/*    */   public void deleteDoor(Door door) {
/* 35 */     this.commonService.createDeleteLog("删除仓门 [" + door.getId() + "]");
/* 36 */     this.doorRepo.delete(door);
/*    */   }
/*    */   
/*    */   public Door createDoorByStoreCodeId(Door door, Long id) {
/* 40 */     Store store = (Store)this.storeRepo.findOne(id);
/* 41 */     door.setStore(store);
/* 42 */     this.commonService.createCreateLog("创建仓门 [" + door.getName() + "]-[" + store.getName() + "]");
/* 43 */     return (Door)this.doorRepo.save(door);
/*    */   }
/*    */   
/*    */   public Door getDoorByStoreIdAndCodeId(Long id, Integer doorId) {
/* 47 */     return this.doorRepo.findByStore_IdAndCodeId(id, doorId);
/*    */   }
/*    */   
/*    */   public boolean setDoorPosition(Door door) throws Throwable {
/* 51 */     SdkContext context = IpCamera.getInstance().getContext(door.getStore().getCamera());
/* 52 */     return IpCamera.getInstance().setPreset(context, door.getCodeId().intValue());
/*    */   }
/*    */   
/*    */   public void deleteDoorPosition(Door door) throws Throwable {
/* 56 */     SdkContext context = IpCamera.getInstance().getContext(door.getStore().getCamera());
/* 57 */     IpCamera.getInstance().deletePreset(context, door.getCodeId().intValue());
/*    */   }
/*    */   
/*    */   public void turnToDoor(Door door) throws Throwable {
/* 61 */     SdkContext context = IpCamera.getInstance().getContext(door.getStore().getCamera());
/* 62 */     IpCamera.getInstance().turnToPreset(context, door.getCodeId().intValue());
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\DoorService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */