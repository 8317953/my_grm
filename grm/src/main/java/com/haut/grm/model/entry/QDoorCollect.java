/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntry;
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
/*    */ public class QDoorCollect
/*    */   extends EntityPathBase<DoorCollect>
/*    */ {
/*    */   private static final long serialVersionUID = 1230067878L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QDoorCollect doorCollect = new QDoorCollect("doorCollect");
/*    */   
/*    */   public final QAbstractEntry _super;
/*    */   
/* 27 */   public final NumberPath<Long> closeCount = createNumber("closeCount", Long.class);
/*    */   
/* 29 */   public final StringPath comment = createString("comment");
/*    */   
/*    */ 
/*    */   public final NumberPath<Long> id;
/*    */   
/* 34 */   public final NumberPath<Long> openCount = createNumber("openCount", Long.class);
/*    */   
/*    */   public final QStore store;
/*    */   
/*    */   public final DateTimePath<Date> time;
/*    */   
/*    */   public QDoorCollect(String variable)
/*    */   {
/* 42 */     this(DoorCollect.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QDoorCollect(Path<? extends DoorCollect> path) {
/* 46 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QDoorCollect(PathMetadata metadata) {
/* 50 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QDoorCollect(PathMetadata metadata, PathInits inits) {
/* 54 */     this(DoorCollect.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QDoorCollect(Class<? extends DoorCollect> type, PathMetadata metadata, PathInits inits) {
/* 58 */     super(type, metadata, inits);
/* 59 */     this._super = new QAbstractEntry(type, metadata, inits);
/* 60 */     this.id = this._super.id;
/* 61 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/* 62 */     this.time = this._super.time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\QDoorCollect.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */