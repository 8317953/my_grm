/*     */ package com.haut.grm.service;
/*     */ 
/*     */ import com.haut.grm.datatables.repository.SystemVariableDataTablesRepository;
/*     */ import com.haut.grm.model.business.BusinessNotification;
/*     */ import com.haut.grm.model.dto.UserChangePasswordDto;
/*     */ import com.haut.grm.model.ies.IesCameraImage;
/*     */ import com.haut.grm.model.meta.ActivitiGroup;
/*     */ import com.haut.grm.model.meta.Menu;
/*     */ import com.haut.grm.model.meta.Role;
/*     */ import com.haut.grm.model.standard.code.GrainVariety;
/*     */ import com.haut.grm.model.system.SystemLog;
/*     */ import com.haut.grm.model.system.SystemModule;
/*     */ import com.haut.grm.model.system.SystemStatus;
/*     */ import com.haut.grm.model.system.SystemTrafficModule;
/*     */ import com.haut.grm.model.system.SystemVariable;
/*     */ import com.haut.grm.repository.business.BusinessNotificationRepository;
/*     */ import com.haut.grm.repository.ies.IesCameraImageRepository;
/*     */ import com.haut.grm.repository.meta.MenuRepository;
/*     */ import com.haut.grm.repository.meta.RoleRepository;
/*     */ import com.haut.grm.repository.meta.UserRepository;
/*     */ import com.haut.grm.repository.standard.code.GrainVarietyRepository;
/*     */ import com.haut.grm.repository.system.SystemLogRepository;
/*     */ import com.haut.grm.repository.system.SystemModuleRepository;
/*     */ import com.haut.grm.repository.system.SystemStatusRepository;
/*     */ import com.haut.grm.repository.system.SystemTrafficModuleRepository;
/*     */ import com.haut.grm.util.MessageProducer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.jms.JMSException;
/*     */ import org.activiti.engine.IdentityService;
/*     */ import org.activiti.engine.identity.Group;
/*     */ import org.activiti.engine.identity.GroupQuery;
/*     */ import org.activiti.engine.identity.UserQuery;
/*     */ import org.activiti.engine.impl.persistence.entity.GroupEntityImpl;
/*     */ import org.activiti.engine.impl.persistence.entity.UserEntityImpl;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.context.annotation.Lazy;
/*     */ import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/*     */ import org.springframework.stereotype.Service;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ public class CommonService
/*     */ {
/*     */   @Autowired
/*     */   private UserRepository userRepo;
/*     */   @Autowired
/*     */   private RoleRepository roleRepo;
/*     */   @Autowired
/*     */   private MenuRepository menuRepo;
/*     */   @Autowired
/*     */   private SystemModuleRepository moduleRepo;
/*     */   @Autowired
/*     */   private SystemTrafficModuleRepository trafficModuleRepo;
/*     */   @Autowired
/*     */   private SystemLogRepository logRepo;
/*     */   @Autowired
/*     */   private SystemStatusRepository statusRepo;
/*     */   @Autowired
/*     */   private SystemVariableDataTablesRepository variableRepo;
/*     */   @Autowired
/*     */   private GrainVarietyRepository gvRepo;
/*     */   @Autowired
/*     */   private BusinessNotificationRepository notificationRepo;
/*     */   @Autowired
/*     */   private IesCameraImageRepository iesCiRepo;
/*     */   @Autowired
/*     */   @Lazy
/*     */   private IdentityService identityService;
/*     */   @Autowired
/*     */   private MessageProducer amqSender;
/*     */   
/*     */   public com.haut.grm.model.meta.User createUser(com.haut.grm.model.meta.User user)
/*     */   {
/*  90 */     if (user.getId() != null) {
/*  91 */       return user;
/*     */     }
/*     */     
/*  94 */     Set<Role> _roles = new HashSet();
/*  95 */     for (Role role : user.getRoles()) {
/*  96 */       _roles.add((Role)this.roleRepo.findOne((Long)role.getId()));
/*     */     }
/*  98 */     user.setRoles(_roles);
/*     */     
/* 100 */     createCreateLog("创建用户[" + user.getOfficialName() + "]");
/* 101 */     user = (com.haut.grm.model.meta.User)this.userRepo.save(user);
/* 102 */     UserEntityImpl a_user = new UserEntityImpl();
/* 103 */     a_user.setId(user.getUsername());
/* 104 */     a_user.setLastName(user.getOfficialName());
/* 105 */     a_user.setPassword(user.getPassword());
/* 106 */     a_user.setRevision(1);
/* 107 */     this.identityService.saveUser(a_user);
/*     */     
/* 109 */     for (Role role : user.getRoles()) {
/* 110 */       Group group = (Group)this.identityService.createGroupQuery().groupId(role.getCode()).singleResult();
/* 111 */       this.identityService.createMembership(user.getUsername(), group.getId());
/*     */     }
/* 113 */     return user;
/*     */   }
/*     */   
/*     */   public void deleteUser(com.haut.grm.model.meta.User user)
/*     */   {
/* 118 */     createDeleteLog("删除用户[" + user.getOfficialName() + "]");
/* 119 */     org.activiti.engine.identity.User a_user = (org.activiti.engine.identity.User)this.identityService.createUserQuery().userId(user.getUsername()).singleResult();
/* 120 */     this.identityService.deleteUser(a_user.getId());
/* 121 */     this.userRepo.delete(user);
/*     */   }
/*     */   
/*     */   public Date getLastDate(int hours) {
/* 125 */     Date time = new Date();
/* 126 */     Calendar c = Calendar.getInstance();
/* 127 */     c.setTime(time);
/* 128 */     c.add(10, hours);
/* 129 */     time.setTime(c.getTime().getTime());
/* 130 */     return time;
/*     */   }
/*     */   
/*     */   public com.haut.grm.model.meta.User updateUser(com.haut.grm.model.meta.User user) {
/* 134 */     if (user.getId() != null) {
/* 135 */       com.haut.grm.model.meta.User _user = (com.haut.grm.model.meta.User)this.userRepo.findOne((Long)user.getId());
/* 136 */       _user.setOfficialName(user.getOfficialName());
/* 137 */       Set<Role> _roles = new HashSet();
/* 138 */       for (Role role : user.getRoles()) {
/* 139 */         _roles.add((Role)this.roleRepo.findOne((Long)role.getId()));
/*     */       }
/* 141 */       _user.setRoles(_roles);
/* 142 */       createUpdateLog("修改用户[" + _user.getOfficialName() + "]信息");
/*     */       
/*     */ 
/* 145 */       org.activiti.engine.identity.User a_user = (org.activiti.engine.identity.User)this.identityService.createUserQuery().userId(_user.getUsername()).singleResult();
/* 146 */       a_user.setLastName(_user.getOfficialName());
/* 147 */       a_user.setPassword(_user.getPassword());
/* 148 */       this.identityService.saveUser(a_user);
/*     */       
/* 150 */       for (Group group : this.identityService.createGroupQuery().groupMember(_user.getUsername()).list()) {
/* 151 */         this.identityService.deleteMembership(_user.getUsername(), group.getId());
/*     */       }
/* 153 */       for (Role role : _user.getRoles()) {
/* 154 */         Group group = (Group)this.identityService.createGroupQuery().groupId(role.getCode()).singleResult();
/* 155 */         this.identityService.createMembership(_user.getUsername(), group.getId());
/*     */       }
/* 157 */       return (com.haut.grm.model.meta.User)this.userRepo.save(_user);
/*     */     }
/* 159 */     return null;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   public Role updateRole(Role role)
/*     */   {
/* 187 */     if (role.getId() != null) {
/* 188 */       Role _role = (Role)this.roleRepo.findOne((Long)role.getId());
/* 189 */       _role.setName(role.getName());
/* 190 */       _role.setCode(role.getCode());
/* 191 */       Set<Menu> _menus = new HashSet();
/* 192 */       for (Menu menu : role.getMenus()) {
/* 193 */         _menus.add((Menu)this.menuRepo.findOne((Long)menu.getId()));
/*     */       }
/* 195 */       _role.setMenus(_menus);
/* 196 */       Set<SystemTrafficModule> _modules = new HashSet();
/* 197 */       for (SystemTrafficModule module : role.getTrafficModules()) {
/* 198 */         _modules.add((SystemTrafficModule)this.trafficModuleRepo.findOne((Long)module.getId()));
/*     */       }
/* 200 */       _role.setTrafficModules(_modules);
/* 201 */       createUpdateLog("修改角色[" + _role.getName() + "]信息");
/*     */       
/*     */ 
/* 204 */       Object group = (Group)this.identityService.createGroupQuery().groupId(role.getCode()).singleResult();
/* 205 */       if (group == null) {
/* 206 */         group = new GroupEntityImpl();
/*     */       }
/* 208 */       ((Group)group).setName(_role.getName());
/* 209 */       ((Group)group).setId(_role.getCode());
/* 210 */       ((Group)group).setType("assignment");
/* 211 */       this.identityService.saveGroup((Group)group);
/* 212 */       return (Role)this.roleRepo.save(_role);
/*     */     }
/* 214 */     return null;
/*     */   }
/*     */   
/*     */   public Role createRole(Role role) {
/* 218 */     if (role.getId() != null) {
/* 219 */       return role;
/*     */     }
/* 221 */     Set<Menu> _menus = new HashSet();
/* 222 */     for (Menu menu : role.getMenus()) {
/* 223 */       _menus.add((Menu)this.menuRepo.findOne((Long)menu.getId()));
/*     */     }
/* 225 */     role.setMenus(_menus);
/* 226 */     Set<SystemTrafficModule> _modules = new HashSet();
/* 227 */     for (SystemTrafficModule module : role.getTrafficModules()) {
/* 228 */       _modules.add((SystemTrafficModule)this.trafficModuleRepo.findOne((Long)module.getId()));
/*     */     }
/* 230 */     role.setTrafficModules(_modules);
/* 231 */     createCreateLog("创建角色[" + role.getName() + "]");
/* 232 */     role = (Role)this.roleRepo.save(role);
/*     */     
/* 234 */     GroupEntityImpl a_group = new GroupEntityImpl();
/* 235 */     a_group.setId(role.getCode());
/* 236 */     a_group.setRevision(1);
/* 237 */     a_group.setName(role.getName());
/* 238 */     a_group.setType("assignment");
/* 239 */     this.identityService.saveGroup(a_group);
/* 240 */     return role;
/*     */   }
/*     */   
/*     */ 
/*     */   public void deleteRole(Role role)
/*     */   {
/* 246 */     createDeleteLog("删除角色[" + role.getName() + "]");
/* 247 */     Group group = (Group)this.identityService.createGroupQuery().groupId(role.getCode()).singleResult();
/* 248 */     this.identityService.deleteGroup(group.getId());
/* 249 */     this.roleRepo.delete(role);
/*     */   }
/*     */   
/*     */   public List<SystemLog> getLogs()
/*     */   {
/* 254 */     return this.logRepo.findAll();
/*     */   }
/*     */   
/*     */   public void createLog(String content, String type) {
/* 258 */     SystemLog log = new SystemLog();
/* 259 */     log.setContent(content);
/* 260 */     log.setTime(new Date());
/* 261 */     log.setUser(AuthUserService.getCurrentUser(userRepo));
/* 262 */     log.setType(type);
/* 263 */     this.logRepo.save(log);
/*     */   }
/*     */   
/*     */   public void createSystemLog(String content) {
/* 267 */     SystemLog log = new SystemLog();
/* 268 */     log.setContent(content);
/* 269 */     log.setTime(new Date());
/* 270 */     log.setUser(null);
/* 271 */     log.setType("系统生成");
/* 272 */     this.logRepo.save(log);
/*     */   }
/*     */   
/*     */   public void createCreateLog(String content) {
/* 276 */     createLog(content, "创建");
/*     */   }
/*     */   
/*     */   public void createUpdateLog(String content) {
/* 280 */     createLog(content, "修改");
/*     */   }
/*     */   
/*     */   public void createNotifyLog(String content) {
/* 284 */     createLog(content, "通知");
/*     */   }
/*     */   
/*     */   public void createDeleteLog(String content) {
/* 288 */     createLog(content, "删除");
/*     */   }
/*     */   
/*     */   public SystemVariable updateSystemVariable(SystemVariable variable) {
/* 292 */     createUpdateLog("修改系统变量[" + variable.getVariableKey() + "]");
/* 293 */     return (SystemVariable)this.variableRepo.save(variable);
/*     */   }
/*     */   
/*     */   public String getSystemVariableWithKey(String key) {
/* 297 */     SystemVariable variable = this.variableRepo.findByVariableKey(key);
/* 298 */     return variable == null ? null : variable.getVariableValue();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public com.haut.grm.model.meta.User getUserByUsername(String username)
/*     */   {
/* 306 */     return this.userRepo.getByUsername(username);
/*     */   }
/*     */   
/*     */   public String getOffcialNameByUsername(String username) {
/* 310 */     return getUserByUsername(username).getOfficialName();
/*     */   }
/*     */   
/*     */   public void setUserPassword(UserChangePasswordDto user) throws Exception
/*     */   {
/* 315 */     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
/* 316 */     com.haut.grm.model.meta.User _user = this.userRepo.findByUsername(user.getUsername());
/* 317 */     if (!passwordEncoder.matches(user.getOldPassword(), _user.getPassword()))
/* 318 */       throw new Exception("用户密码错误");
/* 319 */     _user.setPassword(passwordEncoder.encode(user.getNewPassword()));
/* 320 */     _user.setIsPasswordComplete(Boolean.valueOf(true));
/* 321 */     this.userRepo.save(_user);
/*     */   }
/*     */   
/*     */   public void resetUserPassword(String username) {
/* 325 */     com.haut.grm.model.meta.User _user = this.userRepo.findByUsername(username);
/* 326 */     _user.setPassword("$2a$10$ysj0VzgktdZAcuJn9FuB1OIVSF/FXeiFjQ51RuHpB9K0cX/d7/h8i");
/* 327 */     this.userRepo.save(_user);
/*     */   }
/*     */   
/*     */   public List<SystemModule> getModules() {
/* 331 */     return this.moduleRepo.findAll();
/*     */   }
/*     */   
/*     */   public void updateModules(List<SystemModule> modules) {
/* 335 */     this.moduleRepo.save(modules);
/*     */   }
/*     */   
/*     */   public List<SystemTrafficModule> getAllTrafficModules() {
/* 339 */     return this.trafficModuleRepo.findAll();
/*     */   }
/*     */   
/*     */   public Set<SystemTrafficModule> getTrafficModules(com.haut.grm.model.meta.User currentUser) {
/* 343 */     com.haut.grm.model.meta.User _user = this.userRepo.getById((Long)currentUser.getId());
/* 344 */     Set<SystemTrafficModule> modules = new HashSet();
/* 345 */     for (Role role : _user.getRoles()) {
/* 346 */       modules.addAll(role.getTrafficModules());
/*     */     }
/* 348 */     return modules;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public SystemStatus updateSystemStatus(SystemStatus systemStatus)
/*     */   {
/* 356 */     return (SystemStatus)this.statusRepo.save(systemStatus);
/*     */   }
/*     */   
/*     */   public List<com.haut.grm.model.meta.User> getSafetyUsers() {
/* 360 */     List<Role> roles = new ArrayList();
/* 361 */     roles.add(this.roleRepo.findByCode("ROLE_SAFETY"));
/* 362 */     return this.userRepo.findByRoles(roles);
/*     */   }
/*     */   
/*     */   public boolean moduleActive(String code) {
/* 366 */     for (SystemModule module : getModules()) {
/* 367 */       if ((module.getCode().equals(code)) && (module.getActive().booleanValue()))
/* 368 */         return true;
/*     */     }
/* 370 */     return false;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */ 
/*     */   public List<BusinessNotification> getUserNotifications(Date time)
/*     */   {
/* 378 */     if (AuthUserService.getCurrentUser(userRepo) != null) {
/* 379 */       Set<ActivitiGroup> ags = new HashSet();
/* 380 */       for (Role role : this.userRepo.readById((Long)AuthUserService.getCurrentUser(userRepo).getId()).getRoles()) {
/* 381 */         ags.addAll(role.getActivitiGroups());
/*     */       }
/* 383 */       if (ags.size() == 0) {
/* 384 */         return this.notificationRepo.findByUserAndTimeAfterOrderByTimeDesc(AuthUserService.getCurrentUser(userRepo), time);
/*     */       }
/* 386 */       return this.notificationRepo.findByUserAndTimeAfterOrActivitiGroupInAndTimeAfterOrderByTimeDesc(AuthUserService.getCurrentUser(userRepo), time, ags, time);
/*     */     }
/*     */     
/* 389 */     return null;
/*     */   }
/*     */   
/*     */   public BusinessNotification createNotification(BusinessNotification notif) {
/*     */     try {
/* 394 */       this.amqSender.generateNotificationMessage(notif);
/*     */     } catch (JMSException e) {
/* 396 */       e.printStackTrace();
/*     */     }
/* 398 */     return (BusinessNotification)this.notificationRepo.save(notif);
/*     */   }
/*     */   
/*     */   public Role getRoleByCode(String code) {
/* 402 */     return this.roleRepo.findByCode(code);
/*     */   }
/*     */   
/*     */   public List<com.haut.grm.model.meta.User> getUsersFiltered(String filter) {
/* 406 */     return this.userRepo.findByOfficialNameContainingOrTelephoneContaining(filter, filter);
/*     */   }
/*     */   
/*     */   public void blockUserByUsername(String username, boolean isBlocked) {
/* 410 */     com.haut.grm.model.meta.User u = getUserByUsername(username);
/* 411 */     u.setIsLocked(Boolean.valueOf(isBlocked));
/* 412 */     this.userRepo.save(u);
/*     */   }
/*     */   
/*     */   public void activeUserByUsername(String username, boolean isActive) {
/* 416 */     com.haut.grm.model.meta.User u = getUserByUsername(username);
/* 417 */     u.setIsActive(Boolean.valueOf(isActive));
/* 418 */     this.userRepo.save(u);
/*     */   }
/*     */   
/*     */   public GrainVariety getUpTo3Level(GrainVariety gv) {
/* 422 */     String shortCode = getUpTo3LevelCode(gv);
/* 423 */     return (GrainVariety)this.gvRepo.findByShortCode(shortCode);
/*     */   }
/*     */   
/*     */   private String getUpTo3LevelCode(GrainVariety gv) {
/* 427 */     if (gv == null) {
/* 428 */       return "1";
/*     */     }
/* 430 */     if (gv.getLevel().intValue() <= 3) {
/* 431 */       return gv.getShortCode();
/*     */     }
/*     */     
/* 434 */     return gv.getShortCode().substring(0, 3);
/*     */   }
/*     */   
/*     */   public IesCameraImage getFirstIesCameraImage(long gtId, String code)
/*     */   {
/* 439 */     List<IesCameraImage> images = this.iesCiRepo.findByGrainTrafficIdAndRegistry_TrafficModule_Code(Long.valueOf(gtId), code);
/* 440 */     return images.size() == 0 ? null : (IesCameraImage)images.get(0);
/*     */   }
/*     */   
/*     */   public List<IesCameraImage> getIesCameraImage(long gtId, String code) {
/* 444 */     return this.iesCiRepo.findByGrainTrafficIdAndRegistry_TrafficModule_Code(Long.valueOf(gtId), code);
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\service\CommonService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */