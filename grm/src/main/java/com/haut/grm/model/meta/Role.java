/*     */ package com.haut.grm.model.meta;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.system.SystemTrafficModule;
/*     */ import java.util.Set;
/*     */ import javax.persistence.Column;
/*     */ import javax.persistence.Entity;
/*     */ import javax.persistence.FetchType;
/*     */ import javax.persistence.JoinColumn;
/*     */ import javax.persistence.JoinTable;
/*     */ import javax.persistence.ManyToMany;
/*     */ import javax.persistence.ManyToOne;
/*     */ import javax.persistence.Table;
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
/*     */ @Entity
/*     */ @Table(name="meta_role")
/*     */ public class Role
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   public static final String SAFETY_ROLE = "ROLE_SAFETY";
/*     */   private static final long serialVersionUID = -653745576568073921L;
/*     */   @Column(name="code_id")
/*     */   private Integer codeId;
/*     */   @Column(name="name")
/*     */   private String name;
/*     */   @Column(name="code")
/*     */   private String code;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="department_id")
/*     */   private Department department;
/*     */   @JsonIgnore
/*     */   @ManyToMany(fetch=FetchType.LAZY)
/*     */   @JoinTable(name="x_user_x_role", joinColumns={@JoinColumn(name="role_id")}, inverseJoinColumns={@JoinColumn(name="user_id")})
/*     */   private Set<User> users;
/*     */   @ManyToMany(fetch=FetchType.LAZY)
/*     */   @JoinTable(name="x_role_x_activiti_group", joinColumns={@JoinColumn(name="role_id")}, inverseJoinColumns={@JoinColumn(name="activiti_group_id")})
/*     */   private Set<ActivitiGroup> activitiGroups;
/*     */   @ManyToMany(fetch=FetchType.LAZY)
/*     */   @JoinTable(name="x_menu_x_role", joinColumns={@JoinColumn(name="role_id")}, inverseJoinColumns={@JoinColumn(name="menu_id")})
/*     */   private Set<Menu> menus;
/*     */   @ManyToMany(fetch=FetchType.LAZY)
/*     */   @JoinTable(name="x_role_x_traffic_module", joinColumns={@JoinColumn(name="role_id")}, inverseJoinColumns={@JoinColumn(name="traffic_module_id")})
/*     */   private Set<SystemTrafficModule> trafficModules;
/*     */   
/*     */   public Integer getCodeId()
/*     */   {
/*  65 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/*  69 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  73 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  77 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getCode() {
/*  81 */     return this.code;
/*     */   }
/*     */   
/*     */   public void setCode(String code) {
/*  85 */     this.code = code;
/*     */   }
/*     */   
/*     */   public Set<Menu> getMenus() {
/*  89 */     return this.menus;
/*     */   }
/*     */   
/*     */   public void setMenus(Set<Menu> menus) {
/*  93 */     this.menus = menus;
/*     */   }
/*     */   
/*     */   public Set<SystemTrafficModule> getTrafficModules() {
/*  97 */     return this.trafficModules;
/*     */   }
/*     */   
/*     */   public void setTrafficModules(Set<SystemTrafficModule> trafficModules) {
/* 101 */     this.trafficModules = trafficModules;
/*     */   }
/*     */   
/*     */   public Set<ActivitiGroup> getActivitiGroups() {
/* 105 */     return this.activitiGroups;
/*     */   }
/*     */   
/*     */   public void setActivitiGroups(Set<ActivitiGroup> activitiGroups) {
/* 109 */     this.activitiGroups = activitiGroups;
/*     */   }
/*     */   
/*     */   public Set<User> getUsers() {
/* 113 */     return this.users;
/*     */   }
/*     */   
/*     */   public void setUsers(Set<User> users) {
/* 117 */     this.users = users;
/*     */   }
/*     */   
/*     */   public Department getDepartment() {
/* 121 */     return this.department;
/*     */   }
/*     */   
/*     */   public void setDepartment(Department department) {
/* 125 */     this.department = department;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\Role.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */