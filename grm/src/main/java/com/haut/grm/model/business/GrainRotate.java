/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.Depot;
/*     */ import com.haut.grm.model.base.AbstractBusiness;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.type.GrainType;
/*     */ import javax.persistence.Column;
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
/*     */ @Entity
/*     */ @Table(name="gb_grain_rotate")
/*     */ public class GrainRotate
/*     */   extends AbstractBusiness
/*     */ {
/*     */   private static final long serialVersionUID = -1036183782443313505L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_type_id")
/*     */   @Description("粮食性质")
/*     */   private GrainType grainType;
/*     */   @Column(name="year")
/*     */   @Description("计划年份")
/*     */   private String year;
/*     */   @Column(name="harvest_year")
/*     */   @Description("生产年份")
/*     */   private String harvestYear;
/*     */   @Column(name="stock_year")
/*     */   @Description("储存年限")
/*     */   private Integer stockYear;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="grain_variety_id")
/*     */   @Description("粮食品种")
/*     */   private GrainVariety grainVariety;
/*     */   @Column(name="amount")
/*     */   @Description("轮换数量 (吨)")
/*     */   private Long amount;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="depot_id")
/*     */   @Description("库区")
/*     */   private Depot depot;
/*     */   @Column(name="is_ingress")
/*     */   private Boolean isIngress;
/*     */   
/*     */   public GrainType getGrainType()
/*     */   {
/*  60 */     return this.grainType;
/*     */   }
/*     */   
/*     */   public void setGrainType(GrainType grainType) {
/*  64 */     this.grainType = grainType;
/*     */   }
/*     */   
/*     */   public GrainVariety getGrainVariety() {
/*  68 */     return this.grainVariety;
/*     */   }
/*     */   
/*     */   public void setGrainVariety(GrainVariety grainVariety) {
/*  72 */     this.grainVariety = grainVariety;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/*  76 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/*  80 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Boolean getIsIngress() {
/*  84 */     return this.isIngress;
/*     */   }
/*     */   
/*     */   public void setIsIngress(Boolean isIngress) {
/*  88 */     this.isIngress = isIngress;
/*     */   }
/*     */   
/*     */   public String getYear() {
/*  92 */     return this.year;
/*     */   }
/*     */   
/*     */   public void setYear(String year) {
/*  96 */     this.year = year;
/*     */   }
/*     */   
/*     */   public Depot getDepot() {
/* 100 */     return this.depot;
/*     */   }
/*     */   
/*     */   public void setDepot(Depot depot) {
/* 104 */     this.depot = depot;
/*     */   }
/*     */   
/*     */   public String getHarvestYear() {
/* 108 */     return this.harvestYear;
/*     */   }
/*     */   
/*     */   public void setHarvestYear(String harvestYear) {
/* 112 */     this.harvestYear = harvestYear;
/*     */   }
/*     */   
/*     */   public Integer getStockYear() {
/* 116 */     return this.stockYear;
/*     */   }
/*     */   
/*     */   public void setStockYear(Integer stockYear) {
/* 120 */     this.stockYear = stockYear;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\GrainRotate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */