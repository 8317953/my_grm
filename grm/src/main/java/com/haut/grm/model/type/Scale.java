/*    */ package com.haut.grm.model.type;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractType;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="bt_scale")
/*    */ public class Scale
/*    */   extends AbstractType
/*    */ {
/*    */   private static final long serialVersionUID = -7598369838819587937L;
/*    */   @Column(name="factor")
/*    */   private Long factor;
/*    */   
/*    */   public Long getFactor()
/*    */   {
/* 22 */     return this.factor;
/*    */   }
/*    */   
/*    */   public void setFactor(Long factor) {
/* 26 */     this.factor = factor;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\Scale.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */