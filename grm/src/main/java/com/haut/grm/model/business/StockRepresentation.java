/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="gb_stock_representation")
/*    */ public class StockRepresentation
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -4682325368315970668L;
/*    */   @Column(name="cargo_name")
/*    */   private String cargoName;
/*    */   @Column(name="code")
/*    */   private String code;
/*    */   @Column(name="business_key")
/*    */   protected String businessKey;
/*    */   @Column(name="input_time")
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   protected Date inputTime;
/*    */   @Column(name="is_current")
/*    */   private Boolean isCurrent;
/*    */   
/*    */   public Boolean getIsCurrent()
/*    */   {
/* 39 */     return this.isCurrent;
/*    */   }
/*    */   
/*    */   public void setIsCurrent(Boolean isCurrent) {
/* 43 */     this.isCurrent = isCurrent;
/*    */   }
/*    */   
/*    */   public String getCargoName() {
/* 47 */     return this.cargoName;
/*    */   }
/*    */   
/*    */   public void setCargoName(String cargoName) {
/* 51 */     this.cargoName = cargoName;
/*    */   }
/*    */   
/*    */   public String getCode() {
/* 55 */     return this.code;
/*    */   }
/*    */   
/*    */   public void setCode(String code) {
/* 59 */     this.code = code;
/*    */   }
/*    */   
/*    */   public String getBusinessKey() {
/* 63 */     return this.businessKey;
/*    */   }
/*    */   
/*    */   public void setBusinessKey(String businessKey) {
/* 67 */     this.businessKey = businessKey;
/*    */   }
/*    */   
/*    */   public Date getInputTime() {
/* 71 */     return this.inputTime;
/*    */   }
/*    */   
/*    */   public void setInputTime(Date inputTime) {
/* 75 */     this.inputTime = inputTime;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockRepresentation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */