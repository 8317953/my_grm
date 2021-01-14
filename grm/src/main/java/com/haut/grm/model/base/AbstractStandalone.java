/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.MappedSuperclass;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @MappedSuperclass
/*    */ public class AbstractStandalone
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 3198053862530588835L;
/*    */   @Column(name="name")
/*    */   protected String name;
/*    */   @Column(name="_order")
/*    */   protected Integer order;
/*    */   
/*    */   public Integer getOrder()
/*    */   {
/* 21 */     return this.order;
/*    */   }
/*    */   
/*    */   public void setOrder(Integer order) {
/* 25 */     this.order = order;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 29 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 33 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\AbstractStandalone.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */