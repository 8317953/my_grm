///*    */ package com.haut.grm.bean;
///*    */ 
///*    */ import com.haut.grm.service.LoginAttemptService;
///*    */ import org.springframework.beans.factory.annotation.Autowired;
///*    */ import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
///*    */ import org.springframework.security.core.Authentication;
///*    */ import org.springframework.stereotype.Component;
///*    */ 
///*    */ @Component
///*    */ public class AuthenticationFailureListener implements org.springframework.context.ApplicationListener<AuthenticationFailureBadCredentialsEvent>
///*    */ {
///*    */   @Autowired
///*    */   private LoginAttemptService loginAttemptService;
///*    */   
///*    */   public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e)
///*    */   {
///* 17 */     String _user = (String)e.getAuthentication().getPrincipal();
///* 18 */     this.loginAttemptService.loginFailed(_user);
///*    */   }
///*    */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\AuthenticationFailureListener.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */