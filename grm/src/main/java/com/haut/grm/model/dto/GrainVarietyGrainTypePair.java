/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import com.haut.grm.model.standard.code.GrainVariety;
/*    */ import com.haut.grm.model.type.GrainType;
/*    */ 
/*    */ 
/*    */ public class GrainVarietyGrainTypePair
/*    */ {
/*    */   private GrainVariety gv;
/*    */   private GrainType gt;
/*    */   
/*    */   public GrainVarietyGrainTypePair(GrainVariety gv, GrainType gt)
/*    */   {
/* 14 */     this.gv = gv;
/* 15 */     this.gt = gt;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 20 */     int prime = 31;
/* 21 */     int result = 1;
/* 22 */     result = 31 * result + (this.gt == null ? 0 : this.gt.hashCode());
/* 23 */     result = 31 * result + (this.gv == null ? 0 : this.gv.hashCode());
/* 24 */     return result;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 29 */     if (this == obj)
/* 30 */       return true;
/* 31 */     if (obj == null)
/* 32 */       return false;
/* 33 */     if (getClass() != obj.getClass())
/* 34 */       return false;
/* 35 */     GrainVarietyGrainTypePair other = (GrainVarietyGrainTypePair)obj;
/* 36 */     if (this.gt == null) {
/* 37 */       if (other.gt != null)
/* 38 */         return false;
/* 39 */     } else if (!this.gt.equals(other.gt))
/* 40 */       return false;
/* 41 */     if (this.gv == null) {
/* 42 */       if (other.gv != null)
/* 43 */         return false;
/* 44 */     } else if (!this.gv.equals(other.gv))
/* 45 */       return false;
/* 46 */     return true;
/*    */   }
/*    */   
/*    */   public GrainVariety getGv() {
/* 50 */     return this.gv;
/*    */   }
/*    */   
/*    */   public void setGv(GrainVariety gv) {
/* 54 */     this.gv = gv;
/*    */   }
/*    */   
/*    */   public GrainType getGt() {
/* 58 */     return this.gt;
/*    */   }
/*    */   
/*    */   public void setGt(GrainType gt) {
/* 62 */     this.gt = gt;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\GrainVarietyGrainTypePair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */