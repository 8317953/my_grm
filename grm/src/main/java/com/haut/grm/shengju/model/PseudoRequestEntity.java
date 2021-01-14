/*    */ package com.haut.grm.shengju.model;
/*    */ 
/*    */ import com.fasterxml.jackson.annotation.JsonFormat;
/*    */ import com.fasterxml.jackson.annotation.JsonFormat.Shape;
/*    */ import com.fasterxml.jackson.annotation.JsonRawValue;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PseudoRequestEntity
/*    */ {
/*    */   private String requestId;
/*    */   private String accessToken;
/*    */   private String ver;
/*    */   private String username;
/*    */   private String name;
/*    */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*    */   private Date sendTime;
/*    */   private String type;
/*    */   private String signature;
/*    */   @JsonRawValue
/*    */   private String datas;
/*    */   
/*    */   public String getRequestId()
/*    */   {
/* 31 */     return this.requestId;
/*    */   }
/*    */   
/*    */   public void setRequestId(String requestId) {
/* 35 */     this.requestId = requestId;
/*    */   }
/*    */   
/*    */   public String getAccessToken() {
/* 39 */     return this.accessToken;
/*    */   }
/*    */   
/*    */   public void setAccessToken(String accessToken) {
/* 43 */     this.accessToken = accessToken;
/*    */   }
/*    */   
/*    */   public String getVer() {
/* 47 */     return this.ver;
/*    */   }
/*    */   
/*    */   public void setVer(String ver) {
/* 51 */     this.ver = ver;
/*    */   }
/*    */   
/*    */   public String getUsername() {
/* 55 */     return this.username;
/*    */   }
/*    */   
/*    */   public void setUsername(String username) {
/* 59 */     this.username = username;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 63 */     return this.name;
/*    */   }
/*    */   
/*    */   public void setName(String name) {
/* 67 */     this.name = name;
/*    */   }
/*    */   
/*    */   public Date getSendTime() {
/* 71 */     return this.sendTime;
/*    */   }
/*    */   
/*    */   public void setSendTime(Date sendTime) {
/* 75 */     this.sendTime = sendTime;
/*    */   }
/*    */   
/*    */   public String getType() {
/* 79 */     return this.type;
/*    */   }
/*    */   
/*    */   public void setType(String type) {
/* 83 */     this.type = type;
/*    */   }
/*    */   
/*    */   public String getSignature() {
/* 87 */     return this.signature;
/*    */   }
/*    */   
/*    */   public void setSignature(String signature) {
/* 91 */     this.signature = signature;
/*    */   }
/*    */   
/*    */   public String getDatas() {
/* 95 */     return this.datas;
/*    */   }
/*    */   
/*    */   public void setDatas(String datas) {
/* 99 */     this.datas = datas;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\PseudoRequestEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */