/*    */ package com.haut.grm.model.meta;
/*    */ 
/*    */ import com.haut.grm.model.base.QAbstractEntity;
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DatePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QMonthTable
/*    */   extends EntityPathBase<MonthTable>
/*    */ {
/*    */   private static final long serialVersionUID = -615669507L;
/* 20 */   public static final QMonthTable monthTable = new QMonthTable("monthTable");
/*    */   
/* 22 */   public final QAbstractEntity _super = new QAbstractEntity(this);
/*    */   
/* 24 */   public final DatePath<Date> date = createDate("date", Date.class);
/*    */   
/* 26 */   public final StringPath dateName = createString("dateName");
/*    */   
/* 28 */   public final NumberPath<Long> id = createNumber("id", Long.class);
/*    */   
/* 30 */   public final DatePath<Date> lastDate = createDate("lastDate", Date.class);
/*    */   
/* 32 */   public final StringPath month = createString("month");
/*    */   
/* 34 */   public final StringPath monthName = createString("monthName");
/*    */   
/* 36 */   public final StringPath year = createString("year");
/*    */   
/*    */   public QMonthTable(String variable) {
/* 39 */     super(MonthTable.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QMonthTable(Path<? extends MonthTable> path) {
/* 43 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QMonthTable(PathMetadata metadata) {
/* 47 */     super(MonthTable.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\model\meta\QMonthTable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */