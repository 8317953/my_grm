/*    */ package com.haut.grm.qt.model;
/*    */ 
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.NumberPath;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QCdrecord
/*    */   extends EntityPathBase<Cdrecord>
/*    */ {
/*    */   private static final long serialVersionUID = -1930251571L;
/* 20 */   public static final QCdrecord cdrecord = new QCdrecord("cdrecord");
/*    */   
/* 22 */   public final StringPath codeId = createString("codeId");
/*    */   
/* 24 */   public final DateTimePath<Date> endTime = createDateTime("endTime", Date.class);
/*    */   
/* 26 */   public final NumberPath<Integer> id = createNumber("id", Integer.class);
/*    */   
/* 28 */   public final NumberPath<Float> jsnd = createNumber("jsnd", Float.class);
/*    */   
/* 30 */   public final NumberPath<Integer> plc = createNumber("plc", Integer.class);
/*    */   
/* 32 */   public final NumberPath<Long> sdcdl = createNumber("sdcdl", Long.class);
/*    */   
/* 34 */   public final NumberPath<Float> sdnd = createNumber("sdnd", Float.class);
/*    */   
/* 36 */   public final StringPath sfyc = createString("sfyc");
/*    */   
/* 38 */   public final NumberPath<Long> sjcdl = createNumber("sjcdl", Long.class);
/*    */   
/* 40 */   public final DateTimePath<Date> startTime = createDateTime("startTime", Date.class);
/*    */   
/* 42 */   public final StringPath type = createString("type");
/*    */   
/*    */   public QCdrecord(String variable) {
/* 45 */     super(Cdrecord.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QCdrecord(Path<? extends Cdrecord> path) {
/* 49 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QCdrecord(PathMetadata metadata) {
/* 53 */     super(Cdrecord.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\QCdrecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */