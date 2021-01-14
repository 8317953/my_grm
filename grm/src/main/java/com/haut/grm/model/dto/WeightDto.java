/*     */ package com.haut.grm.model.dto;
/*     */ 
/*     */ import com.haut.grm.model.meta.User;
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
/*     */ public class WeightDto
/*     */ {
/*     */   private Double amount;
/*     */   private Long storeId;
/*     */   private Long cargoId;
/*     */   private Long doorId;
/*     */   private Long loadCompanyId;
/*     */   private Long pack;
/*     */   private Double deductAmount;
/*     */   private Double packPerWeight;
/*     */   private String comment;
/*     */   private User username;
/*     */   private Long contractId;
			private Long stock_id;
			
			
public Long getStock_id() {
				return stock_id;
			}
			public void setStock_id(Long stock_id) {
				this.stock_id = stock_id;
			}
/*     */   
/*     */   public Double getPackPerWeight()
/*     */   {
/*  30 */     return this.packPerWeight;
/*     */   }
/*     */   
/*     */   public void setPackPerWeight(Double packPerWeight) {
/*  34 */     this.packPerWeight = packPerWeight;
/*     */   }
/*     */   
/*     */   public Long getLoadCompanyId() {
/*  38 */     return this.loadCompanyId;
/*     */   }
/*     */   
/*     */   public void setLoadCompanyId(Long loadCompanyId) {
/*  42 */     this.loadCompanyId = loadCompanyId;
/*     */   }
/*     */   
/*     */   public Long getPack() {
/*  46 */     return this.pack;
/*     */   }
/*     */   
/*     */   public void setPack(Long pack) {
/*  50 */     this.pack = pack;
/*     */   }
/*     */   
/*     */   public String getComment() {
/*  54 */     return this.comment;
/*     */   }
/*     */   
/*     */   public void setComment(String comment) {
/*  58 */     this.comment = comment;
/*     */   }
/*     */   
/*     */   public Double getAmount() {
/*  62 */     return this.amount;
/*     */   }
/*     */   
/*     */   public void setAmount(Double amount) {
/*  66 */     this.amount = amount;
/*     */   }
/*     */   
/*     */   public Long getStoreId() {
/*  70 */     return this.storeId;
/*     */   }
/*     */   
/*     */   public void setStoreId(Long storeId) {
/*  74 */     this.storeId = storeId;
/*     */   }
/*     */   
/*     */   public Long getCargoId() {
/*  78 */     return this.cargoId;
/*     */   }
/*     */   
/*     */   public void setCargoId(Long cargoId) {
/*  82 */     this.cargoId = cargoId;
/*     */   }
/*     */   
/*     */   public Long getDoorId() {
/*  86 */     return this.doorId;
/*     */   }
/*     */   
/*     */   public void setDoorId(Long doorId) {
/*  90 */     this.doorId = doorId;
/*     */   }
/*     */   
/*     */   public Double getDeductAmount() {
/*  94 */     return this.deductAmount;
/*     */   }
/*     */   
/*     */   public void setDeductAmount(Double deductAmount) {
/*  98 */     this.deductAmount = deductAmount;
/*     */   }
/*     */   
/*     */   public Long getContractId() {
/* 102 */     return this.contractId;
/*     */   }
/*     */   
/*     */   public void setContractId(Long contractId) {
/* 106 */     this.contractId = contractId;
/*     */   }
/*     */   
/*     */   public User getUsername() {
/* 110 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(User username) {
/* 114 */     this.username = username;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\WeightDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */