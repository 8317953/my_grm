/*     */ package com.haut.grm.model.meta;
/*     */ 
/*     */ import com.fasterxml.jackson.annotation.JsonIgnore;
/*     */ import com.fasterxml.jackson.annotation.JsonView;
import com.haut.grm.json.view.Views;
/*     */ import com.haut.grm.json.view.Views.MenuRefParentView;
/*     */ import com.haut.grm.json.view.Views.MenuView;
/*     */ import com.haut.grm.model.base.AbstractEntity;
/*     */ import com.haut.grm.model.system.SystemModule;
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
/*     */ @Entity
/*     */ @Table(name="meta_menu")
/*     */ public class Menu
/*     */   extends AbstractEntity<Long>
/*     */ {
/*     */   private static final long serialVersionUID = -8811556612011893101L;
/*     */   @Column(name="code_id")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private Integer codeId;
/*     */   @Column(name="name")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private String name;
/*     */   @Column(name="url")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private String url;
/*     */   @Column(name="icon")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private String icon;
/*     */   @Column(name="level")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private Integer level;
/*     */   @Column(name="position")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private Integer position;
/*     */   @JsonIgnore
/*     */   @ManyToMany(fetch=FetchType.LAZY)
/*     */   @JoinTable(name="x_menu_x_role", joinColumns={@JoinColumn(name="menu_id")}, inverseJoinColumns={@JoinColumn(name="role_id")})
/*     */   private Set<Role> roles;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="parent_id")
/*     */   @JsonView({Views.MenuRefParentView.class})
/*     */   private Menu parentMenu;
/*     */   @ManyToOne
/*     */   @JoinColumn(name="module_id")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private SystemModule module;
/*     */   @Column(name="is_obsolete")
/*     */   @JsonView({Views.MenuView.class})
/*     */   private Boolean isObsolete;
/*     */   
/*     */   public Integer getPosition()
/*     */   {
/*  72 */     return this.position;
/*     */   }
/*     */   
/*     */   public void setPosition(Integer position) {
/*  76 */     this.position = position;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  80 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  84 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getUrl() {
/*  88 */     return this.url;
/*     */   }
/*     */   
/*     */   public void setUrl(String url) {
/*  92 */     this.url = url;
/*     */   }
/*     */   
/*     */   public String getIcon() {
/*  96 */     return this.icon;
/*     */   }
/*     */   
/*     */   public void setIcon(String icon) {
/* 100 */     this.icon = icon;
/*     */   }
/*     */   
/*     */   public Integer getLevel() {
/* 104 */     return this.level;
/*     */   }
/*     */   
/*     */   public void setLevel(Integer level) {
/* 108 */     this.level = level;
/*     */   }
/*     */   
/*     */   public Boolean getIsObsolete() {
/* 112 */     return this.isObsolete;
/*     */   }
/*     */   
/*     */   public void setIsObsolete(Boolean isObsolete) {
/* 116 */     this.isObsolete = isObsolete;
/*     */   }
/*     */   
/*     */   public Menu getParentMenu() {
/* 120 */     return this.parentMenu;
/*     */   }
/*     */   
/*     */   public void setParentMenu(Menu parentMenu) {
/* 124 */     this.parentMenu = parentMenu;
/*     */   }
/*     */   
/*     */   public SystemModule getModule() {
/* 128 */     return this.module;
/*     */   }
/*     */   
/*     */   public void setModule(SystemModule module) {
/* 132 */     this.module = module;
/*     */   }
/*     */   
/*     */   public Integer getCodeId() {
/* 136 */     return this.codeId;
/*     */   }
/*     */   
/*     */   public void setCodeId(Integer codeId) {
/* 140 */     this.codeId = codeId;
/*     */   }
/*     */   
/*     */   public Set<Role> getRoles() {
/* 144 */     return this.roles;
/*     */   }
/*     */   
/*     */   public void setRoles(Set<Role> roles) {
/* 148 */     this.roles = roles;
/*     */   }
/*     */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\Menu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */