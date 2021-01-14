/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.PathInits;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QDeductRecord
/*    */   extends EntityPathBase<DeductRecord>
/*    */ {
/*    */   private static final long serialVersionUID = 1631129957L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QDeductRecord deductRecord = new QDeductRecord("deductRecord");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Float> amount = createNumber("amount", Float.class);
/*    */   
/* 29 */   public final StringPath code = createString("code");
/*    */   
/* 31 */   public final StringPath comment = createString("comment");
/*    */   
/* 33 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 35 */   public final NumberPath<Float> price = createNumber("price", Float.class);
/*    */   public final QStore store;
/*    */   
/*    */   public QDeductRecord(String variable)
/*    */   {
/* 40 */     this(DeductRecord.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QDeductRecord(Path<? extends DeductRecord> path) {
/* 44 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QDeductRecord(PathMetadata metadata) {
/* 48 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QDeductRecord(PathMetadata metadata, PathInits inits) {
/* 52 */     this(DeductRecord.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QDeductRecord(Class<? extends DeductRecord> type, PathMetadata metadata, PathInits inits) {
/* 56 */     super(type, metadata, inits);
/* 57 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QDeductRecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */