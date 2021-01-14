/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.system.QSystemModule;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.SetPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QMenu
/*    */   extends EntityPathBase<Menu>
/*    */ {
/*    */   private static final long serialVersionUID = -734542738L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QMenu menu = new QMenu("menu");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 29 */   public final StringPath icon = createString("icon");
/*    */   
/* 31 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 33 */   public final BooleanPath isObsolete = createBoolean("isObsolete");
/*    */   
/* 35 */   public final NumberPath<Integer> level = createNumber("level", Integer.class);
/*    */   
/*    */   public final QSystemModule module;
/*    */   
/* 39 */   public final StringPath name = createString("name");
/*    */   
/*    */   public final QMenu parentMenu;
/*    */   
/* 43 */   public final NumberPath<Integer> position = createNumber("position", Integer.class);
/*    */   
/* 45 */   public final SetPath<Role, QRole> roles = createSet("roles", Role.class, QRole.class, PathInits.DIRECT2);
/*    */   
/* 47 */   public final StringPath url = createString("url");
/*    */   
/*    */   public QMenu(String variable) {
/* 50 */     this(Menu.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QMenu(Path<? extends Menu> path) {
/* 54 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QMenu(PathMetadata metadata) {
/* 58 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QMenu(PathMetadata metadata, PathInits inits) {
/* 62 */     this(Menu.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QMenu(Class<? extends Menu> type, PathMetadata metadata, PathInits inits) {
/* 66 */     super(type, metadata, inits);
/* 67 */     this.module = (inits.isInitialized("module") ? new QSystemModule(forProperty("module")) : null);
/* 68 */     this.parentMenu = (inits.isInitialized("parentMenu") ? new QMenu(forProperty("parentMenu"), inits.get("parentMenu")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QMenu.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */