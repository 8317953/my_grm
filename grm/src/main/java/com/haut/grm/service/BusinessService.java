/*     */ package com.haut.grm.service;
/*     */ 
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.Compartment;
/*     */ import com.haut.grm.model.Depot;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.StoreStatus;
/*     */ import com.haut.grm.model.business.BusinessData;
/*     */ import com.haut.grm.model.business.StockChange;
/*     */ import com.haut.grm.model.business.StockId;
/*     */ import com.haut.grm.model.business.StockSum;
/*     */ import com.haut.grm.model.type.CargoStatus;
/*     */ import com.haut.grm.model.type.DepotCategory;
/*     */ import com.haut.grm.model.type.SourceType;
/*     */ import com.haut.grm.model.type.SpaceStatus;
/*     */ import com.haut.grm.repository.CargoRepository;
/*     */ import com.haut.grm.repository.StoreRepository;
/*     */ import com.haut.grm.repository.base.BusinessDataRepository;
/*     */ import com.haut.grm.repository.business.StockChangeRepository;
/*     */ import com.haut.grm.repository.business.StockIdRepository;
/*     */ import com.haut.grm.repository.business.StockSumRepository;
/*     */ import com.haut.grm.repository.ies.GrainTrafficRepository;
/*     */ import com.haut.grm.repository.type.CargoStatusRepository;
/*     */ import com.haut.grm.repository.type.SourceTypeRepository;
/*     */ import com.haut.grm.repository.type.SpaceStatusRepository;
/*     */ import com.haut.grm.util.OfficialIdUtil;
/*     */ import java.util.Date;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class BusinessService
/*     */ {
/*     */   @Autowired
/*     */   private BusinessDataRepository bdRepo;
/*     */   @Autowired
/*     */   private StockIdRepository siRepo;
/*     */   @Autowired
/*     */   private StockSumRepository ssRepo;
/*     */   @Autowired
/*     */   private GrainTrafficRepository gtRepo;
/*     */   @Autowired
/*     */   private StockChangeRepository scRepo;
/*     */   @Autowired
/*     */   private SourceTypeRepository stRepo;
/*     */   @Autowired
/*     */   private CargoStatusRepository csRepo;
/*     */   @Autowired
/*     */   private CargoRepository cRepo;
/*     */   @Autowired
/*     */   private StoreRepository storeRepo;
/*     */   @Autowired
/*     */   private SpaceStatusRepository spsRepo;
/*     */   
/*     */   public String getBusinessKeyForPattern(String formatter)
/*     */   {
/*  60 */     return OfficialIdUtil.generateBusinessKey(this.bdRepo, formatter);
/*     */   }
/*     */   
/*     */   public String getBusinessKeyForPattern(String formatter, Date time) {
/*  64 */     return OfficialIdUtil.generateBusinessKey(this.bdRepo, formatter, time);
/*     */   }
/*     */   
/*     */   public String getBusinessKeyForSc(String formatter, Date time) {
/*  68 */     return OfficialIdUtil.generateStockChangeOId(this.bdRepo, this.gtRepo, this.scRepo, formatter, time);
/*     */   }
/*     */   
/*     */   public String getBusinessKeyForSc(String formatter) {
/*  72 */     return OfficialIdUtil.generateStockChangeOId(this.bdRepo, this.gtRepo, this.scRepo, formatter);
/*     */   }
/*     */   
/*     */   public void stockInFinish(Long id, Date inTime) {
/*  76 */     StockId stock = (StockId)this.siRepo.findOne(id);
/*  77 */     stock.setInTime(inTime);
/*  78 */     stock.setInFinished(Boolean.valueOf(true));
/*  79 */     Cargo c = stock.getCargo();
/*  80 */     c.setStatus((CargoStatus)this.csRepo.findByCodeId(Integer.valueOf(3)));
/*  81 */     Store store = c.getCompartment().getStore();
/*  82 */     if (this.cRepo.countByCompartment_Store_Id(((Long)store.getId()).longValue()) == 1L) {
/*  83 */       store.getStatus().setStatus((SpaceStatus)this.spsRepo.findByCodeId(Integer.valueOf(3)));
/*  84 */       this.storeRepo.save(store);
/*     */     }
/*  86 */     this.cRepo.save(c);
/*  87 */     this.siRepo.save(stock);
/*     */   }
/*     */   
/*     */   public void stockOutFinish(Long id, Date outTime, boolean generate) {
/*  91 */     StockId stock = (StockId)this.siRepo.findOne(id);
/*  92 */     StockSum ss = (StockSum)this.ssRepo.findOne(id);
/*  93 */     stock.setOutTime(outTime);
/*  94 */     stock.setOutFinished(Boolean.valueOf(true));
/*  95 */     Cargo c = stock.getCargo();
/*  96 */     c.setStatus((CargoStatus)this.csRepo.findByCodeId(Integer.valueOf(5)));
/*  97 */     Store store = c.getCompartment().getStore();
/*  98 */     if (generate) {
/*  99 */       StockChange sc = new StockChange();
/* 100 */       Long amount = Long.valueOf(ss.getAmount().longValue() + ss.getInAmount().longValue() - ss.getOutAmount().longValue());
/* 101 */       sc.setAmount(Long.valueOf(Math.abs(amount.longValue())));
/* 102 */       String prefix = amount.longValue() > 0L ? "亏%Y%M%D%04d" : "盈%Y%M%D%04d";
/* 103 */       sc.setBusinessKey(getBusinessKeyForPattern(prefix, outTime));
/* 104 */       sc.setType((SourceType)this.stRepo.findByCodeId(Integer.valueOf(amount.longValue() > 0L ? 5 : 4)));
/* 105 */       sc.setInputTime(outTime);
/* 106 */       if (amount.longValue() > 0L) {
/* 107 */         sc.setSourceStock(stock);
/*     */       } else
/* 109 */         sc.setTargetStock(stock);
/* 110 */       if (stock.getCargo().getCompartment().getStore().getDepot().getDepotCategory().getCodeId().intValue() <= 2)
/* 111 */         this.scRepo.save(sc);
/* 112 */       BusinessData bd = new BusinessData();
/* 113 */       bd.setBusinessKey(sc.getBusinessKey());
/* 114 */       this.bdRepo.save(bd);
/*     */     }
/* 116 */     if (this.cRepo.countByCompartment_Store_Id(((Long)store.getId()).longValue()) == 1L) {
/* 117 */       store.getStatus().setStatus((SpaceStatus)this.spsRepo.findByCodeId(Integer.valueOf(1)));
/* 118 */       this.storeRepo.save(store);
/*     */     }
/* 120 */     this.cRepo.save(c);
/* 121 */     this.siRepo.save(stock);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\BusinessService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */