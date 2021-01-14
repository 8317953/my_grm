/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BooleanPath;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QStockRepresentation
/*    */   extends EntityPathBase<StockRepresentation>
/*    */ {
/*    */   private static final long serialVersionUID = -139718705L;
/* 20 */   public static final QStockRepresentation stockRepresentation = new QStockRepresentation("stockRepresentation");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final StringPath businessKey = createString("businessKey");
/*    */   
/* 26 */   public final StringPath cargoName = createString("cargoName");
/*    */   
/* 28 */   public final StringPath code = createString("code");
/*    */   
/* 30 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 32 */   public final DateTimePath<Date> inputTime = createDateTime("inputTime", Date.class);
/*    */   
/* 34 */   public final BooleanPath isCurrent = createBoolean("isCurrent");
/*    */   
/*    */   public QStockRepresentation(String variable) {
/* 37 */     super(StockRepresentation.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QStockRepresentation(Path<? extends StockRepresentation> path) {
/* 41 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QStockRepresentation(PathMetadata metadata) {
/* 45 */     super(StockRepresentation.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockRepresentation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */