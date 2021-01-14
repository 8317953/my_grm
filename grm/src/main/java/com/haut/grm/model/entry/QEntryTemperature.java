/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntry;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ public class QEntryTemperature
/*    */   extends EntityPathBase<EntryTemperature>
/*    */ {
/*    */   private static final long serialVersionUID = -867238696L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QEntryTemperature entryTemperature = new QEntryTemperature("entryTemperature");
/*    */   
/*    */   public final QAbstractEntry _super;
/*    */   
/* 27 */   public final StringPath data = createString("data");
/*    */   
/*    */ 
/*    */   public final NumberPath<Long> id;
/*    */   
/* 32 */   public final BooleanPath isAuto = createBoolean("isAuto");
/*    */   
/*    */   public final QStore store;
/*    */   
/*    */   public final DateTimePath<Date> time;
/*    */   
/*    */ 
/*    */   public QEntryTemperature(String variable)
/*    */   {
/* 41 */     this(EntryTemperature.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QEntryTemperature(Path<? extends EntryTemperature> path) {
/* 45 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QEntryTemperature(PathMetadata metadata) {
/* 49 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QEntryTemperature(PathMetadata metadata, PathInits inits) {
/* 53 */     this(EntryTemperature.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QEntryTemperature(Class<? extends EntryTemperature> type, PathMetadata metadata, PathInits inits) {
/* 57 */     super(type, metadata, inits);
/* 58 */     this._super = new QAbstractEntry(type, metadata, inits);
/* 59 */     this.id = this._super.id;
/* 60 */     this.store = this._super.store;
/* 61 */     this.time = this._super.time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\QEntryTemperature.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */