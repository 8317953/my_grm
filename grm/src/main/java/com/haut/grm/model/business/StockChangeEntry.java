/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Embeddable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Embeddable
/*    */ public class StockChangeEntry
/*    */ {
/*    */   @Column(name="amount")
/*    */   private Long amount;
/*    */   @Column(name="pack")
/*    */   private Long pack;
/*    */   @Column(name="plate")
/*    */   private String plate;
/*    */   @Column(name="location")
/*    */   private String location;
/*    */   @Column(name="year")
/*    */   private String year;
/*    */   @Column(name="water")
/*    */   private Double water;
/*    */   @Column(name="impurity")
/*    */   private Double impurity;
/*    */   
/*    */   public Long getAmount()
/*    */   {
/* 31 */     return this.amount;
/*    */   }
/*    */   
/*    */   public void setAmount(Long amount) {
/* 35 */     this.amount = amount;
/*    */   }
/*    */   
/*    */   public Long getPack() {
/* 39 */     return this.pack;
/*    */   }
/*    */   
/*    */   public void setPack(Long pack) {
/* 43 */     this.pack = pack;
/*    */   }
/*    */   
/*    */   public String getPlate() {
/* 47 */     return this.plate;
/*    */   }
/*    */   
/*    */   public void setPlate(String plate) {
/* 51 */     this.plate = plate;
/*    */   }
/*    */   
/*    */   public Double getWater() {
/* 55 */     return this.water;
/*    */   }
/*    */   
/*    */   public void setWater(Double water) {
/* 59 */     this.water = water;
/*    */   }
/*    */   
/*    */   public Double getImpurity() {
/* 63 */     return this.impurity;
/*    */   }
/*    */   
/*    */   public void setImpurity(Double impurity) {
/* 67 */     this.impurity = impurity;
/*    */   }
/*    */   
/*    */   public String getLocation() {
/* 71 */     return this.location;
/*    */   }
/*    */   
/*    */   public void setLocation(String location) {
/* 75 */     this.location = location;
/*    */   }
/*    */   
/*    */   public String getYear() {
/* 79 */     return this.year;
/*    */   }
/*    */   
/*    */   public void setYear(String year) {
/* 83 */     this.year = year;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\StockChangeEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */