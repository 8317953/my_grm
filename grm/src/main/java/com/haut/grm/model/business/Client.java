/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*    */ import com.haut.grm.json.view.Views.ClientView;
/*    */ import com.haut.grm.model.base.AbstractBusiness;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ import org.springframework.data.rest.core.annotation.Description;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="gb_client")
/*    */ public class Client
/*    */   extends AbstractBusiness
/*    */ {
/*    */   private static final long serialVersionUID = -7147745030788512895L;
/*    */   @Column(name="name")
/*    */   @JsonView({Views.ClientView.class})
/*    */   @Description("名称")
/*    */   private String name;
/*    */   @Column(name="telephone")
/*    */   @Description("电话")
/*    */   @JsonView({Views.ClientView.class})
/*    */   private String telephone;
/*    */   @Column(name="address")
/*    */   @Description("地址")
/*    */   @JsonView({Views.ClientView.class})
/*    */   private String address;
/*    */   
/*    */   public String getName()
/*    */   {
/* 38 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 42 */     this.name = name;
/*    */   }
/*    */   
/*    */   public String getTelephone() {
/* 46 */     return this.telephone;
/*    */   }
/*    */   
/*    */   public void setTelephone(String telephone) {
/* 50 */     this.telephone = telephone;
/*    */   }
/*    */   
/*    */   public String getAddress() {
/* 54 */     return this.address;
/*    */   }
/*    */   
/*    */   public void setAddress(String address) {
/* 58 */     this.address = address;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\Client.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */