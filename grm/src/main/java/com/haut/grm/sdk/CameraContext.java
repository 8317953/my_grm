/*    */ package com.haut.grm.sdk;
/*    */ 
/*    */ 
/*    */ public class CameraContext
/*    */ {
/*    */   public static final int PORT_DEFAULT = 37777;
/*    */   
/*    */   private String user;
/*    */   
/*    */   private String password;
/*    */   
/*    */   private String ipAddress;
/* 13 */   private int port = 37777;
/*    */   
/*    */   private long refId;
/*    */   
/* 17 */   private long profileId = -1L;
/*    */   
/*    */   public CameraContext(String user, String password, String ipAddress, Long refId)
/*    */   {
/* 21 */     this.user = user;
/* 22 */     this.password = password;
/* 23 */     this.ipAddress = ipAddress;
/* 24 */     this.refId = refId.longValue();
/*    */   }
/*    */   
/*    */ 
/*    */   public CameraContext(String user, String password, String ipAddress, int port)
/*    */   {
/* 30 */     this.user = user;
/* 31 */     this.password = password;
/* 32 */     this.ipAddress = ipAddress;
/* 33 */     this.port = port;
/*    */   }
/*    */   
/*    */   public String getUser() {
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
/*    */   public int getPort() {
/* 61 */     return this.port;
/*    */   }
/*    */   
/*    */   public void setPort(int port) {
/* 65 */     this.port = port;
/*    */   }
/*    */   
/*    */   public boolean isClosed() {
/* 69 */     return this.profileId <= 0L;
/*    */   }
/*    */   
/*    */   public long getProfileId() {
/* 73 */     return this.profileId;
/*    */   }
/*    */   
/*    */   public void setProfileId(long profileId) {
/* 77 */     this.profileId = profileId;
/*    */   }
/*    */   
/*    */   public long getRefId() {
/* 81 */     return this.refId;
/*    */   }
/*    */   
/*    */   public void setRefId(long refId) {
/* 85 */     this.refId = refId;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\CameraContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */