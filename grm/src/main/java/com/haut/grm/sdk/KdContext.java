/*    */ package com.haut.grm.sdk;
/*    */ 
/*    */ 
/*    */ public class KdContext
/*    */ {
/*    */   public static final short KD_PORT_DEFAULT = 80;
/*    */   
/*    */   private String user;
/*    */   
/*    */   private String password;
/*    */   
/*    */   private String ipAddress;
/* 13 */   private short port = 80;
/*    */   
/* 15 */   private long profileId = -1L;
/*    */   
/*    */   public KdContext(String user, String password, String ipAddress, short port)
/*    */   {
/* 19 */     this.user = user;
/* 20 */     this.password = password;
/* 21 */     this.ipAddress = ipAddress;
/* 22 */     this.port = port;
/*    */   }
/*    */   
/*    */   public KdContext() {}
/*    */   
/*    */   public String getUser()
/*    */   {
/* 29 */     return this.user;
/*    */   }
/*    */   
/*    */   public void setUser(String user) {
/* 33 */     this.user = user;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 37 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 41 */     this.password = password;
/*    */   }
/*    */   
/*    */   public String getIpAddress() {
/* 45 */     return this.ipAddress;
/*    */   }
/*    */   
/*    */   public void setIpAddress(String ipAddress) {
/* 49 */     this.ipAddress = ipAddress;
/*    */   }
/*    */   
/*    */   public short getPort() {
/* 53 */     return this.port;
/*    */   }
/*    */   
/*    */   public void setPort(short port) {
/* 57 */     this.port = port;
/*    */   }
/*    */   
/*    */   public long getProfileId() {
/* 61 */     return this.profileId;
/*    */   }
/*    */   
/*    */   public void setProfileId(long profileId) {
/* 65 */     this.profileId = profileId;
/*    */   }
/*    */   
/*    */   public boolean isClosed() {
/* 69 */     return this.profileId < 0L;
/*    */   }
/*    */   
/*    */   public long getFormattedIp() {
/* 73 */     String[] elements = this.ipAddress.split("\\.");
/* 74 */     return Integer.valueOf(elements[0]).intValue() * 16777216 + Integer.valueOf(elements[1]).intValue() * 65536 + Integer.valueOf(elements[2]).intValue() * 256 + Integer.valueOf(elements[3]).intValue();
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\sdk\KdContext.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */