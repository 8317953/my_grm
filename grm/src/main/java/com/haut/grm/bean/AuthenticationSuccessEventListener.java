///*    */ package com.haut.grm.bean;
///*    */ 
///*    */ import com.haut.grm.model.meta.MyUserDetails;
///*    */ import com.haut.grm.service.LoginAttemptService;
///*    */ import org.springframework.beans.factory.annotation.Autowired;
///*    */ import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
///*    */ import org.springframework.security.core.Authentication;
///*    */ import org.springframework.stereotype.Component;
///*    */ 
///*    */ @Component
///*    */ public class AuthenticationSuccessEventListener implements org.springframework.context.ApplicationListener<AuthenticationSuccessEvent>
///*    */ {
///*    */   @Autowired
///*    */   private LoginAttemptService loginAttemptService;
///*    */   
///*    */   public void onApplicationEvent(AuthenticationSuccessEvent e)
///*    */   {
///* 18 */     MyUserDetails _user = (MyUserDetails)e.getAuthentication().getPrincipal();
///* 19 */     this.loginAttemptService.remind(_user);
///* 20 */     this.loginAttemptService.loginSucceeded(_user);
///*    */   }
///*    */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\AuthenticationSuccessEventListener.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */