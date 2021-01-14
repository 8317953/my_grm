/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.type.MaterialType;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
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
/*    */ @Table(name="gb_material_sum")
/*    */ public class MaterialSum
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -594358872062578140L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="type_id")
/*    */   private MaterialType type;
/*    */   @Column(name="in_amount")
/*    */   private Long in;
/*    */   @Column(name="out_amount")
/*    */   private Long out;
/*    */   @Column(name="total")
/*    */   private Long total;
/*    */   @Column(name="name")
/*    */   private String name;
/*    */   
/*    */   public String getName()
/*    */   {
/* 38 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 42 */     this.name = name;
/*    */   }
/*    */   
/*    */   public MaterialType getType() {
/* 46 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(MaterialType type) {
/* 50 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Long getIn() {
/* 54 */     return this.in;
/*    */   }
/*    */   
/*    */   public void setIn(Long in) {
/* 58 */     this.in = in;
/*    */   }
/*    */   
/*    */   public Long getOut() {
/* 62 */     return this.out;
/*    */   }
/*    */   
/*    */   public void setOut(Long out) {
/* 66 */     this.out = out;
/*    */   }
/*    */   
/*    */   public Long getTotal() {
/* 70 */     return this.total;
/*    */   }
/*    */   
/*    */   public void setTotal(Long total) {
/* 74 */     this.total = total;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\MaterialSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */