/*    */ package com.haut.grm.qt.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="Nrecord")
/*    */ public class Nrecord
/*    */ {
/*    */   @Id
/*    */   @Column(name="序号")
/*    */   private String id;
/*    */   @Column(name="仓房名")
/*    */   private String codeId;
/*    */   @Column(name="浓度")
/*    */   private Float nd;
/*    */   @Column(name="副氧浓度")
/*    */   private Float fynd;
/*    */   @Column(name="时间")
/*    */   private Date time;
/*    */   
/*    */   public String getId()
/*    */   {
/* 31 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 35 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Float getNd() {
/* 39 */     return this.nd;
/*    */   }
/*    */   
/*    */   public void setNd(Float nd) {
/* 43 */     this.nd = nd;
/*    */   }
/*    */   
/*    */   public Float getFynd() {
/* 47 */     return this.fynd;
/*    */   }
/*    */   
/*    */   public void setFynd(Float fynd) {
/* 51 */     this.fynd = fynd;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 55 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 59 */     this.time = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\Nrecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */