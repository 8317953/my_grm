/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.haut.grm.model.QDoor;
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntry;
/*    */ import com.haut.grm.model.type.QDoorState;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public class QEntryDoor
/*    */   extends EntityPathBase<EntryDoor>
/*    */ {
/*    */   private static final long serialVersionUID = 1241035978L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QEntryDoor entryDoor = new QEntryDoor("entryDoor");
/*    */   
/*    */ 
/*    */   public final QAbstractEntry _super;
/*    */   
/*    */   public final QDoor door;
/*    */   
/*    */   public final NumberPath<Long> id;
/*    */   
/*    */   public final QDoorState state;
/*    */   
/*    */   public final QStore store;
/*    */   
/*    */   public final DateTimePath<Date> time;
/*    */   
/*    */ 
/*    */   public QEntryDoor(String variable)
/*    */   {
/* 41 */     this(EntryDoor.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QEntryDoor(Path<? extends EntryDoor> path) {
/* 45 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QEntryDoor(PathMetadata metadata) {
/* 49 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QEntryDoor(PathMetadata metadata, PathInits inits) {
/* 53 */     this(EntryDoor.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QEntryDoor(Class<? extends EntryDoor> type, PathMetadata metadata, PathInits inits) {
/* 57 */     super(type, metadata, inits);
/* 58 */     this._super = new QAbstractEntry(type, metadata, inits);
/* 59 */     this.door = (inits.isInitialized("door") ? new QDoor(forProperty("door"), inits.get("door")) : null);
/* 60 */     this.id = this._super.id;
/* 61 */     this.state = (inits.isInitialized("state") ? new QDoorState(forProperty("state")) : null);
/* 62 */     this.store = this._super.store;
/* 63 */     this.time = this._super.time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\QEntryDoor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */