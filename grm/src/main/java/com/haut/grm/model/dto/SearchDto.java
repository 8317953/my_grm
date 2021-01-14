/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import java.util.Date;
/*    */ import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
/*    */ import org.springframework.format.annotation.DateTimeFormat;
/*    */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*    */ 
/*    */ public class SearchDto
/*    */   extends DataTablesInput
/*    */ {
/*    */   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
/*    */   private Date queryStart;
/*    */   @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
/*    */   private Date queryEnd;
/*    */   
/*    */   public Date getQueryStart()
/*    */   {
/* 18 */     return this.queryStart;
/*    */   }
/*    */   
/*    */   public void setQueryStart(Date queryStart) {
/* 22 */     this.queryStart = queryStart;
/*    */   }
/*    */   
/*    */   public Date getQueryEnd() {
/* 26 */     return this.queryEnd;
/*    */   }
/*    */   
/*    */   public void setQueryEnd(Date queryEnd) {
/* 30 */     this.queryEnd = queryEnd;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\SearchDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */