/*    */ package com.haut.grm.model.system;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.meta.QUser;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QSystemLog
/*    */   extends EntityPathBase<SystemLog>
/*    */ {
/*    */   private static final long serialVersionUID = -858289648L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QSystemLog systemLog = new QSystemLog("systemLog");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final StringPath content = createString("content");
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 31 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/* 33 */   public final StringPath type = createString("type");
/*    */   public final QUser user;
/*    */   
/*    */   public QSystemLog(String variable)
/*    */   {
/* 38 */     this(SystemLog.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QSystemLog(Path<? extends SystemLog> path) {
/* 42 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QSystemLog(PathMetadata metadata) {
/* 46 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QSystemLog(PathMetadata metadata, PathInits inits) {
/* 50 */     this(SystemLog.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QSystemLog(Class<? extends SystemLog> type, PathMetadata metadata, PathInits inits) {
/* 54 */     super(type, metadata, inits);
/* 55 */     this.user = (inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\system\QSystemLog.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */