/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.DeviceCamera;
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import com.haut.grm.model.system.SystemTrafficModule;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="ies_camera_registry")
/*    */ public class IesCameraRegistry
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = -7941274845625904746L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="camera_id")
/*    */   private DeviceCamera camera;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="traffic_module_id")
/*    */   private SystemTrafficModule trafficModule;
/*    */   
/*    */   public DeviceCamera getCamera()
/*    */   {
/* 30 */     return this.camera;
/*    */   }
/*    */   
/*    */   public void setCamera(DeviceCamera camera) {
/* 34 */     this.camera = camera;
/*    */   }
/*    */   
/*    */   public SystemTrafficModule getTrafficModule() {
/* 38 */     return this.trafficModule;
/*    */   }
/*    */   
/*    */   public void setTrafficModule(SystemTrafficModule trafficModule) {
/* 42 */     this.trafficModule = trafficModule;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\IesCameraRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */