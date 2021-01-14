/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.system.QSystemTrafficModule;
/*    */ import com.haut.grm.model.system.SystemTrafficModule;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.SetPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QRole
/*    */   extends EntityPathBase<Role>
/*    */ {
/*    */   private static final long serialVersionUID = -734384251L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QRole role = new QRole("role");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final SetPath<ActivitiGroup, QActivitiGroup> activitiGroups = createSet("activitiGroups", ActivitiGroup.class, QActivitiGroup.class, PathInits.DIRECT2);
/*    */   
/* 29 */   public final StringPath code = createString("code");
/*    */   
/* 31 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/*    */   public final QDepartment department;
/*    */   
/* 35 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 37 */   public final SetPath<Menu, QMenu> menus = createSet("menus", Menu.class, QMenu.class, PathInits.DIRECT2);
/*    */   
/* 39 */   public final StringPath name = createString("name");
/*    */   
/* 41 */   public final SetPath<SystemTrafficModule, QSystemTrafficModule> trafficModules = createSet("trafficModules", SystemTrafficModule.class, QSystemTrafficModule.class, PathInits.DIRECT2);
/*    */   
/* 43 */   public final SetPath<User, QUser> users = createSet("users", User.class, QUser.class, PathInits.DIRECT2);
/*    */   
/*    */   public QRole(String variable) {
/* 46 */     this(Role.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QRole(Path<? extends Role> path) {
/* 50 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QRole(PathMetadata metadata) {
/* 54 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QRole(PathMetadata metadata, PathInits inits) {
/* 58 */     this(Role.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QRole(Class<? extends Role> type, PathMetadata metadata, PathInits inits) {
/* 62 */     super(type, metadata, inits);
/* 63 */     this.department = (inits.isInitialized("department") ? new QDepartment(forProperty("department")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QRole.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */