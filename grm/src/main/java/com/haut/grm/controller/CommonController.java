/*     */ package com.haut.grm.controller;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.BusinessNotificationView;
/*     */ import com.haut.grm.json.view.Views.SystemVariableView;
/*     */ import com.haut.grm.json.view.Views.UserView;
/*     */ import com.haut.grm.json.view.Views.UserWithRoleView;
/*     */ import com.haut.grm.model.business.BusinessNotification;
/*     */ import com.haut.grm.model.dto.UserChangePasswordDto;
/*     */ import com.haut.grm.model.meta.Role;
/*     */ import com.haut.grm.model.meta.User;
/*     */ import com.haut.grm.model.system.SystemTrafficModule;
/*     */ import com.haut.grm.model.system.SystemVariable;
import com.haut.grm.repository.meta.UserRepository;
/*     */ import com.haut.grm.service.AuthUserService;
/*     */ import com.haut.grm.service.CommonService;
/*     */ import com.haut.grm.util.OfficialIdUtil;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.validation.Valid;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.format.annotation.DateTimeFormat;
/*     */ import org.springframework.format.annotation.DateTimeFormat.ISO;
/*     */ import org.springframework.web.bind.annotation.PathVariable;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.RestController;
/*     */ 
/*     */ @RestController
/*     */ public class CommonController
/*     */ {
/*     */   @Autowired
/*     */   private CommonService commonService;
/*     */   
@Autowired
private UserRepository userRepo;
			
/*     */   @RequestMapping(value={"/retrieve/current/user"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public User getCurrentUser()
/*     */   {
/*  39 */     return AuthUserService.getCurrentUser(userRepo);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/user/{username}"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.UserWithRoleView.class})
/*     */   public User getUserByUsername(@PathVariable String username) {
/*  45 */     return this.commonService.getUserByUsername(username);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/users/filtered"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public List<User> getUsersFiltered(@Valid String filter) {
/*  50 */     return this.commonService.getUsersFiltered(filter);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/current/user/traffic_modules"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({com.haut.grm.json.view.Views.SystemTrafficModuleView.class})
/*     */   public Set<SystemTrafficModule> getCurrentUserTrafficModules() {
/*  56 */     return this.commonService.getTrafficModules(AuthUserService.getCurrentUser(userRepo));
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/current/time"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public Date getCurrentDate() {
/*  61 */     return new Date();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/retrieve/notifications"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @JsonView({Views.BusinessNotificationView.class})
/*     */   public List<BusinessNotification> getNotifications(@RequestParam @DateTimeFormat(iso=DateTimeFormat.ISO.DATE_TIME) Date time) {
/*  67 */     return this.commonService.getUserNotifications(time);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/user"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @JsonView({Views.UserView.class})
/*     */   public User updateUser(@RequestBody User user) {
/*  73 */     return this.commonService.updateUser(user);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/user/password"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void resetUserPassword(@RequestBody UserChangePasswordDto user) throws Exception {
/*  78 */     this.commonService.setUserPassword(user);
/*  79 */     AuthUserService.clearContext();
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/reset/user/{username}/password"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void resetUserPassword(@PathVariable String username) throws Exception {
/*  84 */     this.commonService.resetUserPassword(username);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/user"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @JsonView({Views.UserView.class})
/*     */   public User createUser(@RequestBody User user) {
/*  90 */     User _user = this.commonService.createUser(user);
/*  91 */     return _user;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/role"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void updateRole(@RequestBody Role role) {
/*  96 */     this.commonService.updateRole(role);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/role"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void createRole(@RequestBody Role role) {
/* 101 */     this.commonService.createRole(role);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/role"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteRole(@RequestBody Role role) {
/* 106 */     this.commonService.deleteRole(role);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/delete/user"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void deleteUser(@RequestBody User user) {
/* 111 */     this.commonService.deleteUser(user);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/active/user"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void activeUser(@RequestParam(required=true) String username, @RequestParam(required=true) Boolean isActive) {
/* 116 */     this.commonService.activeUserByUsername(username, isActive.booleanValue());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/block/user"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   public void blockUser(@RequestParam(required=true) String username, @RequestParam(required=true) Boolean isBlocked) {
/* 121 */     this.commonService.blockUserByUsername(username, isBlocked.booleanValue());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/create/system_variable"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @JsonView({Views.SystemVariableView.class})
/*     */   public SystemVariable createSystemVariable(@RequestBody SystemVariable systemVariable) {
/* 127 */     return this.commonService.updateSystemVariable(systemVariable);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/update/system_variable"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @JsonView({Views.SystemVariableView.class})
/*     */   public SystemVariable updateSystemVariable(@RequestBody SystemVariable systemVariable) {
/* 133 */     return this.commonService.updateSystemVariable(systemVariable);
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/dummy_action"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public void dummyAction() {}
/*     */   
/*     */   @RequestMapping(value={"/retrieve/format"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   public String formatOid(@RequestParam String pattern, @RequestParam Integer number)
/*     */   {
/* 142 */     return OfficialIdUtil.format(pattern, number.intValue());
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\controller\CommonController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */