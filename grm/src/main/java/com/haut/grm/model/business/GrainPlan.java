/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractBusiness;
/*    */ import com.haut.grm.model.type.PlanType;
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
/*    */ @Entity
/*    */ @Table(name="gb_grain_plan")
/*    */ public class GrainPlan
/*    */   extends AbstractBusiness
/*    */ {
/*    */   private static final long serialVersionUID = -2571318885604648703L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="type_id")
/*    */   private PlanType type;
/*    */   @Column(name="name")
/*    */   private String name;
/*    */   @Column(name="content")
/*    */   private String content;
/*    */   
/*    */   public String getContent()
/*    */   {
/* 32 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 36 */     this.content = content;
/*    */   }
/*    */   
/*    */   public PlanType getType() {
/* 40 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(PlanType type) {
/* 44 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 48 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 52 */     this.name = name;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\GrainPlan.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */