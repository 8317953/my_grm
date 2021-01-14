/*     */ package com.haut.grm.model.entry;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.EntryMeasureView;
/*     */ import com.haut.grm.model.base.AbstractEntry;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="entry_measure")
/*     */ public class EntryMeasure
/*     */   extends AbstractEntry
/*     */ {
/*     */   private static final long serialVersionUID = 7177063532940811160L;
/*     */   @Column(name="volume")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private Double volume;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="user_id")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private User initiator;
/*     */   @Column(name="has_data")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private Boolean hasData;
/*     */   @Column(name="is_auto")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private Boolean isAuto;
/*     */   @Column(name="amount")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private Long amount;
/*     */   @Column(name="stock_amount")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private Long stockAmount;
/*     */   @Column(name="measure_data")
/*     */   @JsonView({Views.EntryMeasureView.class})
/*     */   private String data;
/*     */   
/*     */   public Double getVolume()
/*     */   {
/*  50 */     return this.volume;
/*     */   }
/*     */   
/*     */   public void setVolume(Double volume) {
/*  54 */     this.volume = volume;
/*     */   }
/*     */   
/*     */   public User getInitiator() {
/*  58 */     return this.initiator;
/*     */   }
/*     */   
/*     */   public void setInitiator(User initiator) {
/*  62 */     this.initiator = initiator;
/*     */   }
/*     */   
/*     */   public Boolean getHasData() {
/*  66 */     return this.hasData;
/*     */   }
/*     */   
/*     */   public void setHasData(Boolean hasData) {
/*  70 */     this.hasData = hasData;
/*     */   }
/*     */   
/*     */   public Boolean getIsAuto() {
/*  74 */     return this.isAuto;
/*     */   }
/*     */   
/*     */   public void setIsAuto(Boolean isAuto) {
/*  78 */     this.isAuto = isAuto;
/*     */   }
/*     */   
/*     */   public String getData() {
/*  82 */     return this.data;
/*     */   }
/*     */   
/*     */   public void setData(String data) {
/*  86 */     this.data = data;
/*     */   }
/*     */   
/*     */   public Long getAmount() {
/*  90 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Long amount) {
/*  94 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Long getStockAmount() {
/*  98 */     return this.stockAmount;
/*     */   }
/*     */   
/*     */   public void setStockAmount(Long stockAmount) {
/* 102 */     this.stockAmount = stockAmount;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\EntryMeasure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */