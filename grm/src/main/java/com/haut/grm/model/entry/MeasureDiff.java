/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.MeasureDiffRefStoreView;
/*    */ import com.haut.grm.json.view.Views.MeasureDiffView;
/*    */ import com.haut.grm.model.Store;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="entry_measure_diff")
/*    */ public class MeasureDiff
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -5875409721558079026L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="store_id")
/*    */   @JsonView({Views.MeasureDiffRefStoreView.class})
/*    */   private Store store;
/*    */   @Column(name="this_volume")
/*    */   @JsonView({Views.MeasureDiffView.class})
/*    */   private Double thisVolume;
/*    */   @Column(name="that_volume")
/*    */   @JsonView({Views.MeasureDiffView.class})
/*    */   private Double thatVolume;
/*    */   @Column(name="error_percentage")
/*    */   @JsonView({Views.MeasureDiffView.class})
/*    */   private Double errorPercentage;
/*    */   @Column(name="this_time")
/*    */   @JsonView({Views.MeasureDiffView.class})
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date thisTime;
/*    */   @Column(name="that_time")
/*    */   @JsonView({Views.MeasureDiffView.class})
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date thatTime;
/*    */   
/*    */   public Store getStore()
/*    */   {
/* 52 */     return this.store;
/*    */   }
/*    */   
/*    */   public void setStore(Store store) {
/* 56 */     this.store = store;
/*    */   }
/*    */   
/*    */   public Double getThisVolume() {
/* 60 */     return this.thisVolume;
/*    */   }
/*    */   
/*    */   public void setThisVolume(Double thisVolume) {
/* 64 */     this.thisVolume = thisVolume;
/*    */   }
/*    */   
/*    */   public Double getThatVolume() {
/* 68 */     return this.thatVolume;
/*    */   }
/*    */   
/*    */   public void setThatVolume(Double thatVolume) {
/* 72 */     this.thatVolume = thatVolume;
/*    */   }
/*    */   
/*    */   public Double getErrorPercentage() {
/* 76 */     return this.errorPercentage;
/*    */   }
/*    */   
/*    */   public void setErrorPercentage(Double errorPercentage) {
/* 80 */     this.errorPercentage = errorPercentage;
/*    */   }
/*    */   
/*    */   public Date getThisTime() {
/* 84 */     return this.thisTime;
/*    */   }
/*    */   
/*    */   public void setThisTime(Date thisTime) {
/* 88 */     this.thisTime = thisTime;
/*    */   }
/*    */   
/*    */   public Date getThatTime() {
/* 92 */     return this.thatTime;
/*    */   }
/*    */   
/*    */   public void setThatTime(Date thatTime) {
/* 96 */     this.thatTime = thatTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\MeasureDiff.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */