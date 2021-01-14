/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.meta.QActivitiGroup;
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
/*    */ public class QBusinessNotification
/*    */   extends EntityPathBase<BusinessNotification>
/*    */ {
/*    */   private static final long serialVersionUID = 1416639487L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QBusinessNotification businessNotification = new QBusinessNotification("businessNotification");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/*    */   public final QActivitiGroup activitiGroup;
/*    */   
/* 29 */   public final StringPath content = createString("content");
/*    */   
/* 31 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 33 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/* 35 */   public final StringPath title = createString("title");
/*    */   public final QUser user;
/*    */   
/*    */   public QBusinessNotification(String variable)
/*    */   {
/* 40 */     this(BusinessNotification.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QBusinessNotification(Path<? extends BusinessNotification> path) {
/* 44 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QBusinessNotification(PathMetadata metadata) {
/* 48 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QBusinessNotification(PathMetadata metadata, PathInits inits) {
/* 52 */     this(BusinessNotification.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QBusinessNotification(Class<? extends BusinessNotification> type, PathMetadata metadata, PathInits inits) {
/* 56 */     super(type, metadata, inits);
/* 57 */     this.activitiGroup = (inits.isInitialized("activitiGroup") ? new QActivitiGroup(forProperty("activitiGroup")) : null);
/* 58 */     this.user = (inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QBusinessNotification.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */