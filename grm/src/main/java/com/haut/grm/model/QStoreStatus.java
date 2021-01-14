/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QSpaceCondition;
/*    */ import com.haut.grm.model.type.QSpaceStatus;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.DatePath;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ public class QStoreStatus extends EntityPathBase<StoreStatus>
/*    */ {
/*    */   private static final long serialVersionUID = 1066072889L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QStoreStatus storeStatus = new QStoreStatus("storeStatus");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final DatePath<Date> activeDate = createDate("activeDate", Date.class);
/*    */   
/* 29 */   public final BooleanPath alerting = createBoolean("alerting");
/*    */   
/*    */   public final QSpaceCondition condition;
/*    */   
/* 33 */   public final StringPath doorComment = createString("doorComment");
/*    */   
/* 35 */   public final DateTimePath<Date> doorTime = createDateTime("doorTime", Date.class);
/*    */   
/* 37 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 39 */   public final BooleanPath isMeasureOngoing = createBoolean("isMeasureOngoing");
/*    */   
/* 41 */   public final StringPath measureComment = createString("measureComment");
/*    */   
/* 43 */   public final DateTimePath<Date> measureTime = createDateTime("measureTime", Date.class);
/*    */   
/* 45 */   public final StringPath safetyComment = createString("safetyComment");
/*    */   
/* 47 */   public final DateTimePath<Date> safetyTime = createDateTime("safetyTime", Date.class);
/*    */   
/*    */   public final QSpaceStatus status;
/*    */   public final QStore store;
/*    */   
/*    */   public QStoreStatus(String variable)
/*    */   {
/* 54 */     this(StoreStatus.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QStoreStatus(Path<? extends StoreStatus> path) {
/* 58 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QStoreStatus(PathMetadata metadata) {
/* 62 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QStoreStatus(PathMetadata metadata, PathInits inits) {
/* 66 */     this(StoreStatus.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QStoreStatus(Class<? extends StoreStatus> type, PathMetadata metadata, PathInits inits) {
/* 70 */     super(type, metadata, inits);
/* 71 */     this.condition = (inits.isInitialized("condition") ? new QSpaceCondition(forProperty("condition")) : null);
/* 72 */     this.status = (inits.isInitialized("status") ? new QSpaceStatus(forProperty("status")) : null);
/* 73 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QStoreStatus.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */