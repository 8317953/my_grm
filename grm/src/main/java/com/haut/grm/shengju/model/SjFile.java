/*    */ package com.haut.grm.shengju.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/*    */ import com.haut.grm.shengju.util.SjNumberSerializer;
/*    */ import java.math.BigDecimal;
/*    */ import org.springframework.data.rest.core.annotation.Description;
/*    */ 
/*    */ public class SjFile
/*    */ {
/*    */   @Description("文件")
/*    */   private byte[] WJNR;
/*    */   @Description("文件名称")
/*    */   private String MC;
/*    */   @Description("文件大小")
/*    */   private BigDecimal DX;
/*    */   
/*    */   @JsonProperty("wjnr")
/*    */   public byte[] getWJNR()
/*    */   {
/* 21 */     return this.WJNR;
/*    */   }
/*    */   
/* 24 */   public void setWJNR(byte[] wJNR) { this.WJNR = wJNR; }
/*    */   
/*    */   @JsonProperty("mc")
/*    */   public String getMC() {
/* 28 */     return this.MC;
/*    */   }
/*    */   
/* 31 */   public void setMC(String mC) { this.MC = mC; }
/*    */   
/*    */   @JsonSerialize(using=SjNumberSerializer.class)
/*    */   @JsonProperty("dx")
/*    */   public BigDecimal getDX() {
/* 36 */     return this.DX;
/*    */   }
/*    */   
/* 39 */   public void setDX(BigDecimal dX) { this.DX = dX; }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */