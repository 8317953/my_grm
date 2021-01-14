/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="meta_stage")
/*    */ public class Stage
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -5395160010550157371L;
/*    */   public static final int INIT = 1;
/*    */   @Column(name="name")
/*    */   protected String name;
/*    */   @Column(name="value")
/*    */   protected Integer value;
/*    */   @Column(name="next")
/*    */   protected Integer next;
/*    */   @Column(name="previous")
/*    */   protected Integer previous;
/*    */   
/*    */   public String getName()
/*    */   {
/* 33 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 37 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Integer getValue() {
/* 41 */     return this.value;
/*    */   }
/*    */   
/*    */   public void setValue(Integer value) {
/* 45 */     this.value = value;
/*    */   }
/*    */   
/*    */   public Integer getNext() {
/* 49 */     return this.next;
/*    */   }
/*    */   
/*    */   public void setNext(Integer next) {
/* 53 */     this.next = next;
/*    */   }
/*    */   
/*    */   public Integer getPrevious() {
/* 57 */     return this.previous;
/*    */   }
/*    */   
/*    */   public void setPrevious(Integer previous) {
/* 61 */     this.previous = previous;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\Stage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */