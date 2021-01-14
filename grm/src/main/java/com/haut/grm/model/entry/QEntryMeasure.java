/*    */ package com.haut.grm.model.entry;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntry;
/*    */ import com.haut.grm.model.meta.QUser;
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
/*    */ public class QEntryMeasure
/*    */   extends EntityPathBase<EntryMeasure>
/*    */ {
/*    */   private static final long serialVersionUID = -277139774L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QEntryMeasure entryMeasure = new QEntryMeasure("entryMeasure");
/*    */   
/*    */   public final QAbstractEntry _super;
/*    */   
/* 27 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
/*    */   
/* 29 */   public final StringPath data = createString("data");
/*    */   
/* 31 */   public final BooleanPath hasData = createBoolean("hasData");
/*    */   
/*    */ 
/*    */   public final NumberPath<Long> id;
/*    */   
/*    */   public final QUser initiator;
/*    */   
/* 38 */   public final BooleanPath isAuto = createBoolean("isAuto");
/*    */   
/* 40 */   public final NumberPath<Long> stockAmount = createNumber("stockAmount", Long.class);
/*    */   
/*    */ 
/*    */   public final QStore store;
/*    */   
/*    */ 
/*    */   public final DateTimePath<Date> time;
/*    */   
/* 48 */   public final NumberPath<Double> volume = createNumber("volume", Double.class);
/*    */   
/*    */   public QEntryMeasure(String variable) {
/* 51 */     this(EntryMeasure.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QEntryMeasure(Path<? extends EntryMeasure> path) {
/* 55 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QEntryMeasure(PathMetadata metadata) {
/* 59 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QEntryMeasure(PathMetadata metadata, PathInits inits) {
/* 63 */     this(EntryMeasure.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QEntryMeasure(Class<? extends EntryMeasure> type, PathMetadata metadata, PathInits inits) {
/* 67 */     super(type, metadata, inits);
/* 68 */     this._super = new QAbstractEntry(type, metadata, inits);
/* 69 */     this.id = this._super.id;
/* 70 */     this.initiator = (inits.isInitialized("initiator") ? new QUser(forProperty("initiator"), inits.get("initiator")) : null);
/* 71 */     this.store = this._super.store;
/* 72 */     this.time = this._super.time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\QEntryMeasure.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */