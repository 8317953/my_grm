/*    */ package com.haut.grm.qt.model;
/*    */ 
/*    */ import com.querydsl.core.types.Path;
/*    */ import com.querydsl.core.types.PathMetadata;
/*    */ import com.querydsl.core.types.PathMetadataFactory;
/*    */ import com.querydsl.core.types.dsl.DateTimePath;
/*    */ import com.querydsl.core.types.dsl.EntityPathBase;
/*    */ import com.querydsl.core.types.dsl.StringPath;
/*    */ import java.util.Date;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class QRwrecord
/*    */   extends EntityPathBase<Rwrecord>
/*    */ {
/*    */   private static final long serialVersionUID = -1875199567L;
/* 20 */   public static final QRwrecord rwrecord = new QRwrecord("rwrecord");
/*    */   
/* 22 */   public final StringPath codeId = createString("codeId");
/*    */   
/* 24 */   public final StringPath ms = createString("ms");
/*    */   
/* 26 */   public final StringPath state = createString("state");
/*    */   
/* 28 */   public final DateTimePath<Date> time = createDateTime("time", Date.class);
/*    */   
/* 30 */   public final StringPath type = createString("type");
/*    */   
/*    */   public QRwrecord(String variable) {
/* 33 */     super(Rwrecord.class, PathMetadataFactory.forVariable(variable));
/*    */   }
/*    */   
/*    */   public QRwrecord(Path<? extends Rwrecord> path) {
/* 37 */     super(path.getType(), path.getMetadata());
/*    */   }
/*    */   
/*    */   public QRwrecord(PathMetadata metadata) {
/* 41 */     super(Rwrecord.class, metadata);
/*    */   }
/*    */ }


/* Location:              C:\Users\10231\Desktop\shundedapingtai\grm\WEB-INF\classes\!\com\haut\grm\qt\model\QRwrecord.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */