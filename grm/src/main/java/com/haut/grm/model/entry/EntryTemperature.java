/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.EntryTemperatureView;
/*    */ import com.haut.grm.model.base.AbstractEntry;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="entry_temperature")
/*    */ public class EntryTemperature
/*    */   extends AbstractEntry
/*    */ {
/*    */   private static final long serialVersionUID = 7177063532940811160L;
/*    */   @Column(name="data")
/*    */   @JsonView({Views.EntryTemperatureView.class})
/*    */   private String data;
/*    */   @Column(name="is_auto")
/*    */   @JsonView({Views.EntryTemperatureView.class})
/*    */   private Boolean isAuto;
/*    */   
/*    */   public String getData()
/*    */   {
/* 26 */     return this.data;
/*    */   }
/*    */   
/*    */   public void setData(String data) {
/* 30 */     this.data = data;
/*    */   }
/*    */   
/*    */   public Boolean getIsAuto() {
/* 34 */     return this.isAuto;
/*    */   }
/*    */   
/*    */   public void setIsAuto(Boolean isAuto) {
/* 38 */     this.isAuto = isAuto;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\EntryTemperature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */