/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.JoinColumn;
/*    */ import javax.persistence.ManyToOne;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="ies_camera_image")
/*    */ public class IesCameraImage
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 2540633763568605610L;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="registry_id")
/*    */   private IesCameraRegistry registry;
/*    */   @ManyToOne
/*    */   @JoinColumn(name="grain_traffic_id")
/*    */   private GrainTraffic grainTraffic;
/*    */   @Column(name="image_path")
/*    */   private String imagePath;
/*    */   
/*    */   public IesCameraRegistry getRegistry()
/*    */   {
/* 32 */     return this.registry;
/*    */   }
/*    */   
/*    */   public void setRegistry(IesCameraRegistry registry) {
/* 36 */     this.registry = registry;
/*    */   }
/*    */   
/*    */   public GrainTraffic getGrainTraffic() {
/* 40 */     return this.grainTraffic;
/*    */   }
/*    */   
/*    */   public void setGrainTraffic(GrainTraffic grainTraffic) {
/* 44 */     this.grainTraffic = grainTraffic;
/*    */   }
/*    */   
/*    */   public String getImagePath() {
/* 48 */     return this.imagePath;
/*    */   }
/*    */   
/*    */   public void setImagePath(String imagePath) {
/* 52 */     this.imagePath = imagePath;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\IesCameraImage.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */