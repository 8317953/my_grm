/*    */ package com.haut.grm.sdk;
/*    */ 
/*    */ 
/*    */ public class HkContext
/*    */ {
/*    */   public static final short SDK_PORT_DEFAULT = 8000;
/*    */   
/*    */   private String user;
/*    */   
/*    */   private String password;
/*    */   
/*    */   private String ipAddress;
/* 13 */   private short port = 8000;
/*    */   
/* 15 */   private long profileId = -1L;
/*    */   
/*    */ 
/*    */   public HkContext(String user, String password, String ipAddress, short port)
/*    */   {
/* 20 */     this.user = user;
/* 21 */     this.password = password;
/* 22 */     this.ipAddress = ipAddress;
/* 23 */     this.port = port;
/*    */   }
/*    */   
/*    */   public HkContext(String user, String password, String ipAddress)
/*    */   {
/* 28 */     this.user = user;
/* 29 */     this.password = password;
/* 30 */     this.ipAddress = ipAddress;
/*    */   }
/*    */   
/*    */   public HkContext() {}
/*    */   
/*    */   public String getUser()
/*    */   {
/* 37 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(String user) {
/* 41 */     this.user = user;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 45 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 49 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getIpAddress() {
/* 53 */     return this.ipAddress;
/*    */   }
/*    */   
/*    */   public void setIpAddress(String ipAddress) {
/* 57 */     this.ipAddress = ipAddress;
/*    */   }
/*    */   
/*    */   public short getPort() {
/* 61 */     return this.port;
/*    */   }
/*    */   
/*    */   public void setPort(short port) {
/* 65 */     this.port = port;
/*    */   }
/*    */   
/*    */   public long getProfileId() {
/* 69 */     return this.profileId;
/*    */   }
/*    */   
/*    */   public void setProfileId(long profileId) {
/* 73 */     this.profileId = profileId;
/*    */   }
/*    */   
/*    */   public boolean isClosed() {
/* 77 */     return this.profileId < 0L;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\HkContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */