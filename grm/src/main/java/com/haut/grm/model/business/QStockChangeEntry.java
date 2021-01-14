/*    */ package com.haut.grm.model.business;
/*    */ 
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.BeanPath;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QStockChangeEntry
/*    */   extends BeanPath<StockChangeEntry>
/*    */ {
/*    */   private static final long serialVersionUID = 164580064L;
/* 20 */   public static final QStockChangeEntry stockChangeEntry = new QStockChangeEntry("stockChangeEntry");
/*    */   
/* 22 */   public final NumberPath<Long> amount = createNumber("amount", Long.class);
/*    */   
/* 24 */   public final NumberPath<Double> impurity = createNumber("impurity", Double.class);
/*    */   
/* 26 */   public final StringPath location = createString("location");
/*    */   
/* 28 */   public final NumberPath<Long> pack = createNumber("pack", Long.class);
/*    */   
/* 30 */   public final StringPath plate = createString("plate");
/*    */   
/* 32 */   public final NumberPath<Double> water = createNumber("water", Double.class);
/*    */   
/* 34 */   public final StringPath year = createString("year");
/*    */   
/*    */   public QStockChangeEntry(String variable) {
/* 37 */     super(StockChangeEntry.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QStockChangeEntry(Path<? extends StockChangeEntry> path) {
/* 41 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QStockChangeEntry(PathMetadata metadata) {
/* 45 */     super(StockChangeEntry.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\business\QStockChangeEntry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */