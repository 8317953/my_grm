/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import java.util.Date;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import javax.persistence.Temporal;
/*    */ import javax.persistence.TemporalType;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="ies_vehicle_license")
/*    */ public class VehicleLicense
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -634867651165127890L;
/*    */   @Column(name="plate")
/*    */   private String plate;
/*    */   @Column(name="image_path")
/*    */   private String imagePath;
/*    */   @Column(name="time")
/*    */   @Temporal(TemporalType.TIMESTAMP)
/*    */   private Date time;
/*    */   
/*    */   public String getPlate()
/*    */   {
/* 33 */     return this.plate;
/*    */   }
/*    */   
/*    */   public void setPlate(String plate) {
/* 37 */     this.plate = plate;
/*    */   }
/*    */   
/*    */   public String getImagePath() {
/* 41 */     return this.imagePath;
/*    */   }
/*    */   
/*    */   public void setImagePath(String imagePath) {
/* 45 */     this.imagePath = imagePath;
/*    */   }
/*    */   
/*    */   public Date getTime() {
/* 49 */     return this.time;
/*    */   }
/*    */   
/*    */   public void setTime(Date time) {
/* 53 */     this.time = time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\VehicleLicense.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */