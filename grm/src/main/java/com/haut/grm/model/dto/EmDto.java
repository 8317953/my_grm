/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import java.util.Date;
/*    */ import java.util.List;
/*    */ import org.springframework.format.annotation.DateTimeFormat;
/*    */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EmDto
/*    */ {
/*    */   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
/*    */   private Date start;
/*    */   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
/*    */   private Date end;
/*    */   private List<Long> ids;
/*    */   
/*    */   public Date getStart()
/*    */   {
/* 20 */     return this.start;
/*    */   }
/*    */   
/*    */   public void setStart(Date start) {
/* 24 */     this.start = start;
/*    */   }
/*    */   
/*    */   public Date getEnd() {
/* 28 */     return this.end;
/*    */   }
/*    */   
/*    */   public void setEnd(Date end) {
/* 32 */     this.end = end;
/*    */   }
/*    */   
/*    */   public List<Long> getIds() {
/* 36 */     return this.ids;
/*    */   }
/*    */   
/*    */   public void setIds(List<Long> ids) {
/* 40 */     this.ids = ids;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\EmDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */