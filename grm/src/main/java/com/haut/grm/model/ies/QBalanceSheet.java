/*    */ package com.haut.grm.model.ies;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
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
/*    */ 
/*    */ public class QBalanceSheet
/*    */   extends EntityPathBase<BalanceSheet>
/*    */ {
/*    */   private static final long serialVersionUID = 503931476L;
/* 21 */   private static final PathInits INITS = PathInits.DIRECT2;
/*    */   
/* 23 */   public static final QBalanceSheet balanceSheet = new QBalanceSheet("balanceSheet");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final StringPath comment = createString("comment");
/*    */   
/* 29 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 31 */   public final BooleanPath isFinished = createBoolean("isFinished");
/*    */   
/*    */   public final QUser manager;
/*    */   
/* 35 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QBalanceSheet(String variable) {
/* 38 */     this(BalanceSheet.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QBalanceSheet(Path<? extends BalanceSheet> path) {
/* 42 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QBalanceSheet(PathMetadata metadata) {
/* 46 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QBalanceSheet(PathMetadata metadata, PathInits inits) {
/* 50 */     this(BalanceSheet.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QBalanceSheet(Class<? extends BalanceSheet> type, PathMetadata metadata, PathInits inits) {
/* 54 */     super(type, metadata, inits);
/* 55 */     this.manager = (inits.isInitialized("manager") ? new QUser(forProperty("manager"), inits.get("manager")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\ies\QBalanceSheet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */