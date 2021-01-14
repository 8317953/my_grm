/*    */ package com.haut.grm.shengju.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonProperty;
/*    */ import com.fasterxml.jackson.databind.annotation.JsonSerialize;
/*    */ import com.haut.grm.shengju.util.SjNumberSerializer;
/*    */ import java.math.BigDecimal;
/*    */ import org.springframework.data.rest.core.annotation.Description;
/*    */ 
/*    */ 
/*    */ public class SjTemperaturePoint
/*    */ {
/*    */   @Description("测温杆编号")
/*    */   String CWGBH;
/*    */   @Description("测温点编号")
/*    */   String CWDBH;
/*    */   @Description("X坐标")
/*    */   Integer X;
/*    */   @Description("Y坐标")
/*    */   Integer Y;
/*    */   @Description("Z坐标")
/*    */   Integer Z;
/*    */   @Description("温度值")
/*    */   BigDecimal WDZ;
/*    */   @Description("是否删除")
/* 25 */   Integer SFSC = Integer.valueOf(0);
/*    */   
/*    */   @JsonProperty("cwgbh")
/* 28 */   public String getCWGBH() { return this.CWGBH; }
/*    */   
/*    */   public void setCWGBH(String cWGBH) {
/* 31 */     this.CWGBH = cWGBH;
/*    */   }
/*    */   
/*    */   @JsonProperty("cwdbh")
/* 35 */   public String getCWDBH() { return this.CWDBH; }
/*    */   
/*    */   public void setCWDBH(String cWDBH) {
/* 38 */     this.CWDBH = cWDBH;
/*    */   }
/*    */   
/*    */   @JsonProperty("x")
/* 42 */   public Integer getX() { return this.X; }
/*    */   
/*    */   public void setX(Integer x) {
/* 45 */     this.X = x;
/*    */   }
/*    */   
/*    */   @JsonProperty("y")
/* 49 */   public Integer getY() { return this.Y; }
/*    */   
/*    */   public void setY(Integer y) {
/* 52 */     this.Y = y;
/*    */   }
/*    */   
/*    */   @JsonProperty("z")
/* 56 */   public Integer getZ() { return this.Z; }
/*    */   
/*    */   public void setZ(Integer z) {
/* 59 */     this.Z = z;
/*    */   }
/*    */   
/*    */   @JsonSerialize(using=SjNumberSerializer.class)
/*    */   @JsonProperty("wdz")
/* 64 */   public BigDecimal getWDZ() { return this.WDZ; }
/*    */   
/*    */   public void setWDZ(BigDecimal wDZ) {
/* 67 */     this.WDZ = wDZ;
/*    */   }
/*    */   
/*    */   @JsonProperty("sfsc")
/* 71 */   public Integer getSFSC() { return this.SFSC; }
/*    */   
/*    */   public void setSFSC(Integer sFSC) {
/* 74 */     this.SFSC = sFSC;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\SjTemperaturePoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */