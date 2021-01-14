/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ 
/*    */ public class MyUserDetails extends org.springframework.security.core.userdetails.User
/*    */ {
/*    */   private static final long serialVersionUID = -8765726904512020155L;
/*    */   private User user;
/*    */   
/*    */   public MyUserDetails(User user, Collection<? extends GrantedAuthority> authorities)
/*    */   {
/* 13 */     super(user.getUsername(), user.getPassword(), authorities);
/* 14 */     this.user = user;
/*    */   }
/*    */   
/*    */   public MyUserDetails(User user, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
/* 18 */     super(user.getUsername(), user.getPassword(), enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
/* 19 */     this.user = user;
/*    */   }
/*    */   
/*    */   public User getUser() {
/* 23 */     return this.user;
/*    */   }
/*    */   
/*    */   public boolean equals(Object o)
/*    */   {
/* 28 */     if ((o instanceof MyUserDetails)) {
/* 29 */       return this.user.hashCode() == ((MyUserDetails)o).user.hashCode();
/*    */     }
/* 31 */     return false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 39 */     return this.user.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\MyUserDetails.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */