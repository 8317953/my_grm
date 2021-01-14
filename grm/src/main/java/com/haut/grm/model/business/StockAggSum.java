/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.base.AbstractEntity;
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
/*     */ @Entity
/*     */ @Table(name="gb_stock_agg_sum")
/*     */ public class StockAggSum
/*     */   extends AbstractEntity<String>
/*     */ {
/*     */   private static final long serialVersionUID = 8225446102186193945L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="stock_id")
/*     */   private StockRepresentation stock;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="cargo_id")
/*     */   @QueryInit({"compartment.store.depot.*"})
/*     */   private Cargo cargo;
/*     */   @Column(name="time")
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   protected Date time;
/*     */   @Column(name="amount")
/*     */   private Long amount;
/*     */   @Column(name="in_amount")
/*     */   private Long inAmount;
/*     */   @Column(name="out_amount")
/*     */   private Long outAmount;
/*     */   @Column(name="water_amount")
/*     */   private Double waterAmount;
/*     */   @Column(name="impurity_amount")
/*     */   private Double impurityAmount;
/*     */   
/*     */   public StockRepresentation getStock()
/*     */   {
/*  55 */     return this.stock;
/*     */   }
/*     */   
/*     */   public void setStock(StockRepresentation stock) {
/*  59 */     this.stock = stock;
/*     */   }
/*     */   
/*     */   public Cargo getCargo() {
/*  63 */     return this.cargo;
/*     */   }
/*     */   
/*     */   public void setCargo(Cargo cargo) {
/*  67 */     this.cargo = cargo;
/*     */   }
/*     */   
/*     */   public Date getTime() {
/*  71 */     return this.time;
/*     */   }
/*     */   
/*     */   public void setTime(Date time) {
/*  75 */     this.time = time;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/*  79 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/*  83 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Long getInAmount() {
/*  87 */     return this.inAmount;
/*     */   }
/*     */   
/*     */   public void setInAmount(Long inAmount) {
/*  91 */     this.inAmount = inAmount;
/*     */   }
/*     */   
/*     */   public Long getOutAmount() {
/*  95 */     return this.outAmount;
/*     */   }
/*     */   
/*     */   public void setOutAmount(Long outAmount) {
/*  99 */     this.outAmount = outAmount;
/*     */   }
/*     */   
/*     */   public Double getWaterAmount() {
/* 103 */     return this.waterAmount;
/*     */   }
/*     */   
/*     */   public void setWaterAmount(Double waterAmount) {
/* 107 */     this.waterAmount = waterAmount;
/*     */   }
/*     */   
/*     */   public Double getImpurityAmount() {
/* 111 */     return this.impurityAmount;
/*     */   }
/*     */   
/*     */   public void setImpurityAmount(Double impurityAmount) {
/* 115 */     this.impurityAmount = impurityAmount;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockAggSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */