/*      */ package com.haut.grm.model.business;
/*      */ 
/*      */ import com.haut.grm.model.CargoRepView;
/*      */ import com.haut.grm.model.base.AbstractBusiness;
/*      */ import com.haut.grm.model.standard.code.GrainVariety;
/*      */ import com.haut.grm.model.type.AnalysisLevel;
/*      */ import com.haut.grm.model.type.Country;
/*      */ import com.haut.grm.model.type.GrainType;
/*      */ import com.haut.grm.model.type.PackageCategory;
/*      */ import com.haut.grm.model.type.PackageType;
/*      */ import com.querydsl.core.annotations.QueryInit;
/*      */ import java.util.Date;
/*      */ import java.util.Set;
/*      */ import javax.persistence.Column;
/*      */ import javax.persistence.Entity;
/*      */ import javax.persistence.FetchType;
/*      */ import javax.persistence.JoinColumn;
/*      */ import javax.persistence.ManyToOne;
/*      */ import javax.persistence.OneToMany;
/*      */ import javax.persistence.Table;
/*      */ import javax.persistence.Temporal;
/*      */ import javax.persistence.TemporalType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ @Entity
/*      */ @Table(name="gb_stock_sum_history")
/*      */ public class StockSumHistory
/*      */   extends AbstractBusiness
/*      */ {
/*      */   private static final long serialVersionUID = 609837159179086688L;
/*      */   @ManyToOne
/*      */   @JoinColumn(name="cargo_id")
/*      */   @QueryInit({"compartment.store.depot.*"})
/*      */   private CargoRepView cargo;
/*      */   @Column(name="cargo_name")
/*      */   private String cargoName;
/*      */   @Column(name="cargo_name_short")
/*      */   private String cargoNameShort;
/*      */   @ManyToOne
/*      */   @JoinColumn(name="grain_type_id")
/*      */   private GrainType grainType;
/*      */   @ManyToOne
/*      */   @JoinColumn(name="grain_variety_id")
/*      */   private GrainVariety grainVariety;
/*      */   @Column(name="year")
/*      */   private String year;
/*      */   @Column(name="amount")
/*      */   private Long amount;
/*      */   @Column(name="in_amount")
/*      */   private Long inAmount;
/*      */   @Column(name="out_amount")
/*      */   private Long outAmount;
/*      */   @ManyToOne
/*      */   @JoinColumn(name="package_type_id")
/*      */   private PackageType packageType;
/*      */   @ManyToOne
/*      */   @JoinColumn(name="package_category_id")
/*      */   private PackageCategory packageCategory;
/*      */   @Column(name="location")
/*      */   private String location;
/*      */   @ManyToOne
/*      */   @JoinColumn(name="country_id")
/*      */   private Country country;
/*      */   @Column(name="in_finished")
/*   83 */   private Boolean inFinished = Boolean.valueOf(false);
/*      */   
/*      */   @Column(name="out_finished")
/*   86 */   private Boolean outFinished = Boolean.valueOf(false);
/*      */   
/*      */   @Column(name="in_time")
/*      */   @Temporal(TemporalType.TIMESTAMP)
/*      */   private Date inTime;
/*      */   
/*      */   @Column(name="out_time")
/*      */   @Temporal(TemporalType.TIMESTAMP)
/*      */   private Date outTime;
/*      */   
/*      */   @Column(name="_unit_weight")
/*      */   private Double unitWeight;
/*      */   
/*      */   @Column(name="_deduct_volume")
/*      */   private Double deductVolume;
/*      */   
/*      */   @Column(name="_factor")
/*      */   private Double factor;
/*      */   
/*      */   @OneToMany(fetch=FetchType.LAZY, mappedBy="stock", cascade={javax.persistence.CascadeType.ALL})
/*      */   private Set<StockAnalysis> stockAnalyses;
/*      */   
/*      */   @OneToMany(fetch=FetchType.LAZY, mappedBy="targetStock", cascade={javax.persistence.CascadeType.ALL})
/*      */   private Set<StockChange> positiveStockChanges;
/*      */   
/*      */   @OneToMany(fetch=FetchType.LAZY, mappedBy="sourceStock", cascade={javax.persistence.CascadeType.ALL})
/*      */   private Set<StockChange> negetiveStockChanges;
/*      */   
/*      */   @ManyToOne
/*      */   @JoinColumn(name="l_analysis_level_id")
/*      */   private AnalysisLevel l_analysisLevel;
/*      */   
/*      */   @Column(name="l_a1")
/*      */   private Double l_a1;
/*      */   
/*      */   @Column(name="l_a2")
/*      */   private Double l_a2;
/*      */   
/*      */   @Column(name="l_a3")
/*      */   private Double l_a3;
/*      */   
/*      */   @Column(name="l_a4")
/*      */   private Double l_a4;
/*      */   
/*      */   @Column(name="l_a5")
/*      */   private Double l_a5;
/*      */   
/*      */   @Column(name="l_a6")
/*      */   private Double l_a6;
/*      */   
/*      */   @Column(name="l_a7")
/*      */   private Double l_a7;
/*      */   
/*      */   @Column(name="l_a8")
/*      */   private Double l_a8;
/*      */   
/*      */   @Column(name="l_a9")
/*      */   private Double l_a9;
/*      */   
/*      */   @Column(name="l_a10")
/*      */   private Double l_a10;
/*      */   
/*      */   @Column(name="l_a11")
/*      */   private Double l_a11;
/*      */   
/*      */   @Column(name="l_a12")
/*      */   private Double l_a12;
/*      */   
/*      */   @Column(name="l_a13")
/*      */   private Integer l_a13;
/*      */   
/*      */   @Column(name="l_a14")
/*      */   private Double l_a14;
/*      */   
/*      */   @Column(name="l_a15")
/*      */   private Double l_a15;
/*      */   
/*      */   @Column(name="l_a16")
/*      */   private Integer l_a16;
/*      */   
/*      */   @Column(name="l_a17")
/*      */   private Integer l_a17;
/*      */   
/*      */   @Column(name="l_s1")
/*      */   private String l_s1;
/*      */   
/*      */   @Column(name="l_s2")
/*      */   private String l_s2;
/*      */   
/*      */   @Column(name="l_s3")
/*      */   private String l_s3;
/*      */   
/*      */   @Column(name="l_s4")
/*      */   private String l_s4;
/*      */   
/*      */   @Column(name="l_s5")
/*      */   private String l_s5;
/*      */   
/*      */   @ManyToOne
/*      */   @JoinColumn(name="o_analysis_level_id")
/*      */   private AnalysisLevel o_analysisLevel;
/*      */   
/*      */   @Column(name="o_a1")
/*      */   private Double o_a1;
/*      */   
/*      */   @Column(name="o_a2")
/*      */   private Double o_a2;
/*      */   
/*      */   @Column(name="o_a3")
/*      */   private Double o_a3;
/*      */   
/*      */   @Column(name="o_a4")
/*      */   private Double o_a4;
/*      */   
/*      */   @Column(name="o_a5")
/*      */   private Double o_a5;
/*      */   
/*      */   @Column(name="o_a6")
/*      */   private Double o_a6;
/*      */   
/*      */   @Column(name="o_a7")
/*      */   private Double o_a7;
/*      */   
/*      */   @Column(name="o_a8")
/*      */   private Double o_a8;
/*      */   
/*      */   @Column(name="o_a9")
/*      */   private Double o_a9;
/*      */   
/*      */   @Column(name="o_a10")
/*      */   private Double o_a10;
/*      */   
/*      */   @Column(name="o_a11")
/*      */   private Double o_a11;
/*      */   
/*      */   @Column(name="o_a12")
/*      */   private Double o_a12;
/*      */   
/*      */   @Column(name="o_a13")
/*      */   private Integer o_a13;
/*      */   
/*      */   @Column(name="o_a14")
/*      */   private Double o_a14;
/*      */   
/*      */   @Column(name="o_a15")
/*      */   private Double o_a15;
/*      */   
/*      */   @Column(name="o_a16")
/*      */   private Integer o_a16;
/*      */   
/*      */   @Column(name="o_a17")
/*      */   private Integer o_a17;
/*      */   
/*      */   @Column(name="o_s1")
/*      */   private String o_s1;
/*      */   
/*      */   @Column(name="o_s2")
/*      */   private String o_s2;
/*      */   
/*      */   @Column(name="o_s3")
/*      */   private String o_s3;
/*      */   
/*      */   @Column(name="o_s4")
/*      */   private String o_s4;
/*      */   
/*      */   @Column(name="o_s5")
/*      */   private String o_s5;
/*      */   
/*      */   @ManyToOne
/*      */   @JoinColumn(name="i_analysis_level_id")
/*      */   private AnalysisLevel i_analysisLevel;
/*      */   
/*      */   @Column(name="i_a1")
/*      */   private Double i_a1;
/*      */   
/*      */   @Column(name="i_a2")
/*      */   private Double i_a2;
/*      */   
/*      */   @Column(name="i_a3")
/*      */   private Double i_a3;
/*      */   
/*      */   @Column(name="i_a4")
/*      */   private Double i_a4;
/*      */   
/*      */   @Column(name="i_a5")
/*      */   private Double i_a5;
/*      */   
/*      */   @Column(name="i_a6")
/*      */   private Double i_a6;
/*      */   
/*      */   @Column(name="i_a7")
/*      */   private Double i_a7;
/*      */   
/*      */   @Column(name="i_a8")
/*      */   private Double i_a8;
/*      */   
/*      */   @Column(name="i_a9")
/*      */   private Double i_a9;
/*      */   
/*      */   @Column(name="i_a10")
/*      */   private Double i_a10;
/*      */   
/*      */   @Column(name="i_a11")
/*      */   private Double i_a11;
/*      */   
/*      */   @Column(name="i_a12")
/*      */   private Double i_a12;
/*      */   
/*      */   @Column(name="i_a13")
/*      */   private Integer i_a13;
/*      */   
/*      */   @Column(name="i_a14")
/*      */   private Double i_a14;
/*      */   
/*      */   @Column(name="i_a15")
/*      */   private Double i_a15;
/*      */   
/*      */   @Column(name="i_a16")
/*      */   private Integer i_a16;
/*      */   
/*      */   @Column(name="i_a17")
/*      */   private Integer i_a17;
/*      */   
/*      */   @Column(name="i_s1")
/*      */   private String i_s1;
/*      */   
/*      */   @Column(name="i_s2")
/*      */   private String i_s2;
/*      */   
/*      */   @Column(name="i_s3")
/*      */   private String i_s3;
/*      */   
/*      */   @Column(name="i_s4")
/*      */   private String i_s4;
/*      */   @Column(name="i_s5")
/*      */   private String i_s5;
/*      */   
/*      */   public PackageCategory getPackageCategory()
/*      */   {
/*  325 */     return this.packageCategory;
/*      */   }
/*      */   
/*      */   public void setPackageCategory(PackageCategory packageCategory) {
/*  329 */     this.packageCategory = packageCategory;
/*      */   }
/*      */   
/*      */   public CargoRepView getCargo() {
/*  333 */     return this.cargo;
/*      */   }
/*      */   
/*      */   public void setCargo(CargoRepView cargo) {
/*  337 */     this.cargo = cargo;
/*      */   }
/*      */   
/*      */   public GrainType getGrainType() {
/*  341 */     return this.grainType;
/*      */   }
/*      */   
/*      */   public void setGrainType(GrainType grainType) {
/*  345 */     this.grainType = grainType;
/*      */   }
/*      */   
/*      */   public GrainVariety getGrainVariety() {
/*  349 */     return this.grainVariety;
/*      */   }
/*      */   
/*      */   public void setGrainVariety(GrainVariety grainVariety) {
/*  353 */     this.grainVariety = grainVariety;
/*      */   }
/*      */   
/*      */   public String getYear() {
/*  357 */     return this.year;
/*      */   }
/*      */   
/*      */   public void setYear(String year) {
/*  361 */     this.year = year;
/*      */   }
/*      */   
/*      */   public Long getAmount() {
/*  365 */     return this.amount;
/*      */   }
/*      */   
/*      */   public void setAmount(Long amount) {
/*  369 */     this.amount = amount;
/*      */   }
/*      */   
/*      */   public Long getInAmount() {
/*  373 */     return this.inAmount;
/*      */   }
/*      */   
/*      */   public void setInAmount(Long inAmount) {
/*  377 */     this.inAmount = inAmount;
/*      */   }
/*      */   
/*      */   public Long getOutAmount() {
/*  381 */     return this.outAmount;
/*      */   }
/*      */   
/*      */   public void setOutAmount(Long outAmount) {
/*  385 */     this.outAmount = outAmount;
/*      */   }
/*      */   
/*      */   public PackageType getPackageType() {
/*  389 */     return this.packageType;
/*      */   }
/*      */   
/*      */   public void setPackageType(PackageType packageType) {
/*  393 */     this.packageType = packageType;
/*      */   }
/*      */   
/*      */   public String getLocation() {
/*  397 */     return this.location;
/*      */   }
/*      */   
/*      */   public void setLocation(String location) {
/*  401 */     this.location = location;
/*      */   }
/*      */   
/*      */   public Boolean getInFinished() {
/*  405 */     return this.inFinished;
/*      */   }
/*      */   
/*      */   public void setInFinished(Boolean inFinished) {
/*  409 */     this.inFinished = inFinished;
/*      */   }
/*      */   
/*      */   public Boolean getOutFinished() {
/*  413 */     return this.outFinished;
/*      */   }
/*      */   
/*      */   public void setOutFinished(Boolean outFinished) {
/*  417 */     this.outFinished = outFinished;
/*      */   }
/*      */   
/*      */   public Date getInTime() {
/*  421 */     return this.inTime;
/*      */   }
/*      */   
/*      */   public void setInTime(Date inTime) {
/*  425 */     this.inTime = inTime;
/*      */   }
/*      */   
/*      */   public Date getOutTime() {
/*  429 */     return this.outTime;
/*      */   }
/*      */   
/*      */   public void setOutTime(Date outTime) {
/*  433 */     this.outTime = outTime;
/*      */   }
/*      */   
/*      */   public Set<StockAnalysis> getStockAnalyses() {
/*  437 */     return this.stockAnalyses;
/*      */   }
/*      */   
/*      */   public void setStockAnalyses(Set<StockAnalysis> stockAnalyses) {
/*  441 */     this.stockAnalyses = stockAnalyses;
/*      */   }
/*      */   
/*      */   public Set<StockChange> getPositiveStockChanges() {
/*  445 */     return this.positiveStockChanges;
/*      */   }
/*      */   
/*      */   public void setPositiveStockChanges(Set<StockChange> positiveStockChanges) {
/*  449 */     this.positiveStockChanges = positiveStockChanges;
/*      */   }
/*      */   
/*      */   public Set<StockChange> getNegetiveStockChanges() {
/*  453 */     return this.negetiveStockChanges;
/*      */   }
/*      */   
/*      */   public void setNegetiveStockChanges(Set<StockChange> negetiveStockChanges) {
/*  457 */     this.negetiveStockChanges = negetiveStockChanges;
/*      */   }
/*      */   
/*      */   public AnalysisLevel getL_analysisLevel() {
/*  461 */     return this.l_analysisLevel;
/*      */   }
/*      */   
/*      */   public void setL_analysisLevel(AnalysisLevel l_analysisLevel) {
/*  465 */     this.l_analysisLevel = l_analysisLevel;
/*      */   }
/*      */   
/*      */   public Double getL_a1() {
/*  469 */     return this.l_a1;
/*      */   }
/*      */   
/*      */   public void setL_a1(Double l_a1) {
/*  473 */     this.l_a1 = l_a1;
/*      */   }
/*      */   
/*      */   public Double getL_a2() {
/*  477 */     return this.l_a2;
/*      */   }
/*      */   
/*      */   public void setL_a2(Double l_a2) {
/*  481 */     this.l_a2 = l_a2;
/*      */   }
/*      */   
/*      */   public Double getL_a3() {
/*  485 */     return this.l_a3;
/*      */   }
/*      */   
/*      */   public void setL_a3(Double l_a3) {
/*  489 */     this.l_a3 = l_a3;
/*      */   }
/*      */   
/*      */   public Double getL_a4() {
/*  493 */     return this.l_a4;
/*      */   }
/*      */   
/*      */   public void setL_a4(Double l_a4) {
/*  497 */     this.l_a4 = l_a4;
/*      */   }
/*      */   
/*      */   public Double getL_a5() {
/*  501 */     return this.l_a5;
/*      */   }
/*      */   
/*      */   public void setL_a5(Double l_a5) {
/*  505 */     this.l_a5 = l_a5;
/*      */   }
/*      */   
/*      */   public Double getL_a6() {
/*  509 */     return this.l_a6;
/*      */   }
/*      */   
/*      */   public void setL_a6(Double l_a6) {
/*  513 */     this.l_a6 = l_a6;
/*      */   }
/*      */   
/*      */   public Double getL_a7() {
/*  517 */     return this.l_a7;
/*      */   }
/*      */   
/*      */   public void setL_a7(Double l_a7) {
/*  521 */     this.l_a7 = l_a7;
/*      */   }
/*      */   
/*      */   public Double getL_a8() {
/*  525 */     return this.l_a8;
/*      */   }
/*      */   
/*      */   public void setL_a8(Double l_a8) {
/*  529 */     this.l_a8 = l_a8;
/*      */   }
/*      */   
/*      */   public Double getL_a9() {
/*  533 */     return this.l_a9;
/*      */   }
/*      */   
/*      */   public void setL_a9(Double l_a9) {
/*  537 */     this.l_a9 = l_a9;
/*      */   }
/*      */   
/*      */   public Double getL_a10() {
/*  541 */     return this.l_a10;
/*      */   }
/*      */   
/*      */   public void setL_a10(Double l_a10) {
/*  545 */     this.l_a10 = l_a10;
/*      */   }
/*      */   
/*      */   public String getL_s1() {
/*  549 */     return this.l_s1;
/*      */   }
/*      */   
/*      */   public void setL_s1(String l_s1) {
/*  553 */     this.l_s1 = l_s1;
/*      */   }
/*      */   
/*      */   public String getL_s2() {
/*  557 */     return this.l_s2;
/*      */   }
/*      */   
/*      */   public void setL_s2(String l_s2) {
/*  561 */     this.l_s2 = l_s2;
/*      */   }
/*      */   
/*      */   public String getL_s3() {
/*  565 */     return this.l_s3;
/*      */   }
/*      */   
/*      */   public void setL_s3(String l_s3) {
/*  569 */     this.l_s3 = l_s3;
/*      */   }
/*      */   
/*      */   public String getL_s4() {
/*  573 */     return this.l_s4;
/*      */   }
/*      */   
/*      */   public void setL_s4(String l_s4) {
/*  577 */     this.l_s4 = l_s4;
/*      */   }
/*      */   
/*      */   public String getL_s5() {
/*  581 */     return this.l_s5;
/*      */   }
/*      */   
/*      */   public void setL_s5(String l_s5) {
/*  585 */     this.l_s5 = l_s5;
/*      */   }
/*      */   
/*      */   public AnalysisLevel getO_analysisLevel() {
/*  589 */     return this.o_analysisLevel;
/*      */   }
/*      */   
/*      */   public void setO_analysisLevel(AnalysisLevel o_analysisLevel) {
/*  593 */     this.o_analysisLevel = o_analysisLevel;
/*      */   }
/*      */   
/*      */   public Double getO_a1() {
/*  597 */     return this.o_a1;
/*      */   }
/*      */   
/*      */   public void setO_a1(Double o_a1) {
/*  601 */     this.o_a1 = o_a1;
/*      */   }
/*      */   
/*      */   public Double getO_a2() {
/*  605 */     return this.o_a2;
/*      */   }
/*      */   
/*      */   public void setO_a2(Double o_a2) {
/*  609 */     this.o_a2 = o_a2;
/*      */   }
/*      */   
/*      */   public Double getO_a3() {
/*  613 */     return this.o_a3;
/*      */   }
/*      */   
/*      */   public void setO_a3(Double o_a3) {
/*  617 */     this.o_a3 = o_a3;
/*      */   }
/*      */   
/*      */   public Double getO_a4() {
/*  621 */     return this.o_a4;
/*      */   }
/*      */   
/*      */   public void setO_a4(Double o_a4) {
/*  625 */     this.o_a4 = o_a4;
/*      */   }
/*      */   
/*      */   public Double getO_a5() {
/*  629 */     return this.o_a5;
/*      */   }
/*      */   
/*      */   public void setO_a5(Double o_a5) {
/*  633 */     this.o_a5 = o_a5;
/*      */   }
/*      */   
/*      */   public Double getO_a6() {
/*  637 */     return this.o_a6;
/*      */   }
/*      */   
/*      */   public void setO_a6(Double o_a6) {
/*  641 */     this.o_a6 = o_a6;
/*      */   }
/*      */   
/*      */   public Double getO_a7() {
/*  645 */     return this.o_a7;
/*      */   }
/*      */   
/*      */   public void setO_a7(Double o_a7) {
/*  649 */     this.o_a7 = o_a7;
/*      */   }
/*      */   
/*      */   public Double getO_a8() {
/*  653 */     return this.o_a8;
/*      */   }
/*      */   
/*      */   public void setO_a8(Double o_a8) {
/*  657 */     this.o_a8 = o_a8;
/*      */   }
/*      */   
/*      */   public Double getO_a9() {
/*  661 */     return this.o_a9;
/*      */   }
/*      */   
/*      */   public void setO_a9(Double o_a9) {
/*  665 */     this.o_a9 = o_a9;
/*      */   }
/*      */   
/*      */   public Double getO_a10() {
/*  669 */     return this.o_a10;
/*      */   }
/*      */   
/*      */   public void setO_a10(Double o_a10) {
/*  673 */     this.o_a10 = o_a10;
/*      */   }
/*      */   
/*      */   public String getO_s1() {
/*  677 */     return this.o_s1;
/*      */   }
/*      */   
/*      */   public void setO_s1(String o_s1) {
/*  681 */     this.o_s1 = o_s1;
/*      */   }
/*      */   
/*      */   public String getO_s2() {
/*  685 */     return this.o_s2;
/*      */   }
/*      */   
/*      */   public void setO_s2(String o_s2) {
/*  689 */     this.o_s2 = o_s2;
/*      */   }
/*      */   
/*      */   public String getO_s3() {
/*  693 */     return this.o_s3;
/*      */   }
/*      */   
/*      */   public void setO_s3(String o_s3) {
/*  697 */     this.o_s3 = o_s3;
/*      */   }
/*      */   
/*      */   public String getO_s4() {
/*  701 */     return this.o_s4;
/*      */   }
/*      */   
/*      */   public void setO_s4(String o_s4) {
/*  705 */     this.o_s4 = o_s4;
/*      */   }
/*      */   
/*      */   public String getO_s5() {
/*  709 */     return this.o_s5;
/*      */   }
/*      */   
/*      */   public void setO_s5(String o_s5) {
/*  713 */     this.o_s5 = o_s5;
/*      */   }
/*      */   
/*      */   public AnalysisLevel getI_analysisLevel() {
/*  717 */     return this.i_analysisLevel;
/*      */   }
/*      */   
/*      */   public void setI_analysisLevel(AnalysisLevel i_analysisLevel) {
/*  721 */     this.i_analysisLevel = i_analysisLevel;
/*      */   }
/*      */   
/*      */   public Double getI_a1() {
/*  725 */     return this.i_a1;
/*      */   }
/*      */   
/*      */   public void setI_a1(Double i_a1) {
/*  729 */     this.i_a1 = i_a1;
/*      */   }
/*      */   
/*      */   public Double getI_a2() {
/*  733 */     return this.i_a2;
/*      */   }
/*      */   
/*      */   public void setI_a2(Double i_a2) {
/*  737 */     this.i_a2 = i_a2;
/*      */   }
/*      */   
/*      */   public Double getI_a3() {
/*  741 */     return this.i_a3;
/*      */   }
/*      */   
/*      */   public void setI_a3(Double i_a3) {
/*  745 */     this.i_a3 = i_a3;
/*      */   }
/*      */   
/*      */   public Double getI_a4() {
/*  749 */     return this.i_a4;
/*      */   }
/*      */   
/*      */   public void setI_a4(Double i_a4) {
/*  753 */     this.i_a4 = i_a4;
/*      */   }
/*      */   
/*      */   public Double getI_a5() {
/*  757 */     return this.i_a5;
/*      */   }
/*      */   
/*      */   public void setI_a5(Double i_a5) {
/*  761 */     this.i_a5 = i_a5;
/*      */   }
/*      */   
/*      */   public Double getI_a6() {
/*  765 */     return this.i_a6;
/*      */   }
/*      */   
/*      */   public void setI_a6(Double i_a6) {
/*  769 */     this.i_a6 = i_a6;
/*      */   }
/*      */   
/*      */   public Double getI_a7() {
/*  773 */     return this.i_a7;
/*      */   }
/*      */   
/*      */   public void setI_a7(Double i_a7) {
/*  777 */     this.i_a7 = i_a7;
/*      */   }
/*      */   
/*      */   public Double getI_a8() {
/*  781 */     return this.i_a8;
/*      */   }
/*      */   
/*      */   public void setI_a8(Double i_a8) {
/*  785 */     this.i_a8 = i_a8;
/*      */   }
/*      */   
/*      */   public Double getI_a9() {
/*  789 */     return this.i_a9;
/*      */   }
/*      */   
/*      */   public void setI_a9(Double i_a9) {
/*  793 */     this.i_a9 = i_a9;
/*      */   }
/*      */   
/*      */   public Double getI_a10() {
/*  797 */     return this.i_a10;
/*      */   }
/*      */   
/*      */   public void setI_a10(Double i_a10) {
/*  801 */     this.i_a10 = i_a10;
/*      */   }
/*      */   
/*      */   public String getI_s1() {
/*  805 */     return this.i_s1;
/*      */   }
/*      */   
/*      */   public void setI_s1(String i_s1) {
/*  809 */     this.i_s1 = i_s1;
/*      */   }
/*      */   
/*      */   public String getI_s2() {
/*  813 */     return this.i_s2;
/*      */   }
/*      */   
/*      */   public void setI_s2(String i_s2) {
/*  817 */     this.i_s2 = i_s2;
/*      */   }
/*      */   
/*      */   public String getI_s3() {
/*  821 */     return this.i_s3;
/*      */   }
/*      */   
/*      */   public void setI_s3(String i_s3) {
/*  825 */     this.i_s3 = i_s3;
/*      */   }
/*      */   
/*      */   public String getI_s4() {
/*  829 */     return this.i_s4;
/*      */   }
/*      */   
/*      */   public void setI_s4(String i_s4) {
/*  833 */     this.i_s4 = i_s4;
/*      */   }
/*      */   
/*      */   public String getI_s5() {
/*  837 */     return this.i_s5;
/*      */   }
/*      */   
/*      */   public void setI_s5(String i_s5) {
/*  841 */     this.i_s5 = i_s5;
/*      */   }
/*      */   
/*      */   public Double getUnitWeight() {
/*  845 */     return this.unitWeight;
/*      */   }
/*      */   
/*      */   public void setUnitWeight(Double unitWeight) {
/*  849 */     this.unitWeight = unitWeight;
/*      */   }
/*      */   
/*      */   public Double getDeductVolume() {
/*  853 */     return this.deductVolume;
/*      */   }
/*      */   
/*      */   public void setDeductVolume(Double deductVolume) {
/*  857 */     this.deductVolume = deductVolume;
/*      */   }
/*      */   
/*      */   public Double getFactor() {
/*  861 */     return this.factor;
/*      */   }
/*      */   
/*      */   public void setFactor(Double factor) {
/*  865 */     this.factor = factor;
/*      */   }
/*      */   
/*      */   public String getCargoName() {
/*  869 */     return this.cargoName;
/*      */   }
/*      */   
/*      */   public void setCargoName(String cargoName) {
/*  873 */     this.cargoName = cargoName;
/*      */   }
/*      */   
/*      */   public Double getL_a11() {
/*  877 */     return this.l_a11;
/*      */   }
/*      */   
/*      */   public void setL_a11(Double l_a11) {
/*  881 */     this.l_a11 = l_a11;
/*      */   }
/*      */   
/*      */   public Double getL_a12() {
/*  885 */     return this.l_a12;
/*      */   }
/*      */   
/*      */   public void setL_a12(Double l_a12) {
/*  889 */     this.l_a12 = l_a12;
/*      */   }
/*      */   
/*      */   public Integer getL_a13() {
/*  893 */     return this.l_a13;
/*      */   }
/*      */   
/*      */   public void setL_a13(Integer l_a13) {
/*  897 */     this.l_a13 = l_a13;
/*      */   }
/*      */   
/*      */   public Double getL_a14() {
/*  901 */     return this.l_a14;
/*      */   }
/*      */   
/*      */   public void setL_a14(Double l_a14) {
/*  905 */     this.l_a14 = l_a14;
/*      */   }
/*      */   
/*      */   public Double getL_a15() {
/*  909 */     return this.l_a15;
/*      */   }
/*      */   
/*      */   public void setL_a15(Double l_a15) {
/*  913 */     this.l_a15 = l_a15;
/*      */   }
/*      */   
/*      */   public Double getO_a11() {
/*  917 */     return this.o_a11;
/*      */   }
/*      */   
/*      */   public void setO_a11(Double o_a11) {
/*  921 */     this.o_a11 = o_a11;
/*      */   }
/*      */   
/*      */   public Double getO_a12() {
/*  925 */     return this.o_a12;
/*      */   }
/*      */   
/*      */   public void setO_a12(Double o_a12) {
/*  929 */     this.o_a12 = o_a12;
/*      */   }
/*      */   
/*      */   public Integer getO_a13() {
/*  933 */     return this.o_a13;
/*      */   }
/*      */   
/*      */   public void setO_a13(Integer o_a13) {
/*  937 */     this.o_a13 = o_a13;
/*      */   }
/*      */   
/*      */   public Double getO_a14() {
/*  941 */     return this.o_a14;
/*      */   }
/*      */   
/*      */   public void setO_a14(Double o_a14) {
/*  945 */     this.o_a14 = o_a14;
/*      */   }
/*      */   
/*      */   public Double getO_a15() {
/*  949 */     return this.o_a15;
/*      */   }
/*      */   
/*      */   public void setO_a15(Double o_a15) {
/*  953 */     this.o_a15 = o_a15;
/*      */   }
/*      */   
/*      */   public Double getI_a11() {
/*  957 */     return this.i_a11;
/*      */   }
/*      */   
/*      */   public void setI_a11(Double i_a11) {
/*  961 */     this.i_a11 = i_a11;
/*      */   }
/*      */   
/*      */   public Double getI_a12() {
/*  965 */     return this.i_a12;
/*      */   }
/*      */   
/*      */   public void setI_a12(Double i_a12) {
/*  969 */     this.i_a12 = i_a12;
/*      */   }
/*      */   
/*      */   public Integer getI_a13() {
/*  973 */     return this.i_a13;
/*      */   }
/*      */   
/*      */   public void setI_a13(Integer i_a13) {
/*  977 */     this.i_a13 = i_a13;
/*      */   }
/*      */   
/*      */   public Double getI_a14() {
/*  981 */     return this.i_a14;
/*      */   }
/*      */   
/*      */   public void setI_a14(Double i_a14) {
/*  985 */     this.i_a14 = i_a14;
/*      */   }
/*      */   
/*      */   public Double getI_a15() {
/*  989 */     return this.i_a15;
/*      */   }
/*      */   
/*      */   public void setI_a15(Double i_a15) {
/*  993 */     this.i_a15 = i_a15;
/*      */   }
/*      */   
/*      */   public Integer getL_a16() {
/*  997 */     return this.l_a16;
/*      */   }
/*      */   
/*      */   public void setL_a16(Integer l_a16) {
/* 1001 */     this.l_a16 = l_a16;
/*      */   }
/*      */   
/*      */   public Integer getL_a17() {
/* 1005 */     return this.l_a17;
/*      */   }
/*      */   
/*      */   public void setL_a17(Integer l_a17) {
/* 1009 */     this.l_a17 = l_a17;
/*      */   }
/*      */   
/*      */   public Integer getO_a16() {
/* 1013 */     return this.o_a16;
/*      */   }
/*      */   
/*      */   public void setO_a16(Integer o_a16) {
/* 1017 */     this.o_a16 = o_a16;
/*      */   }
/*      */   
/*      */   public Integer getO_a17() {
/* 1021 */     return this.o_a17;
/*      */   }
/*      */   
/*      */   public void setO_a17(Integer o_a17) {
/* 1025 */     this.o_a17 = o_a17;
/*      */   }
/*      */   
/*      */   public Integer getI_a16() {
/* 1029 */     return this.i_a16;
/*      */   }
/*      */   
/*      */   public void setI_a16(Integer i_a16) {
/* 1033 */     this.i_a16 = i_a16;
/*      */   }
/*      */   
/*      */   public Integer getI_a17() {
/* 1037 */     return this.i_a17;
/*      */   }
/*      */   
/*      */   public void setI_a17(Integer i_a17) {
/* 1041 */     this.i_a17 = i_a17;
/*      */   }
/*      */   
/*      */   public String getCargoNameShort() {
/* 1045 */     return this.cargoNameShort;
/*      */   }
/*      */   
/*      */   public void setCargoNameShort(String cargoNameShort) {
/* 1049 */     this.cargoNameShort = cargoNameShort;
/*      */   }
/*      */   
/*      */   public Country getCountry() {
/* 1053 */     return this.country;
/*      */   }
/*      */   
/*      */   public void setCountry(Country country) {
/* 1057 */     this.country = country;
/*      */   }
/*      */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockSumHistory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */