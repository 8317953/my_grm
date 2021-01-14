/*    */ package com.haut.grm.qt.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Id;
/*    */ import javax.persistence.IdClass;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="[Workstate]")
/*    */ @IdClass(RwId.class)
/*    */ public class Rwrecord
/*    */ {
/*    */   @Id
/*    */   @Column(name="[仓房名]")
/*    */   private String codeId;
/*    */   @Column(name="[类型]")
/*    */   private String type;
/*    */   @Column(name="[工作模式]")
/*    */   private String ms;
/*    */   @Column(name="[运行状态]")
/*    */   private String state;
/*    */   @Id
/*    */   @Column(name="[日期]")
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date time;
/*    */   
/*    */   public String getCodeId()
/*    */   {
/* 37 */     return this.codeId;
/*    */   }
/*    */   
/*    */   public void setCodeId(String codeId) {
/* 41 */     this.codeId = codeId;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 45 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 49 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getMs() {
/* 53 */     return this.ms;
/*    */   }
/*    */   
/*    */   public void setMs(String ms) {
/* 57 */     this.ms = ms;
/*    */   }
/*    */   
/*    */   public String getState() {
/* 61 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(String state) {
/* 65 */     this.state = state;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 69 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 73 */     this.time = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\Rwrecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */