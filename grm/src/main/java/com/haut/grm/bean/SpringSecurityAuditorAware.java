/*    */ package com.haut.grm.bean;
/*    */ 
/*    */ import com.haut.grm.model.meta.MyUserDetails;
/*    */ import com.haut.grm.model.meta.User;
/*    */ import org.springframework.data.domain.AuditorAware;
/*    */ import org.springframework.security.authentication.AnonymousAuthenticationToken;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ 
/*    */ public class SpringSecurityAuditorAware
/*    */   implements AuditorAware<User>
/*    */ {
/*    */   public User getCurrentAuditor()
/*    */   {
/* 16 */     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
/*    */     
/* 18 */     if ((authentication == null) || (!authentication.isAuthenticated()) || ((authentication instanceof AnonymousAuthenticationToken))) {
/* 19 */       return null;
/*    */     }
/*    */     
/* 22 */     return ((MyUserDetails)authentication.getPrincipal()).getUser();
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\bean\SpringSecurityAuditorAware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */