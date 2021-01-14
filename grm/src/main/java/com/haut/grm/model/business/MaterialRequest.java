/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractBusiness;
/*    */ import com.haut.grm.model.type.MaterialType;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ import org.springframework.data.rest.core.annotation.Description;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="gb_material_request")
/*    */ public class MaterialRequest
/*    */   extends AbstractBusiness
/*    */ {
/*    */   private static final long serialVersionUID = -5178260486681131517L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="type_id")
/*    */   @Description("物料类型")
/*    */   private MaterialType type;
/*    */   @Column(name="amount")
/*    */   @Description("数量 (个)")
/*    */   private Integer amount;
/*    */   @Column(name="purpose")
/*    */   @Description("用途")
/*    */   private String purpose;
/*    */   
/*    */   public MaterialType getType()
/*    */   {
/* 37 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(MaterialType type) {
/* 41 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Integer getAmount() {
/* 45 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Integer amount) {
/* 49 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public String getPurpose() {
/* 53 */     return this.purpose;
/*    */   }
/*    */   
/*    */   public void setPurpose(String purpose) {
/* 57 */     this.purpose = purpose;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\MaterialRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */