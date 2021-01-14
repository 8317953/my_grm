///*    */ package com.haut.grm.bean;
///*    */ 
///*    */ import com.haut.grm.service.LoginAttemptService;
///*    */ import java.io.IOException;
///*    */ import java.io.PrintWriter;
///*    */ import javax.servlet.ServletException;
///*    */ import javax.servlet.http.HttpServletRequest;
///*    */ import javax.servlet.http.HttpServletResponse;
///*    */ import org.springframework.beans.factory.annotation.Autowired;
///*    */ import org.springframework.security.authentication.AccountExpiredException;
///*    */ import org.springframework.security.authentication.BadCredentialsException;
///*    */ import org.springframework.security.authentication.LockedException;
///*    */ import org.springframework.security.core.AuthenticationException;
///*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
///*    */ import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
///*    */ import org.springframework.stereotype.Component;
///*    */ 
///*    */ 
///*    */ 
///*    */ @Component("customAuthenticationFailureHandler")
///*    */ public class AuthenticationFailureHandler
///*    */   extends SimpleUrlAuthenticationFailureHandler
///*    */ {
///*    */   @Autowired
///*    */   private LoginAttemptService loginAttemptService;
///*    */   
///*    */   public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
///*    */     throws IOException, ServletException
///*    */   {
///* 30 */     String content = "";
///* 31 */     if ((exception instanceof BadCredentialsException)) {
///* 32 */       content = String.format("密码错误，剩余尝试次数:%d", new Object[] { Integer.valueOf(5 - this.loginAttemptService.getCount(request.getParameter("username")).intValue() >= 0 ? 5 - this.loginAttemptService.getCount(request.getParameter("username")).intValue() : 0) });
///*    */     }
///* 34 */     else if ((exception instanceof UsernameNotFoundException)) {
///* 35 */       content = "未找到该账户";
///*    */     }
///* 37 */     else if ((exception instanceof AccountExpiredException)) {
///* 38 */       content = "该用户账户已被禁用，如该情况不属实请及时联系系统管理员";
///*    */     }
///* 40 */     else if ((exception instanceof LockedException)) {
///* 41 */       content = "该用户登录尝试超过5次，请于2小时后尝试或联系系统管理员关闭账户屏蔽";
///*    */     }
///*    */     else {
///* 44 */       content = "服务器出现错误，无法登陆";
///*    */     }
///* 46 */     response.setStatus(401);
///* 47 */     response.setHeader("Content-Type", "text/plain");
///* 48 */     response.getWriter().write(content);
///* 49 */     response.getWriter().flush();
///* 50 */     response.getWriter().close();
///*    */   }
///*    */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\AuthenticationFailureHandler.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */