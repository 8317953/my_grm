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
/*    */ public class QSystemStatus
/*    */   extends EntityPathBase<SystemStatus>
/*    */ {
/*    */   private static final long serialVersionUID = -1161632346L;
/* 20 */   public static final QSystemStatus systemStatus = new QSystemStatus("systemStatus");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath code = createString("code");
/*    */   
/* 26 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 28 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 30 */   public final StringPath name = createString("name");
/*    */   
/* 32 */   public final BooleanPath value = createBoolean("value");
/*    */   
/*    */   public QSystemStatus(String variable) {
/* 35 */     super(SystemStatus.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QSystemStatus(Path<? extends SystemStatus> path) {
/* 39 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QSystemStatus(PathMetadata metadata) {
/* 43 */     super(SystemStatus.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\QSystemStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */