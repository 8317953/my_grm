/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QSystemModule
/*    */   extends EntityPathBase<SystemModule>
/*    */ {
/*    */   private static final long serialVersionUID = -1337934816L;
/* 20 */   public static final QSystemModule systemModule = new QSystemModule("systemModule");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final BooleanPath active = createBoolean("active");
/*    */   
/* 26 */   public final StringPath code = createString("code");
/*    */   
/* 28 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 30 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 32 */   public final StringPath name = createString("name");
/*    */   
/*    */   public QSystemModule(String variable) {
/* 35 */     super(SystemModule.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QSystemModule(Path<? extends SystemModule> path) {
/* 39 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QSystemModule(PathMetadata metadata) {
/* 43 */     super(SystemModule.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\QSystemModule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */