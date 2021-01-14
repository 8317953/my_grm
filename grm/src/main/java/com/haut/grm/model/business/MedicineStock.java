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
/*    */ @Entity
/*    */ @Table(name="gb_medicine_stock")
/*    */ public class MedicineStock
/*    */   extends AbstractBusiness
/*    */ {
/*    */   private static final long serialVersionUID = 7138295140590940554L;
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
/*    */   
/*    */   public MedicineType getType()
/*    */   {
/* 39 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(MedicineType type) {
/* 43 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Double getAmount() {
/* 47 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Double amount) {
/* 51 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public Scale getScale() {
/* 55 */     return this.scale;
/*    */   }
/*    */   
/*    */   public void setScale(Scale scale) {
/* 59 */     this.scale = scale;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\MedicineStock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */