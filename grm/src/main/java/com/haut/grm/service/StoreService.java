/*     */ package com.haut.grm.service;
/*     */ 
/*     */ import com.haut.grm.model.Door;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreConfig;
/*     */ import com.haut.grm.model.StoreStatus;
/*     */ import com.haut.grm.model.dto.StorePositionDto;
/*     */ import com.haut.grm.model.meta.StoreModel;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.meta.StoreModelRepository;
/*     */ import java.util.List;
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
/*     */ @Service
/*     */ public class StoreService
/*     */ {
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private StoreModelRepository storeModelRepo;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   
/*     */   public List<Store> getAllStores()
/*     */   {
/*  37 */     return this.storeRepo.findAll();
/*     */   }
/*     */   
/*     */   public List<Store> getAllCenterStores() {
/*  41 */     return this.storeRepo.findByDepot_Id(new Long(1L));
/*     */   }


public List<Store> getStoresByDepotId(Long depotId) {
	return this.storeRepo.findByDepot_Id(depotId);
}


/*     */   
/*     */   public List<Store> getAllStoresWithDoor() {
/*  45 */     return this.storeRepo.getDistinctByIdNotNullOrderByCodeIdAsc();
/*     */   }
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
/*     */   public Store storeSetMeasureOngoing(Store store, boolean ongoing)
/*     */   {
/*  68 */     if (store.getId() != null) {
/*  69 */       Store _store = (Store)this.storeRepo.findOne((Long)store.getId());
/*  70 */       _store.getStatus().setIsMeasureOngoing(Boolean.valueOf(ongoing));
/*  71 */       store = (Store)this.storeRepo.save(_store);
/*     */     }
/*  73 */     return store;
/*     */   }
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
/*     */   public Integer getStoreNextAssignableCodeId(Store store)
/*     */   {
/*  99 */     for (int i = 1; i <= Integer.valueOf(this.commonService.getSystemVariableWithKey("MAX_POSITION_ID")).intValue(); i++) {
/* 100 */       boolean match = false;
/* 101 */       for (Door d : store.getDoors()) {
/* 102 */         if ((d.getCodeId() != null) && 
/* 103 */           (i == d.getCodeId().intValue()))
/* 104 */           match = true;
/*     */       }
/* 106 */       if (!match) {
/* 107 */         return Integer.valueOf(i);
/*     */       }
/*     */     }
/* 110 */     return Integer.valueOf(0);
/*     */   }
/*     */   
/*     */   public void updatePosition(List<StorePositionDto> positionData) {
/* 114 */     for (StorePositionDto position : positionData) {
/* 115 */       if (position.getType().equals("connector")) {
/* 116 */         StoreModel model = (StoreModel)this.storeModelRepo.findOne(position.getRef());
/* 117 */         model.setTargetX(position.getX());
/* 118 */         model.setTargetY(position.getY());
/* 119 */         this.storeModelRepo.save(model);
/*     */       }
/* 121 */       if (position.getType().equals("target")) {
/* 122 */         Store store = (Store)this.storeRepo.findOne(position.getRef());
/* 123 */         StorePositionDto positionSource = null;
/* 124 */         for (StorePositionDto _positionSource : positionData) {
/* 125 */           if ((_positionSource.getRef().equals(store.getId())) && 
/* 126 */             (_positionSource.getType().equals("source")))
/* 127 */             positionSource = _positionSource;
/*     */         }
/* 129 */         if (positionSource == null)
/* 130 */           throw new RuntimeException();
/* 131 */         store.getConfig().setSourcePositionX(positionSource.getX());
/* 132 */         store.getConfig().setSourcePositionY(positionSource.getY());
/* 133 */         store.getConfig().setTargetPositionX(position.getX());
/* 134 */         store.getConfig().setTargetPositionY(position.getY());
/* 135 */         this.storeRepo.save(store);
/*     */       }
/*     */     }
/* 138 */     this.commonService.createUpdateLog("修改粮仓鸟瞰图坐标");
/*     */   }
/*     */   
/*     */   public List<Store> getStoresByIsMeasureOngoing(boolean isMeasureOngoing) {
/* 142 */     return this.storeRepo.findByStatus_IsMeasureOngoing(isMeasureOngoing);
/*     */   }

			

			public void saveStore(Store st) {
				storeRepo.save(st);
			}


/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\StoreService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */