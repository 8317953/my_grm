/*     */ package com.haut.grm.shengju.model;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonFormat;
/*     */ import com.fasterxml.jackson.annotation.JsonFormat.Shape;
/*     */ import com.fasterxml.jackson.annotation.JsonProperty;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RequestEntity<T>
/*     */ {
/*     */   private String requestId;
/*     */   private String accessToken;
/*     */   private String ver;
/*     */   private String username;
/*     */   private String name;
/*     */   @JsonFormat(shape=JsonFormat.Shape.NUMBER)
/*     */   private Date sendTime;
/*     */   private String type;
/*     */   private String signature;
/*     */   private List<T> datas;
/*     */   
/*     */   @JsonProperty("datas")
/*     */   public List<T> getData()
/*     */   {
/*  32 */     return this.datas;
/*     */   }
/*     */   
/*     */   public void setData(List<T> data) {
/*  36 */     this.datas = data;
/*     */   }
/*     */   
/*     */   public String getRequestId() {
/*  40 */     return this.requestId;
/*     */   }
/*     */   
/*     */   public void setRequestId(String requestId) {
/*  44 */     this.requestId = requestId;
/*     */   }
/*     */   
/*     */   public String getAccessToken() {
/*  48 */     return this.accessToken;
/*     */   }
/*     */   
/*     */   public void setAccessToken(String accessToken) {
/*  52 */     this.accessToken = accessToken;
/*     */   }
/*     */   
/*     */   @JsonProperty("VER")
/*     */   public String getVer() {
/*  57 */     return this.ver;
/*     */   }
/*     */   
/*     */   public void setVer(String ver) {
/*  61 */     this.ver = ver;
/*     */   }
/*     */   
/*     */   public String getUsername() {
/*  65 */     return this.username;
/*     */   }
/*     */   
/*     */   public void setUsername(String username) {
/*  69 */     this.username = username;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  73 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  77 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Date getSendTime() {
/*  81 */     return this.sendTime;
/*     */   }
/*     */   
/*     */   public void setSendTime(Date sendTime) {
/*  85 */     this.sendTime = sendTime;
/*     */   }
/*     */   
/*     */   public String getType() {
/*  89 */     return this.type;
/*     */   }
/*     */   
/*     */   public void setType(String type) {
/*  93 */     this.type = type;
/*     */   }
/*     */   
/*     */   public String getSignature() {
/*  97 */     return this.signature;
/*     */   }
/*     */   
/*     */   public void setSignature(String signature) {
/* 101 */     this.signature = signature;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\shengju\model\RequestEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */