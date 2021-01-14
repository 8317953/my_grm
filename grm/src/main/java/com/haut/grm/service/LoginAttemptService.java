/*    */ package com.haut.grm.service;
/*    */ 
/*    */ import com.google.common.cache.CacheBuilder;
/*    */ import com.google.common.cache.CacheLoader;
/*    */ import com.google.common.cache.LoadingCache;
/*    */ import com.haut.grm.model.business.BusinessNotification;
/*    */ import com.haut.grm.model.meta.MyUserDetails;
/*    */ import com.haut.grm.model.meta.User;
/*    */ import java.util.Date;
/*    */ import java.util.concurrent.ExecutionException;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class LoginAttemptService
/*    */ {
/*    */   @Autowired
/*    */   private CommonService cs;
/* 23 */   private final int MAX_ATTEMPT = 5;
/*    */   private LoadingCache<String, Integer> attemptsCache;
/*    */   private LoadingCache<MyUserDetails, Boolean> reminderCache;
/*    */   
/*    */   public LoginAttemptService()
/*    */   {
/* 29 */     this.attemptsCache = CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.HOURS).build(new CacheLoader() {
/*    */       public Integer load(String key) {
/* 31 */         return Integer.valueOf(0);
/*    */       }
/* 33 */

@Override
public Object load(Object key) throws Exception {
	// TODO Auto-generated method stub
	return Integer.valueOf(0);
}     });
/* 34 */     this.reminderCache = CacheBuilder.newBuilder().expireAfterWrite(1L, TimeUnit.DAYS).build(new CacheLoader() {
/*    */       public Boolean load(MyUserDetails key) {
/* 36 */         return Boolean.valueOf(true);
/*    */       }
/*    */

@Override
public Object load(Object key) throws Exception {
	// TODO Auto-generated method stub
	return Boolean.valueOf(true);
}     });
/*    */   }
/*    */   
/*    */   public void remind(MyUserDetails key) {
/* 42 */     if ((!key.getUser().getIsPasswordComplete().booleanValue()) && (this.reminderCache.getIfPresent(key) == null)) {
/* 43 */       BusinessNotification notif = new BusinessNotification();
/* 44 */       notif.setUser(key.getUser());
/* 45 */       notif.setContent("用户 " + key.getUser().getOfficialName() + "， 您的密码复杂程度不够，请及时重设密码");
/* 46 */       notif.setTitle("重设密码");
/* 47 */       notif.setTime(new Date());
/* 48 */       this.cs.createNotification(notif);
/* 49 */       this.reminderCache.put(key, Boolean.valueOf(true));
/*    */     }
/*    */   }
/*    */   
/*    */   public void loginSucceeded(MyUserDetails key) {
/* 54 */     this.attemptsCache.invalidate(key.getUsername());
/* 55 */     if (shouldBlocked(key.getUsername())) {
/* 56 */       this.cs.blockUserByUsername(key.getUsername(), false);
/*    */     }
/* 58 */     this.cs.createNotifyLog("用户 " + key.getUser().getOfficialName() + " - 登录名:" + key.getUser().getUsername() + " 登录系统");
/*    */   }
/*    */   
/*    */   public void loginFailed(String key) {
/* 62 */     int attempts = 0;
/*    */     try {
/* 64 */       attempts = ((Integer)this.attemptsCache.get(key)).intValue();
/*    */     } catch (ExecutionException e) {
/* 66 */       attempts = 0;
/*    */     }
/* 68 */     attempts++;
/* 69 */     this.attemptsCache.put(key, Integer.valueOf(attempts));
/* 70 */     if (shouldBlocked(key)) {
/* 71 */       this.cs.blockUserByUsername(key, true);
/*    */     }
/*    */   }
/*    */   
/*    */   private boolean shouldBlocked(String key) {
/* 76 */     boolean result = false;
/*    */     try {
/* 78 */       result = ((Integer)this.attemptsCache.get(key)).intValue() >= MAX_ATTEMPT;
/*    */     } catch (ExecutionException e) {
/* 80 */       result = false;
/*    */     }
/* 82 */     return result;
/*    */   }
/*    */   
/*    */   public boolean isBlocked(String key) {
/* 86 */     User u = this.cs.getUserByUsername(key);
/* 87 */     return (u != null) && (u.getIsLocked().booleanValue());
/*    */   }
/*    */   
/*    */   public Integer getCount(String key) {
/*    */     try {
/* 92 */       return (Integer)this.attemptsCache.get(key);
/*    */     } catch (ExecutionException e) {}
/* 94 */     return Integer.valueOf(0);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\LoginAttemptService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */