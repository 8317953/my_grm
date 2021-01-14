/*     */ package com.haut.grm.model.ies;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.WeightSheetView;
/*     */ import com.haut.grm.model.Cargo;
/*     */ import com.haut.grm.model.Store;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.model.standalone.LoadCompany;
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
/*     */ @Entity
/*     */ @Table(name="ies_weight_sheet")
/*     */ public class WeightSheet
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = 1687127244355161084L;
/*     */   @Column(name="first_weight")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private Double firstWeight;
/*     */   @Column(name="second_weight")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private Double secondWeight;
/*     */   @Column(name="deduct_weight")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private Double deductWeight;
/*     */   @Column(name="deduct_percentage")
/*     */   @JsonView({Views.WeightSheetView.class})
/*  44 */   private Double deductPercentage = Double.valueOf(0.0D);
/*     */   
/*     */   @Column(name="comment")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private String comment;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="load_company_id")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private LoadCompany loadCompany;
/*     */   
/*     */   @Column(name="pack")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private Long pack;
/*     */   
/*     */   @Column(name="pack_per_weight")
/*     */   @JsonView({Views.WeightSheetView.class})
/*  61 */   private Double packPerWeight = Double.valueOf(0.15D);
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="first_user_id")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private User firstUser;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="second_user_id")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private User secondUser;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="manager_id")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private User manager;
/*     */   
/*     */   @Column(name="first_time")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date firstTime;
/*     */   
/*     */   @Column(name="second_time")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date secondTime;
/*     */   
/*     */   @Column(name="deduct_time")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   @Temporal(TemporalType.TIMESTAMP)
/*     */   private Date deductTime;
/*     */   
/*     */   @ManyToOne
/*     */   @JoinColumn(name="store_id")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private Store store;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="cargo_id")
/*     */   @JsonView({Views.WeightSheetView.class})
/*     */   private Cargo cargo;
/*     */   
/*     */   public LoadCompany getLoadCompany()
/*     */   {
/* 104 */     return this.loadCompany;
/*     */   }
/*     */   
/*     */   public void setLoadCompany(LoadCompany loadCompany) {
/* 108 */     this.loadCompany = loadCompany;
/*     */   }
/*     */   
/*     */   public Long getPack() {
/* 112 */     return this.pack;
/*     */   }
/*     */   
/*     */   public void setPack(Long pack) {
/* 116 */     this.pack = pack;
/*     */   }
/*     */   
/*     */   public Store getStore() {
/* 120 */     return this.store;
/*     */   }
/*     */   
/*     */   public void setStore(Store store) {
/* 124 */     this.store = store;
/*     */   }
/*     */   
/*     */   public Cargo getCargo() {
/* 128 */     return this.cargo;
/*     */   }
/*     */   
/*     */   public void setCargo(Cargo cargo) {
/* 132 */     this.cargo = cargo;
/*     */   }
/*     */   
/*     */   public Date getFirstTime() {
/* 136 */     return this.firstTime;
/*     */   }
/*     */   
/*     */   public void setFirstTime(Date firstTime) {
/* 140 */     this.firstTime = firstTime;
/*     */   }
/*     */   
/*     */   public Date getSecondTime() {
/* 144 */     return this.secondTime;
/*     */   }
/*     */   
/*     */   public void setSecondTime(Date secondTime) {
/* 148 */     this.secondTime = secondTime;
/*     */   }
/*     */   
/*     */   public Date getDeductTime() {
/* 152 */     return this.deductTime;
/*     */   }
/*     */   
/*     */   public void setDeductTime(Date deductTime) {
/* 156 */     this.deductTime = deductTime;
/*     */   }
/*     */   
/*     */   public Double getFirstWeight() {
/* 160 */     return this.firstWeight;
/*     */   }
/*     */   
/*     */   public void setFirstWeight(Double firstWeight) {
/* 164 */     this.firstWeight = firstWeight;
/*     */   }
/*     */   
/*     */   public Double getSecondWeight() {
/* 168 */     return this.secondWeight;
/*     */   }
/*     */   
/*     */   public void setSecondWeight(Double secondWeight) {
/* 172 */     this.secondWeight = secondWeight;
/*     */   }
/*     */   
/*     */   public Double getDeductWeight() {
/* 176 */     return this.deductWeight;
/*     */   }
/*     */   
/*     */   public void setDeductWeight(Double deductWeight) {
/* 180 */     this.deductWeight = deductWeight;
/*     */   }
/*     */   
/*     */   public User getFirstUser() {
/* 184 */     return this.firstUser;
/*     */   }
/*     */   
/*     */   public void setFirstUser(User firstUser) {
/* 188 */     this.firstUser = firstUser;
/*     */   }
/*     */   
/*     */   public User getSecondUser() {
/* 192 */     return this.secondUser;
/*     */   }
/*     */   
/*     */   public void setSecondUser(User secondUser) {
/* 196 */     this.secondUser = secondUser;
/*     */   }
/*     */   
/*     */   public User getManager() {
/* 200 */     return this.manager;
/*     */   }
/*     */   
/*     */   public void setManager(User manager) {
/* 204 */     this.manager = manager;
/*     */   }
/*     */   
/*     */   public String getComment() {
/* 208 */     return this.comment;
/*     */   }
/*     */   
/*     */   public void setComment(String comment) {
/* 212 */     this.comment = comment;
/*     */   }
/*     */   
/*     */   public Double getDeductPercentage() {
/* 216 */     return this.deductPercentage;
/*     */   }
/*     */   
/*     */   public void setDeductPercentage(Double deductPercentage) {
/* 220 */     this.deductPercentage = deductPercentage;
/*     */   }
/*     */   
/*     */   public Double getPackPerWeight() {
/* 224 */     return this.packPerWeight;
/*     */   }
/*     */   
/*     */   public void setPackPerWeight(Double packPerWeight) {
/* 228 */     this.packPerWeight = packPerWeight;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\WeightSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */