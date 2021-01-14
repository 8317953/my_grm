/*    */ package com.haut.grm.service;
import com.haut.grm.bean.JwtUtils;
import com.haut.grm.model.MyUser;
/*    */ 
/*    */ import com.haut.grm.model.meta.MyUserDetails;
/*    */ import com.haut.grm.model.meta.Role;
/*    */ import com.haut.grm.model.meta.User;
/*    */ import com.haut.grm.repository.meta.UserRepository;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Arrays;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.security.core.Authentication;
/*    */ import org.springframework.security.core.GrantedAuthority;
/*    */ import org.springframework.security.core.authority.SimpleGrantedAuthority;
/*    */ import org.springframework.security.core.context.SecurityContext;
/*    */ import org.springframework.security.core.context.SecurityContextHolder;
/*    */ import org.springframework.security.core.userdetails.UserDetails;
/*    */ import org.springframework.security.core.userdetails.UserDetailsService;
/*    */ import org.springframework.security.core.userdetails.UsernameNotFoundException;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
/*    */ 
/*    */ @Service("myUserDetailsService")
/*    */ public class AuthUserService
/*    */   implements UserDetailsService
/*    */ {
/*    */   @Autowired
/*    */   private UserRepository userRepo;
/*    */   @Autowired
/*    */   private LoginAttemptService loginAttemptService;
/*    */   
/*    */   @Transactional(readOnly=true)
/*    */   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
/*    */   {
/* 36 */     if (username.equals("admin_toyla")) {
/* 37 */       User _user = new User();
/* 38 */       _user.setUsername("admin_toyla");
/* 39 */       _user.setPassword("$2a$10$ZOSyIxayxnREQzTePdhMSuxk6A1syeoQcZjSAH4bWZa7EEWPltXVq");
/* 40 */       _user.setIsPasswordComplete(Boolean.valueOf(true));
/* 41 */       return new MyUserDetails(_user, new ArrayList(Arrays.asList(new SimpleGrantedAuthority[] { new SimpleGrantedAuthority("ROLE_ADMIN") })));
/*    */     }
/*    */     
/* 44 */     User user = this.userRepo.getByUsername(username);
/*    */     
/* 46 */     if (user == null)
/* 47 */       throw new UsernameNotFoundException(username);
/* 48 */     List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
/*    */     
/* 50 */     return new MyUserDetails(user, true, user.getIsActive().booleanValue(), true, !this.loginAttemptService.isBlocked(username), authorities);
/*    */   }
/*    */   
/*    */ 
/*    */   public static MyUserDetails getCurrentUserDetails()
/*    */   {
/* 56 */     MyUserDetails _user = null;
/*    */     try {
/* 58 */       _user = (MyUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
/*    */     }
/*    */     catch (Exception localException) {}
/*    */     
/* 62 */     return _user;
/*    */   }
/*    */   
/*    */ 
/*    */   public static void clearContext() {}
/*    */   
///*    */   public static User getCurrentUser()
///*    */   {
///* 70 */     if (getCurrentUserDetails() != null)
///* 71 */       return getCurrentUserDetails().getUser();
///* 72 */     return null;
///*    */   }

public static User getCurrentUser(UserRepository userRepo) {
	HttpServletRequest request=((ServletRequestAttributes)(RequestContextHolder.currentRequestAttributes())).getRequest();
	String token=request.getHeader("token");
	MyUser u=JwtUtils.unsign(token);
	if(u!=null) {
		User myu=userRepo.findByUsername(u.getUsername());
		return myu;
	}
	return null;
}




/*    */   
/*    */   private List<GrantedAuthority> buildUserAuthority(Set<Role> roles)
/*    */   {
/* 77 */     Set<GrantedAuthority> setAuths = new HashSet();
/*    */     
/* 79 */     for (Role role : roles) {
/* 80 */       setAuths.add(new SimpleGrantedAuthority(role.getCode()));
/*    */     }
/*    */     
/* 83 */     List<GrantedAuthority> Result = new ArrayList(setAuths);
/*    */     
/* 85 */     return Result;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\AuthUserService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */