/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.AbstractEntity;
/*    */ import javax.persistence.Column;
/*    */ import javax.persistence.Entity;
/*    */ import javax.persistence.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Entity
/*    */ @Table(name="gb_data")
/*    */ public class BusinessData
/*    */   extends AbstractEntity<Long>
/*    */ {
/*    */   private static final long serialVersionUID = 7051817529359914769L;
/*    */   @Column(name="url")
/*    */   private String url;
/*    */   @Column(name="content")
/*    */   private String content;
/*    */   @Column(name="business_key")
/*    */   private String businessKey;
/*    */   
/*    */   public String getUrl()
/*    */   {
/* 28 */     return this.url;
/*    */   }
/*    */   
/*    */   public void setUrl(String url) {
/* 32 */     this.url = url;
/*    */   }
/*    */   
/*    */   public String getContent() {
/* 36 */     return this.content;
/*    */   }
/*    */   
/*    */   public void setContent(String content) {
/* 40 */     this.content = content;
/*    */   }
/*    */   
/*    */   public String getBusinessKey() {
/* 44 */     return this.businessKey;
/*    */   }
/*    */   
/*    */   public void setBusinessKey(String businessKey) {
/* 48 */     this.businessKey = businessKey;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\BusinessData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */