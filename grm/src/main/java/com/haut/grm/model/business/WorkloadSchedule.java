/*     */ package com.haut.grm.model.business;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.WorkloadScheduleView;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.base.AbstractBusiness;
/*     */ import com.haut.grm.model.type.WorkloadCategory;
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
/*     */ @Entity
/*     */ @Table(name="gb_workload_schedule")
/*     */ public class WorkloadSchedule
/*     */   extends AbstractBusiness
/*     */ {
/*     */   private static final long serialVersionUID = -962906422832723521L;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="store_id")
/*     */   private Store store;
/*     */   @Column(name="color")
/*     */   @JsonView({Views.WorkloadScheduleView.class})
/*     */   private String color;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="category_id")
/*     */   @JsonView({Views.WorkloadScheduleView.class})
/*     */   private WorkloadCategory category;
/*     */   @Column(name="start_time")
/*     */   @JsonView({Views.WorkloadScheduleView.class})
/*     */   private String startTime;
/*     */   @Column(name="end_time")
/*     */   @JsonView({Views.WorkloadScheduleView.class})
/*     */   private String endTime;
/*     */   @Column(name="start_date")
/*     */   @JsonView({Views.WorkloadScheduleView.class})
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date startDate;
/*     */   @Column(name="end_date")
/*     */   @JsonView({Views.WorkloadScheduleView.class})
/*     */   @Temporal(TemporalType.DATE)
/*     */   private Date endDate;
/*     */   
/*     */   public Store getStore()
/*     */   {
/*  57 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/*  61 */     this.store = store;
/*     */   }
/*     */   
/*     */   public String getColor() {
/*  65 */     return this.color;
/*     */   }
/*     */   
/*     */   public void setColor(String color) {
/*  69 */     this.color = color;
/*     */   }
/*     */   
/*     */   public WorkloadCategory getCategory() {
/*  73 */     return this.category;
/*     */   }
/*     */   
/*     */   public void setCategory(WorkloadCategory category) {
/*  77 */     this.category = category;
/*     */   }
/*     */   
/*     */   public String getStartTime() {
/*  81 */     return this.startTime;
/*     */   }
/*     */   
/*     */   public void setStartTime(String startTime) {
/*  85 */     this.startTime = startTime;
/*     */   }
/*     */   
/*     */   public String getEndTime() {
/*  89 */     return this.endTime;
/*     */   }
/*     */   
/*     */   public void setEndTime(String endTime) {
/*  93 */     this.endTime = endTime;
/*     */   }
/*     */   
/*     */   public Date getStartDate() {
/*  97 */     return this.startDate;
/*     */   }
/*     */   
/*     */   public void setStartDate(Date startDate) {
/* 101 */     this.startDate = startDate;
/*     */   }
/*     */   
/*     */   public Date getEndDate() {
/* 105 */     return this.endDate;
/*     */   }
/*     */   
/*     */   public void setEndDate(Date endDate) {
/* 109 */     this.endDate = endDate;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\WorkloadSchedule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */