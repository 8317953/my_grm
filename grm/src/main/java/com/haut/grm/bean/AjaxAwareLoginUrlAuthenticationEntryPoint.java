///*    */ package com.haut.grm.bean;
///*    */ 
///*    */ import java.io.IOException;
///*    */ import javax.servlet.ServletException;
///*    */ import javax.servlet.http.HttpServletRequest;
///*    */ import javax.servlet.http.HttpServletResponse;
///*    */ import org.springframework.security.core.AuthenticationException;
///*    */ import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
///*    */ import org.springframework.security.web.util.matcher.ELRequestMatcher;
///*    */ import org.springframework.security.web.util.matcher.RequestMatcher;
///*    */ import org.springframework.stereotype.Component;
///*    */ 
///*    */ 
///*    */ @Component("ajaxAwareLoginUrlAuthenticationEntryPoint")
///*    */ public class AjaxAwareLoginUrlAuthenticationEntryPoint
///*    */   extends LoginUrlAuthenticationEntryPoint
///*    */ {
///* 18 */   private static final RequestMatcher requestMatcher = new ELRequestMatcher(
///* 19 */     "hasHeader('X-Requested-With','XMLHttpRequest')");
///*    */   
///*    */   public AjaxAwareLoginUrlAuthenticationEntryPoint(String loginFormUrl) {
///* 22 */     super(loginFormUrl);
///*    */   }
///*    */   
///*    */   public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
///*    */     throws IOException, ServletException
///*    */   {
///* 28 */     if (isPreflight(request)) {
///* 29 */       response.setStatus(204);
///* 30 */     } else if (isRestRequest(request)) {
///* 31 */       response.sendError(401, "Unauthorized");
///*    */     } else {
///* 33 */       super.commence(request, response, authException);
///*    */     }
///*    */   }
///*    */   
///*    */ 
///*    */ 
///*    */ 
///*    */ 
///*    */ 
///*    */   private boolean isPreflight(HttpServletRequest request)
///*    */   {
///* 44 */     return "OPTIONS".equals(request.getMethod());
////			return true;
///*    */   }
///*    */   
///*    */ 
///*    */ 
///*    */ 
///*    */ 
///*    */ 
///*    */   protected boolean isRestRequest(HttpServletRequest request)
///*    */   {
///* 54 */     return requestMatcher.matches(request);
///*    */   }
///*    */ }
//
//
///* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\AjaxAwareLoginUrlAuthenticationEntryPoint.class
// * Java compiler version: 8 (52.0)
// * JD-Core Version:       0.7.1
// */