/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.Compartment;
/*     */ import com.haut.grm.model.Depot;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.type.AnalysisLevel;
/*     */ import com.haut.grm.model.type.AnalysisType;
/*     */ import com.haut.grm.model.type.GrainType;
/*     */ import com.haut.grm.model.type.PackageCategory;
/*     */ import com.haut.grm.model.type.PackageType;
/*     */ import com.querydsl.core.annotations.QueryInit;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
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
/*     */ @Entity
/*     */ @Table(name="gb_stock_agg")
/*     */ public class StockAgg
/*     */   extends AbstractEntity<String>
/*     */ {
/*     */   private static final long serialVersionUID = -9013877725408465587L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="stock_id")
/*     */   private StockId stock;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="cargo_id")
/*     */   @QueryInit({"compartment.store.depot.*"})
/*     */   private Cargo cargo;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="compartment_id")
/*     */   private Compartment compartment;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="store_id")
/*     */   private Store store;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="depot_id")
/*     */   private Depot depot;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_type_id")
/*     */   private GrainType grainType;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_variety_id")
/*     */   private GrainVariety grainVariety;
/*     */   @Column(name="year")
/*     */   private String year;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_type_id")
/*     */   private PackageType packageType;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_category_id")
/*     */   private PackageCategory packageCategory;
/*     */   @Column(name="location")
/*     */   private String location;
/*     */   @Column(name="business_key")
/*     */   protected String businessKey;
/*     */   @Column(name="input_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date inputTime;
/*     */   @Column(name="in_finished")
/*  86 */   private Boolean inFinished = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="out_finished")
/*  89 */   private Boolean outFinished = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="in_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date inTime;
/*     */   
/*     */   @Column(name="out_time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date outTime;
/*     */   
/*     */   @Column(name="amount")
/*     */   private Long amount;
/*     */   
/*     */   @Column(name="in_amount")
/*     */   private Long inAmount;
/*     */   
/*     */   @Column(name="out_amount")
/*     */   private Long outAmount;
/*     */   
/*     */   @Column(name="_unit_weight")
/*     */   private Double unitWeight;
/*     */   
/*     */   @Column(name="_deduct_volume")
/*     */   private Double deductVolume;
/*     */   
/*     */   @Column(name="_factor")
/*     */   private Double factor;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_level_id")
/*     */   private AnalysisLevel analysisLevel;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_type_id")
/*     */   private AnalysisType analysisType;
/*     */   
/*     */   @Column(name="a1")
/*     */   private Double a1;
/*     */   
/*     */   @Column(name="a2")
/*     */   private Double a2;
/*     */   
/*     */   @Column(name="a3")
/*     */   private Double a3;
/*     */   
/*     */   @Column(name="a4")
/*     */   private Double a4;
/*     */   
/*     */   @Column(name="a5")
/*     */   private Double a5;
/*     */   
/*     */   @Column(name="a6")
/*     */   private Double a6;
/*     */   
/*     */   @Column(name="a7")
/*     */   private Double a7;
/*     */   
/*     */   @Column(name="a8")
/*     */   private Double a8;
/*     */   
/*     */   @Column(name="a9")
/*     */   private Double a9;
/*     */   
/*     */   @Column(name="a10")
/*     */   private Double a10;
/*     */   
/*     */   @Column(name="a11")
/*     */   private Double a11;
/*     */   
/*     */   @Column(name="a12")
/*     */   private Double a12;
/*     */   
/*     */   @Column(name="a13")
/*     */   private Integer a13;
/*     */   
/*     */   @Column(name="a14")
/*     */   private Double a14;
/*     */   
/*     */   @Column(name="a15")
/*     */   private Double a15;
/*     */   
/*     */   @Column(name="s1")
/*     */   private String s1;
/*     */   
/*     */   @Column(name="s2")
/*     */   private String s2;
/*     */   
/*     */   @Column(name="s3")
/*     */   private String s3;
/*     */   
/*     */   @Column(name="s4")
/*     */   private String s4;
/*     */   
/*     */   @Column(name="s5")
/*     */   private String s5;
/*     */   @Column(name="time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date time;
/*     */   
/*     */   public PackageCategory getPackageCategory()
/*     */   {
/* 190 */     return this.packageCategory;
/*     */   }
/*     */   
/*     */   public void setPackageCategory(PackageCategory packageCategory) {
/* 194 */     this.packageCategory = packageCategory;
/*     */   }
/*     */   
/*     */   public StockId getStock() {
/* 198 */     return this.stock;
/*     */   }
/*     */   
/*     */   public void setStock(StockId stock) {
/* 202 */     this.stock = stock;
/*     */   }
/*     */   
/*     */   public Cargo getCargo() {
/* 206 */     return this.cargo;
/*     */   }
/*     */   
/*     */   public void setCargo(Cargo cargo) {
/* 210 */     this.cargo = cargo;
/*     */   }
/*     */   
/*     */   public GrainType getGrainType() {
/* 214 */     return this.grainType;
/*     */   }
/*     */   
/*     */   public void setGrainType(GrainType grainType) {
/* 218 */     this.grainType = grainType;
/*     */   }
/*     */   
/*     */   public GrainVariety getGrainVariety() {
/* 222 */     return this.grainVariety;
/*     */   }
/*     */   
/*     */   public void setGrainVariety(GrainVariety grainVariety) {
/* 226 */     this.grainVariety = grainVariety;
/*     */   }
/*     */   
/*     */   public String getYear() {
/* 230 */     return this.year;
/*     */   }
/*     */   
/*     */   public void setYear(String year) {
/* 234 */     this.year = year;
/*     */   }
/*     */   
/*     */   public PackageType getPackageType() {
/* 238 */     return this.packageType;
/*     */   }
/*     */   
/*     */   public void setPackageType(PackageType packageType) {
/* 242 */     this.packageType = packageType;
/*     */   }
/*     */   
/*     */   public String getLocation() {
/* 246 */     return this.location;
/*     */   }
/*     */   
/*     */   public void setLocation(String location) {
/* 250 */     this.location = location;
/*     */   }
/*     */   
/*     */   public String getBusinessKey() {
/* 254 */     return this.businessKey;
/*     */   }
/*     */   
/*     */   public void setBusinessKey(String businessKey) {
/* 258 */     this.businessKey = businessKey;
/*     */   }
/*     */   
/*     */   public Date getInputTime() {
/* 262 */     return this.inputTime;
/*     */   }
/*     */   
/*     */   public void setInputTime(Date inputTime) {
/* 266 */     this.inputTime = inputTime;
/*     */   }
/*     */   
/*     */   public Boolean getInFinished() {
/* 270 */     return this.inFinished;
/*     */   }
/*     */   
/*     */   public void setInFinished(Boolean inFinished) {
/* 274 */     this.inFinished = inFinished;
/*     */   }
/*     */   
/*     */   public Boolean getOutFinished() {
/* 278 */     return this.outFinished;
/*     */   }
/*     */   
/*     */   public void setOutFinished(Boolean outFinished) {
/* 282 */     this.outFinished = outFinished;
/*     */   }
/*     */   
/*     */   public Date getInTime() {
/* 286 */     return this.inTime;
/*     */   }
/*     */   
/*     */   public void setInTime(Date inTime) {
/* 290 */     this.inTime = inTime;
/*     */   }
/*     */   
/*     */   public Date getOutTime() {
/* 294 */     return this.outTime;
/*     */   }
/*     */   
/*     */   public void setOutTime(Date outTime) {
/* 298 */     this.outTime = outTime;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/* 302 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/* 306 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Long getInAmount() {
/* 310 */     return this.inAmount;
/*     */   }
/*     */   
/*     */   public void setInAmount(Long inAmount) {
/* 314 */     this.inAmount = inAmount;
/*     */   }
/*     */   
/*     */   public Long getOutAmount() {
/* 318 */     return this.outAmount;
/*     */   }
/*     */   
/*     */   public void setOutAmount(Long outAmount) {
/* 322 */     this.outAmount = outAmount;
/*     */   }
/*     */   
/*     */   public AnalysisLevel getAnalysisLevel() {
/* 326 */     return this.analysisLevel;
/*     */   }
/*     */   
/*     */   public void setAnalysisLevel(AnalysisLevel analysisLevel) {
/* 330 */     this.analysisLevel = analysisLevel;
/*     */   }
/*     */   
/*     */   public AnalysisType getAnalysisType() {
/* 334 */     return this.analysisType;
/*     */   }
/*     */   
/*     */   public void setAnalysisType(AnalysisType analysisType) {
/* 338 */     this.analysisType = analysisType;
/*     */   }
/*     */   
/*     */   public Double getA1() {
/* 342 */     return this.a1;
/*     */   }
/*     */   
/*     */   public void setA1(Double a1) {
/* 346 */     this.a1 = a1;
/*     */   }
/*     */   
/*     */   public Double getA2() {
/* 350 */     return this.a2;
/*     */   }
/*     */   
/*     */   public void setA2(Double a2) {
/* 354 */     this.a2 = a2;
/*     */   }
/*     */   
/*     */   public Double getA3() {
/* 358 */     return this.a3;
/*     */   }
/*     */   
/*     */   public void setA3(Double a3) {
/* 362 */     this.a3 = a3;
/*     */   }
/*     */   
/*     */   public Double getA4() {
/* 366 */     return this.a4;
/*     */   }
/*     */   
/*     */   public void setA4(Double a4) {
/* 370 */     this.a4 = a4;
/*     */   }
/*     */   
/*     */   public Double getA5() {
/* 374 */     return this.a5;
/*     */   }
/*     */   
/*     */   public void setA5(Double a5) {
/* 378 */     this.a5 = a5;
/*     */   }
/*     */   
/*     */   public Double getA6() {
/* 382 */     return this.a6;
/*     */   }
/*     */   
/*     */   public void setA6(Double a6) {
/* 386 */     this.a6 = a6;
/*     */   }
/*     */   
/*     */   public Double getA7() {
/* 390 */     return this.a7;
/*     */   }
/*     */   
/*     */   public void setA7(Double a7) {
/* 394 */     this.a7 = a7;
/*     */   }
/*     */   
/*     */   public Double getA8() {
/* 398 */     return this.a8;
/*     */   }
/*     */   
/*     */   public void setA8(Double a8) {
/* 402 */     this.a8 = a8;
/*     */   }
/*     */   
/*     */   public Double getA9() {
/* 406 */     return this.a9;
/*     */   }
/*     */   
/*     */   public void setA9(Double a9) {
/* 410 */     this.a9 = a9;
/*     */   }
/*     */   
/*     */   public Double getA10() {
/* 414 */     return this.a10;
/*     */   }
/*     */   
/*     */   public void setA10(Double a10) {
/* 418 */     this.a10 = a10;
/*     */   }
/*     */   
/*     */   public String getS1() {
/* 422 */     return this.s1;
/*     */   }
/*     */   
/*     */   public void setS1(String s1) {
/* 426 */     this.s1 = s1;
/*     */   }
/*     */   
/*     */   public String getS2() {
/* 430 */     return this.s2;
/*     */   }
/*     */   
/*     */   public void setS2(String s2) {
/* 434 */     this.s2 = s2;
/*     */   }
/*     */   
/*     */   public String getS3() {
/* 438 */     return this.s3;
/*     */   }
/*     */   
/*     */   public void setS3(String s3) {
/* 442 */     this.s3 = s3;
/*     */   }
/*     */   
/*     */   public String getS4() {
/* 446 */     return this.s4;
/*     */   }
/*     */   
/*     */   public void setS4(String s4) {
/* 450 */     this.s4 = s4;
/*     */   }
/*     */   
/*     */   public String getS5() {
/* 454 */     return this.s5;
/*     */   }
/*     */   
/*     */   public void setS5(String s5) {
/* 458 */     this.s5 = s5;
/*     */   }
/*     */   
/*     */   public Date getTime() {
/* 462 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Date time) {
/* 466 */     this.time = time;
/*     */   }
/*     */   
/*     */   public Compartment getCompartment() {
/* 470 */     return this.compartment;
/*     */   }
/*     */   
/*     */   public void setCompartment(Compartment compartment) {
/* 474 */     this.compartment = compartment;
/*     */   }
/*     */   
/*     */   public Store getStore() {
/* 478 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/* 482 */     this.store = store;
/*     */   }
/*     */   
/*     */   public Depot getDepot() {
/* 486 */     return this.depot;
/*     */   }
/*     */   
/*     */   public void setDepot(Depot depot) {
/* 490 */     this.depot = depot;
/*     */   }
/*     */   
/*     */   public Double getUnitWeight() {
/* 494 */     return this.unitWeight;
/*     */   }
/*     */   
/*     */   public void setUnitWeight(Double unitWeight) {
/* 498 */     this.unitWeight = unitWeight;
/*     */   }
/*     */   
/*     */   public Double getDeductVolume() {
/* 502 */     return this.deductVolume;
/*     */   }
/*     */   
/*     */   public void setDeductVolume(Double deductVolume) {
/* 506 */     this.deductVolume = deductVolume;
/*     */   }
/*     */   
/*     */   public Double getFactor() {
/* 510 */     return this.factor;
/*     */   }
/*     */   
/*     */   public void setFactor(Double factor) {
/* 514 */     this.factor = factor;
/*     */   }
/*     */   
/*     */   public Double getA11() {
/* 518 */     return this.a11;
/*     */   }
/*     */   
/*     */   public void setA11(Double a11) {
/* 522 */     this.a11 = a11;
/*     */   }
/*     */   
/*     */   public Double getA12() {
/* 526 */     return this.a12;
/*     */   }
/*     */   
/*     */   public void setA12(Double a12) {
/* 530 */     this.a12 = a12;
/*     */   }
/*     */   
/*     */   public Integer getA13() {
/* 534 */     return this.a13;
/*     */   }
/*     */   
/*     */   public void setA13(Integer a13) {
/* 538 */     this.a13 = a13;
/*     */   }
/*     */   
/*     */   public Double getA14() {
/* 542 */     return this.a14;
/*     */   }
/*     */   
/*     */   public void setA14(Double a14) {
/* 546 */     this.a14 = a14;
/*     */   }
/*     */   
/*     */   public Double getA15() {
/* 550 */     return this.a15;
/*     */   }
/*     */   
/*     */   public void setA15(Double a15) {
/* 554 */     this.a15 = a15;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockAgg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */