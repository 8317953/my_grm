/*    */ package com.haut.grm.model.dto;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class TemperatureDataDto implements Cloneable {
/*    */   private Double houseTemp;
/*    */   private Double houseMois;
/*    */   private Double outTemp;
/*    */   private Double outMois;
/*    */   private List<Double> data;
/*    */   private List<Double> rawData;
/*    */   
/* 13 */   public Object clone() throws CloneNotSupportedException { return super.clone(); }
/*    */   
/*    */   public List<Double> getRawData() {
/* 16 */     return this.rawData;
/*    */   }
/*    */   
/* 19 */   public void setRawData(List<Double> rawData) { this.rawData = rawData; }
/*    */   
/*    */   public Double getHouseTemp() {
/* 22 */     return this.houseTemp;
/*    */   }
/*    */   
/* 25 */   public void setHouseTemp(Double houseTemp) { this.houseTemp = houseTemp; }
/*    */   
/*    */   public Double getHouseMois() {
/* 28 */     return this.houseMois;
/*    */   }
/*    */   
/* 31 */   public void setHouseMois(Double houseMois) { this.houseMois = houseMois; }
/*    */   
/*    */   public List<Double> getData() {
/* 34 */     return this.data;
/*    */   }
/*    */   
/* 37 */   public void setData(List<Double> data) { this.data = data; }
/*    */   
/*    */   public Double getOutTemp() {
/* 40 */     return this.outTemp;
/*    */   }
/*    */   
/* 43 */   public void setOutTemp(Double outTemp) { this.outTemp = outTemp; }
/*    */   
/*    */   public Double getOutMois() {
/* 46 */     return this.outMois;
/*    */   }
/*    */   
/* 49 */   public void setOutMois(Double outMois) { this.outMois = outMois; }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\dto\TemperatureDataDto.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */