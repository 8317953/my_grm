/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.base.AbstractBusiness;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.type.AnalysisLevel;
/*     */ import com.haut.grm.model.type.GrainType;
/*     */ import com.haut.grm.model.type.PackageCategory;
/*     */ import com.haut.grm.model.type.SourceType;
/*     */ import com.querydsl.core.annotations.QueryInit;
/*     */ import java.util.List;
/*     */ import javax.persistence.CollectionTable;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.ElementCollection;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ import org.springframework.data.rest.core.annotation.Description;
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
/*     */ @Table(name="gb_stock_change")
/*     */ public class StockChange
/*     */   extends AbstractBusiness//人家的也有profile
/*     */ {
/*     */   private static final long serialVersionUID = -445419563594619798L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="type_id")
/*     */   @Description("货位变更类型")//明白了 这些中文的 意义 就是要获取 doc 值用来 在前段 展现  input 前面 lable 字样
/*     */   private SourceType type;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="source_stock_id")
/*     */   @Description("来源货位")
/*     */   @QueryInit({"cargo.compartment.store.depot.*"})
/*     */   private StockId sourceStock;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="target_stock_id")
/*     */   @Description("目标货位")
/*     */   @QueryInit({"cargo.compartment.store.depot.*"})
/*     */   private StockId targetStock;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="contract_id")
/*     */   @Description("合同")
/*     */   private Contract contract;
/*     */   @Column(name="amount")
/*     */   @Description("变动数量 (kg/公斤)")
/*     */   private Long amount;
/*     */   @Column(name="pack")
/*     */   @Description("包数")
/*     */   private Long pack;
/*     */   @Column(name="water")
/*     */   @Description("水分")
/*     */   private Double water;
/*     */   @Column(name="impurity")
/*     */   @Description("杂质")
/*     */   private Double impurity;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="package_category_id")
/*     */   @Description("储存方式")
/*     */   private PackageCategory packageCategory;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_type_id")
/*     */   @Description("粮食性质")
/*     */   private GrainType grainType;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_variety_id")
/*     */   @Description("粮食品种")
/*     */   private GrainVariety grainVariety;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="analysis_level_id")
/*     */   @Description("质量等级")
/*     */   private AnalysisLevel analysisLevel;
/*     */   @ElementCollection
/*     */   @CollectionTable(name="gb_stock_change_entry", joinColumns={@JoinColumn(name="owner_id", nullable=false)})
/*     */   private List<StockChangeEntry> entries;
/*     */   
/*     */   public PackageCategory getPackageCategory()
/*     */   {
/*  95 */     return this.packageCategory;
/*     */   }
/*     */   
/*     */   public void setPackageCategory(PackageCategory packageCategory) {
/*  99 */     this.packageCategory = packageCategory;
/*     */   }
/*     */   
/*     */   public List<StockChangeEntry> getEntries() {
/* 103 */     return this.entries;
/*     */   }
/*     */   
/*     */   public void setEntries(List<StockChangeEntry> entries) {
/* 107 */     this.entries = entries;
/*     */   }
/*     */   
/*     */   public AnalysisLevel getAnalysisLevel() {
/* 111 */     return this.analysisLevel;
/*     */   }
/*     */   
/*     */   public void setAnalysisLevel(AnalysisLevel analysisLevel) {
/* 115 */     this.analysisLevel = analysisLevel;
/*     */   }
/*     */   
/*     */   public Double getWater() {
/* 119 */     return this.water;
/*     */   }
/*     */   
/*     */   public void setWater(Double water) {
/* 123 */     this.water = water;
/*     */   }
/*     */   
/*     */   public Double getImpurity() {
/* 127 */     return this.impurity;
/*     */   }
/*     */   
/*     */   public void setImpurity(Double impurity) {
/* 131 */     this.impurity = impurity;
/*     */   }
/*     */   
/*     */   public GrainType getGrainType() {
/* 135 */     return this.grainType;
/*     */   }
/*     */   
/*     */   public void setGrainType(GrainType grainType) {
/* 139 */     this.grainType = grainType;
/*     */   }
/*     */   
/*     */   public Long getPack() {
/* 143 */     return this.pack;
/*     */   }
/*     */   
/*     */   public void setPack(Long pack) {
/* 147 */     this.pack = pack;
/*     */   }
/*     */   
/*     */   public GrainVariety getGrainVariety() {
/* 151 */     return this.grainVariety;
/*     */   }
/*     */   
/*     */   public void setGrainVariety(GrainVariety grainVariety) {
/* 155 */     this.grainVariety = grainVariety;
/*     */   }
/*     */   
/*     */   public StockId getSourceStock() {
/* 159 */     return this.sourceStock;
/*     */   }
/*     */   
/*     */   public void setSourceStock(StockId sourceStock) {
/* 163 */     this.sourceStock = sourceStock;
/*     */   }
/*     */   
/*     */   public StockId getTargetStock() {
/* 167 */     return this.targetStock;
/*     */   }
/*     */   
/*     */   public void setTargetStock(StockId targetStock) {
/* 171 */     this.targetStock = targetStock;
/*     */   }
/*     */   
/*     */   public SourceType getType() {
/* 175 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(SourceType type) {
/* 179 */     this.type = type;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/* 183 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/* 187 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Contract getContract() {
/* 191 */     return this.contract;
/*     */   }
/*     */   
/*     */   public void setContract(Contract contract) {
/* 195 */     this.contract = contract;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockChange.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */