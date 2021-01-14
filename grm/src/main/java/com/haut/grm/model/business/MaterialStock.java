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
/*    */ @Table(name="gb_material_stock")
/*    */ public class MaterialStock
/*    */   extends AbstractBusiness
/*    */ {
/*    */   private static final long serialVersionUID = -7317631990328570706L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="type_id")
/*    */   @Description("物料类型")
/*    */   private MaterialType type;
/*    */   @Column(name="amount")
/*    */   @Description("数量 (个)")
/*    */   private Integer amount;
/*    */   
/*    */   public MaterialType getType()
/*    */   {
/* 34 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(MaterialType type) {
/* 38 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Integer getAmount() {
/* 42 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Integer amount) {
/* 46 */     this.amount = amount;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\MaterialStock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */