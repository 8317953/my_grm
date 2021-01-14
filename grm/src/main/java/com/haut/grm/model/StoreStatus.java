/*     */ package com.haut.grm.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonBackReference;
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.SpaceConditionView;
/*     */ import com.haut.grm.json.view.Views.SpaceStatusView;
/*     */ import com.haut.grm.json.view.Views.StoreStatusRefStoreView;
/*     */ import com.haut.grm.json.view.Views.StoreStatusView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.type.SpaceCondition;
/*     */ import com.haut.grm.model.type.SpaceStatus;
/*     */ import java.util.Date;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.OneToOne;
/*     */ import javax.persistence.Table;
/*     */ import javax.persistence.Temporal;
/*     */ import javax.persistence.TemporalType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Entity
/*     */ @Table(name="grm_store_status")
/*     */ public class StoreStatus
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -5174373570677283902L;
/*     */   @JsonBackReference
/*     */   @JsonView({Views.StoreStatusRefStoreView.class})
/*     */   @OneToOne(mappedBy="status")
/*     */   private Store store;
/*     */   @Column(name="is_measure_ongoing")
/*     */   @JsonView({Views.StoreStatusView.class})
/*  37 */   private Boolean isMeasureOngoing = Boolean.valueOf(false);
/*     */   
/*     */   @Column(name="measure_time")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date measureTime;
/*     */   
/*     */   @Column(name="safety_time")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date safetyTime;
/*     */   
/*     */   @Column(name="door_time")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date doorTime;
/*     */   
/*     */   @Column(name="measure_comment")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   private String measureComment;
/*     */   
/*     */   @Column(name="safety_comment")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   private String safetyComment;
/*     */   
/*     */   @Column(name="door_comment")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   private String doorComment;
/*     */   
/*     */   @ManyToOne
/*     */   @JsonView({Views.SpaceConditionView.class})
/*     */   @JoinColumn(name="condition_id")
/*     */   private SpaceCondition condition;
/*     */   
/*     */   @ManyToOne
/*     */   @JsonView({Views.SpaceStatusView.class})
/*     */   @JoinColumn(name="status_id")
/*     */   private SpaceStatus status;
/*     */   
/*     */   @Column(name="active_date")
/*     */   @JsonView({Views.StoreStatusView.class})
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date activeDate;
/*     */   
/*     */   @Column(name="alerting")
/*     */   @JsonView({Views.StoreStatusView.class})
/*  83 */   private Boolean alerting = Boolean.valueOf(false);
/*     */   
/*     */   public Store getStore() {
/*  86 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/*  90 */     this.store = store;
/*     */   }
/*     */   
/*     */   public Boolean getIsMeasureOngoing() {
/*  94 */     return this.isMeasureOngoing;
/*     */   }
/*     */   
/*     */   public void setIsMeasureOngoing(Boolean isMeasureOngoing) {
/*  98 */     this.isMeasureOngoing = isMeasureOngoing;
/*     */   }
/*     */   
/*     */   public Date getMeasureTime() {
/* 102 */     return this.measureTime;
/*     */   }
/*     */   
/*     */   public void setMeasureTime(Date measureTime) {
/* 106 */     this.measureTime = measureTime;
/*     */   }
/*     */   
/*     */   public Date getSafetyTime() {
/* 110 */     return this.safetyTime;
/*     */   }
/*     */   
/*     */   public void setSafetyTime(Date safetyTime) {
/* 114 */     this.safetyTime = safetyTime;
/*     */   }
/*     */   
/*     */   public Date getDoorTime() {
/* 118 */     return this.doorTime;
/*     */   }
/*     */   
/*     */   public void setDoorTime(Date doorTime) {
/* 122 */     this.doorTime = doorTime;
/*     */   }
/*     */   
/*     */   public String getMeasureComment() {
/* 126 */     return this.measureComment;
/*     */   }
/*     */   
/*     */   public void setMeasureComment(String measureComment) {
/* 130 */     this.measureComment = measureComment;
/*     */   }
/*     */   
/*     */   public String getSafetyComment() {
/* 134 */     return this.safetyComment;
/*     */   }
/*     */   
/*     */   public void setSafetyComment(String safetyComment) {
/* 138 */     this.safetyComment = safetyComment;
/*     */   }
/*     */   
/*     */   public String getDoorComment() {
/* 142 */     return this.doorComment;
/*     */   }
/*     */   
/*     */   public void setDoorComment(String doorComment) {
/* 146 */     this.doorComment = doorComment;
/*     */   }
/*     */   
/*     */   public SpaceCondition getCondition() {
/* 150 */     return this.condition;
/*     */   }
/*     */   
/*     */   public void setCondition(SpaceCondition condition) {
/* 154 */     this.condition = condition;
/*     */   }
/*     */   
/*     */   public SpaceStatus getStatus() {
/* 158 */     return this.status;
/*     */   }
/*     */   
/*     */   public void setStatus(SpaceStatus status) {
/* 162 */     this.status = status;
/*     */   }
/*     */   
/*     */   public Date getActiveDate() {
/* 166 */     return this.activeDate;
/*     */   }
/*     */   
/*     */   public void setActiveDate(Date activeDate) {
/* 170 */     this.activeDate = activeDate;
/*     */   }
/*     */   
/*     */   public Boolean getAlerting() {
/* 174 */     return this.alerting;
/*     */   }
/*     */   
/*     */   public void setAlerting(Boolean alerting) {
/* 178 */     this.alerting = alerting;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\StoreStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */