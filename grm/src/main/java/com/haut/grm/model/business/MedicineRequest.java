/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractBusiness;
/*    */ import com.haut.grm.model.type.MedicineType;
/*    */ import com.haut.grm.model.type.Scale;
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
/*    */ 
/*    */ @Entity
/*    */ @Table(name="gb_medicine_request")
/*    */ public class MedicineRequest
/*    */   extends AbstractBusiness
/*    */ {
/*    */   private static final long serialVersionUID = -5917642688953911086L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="type_id")
/*    */   @Description("药品类型")
/*    */   private MedicineType type;
/*    */   @Column(name="amount")
/*    */   @Description("数量")
/*    */   private Double amount;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="scale_id")
/*    */   @Description("计量单位")
/*    */   private Scale scale;
/*    */   @Column(name="purpose")
/*    */   @Description("用途")
/*    */   private String purpose;
/*    */   
/*    */   public MedicineType getType()
/*    */   {
/* 43 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(MedicineType type) {
/* 47 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Double getAmount() {
/* 51 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Double amount) {
/* 55 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public Scale getScale() {
/* 59 */     return this.scale;
/*    */   }
/*    */   
/*    */   public void setScale(Scale scale) {
/* 63 */     this.scale = scale;
/*    */   }
/*    */   
/*    */   public String getPurpose() {
/* 67 */     return this.purpose;
/*    */   }
/*    */   
/*    */   public void setPurpose(String purpose) {
/* 71 */     this.purpose = purpose;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\MedicineRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */