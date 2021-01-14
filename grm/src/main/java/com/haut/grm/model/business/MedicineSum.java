/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.type.MedicineType;
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
/*    */ @Table(name="gb_medicine_sum")
/*    */ public class MedicineSum
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 149389420796929955L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="type_id")
/*    */   private MedicineType type;
/*    */   @Column(name="in_amount")
/*    */   private Double in;
/*    */   @Column(name="out_amount")
/*    */   private Double out;
/*    */   @Column(name="total")
/*    */   private Double total;
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
/*    */   public MedicineType getType() {
/* 46 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(MedicineType type) {
/* 50 */     this.type = type;
/*    */   }
/*    */   
/*    */   public Double getIn() {
/* 54 */     return this.in;
/*    */   }
/*    */   
/*    */   public void setIn(Double in) {
/* 58 */     this.in = in;
/*    */   }
/*    */   
/*    */   public Double getOut() {
/* 62 */     return this.out;
/*    */   }
/*    */   
/*    */   public void setOut(Double out) {
/* 66 */     this.out = out;
/*    */   }
/*    */   
/*    */   public Double getTotal() {
/* 70 */     return this.total;
/*    */   }
/*    */   
/*    */   public void setTotal(Double total) {
/* 74 */     this.total = total;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\MedicineSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */