/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.bean.RolerController;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.StoreView;
/*     */ import com.haut.grm.json.view.Views.StoreWithDoorsView;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreConfig;
/*     */ import com.haut.grm.model.StoreStatus;
/*     */ import com.haut.grm.model.dto.StorePositionDto;
import com.haut.grm.model.ies.VehicleTraffic;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.service.MeasureTaskService;
/*     */ import com.haut.grm.service.StoreService;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ 
/*     */ 
/*     */ @RestController
/*     */ public class StoreController
/*     */ {
/*     */   @Autowired
/*     */   private StoreService storeService;
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   @Autowired
/*     */   private MeasureTaskService measureTaskExecutor;
/*     */   
/*     */   @RequestMapping(value={"/retrieve/stores"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.StoreView.class})
/*     */   public List<Store> getAllStores()
/*     */   {
/*  39 */     return this.storeService.getAllStores();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/stores/is_measure_ongoing/{is_measure_ongoing}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.StoreView.class})
/*     */   public List<Store> getAllStoresIsMeasureOngoing(@PathVariable("is_measure_ongoing") boolean isMeasureOngoing) {
/*  45 */     return this.storeService.getStoresByIsMeasureOngoing(isMeasureOngoing);
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
/*     */   @RequestMapping(value={"/retrieve/stores/with/doors"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.StoreWithDoorsView.class})
/*     */   public List<Store> getStoresWithDoorsByCode()
/*     */   {
/*  72 */     return this.storeService.getAllStoresWithDoor();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/store/position"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updatePosition(@RequestBody List<StorePositionDto> positionData) {
/*  77 */     this.storeService.updatePosition(positionData);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/start_measure/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void startMeasure(@PathVariable("id") Long id) {
/*  82 */     Store store = (Store)this.storeRepo.findOne(id);
/*  83 */     if (!store.getStatus().getIsMeasureOngoing().booleanValue())
/*  84 */       this.measureTaskExecutor.startMeasure(store, false, null, false);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/start_measure/all"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void startMeasureAll() {
/*  89 */     List<Store> stores = this.storeService.getAllCenterStores();
/*  90 */     for (Store store : stores) {
/*  91 */       if ((!store.getStatus().getIsMeasureOngoing().booleanValue()) && (!store.getConfig().getIsDemo().booleanValue()))
/*  92 */         this.measureTaskExecutor.startMeasure(store, false, null, false);
/*     */     }
/*  94 */     this.commonService.createUpdateLog("手动开启数量监测（快速全部）");
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/start_measure/all/full"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void startMeasureAllFull() {
/*  99 */     List<Store> stores = this.storeService.getAllCenterStores();
/* 100 */     for (Store store : stores) {
/* 101 */       if ((!store.getStatus().getIsMeasureOngoing().booleanValue()) && (!store.getConfig().getIsDemo().booleanValue()))
/* 102 */         this.measureTaskExecutor.startMeasure(store, true, null, false);
/*     */     }
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/start_measure/store/{id}/full"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void startMeasureFull(@PathVariable("id") Long id) {
/* 108 */     Store store = (Store)this.storeRepo.findOne(id);
/* 109 */     if (!store.getStatus().getIsMeasureOngoing().booleanValue())
/* 110 */       this.measureTaskExecutor.startMeasure(store, true, null, false);
/* 111 */     this.commonService.createUpdateLog("粮仓[" + store.getName() + "]手动开启数量监测（快速）");
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/stop_measure/manual"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void stopMeasures() {
/* 116 */     this.measureTaskExecutor.stopAllThreads();
/* 117 */     for (Store s : this.storeService.getAllCenterStores()) {
/* 118 */       this.storeService.storeSetMeasureOngoing(s, false);
/*     */     }
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/stop_measure/store/{id}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void stopMeasure(@PathVariable("id") Long id) {
/* 124 */     this.measureTaskExecutor.stopMeasure((Store)this.storeRepo.findOne(id));
/*     */   }





	@RequestMapping(value={"/myedit/store"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
	public void editStore(@RequestBody Store store) {
		System.out.println(store.getId()+","+store.getConfig().getId()+","+store.getStatus().getId()+","+store.getCamera().getId()+","+store.getConfig().getTempLayer()+","+store.getConfig().getTempWidth()+","+store.getConfig().getTempBreadth());
		if(store.getId()!=null&&store.getConfig().getId()!=null&&store.getStatus().getId()!=null) {
			storeService.saveStore(store);
		}
	}
	
	
	@RolerController(getRoles = { "1111","22222","23123" },onlyLoginCanAccess=false)
	@RequestMapping(value={"/get/stores/by/depotid/{depotId}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
//	@JsonView({Views.StoreView.class})
	public List<Store> getStoresByDepotId(@PathVariable("depotId") Long depotId){
		System.out.println("jkasd");
		return storeService.getStoresByDepotId(depotId);
	}









/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\StoreController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */