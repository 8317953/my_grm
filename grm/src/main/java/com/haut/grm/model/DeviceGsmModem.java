/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.DeviceGsmModemView;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="device_gsm_modem")
/*    */ public class DeviceGsmModem
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 3718062483759260035L;
/*    */   public static final long THE_ID = 1L;
/*    */   @Column(name="port")
/*    */   @JsonView({Views.DeviceGsmModemView.class})
/*    */   private String port;
/*    */   @Column(name="manufacture")
/*    */   @JsonView({Views.DeviceGsmModemView.class})
/*    */   private String manufacture;
/*    */   @Column(name="model")
/*    */   @JsonView({Views.DeviceGsmModemView.class})
/*    */   private String model;
/*    */   @Column(name="baud_rate")
/*    */   @JsonView({Views.DeviceGsmModemView.class})
/*    */   private Integer baudRate;
/*    */   
/*    */   public String getPort()
/*    */   {
/* 36 */     return this.port;
/*    */   }
/*    */   
/*    */   public void setPort(String port) {
/* 40 */     this.port = port;
/*    */   }
/*    */   
/*    */   public String getManufacture() {
/* 44 */     return this.manufacture;
/*    */   }
/*    */   
/*    */   public void setManufacture(String manufacture) {
/* 48 */     this.manufacture = manufacture;
/*    */   }
/*    */   
/*    */   public String getModel() {
/* 52 */     return this.model;
/*    */   }
/*    */   
/*    */   public void setModel(String model) {
/* 56 */     this.model = model;
/*    */   }
/*    */   
/*    */   public Integer getBaudRate() {
/* 60 */     return this.baudRate;
/*    */   }
/*    */   
/*    */   public void setBaudRate(Integer baudRate) {
/* 64 */     this.baudRate = baudRate;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\DeviceGsmModem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */