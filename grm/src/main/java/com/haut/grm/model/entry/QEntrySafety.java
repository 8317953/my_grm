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
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QEntrySafety
/*    */   extends EntityPathBase<EntrySafety>
/*    */ {
/*    */   private static final long serialVersionUID = -949102354L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QEntrySafety entrySafety = new QEntrySafety("entrySafety");
/*    */   
/*    */   public final QAbstractEntry _super;
/*    */   
/* 27 */   public final BooleanPath active = createBoolean("active");
/*    */   
/*    */ 
/*    */   public final NumberPath<Long> id;
/*    */   
/*    */   public final QStore store;
/*    */   
/*    */   public final DateTimePath<Date> time;
/*    */   
/*    */ 
/*    */   public QEntrySafety(String variable)
/*    */   {
/* 39 */     this(EntrySafety.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QEntrySafety(Path<? extends EntrySafety> path) {
/* 43 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QEntrySafety(PathMetadata metadata) {
/* 47 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QEntrySafety(PathMetadata metadata, PathInits inits) {
/* 51 */     this(EntrySafety.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QEntrySafety(Class<? extends EntrySafety> type, PathMetadata metadata, PathInits inits) {
/* 55 */     super(type, metadata, inits);
/* 56 */     this._super = new QAbstractEntry(type, metadata, inits);
/* 57 */     this.id = this._super.id;
/* 58 */     this.store = this._super.store;
/* 59 */     this.time = this._super.time;
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\entry\QEntrySafety.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */