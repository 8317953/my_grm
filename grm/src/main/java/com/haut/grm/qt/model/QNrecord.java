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
/*    */ public class QNrecord
/*    */   extends EntityPathBase<Nrecord>
/*    */ {
/*    */   private static final long serialVersionUID = -717663228L;
/* 20 */   public static final QNrecord nrecord = new QNrecord("nrecord");
/*    */   
/* 22 */   public final StringPath codeId = createString("codeId");
/*    */   
/* 24 */   public final NumberPath<Float> fynd = createNumber("fynd", Float.class);
/*    */   
/* 26 */   public final StringPath id = createString("id");
/*    */   
/* 28 */   public final NumberPath<Float> nd = createNumber("nd", Float.class);
/*    */   
/* 30 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/*    */   public QNrecord(String variable) {
/* 33 */     super(Nrecord.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QNrecord(Path<? extends Nrecord> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QNrecord(PathMetadata metadata) {
/* 41 */     super(Nrecord.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\QNrecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */