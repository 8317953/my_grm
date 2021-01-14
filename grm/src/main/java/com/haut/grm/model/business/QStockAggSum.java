/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.QCargo;
/*    */ import com.haut.grm.model.base.QAbstractEntity;
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
/*    */ public class QStockAggSum
/*    */   extends EntityPathBase<StockAggSum>
/*    */ {
/*    */   private static final long serialVersionUID = -613582196L;
/* 21 */   private static final PathInits INITS = new PathInits(new String[] { "*", "cargo.compartment.store.depot.*" });
/*    */   
/* 23 */   public static final QStockAggSum stockAggSum = new QStockAggSum("stockAggSum");
/*    */   
/* 25 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 27 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
/*    */   
/*    */   public final QCargo cargo;
/*    */   
/* 31 */   public final StringPath id = createString("id");
/*    */   
/* 33 */   public final NumberPath<Double> impurityAmount = createNumber("impurityAmount", Double.class);
/*    */   
/* 35 */   public final NumberPath<Long> inAmount = createNumber("inAmount", Long.class);
/*    */   
/* 37 */   public final NumberPath<Long> outAmount = createNumber("outAmount", Long.class);
/*    */   
/*    */   public final QStockRepresentation stock;
/*    */   
/* 41 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/* 43 */   public final NumberPath<Double> waterAmount = createNumber("waterAmount", Double.class);
/*    */   
/*    */   public QStockAggSum(String variable) {
/* 46 */     this(StockAggSum.class, PathMetadataFactory.forVariable(variable), INITS);
/*    */   }
/*    */   
/*    */   public QStockAggSum(Path<? extends StockAggSum> path) {
/* 50 */     this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
/*    */   }
/*    */   
/*    */   public QStockAggSum(PathMetadata metadata) {
/* 54 */     this(metadata, PathInits.getFor(metadata, INITS));
/*    */   }
/*    */   
/*    */   public QStockAggSum(PathMetadata metadata, PathInits inits) {
/* 58 */     this(StockAggSum.class, metadata, inits);
/*    */   }
/*    */   
/*    */   public QStockAggSum(Class<? extends StockAggSum> type, PathMetadata metadata, PathInits inits) {
/* 62 */     super(type, metadata, inits);
/* 63 */     this.cargo = (inits.isInitialized("cargo") ? new QCargo(forProperty("cargo"), inits.get("cargo")) : null);
/* 64 */     this.stock = (inits.isInitialized("stock") ? new QStockRepresentation(forProperty("stock")) : null);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockAggSum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */