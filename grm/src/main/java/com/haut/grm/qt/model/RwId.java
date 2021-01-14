/*    */ package com.haut.grm.qt.model;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class RwId implements java.io.Serializable
/*    */ {
/*    */   private static final long serialVersionUID = -6340975771332723393L;
/*    */   private String codeId;
/*    */   private Date time;
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 13 */     int prime = 31;
/* 14 */     int result = 1;
/* 15 */     result = 31 * result + (this.codeId == null ? 0 : this.codeId.hashCode());
/* 16 */     result = 31 * result + (this.time == null ? 0 : this.time.hashCode());
/* 17 */     return result;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj) {
/* 21 */     if (this == obj)
/* 22 */       return true;
/* 23 */     if (obj == null)
/* 24 */       return false;
/* 25 */     if (getClass() != obj.getClass())
/* 26 */       return false;
/* 27 */     RwId other = (RwId)obj;
/* 28 */     if (this.time == null) {
/* 29 */       if (other.time != null)
/* 30 */         return false;
/* 31 */     } else if (!this.time.equals(other.time))
/* 32 */       return false;
/* 33 */     if (this.codeId == null) {
/* 34 */       if (other.codeId != null)
/* 35 */         return false;
/* 36 */     } else if (!this.codeId.equals(other.codeId))
/* 37 */       return false;
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\RwId.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */