/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import com.haut.grm.model.standard.code.GrainVariety;
/*    */ import com.haut.grm.model.type.PackageType;
/*    */ 
/*    */ public class GrainVarietyPackageTypePair
/*    */ {
/*    */   private GrainVariety gv;
/*    */   private PackageType pt;
/*    */   
/*    */   public GrainVariety getGv()
/*    */   {
/* 13 */     return this.gv;
/*    */   }
/*    */   
/*    */   public void setGv(GrainVariety gv) {
/* 17 */     this.gv = gv;
/*    */   }
/*    */   
/*    */   public PackageType getPt() {
/* 21 */     return this.pt;
/*    */   }
/*    */   
/*    */   public void setPt(PackageType pt) {
/* 25 */     this.pt = pt;
/*    */   }
/*    */   
/*    */   public GrainVarietyPackageTypePair(GrainVariety gv, PackageType pt)
/*    */   {
/* 30 */     this.gv = gv;
/* 31 */     this.pt = pt;
/*    */   }
/*    */   
/*    */   public int hashCode()
/*    */   {
/* 36 */     int prime = 31;
/* 37 */     int result = 1;
/* 38 */     result = 31 * result + (this.gv == null ? 0 : this.gv.hashCode());
/* 39 */     result = 31 * result + (this.pt == null ? 0 : this.pt.hashCode());
/* 40 */     return result;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj)
/*    */   {
/* 45 */     if (this == obj)
/* 46 */       return true;
/* 47 */     if (obj == null)
/* 48 */       return false;
/* 49 */     if (getClass() != obj.getClass())
/* 50 */       return false;
/* 51 */     GrainVarietyPackageTypePair other = (GrainVarietyPackageTypePair)obj;
/* 52 */     if (this.gv == null) {
/* 53 */       if (other.gv != null)
/* 54 */         return false;
/* 55 */     } else if (!this.gv.equals(other.gv))
/* 56 */       return false;
/* 57 */     if (this.pt == null) {
/* 58 */       if (other.pt != null)
/* 59 */         return false;
/* 60 */     } else if (!this.pt.equals(other.pt))
/* 61 */       return false;
/* 62 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\GrainVarietyPackageTypePair.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */