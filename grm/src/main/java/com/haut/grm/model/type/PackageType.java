/*    */ package com.haut.grm.model.type;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.BaseTypeView;
/*    */ import com.haut.grm.model.base.AbstractType;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="bt_package_type")
/*    */ public class PackageType
/*    */   extends AbstractType
/*    */ {
/*    */   private static final long serialVersionUID = -7717214013791325725L;
/*    */   @JsonView({Views.BaseTypeView.class})
/*    */   @Column(name="short_name")
/*    */   protected String shortName;
/*    */   @JsonView({Views.BaseTypeView.class})
/*    */   @Column(name="size")
/*    */   protected String size;
/*    */   
/*    */   public String getShortName()
/*    */   {
/* 29 */     return this.shortName;
/*    */   }
/*    */   
/*    */   public void setShortName(String shortName) {
/* 33 */     this.shortName = shortName;
/*    */   }
/*    */   
/*    */   public String getSize() {
/* 37 */     return this.size;
/*    */   }
/*    */   
/*    */   public void setSize(String size) {
/* 41 */     this.size = size;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\type\PackageType.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */