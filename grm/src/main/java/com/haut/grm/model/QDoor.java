/*    */ package com.haut.grm.model;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.haut.grm.model.type.QDoorState;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QDoor
/*    */   extends EntityPathBase<Door>
/*    */ {
/*    */   private static final long serialVersionUID = -603542680L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QDoor door = new QDoor("door");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Integer> codeId = createNumber("codeId", Integer.class);
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 31 */   public final StringPath name = createString("name");
/*    */   
/* 33 */   public final BooleanPath occupied = createBoolean("occupied");
/*    */   
/*    */   public final QDoorState state;
/*    */   public final QStore store;
/*    */   
/*    */   public QDoor(String variable)
/*    */   {
/* 40 */     this(Door.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QDoor(Path<? extends Door> path) {
/* 44 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QDoor(PathMetadata metadata) {
/* 48 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QDoor(PathMetadata metadata, PathInits inits) {
/* 52 */     this(Door.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QDoor(Class<? extends Door> type, PathMetadata metadata, PathInits inits) {
/* 56 */     super(type, metadata, inits);
/* 57 */     this.state = (inits.isInitialized("state") ? new QDoorState(forProperty("state")) : null);
/* 58 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\QDoor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */