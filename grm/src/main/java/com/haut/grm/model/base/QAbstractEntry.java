/*    */ package com.haut.grm.model.base;
/*    */ 
/*    */ import com.haut.grm.model.QStore;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QAbstractEntry
/*    */   extends EntityPathBase<AbstractEntry>
/*    */ {
/*    */   private static final long serialVersionUID = 1300126477L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QAbstractEntry abstractEntry = new QAbstractEntry("abstractEntry");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/*    */   public final QStore store;
/*    */   
/* 31 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QAbstractEntry(String variable) {
/* 34 */     this(AbstractEntry.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QAbstractEntry(Path<? extends AbstractEntry> path) {
/* 38 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QAbstractEntry(PathMetadata metadata) {
/* 42 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QAbstractEntry(PathMetadata metadata, PathInits inits) {
/* 46 */     this(AbstractEntry.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QAbstractEntry(Class<? extends AbstractEntry> type, PathMetadata metadata, PathInits inits) {
/* 50 */     super(type, metadata, inits);
/* 51 */     this.store = (inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\base\QAbstractEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */