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
/*    */ @Entity
/*    */ @Table(name="Wendu")
/*    */ public class Wendu
/*    */ {
/*    */   @Id
/*    */   @Column(name="序号")
/*    */   private String id;
/*    */   @Column(name="仓房名")
/*    */   private String codeId;
/*    */   @Column(name="温度")
/*    */   private Integer temperature;
/*    */   @Column(name="时间")
/*    */   private Date time;
/*    */   
/*    */   public String getId()
/*    */   {
/* 28 */     return this.id;
/*    */   }
/*    */   
/*    */   public void setId(String id) {
/* 32 */     this.id = id;
/*    */   }
/*    */   
/*    */   public Integer getTemperature() {
/* 36 */     return this.temperature;
/*    */   }
/*    */   
/*    */   public void setTemperature(Integer temperature) {
/* 40 */     this.temperature = temperature;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 44 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 48 */     this.time = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\Wendu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */