/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.SmsTemplateView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="meta_sms_template")
/*    */ public class SmsTemplate
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -6351947059946675808L;
/*    */   public static final long THE_ID = 1L;
/*    */   @Column(name="safety_alert")
/*    */   @JsonView({Views.SmsTemplateView.class})
/*    */   private String safetyAlert;
/*    */   @Column(name="measure_alert")
/*    */   @JsonView({Views.SmsTemplateView.class})
/*    */   private String measureAlert;
/*    */   @Column(name="door_alert")
/*    */   @JsonView({Views.SmsTemplateView.class})
/*    */   private String doorAlert;
/*    */   
/*    */   public String getSafetyAlert()
/*    */   {
/* 32 */     return this.safetyAlert;
/*    */   }
/*    */   
/*    */   public void setSafetyAlert(String safetyAlert) {
/* 36 */     this.safetyAlert = safetyAlert;
/*    */   }
/*    */   
/*    */   public String getMeasureAlert() {
/* 40 */     return this.measureAlert;
/*    */   }
/*    */   
/*    */   public void setMeasureAlert(String measureAlert) {
/* 44 */     this.measureAlert = measureAlert;
/*    */   }
/*    */   
/*    */   public String getDoorAlert() {
/* 48 */     return this.doorAlert;
/*    */   }
/*    */   
/*    */   public void setDoorAlert(String doorAlert) {
/* 52 */     this.doorAlert = doorAlert;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\SmsTemplate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */